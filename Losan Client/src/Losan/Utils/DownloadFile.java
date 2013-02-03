package Losan.Utils;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import Losan.Gui.GuiDownloadTexturePack;

import net.minecraft.client.Minecraft;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSelectWorld;
import net.minecraft.src.GuiTexturePacks;
import net.minecraft.src.ITexturePack;

public class DownloadFile implements Runnable
{
	private String host;
	private String path;
	private String fileName;
	public GuiDownloadTexturePack gui;
	private boolean _download;
	@Override
	public void run() {
		InputStream input = null;
		FileOutputStream writeFile = null;
		final FTPClient ftp = new FTPClient();
		try
		{
			//            URL url = new URL(this.host);
			//            URLConnection connection = url.openConnection();
			//            int fileLength = connection.getContentLength();
			ftp.connect(this.host);
			ftp.login("anonymous", "");
			final long fileLength = ftp.fileSize(this.fileName);

			if (fileLength == -1)
			{
				System.out.println("Invalide URL or file.");
				ftp.disconnect(false);
				return;
			}
			this.gui.downloadSize = (double)fileLength;

			final File file = new File(path+fileName);
			Thread thread = new Thread() {
				public void run() {				
					while (file.length()>1){}
					long length = 0;
					while (length != fileLength) {
						length = file.length();
						gui.Time = System.currentTimeMillis();
						gui.downloadProgress = (double)length;
						gui.dwnProgress = length;
//						System.out.println(length+" / "+fileLength);
					}
				}

			};
			thread.start();
			ftp.download(fileName, file);
			ftp.disconnect(false);

			//            input = connection.getInputStream();
			//           
			//            this.gui.downloadSize = (double)fileLength; 
			//            
			//            this.fileName = url.getFile().substring(url.getFile().lastIndexOf('/') + 1);
			//            
			//            writeFile = new FileOutputStream(this.path+this.fileName);
			//            byte[] buffer = new byte[1024];
			//            int read;
			//
			//            while ((read = input.read(buffer)) > 0){
			//                writeFile.write(buffer, 0, read);
			//                this.gui.Time = System.currentTimeMillis();
			//                this.gui.downloadProgress = this.gui.downloadProgress + (double)read;
			//                this.gui.dwnProgress = this.gui.dwnProgress + read;
			//            }
			//            writeFile.flush();
		}
		catch (IOException e)
		{
			System.out.println("Error while trying to download the file.");
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FTPIllegalReplyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FTPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FTPDataTransferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FTPAbortedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			//            try
			//            {
			//            	
			////                writeFile.close(); 
			////                input.close();
			//            }
			//            catch (IOException e)
			//            {
			//                e.printStackTrace();
			//            }   
			this.gui.endDownload = true;
			Minecraft.getMinecraft().texturePackList.updateAvaliableTexturePacks();

			int size = Minecraft.getMinecraft().texturePackList.availableTexturePacks().size();

			for(int T = 0;T <size; T++){
				ITexturePack IT = (ITexturePack) (Minecraft.getMinecraft().texturePackList.availableTexturePacks().get(T));
				if(IT.getTexturePackFileName().equals("LosanPack.zip")){
					this.gui.IT = IT;
					break;
				}
			}

			this.gui.start = true;     
			this.gui.loadTexture = 0;
		}
	}

	public DownloadFile(String host, String path, String fileName, GuiDownloadTexturePack gui) {
		this.host = host;
		this.path = path;
		this.fileName = fileName;
		this.gui = gui;
	}
}

package Losan.Gui;

import java.awt.Desktop;
import java.awt.Menu;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraft.client.Minecraft;
import net.minecraft.src.DemoWorldServer;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiButtonLanguage;
import net.minecraft.src.GuiConnecting;
import net.minecraft.src.GuiLanguage;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiOptions;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSelectWorld;
import net.minecraft.src.GuiTextField;
import net.minecraft.src.GuiTexturePacks;
import net.minecraft.src.GuiYesNo;
import net.minecraft.src.ISaveFormat;
import net.minecraft.src.ITexturePack;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.StringTranslate;
import net.minecraft.src.Tessellator;
import net.minecraft.src.WorldInfo;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.util.glu.GLU;

import Losan.Utils.DownloadFile;

public class GuiDownloadTexturePack extends GuiScreen
{
	private int taille; //ajout
	private boolean download = true;
	private int anim = -2130706433;
	
    /** The RNG used by the Main Menu Screen. */
    private static final Random rand = new Random();

    /** Counts the number of screen updates. */
    private float updateCounter = 0.0F;

    /** The splash message. */
    private String splashText = "missingno";
    private GuiButton field_73973_d;
    
    private int strpos; //ajout
    private String[] announces; //ajout
    private int announceCount; //ajout
    public double downloadProgress = -1;
    public double downloadSize = 0;
    private GuiButton oui;
    private GuiButton non;
    public boolean endDownload = false;
    public boolean start = false;
    public ITexturePack IT = null;
    private long StartTime;
    public long Time;
    public long dwnProgress = 0;
    public int loadTexture = 0;

    public GuiDownloadTexturePack(int str, String[] announces, int count, String splash)
    {
        this.strpos = str;
        this.announces = announces;
        this.announceCount = count;
        this.splashText = splash;
        this.updateCounter = rand.nextFloat();
    }

	/**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        if (this.strpos < 0 - this.mc.fontRenderer.getStringWidth(this.announces[this.announceCount]))
        {
            this.strpos = this.width +10;

            if (this.announceCount >= this.announces.length - 1)
            {
                this.announceCount = -1;
            }
            ++this.announceCount;           
        }       
        this.strpos -= 2;
        ++this.loadTexture;
        if(this.loadTexture >= 100)
        	this.loadTexture = 100;
    }

    /**
     * Returns true if this GUI should pause the game when it is displayed in single-player
     */
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    /**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
    protected void keyTyped(char par1, int par2) {}

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
    	this.controlList.clear();
        int var4 = this.height / 4 + 48;
    	this.taille = var4;
//    	this.oui = new GuiButton(0, this.width / 2 -10, this.taille + 12 + 16-18, 98, 20, "Oui");
//     	this.controlList.add(this.oui);
//     	this.non = new GuiButton(1, this.width / 2 + 92, this.taille + 12 + 16-18, 98, 20, "Non");
//    	this.controlList.add(this.non);
    }

    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.id == 0)
        {
        	if(this.download){
        		this.downloadProgress = 0;
        		this.StartTime = System.currentTimeMillis();
        		try{
        			DownloadFile myRunnable = new DownloadFile("dermen-design.fr", new File(Minecraft.getMinecraftDir(), "texturepacks").getAbsolutePath()+"/", "LosanPack.zip", this);
        	        Thread t = new Thread(myRunnable);
        	        t.start();
        		}catch(Exception ex){}
        		this.download = false;        	}        
        }
        if (par1GuiButton.id == 1)
        {
        	 this.mc.displayGuiScreen(new GuiConnecting(mc, "88.190.210.60", 25565));
        }
    }

    public void confirmClicked(boolean par1, int par2)
    {
        if (par1 && par2 == 12)
        {
            ISaveFormat var3 = this.mc.getSaveLoader();
            var3.flushCache();
            var3.deleteWorldDirectory("Demo_World");
            this.mc.displayGuiScreen(this);
        }
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
    	this.fontRenderer.setUnicodeFlag(true);
      Tessellator var4 = Tessellator.instance;
      short var5 = 274;
      int var6 = this.width / 2 - var5 / 2;
      byte var7 = 30;
      
      //light edition
      
// 	 GL11.glPushMatrix();
//    GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.mc.renderEngine.getTexture("/title/parchemin.png"));
//	GL11.glScalef((float)(1280/this.width)+0.5F, (float)(768/this.height)+0.2F, 1.0F);
//    this.drawTexturedModalRect(0, 0, 0, 0, 640, 384);
//    GL11.glPopMatrix();
//    System.out.println(this.width+"   "+this.height);
  this.drawGradientRect(0, 0, this.width, this.height, this.anim, 16777215);
  this.drawGradientRect(0, 10, this.width, this.height-45, 0xfd8d8d8, Integer.MIN_VALUE);
  this.drawRect(0, 0, this.width, this.height, 0xff);
      
      drawHorizontalLine(0, this.width, this.height-47, 0xff000000);
      drawHorizontalLine(0, this.width, this.height-46, 0xff737373);
      
      this.drawRect(0, this.height-45, this.width, this.height, 0xff333333);

      drawHorizontalLine(0, this.width, this.height-47, 0xff000000);
      drawHorizontalLine(0, this.width, this.height-46, 0xff737373);
      
      this.drawRect(0, this.height-45, this.width, this.height, 0xff333333);
      GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.mc.renderEngine.getTexture("/title/mclogo.png"));
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

      if ((double)this.updateCounter < 1.0E-4D)
      {
          this.drawTexturedModalRect(var6 + 0, var7 + 0, 0, 0, 99, 44);
          this.drawTexturedModalRect(var6 + 99, var7 + 0, 129, 0, 27, 44);
          this.drawTexturedModalRect(var6 + 99 + 26, var7 + 0, 126, 0, 3, 44);
          this.drawTexturedModalRect(var6 + 99 + 26 + 3, var7 + 0, 99, 0, 26, 44);
          this.drawTexturedModalRect(var6 + 155, var7 + 0, 0, 45, 155, 44);
      }
      else
      {
    	  GL11.glPushMatrix();
    	  GL11.glScalef(0.4F, 0.4F, 0.4F);
    	  this.drawTexturedModalRect((int)((this.width-122)/0.4F), (int)((this.height-35)/0.4F), 0, 0, 155, 44);
    	  this.drawTexturedModalRect((int)((this.width-60)/0.4F) , (int)((this.height-35)/0.4F), 0, 45, 155, 44);
    	  GL11.glPopMatrix();

    	  GL11.glPushMatrix();
    	  GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.mc.renderEngine.getTexture("/title/blason.png"));
    	  GL11.glScalef(0.6F, 0.6F, 0.6F);
    	  if(this.width <= 427)
    		  this.drawTexturedModalRect((int)(((this.width/100)*6)/0.6F), (int)(((this.height/100)*15)/0.6F), 0, 0, 256, 256);
    	  else
    		  this.drawTexturedModalRect((int)(((this.width/100)*10)/0.6F), (int)(((this.height/100)*15)/0.6F), 0, 0, 256, 256);
    	  GL11.glPopMatrix();
      }

      var4.setColorOpaque_I(16777215);
      GL11.glPushMatrix();
      if(this.width <= 427)
    	  GL11.glTranslatef((float)((this.width/100)*24.5F), (float)(this.height-85), 0.0F);
      else
    	  GL11.glTranslatef((float)((this.width/100)*22), (float)(this.height-100), 0.0F);

      GL11.glRotatef(-0.0F, 0.0F, 0.0F, 1.0F);
      float var8 = 1.8F - MathHelper.abs(MathHelper.sin((float)(Minecraft.getSystemTime() % 1000L) / 1000.0F * (float)Math.PI * 2.0F) * 0.1F);
      var8 = var8 * 100.0F / (float)(this.fontRenderer.getStringWidth(this.splashText)+32);
      GL11.glScalef(var8, var8, var8);
      this.drawCenteredString(this.fontRenderer, this.splashText, 0, 0, 16776960);
      GL11.glPopMatrix();

      this.drawString(this.fontRenderer, "Moddé par:", 10, this.height - 32, 0x716dd6); //ajout
      this.drawString(this.fontRenderer, "\2474Dermenslof \2476&& \2474yoyo1902", 10, this.height - 22, 0x8a0f0f); //ajout
      this.drawString(this.fontRenderer, "\2476Losan.fr \24741.4.5", this.width - this.fontRenderer.getStringWidth("\2476Losan.fr \24741.4.5") - 40, this.height - 15, 0x716dd6); //ajout

      drawRect(0, 0, this.width, this.fontRenderer.FONT_HEIGHT + 4, Integer.MIN_VALUE); //ajout
      drawRect(0, 0, this.width, this.fontRenderer.FONT_HEIGHT + 4, Integer.MIN_VALUE); //ajout

      this.drawString(this.fontRenderer, this.announces[this.announceCount], this.strpos, 2, 16777215); //ajout


      int x = this.width / 2  +1;
      double dp = (this.downloadProgress*100)/this.downloadSize;

      if(this.downloadProgress == -1){
    	  this.controlList.clear();
    	  if(this.width <= 427){
    		  drawRect(this.width / 2 - 10, this.taille-78, this.width / 2 + 190, this.taille + 108-60-18, 0xaf000000);
    		  drawGradientRect( this.width / 2 - 10, this.taille+1-60-18, this.width / 2 + 190, this.taille +15-18-60, 0xff5a0000, 0xff4a0000);
    		  drawGradientRect( this.width / 2 - 10, this.taille+15-60-18, this.width / 2 + 190, this.taille +28-18-60, 0xff4a0000, 0xff080000);
    		  drawVerticalLine(this.width / 2 - 11, this.taille-60-18, this.taille+108-60-18, 0xfd4d4d4d);
    		  drawVerticalLine(this.width / 2 + 190, this.taille-60-18, this.taille+108-60-18, 0xfd2d2d2d);
    		  drawHorizontalLine(this.width / 2 - 10, this.width / 2 + 189, this.taille+108-60-18, 0xfd2d2d2d);
    		  drawHorizontalLine(this.width / 2 - 10, this.width / 2 + 189, this.taille-60-18, 0xfd4d4d4d);
    		  drawHorizontalLine(this.width / 2 - 10, this.width / 2 + 189, this.taille+28-60-18, 0xfd2d2d2d);

    		  drawVerticalLine(this.width / 2 + 189, this.taille+28-60-18, this.taille+30-60-18, 0xfd2d2d2d);
    		  drawVerticalLine(this.width / 2 - 10, this.taille+28-60-18, this.taille+30-60-18, 0xfd2d2d2d);

    		  drawVerticalLine(this.width / 2 + 189, this.taille+106-60-18, this.taille+108-60-18, 0xfd2d2d2d);
    		  drawVerticalLine(this.width / 2 - 10, this.taille+106-60-18, this.taille+108-60-18, 0xfd2d2d2d);;

    		  drawVerticalLine(this.width / 2 + 189, this.taille+0-60-18, this.taille+4-60-18, 0xfdafafaf);
    		  drawHorizontalLine(this.width / 2 + 187, this.width / 2 + 189, this.taille+1-60-18, 0xfdafafaf);

    		  drawVerticalLine(this.width / 2 - 10, this.taille+0-60-18, this.taille+4-60-18, 0xfdafafaf);
    		  drawHorizontalLine(this.width / 2 - 10, this.width / 2 -8, this.taille+1-60-18, 0xfdafafaf);

    		  drawVerticalLine(this.width / 2 + 189, this.taille+28-60-18, this.taille+24-60-18, 0xfdafafaf);
    		  drawHorizontalLine(this.width / 2 + 187, this.width / 2 + 189, this.taille+27-60-18, 0xfdafafaf);

    		  drawVerticalLine(this.width / 2 - 10, this.taille+28-60-18, this.taille+24-60-18, 0xfdafafaf);
    		  drawHorizontalLine(this.width / 2 - 10, this.width / 2 -8, this.taille+27-60-18, 0xfdafafaf);


    		  drawVerticalLine(this.width / 2 + 189, this.taille+0-60-18, this.taille+2-60-18, 0xfdcacaca);
    		  drawVerticalLine(this.width / 2 - 10, this.taille+0-60-18, this.taille+2-60-18, 0xfdcacaca);

    		  drawVerticalLine(this.width / 2 + 189, this.taille+26-60-18, this.taille+28-60-18, 0xfdcacaca);
    		  drawVerticalLine(this.width / 2 - 10, this.taille+26-60-18, this.taille+28-60-18, 0xfdcacaca);

    		  drawCenteredString(this.fontRenderer, "\2476Un nouveau pack de texture est disponible.", this.width / 2 + 90, this.taille+10-60-18, 0xd8d8d8);
    		  drawCenteredString(this.fontRenderer, "Voulez-vous le télécharger et l'installer", this.width / 2 + 90, this.taille+50-60-18, 0xd8d8d8);
    		  drawCenteredString(this.fontRenderer, "avant de jouer?", this.width / 2 + 90, this.taille+60-60-18, 0xd8d8d8);
    
    	    	this.oui = new GuiButton(0, this.width / 2 -10, this.taille + 12 + 16-18, 98, 20, "Oui");
    	     	this.controlList.add(this.oui);
    	     	this.non = new GuiButton(1, this.width / 2 + 92, this.taille + 12 + 16-18, 98, 20, "Non");
    	    	this.controlList.add(this.non);
    	  }else{
    		  drawRect(this.width / 2 - 10+15, this.taille-78-20, this.width / 2 + 190+15, this.taille + 108-60-18-20, 0xaf000000);
    		  drawGradientRect( this.width / 2 - 10+15, this.taille+1-60-18-20, this.width / 2 + 190+15, this.taille +15-18-60-20, 0xff5a0000, 0xff4a0000);
    		  drawGradientRect( this.width / 2 - 10+15, this.taille+15-60-18-20, this.width / 2 + 190+15, this.taille +28-18-60-20, 0xff4a0000, 0xff080000);
    		  drawVerticalLine(this.width / 2 - 11+15, this.taille-60-18-20, this.taille+108-60-18-20, 0xfd4d4d4d);
    		  drawVerticalLine(this.width / 2 + 190+15, this.taille-60-18-20, this.taille+108-60-18-20, 0xfd2d2d2d);
    		  drawHorizontalLine(this.width / 2 - 10+15, this.width / 2 + 189+15, this.taille+108-60-18-20, 0xfd2d2d2d);
    		  drawHorizontalLine(this.width / 2 - 10+15, this.width / 2 + 189+15, this.taille-60-18-20, 0xfd4d4d4d);
    		  drawHorizontalLine(this.width / 2 - 10+15, this.width / 2 + 189+15, this.taille+28-60-18-20, 0xfd2d2d2d);

    		  drawVerticalLine(this.width / 2 + 189+15, this.taille+28-60-18-20, this.taille+30-60-18-20, 0xfd2d2d2d);
    		  drawVerticalLine(this.width / 2 - 10+15, this.taille+28-60-18-20, this.taille+30-60-18-20, 0xfd2d2d2d);

    		  drawVerticalLine(this.width / 2 + 189+15, this.taille+106-60-18-20, this.taille+108-60-18-20, 0xfd2d2d2d);
    		  drawVerticalLine(this.width / 2 - 10+15, this.taille+106-60-18-20, this.taille+108-60-18-20, 0xfd2d2d2d);;

    		  drawVerticalLine(this.width / 2 + 189+15, this.taille+0-60-18-20, this.taille+4-60-18-20, 0xfdafafaf);
    		  drawHorizontalLine(this.width / 2 + 187+15, this.width / 2 + 189+15, this.taille+1-60-18-20, 0xfdafafaf);

    		  drawVerticalLine(this.width / 2 - 10+15, this.taille+0-60-18-20, this.taille+4-60-18-20, 0xfdafafaf);
    		  drawHorizontalLine(this.width / 2 - 10+15, this.width / 2 -8+15, this.taille+1-60-18-20, 0xfdafafaf);

    		  drawVerticalLine(this.width / 2 + 189+15, this.taille+28-60-18-20, this.taille+24-60-18-20, 0xfdafafaf);
    		  drawHorizontalLine(this.width / 2 + 187+15, this.width / 2 + 189+15, this.taille+27-60-18-20, 0xfdafafaf);

    		  drawVerticalLine(this.width / 2 - 10+15, this.taille+28-60-18-20, this.taille+24-60-18-20, 0xfdafafaf);
    		  drawHorizontalLine(this.width / 2 - 10+15, this.width / 2 -8+15, this.taille+27-60-18-20, 0xfdafafaf);


    		  drawVerticalLine(this.width / 2 + 189+15, this.taille+0-60-18-20, this.taille+2-60-18-20, 0xfdcacaca);
    		  drawVerticalLine(this.width / 2 - 10+15, this.taille+0-60-18-20, this.taille+2-60-18-20, 0xfdcacaca);

    		  drawVerticalLine(this.width / 2 + 189+15, this.taille+26-60-18-20, this.taille+28-60-18-20, 0xfdcacaca);
    		  drawVerticalLine(this.width / 2 - 10+15, this.taille+26-60-18-20, this.taille+28-60-18-20, 0xfdcacaca);

    		  drawCenteredString(this.fontRenderer, "\2476Un nouveau pack de texture est disponible.", this.width / 2 + 90+15, this.taille+10-60-18-20, 0xd8d8d8);
    		  drawCenteredString(this.fontRenderer, "Voulez-vous le télécharger et l'installer", this.width / 2 + 90+15, this.taille+50-60-18-20, 0xd8d8d8);
    		  drawCenteredString(this.fontRenderer, "avant de jouer?", this.width / 2 + 90+15, this.taille+60-60-18-20, 0xd8d8d8);
    	    	
    
    	    	this.oui = new GuiButton(0, this.width / 2 -10+15, this.taille + 12 + 16-18-20, 98, 20, "Oui");
    	     	this.controlList.add(this.oui);
    	     	this.non = new GuiButton(1, this.width / 2 + 92+15, this.taille + 12 + 16-18-20, 98, 20, "Non");
    	    	this.controlList.add(this.non);
    	  }
      }else if(!this.endDownload){
    	  this.controlList.clear();
//    	  drawRect(this.width / 2 - 0+15, (this.taille+110/2) , this.width / 2 + 180+25, (this.taille+138/2) + 15, 0xdd232323);

    	  drawRect(this.width-200, this.height-80 , this.width-8, this.height-64 + 15, 0xdd232323);
    	  drawRect(this.width -194, this.height-63 , this.width-14, this.height-53, 0xfd8d8d80);
    	  drawRect(this.width-193, this.height-62, this.width-15, this.height-54, 0xf0000000);
    	  drawRect(this.width-193, this.height-62, this.width-193 + (int) (1.78*dp), this.height-54, 0xf00aa000);
    	  if(dp>=99)
    		  drawCenteredString(this.fontRenderer, "Téléchargement du TexturePack (100%)", this.width-107, this.height-75, 0xffffff);
    	  else if(dp>0)
    		  drawCenteredString(this.fontRenderer, "Téléchargement du TexturePack ("+(int)dp+"% à "+getDownloadSpeed()+")", this.width-107, this.height-75, 0xffffff);
    	  else
    		  drawCenteredString(this.fontRenderer, "Connection au serveur...", this.width-107, this.height-75, 0xffffff);
      }else{
    	  drawRect(this.width-200, this.height-80 , this.width-8, this.height-64 + 15, 0xdd232323);
    	  drawRect(this.width -194, this.height-63 , this.width-14, this.height-53, 0xfd8d8d80);
    	  drawRect(this.width-193, this.height-62, this.width-15, this.height-54, 0xf0000000);
    	  drawRect(this.width-193, this.height-62, this.width-193 + (int) (1.78*this.loadTexture), this.height-54, 0xf00aa000);
    	  drawCenteredString(this.fontRenderer, "Application du TexturePack ...", this.width-107, this.height-75, 0xd8d8d8);
    	  int i=0;
    	  
    	  
    	  
    	  while(i<50){++i;}
    	  if(this.start){    		
    		  if(this.IT != null){
    			  this.mc.texturePackList.setTexturePack(this.IT);
    			  this.mc.renderEngine.refreshTextures();
    		  }
    		  this.mc.displayGuiScreen(new GuiConnecting(mc, "88.190.210.60", 25565));
    		  this.start = false;
    	  }
      }
      super.drawScreen(par1, par2, par3);
    }

	protected void mouseClicked(int i, int j, int k) //ajout
	{
		super.mouseClicked(i, j, k);		
	}
	
	private String getDownloadSpeed(){
		String speed = "0Ko/s";
		long time = (this.Time - this.StartTime)/1000;
		long progression = this.dwnProgress;
		
		if(time <= 0)
			return speed;
		
		double s = (((progression)/1000)/time);
		DecimalFormat S = new DecimalFormat("#.###");
		
		speed = String.valueOf(S.format(s)) + "Ko/s";
		
//		System.out.println(progression);		
		
		return speed;
	}
	
}


package Losan.Gui;

/** Import */
import java.lang.reflect.Field;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiInventory;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSmallButton;
import net.minecraft.src.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiTeleport extends GuiScreen //ajout
{

	/** Variable */
	private Minecraft mc;
	private EntityPlayer player;
	private int xSize;
	private int ySize;

	GuiButton btn_GuiBoutique;//ajout
	GuiButton btn_GuiCraft;//ajout
	GuiButton btn_GuiInv;//ajout 
	GuiButton btn_GuiShop;//ajout


	public GuiTeleport(Minecraft minecraft, EntityPlayer entityplayer)
	{


		this.xSize = 176;    // xSize vaut ici 256
		this.ySize = 166;    // ySize vaut ici 202
		this.mc = minecraft; // mc remplace minecraft.
		this.player = entityplayer;  //player remplace entityplayer

	}

	/**
	 * Adds the buttons (and other controls) to the screen in question.
	 * Ajoute les boutons (et autre controls) à la gui en question.
	 */


	public void initGui()
	{
		controlList.clear();
		int i = (this.width - this.xSize) / 2;
		int j = (this.height - this.ySize) / 2;

		/** Champs */

		controlList.add(new GuiSmallButton(1, i+(this.xSize/2)-30, j + 15, 60, 20,  StatCollector.translateToLocal("Spawn")));    //02 c'est l'id du bouton     
		//            controlList.add(new GuiSmallButton(2, i + 100, j + 25, 60, 20,  StatCollector.translateToLocal("bouton.faq")));
		controlList.add(new GuiSmallButton(3, i + 15, j + 55, 60, 20,  StatCollector.translateToLocal("Ville1")));
		controlList.add(new GuiSmallButton(4, i + 100, j + 55, 60, 20,  StatCollector.translateToLocal("Ville2")));
		controlList.add(new GuiSmallButton(5, i + 15, j + 85, 60, 20,  StatCollector.translateToLocal("Ville3")));
		controlList.add(new GuiSmallButton(6, i + 100, j + 85, 60, 20,  StatCollector.translateToLocal("Ville4")));
		controlList.add(new GuiSmallButton(7, i+(this.xSize/2)-30, j + 125, 60, 20,  "/back"));
		btn_GuiBoutique= new GuiButton(14, i+175, j, 67, 20, StatCollector.translateToLocal("Commerce")); 
		controlList.add(btn_GuiBoutique);
		btn_GuiCraft= new GuiButton(15, i+175, j+20, 67, 20, StatCollector.translateToLocal("Les crafts")); 
		controlList.add(btn_GuiCraft);
		btn_GuiInv= new GuiButton(16, i+175, j+60, 67, 20, StatCollector.translateToLocal("Inventaire"));
		controlList.add(btn_GuiInv);
		btn_GuiShop= new GuiButton(17, i+175, j+40, 67, 20, StatCollector.translateToLocal("Boutique"));
		controlList.add(btn_GuiShop);
		//        	controlList.add(new GuiButton(10, i+175, j+80, 67, 20, "Profils"));

	}





	/**
	 * Draws the screen and all the components in it.
	 */
	public void drawScreen(int i, int j, float f)
	{
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;


		this.BackgroundImage();

		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

		super.drawScreen(i, j, f);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glEnable(GL11.GL_LIGHTING);
	}



	protected void BackgroundImage()
	{
		drawRect(0, 0, this.width, this.height, 0x90101010);
		drawRect(0, 0, this.width, this.height, 0x80101010);

		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		int i = (this.width - this.xSize) / 2;
		int j = (this.height - this.ySize) / 2;
		int k = mc.renderEngine.getTexture("/gui/teleport.png");     //k prend la texture FondGui.png qui se trouve dans .minecraft.jar/gui/FondGui.png.
		mc.renderEngine.bindTexture(k);
		drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

	}

	/**
	 * Called when the mouse is clicked.
	 * Appelé lorsque l'utilisateur clique.
	 */
	protected void mouseClicked(int i, int j, int k)
	{
		super.mouseClicked(i, j, k);

	}

	/**
	 * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
	 * Déclenché lorsque une touche est tapé. C'est l'équivalent de KeyListener.keyTyped (KeyEvent e).
	 */
	protected void keyTyped(char c, int i)
	{
		//            if (c == 1 || i == this.mc.gameSettings.keyBindProfils.keyCode)
		//            {
		//                this.mc.displayGuiScreen(new GuiProfils(this.mc.thePlayer, this.mc));
		//            }
		super.keyTyped(c, i);

	}

	/**
	 * Called from the main game loop to update the screen.
	 * Appelé à partir de la boucle de jeu principale ce qui permet de mettre à jour l'écran.
	 */
	public void updateScreen()
	{
		super.updateScreen();

		if (!this.mc.thePlayer.isEntityAlive() || this.mc.thePlayer.isDead)
		{
			this.mc.thePlayer.closeScreen();
		}
	}


	protected void actionPerformed(GuiButton guibutton)
	{
		if (guibutton.id == 1)
		{
			this.mc.thePlayer.sendChatMessage("/spawn");   
			this.mc.thePlayer.closeScreen();    //Ferme la gui
		}
		if (guibutton.id == 2)
		{
			this.mc.thePlayer.sendChatMessage("/go faq");   
			this.mc.thePlayer.closeScreen();    //Ferme la gui
		}
		if (guibutton.id == 3)
		{
			this.mc.thePlayer.sendChatMessage("/go ville1");   
			this.mc.thePlayer.closeScreen();    //Ferme la gui
		}
		if (guibutton.id == 4)
		{
			this.mc.thePlayer.sendChatMessage("/go ville2");  
			this.mc.thePlayer.closeScreen();    //Ferme la gui
		}
		if (guibutton.id == 5)
		{
			this.mc.thePlayer.sendChatMessage("/go ville3");  
			this.mc.thePlayer.closeScreen();    //Ferme la gui
		}
		if (guibutton.id == 6)
		{
			this.mc.thePlayer.sendChatMessage("/go ville4");   
			this.mc.thePlayer.closeScreen();    //Ferme la gui
		}
		if (guibutton.id == 7)
		{
			this.mc.thePlayer.sendChatMessage("/back");   
			this.mc.thePlayer.closeScreen();    //Ferme la gui
		}

		if (guibutton.id == 14)
		{
			this.mc.thePlayer.potion = false;
			this.mc.displayGuiScreen(new GuiBoutique(this.mc.thePlayer, this.mc));
			if(this.mc.theWorld.isRemote){   
				//                    this.mc.getSendQueue().addToSendQueue(new Packet133Money(this.mc.thePlayer));
			}
		} 
		if (guibutton.id == 15)
		{
			this.mc.thePlayer.potion = true;
			this.mc.displayGuiScreen(new GuiContainerCrafts(this.mc.thePlayer));
		}
		if (guibutton.id == 16)
		{
			this.mc.thePlayer.potion = false;
			this.mc.displayGuiScreen(new GuiInventory(this.mc.thePlayer));
		}
		if (guibutton.id == 17)
		{
			this.mc.thePlayer.potion = true;
			this.mc.displayGuiScreen(new GuiContainerShop(this.mc.thePlayer));
		}
		//            if(guibutton.id == 10)
			//            {
			//            	this.mc.thePlayer.potion = true;
		//            	this.mc.displayGuiScreen(new GuiProfils(this.mc.thePlayer, this.mc));
		//            }

	}

}


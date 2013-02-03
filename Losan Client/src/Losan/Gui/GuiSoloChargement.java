package Losan.Gui;

import net.minecraft.src.GuiDownloadTerrain;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.StringTranslate;
import net.minecraft.src.WorldSettings;

import org.lwjgl.opengl.GL11;

import Losan.Utils.CraftingFinder;

public class GuiSoloChargement extends GuiScreen
{

    public int cooldownTimer;
    public String host;
    public int port;
    public boolean canLogin;
    public boolean isLogging = true;
    private String world1;
    private String world2;
    
    /** Counts the number of screen updates. */
    private int updateCounter = 0;


    
    public GuiSoloChargement(String w1, String w2)
    {
        this.world1 = w1;
        this.world2 = w2;
        CraftingFinder.spawn = 0;
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
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        ++this.updateCounter;
        
        cooldownTimer++;

        
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
    	//        this.drawBackground(0);
    	StringTranslate var4 = StringTranslate.getInstance();
    	//        this.drawCenteredString(this.fontRenderer, var4.translateKey("multiplayer.downloadingTerrain"), this.width / 2, this.height / 2 - 50, 16777215);

//    	this.drawDefaultBackground();

//    	int bg = mc.renderEngine.getTexture("/title/chargement.png");
    	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//    	mc.renderEngine.bindTexture(bg);
    	GL11.glPushMatrix();
//    	this.width = 1280;
//    	this.height = 768;
    	
    	 GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.mc.renderEngine.getTexture("/title/chargement.png"));
    	 if(this.width <=427)
    		 GL11.glScalef((float)1.7F, 1.7F, 1.0F);
    	 else
    		 GL11.glScalef((float)(1280/this.width)+0.5F, (float)(768/this.height)+0.5F, 1.0F);
        this.drawTexturedModalRect(0, 0, 0, 0, 640, 384);

    	GL11.glPopMatrix();
    	//         drawHorizontalLine(0, width, height - 50, 0xff838383);
    	//         drawGradientRect(0, height - 50, width, height-35, 0xaa535353, 0xdd232323);
    	//         drawGradientRect(0, height - 35, width, height, 0xdd232323, 0xee000000);

    	drawHorizontalLine(0, this.width, this.height-47, 0xff000000);
    	drawHorizontalLine(0, this.width, this.height-46, 0xff737373);

    	this.drawRect(0, this.height-45, this.width, this.height, 0xff333333);

    	//         drawRect(0, 0, width, 25, 0x99000000);
    	//fontRenderer.drawString(q + tip, width/2 - (fontRenderer.getStringWidth(q + tip)/2), 9, 0xffffffff);

    	if(CraftingFinder.spawn == 0)
    		drawCenteredString(fontRenderer, var4.translateKey("menu.generatingTerrain"), width / 2, height - 44, 0xffffff);
    	else
    		drawCenteredString(fontRenderer, var4.translateKey("multiplayer.downloadingTerrain"), width / 2, height - 44, 0xffffff);

    	drawRect(this.width/2 - 101, this.height - 31 , this.width / 2 + 101 , this.height - 21, 0xfd8d8d80);
    	drawRect(this.width / 2 - 100, this.height - 30, this.width / 2 + 100, this.height - 22, 0xf0000000);
    	drawRect(this.width / 2 - 100, this.height - 30, width/2 - 100 + CraftingFinder.spawn*2, this.height - 22, 0xf00aa000);
//    	System.out.println(CraftingFinder.spawn);
    	fontRenderer.drawString(CraftingFinder.spawn+" %", width/2 - (fontRenderer.getStringWidth(+CraftingFinder.spawn+" %")/2), height - 31, 0xffffffff);

    	super.drawScreen(par1, par2, par3);
    }
}

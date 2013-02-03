package Losan.Gui;

import java.awt.Desktop;
import java.awt.Menu;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraft.client.Minecraft;
import net.minecraft.src.AchievementList;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class GuiBienvenue extends GuiScreen //ajout
{
	public Minecraft mc;
	GuiButton btn_GuiVisite;//ajout
	GuiButton btn_GuiFormulaire;//ajout

	

	
    /**
     * x size of the inventory window in pixels. Defined as float, passed as int
     */
    private float xSize_lo;

    /**
     * y size of the inventory window in pixels. Defined as float, passed as int.
     */
    private float ySize_lo;

    public GuiBienvenue(Minecraft mc)
    {
    	this.mc = mc;
        this.allowUserInput = true;
        mc.thePlayer.addStat(AchievementList.openInventory, 1);
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        this.controlList.clear();

    	int i = (width) / 2;
    	int j = (height) / 2;
    	btn_GuiVisite= new GuiButton(0, this.width/6, this.height/6*5-20+2, this.width/6*2-1, 20, "Visiter");
    	controlList.add(btn_GuiVisite);
    	btn_GuiFormulaire= new GuiButton(1, this.width/6+this.width/6*2+2, this.height/6*5-20+2, this.width/6*2-1, 20, "M'inscrire");
    	controlList.add(btn_GuiFormulaire);
        
            super.initGui();

    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        super.drawScreen(par1, par2, par3);
        this.xSize_lo = (float)par1;
        this.ySize_lo = (float)par2;
//        drawRect(0, 0, this.width, this.height, 0x80000000);
        drawRect(this.width/6, this.height/6-20, this.width/6*5, this.height/6*5-20, 0xa0000000);
////        drawRect(0, 0, this.width, this.height, Integer.MIN_VALUE);
////        drawRect(0, 0, this.width, this.height, Integer.MIN_VALUE);
        
        drawGradientRect(this.width/6, this.height/6-20, this.width/6*5, this.height/6*5-20, 0xe8e8e8, 0xa0000000);
        drawGradientRect(this.width/6, this.height/6-20, this.width/6*5, this.height/6*5-20, 0xe8e8e8, 0xa0000000);
        drawRect(this.width/4, this.height/4-20, (this.width/4)*3, (this.height/4)*3-20, 0xf0000000);
        drawHorizontalLine(this.width/3+2, this.width/3*2-3, this.height/4+14-20, 0xffbfbfb0);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        drawGuiContainerBackgroundLayer();
        drawCenteredString(this.fontRenderer, "Salut à toi visiteur", this.width/2, this.height/4+2-20, 0xd8d8d8);
        drawCenteredString(this.fontRenderer, "Tu peut visiter librement le serveur", this.width/2, this.height/4+32-25, 0xd8d8d8);
        drawCenteredString(this.fontRenderer, "mais tes actions sont \2474limitées\247f.", this.width/2, this.height/4+32-15, 0xd8d8d8);
        drawCenteredString(this.fontRenderer, "Si tu en veut plus, \2476inscris-toi\247f sur le site", this.width/2, this.height/4+32-5, 0xd8d8d8);
        drawCenteredString(this.fontRenderer, "pour accepter le \2479règlement\247f", this.width/2, this.height/4+32+5, 0xd8d8d8);
        drawCenteredString(this.fontRenderer, "et", this.width/2, this.height/4+32+15, 0xd8d8d8);
        drawCenteredString(this.fontRenderer, "faire ta \247acandidature\247f.", this.width/2, this.height/4+32+25, 0xd8d8d8);
        drawCenteredString(this.fontRenderer, "Le serveur est en \2475béta\247f \247btest\247f et \247bdéveloppement\247f.", this.width/2, this.height/4+32+45, 0xd8d8d8);
        drawCenteredString(this.fontRenderer, "Des changements et bugs sont donc à prévoir.", this.width/2, this.height/4+32+52, 0xd8d8d8);
        
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    private void drawGuiContainerBackgroundLayer(){}

    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.id == 0)
        {
        	this.mc.thePlayer.closeScreen();
        }
        if (par1GuiButton.id == 1)
        {
            Desktop desktop = null;
            java.net.URI url;

            try
            {
                url = new java.net.URI("http://losan.fr/forum/index.php?login/");

                if (Desktop.isDesktopSupported())
                {
                    desktop = Desktop.getDesktop();
                    desktop.browse(url);
                }
            }
            catch (Exception ex)
            {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

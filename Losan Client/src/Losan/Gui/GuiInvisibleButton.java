package Losan.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.src.GuiButton;

import org.lwjgl.opengl.GL11;



public class GuiInvisibleButton extends GuiButton //ajout
{
	/** True if this control is enabled, false to disable. */
	public boolean enabled;
    public GuiInvisibleButton(int par1, int par2, int par3)
    {
        super(par1, par2+15, par3, 30, 10, "");
    }

    /**
     * Draws this button to the screen.
     */
    public void drawButton(Minecraft par1Minecraft, int par2, int par3)
    {
        if (this.drawButton)
        {
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, par1Minecraft.renderEngine.getTexture("/gui/gui.png"));
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            int var5 = 195;

            	this.drawTexturedModalRect(this.xPosition+15, this.yPosition, var5, 30, this.width, this.height);
        }
    }
    
    
    protected int getHoverState(boolean par1)
    {
        byte var2 = 1;

        if (!this.enabled)
        {
            var2 = 0;
        }
        else if (par1)
        {
            var2 = 2;
        }

        return var2;
    }

}
package Losan.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.src.GuiButton;

import org.lwjgl.opengl.GL11;

public class GuiCheckBox extends GuiButton //ajout
{
	public boolean enabled;
    public GuiCheckBox(int par1, int par2, int par3)
    {
        super(par1, par2, par3, 10, 10, "");
    }

    public void drawButton(Minecraft par1Minecraft, int par2, int par3)
    {
        if (this.drawButton)
        {
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, par1Minecraft.renderEngine.getTexture("/gui/gui.png"));
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            int var5 = 195;

            if (this.enabled)
            {
                var5 -= this.height;
                this.drawTexturedModalRect(this.xPosition-2, this.yPosition, var5, 0, this.width, this.height);
            }else
            	this.drawTexturedModalRect(this.xPosition, this.yPosition, var5, 0, this.width, this.height);
        }
    }
    
    public void drawButton1(Minecraft par1Minecraft, int par2, int par3, boolean actif)
    {
    	this.enabled = actif;
        if (this.drawButton)
        {
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, par1Minecraft.renderEngine.getTexture("/gui/gui.png"));
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            int var5 = 195;
            if (actif)
            {
                var5 -= this.height;
                this.drawTexturedModalRect(this.xPosition-2, this.yPosition, var5, 0, this.width, this.height);
            }else
            	this.drawTexturedModalRect(this.xPosition, this.yPosition, var5, 0, this.width, this.height);
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
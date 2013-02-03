package Losan.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.src.GuiButton;

import org.lwjgl.opengl.GL11;

public class GuiButtonTeamSpeak extends GuiButton//ajout
{
    public GuiButtonTeamSpeak(int par1, int par2, int par3)
    {
        super(par1, par2, par3, 20, 20, "");
    }

    /**
     * Draws this teamspeak button to the screen.
     */
    public void drawButton(Minecraft par1Minecraft, int par2, int par3)
    {
        if (this.drawButton)
        {
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, par1Minecraft.renderEngine.getTexture("/gui/guiBoutonTS3.png"));
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            boolean var4 = par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
            int var5 = 0;

            if (var4)
            {
                var5 += this.height;
            }

            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, var5, this.width, this.height);
        }
    }
}
 
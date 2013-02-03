package Losan.Gui;

import net.minecraft.src.GuiContainer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.StatCollector;

import org.lwjgl.opengl.GL11;

import Losan.Container.ContainerFreezer;
import Losan.TileEntity.TileEntityFreezer;

public class GuiFreezer extends GuiContainer
{
    private TileEntityFreezer freezerInventory;

    public GuiFreezer(InventoryPlayer par1InventoryPlayer, TileEntityFreezer par2TileEntityFreezer)
    {
        super(new ContainerFreezer(par1InventoryPlayer, par2TileEntityFreezer));
        this.freezerInventory = par2TileEntityFreezer;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
    	
        this.fontRenderer.drawString("Congélateur", this.xSize/2-("Congélateur".length()+10), 3, 20009705);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 20009705);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        int var4 = this.mc.renderEngine.getTexture("/gui/freezer.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(var4);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
        int var7;

        if (this.freezerInventory.isBurning())
        {
            var7 = this.freezerInventory.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(var5 + 56, var6 + 36 + 12 - var7, 176, 12 - var7, 14, var7 + 2);
        }

        var7 = this.freezerInventory.getCookProgressScaled(24);
        this.drawTexturedModalRect(var5 + 79, var6 + 34, 176, 14, var7 + 1, 16);
    }
}

package Losan.Gui;

import net.minecraft.src.GuiContainer;
import net.minecraft.src.IInventory;
import net.minecraft.src.StatCollector;

import org.lwjgl.opengl.GL11;

import Losan.Container.ContainerPoubelle;

public class GuiPoubelle extends GuiContainer  //ajout
{
    private IInventory upperPoubelleInventory;
    private IInventory lowerPoubelleInventory;

    /**
     * window height is calculated with this values, the more rows, the heigher
     */
    private int inventoryRows = 0;

    public GuiPoubelle(IInventory par1IInventory, IInventory par2IInventory)
    {
        super(new ContainerPoubelle(par1IInventory, par2IInventory));
        this.upperPoubelleInventory = par1IInventory;
        this.lowerPoubelleInventory = par2IInventory;
        this.allowUserInput = false;
        short var3 = 222;
        int var4 = var3 - 108;
        this.inventoryRows = par2IInventory.getSizeInventory() / 9;
        this.ySize = var4 + this.inventoryRows * 18;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer()
    {
    	this.fontRenderer.drawString(StatCollector.translateToLocal("container.poubelle"), 8, 6, 4210752);
        
        this.fontRenderer.drawString(StatCollector.translateToLocal(this.upperPoubelleInventory.getInvName()), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        int var4 = this.mc.renderEngine.getTexture("/gui/container.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(var4);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.inventoryRows * 18 + 17);
        this.drawTexturedModalRect(var5, var6 + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
    }
}

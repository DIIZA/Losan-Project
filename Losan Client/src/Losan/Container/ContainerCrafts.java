package Losan.Container;

import java.util.ArrayList;
import java.util.List;

import Losan.Gui.GuiContainerCrafts;
import Losan.Inventory.InventoryCrafts;
import Losan.Slot.SlotCrafts;
import Losan.Slot.SlotCraftsRef;

import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;

public class ContainerCrafts extends Container //ajout
{
    /** the list of items in this container */
    public List itemList = new ArrayList();
    public InventoryCrafts slotRef;
    public InventoryCrafts slotCrafts;

    public ContainerCrafts(EntityPlayer par1EntityPlayer)
    {
    	int y = 0;
    	par1EntityPlayer.contCrafts = this;
		this.slotRef = new InventoryCrafts("ref", 1);
		this.slotCrafts = new InventoryCrafts("crafts",9);
		this.addSlotToContainer(new SlotCraftsRef(par1EntityPlayer, this.slotRef, 0, 128, 139));
		
		this.addSlotToContainer(new SlotCrafts( this.slotCrafts, 0, 34, 121));
		this.addSlotToContainer(new SlotCrafts( this.slotCrafts, 1, 52, 121));
		this.addSlotToContainer(new SlotCrafts( this.slotCrafts, 2, 70, 121));
		this.addSlotToContainer(new SlotCrafts( this.slotCrafts, 3, 34, 139));
		this.addSlotToContainer(new SlotCrafts( this.slotCrafts, 4, 52, 139));
		this.addSlotToContainer(new SlotCrafts( this.slotCrafts, 5, 70, 139));
		this.addSlotToContainer(new SlotCrafts( this.slotCrafts, 6, 34, 157));
		this.addSlotToContainer(new SlotCrafts( this.slotCrafts, 7, 52, 157));
		this.addSlotToContainer(new SlotCrafts( this.slotCrafts, 8, 70, 157));
    	
        InventoryPlayer var2 = par1EntityPlayer.inventory;
        int var3;

        for (var3 = 0; var3 < 5; ++var3)
        {
            for (int var4 = 0; var4 < 9; ++var4)
            {
                this.addSlotToContainer(new Slot(GuiContainerCrafts.getInventory(), var3 * 9 + var4, 9 + var4 * 18, 18 + var3 * 18-y));
            }
        }



        this.scrollTo(0.0F);
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return true;
    }

    /**
     * Updates the gui slots ItemStack's based on scroll position.
     */
    public void scrollTo(float par1)
    {
        int var2 = this.itemList.size() / 9 - 5 + 1;
        int var3 = (int)((double)(par1*1.28 * (float)var2) + 0.5D);

        if (var3 < 0)
        {
            var3 = 0;
        }

        for (int var4 = 0; var4 < 5; ++var4)
        {
            for (int var5 = 0; var5 < 9; ++var5)
            {
                int var6 = var5 + (var4 + var3) * 9;

                if (var6 >= 0 && var6 < this.itemList.size())
                {
                    GuiContainerCrafts.getInventory().setInventorySlotContents(var5 + var4 * 9, (ItemStack)this.itemList.get(var6));
                }
                else
                {
                	GuiContainerCrafts.getInventory().setInventorySlotContents(var5 + var4 * 9, (ItemStack)null);
                }
            }
        }
    }

    /**
     * theCreativeContainer seems to be hard coded to 9x5 items
     */
    public boolean hasMoreThan1PageOfItemsInList()
    {
        return this.itemList.size() > 45;
    }

    protected void retrySlotClick(int par1, int par2, boolean par3, EntityPlayer par4EntityPlayer) {}

    /**
     * Called to transfer a stack from one inventory to the other eg. when shift clicking.
     */

    public ItemStack func_82846_b(EntityPlayer par1EntityPlayer, int par2)
    {
//        if (par2 >= this.inventorySlots.size() - 9 && par2 < this.inventorySlots.size())
//        {
//            Slot var3 = (Slot)this.inventorySlots.get(par2);
//
//            if (var3 != null && var3.getHasStack())
//            {
//                var3.putStack((ItemStack)null);
//            }
//        }

        return null;
    }
}

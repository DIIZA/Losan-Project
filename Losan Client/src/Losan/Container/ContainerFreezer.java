package Losan.Container;

import java.util.Iterator;

import Losan.Recipe.FreezerRecipes;
import Losan.Slot.SlotFreezer;
import Losan.TileEntity.TileEntityFreezer;

import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ICrafting;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;

public class ContainerFreezer extends Container //ajout
{
    private TileEntityFreezer freezer;
    private int lastCookTime = 0;
    private int lastBurnTime = 0;
    private int lastItemBurnTime = 0;
    private int seau = 0;

    public ContainerFreezer(InventoryPlayer par1InventoryPlayer, TileEntityFreezer par2TileEntityFreezer)
    {
        
        this.addSlotToContainer(new Slot(par2TileEntityFreezer, 0, 56, 17));
        this.addSlotToContainer(new Slot(par2TileEntityFreezer, 1, 56, 53));
        this.addSlotToContainer(new SlotFreezer(par1InventoryPlayer.player, par2TileEntityFreezer, 2, 116, 35));
        this.addSlotToContainer(new SlotFreezer(par1InventoryPlayer.player, par2TileEntityFreezer, 3, 147, 35));
        int var3;

        for (var3 = 0; var3 < 3; ++var3)
        {
            for (int var4 = 0; var4 < 9; ++var4)
            {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for (var3 = 0; var3 < 9; ++var3)
        {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, var3, 8 + var3 * 18, 142));
        }
        this.freezer = par2TileEntityFreezer;
        
    }

    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.freezer.freezerCookTime);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.freezer.freezerBurnTime);
        par1ICrafting.sendProgressBarUpdate(this, 2, this.freezer.freezercurrentItemBurnTime);
        par1ICrafting.sendProgressBarUpdate(this, 3, 0);
        
    }

    /**
     * Updates crafting matrix; called from onCraftMatrixChanged. Args: none
     */
    public void updateCraftingResults()
    {
        super.updateCraftingResults();
        Iterator var1 = this.crafters.iterator();

        while (var1.hasNext())
        {
            ICrafting var2 = (ICrafting)var1.next();

            if (this.lastCookTime != this.freezer.freezerCookTime)
            {
                var2.sendProgressBarUpdate(this, 0, this.freezer.freezerCookTime);
            }

            if (this.lastBurnTime != this.freezer.freezerBurnTime)
            {
                var2.sendProgressBarUpdate(this, 1, this.freezer.freezerBurnTime);
            }

            if (this.lastItemBurnTime != this.freezer.freezercurrentItemBurnTime)
            {
                var2.sendProgressBarUpdate(this, 2, this.freezer.freezercurrentItemBurnTime);
            }
            
            if (this.seau != 0)
            {
                var2.sendProgressBarUpdate(this, 3, 0);
            }
        }

        this.lastCookTime = this.freezer.freezerCookTime;
        this.lastBurnTime = this.freezer.freezerBurnTime;
        this.lastItemBurnTime = this.freezer.freezercurrentItemBurnTime;
        this.seau = 0;
    }

    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.freezer.freezerCookTime = par2;
        }

        if (par1 == 1)
        {
            this.freezer.freezerBurnTime = par2;
        }

        if (par1 == 2)
        {
            this.freezer.freezercurrentItemBurnTime = par2;
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.freezer.isUseableByPlayer(par1EntityPlayer);
    }

    /**
     * Called to transfer a stack from one inventory to the other eg. when shift clicking.
     */
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack var2 = null;
        Slot var3 = (Slot)this.inventorySlots.get(par2);

        if (var3 != null && var3.getHasStack())
        {
            ItemStack var4 = var3.getStack();
            var2 = var4.copy();

            if (par2 == 2)
            {
                if (!this.mergeItemStack(var4, 3, 39, true))
                {
                    return null;
                }

                var3.onSlotChange(var4, var2);
            }
            else if (par2 == 3)
            {
                if (!this.mergeItemStack(var4, 4, 39, true))
                {
                    return null;
                }

                var3.onSlotChange(var4, var2);
            }
            
            else if (par2 != 1 && par2 != 0 && par2 != 3)
            {
                if (FreezerRecipes.smelting().getSmeltingResult(var4.getItem().shiftedIndex) != null)
                {
                    if (!this.mergeItemStack(var4, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityFreezer.isItemFuel(var4))
                {
                    if (!this.mergeItemStack(var4, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 4 && par2 < 30)
                {
                    if (!this.mergeItemStack(var4, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(var4, 4, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(var4, 4, 39, false))
            {
                return null;
            }

            if (var4.stackSize == 0)
            {
                var3.putStack((ItemStack)null);
            }
            else
            {
                var3.onSlotChanged();
            }

            if (var4.stackSize == var2.stackSize)
            {
                return null;
            }

            var3.onPickupFromSlot(par1EntityPlayer, var4);
        }

        return var2;
    }
}

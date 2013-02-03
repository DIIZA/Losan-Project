package Losan.Container;

import java.util.Iterator;

import Losan.Recipe.FutRecipes;
import Losan.Slot.SlotFut;
import Losan.TileEntity.TileEntityFut;

import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ICrafting;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;

public class ContainerFut extends Container //ajout
{
    private TileEntityFut fut;
    private int lastCookTime = 0;
    private int lastBurnTime = 0;
    private int lastItemBurnTime = 0;
    private int seau = 0;

    public ContainerFut(InventoryPlayer par1InventoryPlayer, TileEntityFut par2TileEntityFut)
    {
        
        this.addSlotToContainer(new Slot(par2TileEntityFut, 0, 56, 17));
        this.addSlotToContainer(new Slot(par2TileEntityFut, 1, 56, 53));
        this.addSlotToContainer(new SlotFut(par1InventoryPlayer.player, par2TileEntityFut, 2, 116, 35));
        this.addSlotToContainer(new SlotFut(par1InventoryPlayer.player, par2TileEntityFut, 3, 147, 35));
        this.addSlotToContainer(new Slot(par2TileEntityFut, 4, 21, 36));
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
        this.fut = par2TileEntityFut;
        
    }

    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.fut.futCookTime);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.fut.futBurnTime);
        par1ICrafting.sendProgressBarUpdate(this, 2, this.fut.futcurrentItemBurnTime);
        par1ICrafting.sendProgressBarUpdate(this, 3, 0);
        par1ICrafting.sendProgressBarUpdate(this, 4, 0);
        
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

            if (this.lastCookTime != this.fut.futCookTime)
            {
                var2.sendProgressBarUpdate(this, 0, this.fut.futCookTime);
            }

            if (this.lastBurnTime != this.fut.futBurnTime)
            {
                var2.sendProgressBarUpdate(this, 1, this.fut.futBurnTime);
            }

            if (this.lastItemBurnTime != this.fut.futcurrentItemBurnTime)
            {
                var2.sendProgressBarUpdate(this, 2, this.fut.futcurrentItemBurnTime);
            }
            
            if (this.seau != 0)
            {
                var2.sendProgressBarUpdate(this, 3, 0);
            }
        }

        this.lastCookTime = this.fut.futCookTime;
        this.lastBurnTime = this.fut.futBurnTime;
        this.lastItemBurnTime = this.fut.futcurrentItemBurnTime;
        this.seau = 0;
    }

    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.fut.futCookTime = par2;
        }

        if (par1 == 1)
        {
            this.fut.futBurnTime = par2;
        }

        if (par1 == 2)
        {
            this.fut.futcurrentItemBurnTime = par2;
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.fut.isUseableByPlayer(par1EntityPlayer);
    }

    /**
     * Called to transfer a stack from one inventory to the other eg. when shift clicking.
     */
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par1)
    {
        ItemStack var2 = null;
        Slot var3 = (Slot)this.inventorySlots.get(par1);

        if (var3 != null && var3.getHasStack())
        {
            ItemStack var4 = var3.getStack();
            var2 = var4.copy();

            if (par1 == 2)
            {
                if (!this.mergeItemStack(var4, 3, 39, true))
                {
                    return null;
                }

                var3.onSlotChange(var4, var2);
            }
            else if (par1 == 3)
            {
                if (!this.mergeItemStack(var4, 4, 39, true))
                {
                    return null;
                }

                var3.onSlotChange(var4, var2);
            }
            else if (par1 == 4)
            {
                if (!this.mergeItemStack(var4, 5, 39, true))
                {
                    return null;
                }

                var3.onSlotChange(var4, var2);
            }
            
            else if (par1 != 1 && par1 != 0 && par1 != 3 && par1 != 4)
            {
                if (FutRecipes.smelting().getSmeltingResult(var4.getItem().shiftedIndex) != null)
                {
                    if (!this.mergeItemStack(var4, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityFut.isItemFuel(var4))
                {
                    if (!this.mergeItemStack(var4, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (par1 >= 5 && par1 < 30)
                {
                    if (!this.mergeItemStack(var4, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (par1 >= 30 && par1 < 39 && !this.mergeItemStack(var4, 5, 30, false))
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

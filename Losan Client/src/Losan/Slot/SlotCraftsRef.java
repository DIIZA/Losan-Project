package Losan.Slot;

import Losan.Inventory.InventoryCrafts;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;

public class SlotCraftsRef extends Slot //ajout
{
    private EntityPlayer thePlayer;

    private int amountCrafted;
    
    public SlotCraftsRef(EntityPlayer par1EntityPlayer, InventoryCrafts par2IInventory, int par3, int par4, int par5)
    {
        super(par2IInventory, par3, par4, par5);
        this.thePlayer = par1EntityPlayer;
    }
    
    public boolean isItemValid(ItemStack par1ItemStack)
    {
        return true;
    }

    public void onPickupFromSlot(ItemStack par1ItemStack)
    {

    }

    protected void onCrafting(ItemStack par1ItemStack, int par2)
    {

    }

    protected void onCrafting(ItemStack par1ItemStack)
    {

    }
}

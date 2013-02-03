package Losan.Slot;

import Losan.Inventory.InventoryBoutique;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;

public class SlotBoutique extends Slot
{
    private EntityPlayer thePlayer;

    private int amountCrafted;
    
    public SlotBoutique(EntityPlayer par1EntityPlayer, InventoryBoutique par2IInventory, int par3, int par4, int par5)
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

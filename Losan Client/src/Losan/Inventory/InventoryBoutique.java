package Losan.Inventory;

import java.util.Iterator;
import java.util.List;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;

public class InventoryBoutique implements IInventory //ajout
{
    private String inventoryTitle;
    private int slotsCount;
    private ItemStack[] inventoryContents;

    public InventoryBoutique(String par1Str, int par2)
    {
        this.inventoryTitle = par1Str;
        this.slotsCount = par2;
        this.inventoryContents = new ItemStack[par2];
    }

    public ItemStack getStackInSlot(int par1)
    {
        return this.inventoryContents[par1];
    }

    public ItemStack decrStackSize(int par1, int par2)
    {
    	return null;
    }

    public ItemStack getStackInSlotOnClosing(int par1)
    {
    	this.inventoryContents[par1] = null;
    	return null;
    }

    public int getSizeInventory()
    {
        return this.slotsCount;
    }

    public String getInvName()
    {
        return this.inventoryTitle;
    }

    public int getInventoryStackLimit()
    {
        return 64;
    }

    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return false;
    }

    public void openChest() {}

    public void closeChest() {}
    
    public String getId()
    {
        return this.getItemReference(this.inventoryContents[0]);
    }

    public static String getItemReference(ItemStack par0ItemStack)
    {
        if (par0ItemStack == null)
        {
            return null;
        }
        else
        {
            int var1 = par0ItemStack.getItem().shiftedIndex;
            int sub = 0;
            if(par0ItemStack.getItemDamage() !=0)
            	return String.valueOf(var1)+":"+String.valueOf(par0ItemStack.getItemDamage());
            else
            return String.valueOf(var1);
        }
    }
    
    public void setId(ItemStack x)
    {
    		
    	x = new ItemStack(x.getItem(), 1, x.getItemDamage());
        this.inventoryContents[0] = x.copy();
    }
    
    public void resetId()
    {
    	this.inventoryContents[0] = null;
    }

    @Override
	public void setInventorySlotContents(int var1, ItemStack var2) {}

	@Override
	public void onInventoryChanged() {}
}

package Losan.Inventory;

import java.util.Iterator;
import java.util.List;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;

public class InventoryCrafts implements IInventory //ajout
{
    private String inventoryTitle;
    private int slotsCount;
    private ItemStack[] inventoryContents;

    public InventoryCrafts(String par1Str, int par2)
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
    
    public ItemStack getId()
    {
        return this.getItemReference(this.inventoryContents[0]);
    }

    public static ItemStack getItemReference(ItemStack par0ItemStack)
    {
        if (par0ItemStack == null)
        {
            return null;
        }
        else
        {
            
            	return par0ItemStack;
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
    
    public void setItemStack(ItemStack par1ItemStack)
    {
        this.inventoryContents[0] = par1ItemStack;
    }

    public ItemStack getItemStack()
    {
        return this.inventoryContents[0];
    }

    @Override
	public void setInventorySlotContents(int var1, ItemStack var2) {}

	@Override
	public void onInventoryChanged() {}

    public void setSlot(int x, ItemStack stack)
    {
    	this.inventoryContents[x] = null;
        this.inventoryContents[x] = stack.copy();
    }
    
    public void resetSlot()
    {
    	for (int x = 0; x<this.slotsCount; x++)
    		this.inventoryContents[x] = null;
    }
    
	
}

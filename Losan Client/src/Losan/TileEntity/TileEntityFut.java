package Losan.TileEntity;

import Losan.Block.BlockFut;
import Losan.Recipe.FutRecipes;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.TileEntity;

public class TileEntityFut extends TileEntity implements IInventory //ajout
{
    /**
     * The ItemStacks that hold the items currently being used in the furnace
     */
    private ItemStack[] futItemStacks = new ItemStack[5];
    
    /** The current angle of the lid (between 0 and 1) */
    public float lidAngle;

    /** The angle of the lid last tick */
    public float prevLidAngle;

    /** The number of ticks that the furnace will keep burning */
    public int futBurnTime = 0;

    /**
     * The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
     */
    public int futcurrentItemBurnTime = 0;

    /** The number of ticks that the current item has been cooking for */
    public int futCookTime = 0;

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.futItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int par1)
    {
        return this.futItemStacks[par1];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int par1, int par2)
    {
        if (this.futItemStacks[par1] != null)
        {
            ItemStack var3;
            if (this.futItemStacks[par1].stackSize <= par2)
            {
                var3 = this.futItemStacks[par1];
                this.futItemStacks[par1] = null;
                return var3;
            }
            else
            {
                var3 = this.futItemStacks[par1].splitStack(par2);

                if (this.futItemStacks[par1].stackSize == 0)
                {
                    this.futItemStacks[par1] = null;
                }

                return var3;
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (this.futItemStacks[par1] != null)
        {
            ItemStack var2 = this.futItemStacks[par1];
            this.futItemStacks[par1] = null;
            return var2;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        this.futItemStacks[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    /**
     * Returns the name of the inventory.
     */
    public String getInvName()
    {
        return "container.fut";
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList var2 = par1NBTTagCompound.getTagList("Items");
        this.futItemStacks = new ItemStack[this.getSizeInventory()];
        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.futItemStacks.length)
            {
                this.futItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }
        this.futBurnTime = par1NBTTagCompound.getShort("BurnTime");
        this.futCookTime = par1NBTTagCompound.getShort("CookTime");
        this.futcurrentItemBurnTime = getItemBurnTime(this.futItemStacks[1]);
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("BurnTime", (short)this.futBurnTime);
        par1NBTTagCompound.setShort("CookTime", (short)this.futCookTime);
        NBTTagList var2 = new NBTTagList();
        for (int var3 = 0; var3 < this.futItemStacks.length; ++var3)
        {
            if (this.futItemStacks[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.futItemStacks[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }
        par1NBTTagCompound.setTag("Items", var2);
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
     * this more of a set than a get?*
     */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /**
     * Returns an integer between 0 and the passed value representing how close the current item is to being completely
     * cooked
     */
    public int getCookProgressScaled(int par1)
    {
        return this.futCookTime * par1 / 200;
    }

    /**
     * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
     * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
     */
    public int getBurnTimeRemainingScaled(int par1)
    {
        if (this.futcurrentItemBurnTime == 0)
        {
            this.futcurrentItemBurnTime = 200;
        }
        return this.futBurnTime * par1 / this.futcurrentItemBurnTime;
    }

    /**
     * Returns true if the furnace is currently burning
     */
    public boolean isBurning()
    {
        return this.futBurnTime > 0;
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
        boolean var1 = this.futBurnTime > 0;
        boolean var2 = false;
        if (this.futBurnTime > 0)
        {
            --this.futBurnTime;
        }       
        if (!this.worldObj.isRemote)
        {
            if (this.futBurnTime == 0 && this.canSmelt())
            {
                this.futcurrentItemBurnTime = this.futBurnTime = getItemBurnTime(this.futItemStacks[1]);

                if (this.futBurnTime > 0)
                {
                    var2 = true;

                    if (this.futItemStacks[1] != null)
                    {
                        --this.futItemStacks[1].stackSize;
                        
                        if (this.futItemStacks[1].stackSize == 0)
                        {
                            this.futItemStacks[1] = null;
                        }
                    }
                }
            }
            if (this.isBurning() && this.canSmelt())
            {
                ++this.futCookTime;
                if (this.futCookTime == 200)
                {
                    this.futCookTime = 0;
                    this.smeltItem();
                    var2 = true;
                }
            }
            else
            {
                this.futCookTime = 0;
            }
            if (var1 != this.futBurnTime > 0)
            {
                var2 = true;
                BlockFut.updateFutBlockState(this.futBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }
        if (var2)
        {
            this.onInventoryChanged();
        }
    }

    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt()
    {
        if (this.futItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack var1 = FutRecipes.smelting().getSmeltingResult(this.futItemStacks[0].getItem().shiftedIndex);
            ItemStack var2 = new ItemStack(Item.verreVide);
            if(var1 == null)
            	return false;
            else if(this.futItemStacks[4] == null)
            	return false;
            else if(!this.futItemStacks[4].isItemEqual(var2))
            	return false;
            else if(this.futItemStacks[2] == null)
            	return true;
            else if(!this.futItemStacks[2].isItemEqual(var1))
            	return false;
            else if(this.futItemStacks[2].stackSize < this.getInventoryStackLimit() && this.futItemStacks[2].stackSize < this.futItemStacks[2].getMaxStackSize())
            	return true;
            else if(this.futItemStacks[2].stackSize < this.futItemStacks[2].getMaxStackSize())
            	return true;
            else if(this.futItemStacks[3] == null)
            	return true;
            else if(!this.futItemStacks[3].isItemEqual(var1))
            	return false;
            else if(this.futItemStacks[3].stackSize < this.getInventoryStackLimit() && this.futItemStacks[3].stackSize < this.futItemStacks[3].getMaxStackSize())
            	return true;
            else if(this.futItemStacks[3].stackSize < this.futItemStacks[3].getMaxStackSize())
            	return true;
            else
            	return false;
        }
    }

    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack var1 = FutRecipes.smelting().getSmeltingResult(this.futItemStacks[0].getItem().shiftedIndex);
            ItemStack var2 = new ItemStack(Item.bucketEmpty);
            
            if (this.futItemStacks[2] == null)
            {
                this.futItemStacks[2] = var1.copy();
                
                if (this.futItemStacks[3] == null)
                {
                	this.futItemStacks[3] = var2.copy();
                }
                else if (this.futItemStacks[3].itemID == var2.itemID)
                {
                	++this.futItemStacks[3].stackSize;
                }
            }
            else if (this.futItemStacks[2].itemID == var1.itemID)
            {
            	++this.futItemStacks[2].stackSize;
            	
                if (this.futItemStacks[3] == null)
                {
                	this.futItemStacks[3] = var2.copy();
                }
                else if (this.futItemStacks[3].itemID == var2.itemID)
                {
                	++this.futItemStacks[3].stackSize;
                }
            }
            --this.futItemStacks[0].stackSize;
            if (this.futItemStacks[0].stackSize <= 0)
            {
                this.futItemStacks[0] = null;
            }           
            --this.futItemStacks[4].stackSize;           
            if (this.futItemStacks[4].stackSize <= 0)
            {
                this.futItemStacks[4] = null;
            }
        }
    }

    /**
     * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
     * fuel
     */
    public static int getItemBurnTime(ItemStack par0ItemStack)
    {
        if (par0ItemStack == null)
        {
            return 0;
        }       
            int var1 = par0ItemStack.getItem().shiftedIndex;
            return var1 == Item.bucketWater.shiftedIndex ? 200 : 0;       
    }

    /**
     * Return true if item is a fuel source (getItemBurnTime() > 0).
     */
    public static boolean isItemFuel(ItemStack par0ItemStack)
    {
        return getItemBurnTime(par0ItemStack) > 0;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openChest(){}

    public void closeChest(){}


    
    
    
    
    
    
    
}

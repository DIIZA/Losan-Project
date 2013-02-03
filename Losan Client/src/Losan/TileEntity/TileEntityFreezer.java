package Losan.TileEntity;

import Losan.Block.BlockFreezer;
import Losan.Recipe.FreezerRecipes;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.TileEntity;

public class TileEntityFreezer extends TileEntity implements IInventory //ajout
{
    /**
     * The ItemStacks that hold the items currently being used in the furnace
     */
    private ItemStack[] freezerItemStacks = new ItemStack[4];
    

    
    
    
    
    /** The number of ticks that the furnace will keep burning */
    public int freezerBurnTime = 0;

    /**
     * The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
     */
    public int freezercurrentItemBurnTime = 0;

    /** The number of ticks that the current item has been cooking for */
    public int freezerCookTime = 0;

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.freezerItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int par1)
    {
        return this.freezerItemStacks[par1];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int par1, int par2)
    {
        if (this.freezerItemStacks[par1] != null)
        {
            ItemStack var3;

            if (this.freezerItemStacks[par1].stackSize <= par2)
            {
                var3 = this.freezerItemStacks[par1];
                this.freezerItemStacks[par1] = null;
                return var3;
            }
            else
            {
                var3 = this.freezerItemStacks[par1].splitStack(par2);

                if (this.freezerItemStacks[par1].stackSize == 0)
                {
                    this.freezerItemStacks[par1] = null;
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
        if (this.freezerItemStacks[par1] != null)
        {
            ItemStack var2 = this.freezerItemStacks[par1];
            this.freezerItemStacks[par1] = null;
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
        this.freezerItemStacks[par1] = par2ItemStack;

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
        return "container.freezer";
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList var2 = par1NBTTagCompound.getTagList("Items");
        this.freezerItemStacks = new ItemStack[this.getSizeInventory()];

        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.freezerItemStacks.length)
            {
                this.freezerItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }

        this.freezerBurnTime = par1NBTTagCompound.getShort("BurnTime");
        this.freezerCookTime = par1NBTTagCompound.getShort("CookTime");
        this.freezercurrentItemBurnTime = getItemBurnTime(this.freezerItemStacks[1]);

    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("BurnTime", (short)this.freezerBurnTime);
        par1NBTTagCompound.setShort("CookTime", (short)this.freezerCookTime);
        NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.freezerItemStacks.length; ++var3)
        {
            if (this.freezerItemStacks[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.freezerItemStacks[var3].writeToNBT(var4);
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
        return this.freezerCookTime * par1 / 400;
    }

    /**
     * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
     * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
     */
    public int getBurnTimeRemainingScaled(int par1)
    {
        if (this.freezercurrentItemBurnTime == 0)
        {
            this.freezercurrentItemBurnTime = 400;
        }

        return this.freezerBurnTime * par1 / this.freezercurrentItemBurnTime;
    }

    /**
     * Returns true if the furnace is currently burning
     */
    public boolean isBurning()
    {
        return this.freezerBurnTime > 0;
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
        boolean var1 = this.freezerBurnTime > 0;
        boolean var2 = false;

        if (this.freezerBurnTime > 0)
        {
            --this.freezerBurnTime;
        }
        

        if (!this.worldObj.isRemote)
        {
            if (this.freezerBurnTime == 0 && this.canSmelt())
            {
                this.freezercurrentItemBurnTime = this.freezerBurnTime = getItemBurnTime(this.freezerItemStacks[1]);

                if (this.freezerBurnTime > 0)
                {
                    var2 = true;

                    if (this.freezerItemStacks[1] != null)
                    {
                        --this.freezerItemStacks[1].stackSize;

                        if (this.freezerItemStacks[1].stackSize == 0)
                        {
                            Item var3 = this.freezerItemStacks[1].getItem().getContainerItem();
                            this.freezerItemStacks[1] = var3 != null ? new ItemStack(var3) : null;
                        }
                    }
                }
            }

            if (this.isBurning() && this.canSmelt())
            {
                ++this.freezerCookTime;

                if (this.freezerCookTime == 400)
                {
                    this.freezerCookTime = 0;
                    this.smeltItem();
                    var2 = true;
                }
            }
            else
            {
                this.freezerCookTime = 0;
            }

            if (var1 != this.freezerBurnTime > 0)
            {
                var2 = true;
                BlockFreezer.updateFreezerBlockState(this.freezerBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
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
        if (this.freezerItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack var1 = FreezerRecipes.smelting().getSmeltingResult(this.freezerItemStacks[0].getItem().shiftedIndex);
            if(var1 == null)
            	return false;
            else if(this.freezerItemStacks[2] == null)
            	return true;
            else if(!this.freezerItemStacks[2].isItemEqual(var1))
            	return false;
            else if(this.freezerItemStacks[2].stackSize < this.getInventoryStackLimit() && this.freezerItemStacks[2].stackSize < this.freezerItemStacks[2].getMaxStackSize())
            	return true;
            else if(this.freezerItemStacks[2].stackSize < this.freezerItemStacks[2].getMaxStackSize())
            	return true;
            else if(this.freezerItemStacks[3] == null)
            	return true;
            else if(!this.freezerItemStacks[3].isItemEqual(var1))
            	return false;
            else if(this.freezerItemStacks[3].stackSize < this.getInventoryStackLimit() && this.freezerItemStacks[3].stackSize < this.freezerItemStacks[3].getMaxStackSize())
            	return true;
            else if(this.freezerItemStacks[3].stackSize < this.freezerItemStacks[3].getMaxStackSize())
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
            ItemStack var1 = FreezerRecipes.smelting().getSmeltingResult(this.freezerItemStacks[0].getItem().shiftedIndex);
            ItemStack var2 = new ItemStack(Item.bucketEmpty);
            
            if (this.freezerItemStacks[2] == null)
            {
                this.freezerItemStacks[2] = var1.copy();
                if(this.freezerItemStacks[2].getItem().shiftedIndex == new ItemStack(Item.iceCube).getItem().shiftedIndex){
                	for(int x=0;x<3;x++)
                        ++this.freezerItemStacks[2].stackSize;
                }
                
                if (this.freezerItemStacks[3] == null)
                {
                	this.freezerItemStacks[3] = var2.copy();
                }else if (this.freezerItemStacks[3].itemID == var2.itemID)
                {
                	++this.freezerItemStacks[3].stackSize;
                }
            }
            else if (this.freezerItemStacks[2].itemID == var1.itemID)
            {
            	++this.freezerItemStacks[2].stackSize;
            	if(this.freezerItemStacks[2].getItem().shiftedIndex == new ItemStack(Item.iceCube).getItem().shiftedIndex){
            		for(int x=0;x<3;x++)
            			++this.freezerItemStacks[2].stackSize;
            	}
                if (this.freezerItemStacks[3] == null)
                {
                	this.freezerItemStacks[3] = var2.copy();
                }else if (this.freezerItemStacks[3].itemID == var2.itemID)
                {
                	++this.freezerItemStacks[3].stackSize;
                }
            }

            --this.freezerItemStacks[0].stackSize;

            if (this.freezerItemStacks[0].stackSize <= 0)
            {
                this.freezerItemStacks[0] = null;
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
        else
        {
            int var1 = par0ItemStack.getItem().shiftedIndex;
            Item var2 = par0ItemStack.getItem();

            if (var1 < 256 && Block.blocksList[var1] != null)
            {
                Block var3 = Block.blocksList[var1];

                if (var3 == Block.blockSnow)
                {
                    return 300;
                }

                if (var3 == Block.ice)
                {
                    return 800;
                }
                
                if (var3 == Block.oreRedstone)
                {
                    return 500;
                }
            }

            return var1 == Item.emerald.shiftedIndex ? 1000 : 0;
        }
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



    
    
    



    public void openChest()
    {
    }

    public void closeChest()
    {
    }


    
    
    
    
    
    
    
}

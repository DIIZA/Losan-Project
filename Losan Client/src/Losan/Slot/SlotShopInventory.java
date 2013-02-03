package Losan.Slot;

import Losan.Gui.GuiContainerShop;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;

public class SlotShopInventory extends Slot //ajout
{
    private final Slot field_75241_b;

    final GuiContainerShop field_75242_a;

    public SlotShopInventory(GuiContainerShop par1GuiContainerCreative, Slot par2Slot, int par3)
    {
        super(par2Slot.inventory, par3, 0, 0);
        this.field_75242_a = par1GuiContainerCreative;
        this.field_75241_b = par2Slot;
    }

    /**
     * Called when the player picks up an item from an inventory slot
     */
    public void func_82870_a(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack)
    {
        this.field_75241_b.onPickupFromSlot(par1EntityPlayer, par2ItemStack);
    }
    
    /**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
    public boolean isItemValid(ItemStack par1ItemStack)
    {
        return this.field_75241_b.isItemValid(par1ItemStack);
    }

    /**
     * Helper fnct to get the stack in the slot.
     */
    public ItemStack getStack()
    {
        return this.field_75241_b.getStack();
    }

    /**
     * Returns if this slot contains a stack.
     */
    public boolean getHasStack()
    {
        return this.field_75241_b.getHasStack();
    }

    /**
     * Helper method to put a stack in the slot.
     */
    public void putStack(ItemStack par1ItemStack)
    {
        this.field_75241_b.putStack(par1ItemStack);
    }

    /**
     * Called when the stack in a Slot changes
     */
    public void onSlotChanged()
    {
        this.field_75241_b.onSlotChanged();
    }

    /**
     * Returns the maximum stack size for a given slot (usually the same as getInventoryStackLimit(), but 1 in the case
     * of armor slots)
     */
    public int getSlotStackLimit()
    {
        return this.field_75241_b.getSlotStackLimit();
    }

    /**
     * Returns the icon index on items.png that is used as background image of the slot.
     */
    public int getBackgroundIconIndex()
    {
        return this.field_75241_b.getBackgroundIconIndex();
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
     * stack.
     */
    public ItemStack decrStackSize(int par1)
    {
        return this.field_75241_b.decrStackSize(par1);
    }

    /**
     * returns true if this slot is in par2 of par1
     */
    public boolean isSlotInInventory(IInventory par1IInventory, int par2)
    {
        return this.field_75241_b.isSlotInInventory(par1IInventory, par2);
    }

    static Slot func_75240_a(SlotShopInventory par0SlotCreativeInventory)
    {
        return par0SlotCreativeInventory.field_75241_b;
    }
}

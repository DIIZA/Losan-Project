package Losan.Container;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import Losan.Inventory.InventoryBoutique;
import Losan.Slot.SlotBoutique;

import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ICrafting;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ContainerBoutique extends Container //ajout
{
    public InventoryBoutique slotRef;
    private World worldObj;
    public boolean isLocalWorld;
    public boolean surB = false;
    public String ID;

    public ContainerBoutique(InventoryPlayer par1InventoryPlayer)
    {
        this(par1InventoryPlayer, true);
        this.surB = true;
    }
    
	public ContainerBoutique(InventoryPlayer par1InventoryPlayer, boolean par2)
	{
		par1InventoryPlayer.player.cont = this;
		this.slotRef = new InventoryBoutique("Boutique", 1);	
		this.addSlotToContainer(new SlotBoutique(par1InventoryPlayer.player, this.slotRef, 0, 79, 31));
	}
	public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);       
    }


	public boolean canInteractWith(EntityPlayer par1EntityPlayer)
	{
		return true;
	}

	public ItemStack func_82846_b(EntityPlayer par1EntityPlayer, int par2)
	{
		return null;
	} 
}

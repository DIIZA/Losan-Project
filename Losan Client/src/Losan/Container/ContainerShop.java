package Losan.Container;

import java.util.ArrayList;
import java.util.List;

import Losan.Gui.GuiContainerShop;
import Losan.Inventory.InventoryShop;
import Losan.Slot.SlotShopRef;

import net.minecraft.src.Block;
import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;

public class ContainerShop extends Container //ajout
{
	private ItemStack[] blackList = {new ItemStack(Block.melon), new ItemStack(Block.ice), new ItemStack(Block.football), new ItemStack(Block.dragonEgg), new ItemStack(Block.cobblestoneMossy), new ItemStack(Block.crops), new ItemStack(Block.web), new ItemStack(Block.sponge), new ItemStack(Block.grass), new ItemStack(Block.sapling), new ItemStack(Block.bedrock), new ItemStack(Block.oreCoal), new ItemStack(Block.oreDiamond), new ItemStack(Block.oreEmerald), new ItemStack(Block.oreGold), new ItemStack(Block.oreIron), new ItemStack(Block.oreLapis), new ItemStack(Block.oreRedstone), new ItemStack(Block.oreRedstoneGlowing)};
	
    /** the list of items in this container */
    public List itemList = new ArrayList();
    public InventoryShop slotRef;

    public ContainerShop(EntityPlayer par1EntityPlayer)
    {
    	int y = 0;
    	par1EntityPlayer.contShop = this;
		this.slotRef = new InventoryShop("ref", 1);
		this.addSlotToContainer(new SlotShopRef(this.slotRef, 0, 148, 119));

        InventoryPlayer var2 = par1EntityPlayer.inventory;
        int var3;

        for (var3 = 0; var3 < 5; ++var3)
        {
            for (int var4 = 0; var4 < 9; ++var4)
            {
                this.addSlotToContainer(new Slot(GuiContainerShop.getInventory(), var3 * 9 + var4, 9 + var4 * 18, 18 + var3 * 18-y));
            }
        }



        this.scrollTo(0.0F);
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return true;
    }

    /**
     * Updates the gui slots ItemStack's based on scroll position.
     */
    public void scrollTo(float par1)
    {
    	
        int var2 = this.itemList.size() / 9 - 5 + 1;
        int var3 = (int)((double)(par1*1.28 * (float)var2) + 0.5D);

        if (var3 < 0)
        {
            var3 = 0;
        }
//        int indice =0;
        for (int var4 = 0; var4 < 5;++var4)
        {
            for (int var5 = 0; var5 < 9;++var5)
            {
                int var6 = var5 + (var4 + var3) * 9;

                boolean valide = true;
                
                
                if (var6 >= 0 && var6 < this.itemList.size())
                {
                    try{
                    	ItemStack id = ((ItemStack)this.itemList.get(var6)); 
                    	
//                    	for(ItemStack x: this.blackList)
//                    	{
//
//                    		if(x.getItem()==id.getItem()){
//                    			valide = false;
//                    		}
//                    	}
                    }catch(Exception ex){}
//                	if(valide)
                		GuiContainerShop.getInventory().setInventorySlotContents(var5 + var4 * 9, (ItemStack)this.itemList.get(var6));
//                	else
//                		GuiContainerShop.getInventory().setInventorySlotContents(var5 + var4 * 9, (ItemStack)null);
                }
                else
                {
                	GuiContainerShop.getInventory().setInventorySlotContents(var5 + var4 * 9, (ItemStack)null);
                }
                
            }
             
        }
    }

    /**
     * theCreativeContainer seems to be hard coded to 9x5 items
     */
    public boolean hasMoreThan1PageOfItemsInList()
    {
        return this.itemList.size() > 36;
    }

    protected void retrySlotClick(int par1, int par2, boolean par3, EntityPlayer par4EntityPlayer) {}

    /**
     * Called to transfer a stack from one inventory to the other eg. when shift clicking.
     */
    public ItemStack func_82846_b(EntityPlayer par1EntityPlayer, int par2)
    {

        return null;
    }
}

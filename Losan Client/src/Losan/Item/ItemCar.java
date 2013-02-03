package Losan.Item;

import Losan.Entity.EntityVoiture;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Facing;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemCar extends Item
{
	private boolean demi = false;
	
    public ItemCar(int var1)
    {
        super(var1);
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabTransport);
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7, float var8, float var9, float var10)
    {
        int var11 = var3.getBlockId(var4, var5, var6);
        var4 += Facing.offsetsXForSide[var7];
        var5 += Facing.offsetsYForSide[var7];
        var6 += Facing.offsetsZForSide[var7];
        double var12 = 0.0D;
        
        if (var7 == 1 && var11 == Block.fence.blockID || var11 == Block.netherFence.blockID)
        {
            var12 = 0.5D;
        }

        if (!var3.isRemote)
        {
//        	new EntityVoiture(var3, (double)var4, (double)var5+var12, (double)var6)
        	EntityVoiture car = new EntityVoiture(var3);
        	car.yOffset = car.height / 2.0F+0.2F;
        	car.setPosition((double)var4, (double)var5+car.yOffset, (double)var6);
        	var3.spawnEntityInWorld(car);
//        	car.serverPosX = var4; 
//        	car.serverPosY = var5+(int)var12; 
//        	car.serverPosZ = var6; 
//         	car.posX = (double)var4; 
//        	car.posY = (double)var5+var12; 
//        	car.posZ = (double)var6; 

        }


        if (!var2.capabilities.isCreativeMode)
        {
            --var1.stackSize;
        }

        return true;
    }
}

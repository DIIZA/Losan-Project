package Losan.Block;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;


public class BlockSpeeder extends Block //ajout
{
    public BlockSpeeder(int var1, int var2)
    {
        super(var1, var2, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setTextureFile("/terrain1.png");
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4)
    {
        float var5 = 0.125F;
        return AxisAlignedBB.getBoundingBox((double)var2, (double)var3, (double)var4, (double)(var2 + 1), (double)((float)(var3 + 1) - var5), (double)(var4 + 1));
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World var1, int var2, int var3, int var4, Entity var5)
    {
    	if(var5 instanceof EntityPlayer){
			((EntityPlayer)var5).motionZ = (double)(MathHelper.cos(((EntityPlayer)var5).rotationYawHead / 180.0F * (float)Math.PI) * MathHelper.cos(((EntityPlayer)var5).rotationPitch / 180.0F * (float)Math.PI) *2.5F);
			((EntityPlayer)var5).motionX = (double)(-MathHelper.sin(((EntityPlayer)var5).rotationYawHead / 180.0F * (float)Math.PI) * MathHelper.cos(((EntityPlayer)var5).rotationPitch / 180.0F * (float)Math.PI) *2.5F);  	
    	}
    }
    

    
}

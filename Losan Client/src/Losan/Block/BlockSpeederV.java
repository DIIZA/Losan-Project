package Losan.Block;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;


public class BlockSpeederV extends Block //ajout
{
    public BlockSpeederV(int var1, int var2)
    {
        super(var1, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.blockIndexInTexture = var2;
        this.setTextureFile("/terrain1.png");
        this.setBlockBounds(0F, 0F, 0F, 1.0F, 1.0F, 1.0F);
    }
    
    public boolean renderAsNormalBlock()
    {
        return true;
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
//    	if(var5 instanceof EntityPlayer){

    		
    		int var7 = var1.getBlockMetadata(var2, var3, var4);
    		int var6 = var7 & 3;
    		if(var6 == 3){
    			(var5).motionZ = 2.5D;
    			(var5).motionX = 0D;
    		}else if(var6 == 1){
    			(var5).motionZ = 0D;
    			(var5).motionX = 2.5D;
    		}else if(var6 == 2){
    			(var5).motionZ = -2.5D;
    			(var5).motionX = 0D;
    		}else if(var6 == 0){
    			(var5).motionZ = 0D;
    			(var5).motionX = -2.5D;
    		}
    	
//    	}
    }
    
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
    {
        int var6 = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        int var7 = par1World.getBlockMetadata(par2, par3, par4) & 4;

        if (var6 == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2 | var7);
        }

        if (var6 == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 1 | var7);
        }

        if (var6 == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3 | var7);
        }

        if (var6 == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 0 | var7);
        }
    }

    public int getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
    	int var7 = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
		int var6 = var7 & 3;
		if(var6 == 0){
	        if (par5 == 0)
	        {
	            return this.blockIndexInTexture +2;
	        }
	        else if (par5 == 1)
	        {
	            return this.blockIndexInTexture + 2;
	        }
	        else if (par5 == 2)
	        {
	            return this.blockIndexInTexture ;
	        }
	        else if (par5 == 3)
	        {
	            return this.blockIndexInTexture +2;
	        }
	        else if (par5 == 4)
	        {
	            return this.blockIndexInTexture +1;
	        }
	        else
	        {
	            return this.blockIndexInTexture -1;
	        }
		}else if(var6 == 1){
			if (par5 == 0)
			{
				return this.blockIndexInTexture;
			}
			else if (par5 == 1)
			{
				return this.blockIndexInTexture;
			}
			else if (par5 == 2)
			{
				return this.blockIndexInTexture + 2;
			}
			else if (par5 == 3)
			{
				return this.blockIndexInTexture;
			}
			else if (par5 == 4)
			{
				return this.blockIndexInTexture -1;
			}
			else
			{
				return this.blockIndexInTexture+1;
			}
		}else if(var6 == 2){
			if (par5 == 0)
			{
				return this.blockIndexInTexture-1;
			}
			else if (par5 == 1)
			{
				return this.blockIndexInTexture-1;
			}
			else if (par5 == 2)
			{
				return this.blockIndexInTexture+1;
			}
			else if (par5 == 3)
			{
				return this.blockIndexInTexture-1;
			}
			else if (par5 == 4)
			{
				return this.blockIndexInTexture+2;
			}
			else
			{
				return this.blockIndexInTexture;
			}
		}else{
			if (par5 == 0)
			{
				return this.blockIndexInTexture+1;
			}
			else if (par5 == 1)
			{
				return this.blockIndexInTexture + 1;
			}
			else if (par5 == 2)
			{
				return this.blockIndexInTexture -1;
			}
			else if (par5 == 3)
			{
				return this.blockIndexInTexture+1;
			}
			else if (par5 == 4)
			{
				return this.blockIndexInTexture;
			}
			else
			{
				return this.blockIndexInTexture + 2;
			}
		}
		
    }
    
    
    public int getBlockTextureFromSide(int par1)
    {
        return par1 == 1 ? this.blockIndexInTexture+1  : (par1 == 0 ? this.blockIndexInTexture+1  : (par1 == 3 ? this.blockIndexInTexture + 1 : (par1 == 2 ? this.blockIndexInTexture -1 : (par1 == 4 ? this.blockIndexInTexture  : this.blockIndexInTexture + 2))));
    
    }
}

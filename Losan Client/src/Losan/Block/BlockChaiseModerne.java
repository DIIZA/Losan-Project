package Losan.Block;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class BlockChaiseModerne extends Block //ajout
{
    private final int field_72158_c;
    private boolean field_72156_cr = false;
    private int field_72160_cs = 0;
    private final Block modelBlock;

    public BlockChaiseModerne(int par1, Block par2Block, int par3)
    {
        super(par1, par2Block.blockMaterial);
        this.modelBlock = par2Block;
        this.field_72158_c = par3;
        this.blockIndexInTexture = 113;
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
    public boolean isOpaqueCube()
    {
        return false;
    }

    public int getRenderType()
    {
        return 51;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.5F, 1.0F);
    }
    

    

    public void addCollidingBlockToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
    {
        int var8 = par1World.getBlockMetadata(par2, par3, par4);
        int var9 = var8 & 3;
        float var12 = 0.6F;
        float var13 = 1.5F;
        this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.3F, 0.9F);
        super.addCollidingBlockToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);

        if (var9 == 0)
        {
            this.setBlockBounds(0.8F, var12, 0.1F, 0.9F, var13, 0.9F);
            super.addCollidingBlockToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        }
        else if (var9 == 1)
        {
            this.setBlockBounds(0.1F, var12, 0.1F, 0.2F, var13, 0.90F);
            super.addCollidingBlockToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        }
        else if (var9 == 2)
        {
            this.setBlockBounds(0.1F, var12, 0.9F, 0.9F, var13, 0.9F);
            super.addCollidingBlockToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        }
        else if (var9 == 3)
        {
            this.setBlockBounds(0.1F, var12, 0.1F, 0.9F, var13, 0.2F);
            super.addCollidingBlockToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        }

        this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.6F, 0.9F);
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

    /**
     * called before onBlockPlacedBy by ItemBlock and ItemReed
     */
    public void updateBlockMetadata(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8)
    {
        if (par5 == 0 || par5 != 1 && (double)par7 > 0.5D)
        {
            int var9 = par1World.getBlockMetadata(par2, par3, par4);
            par1World.setBlockMetadataWithNotify(par2, par3, par4, var9 | 4);
        }
    }

    public int idDropped(int par1, Random random)
    {
        return this.blockID;
    }

    public void addCreativeItems(ArrayList itemList)
    {
        itemList.add(new ItemStack(this));
    }

    public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        this.modelBlock.onEntityWalking(par1World, par2, par3, par4, par5Entity);
    }

    /**
     * Returns if this block is collidable (only used by Fire). Args: x, y, z
     */
    public boolean isCollidable()
    {
        return this.modelBlock.isCollidable();
    }

    /**
     * Returns whether this block is collideable based on the arguments passed in Args: blockMetaData, unknownFlag
     */
    public boolean canCollideCheck(int par1, boolean par2)
    {
        return this.modelBlock.canCollideCheck(par1, par2);
    }
    
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return true;
    }
}

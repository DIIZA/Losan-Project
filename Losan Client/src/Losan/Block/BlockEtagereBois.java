package Losan.Block;

import java.util.Iterator;
import java.util.Random;

import Losan.TileEntity.TileEntityEtagereBois;

import net.minecraft.src.BlockContainer;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class BlockEtagereBois extends BlockContainer //ajout
{
	private Random random = new Random();

	public BlockEtagereBois(int par1)
	{
		super(par1, Material.wood);
		this.blockIndexInTexture = 26;
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
	}

	/**
	 * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
	 * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube()
	{
		return false;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	/**
	 * The type of render function that is called for this block
	 */
	public int getRenderType()
	{
		return 53;
	}

	public boolean canPlaceBlockOnSide(World par1World, int par2, int par3, int par4, int par5)
	{
		return par5 == 2 && par1World.isBlockNormalCube(par2, par3, par4 + 1) ? true : (par5 == 3 && par1World.isBlockNormalCube(par2, par3, par4 - 1) ? true : (par5 == 4 && par1World.isBlockNormalCube(par2 + 1, par3, par4) ? true : par5 == 5 && par1World.isBlockNormalCube(par2 - 1, par3, par4)));
	}

	/**
	 * called before onBlockPlacedBy by ItemBlock and ItemReed
	 */
	public void updateBlockMetadata(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8)
	{
		int var9 = par1World.getBlockMetadata(par2, par3, par4);

		if (par5 == 2 && par1World.isBlockNormalCubeDefault(par2, par3, par4 + 1, true))
		{
			var9 = 2;
		}
		if (par5 == 3 && par1World.isBlockNormalCubeDefault(par2, par3, par4 - 1, true))
		{
			var9 = 3;
		}
		if (par5 == 4 && par1World.isBlockNormalCubeDefault(par2 + 1, par3, par4, true))
		{
			var9 = 4;
		}
		if (par5 == 5 && par1World.isBlockNormalCubeDefault(par2 - 1, par3, par4, true))
		{
			var9 = 5;
		}
		par1World.setBlockMetadataWithNotify(par2, par3, par4, var9);
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
//		super.updateTick(par1World, par2, par3, par4, par5Random);
//
//		if (par1World.getBlockMetadata(par2, par3, par4) == 0)
//		{
//			this.onBlockAdded(par1World, par2, par3, par4);
//		}
	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		if (par1World.isBlockNormalCubeDefault(par2 - 1, par3, par4, true))
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 5);
		}
		else if (par1World.isBlockNormalCubeDefault(par2 + 1, par3, par4, true))
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 4);
		}
		else if (par1World.isBlockNormalCubeDefault(par2, par3, par4 - 1, true))
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3);
		}
		else if (par1World.isBlockNormalCubeDefault(par2, par3, par4 + 1, true))
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2);
		}
	}

	/**
	 * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
	 */
	public int getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		return 4;
	}

	/**
	 * Returns the block texture based on the side being looked at.  Args: side
	 */
	public int getBlockTextureFromSide(int par1)
	{
		return 4;
	}

	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	{
		super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
		TileEntityEtagereBois var6 = (TileEntityEtagereBois)par1World.getBlockTileEntity(par2, par3, par4);

		if (var6 != null)
		{
			var6.updateContainingBlockInfo();
		}
	}

	/**
	 * ejects contained items into the world, and notifies neighbours of an update, as appropriate
	 */
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		return true;
	}

	/**
	 * each class overrdies this to return a new <className>
	 */
	public TileEntity createNewTileEntity(World par1World)
	{
		return new TileEntityEtagereBois();
	}

}

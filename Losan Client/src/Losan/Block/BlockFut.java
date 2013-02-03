package Losan.Block;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import Losan.TileEntity.TileEntityFut;

import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class BlockFut extends BlockContainer //ajout
{
	private Random futRand = new Random();

	/** True if this is an active furnace, false if idle */
	private final boolean isActive;

	/**
	 * This flag is used to prevent the furnace inventory to be dropped upon block removal, is used internally when the
	 * furnace block changes from idle to active and vice-versa.
	 */
	private static boolean keepFutInventory = false;

	public BlockFut(int par1, boolean par2)
	{
		super(par1, Material.wood);
		this.isActive = par2;
		this.blockIndexInTexture = 26;
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return Block.fut.blockID;
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
		return 52;
	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);

	}

	/**
	 * Called when the block is placed in the world.
	 */
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
	{
		int var6 = par1World.getBlockId(par2, par3, par4 - 1);
		int var7 = par1World.getBlockId(par2, par3, par4 + 1);
		int var8 = par1World.getBlockId(par2 - 1, par3, par4);
		int var9 = par1World.getBlockId(par2 + 1, par3, par4);
		byte var10 = 0;
		int var11 = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		if (var11 == 0)
		{
			var10 = 2;
		}
		if (var11 == 1)
		{
			var10 = 5;
		}
		if (var11 == 2)
		{
			var10 = 3;
		}
		if (var11 == 3)
		{
			var10 = 4;
		}
		par1World.setBlockMetadataWithNotify(par2, par3, par4, var10);
	}


	/**
	 * A randomly called display update to be able to add particles or other items for display
	 */
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (this.isActive)
		{
			int var6 = par1World.getBlockMetadata(par2, par3, par4);
			float var7 = (float)par2 ;
			float var8 = (float)par3 + 1.5F + par5Random.nextFloat() * 6.0F / 16.0F;
			float var9 = (float)par4;
			float var10 = 0.52F;
			float var11 = par5Random.nextFloat() * 0.6F - 0.3F;
			if (var6 == 4)
			{
				par1World.spawnParticle("gel", (double)(var7 - var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);

			}
			else if (var6 == 5)
			{
				par1World.spawnParticle("gel", (double)(var7 + var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);

			}
			else if (var6 == 2)
			{
				par1World.spawnParticle("gel", (double)(var7 + var11), (double)var8, (double)(var9 - var10), 0.0D, 0.0D, 0.0D);

			}
			else if (var6 == 3)
			{
				par1World.spawnParticle("gel", (double)(var7 + var11), (double)var8, (double)(var9 + var10), 0.0D, 0.0D, 0.0D);

			}
		}
	}


	/**
	 * Update which block ID the furnace is using depending on whether or not it is burning
	 */
	public static void updateFutBlockState(boolean par0, World par1World, int par2, int par3, int par4)
	{
		int var5 = par1World.getBlockMetadata(par2, par3, par4);
		TileEntity var6 = par1World.getBlockTileEntity(par2, par3, par4);
		keepFutInventory = true;
		par1World.setBlockWithNotify(par2, par3, par4, Block.fut.blockID);
		keepFutInventory = false;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, var5);
		if (var6 != null)
		{
			var6.validate();
			par1World.setBlockTileEntity(par2, par3, par4, var6);
		}
	}

	/**
	 * each class overrdies this to return a new <className>
	 */
	public TileEntity createNewTileEntity(World par1World)
	{
		return new TileEntityFut();
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

	/**
	 * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
	 */
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	{
		int[] ban = {0, 8, 9, 10, 11};

		for(int x=0; x < ban.length; x++){ 
			if (par1World.getBlockId(par2 - 1, par3, par4) != x){
				return true;
			}
		}
		return false; 
	}

	/**
	 * ejects contained items into the world, and notifies neighbours of an update, as appropriate
	 */
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		if (!keepFutInventory)
		{
			TileEntityFut var7 = (TileEntityFut)par1World.getBlockTileEntity(par2, par3, par4);
			if (var7 != null)
			{
				for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
				{
					ItemStack var9 = var7.getStackInSlot(var8);
					if (var9 != null)
					{
						float var10 = this.futRand.nextFloat() * 0.8F + 0.1F;
						float var11 = this.futRand.nextFloat() * 0.8F + 0.1F;
						float var12 = this.futRand.nextFloat() * 0.8F + 0.1F;
						while (var9.stackSize > 0)
						{
							int var13 = this.futRand.nextInt(21) + 10;
							if (var13 > var9.stackSize)
							{
								var13 = var9.stackSize;
							}
							var9.stackSize -= var13;
							EntityItem var14 = new EntityItem(par1World, (double)((float)par2 + var10), (double)((float)par3 + var11), (double)((float)par4 + var12), new ItemStack(var9.itemID, var13, var9.getItemDamage()));
							if (var9.hasTagCompound())
							{
								var14.item.setTagCompound((NBTTagCompound)var9.getTagCompound().copy());
							}
							float var15 = 0.05F;
							var14.motionX = (double)((float)this.futRand.nextGaussian() * var15);
							var14.motionY = (double)((float)this.futRand.nextGaussian() * var15 + 0.2F);
							var14.motionZ = (double)((float)this.futRand.nextGaussian() * var15);
							par1World.spawnEntityInWorld(var14);
						}
					}
				}
			}
		}
		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
    	if (par1World.isRemote)
    	{
    		return true;
    	}
    	else
    	{
			TileEntityFut var10 = (TileEntityFut)par1World.getBlockTileEntity(par2, par3, par4);
			if (var10 != null)
			{
				par5EntityPlayer.displayGUIFut(var10);
			}
			return true;
    	}
	}






}

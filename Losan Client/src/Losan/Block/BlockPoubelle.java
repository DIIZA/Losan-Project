package Losan.Block;

import java.util.Iterator;
import java.util.Random;

import Losan.TileEntity.TileEntityPoubelle;

import net.minecraft.client.Minecraft;
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

public class BlockPoubelle extends BlockContainer //ajout
{
    private Random random = new Random();

    public BlockPoubelle(int par1)
    {
        super(par1, Material.iron);
        this.blockIndexInTexture = 145;
        this.setCreativeTab(CreativeTabs.tabDecorations);
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
        return 54;
    }
    
    public int getRenderBlockPass()
    {
        return 0;
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
        TileEntityPoubelle var7 = (TileEntityPoubelle)par1World.getBlockTileEntity(par2, par3, par4);

        if (var7 != null)
        {
            for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
            {
                ItemStack var9 = var7.getStackInSlot(var8);

                if (var9 != null)
                {
                    float var10 = this.random.nextFloat() * 0.8F + 0.1F;
                    float var11 = this.random.nextFloat() * 0.8F + 0.1F;
                    EntityItem var14;

                    for (float var12 = this.random.nextFloat() * 0.8F + 0.1F; var9.stackSize > 0; par1World.spawnEntityInWorld(var14))
                    {
                        int var13 = this.random.nextInt(21) + 10;

                        if (var13 > var9.stackSize)
                        {
                            var13 = var9.stackSize;
                        }

                        var9.stackSize -= var13;
                        var14 = new EntityItem(par1World, (double)((float)par2 + var10), (double)((float)par3 + var11), (double)((float)par4 + var12), new ItemStack(var9.itemID, var13, var9.getItemDamage()));
                        float var15 = 0.05F;
                        var14.motionX = (double)((float)this.random.nextGaussian() * var15);
                        var14.motionY = (double)((float)this.random.nextGaussian() * var15 + 0.2F);
                        var14.motionZ = (double)((float)this.random.nextGaussian() * var15);

                        if (var9.hasTagCompound())
                        {
                            var14.item.setTagCompound((NBTTagCompound)var9.getTagCompound().copy());
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
        Object var10 = (TileEntityPoubelle)par1World.getBlockTileEntity(par2, par3, par4);

        if (var10 == null)
        {
            return true;
        }
        
        else
        {
            if (par1World.isRemote)
            {
                return true;
            }
            else
            {
//            	if(par5EntityPlayer.isSneaking()){
//            		Minecraft.getMinecraft().thePlayer.displayGUIPoubelle((IInventory)var10);
//            		return true;
//            	}else{
            		if(par5EntityPlayer.getCurrentEquippedItem() != null && par5EntityPlayer.getCurrentEquippedItem() != new ItemStack(Block.poubelle)){
            			ItemStack x;
            			int stack;
            			stack = par5EntityPlayer.getCurrentEquippedItem().stackSize;
            			if(par5EntityPlayer.getCurrentEquippedItem().getHasSubtypes())
            				x = new ItemStack(par5EntityPlayer.getCurrentEquippedItem().getItem(), stack, par5EntityPlayer.getCurrentEquippedItem().getItemDamage());
            			else
            				x = new ItemStack(par5EntityPlayer.getCurrentEquippedItem().getItem(), stack);
            			
            			TileEntityPoubelle t = (TileEntityPoubelle) par1World.getBlockTileEntity(par2, par3, par4);
            			t.setContents(x);

            			for(int z = 0; z<stack;z++)	{
            				par5EntityPlayer.inventory.consumeInventoryItem(par5EntityPlayer.getCurrentEquippedItem().getItem().shiftedIndex);

            			}
//            			par5EntityPlayer.displayGUIPoubelle1((IInventory)var10);
            			return true;
            		}
            		return true;
//            	}
                
            }
        }
    }

    /**
     * each class overrdies this to return a new <className>
     */
    public TileEntity createNewTileEntity(World par1World)
    {
        return new TileEntityPoubelle();
    }


    
}

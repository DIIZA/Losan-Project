package Losan.Block;

import java.util.List;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class BlockFoot extends Block
{
    public BlockFoot(int par1,int par2, Material par3)
    {
        super(par1, par2, par3);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockBounds(0.0F, 0.0F, 0.0F,  1.0F, 1.0F, 1.0F);
        this.setTextureFile("/terrain1.png");
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return true;
    }




    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int par1)
    {
        return par1;
    }



}

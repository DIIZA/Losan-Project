package Losan.Item;

import Losan.Block.BlockGlowStoneColor;
import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemDye;
import net.minecraft.src.ItemStack;

public class ItemColoredGlowStone extends ItemBlock
{
    public ItemColoredGlowStone(int par1)
    {
        super(par1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    public int getIconFromDamage(int par1)
    {
        return Block.coloredGlowStone.getBlockTextureFromSideAndMetadata(2, BlockGlowStoneColor.getBlockFromDye(par1));
    }

    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    public int getMetadata(int par1)
    {
        return par1;
    }

    public String getItemNameIS(ItemStack par1ItemStack)
    {
        return super.getItemName() + "." + ItemDye.dyeColorNames[BlockGlowStoneColor.getBlockFromDye(par1ItemStack.getItemDamage())];
    }
}
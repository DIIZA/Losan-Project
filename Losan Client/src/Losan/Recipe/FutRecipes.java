package Losan.Recipe;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class FutRecipes //ajout
{
    private static final FutRecipes smeltingBase = new FutRecipes();

    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final FutRecipes smelting()
    {
        return smeltingBase;
    }

    private FutRecipes()
    {
    	this.addSmelting(Item.orge.shiftedIndex, new ItemStack(Item.verrePlein), 0.5F);
    }

    /**
     * Adds a smelting recipe.
     */
    public void addSmelting(int par1, ItemStack par2ItemStack, float par3)
    {
        this.smeltingList.put(Integer.valueOf(par1), par2ItemStack);
        this.experienceList.put(Integer.valueOf(par2ItemStack.itemID), Float.valueOf(par3));
    }

    /**
     * Returns the smelting result of an item.
     */
    public ItemStack getSmeltingResult(int par1)
    {
        return (ItemStack)this.smeltingList.get(Integer.valueOf(par1));
    }

    public Map getSmeltingList()
    {
        return this.smeltingList;
    }

    public float func_77601_c(int par1)
    {
        return this.experienceList.containsKey(Integer.valueOf(par1)) ? ((Float)this.experienceList.get(Integer.valueOf(par1))).floatValue() : 0.0F;
    }
}

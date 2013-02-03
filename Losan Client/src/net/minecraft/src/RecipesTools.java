package net.minecraft.src;

public class RecipesTools
{
    private String[][] recipePatterns = new String[][] {{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}};
    private Object[][] recipeItems;

    public RecipesTools()
    {
        this.recipeItems = new Object[][] {{Block.planks, Block.cobblestone, Item.ingotIron, Item.diamond, Item.ingotGold, Item.rubis, Item.emerald}, {Item.pickaxeWood, Item.pickaxeStone, Item.pickaxeSteel, Item.pickaxeDiamond, Item.pickaxeGold, Item.pickaxeRubis, Item.pickaxeEmeraude}, {Item.shovelWood, Item.shovelStone, Item.shovelSteel, Item.shovelDiamond, Item.shovelGold, Item.shovelRubis, Item.shovelEmeraude}, {Item.axeWood, Item.axeStone, Item.axeSteel, Item.axeDiamond, Item.axeGold, Item.axeRubis, Item.axeEmeraude}, {Item.hoeWood, Item.hoeStone, Item.hoeSteel, Item.hoeDiamond, Item.hoeGold, Item.hoeRubis, Item.hoeEmeraude}};
    }

    /**
     * Adds the tool recipes to the CraftingManager.
     */
    public void addRecipes(CraftingManager par1CraftingManager)
    {
        for (int var2 = 0; var2 < this.recipeItems[0].length; ++var2)
        {
            Object var3 = this.recipeItems[0][var2];

            for (int var4 = 0; var4 < this.recipeItems.length - 1; ++var4)
            {
                Item var5 = (Item)this.recipeItems[var4 + 1][var2];
                par1CraftingManager.addRecipe(new ItemStack(var5), new Object[] {this.recipePatterns[var4], '#', Item.stick, 'X', var3});
            }
        }

        par1CraftingManager.addRecipe(new ItemStack(Item.shears), new Object[] {" #", "# ", '#', Item.ingotIron});
    }
}

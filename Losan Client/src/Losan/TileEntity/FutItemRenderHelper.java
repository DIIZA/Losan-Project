package Losan.TileEntity;

import net.minecraft.src.Block;
import net.minecraft.src.TileEntityRenderer;

public class FutItemRenderHelper //ajout
{
    /** The static instance of ChestItemRenderHelper. */
    public static FutItemRenderHelper instance = new FutItemRenderHelper();
    private TileEntityFut field_78543_b = new TileEntityFut();

    /**
     * Renders a chest at 0,0,0 - used for item rendering
     */
    public void renderFut(Block par1Block, int par2, float par3)
    {

            TileEntityRenderer.instance.renderTileEntityAt(this.field_78543_b, 0.0D, 0.0D, 0.0D, 0.0F);

    }
}

package Losan.TileEntity;

import net.minecraft.src.Block;
import net.minecraft.src.TileEntityRenderer;

public class EtagereBoisItemRenderHelper //ajout
{
    /** The static instance of ChestItemRenderHelper. */
    public static EtagereBoisItemRenderHelper instance = new EtagereBoisItemRenderHelper();
    private TileEntityEtagereBois field_78543_b = new TileEntityEtagereBois();

    /**
     * Renders a chest at 0,0,0 - used for item rendering
     */
    public void renderEtagereBois(Block par1Block, int par2, float par3)
    {


            TileEntityRenderer.instance.renderTileEntityAt(this.field_78543_b, 0.0D, 0.0D, 0.0D, 0.0F);

    }
}

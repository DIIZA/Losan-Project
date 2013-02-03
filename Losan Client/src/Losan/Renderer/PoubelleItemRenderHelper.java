package Losan.Renderer;

import net.minecraft.src.Block;
import net.minecraft.src.TileEntityRenderer;
import Losan.TileEntity.TileEntityPoubelle;

public class PoubelleItemRenderHelper {
	   /** The static instance of PoubelleItemRenderHelper. */
    public static PoubelleItemRenderHelper instance = new PoubelleItemRenderHelper();
    private TileEntityPoubelle field_78543_b = new TileEntityPoubelle();

    /**
     * Renders a poubelle at 0,0,0 - used for item rendering
     */
    public void renderPoubelle(Block par1Block, int par2, float par3)
    {
            TileEntityRenderer.instance.renderTileEntityAt(this.field_78543_b, 0.0D, 0.0D, 0.0D, 0.0F);
    }
}

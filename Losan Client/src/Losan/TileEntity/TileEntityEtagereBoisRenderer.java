package Losan.TileEntity;

import net.minecraft.src.Block;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntitySpecialRenderer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class TileEntityEtagereBoisRenderer extends TileEntitySpecialRenderer //ajout
{
    /** The normal small etagereBois model. */
    private Losan.Modele.ModelEtagereBois etagereBoisModel = new Losan.Modele.ModelEtagereBois();


    /**
     * Renders the TileEntity for the etagereBois at a position.
     */
    public void renderTileEntityEtagereBoisAt(TileEntityEtagereBois par1TileEntityEtagereBois, double par2, double par4, double par6, float par8)
    {
        int var9;

        if (!par1TileEntityEtagereBois.func_70309_m())
        {
            var9 = 0;
        }
        else
        {
            Block var10 = par1TileEntityEtagereBois.getBlockType();
            var9 = par1TileEntityEtagereBois.getBlockMetadata();

        }

       
            Losan.Modele.ModelEtagereBois var14;

                var14 = this.etagereBoisModel;
                this.bindTextureByName("/item/etagereBois.png");
           

            GL11.glPushMatrix();
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glTranslatef((float)par2, (float)par4 + 1.0F, (float)par6 + 1.0F);
            GL11.glScalef(1.0F, -1.0F, -1.0F);
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            short var11 = 0;

            if (var9 == 2)
            {
                var11 = 180;
            }

            if (var9 == 3)
            {
                var11 = 0;
            }

            if (var9 == 4)
            {
                var11 = 90;
            }

            if (var9 == 5)
            {
                var11 = -90;
            }

            

            

            GL11.glRotatef((float)var11, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

            
            var14.renderAll();
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glPopMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
    {
        this.renderTileEntityEtagereBoisAt((TileEntityEtagereBois)par1TileEntity, par2, par4, par6, par8);
    }
}

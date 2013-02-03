package Losan.Renderer;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;

import org.lwjgl.opengl.GL11;

import Losan.Entity.EntityGiantRaptor;

public class RenderGiantRaptor extends RenderLiving//ajout
{
    /** Scale of the model to use */
    private float scale;

    public RenderGiantRaptor(ModelBase par1ModelBase, float par2, float par3)
    {
        super(par1ModelBase, par2 * par3);
        this.scale = par3;
    }

    /**
     * Applies the scale to the transform matrix
     */
    protected void preRenderScale(EntityGiantRaptor par1EntityGiantZombie, float par2)
    {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        this.preRenderScale((EntityGiantRaptor)par1EntityLiving, par2);
    }
}

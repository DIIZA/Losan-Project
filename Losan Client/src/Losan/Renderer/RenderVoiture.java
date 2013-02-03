package Losan.Renderer;

import net.minecraft.src.Entity;
import net.minecraft.src.ModelBase;
import net.minecraft.src.Render;

import org.lwjgl.opengl.GL11;

import Losan.Entity.EntityVoiture;

public class RenderVoiture extends Render
{
    protected ModelBase modelMinecart;

    public RenderVoiture()
    {
        this.shadowSize = 0.5F;
    }

    public void func_152_a(EntityVoiture var1, double var2, double var4, double var6, float var8, float var9)
    {
        this.modelMinecart = var1.getModel();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)var2, (float)var4, (float)var6);
        GL11.glRotatef(180.0F - var8, 0.0F, 1.0F, 0.0F);

        this.loadTexture("/mob/car.png");
        GL11.glScalef(-2.0F, -2.0F, 2.0F);
        this.modelMinecart.render(var1, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9)
    {
        this.func_152_a((EntityVoiture)var1, var2, var4, var6, var8, var9);
    }  
}

package Losan.Modele;

import net.minecraft.src.Entity;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelVoiture extends ModelBase
{
    public ModelRenderer bottom = new ModelRenderer(this, 0, 0);
    public ModelRenderer back;
    public ModelRenderer front;
    public ModelRenderer New_Shape2;
    public ModelRenderer New_Shape21;
    public ModelRenderer New_Shape1;
    public ModelRenderer New_Shape11;
    public ModelRenderer New_Shape3;
    public ModelRenderer New_Shape31;
    public ModelRenderer New_Shape311;
    public ModelRenderer New_Shape3111;

    public ModelVoiture()
    {
        this.bottom.addBox(-7.0F, 5.0F, -4.0F, 14, 1, 8, 0.0F);
        this.bottom.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bottom.rotateAngleX = 0.0F;
        this.bottom.rotateAngleY = 0.0F;
        this.bottom.rotateAngleZ = 0.0F;
        this.bottom.mirror = false;
        this.back = new ModelRenderer(this, 0, 9);
        this.back.addBox(7.0F, 0.0F, -5.0F, 1, 6, 10, 0.0F);
        this.back.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.back.rotateAngleX = 0.0F;
        this.back.rotateAngleY = 0.0F;
        this.back.rotateAngleZ = 0.0F;
        this.back.mirror = false;
        this.front = new ModelRenderer(this, 0, 9);
        this.front.addBox(-8.0F, 0.0F, -5.0F, 1, 6, 10, 0.0F);
        this.front.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.front.rotateAngleX = 0.0F;
        this.front.rotateAngleY = 0.0F;
        this.front.rotateAngleZ = 0.0F;
        this.front.mirror = false;
        this.New_Shape2 = new ModelRenderer(this, 0, 25);
        this.New_Shape2.addBox(-6.0F, -5.0F, -0.5F, 3, 1, 1, 0.0F);
        this.New_Shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.New_Shape2.rotateAngleX = 0.0F;
        this.New_Shape2.rotateAngleY = 0.0F;
        this.New_Shape2.rotateAngleZ = -0.8552113F;
        this.New_Shape2.mirror = false;
        this.New_Shape21 = new ModelRenderer(this, 8, 25);
        this.New_Shape21.addBox(-3.0F, -6.0F, -1.5F, 1, 3, 3, 0.0F);
        this.New_Shape21.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.New_Shape21.rotateAngleX = 0.0F;
        this.New_Shape21.rotateAngleY = 0.0F;
        this.New_Shape21.rotateAngleZ = -0.8552113F;
        this.New_Shape21.mirror = false;
        this.New_Shape1 = new ModelRenderer(this, 24, 11);
        this.New_Shape1.addBox(-7.0F, 0.0F, 4.0F, 14, 6, 1, 0.0F);
        this.New_Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.New_Shape1.rotateAngleX = 0.0F;
        this.New_Shape1.rotateAngleY = 0.0F;
        this.New_Shape1.rotateAngleZ = 0.0F;
        this.New_Shape1.mirror = false;
        this.New_Shape11 = new ModelRenderer(this, 24, 11);
        this.New_Shape11.addBox(-7.0F, 0.0F, -5.0F, 14, 6, 1, 0.0F);
        this.New_Shape11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.New_Shape11.rotateAngleX = 0.0F;
        this.New_Shape11.rotateAngleY = 0.0F;
        this.New_Shape11.rotateAngleZ = 0.0F;
        this.New_Shape11.mirror = false;
        this.New_Shape3 = new ModelRenderer(this, 24, 20);
        this.New_Shape3.addBox(3.0F, 5.0F, -6.0F, 2, 2, 1, 0.0F);
        this.New_Shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.New_Shape3.rotateAngleX = 0.0F;
        this.New_Shape3.rotateAngleY = 0.0F;
        this.New_Shape3.rotateAngleZ = 0.0F;
        this.New_Shape3.mirror = false;
        this.New_Shape31 = new ModelRenderer(this, 24, 20);
        this.New_Shape31.addBox(-5.0F, 5.0F, -6.0F, 2, 2, 1, 0.0F);
        this.New_Shape31.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.New_Shape31.rotateAngleX = 0.0F;
        this.New_Shape31.rotateAngleY = 0.0F;
        this.New_Shape31.rotateAngleZ = 0.0F;
        this.New_Shape31.mirror = false;
        this.New_Shape311 = new ModelRenderer(this, 24, 20);
        this.New_Shape311.addBox(3.0F, 5.0F, 5.0F, 2, 2, 1, 0.0F);
        this.New_Shape311.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.New_Shape311.rotateAngleX = 0.0F;
        this.New_Shape311.rotateAngleY = 0.0F;
        this.New_Shape311.rotateAngleZ = 0.0F;
        this.New_Shape311.mirror = false;
        this.New_Shape3111 = new ModelRenderer(this, 24, 20);
        this.New_Shape3111.addBox(-5.0F, 5.0F, 5.0F, 2, 2, 1, 0.0F);
        this.New_Shape3111.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.New_Shape3111.rotateAngleX = 0.0F;
        this.New_Shape3111.rotateAngleY = 0.0F;
        this.New_Shape3111.rotateAngleZ = 0.0F;
        this.New_Shape3111.mirror = false;
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
        this.bottom.render(var7);
        this.back.render(var7);
        this.front.render(var7);
        this.New_Shape2.render(var7);
        this.New_Shape21.render(var7);
        this.New_Shape1.render(var7);
        this.New_Shape11.render(var7);
        this.New_Shape3.render(var7);
        this.New_Shape31.render(var7);
        this.New_Shape311.render(var7);
        this.New_Shape3111.render(var7);
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity e)
    {
        super.setRotationAngles(var1, var2, var3, var4, var5, var6, e);
    }
}

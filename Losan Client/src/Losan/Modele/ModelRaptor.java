package Losan.Modele;

import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelRaptor extends ModelBase//ajout
{
	//fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rcuisse;
    ModelRenderer leftarm1;
    ModelRenderer leftarm2;
    ModelRenderer rightarm1;
    ModelRenderer rightarm2;
    ModelRenderer cou;
    ModelRenderer bouche;
    ModelRenderer nez;
    ModelRenderer cretedessus;
    ModelRenderer cretederriere;
    ModelRenderer queue;
    ModelRenderer queue1;
    ModelRenderer queue2;
    ModelRenderer rightleg2;
    ModelRenderer rdoigt1;
    ModelRenderer rdoigt2;
    ModelRenderer rdoigt3;
    ModelRenderer leftleg2;
    ModelRenderer ldoigt1;
    ModelRenderer ldoigt2;
    ModelRenderer ldoigt3;
    ModelRenderer rcuisse2;
    ModelRenderer lcuisse;
    ModelRenderer lcuisse2;
    ModelRenderer queue3;
    ModelRenderer dentbas;
    ModelRenderer dentbas3;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer loeuil;
    ModelRenderer roeuil;
    ModelRenderer denthaut1;
    ModelRenderer denthaut3;
    ModelRenderer denthaut;
    ModelRenderer dentbas1;
  
  public ModelRaptor()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-1.5F, -3F, -6F, 3, 3, 8);
      head.setRotationPoint(0F, 7F, -12F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 11, 16);
      body.addBox(-3F, 0F, -1F, 6, 12, 2);
      body.setRotationPoint(0F, 9F, -7F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0.9294653F, 0F, 0F);
      rightarm = new ModelRenderer(this, 30, 16);
      rightarm.addBox(-0.5F, 0F, 0F, 1, 3, 1);
      rightarm.setRotationPoint(-2F, 11F, -6F);
      rightarm.setTextureSize(64, 32);
      rightarm.mirror = true;
      setRotation(rightarm, -0.8922821F, 0F, 0F);
      leftarm = new ModelRenderer(this, 30, 21);
      leftarm.addBox(-0.5F, -0.5F, 2F, 1, 1, 1);
      leftarm.setRotationPoint(2F, 11F, -6F);
      leftarm.setTextureSize(64, 32);
      leftarm.mirror = true;
      setRotation(leftarm, -2.67686F, 0F, 0F);
      rcuisse = new ModelRenderer(this, 0, 12);
      rcuisse.addBox(-0.5F, -1F, 0F, 1, 4, 2);
      rcuisse.setRotationPoint(-3F, 15F, -1F);
      rcuisse.setTextureSize(64, 32);
      rcuisse.mirror = true;
      setRotation(rcuisse, -0.5948578F, 0F, 0F);
      leftarm1 = new ModelRenderer(this, 30, 16);
      leftarm1.addBox(-0.5F, 0F, 0F, 1, 3, 1);
      leftarm1.setRotationPoint(2F, 11F, -6F);
      leftarm1.setTextureSize(64, 32);
      leftarm1.mirror = true;
      setRotation(leftarm1, -0.8922867F, 0F, 0F);
      leftarm2 = new ModelRenderer(this, 30, 24);
      leftarm2.addBox(-0.5F, 0.5F, 3F, 1, 1, 2);
      leftarm2.setRotationPoint(2F, 11F, -6F);
      leftarm2.setTextureSize(64, 32);
      leftarm2.mirror = true;
      setRotation(leftarm2, -2.67686F, 0F, 0F);
      rightarm1 = new ModelRenderer(this, 30, 21);
      rightarm1.addBox(-0.5F, -0.5F, 2F, 1, 1, 1);
      rightarm1.setRotationPoint(-2F, 11F, -6F);
      rightarm1.setTextureSize(64, 32);
      rightarm1.mirror = true;
      setRotation(rightarm1, -2.67686F, 0F, 0F);
      rightarm2 = new ModelRenderer(this, 30, 24);
      rightarm2.addBox(-0.5F, 0.5F, 3F, 1, 1, 2);
      rightarm2.setRotationPoint(-2F, 11F, -6F);
      rightarm2.setTextureSize(64, 32);
      rightarm2.mirror = true;
      setRotation(rightarm2, -2.67686F, 0F, 0F);
      cou = new ModelRenderer(this, 6, 12);
      cou.addBox(-0.5F, -1F, 0.4F, 1, 6, 1);
      cou.setRotationPoint(0F, 8F, -7F);
      cou.setTextureSize(64, 32);
      cou.mirror = true;
      setRotation(cou, -1.896109F, 0F, 0F);
      bouche = new ModelRenderer(this, 23, 1);
      bouche.addBox(-1.5F, 0F, -7F, 3, 1, 7);
      bouche.setRotationPoint(0F, 7F, -12F);
      bouche.setTextureSize(64, 32);
      bouche.mirror = true;
      setRotation(bouche, 0.2230717F, 0F, 0F);
      nez = new ModelRenderer(this, 0, 0);
      nez.addBox(-1.5F, -1F, -7F, 3, 1, 1);
      nez.setRotationPoint(0F, 7F, -12F);
      nez.setTextureSize(64, 32);
      nez.mirror = true;
      setRotation(nez, 0F, 0F, 0F);
      cretedessus = new ModelRenderer(this, 44, 3);
      cretedessus.addBox(-0.5F, -4F, -3F, 1, 1, 5);
      cretedessus.setRotationPoint(0F, 7F, -12F);
      cretedessus.setTextureSize(64, 32);
      cretedessus.mirror = true;
      setRotation(cretedessus, 0F, 0F, 0F);
      cretederriere = new ModelRenderer(this, 57, 5);
      cretederriere.addBox(-0.5F, -4F, 2F, 1, 3, 1);
      cretederriere.setRotationPoint(0F, 7F, -12F);
      cretederriere.setTextureSize(64, 32);
      cretederriere.mirror = true;
      setRotation(cretederriere, 0F, 0F, 0F);
      queue = new ModelRenderer(this, 50, 16);
      queue.addBox(-1F, 6F, -11F, 2, 4, 2);
      queue.setRotationPoint(0F, 9F, -7F);
      queue.setTextureSize(64, 32);
      queue.mirror = true;
      setRotation(queue, 2.007645F, 0F, 0F);
      queue1 = new ModelRenderer(this, 50, 16);
      queue1.addBox(-1F, 2F, -15.5F, 2, 4, 2);
      queue1.setRotationPoint(0F, 9F, -7F);
      queue1.setTextureSize(64, 32);
      queue1.mirror = true;
      setRotation(queue1, 2.714039F, 0F, 0F);
      queue2 = new ModelRenderer(this, 50, 25);
      queue2.addBox(-1F, 1.5F, 14.3F, 2, 4, 1);
      queue2.setRotationPoint(0F, 9F, -7F);
      queue2.setTextureSize(64, 32);
      queue2.mirror = true;
      setRotation(queue2, 0.6134471F, 0F, 0F);
      rightleg2 = new ModelRenderer(this, 0, 25);
      rightleg2.addBox(-0.5F, 1F, 6F, 1, 5, 1);
      rightleg2.setRotationPoint(-3F, 15F, -1F);
      rightleg2.setTextureSize(64, 32);
      rightleg2.mirror = true;
      setRotation(rightleg2, -1.041001F, 0F, 0F);
      rdoigt1 = new ModelRenderer(this, 6, 19);
      rdoigt1.addBox(-0.5F, 2F, 8F, 1, 3, 1);
      rdoigt1.setRotationPoint(-3F, 15F, -1F);
      rdoigt1.setTextureSize(64, 32);
      rdoigt1.mirror = true;
      setRotation(rdoigt1, -1.561502F, 0F, 0F);
      rdoigt2 = new ModelRenderer(this, 6, 25);
      rdoigt2.addBox(-0.5F, 2F, 8F, 1, 2, 1);
      rdoigt2.setRotationPoint(-3F, 15F, -1F);
      rdoigt2.setTextureSize(64, 32);
      rdoigt2.mirror = true;
      setRotation(rdoigt2, -1.561502F, -0.2230717F, 0F);
      rdoigt3 = new ModelRenderer(this, 6, 25);
      rdoigt3.addBox(-0.5F, 2F, 8F, 1, 2, 1);
      rdoigt3.setRotationPoint(-3F, 15F, -1F);
      rdoigt3.setTextureSize(64, 32);
      rdoigt3.mirror = true;
      setRotation(rdoigt3, -1.561502F, 0.2230717F, 0F);
      leftleg2 = new ModelRenderer(this, 0, 25);
      leftleg2.addBox(-0.5F, 1F, 6F, 1, 5, 1);
      leftleg2.setRotationPoint(3F, 15F, -1F);
      leftleg2.setTextureSize(64, 32);
      leftleg2.mirror = true;
      setRotation(leftleg2, -1.041001F, 0F, 0F);
      ldoigt1 = new ModelRenderer(this, 6, 19);
      ldoigt1.addBox(-0.5F, 2F, 8F, 1, 3, 1);
      ldoigt1.setRotationPoint(3F, 15F, -1F);
      ldoigt1.setTextureSize(64, 32);
      ldoigt1.mirror = true;
      setRotation(ldoigt1, -1.561502F, 0F, 0F);
      ldoigt2 = new ModelRenderer(this, 6, 25);
      ldoigt2.addBox(-0.5F, 2F, 8F, 1, 2, 1);
      ldoigt2.setRotationPoint(3F, 15F, -1F);
      ldoigt2.setTextureSize(64, 32);
      ldoigt2.mirror = true;
      setRotation(ldoigt2, -1.561502F, -0.2230717F, 0F);
      ldoigt3 = new ModelRenderer(this, 6, 25);
      ldoigt3.addBox(0.5F, 2F, 8F, 1, 2, 1);
      ldoigt3.setRotationPoint(2F, 15F, -1F);
      ldoigt3.setTextureSize(64, 32);
      ldoigt3.mirror = true;
      setRotation(ldoigt3, -1.561502F, 0.2230717F, 0F);
      rcuisse2 = new ModelRenderer(this, 0, 19);
      rcuisse2.addBox(-0.5F, 1F, -4F, 1, 4, 1);
      rcuisse2.setRotationPoint(-3F, 15F, -1F);
      rcuisse2.setTextureSize(64, 32);
      rcuisse2.mirror = true;
      setRotation(rcuisse2, 0.9666439F, 0F, 0F);
      lcuisse = new ModelRenderer(this, 0, 12);
      lcuisse.addBox(-0.5F, -1F, 0F, 1, 4, 2);
      lcuisse.setRotationPoint(3F, 15F, -1F);
      lcuisse.setTextureSize(64, 32);
      lcuisse.mirror = true;
      setRotation(lcuisse, -0.5948578F, 0F, 0F);
      lcuisse2 = new ModelRenderer(this, 0, 19);
      lcuisse2.addBox(-0.5F, 1F, -4F, 1, 4, 1);
      lcuisse2.setRotationPoint(3F, 15F, -1F);
      lcuisse2.setTextureSize(64, 32);
      lcuisse2.mirror = true;
      setRotation(lcuisse2, 0.9666439F, 0F, 0F);
      queue3 = new ModelRenderer(this, 50, 16);
      queue3.addBox(-1F, 0F, -16.7F, 2, 4, 2);
      queue3.setRotationPoint(0F, 9F, -7F);
      queue3.setTextureSize(64, 32);
      queue3.mirror = true;
      setRotation(queue3, 3.141593F, 0F, 0F);
      dentbas = new ModelRenderer(this, 35, 16);
      dentbas.addBox(-1.4F, -0.2F, -6.9F, 1, 1, 6);
      dentbas.setRotationPoint(0F, 7F, -12F);
      dentbas.setTextureSize(64, 32);
      dentbas.mirror = true;
      setRotation(dentbas, 0.2230717F, 0F, 0F);
      dentbas3 = new ModelRenderer(this, 35, 16);
      dentbas3.addBox(-0.5F, -0.2F, -6.9F, 1, 1, 1);
      dentbas3.setRotationPoint(0F, 7F, -12F);
      dentbas3.setTextureSize(64, 32);
      dentbas3.mirror = true;
      setRotation(dentbas3, 0.2230717F, 0F, 0F);
      body2 = new ModelRenderer(this, 13, 21);
      body2.addBox(-2F, 3F, -2F, 4, 7, 1);
      body2.setRotationPoint(0F, 9F, -7F);
      body2.setTextureSize(64, 32);
      body2.mirror = true;
      setRotation(body2, 0.9294653F, 0F, 0F);
      body3 = new ModelRenderer(this, 14, 20);
      body3.addBox(-1F, 2F, -2F, 2, 1, 1);
      body3.setRotationPoint(0F, 9F, -7F);
      body3.setTextureSize(64, 32);
      body3.mirror = true;
      setRotation(body3, 0.9294653F, 0F, 0F);
      loeuil = new ModelRenderer(this, 20, 1);
      loeuil.addBox(1F, -2F, -3F, 1, 1, 1);
      loeuil.setRotationPoint(0F, 7F, -12F);
      loeuil.setTextureSize(64, 32);
      loeuil.mirror = true;
      setRotation(loeuil, 0F, 0F, 0F);
      roeuil = new ModelRenderer(this, 16, 1);
      roeuil.addBox(-2F, -2F, -3F, 1, 1, 1);
      roeuil.setRotationPoint(0F, 7F, -12F);
      roeuil.setTextureSize(64, 32);
      roeuil.mirror = true;
      setRotation(roeuil, 0F, 0F, 0F);
      denthaut1 = new ModelRenderer(this, 35, 16);
      denthaut1.addBox(0.4F, -0.8F, -6.9F, 1, 1, 6);
      denthaut1.setRotationPoint(0F, 7F, -12F);
      denthaut1.setTextureSize(64, 32);
      denthaut1.mirror = true;
      setRotation(denthaut1, 0F, 0F, 0F);
      denthaut3 = new ModelRenderer(this, 35, 16);
      denthaut3.addBox(-0.5F, -0.8F, -6.9F, 1, 1, 1);
      denthaut3.setRotationPoint(0F, 7F, -12F);
      denthaut3.setTextureSize(64, 32);
      denthaut3.mirror = true;
      setRotation(denthaut3, 0F, 0F, 0F);
      denthaut = new ModelRenderer(this, 35, 16);
      denthaut.addBox(-1.4F, -0.8F, -6.9F, 1, 1, 6);
      denthaut.setRotationPoint(0F, 7F, -12F);
      denthaut.setTextureSize(64, 32);
      denthaut.mirror = true;
      setRotation(denthaut, 0F, 0F, 0F);
      dentbas1 = new ModelRenderer(this, 35, 16);
      dentbas1.addBox(0.4F, -0.2F, -6.9F, 1, 1, 6);
      dentbas1.setRotationPoint(0F, 7F, -12F);
      dentbas1.setTextureSize(64, 32);
      dentbas1.mirror = true;
      setRotation(dentbas1, 0.2230717F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    head.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rcuisse.render(f5);
    leftarm1.render(f5);
    leftarm2.render(f5);
    rightarm1.render(f5);
    rightarm2.render(f5);
    cou.render(f5);
    bouche.render(f5);
    nez.render(f5);
    cretedessus.render(f5);
    cretederriere.render(f5);
    queue.render(f5);
    queue1.render(f5);
    queue2.render(f5);
    rightleg2.render(f5);
    rdoigt1.render(f5);
    rdoigt2.render(f5);
    rdoigt3.render(f5);
    leftleg2.render(f5);
    ldoigt1.render(f5);
    ldoigt2.render(f5);
    ldoigt3.render(f5);
    rcuisse2.render(f5);
    lcuisse.render(f5);
    lcuisse2.render(f5);
    queue3.render(f5);
    dentbas.render(f5);
    dentbas3.render(f5);
    body2.render(f5);
    body3.render(f5);
    loeuil.render(f5);
    roeuil.render(f5);
    denthaut1.render(f5);
    denthaut3.render(f5);
    denthaut.render(f5);
    dentbas1.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
	 /*
	  leftleg.rotateAngleX = MathHelper.cos(f * 1.5F) * 1.5F * f1;
	  rightleg.rotateAngleX = MathHelper.cos(f * 1.5F + 3.141593F) * 1.5F * f1;
	  
	  leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.5F * f1;
	  rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.5F * f1;
	  
	  head.rotateAngleY = f4 / (200F / (float)Math.PI);
	  head.rotateAngleX = f5 / (200F / (float)Math.PI);
	  */
	  


	  lcuisse.rotateAngleX = (MathHelper.cos(f * 1.5F) * 1.5F * f1)-0.6F;
	  rcuisse.rotateAngleX = (MathHelper.cos(f * 1.5F + 3.141593F) * 1.5F * f1)-0.6F;
	 /*
	  leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.5F * f1;
	  rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.5F * f1;
     */
	 
	  lcuisse2.rotateAngleX= (MathHelper.cos(f * 1.5F) * 1.5F * f1)+0.9F;
	  leftleg2.rotateAngleX = (MathHelper.cos(f * 1.5F) * 1.5F * f1)-1.1F;
	  ldoigt1.rotateAngleX = (MathHelper.cos(f * 1.5F) * 1.5F * f1)-1.6F;
	  ldoigt2.rotateAngleX = (MathHelper.cos(f * 1.5F) * 1.5F * f1)-1.6F;
	  ldoigt3.rotateAngleX = (MathHelper.cos(f * 1.5F) * 1.5F * f1)-1.6F;
	  rcuisse2.rotateAngleX = (MathHelper.cos(f * 1.5F + 3.141593F) * 1.5F * f1)+0.9F;
	  rightleg2.rotateAngleX = (MathHelper.cos(f * 1.5F + 3.141593F) * 1.5F * f1)-1.1F;
	  rdoigt1.rotateAngleX = (MathHelper.cos(f * 1.5F + 3.141593F) * 1.5F * f1)-1.6F;
	  rdoigt2.rotateAngleX = (MathHelper.cos(f * 1.5F + 3.141593F) * 1.5F * f1)-1.6F;
	  rdoigt3.rotateAngleX = (MathHelper.cos(f * 1.5F + 3.141593F) * 1.5F * f1)-1.6F;
     /*
	  leftarm1.rotateAngleX = leftarm.rotateAngleX;
	  leftarm2.rotateAngleX = leftarm.rotateAngleX;
	  rightarm1.rotateAngleX = rightarm.rotateAngleX;
	  rightarm1.rotateAngleX = rightarm.rotateAngleX;
     */
	  
	  head.rotateAngleY = f4 / (180F / (float)Math.PI);
	  head.rotateAngleX = f5 / (180F / (float)Math.PI);
	 
	  nez.rotateAngleY = head.rotateAngleY;
	  nez.rotateAngleX = head.rotateAngleX;
	  bouche.rotateAngleX = (f5 / (180F / (float)Math.PI))+0.35F;
	  bouche.rotateAngleY = head.rotateAngleY;
	  dentbas.rotateAngleX = (f5 / (180F / (float)Math.PI))+0.35F;
	  dentbas.rotateAngleY = head.rotateAngleY;
	  dentbas1.rotateAngleX = (f5 / (180F / (float)Math.PI))+0.35F;
	  dentbas1.rotateAngleY = head.rotateAngleY;
	  dentbas3.rotateAngleX = (f5 / (180F / (float)Math.PI))+0.35F;
	  dentbas3.rotateAngleY = head.rotateAngleY;
	  
	  denthaut.rotateAngleX = (f5 / (180F / (float)Math.PI));
	  denthaut.rotateAngleY = head.rotateAngleY;
	  denthaut1.rotateAngleX = (f5 / (180F / (float)Math.PI));
	  denthaut1.rotateAngleY = head.rotateAngleY;
	  denthaut3.rotateAngleX = (f5 / (180F / (float)Math.PI));
	  denthaut3.rotateAngleY = head.rotateAngleY;
	  
	  loeuil.rotateAngleX = head.rotateAngleX;
	  loeuil.rotateAngleY = head.rotateAngleY;
	  roeuil.rotateAngleX = head.rotateAngleX;
	  roeuil.rotateAngleY = head.rotateAngleY;
      
	  cretedessus.rotateAngleY = head.rotateAngleY;
	  cretederriere.rotateAngleX = head.rotateAngleX;
	  cretedessus.rotateAngleX = head.rotateAngleX;
	  cretederriere.rotateAngleY = head.rotateAngleY;
 
	  queue.rotateAngleY = (MathHelper.cos(f/2 * 3.5F) * f1/2);
      queue1.rotateAngleY = (MathHelper.cos(f/2 * 3.5F) * f1/2);
      queue2.rotateAngleY = (MathHelper.cos(f/2 * 3.5F) * f1/2);
      queue3.rotateAngleY = (MathHelper.cos(f/2 * 3.5F) * f1/2);
      
  }

}
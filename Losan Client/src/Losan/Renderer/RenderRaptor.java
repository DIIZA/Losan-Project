
package Losan.Renderer;

import Losan.Entity.EntityRaptor;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;

public class RenderRaptor extends RenderLiving //ajout
{
	public RenderRaptor(ModelBase modelbase, float f)
	{
		super(modelbase, f);
	}

	
	public void renderCow(EntityRaptor entityraptor, double d, double d1, double d2, float f, float f1)
	{
		super.doRenderLiving(entityraptor, d, d1, d2, f, f1);
	}
	

	public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1)
	{
		renderCow((EntityRaptor)entityliving, d, d1, d2, f, f1);
	}

	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
	{
		renderCow((EntityRaptor)entity, d, d1, d2, f, f1);
	}
}



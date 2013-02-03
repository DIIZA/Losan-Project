package Losan.Entity;

import org.lwjgl.input.Keyboard;

import Losan.Modele.ModelVoiture;

import net.minecraft.client.Minecraft;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ModelBase;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.World;

public class EntityVoiture extends Entity{

	
	public int fuel;
    public int currentDamage;
    public int timeSinceHit;
    public int rockDirection;
    public double speed;
    float maxSpeed;
    float accel;
    float turn;
    public String texture;
    private Minecraft mc;
    public boolean send;
    private double velocityX;
    private double velocityY;
    private double velocityZ;
    
    private EntityVoiture V1;
    private EntityVoiture V2;
    
    public EntityVoiture(World var1)
    {
        super(var1);  
        this.fuel = 0;
        this.speed = 0.0D;
        this.preventEntitySpawning = true;
        this.accel = 0.2F;
        this.turn = 3.0F;
        this.maxSpeed = 2.5F;
        this.speed = 0.0D;
        this.texture = "/mob/car.png";
        this.setSize(1.2F, 1.6F);        
        this.stepHeight = 1.2F;
        this.yOffset = this.height / 2.0F+0.2F;
        
        this.currentDamage = 18;
        this.timeSinceHit = 19;
        this.rockDirection = 20;
        this.dataWatcher.addObject(this.currentDamage, new Integer(0));
        this.dataWatcher.addObject(this.timeSinceHit, new Integer(0));
        this.dataWatcher.addObject(this.rockDirection, new Integer(1));
        this.send = false;
    }
    
    public EntityVoiture(World var1, double x, double y, double z)
    {
        super(var1);
        this.fuel = 0;
        this.speed = 0.0D;
        this.preventEntitySpawning = true;
        this.accel = 0.2F;
        this.turn = 3.0F;
        this.maxSpeed = 2.5F;
        this.speed = 0.0D;
        this.texture = "/mob/car.png";
        this.setSize(1.2F, 1.6F);        
        this.stepHeight = 1.2F;
        
        this.currentDamage = 18;
        this.timeSinceHit = 19;
        this.rockDirection = 20;
        this.dataWatcher.addObject(this.currentDamage, new Integer(0));
        this.dataWatcher.addObject(this.timeSinceHit, new Integer(0));
        this.dataWatcher.addObject(this.rockDirection, new Integer(1));
        this.yOffset = this.height / 2.0F+0.2F;
        this.setPosition((double)x, (double)y + (double)this.yOffset, (double)z);
        this.send = false;
//        System.out.println(this.entityId);
    }

    
    public void setDead()
 

   {

    	super.setDead();

    }

	
    public ModelBase getModel()
    {
        return new ModelVoiture();
    }

    protected void entityInit()
    {

    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        return false;
    }

    /**
     * Returns a boundingBox used to collide the entity with other entities and blocks. This enables the entity to be
     * pushable on contact, like boats or minecarts.
     */
    public AxisAlignedBB getCollisionBox(Entity var1)
    {
        return var1.boundingBox;
    }

    /**
     * returns the bounding box for this entity
     */
    public AxisAlignedBB getBoundingBox()
    {
        return this.boundingBox;
    }

    /**
     * Returns true if this entity should push and be pushed by other entities when colliding.
     */
    public boolean canBePushed()
    {
        return false;
    }

    /**
     * Returns the Y offset from the entity's position for any entity riding this one.
     */
    public double getMountedYOffset()
    {
        return - 0.3D;
    }

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    public boolean canBeCollidedWith()
    {
        return !this.isDead;
    }

    public void updateRiderPosition()
    {
        if (this.riddenByEntity != null)
        {
            double var1 = Math.cos((double)this.rotationYaw * Math.PI / 180.0D) * 0.4D;
            double var3 = Math.sin((double)this.rotationYaw * Math.PI / 180.0D) * 0.4D;
            this.riddenByEntity.setPosition(this.posX + var1, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ + var3);
        }
    }

    /**
     * Setups the entity to do the hurt animation. Only used by packets in multiplayer.
     */
    public void performHurtAnimation()
    {
        this.dataWatcher.updateObject(this.rockDirection, Integer.valueOf(-this.dataWatcher.getWatchableObjectInt(this.rockDirection)));
        this.dataWatcher.updateObject(this.timeSinceHit, Integer.valueOf(10));
        this.dataWatcher.updateObject(this.currentDamage, Integer.valueOf(this.dataWatcher.getWatchableObjectInt(this.currentDamage) * 5));
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource var1, int var2)
    {
        boolean var3 = false;

//        if (this.isDead)
//        {
//            return true;
//        }
//        else
//        {
        if (!this.worldObj.isRemote && !this.isDead)
        {
        	if (this.func_85032_ar())
        	{
        		return false;
        	}
        	else
        	{
        		this.dataWatcher.updateObject(this.rockDirection, Integer.valueOf(-this.dataWatcher.getWatchableObjectInt(this.rockDirection)));
        		this.dataWatcher.updateObject(this.timeSinceHit, Integer.valueOf(10));
        		this.dataWatcher.updateObject(this.currentDamage, Integer.valueOf(this.dataWatcher.getWatchableObjectInt(this.currentDamage) + var2 * 5));
        		this.setBeenAttacked();


        		if (this.dataWatcher.getWatchableObjectInt(this.currentDamage) > 1 )
        		{
        			if (this.riddenByEntity != null)
        			{
        				this.riddenByEntity.mountEntity(this);
        			}

        			if (!this.worldObj.isRemote)
        			{
        				this.dropItemWithOffset(Item.carEmpty.shiftedIndex, 1, 0.0F);
        				this.setDead();            		
        			}
        		}
        	}
            
        }
        return true;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
    	super.onUpdate();              
       
    	if (this.mc != null && this.mc.theWorld != null)
    	{
    		
//            if (this.worldObj instanceof WorldServer && this.mc.theWorld.getEntityByID(this.entityId) == null)
//            {
//                EntityVoiture var1 = new EntityVoiture(this.mc.theWorld);
//                var1.setPosition(this.posX, this.posY, this.posZ);
//                this.mc.theWorld.addEntityToWorld(this.entityId, var1);
//            }
//            
//            if (this.worldObj instanceof WorldServer)
//              {
//            	EntityVoiture var19 = (EntityVoiture)this.mc.theWorld.getEntityByID(this.entityId);
//                  var19.setPositionAndRotation(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
//                  var19.setVelocity(this.motionX, this.motionY, this.motionZ);
//                  var19.speed = this.speed;
//              }

    	}
    	
    	if (this.dataWatcher.getWatchableObjectInt(this.timeSinceHit) > 0)
		{
			this.dataWatcher.updateObject(this.timeSinceHit, Integer.valueOf(this.dataWatcher.getWatchableObjectInt(this.timeSinceHit) - 1));
		}

		if (this.dataWatcher.getWatchableObjectInt(this.currentDamage) > 0)
		{
			this.dataWatcher.updateObject(this.currentDamage, Integer.valueOf(this.dataWatcher.getWatchableObjectInt(this.currentDamage) - 1));
		}
    	
        this.rotationYaw %= 360.0F;
        this.rotationPitch %= 360.0F;
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        byte var20 = 5;
        double var2 = 0.0D;
        int var4;

        for (var4 = 0; var4 < var20; ++var4)
        {
            double var5 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (double)(var4 + 0) / (double)var20 - 0.125D;
            double var7 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (double)(var4 + 1) / (double)var20 - 0.125D;
        }

        double var21;

        if (var2 < 1.0D)
        {
            var21 = var2 * 2.0D - 1.0D;
            this.motionY += 0.04D * var21;
        }
//        else
//        {
//            if (this.motionY < 0.0D)
//            {
//                this.motionY /= 2.0D;
//            }
//
//            this.motionY += 0.007D;
//        }

       
        if (this.riddenByEntity != null && (this.inWater))
        {
            this.dropItem(Item.carEmpty.shiftedIndex, 1);
            this.setDead();
        }
        
        
        if (this.riddenByEntity != null)
        {
            if (Keyboard.isKeyDown(Keyboard.KEY_Q))
            {
            	if(this.speed <0)
            		this.rotationYaw = (float)((double)this.rotationYaw + (double)this.turn * (1.0D + this.speed / 2.0D));
            	else
            		this.rotationYaw = (float)((double)this.rotationYaw - (double)this.turn * (1.5D + this.speed / 2.0D));
            }

            if (Keyboard.isKeyDown(Keyboard.KEY_D))
            {
            	if(this.speed <0)
            		this.rotationYaw = (float)((double)this.rotationYaw - (double)this.turn * (1.0D + this.speed / 2.0D));
            	else
            		this.rotationYaw = (float)((double)this.rotationYaw + (double)this.turn * (1.5D + this.speed / 2.0D));
            }

            if (Keyboard.isKeyDown(Keyboard.KEY_Z) /*&& this.fuel > 0*/)
            {
                this.speed += 0.02D;
            }

            if (Keyboard.isKeyDown(Keyboard.KEY_S) /*&& this.fuel > 0*/)
            {
                this.speed -= 0.01D;
            }

            if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
            {
                this.speed *= 0.75D;
            }

//            this.fuel = (int)((double)this.fuel - this.speed);
            
        }
        else
        {
            this.speed *= 0.9D;
        }

        if (this.inWater && this.speed > 0.2D)
        {
            this.worldObj.playSoundEffect((double)((float)this.posX), (double)((float)this.posY), (double)((float)this.posZ), "random.fizz", 0.5F, 2.6F + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.8F);
        }

        this.speed *= 0.98D;

        if (this.speed > (double)this.maxSpeed)
        {
            this.speed = (double)this.maxSpeed;
        }

        if (this.isCollidedHorizontally)
        {
            this.speed = 0.0D;
        }

        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && Keyboard.isKeyDown(Keyboard.KEY_C))
        {
            EntityPlayer var23 = (EntityPlayer)this.riddenByEntity;

        }

        this.motionX = -(this.speed * Math.cos((double)this.rotationYaw * Math.PI / 180.0D));
        this.motionZ = -(this.speed * Math.sin((double)this.rotationYaw * Math.PI / 180.0D));
        var21 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);

        if (var21 > 0.15D)
        {
            double var24 = Math.cos((double)this.rotationYaw * Math.PI / 180.0D);
            double var8 = Math.sin((double)this.rotationYaw * Math.PI / 180.0D);

            for (int var10 = 0; (double)var10 < 1.0D + var21 * 60.0D; ++var10)
            {
                double var11 = (double)(this.rand.nextFloat() * 2.0F - 1.0F);
                double var13 = (double)(this.rand.nextInt(2) * 2 - 1) * 0.7D;

                if (!this.rand.nextBoolean())
                {
                    double var15 = this.posX + var24 + var8 * var11 * 0.7D;
                    double var17 = this.posZ + var8 - var24 * var11 * 0.7D;
                    this.worldObj.spawnParticle("smoke", var15, this.posY - 0.125D, var17, this.motionX, this.motionY, this.motionZ);
                }
            }
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);       
    }
    


    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound var1)
    {
        this.fuel = var1.getInteger("Fuel");
        NBTTagList var2 = var1.getTagList("Items");
        
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound var1)
    {
        var1.setInteger("fuel", this.fuel);
        NBTTagList var2 = new NBTTagList();

        var1.setTag("Items", var2);
    }

    /**
     * Returns the number of slots in the inventory.
    
    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer var1)
    {

        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != var1)
        {
            return true;
        }

        if (!this.worldObj.isRemote)
        {
//        	var1.setPosition(this.posX+1, this.posY, this.posZ);
        	var1.mountEntity(this);
        	
        }
            return true;
        
    }

    public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9)
    {
//        this.posX = par1;
//        this.posY = par3;
//        this.posZ = par5;
        this.rotationYaw = par7;
        this.rotationPitch = par8;
        this.turn = 3.0F;
//        this.motionX = this.velocityX;
//        this.motionY = this.velocityY;
//        this.motionZ = this.velocityZ;
    }

    /**
     * Sets the velocity to the args. Args: x, y, z
     */
//    public void setVelocity(double par1, double par3, double par5)
//    {
////        this.velocityX = this.motionX = par1;
////        this.velocityY = this.motionY = par3;
////        this.velocityZ = this.motionZ = par5;
//    }
	
}

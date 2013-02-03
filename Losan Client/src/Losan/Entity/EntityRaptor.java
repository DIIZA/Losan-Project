
package Losan.Entity;

import net.minecraft.src.EntityAIAttackOnCollide;
import net.minecraft.src.EntityAIBreakDoor;
import net.minecraft.src.EntityAIHurtByTarget;
import net.minecraft.src.EntityAILookIdle;
import net.minecraft.src.EntityAIMoveThroughVillage;
import net.minecraft.src.EntityAIMoveTwardsRestriction;
import net.minecraft.src.EntityAINearestAttackableTarget;
import net.minecraft.src.EntityAISwimming;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityChicken;
import net.minecraft.src.EntityCow;
import net.minecraft.src.EntityCreeper;
import net.minecraft.src.EntityEnderman;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityPig;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntitySheep;
import net.minecraft.src.EntitySkeleton;
import net.minecraft.src.EntitySpider;
import net.minecraft.src.EntityVillager;
import net.minecraft.src.EntityWolf;
import net.minecraft.src.EntityZombie;
import net.minecraft.src.EnumCreatureAttribute;
import net.minecraft.src.Item;
import net.minecraft.src.World;

public class EntityRaptor extends EntityMob
{
	public EntityRaptor(World par1World)//ajout
	{
		super(par1World);
		this.texture = "/mob/Raptor.png";
		this.moveSpeed = 0.45F;
		//        this.attackStrength = 6;
		this.attackTime = 6;
		//this.yOffset = 0.8F;
		this.setSize(1.1F, 0.8F);
		this.getNavigator().setBreakDoors(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIBreakDoor(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, true));
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityVillager.class, this.moveSpeed, true));
		this.tasks.addTask(4, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
		this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, this.moveSpeed, false));
		this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWolf.class, 16.0F, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityCow.class, 16.0F, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySheep.class, 16.0F, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityChicken.class, 16.0F, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPig.class, 16.0F, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityCreeper.class, 16.0F, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySkeleton.class, 16.0F, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityZombie.class, 16.0F, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySpider.class, 16.0F, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityEnderman.class, 16.0F, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 16.0F, 0, false));
	}

	public int getMaxHealth()
	{
		return 40;
	}

	/**
	 * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
	 */
	public int getTotalArmorValue()
	{
		return 4;
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	protected boolean isAIEnabled()
	{
		return true;
	}

	private boolean getSaddle(){

		return true;
	}

	public boolean interact(EntityPlayer entityplayer)    
	// cette fonction sert a mettre une interaction avec le joueur, ici on pourra le monter :) en mettant sur true la fonction private boolean suivante.
	{
		if (!worldObj.isRemote && !super.interact(entityplayer))
		{
			entityplayer.mountEntity(this);
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	public void onLivingUpdate()
	{
		if (this.worldObj.isDaytime() && !this.worldObj.isRemote)
		{
			float var1 = this.getBrightness(1.0F);
		}
		super.onLivingUpdate();
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound()
	{
		return "mob.raptor";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{
		return "mob.raptorhurt";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "mob.raptordeath";
	}

	protected float getSoundVolume()
	{
		return 0.4F;
	}

	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	protected int getDropItemId()
	{
		return Item.beefRaw.shiftedIndex;
	}

	protected void dropFewItems(boolean par1, int par2)
	{
		int var3 = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);
		int var4;

		for (var4 = 0; var4 < var3; ++var4)
		{
			this.dropItem(Item.lezardSkin.shiftedIndex, 1);
		}

		var3 = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + par2);

		for (var4 = 0; var4 < var3; ++var4)
		{
			if (this.isBurning())
			{
				this.dropItem(Item.beefCooked.shiftedIndex, 1);
			}
			else
			{
				this.dropItem(Item.beefRaw.shiftedIndex, 1);
			}
		}
	}

	/**
	 * Get this Entity's EnumCreatureAttribute
	 */
	 public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEAD;
	}

	 public EntityRaptor spawnBabyAnimal(EntityAnimal entityanimal) {
		 return new EntityRaptor(worldObj);
	 }
}



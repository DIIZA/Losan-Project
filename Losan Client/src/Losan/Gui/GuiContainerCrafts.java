package Losan.Gui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.GuiAchievements;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiInventory;
import net.minecraft.src.GuiStats;
import net.minecraft.src.GuiTextField;
import net.minecraft.src.InventoryBasic;
import net.minecraft.src.InventoryEffectRenderer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.RenderHelper;
import net.minecraft.src.Slot;
import net.minecraft.src.StatCollector;
import Losan.Container.ContainerCrafts;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import Losan.Container.ContainerFut;
import Losan.Inventory.InventoryCrafts;
import Losan.Utils.CraftingFinder;

public class GuiContainerCrafts extends InventoryEffectRenderer //ajout
{
	private static InventoryBasic inventory = new InventoryBasic("tmp", 45);
	private static int field_74241_p = CreativeTabs.tabBlock.getTabIndex();

	GuiButton btn_GuiTeleport;//ajout
	GuiButton btn_GuiBoutique;//ajout
	GuiButton btn_GuiInv;//ajout
	GuiButton btn_GuiShop;//ajout
	public ContainerCrafts contCrafts;

	/** Amount scrolled in Creative mode inventory (0 = top, 1 = bottom) */
	private float currentScroll = 0.0F;

	/** True if the scrollbar is being dragged */
	private boolean isScrolling = false;
	private int guiTop;

	/**
	 * True if the left mouse button was held down last time drawScreen was called.
	 */
	private boolean wasClicking;
	private GuiTextField field_74237_t;
	//    private List field_74236_u;
	//    private Slot field_74235_v = null;
	private boolean field_74234_w = false;
	public int time;
	public boolean vide;
	public int lastDamage;
	public boolean last;
	public int lastTime;
	public int recipe;
	private int cook;
	public int base;

	private EntityPlayer p;

	public GuiContainerCrafts(EntityPlayer par1EntityPlayer)
	{
		super(new ContainerCrafts(par1EntityPlayer));
		par1EntityPlayer.openContainer = this.inventorySlots;
		this.allowUserInput = false;
		this.ySize = 190;
		this.xSize = 195;
		this.p = par1EntityPlayer;
		this.guiTop = 25;
		this.contCrafts = par1EntityPlayer.contCrafts;
		this.time = 0;
		this.vide = true;
		this.lastDamage =0;
		this.last=true;
		this.lastTime =0;
		this.recipe = 0;
		this.cook = 0;
		this.base = 0;
	}

	/**
	 * Called from the main game loop to update the screen.
	 */
	 public void updateScreen()
	{
		if (!p.isEntityAlive() || p.isDead)
		{
			p.closeScreen();
		}
		if (!this.vide)
		{
			this.contCrafts.slotCrafts.resetSlot();
			this.vide = true;
		}
		if(this.contCrafts.slotRef.getId() != null)
		{			
			if(this.time >= 50)
				this.time = 0;
			this.time++;
			if(this.lastTime >= 425)
				this.lastTime = 1;
			this.lastTime++;
			if(this.cook >= 45)
				this.cook = 0;
			this.cook++;
			if(this.base >= 200)
				this.base = 0;
			this.base++;
			this.recipe = 0;
			ItemStack ref = this.contCrafts.slotRef.getId();
			CraftingFinder.set(this, ref);
		}
	}

	 protected void handleMouseClick(Slot par1Slot, int par2, int par3, int par4)
	 {
		 this.field_74234_w = true;
		 ItemStack var6;
		 InventoryCrafts var9;
		 this.last=true;
		 this.lastTime = 0;
		 if (!this.vide)
		 {
			 this.contCrafts.slotCrafts.resetSlot();
			 this.vide = true;
		 }
		 if (par1Slot != null)
		 {
			 int var5;
			 ItemStack var7;
			 if (par1Slot.inventory == inventory)
			 {
				 var9 = this.contCrafts.slotRef;
				 var6 = var9.getItemStack();
				 var7 = par1Slot.getStack();
				 if (var7 != null && var6 == null)
				 {
					 boolean var8 = false;
					 if (!var8)
					 {
						 var9.setItemStack(ItemStack.copyItemStack(var7));
						 var6 = var9.getItemStack();
						 if (par4 == 2)
						 {
							 var6.stackSize = var6.getMaxStackSize();
						 }
					 }
				 }
				 else
				 {
					 boolean var8 = false;
					 if (!var8)
					 {
						 var9.setItemStack(ItemStack.copyItemStack(var7));
						 var6 = var9.getItemStack();
						 if (par4 == 3)
						 {
							 var6.stackSize = var6.getMaxStackSize();
						 }
					 }
				 }
			 }
		 }
		 else
		 {
			 var9 = this.contCrafts.slotRef;
			 if (var9.getItemStack() != null)
			 {
				 if (par3 == 0)
				 {
					 this.mc.playerController.func_78752_a(var9.getItemStack());
					 var9.setItemStack((ItemStack)null);
				 }
				 if (par3 == 1)
				 {
					 var6 = var9.getItemStack().splitStack(1);
					 this.mc.playerController.func_78752_a(var6);

					 if (var9.getItemStack().stackSize == 0)
					 {
						 var9.setItemStack((ItemStack)null);
					 }
				 }
			 }
		 }
	 }

	 public void initGui()
	 {
		 super.initGui();
		 int i;
//		 if(!this.mc.thePlayer.getActivePotionEffects().isEmpty())
//			 i = 160 + (width - xSize -200) / 2;
//		 else
			 i = (this.width - this.xSize) / 2;
		 int j = (this.height - this.ySize) / 2;
		 this.controlList.clear();
		 Keyboard.enableRepeatEvents(true);
		 this.field_74237_t = new GuiTextField(this.fontRenderer, i + 80, j + 5, 89, this.fontRenderer.FONT_HEIGHT+1);
		 this.field_74237_t.setMaxStringLength(15);
		 this.field_74237_t.setEnableBackgroundDrawing(true);
		 this.field_74237_t.setVisible(true);
		 this.field_74237_t.setTextColor(16777215);
		 this.func_74227_b(CreativeTabs.tabAllSearch);
		 btn_GuiTeleport= new GuiButton(2, i+195, j, 67, 20, StatCollector.translateToLocal("Téléportation")); 
		 controlList.add(btn_GuiTeleport);
		 btn_GuiBoutique= new GuiButton(3, i+195, j+20, 67, 20, StatCollector.translateToLocal("Commerce"));
		 controlList.add(btn_GuiBoutique);
		 btn_GuiInv= new GuiButton(4, i+195, j+60, 67, 20, StatCollector.translateToLocal("Inventaire"));
		 controlList.add(btn_GuiInv);
		 btn_GuiShop= new GuiButton(5, i+195, j+40, 67, 20, StatCollector.translateToLocal("Boutique"));
		 controlList.add(btn_GuiShop);
		 
//		 controlList.add(new GuiButton(10, i+195, j+80, 67, 20, "Profils"));
	 }

	  public void onGuiClosed()
	  {
		  super.onGuiClosed();
		  Keyboard.enableRepeatEvents(false);
	  }

	  protected void keyTyped(char par1, int par2)
	  {
		  if (this.field_74234_w)
		  {
			  this.field_74234_w = false;
			  this.field_74237_t.setText("");
		  }
		  if (this.field_74237_t.textboxKeyTyped(par1, par2))
		  {
			  this.updateCreativeSearch();
		  }
		  else
		  {
			  super.keyTyped(par1, par2);
		  }
	  }

	  private void updateCreativeSearch()
	  {
		  ContainerCrafts var1 = (ContainerCrafts)this.inventorySlots;
		  var1.itemList.clear();
		  Item[] var2 = Item.itemsList;
		  int var3 = var2.length;
		  for (int var4 = 0; var4 < var3; ++var4)
		  {
			  Item var5 = var2[var4];

			  if (var5 != null && var5.getCreativeTab() != null)
			  {
				  var5.getSubItems(var5.shiftedIndex, (CreativeTabs)null, var1.itemList);
			  }
		  }
		  Iterator var8 = var1.itemList.iterator();
		  String var9 = this.field_74237_t.getText().toLowerCase();
		  while (var8.hasNext())
		  {
			  ItemStack var10 = (ItemStack)var8.next();
			  boolean var11 = false;
			  Iterator var6 = var10.getTooltip(this.mc.thePlayer, this.mc.gameSettings.advancedItemTooltips).iterator();
			  while (true)
			  {
				  if (var6.hasNext())
				  {
					  String var7 = (String)var6.next();
					  if (!var7.toLowerCase().contains(var9))
					  {
						  continue;
					  }
					  var11 = true;
				  }
				  if (!var11)
				  {
					  var8.remove();
				  }
				  break;
			  }
		  }
		  this.currentScroll = 0.0F;
		  var1.scrollTo(0.0F);
	  }

	  protected void drawGuiContainerForegroundLayer(int par1, int par2){
		  CreativeTabs var1 = CreativeTabs.tabAllSearch;
		  if (var1.drawInForegroundOfTab())
		  {
			  this.fontRenderer.drawString("Recherche: ", 8, 6, 4210752);
		  }
	  }

	  protected void mouseClicked(int par1, int par2, int par3)
	  {
		  super.mouseClicked(par1, par2, par3);
	  }

	  private boolean needsScrollBars()
	  {
		  return field_74241_p != CreativeTabs.tabInventory.getTabIndex() && CreativeTabs.creativeTabArray[field_74241_p].shouldHidePlayerInventory() && ((ContainerCrafts)this.inventorySlots).hasMoreThan1PageOfItemsInList();
	  }

	  private void func_74227_b(CreativeTabs par1CreativeTabs)
	  {
		  int var2 = field_74241_p;
		  field_74241_p = par1CreativeTabs.getTabIndex();
		  ContainerCrafts var3 = (ContainerCrafts)this.inventorySlots;
		  var3.itemList.clear();
		  par1CreativeTabs.displayAllReleventItems(var3.itemList);
		  if (this.field_74237_t != null)
		  {
			  if (par1CreativeTabs == CreativeTabs.tabAllSearch)
			  {
				  this.field_74237_t.setVisible(true);
				  this.field_74237_t.setCanLoseFocus(false);
				  this.field_74237_t.setFocused(true);
				  this.field_74237_t.setText("");
				  this.updateCreativeSearch();
			  }
			  else
			  {
				  this.field_74237_t.setVisible(false);
				  this.field_74237_t.setCanLoseFocus(true);
				  this.field_74237_t.setFocused(false);
			  }
		  }
		  this.currentScroll = 0.0F;
		  var3.scrollTo(0.0F);
	  }

	  public void handleMouseInput()
	  {
		  super.handleMouseInput();
		  int var1 = Mouse.getEventDWheel();
		  if (var1 != 0 && this.needsScrollBars())
		  {
			  int var2 = ((ContainerCrafts)this.inventorySlots).itemList.size() / 9 - 5 + 1;
			  if (var1 > 0)
			  {
				  var1 = 1;
			  }
			  if (var1 < 0)
			  {
				  var1 = -1;
			  }
			  this.currentScroll = (float)((double)this.currentScroll - (double)var1 / (double)var2);
			  if (this.currentScroll < 0.0F)
			  {
				  this.currentScroll = 0.0F;
			  }
			  if (this.currentScroll > 0.78F)
			  {
				  this.currentScroll = 0.78F;
			  }
			  ((ContainerCrafts)this.inventorySlots).scrollTo(this.currentScroll);
		  }
	  }

	  public void drawScreen(int par1, int par2, float par3)
	  {
		  boolean var4 = Mouse.isButtonDown(0);
		  int var5 = this.guiLeft;
		  int var6 = this.guiTop;
		  int var7 = var5 + 175;
		  int var8 = var6 + 18;
		  int var9 = var7 + 14;
		  int var10 = var8 + 112;
		  if (!this.wasClicking && var4 && par1 >= var7 && par2 >= var8 && par1 < var9 && par2 < var10)
		  {
			  this.isScrolling = this.needsScrollBars();
		  }
		  if (!var4)
		  {
			  this.isScrolling = false;
		  }
		  this.wasClicking = var4;
		  if (this.isScrolling)
		  {
			  this.currentScroll = ((float)(par2 - var8) - 7.5F) / ((float)(var10 - var8) - 15.0F);
			  if (this.currentScroll < 0.0F)
			  {
				  this.currentScroll = 0.0F;
			  }
			  if (this.currentScroll > 0.78)
			  {
				  this.currentScroll = 0.78F;
			  }
			  ((ContainerCrafts)this.inventorySlots).scrollTo(this.currentScroll);
		  }
		  super.drawScreen(par1, par2, par3);
		  GL11.glEnable(GL11.GL_LIGHTING);
		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		  GL11.glEnable(GL11.GL_LIGHTING);
	  }

	  protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	  {
		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		  RenderHelper.enableGUIStandardItemLighting();
		  int var4 = this.mc.renderEngine.getTexture("/gui/crafts.png");
		  CreativeTabs var5 = CreativeTabs.tabAllSearch;
		  int var6;
		  if(this.recipe == 1)
			  var6 = this.mc.renderEngine.getTexture("/gui/creative_inv/craftsFour.png");
		  else if(this.recipe == 2)
			  var6 = this.mc.renderEngine.getTexture("/gui/creative_inv/craftsFreezer.png");
		  else if(this.recipe == 3)
			  var6 = this.mc.renderEngine.getTexture("/gui/creative_inv/craftsFut.png");
		  else
			  var6 = this.mc.renderEngine.getTexture("/gui/creative_inv/crafts.png");

		  CreativeTabs var10 = CreativeTabs.tabAllSearch;
		  CreativeTabs[] var7 = CreativeTabs.creativeTabArray;
		  int var8 = var7.length;
		  int var9;
		  this.func_74233_a(var10);
//		  if(!this.mc.thePlayer.getActivePotionEffects().isEmpty())
//			  this.guiLeft = 160 + (this.width - this.xSize -200) / 2;
//		  else
			  this.guiLeft = (this.width - this.xSize) / 2;
		  this.guiTop = (this.height - this.ySize) / 2;
		  this.mc.renderEngine.bindTexture(var6);
		  this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		  if(this.recipe !=0){
			  int var15 = (this.cook/2);
			  this.drawTexturedModalRect(this.guiLeft + 93, this.guiTop + 139,this.xSize, 15,var15 + 1, 167);
		  }
		  this.field_74237_t.drawTextBox();
		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		  int var11 = this.guiLeft + 175;
		  var8 = this.guiTop + 18;
		  var9 = var8 + 112;
		  this.mc.renderEngine.bindTexture(var4);
		  if (var5.shouldHidePlayerInventory())
		  {
			  this.drawTexturedModalRect(var11, var8 + (int)((float)(var9 - var8 - 17) * this.currentScroll), 232 + (this.needsScrollBars() ? 0 : 12), 0, 12, 15);
		  }
		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		  GL11.glEnable(GL11.GL_LIGHTING);
		  this.func_74233_a(var5);
	  }

	  protected boolean func_74232_a(CreativeTabs par1CreativeTabs, int par2, int par3)
	  {
		  int var4 = par1CreativeTabs.getTabColumn();
		  int var5 = 28 * var4;
		  byte var6 = 0;
		  if (var4 == 5)
		  {
			  var5 = this.xSize - 28 + 2;
		  }
		  else if (var4 > 0)
		  {
			  var5 += var4;
		  }
		  int var7;
		  if (par1CreativeTabs.isTabInFirstRow())
		  {
			  var7 = var6 - 32;
		  }
		  else
		  {
			  var7 = var6 + this.ySize;
		  }
		  return par2 >= var5 && par2 <= var5 + 28 && par3 >= var7 && par3 <= var7 + 32;
	  }

	  protected boolean renderCreativeInventoryHoveringText(CreativeTabs par1CreativeTabs, int par2, int par3)
	  {
		  int var4 = par1CreativeTabs.getTabColumn();
		  int var5 = 28 * var4;
		  byte var6 = 0;
		  if (var4 == 5)
		  {
			  var5 = this.xSize - 28 + 2;
		  }
		  else if (var4 > 0)
		  {
			  var5 += var4;
		  }
		  int var7;
		  if (par1CreativeTabs.isTabInFirstRow())
		  {
			  var7 = var6 - 32;
		  }
		  else
		  {
			  var7 = var6 + this.ySize;
		  }
		  if (this.func_74188_c(var5 + 3, var7 + 3, 23, 27, par2, par3))
		  {
			  this.drawCreativeTabHoveringText(par1CreativeTabs.getTranslatedTabLabel(), par2, par3);
			  return true;
		  }
		  else
		  {
			  return false;
		  }
	  }

	  protected void func_74233_a(CreativeTabs par1CreativeTabs)
	  {
		  GL11.glDisable(GL11.GL_LIGHTING);
		  this.zLevel = 100.0F;
		  itemRenderer.zLevel = 100.0F;
		  GL11.glEnable(GL11.GL_LIGHTING);
		  GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		  int i;
//		  if(!this.mc.thePlayer.getActivePotionEffects().isEmpty())
//			  i = 160 + (width - xSize -200) / 2;
//		  else
			  i = (width - xSize) / 2;
		  int j = (height - ySize) / 2;
		  ItemStack var10 = new ItemStack(Block.workbench);
		  if(this.recipe == 1){
			  var10 = new ItemStack(Block.stoneOvenActive);
			  itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i+26, j+139);
			  itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i+26, j+139);
		  }
		  else if(this.recipe == 2){
			  var10 = new ItemStack(Block.freezera);
			  itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i+26, j+139);
			  itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i+26, j+139);
		  }
		  else if(this.recipe == 3){
			  var10 = new ItemStack(Block.fut);
			  itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i+18, j+139);
			  itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i+18, j+139);
		  }else{
			  itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i+10, j+139);
			  itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i+10, j+139);
		  }
		  GL11.glDisable(GL11.GL_LIGHTING);
		  itemRenderer.zLevel = 0.0F;
		  this.zLevel = 0.0F;
	  }


	  protected void actionPerformed(GuiButton par1GuiButton)
	  {
		  if (par1GuiButton.id == 0)
		  {
			  this.contCrafts.slotRef.resetSlot();
			  this.contCrafts.slotCrafts.resetSlot();
			  this.mc.thePlayer.potion = false;
			  this.mc.displayGuiScreen(new GuiAchievements(this.mc.statFileWriter));
		  }
		  if (par1GuiButton.id == 1)
		  {
			  this.contCrafts.slotRef.resetSlot();
			  this.contCrafts.slotCrafts.resetSlot();
			  this.mc.thePlayer.potion = false;
			  this.mc.displayGuiScreen(new GuiStats(this, this.mc.statFileWriter));
		  }
		  if (par1GuiButton.id == 2)
		  {
			  this.contCrafts.slotRef.resetSlot();
			  this.contCrafts.slotCrafts.resetSlot();
			  this.mc.thePlayer.potion = false;
			  this.mc.displayGuiScreen(new GuiTeleport(this.mc, this.mc.thePlayer));
		  }
		  if (par1GuiButton.id == 3)
		  {
			  this.contCrafts.slotRef.resetSlot();
			  this.contCrafts.slotCrafts.resetSlot();
			  this.mc.thePlayer.potion = false;
			  this.mc.displayGuiScreen(new GuiBoutique(this.mc.thePlayer, this.mc));       
			  if(this.mc.theWorld.isRemote){
			//	  this.mc.getSendQueue().addToSendQueue(new Packet133Money(this.mc.thePlayer));
			  }
		  }  
		  if (par1GuiButton.id == 4)
		  {
			  this.contCrafts.slotRef.resetSlot();
			  this.contCrafts.slotCrafts.resetSlot();
			  this.mc.thePlayer.potion = false;
			  this.mc.displayGuiScreen(new GuiInventory(this.mc.thePlayer));       
		  }  
		  if (par1GuiButton.id == 5)
		  {
			  this.contCrafts.slotRef.resetSlot();
			  this.contCrafts.slotCrafts.resetSlot();
			  this.mc.thePlayer.potion = true;
			  this.mc.displayGuiScreen(new GuiContainerShop(this.mc.thePlayer));
		  }
		  
//	        if(par1GuiButton.id == 10)
//	        {
//	  		  this.contCrafts.slotRef.resetSlot();
//			  this.contCrafts.slotCrafts.resetSlot();
//			  this.mc.thePlayer.potion = true;
//			  this.mc.displayGuiScreen(new GuiProfils(this.mc.thePlayer, this.mc));
//	        }
	  }

	   public int func_74230_h()
	   {
		   return field_74241_p;
	   }

	   public static InventoryBasic getInventory()
	   {
		   return inventory;
	   }

	   public ItemStack setSmelt()
	   {
		   if(counterHexa1() >21)
			   this.time = this.lastTime = 0;
		   ItemStack[] itemStack = {new ItemStack(Item.coal), new ItemStack(Block.wood), new ItemStack(Block.planks), new ItemStack(Block.woodSingleSlab), new ItemStack(Block.sapling), new ItemStack(Item.swordWood), new ItemStack(Block.pressurePlatePlanks), new ItemStack(Item.stick), new ItemStack(Block.fence), new ItemStack(Block.stairCompactPlanks), new ItemStack(Block.trapdoor), new ItemStack(Block.workbench), new ItemStack(Block.bookShelf), new ItemStack(Block.chest), new ItemStack(Block.jukebox), new ItemStack(Block.music), new ItemStack(Block.mushroomCapBrown) ,new ItemStack(Block.mushroomCapRed), new ItemStack(Item.blazeRod), new ItemStack(Item.bucketLava)};
		   return itemStack[counterHexa1()];
	   }

	   public ItemStack setFreeze()
	   {
		   if(counterHexa1() >3)
			   this.time = this.lastTime = 0;
		   ItemStack[] itemStack = {new ItemStack(Block.blockSnow), new ItemStack(Block.ice), new ItemStack(Block.oreRedstone), new ItemStack(Item.emerald)};
		   return itemStack[counterHexa1()];
	   }

	   public int counterHexa()
	   {
		   int x = 0;
		   if(this.lastTime<=25)
			   x = 0;
		   if(this.lastTime>25)
			   x = 1;
		   if(this.lastTime>50)
			   x = 2;
		   if(this.lastTime>75)
			   x = 3;
		   if(this.lastTime>100)
			   x = 4;
		   if(this.lastTime>125)
			   x = 5;
		   if(this.lastTime>150)
			   x = 6;
		   if(this.lastTime>175)
			   x = 7;
		   if(this.lastTime>200)
			   x = 8;
		   if(this.lastTime>225)
			   x = 9;
		   if(this.lastTime>250)
			   x = 10;
		   if(this.lastTime>275)
			   x = 11;
		   if(this.lastTime>300)
			   x = 12;
		   if(this.lastTime>325)
			   x = 13;
		   if(this.lastTime>350)
			   x = 14;
		   if(this.lastTime>400)
			   x = 15;
		   return x;
	   }

	   private int counterHexa1()
	   {
		   int x = 0;
		   if(this.lastTime<=25/2)
			   x = 0;
		   if(this.lastTime>25/2)
			   x = 1;
		   if(this.lastTime>50/2)
			   x = 2;
		   if(this.lastTime>75/2)
			   x = 3;
		   if(this.lastTime>100/2)
			   x = 4;
		   if(this.lastTime>125/2)
			   x = 5;
		   if(this.lastTime>150/2)
			   x = 6;
		   if(this.lastTime>175/2)
			   x = 7;
		   if(this.lastTime>200/2)
			   x = 8;
		   if(this.lastTime>225/2)
			   x = 9;
		   if(this.lastTime>250/2)
			   x = 10;
		   if(this.lastTime>275/2)
			   x = 11;
		   if(this.lastTime>300/2)
			   x = 12;
		   if(this.lastTime>325/2)
			   x = 13;
		   if(this.lastTime>350/2)
			   x = 14;
		   if(this.lastTime>400/2)
			   x = 15;
		   if(this.lastTime>425/2)
			   x = 16;
		   if(this.lastTime>450/2)
			   x = 17;
		   if(this.lastTime>475/2)
			   x = 18;
		   if(this.lastTime>500/2)
			   x = 19;
		   if(this.lastTime>525/2)
			   x = 20;
		   if(this.lastTime>550/2)
			   x = 21;
		   if(this.lastTime>575/2)
			   x = 22;
		   if(this.lastTime>600/2)
			   x = 23;
		   if(this.lastTime>625/2)
			   x = 24;
		   if(this.lastTime>250/2)
			   x = 25;
		   if(this.lastTime>675/2)
			   x = 26;
		   if(this.lastTime>700/2)
			   x = 27;
		   if(this.lastTime>725/2)
			   x = 28;
		   if(this.lastTime>750/2)
			   x = 29;
		   return x;
	   }
}

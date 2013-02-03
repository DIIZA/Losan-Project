package Losan.Gui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.src.Block;
import net.minecraft.src.Container;
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

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import Losan.Container.ContainerShop;
import Losan.Inventory.InventoryShop;
import Losan.Slot.SlotShopInventory;

public class GuiContainerShop extends InventoryEffectRenderer //ajout
{
	
	private ItemStack[] blackList = {/*new ItemStack(Item.septreSP), new ItemStack(Item.septreRedstone), new ItemStack(Item.septreOr), new ItemStack(Item.septreLapis), new ItemStack(Item.septreEmeraude),*/ new ItemStack(Item.monsterPlacer), new ItemStack(Item.expBottle), new ItemStack(Block.endPortalFrame), new ItemStack(Block.mycelium), new ItemStack(Block.deadBush), new ItemStack(Block.tallGrass), new ItemStack(Block.melon), new ItemStack(Block.ice), /*new ItemStack(Block.football),*/ new ItemStack(Block.dragonEgg), new ItemStack(Block.cobblestoneMossy), new ItemStack(Block.crops), new ItemStack(Block.web), new ItemStack(Block.sponge), new ItemStack(Block.grass), new ItemStack(Block.sapling), new ItemStack(Block.bedrock), new ItemStack(Block.oreCoal), new ItemStack(Block.oreDiamond), new ItemStack(Block.oreEmerald), new ItemStack(Block.oreGold), new ItemStack(Block.oreIron), new ItemStack(Block.oreLapis), new ItemStack(Block.oreRedstone), new ItemStack(Block.oreRedstoneGlowing)};

	
	private GuiTextField prix;
	private GuiTextField quantite;
	private GuiTextField money;
	
	private List field_74236_u;
	
	private static InventoryBasic inventory = new InventoryBasic("tmp", 45);
	private static int field_74241_p = CreativeTabs.tabBlock.getTabIndex();

	GuiButton btn_GuiTeleport;//ajout
	GuiButton btn_GuiBoutique;//ajout
	GuiButton btn_GuiInv;//ajout
	GuiButton btn_GuiCrafts;//ajout
	GuiButton btn_Buy;//ajout
	
	private GuiCheckBox check1;
	private GuiCheckBox check2;
	
	public ContainerShop contShop;

	/** Amount scrolled in Creative mode inventory (0 = top, 1 = bottom) */
	private float currentScroll = 0.0F;

	/** True if the scrollbar is being dragged */
	private boolean isScrolling = false;
	private int guiTop;
	
	private boolean erreur;
	private boolean remove;
	private String message;

	/**
	 * True if the left mouse button was held down last time drawScreen was called.
	 */
	private boolean wasClicking;
	private GuiTextField field_74237_t;
	//    private List field_74236_u;
	private Slot field_74235_v = null;
	private boolean field_74234_w = false;
	boolean vide;

	private EntityPlayer p;

	public GuiContainerShop(EntityPlayer par1EntityPlayer)
	{
		super(new ContainerShop(par1EntityPlayer));
		par1EntityPlayer.openContainer = this.inventorySlots;
		this.allowUserInput = false;
		this.ySize = 190;
		this.xSize = 195;
		this.p = par1EntityPlayer;
		this.guiTop = 25;
		this.contShop = par1EntityPlayer.contShop;
		this.vide = true;
		this.erreur = false;
		this.remove = true;
		this.message = "";
	}

	/**
	 * Called from the main game loop to update the screen.
	 */
	 public void updateScreen()
	{
		if (!p.isEntityAlive() || p.isDead)
		{
			this.contShop.slotRef.resetSlot();
			p.closeScreen();
		}
		if(this.contShop.slotRef.getId() != null)
		{			
		}

			
	}

	 protected void handleMouseClick(Slot par1Slot, int par2, int par3, int par4)
	 {
		 this.field_74234_w = true;
		 ItemStack var6;
		 InventoryShop var9;
		 if (!this.vide)
		 {
			 this.contShop.slotRef.resetSlot();
			 this.vide = true;
		 }
		 if (par1Slot != null)
		 {
			 int var5;

			 if (par1Slot == this.field_74235_v && ((par4 == 2) || (par4 == 3)))
			 {
				 for (var5 = 0; var5 < this.mc.thePlayer.inventoryContainer.getInventory().size(); ++var5)
				 {
					 this.mc.playerController.sendSlotPacket((ItemStack)null, var5);
				 }
			 }
			 else
			 {
				 ItemStack var7;
				 if (field_74241_p == CreativeTabs.tabInventory.getTabIndex())
				 {
					 if (par1Slot == this.field_74235_v)
					 {
						 this.mc.thePlayer.inventory.setItemStack((ItemStack)null);
					 }
				 }
				 else if (par1Slot.inventory == inventory)
				 {
					 var9 = this.contShop.slotRef;
					 var6 = var9.getItemStack();
					 var7 = par1Slot.getStack();
					 if (var7 != null && var6 == null)
					 {
						 boolean var8 = false;
						 if (!var8)
						 {
							 boolean valide = true;
							 ItemStack id = ItemStack.copyItemStack(var7); 
							 for(ItemStack x: this.blackList)
							 {

								 if(x.getItem()==id.getItem()){
									 valide = false;
								 }
							 }
							 if(valide){
								 var9.setItemStack(ItemStack.copyItemStack(var7));
								 var6 = var9.getItemStack();
								 if (par4 == 2)
								 {
									 var6.stackSize = var6.getMaxStackSize();
								 }
							 }else{
								 this.erreur = true;
								 this.message = "Cet item n'est pas à vendre";
								 this.contShop.slotRef.resetSlot();
							 }
						 }
					 }
					 else
					 {
						 boolean var8 = false;
						 if (!var8)
						 {
							 boolean valide = true;
							 ItemStack id = ItemStack.copyItemStack(var7); 
							 for(ItemStack x: this.blackList)
							 {

								 if(x.getItem()==id.getItem()){
									 valide = false;
								 }
							 }
							 if(valide){
								 var9.setItemStack(ItemStack.copyItemStack(var7));
								 var6 = var9.getItemStack();
								 if (par4 == 3)
								 {
									 var6.stackSize = var6.getMaxStackSize();
								 }
							 }else{
								 this.erreur = true;
								 this.message = "Cet item n'est pas à vendre";
								 this.contShop.slotRef.resetSlot();
							 }
						 }
					 }
				 }
			 }
		 }
		 else
		 {
			 var9 = this.contShop.slotRef;
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
		 btn_GuiCrafts= new GuiButton(5, i+195, j+40, 67, 20, StatCollector.translateToLocal("Les crafts"));
		 controlList.add(btn_GuiCrafts);
		 btn_Buy= new GuiButton(6, i+125, j+150, 67, 20, StatCollector.translateToLocal("Acheter"));
		 controlList.add(btn_Buy);
		 
		 this.check1 = new GuiCheckBox(7, i + 60, j + 145);
		 controlList.add(check1);
		 this.check2 = new GuiCheckBox(8, i + 60, j + 155);
		 controlList.add(check2);
		 
		 controlList.add(new GuiInvisibleButton(9, i + 60, j + 144));
		 controlList.add(new GuiInvisibleButton(10, i + 60, j + 154));
		 
//		 controlList.add(new GuiButton(11, i+195, j+80, 67, 20, "Profils"));
		
		 
		 this.check1.drawButton1(this.mc, 0, 0, true);
		 
		 this.prix = new GuiTextField(this.fontRenderer, i + 4, j + 120, 50, 10);
		 this.prix.setText("");
		 this.prix.setMaxStringLength(20);
		 this.prix.setEnableBackgroundDrawing(true);
		 this.prix.setVisible(true);
		 this.prix.setTextColor(0x00ff00);

		 this.quantite = new GuiTextField(this.fontRenderer, i + 4, j + 148, 50, 10);
		 this.quantite.setText("1");
		 this.quantite.setMaxStringLength(10);
		 this.quantite.setEnableBackgroundDrawing(true);
		 this.quantite.setVisible(true);
		 this.quantite.setTextColor(0xffffff);

		 this.money = new GuiTextField(this.fontRenderer, i + 4, j + 174, 187, 10);
		 this.money.setText(String.valueOf(this.mc.thePlayer.money)+" LS");
		 this.money.setMaxStringLength(100);
		 this.money.setEnableBackgroundDrawing(true);
		 this.money.setVisible(true);
		 this.money.setTextColor(0x00ff00);
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
		  if(this.quantite.textboxKeyTyped(par1, par2))
			  ;
		  else if (this.field_74237_t.textboxKeyTyped(par1, par2))
		  {
			  this.func_74228_j();
		  }
		  else
		  {
			  
			  super.keyTyped(par1, par2);
		  }
	  }

	  private void func_74228_j()
	  {
		  ContainerShop var1 = (ContainerShop)this.inventorySlots;
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
		  if (par3 == 0)
	        {
	            int var4 = par1;
	            int var5 = par2;
	            CreativeTabs[] var6 = CreativeTabs.creativeTabArray;
				 int i;
//				 if(!this.mc.thePlayer.getActivePotionEffects().isEmpty())
//					 i = 160 + (width - xSize -200) / 2;
//				 else
					 i = (this.width - this.xSize) / 2;
				 int j = (this.height - this.ySize) / 2;
	                
	                int x = this.func_74232_a(var4, var5);
	                if(x != 15){
	                	CreativeTabs var9 = var6[x];
	                	for(int a=0;a<45;a++)
	                		this.getInventory().setInventorySlotContents(a, null);
	                    this.func_74227_b(var9);
	                    return;
	                }
	        }
		  if(this.erreur)
			  this.erreur = false;
		  this.mc.theWorld.playSoundAtEntity(this.mc.thePlayer, "random.click", 0.2F, (1.2F * 0.7F + 1.0F) * 2.0F);
		  super.mouseClicked(par1, par2, par3);
		  
			if(this.remove)
			{
				if(this.quantite.mouseClickedSP1(par1, par2, par3, this.quantite));
				
			}
		  
	  }

	  private boolean needsScrollBars()
	  {
		  return field_74241_p != CreativeTabs.tabInventory.getTabIndex() && CreativeTabs.creativeTabArray[field_74241_p].shouldHidePlayerInventory() && ((ContainerShop)this.inventorySlots).hasMoreThan1PageOfItemsInList();
	  }

	  private void func_74227_b(CreativeTabs par1CreativeTabs)
	  {

		  int var2 = field_74241_p;
		  field_74241_p = par1CreativeTabs.getTabIndex();
		  ContainerShop var3 = (ContainerShop)this.inventorySlots;
		  var3.itemList.clear();
		  par1CreativeTabs.displayAllReleventItems(var3.itemList);

		  if (par1CreativeTabs == CreativeTabs.tabInventory)
		  {
			  Container var4 = this.mc.thePlayer.inventoryContainer;

			  if (this.field_74236_u == null)
			  {
				  this.field_74236_u = var3.inventorySlots;
			  }

			  var3.inventorySlots = new ArrayList();

			  for (int var5 = 0; var5 < var4.inventorySlots.size(); ++var5)
			  {
				  SlotShopInventory var6 = new SlotShopInventory(this, (Slot)var4.inventorySlots.get(var5), var5);
				  var3.inventorySlots.add(var6);
				  int var7;
				  int var8;
				  int var9;

				  if (var5 >= 5 && var5 < 9)
				  {
					  var7 = var5 - 5;
					  var8 = var7 / 2;
					  var9 = var7 % 2;
					  var6.xDisplayPosition = 9 + var8 * 54;
					  var6.yDisplayPosition = 6 + var9 * 27;
				  }
				  else if (var5 >= 0 && var5 < 5)
				  {
					  var6.yDisplayPosition = -2000;
					  var6.xDisplayPosition = -2000;
				  }
				  else if (var5 < var4.inventorySlots.size())
				  {
					  var7 = var5 - 9;
					  var8 = var7 % 9;
					  var9 = var7 / 9;
					  var6.xDisplayPosition = 9 + var8 * 18;

					  if (var5 >= 36)
					  {
						  var6.yDisplayPosition = 112;
					  }
					  else
					  {
						  var6.yDisplayPosition = 54 + var9 * 18;
					  }
				  }
			  }

			  this.field_74235_v = new Slot(inventory, 0, 173, 112);
			  var3.inventorySlots.add(this.field_74235_v);
		  }
		  else if (var2 == CreativeTabs.tabInventory.getTabIndex())
		  {
			  var3.inventorySlots = this.field_74236_u;
			  this.field_74236_u = null;
		  }

		  if (this.field_74237_t != null)
		  {
			  if (par1CreativeTabs == CreativeTabs.tabAllSearch)
			  {
				  this.field_74237_t.setVisible(true);
				  this.field_74237_t.setCanLoseFocus(false);
				  this.field_74237_t.setFocused(true);
				  this.field_74237_t.setText("");
				  this.func_74228_j();
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
			  int var2 = ((ContainerShop)this.inventorySlots).itemList.size() / 9 - 5 + 1;
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
			  ((ContainerShop)this.inventorySlots).scrollTo(this.currentScroll);
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
			  ((ContainerShop)this.inventorySlots).scrollTo(this.currentScroll);
		  }
		  super.drawScreen(par1, par2, par3);
		  
	        CreativeTabs[] var11 = CreativeTabs.creativeTabArray;
	        int var12 = var11.length;

	        for (int var13 = 0; var13 < var12; ++var13)
	        {
	            CreativeTabs var14 = var11[var13];
	            int x = this.func_74231_b(par1, par2);
	            if(x == 15)
	            	break;
	            if (var14 == var11[x])
	            {
	            	this.drawCreativeTabHoveringText(var14.getTranslatedTabLabel(), par1, par2);
	                break;
	            }
	        }
	        
	  
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

			  var6 = this.mc.renderEngine.getTexture("/gui/creative_inv/shop.png");

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
		  
		  this.prix.drawTextBox();
		  this.quantite.drawTextBox();
		  this.money.drawTextBox();
		  
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
		  
		  var4 = this.mc.renderEngine.getTexture("/gui/creative_inv/shopBoutons.png");
		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			 int i;
//			 if(!this.mc.thePlayer.getActivePotionEffects().isEmpty())
//				 i = 160 + (width - xSize -200) / 2;
//			 else
				 i = (this.width - this.xSize) / 2;
			 int j = (this.height - this.ySize) / 2;
			 
		  this.mc.renderEngine.bindTexture(var4);
		  this.drawTexturedModalRect(i-100, j+9, 0, 0, 70, 180);
		  
		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		  GL11.glEnable(GL11.GL_LIGHTING);
		  this.func_74233_a(var5);
		  
		  if(this.erreur)
				this.fontRenderer.drawString(this.message, (i+this.xSize/2)-this.message.length()*2, j-10, 0xff0000);
			else
				this.fontRenderer.drawString("", i+10, j-10, 0xff0000);
		  
		  this.fontRenderer.drawString(StatCollector.translateToLocal("prix"), i + 4, j + 110, 0xffffff);
		  this.fontRenderer.drawString(StatCollector.translateToLocal("quantité"), i + 4, j + 138, 0xffffff);
		  this.fontRenderer.drawString(StatCollector.translateToLocal("mon argent"), i + 4, j + 164, 0xffffff);
		  
			if(this.check1.enabled)
				this.fontRenderer.drawString(StatCollector.translateToLocal("unité"), i+70, j+144, 0xffff00);
			else
				this.fontRenderer.drawString(StatCollector.translateToLocal("unité"), i+70, j+144, 0xffffff);
			if(this.check2.enabled)
				this.fontRenderer.drawString("stack", i+70, j+154, 0xffff00);
			else
				this.fontRenderer.drawString("stack", i+70, j+154, 0xffffff);
	  }

	  protected int func_74232_a(int par2, int par3)
	  {   
	   	 int i;
//		 if(!this.mc.thePlayer.getActivePotionEffects().isEmpty())
//			 i = 160 + (width - xSize -200) / 2;
//		 else
			 i = (this.width - this.xSize) / 2;
		 int j = (this.height - this.ySize) / 2;
		 int verif = 15;

		 if(par2>= i-100 && par2 <= i-32 && par3>= j+9 && par3 <= j+27){
				 verif = 5;
		 }
		 else if(par2>= i-100 && par2 <= i-71 && par3>= j+39 && par3 <= j+57){
			 verif = 0;
		 }
		 else if(par2>= i-59 && par2 <= i-32 && par3>= j+39 && par3 <= j+57){
			 verif = 1;
		 }
		 else if(par2>= i-100 && par2 <= i-71 && par3>= j+69 && par3 <= j+87){
				 verif = 2;
		 }
		 else if(par2>= i-59 && par2 <= i-32 && par3>= j+69 && par3 <= j+87){
			 verif = 3;
		 } 
		 else if(par2>= i-100 && par2 <= i-71 && par3>= j+99 && par3 <= j+117){
				 verif = 4;
		 } 
		 else if(par2>= i-59 && par2 <= i-32 && par3>= j+99 && par3 <= j+117){
			 verif = 6;
		 }
		 else if(par2>= i-100 && par2 <= i-71 && par3>= j+129 && par3 <= j+147){
				 verif = 7;
		 } 
		 else if(par2>= i-59 && par2 <= i-32 && par3>= j+129 && par3 <= j+147){
			 verif = 8;
		 }
		 else if(par2>= i-100 && par2 <= i-71 && par3>= j+159 && par3 <= j+177){
				 verif = 9;
		 }
		 else if(par2>= i-59 && par2 <= i-32 && par3>= j+159 && par3 <= j+177){
			 verif = 10;
		 }
		 
	        return verif;
	  }

	  protected int func_74231_b(int par2, int par3)
	  {
		  int i;
//			 if(!this.mc.thePlayer.getActivePotionEffects().isEmpty())
//				 i = 160 + (width - xSize -200) / 2;
//			 else
				 i = (this.width - this.xSize) / 2;
			 int j = (this.height - this.ySize) / 2;
			 int verif = 15;

			 if(par2>= i-100 && par2 <= i-32 && par3>= j+9 && par3 <= j+27){
					 verif = 5;
			 }
			 else if(par2>= i-100 && par2 <= i-71 && par3>= j+39 && par3 <= j+57){
				 verif = 0;
			 }
			 else if(par2>= i-59 && par2 <= i-32 && par3>= j+39 && par3 <= j+57){
				 verif = 1;
			 }
			 else if(par2>= i-100 && par2 <= i-71 && par3>= j+69 && par3 <= j+87){
					 verif = 2;
			 }
			 else if(par2>= i-59 && par2 <= i-32 && par3>= j+69 && par3 <= j+87){
				 verif = 3;
			 } 
			 else if(par2>= i-100 && par2 <= i-71 && par3>= j+99 && par3 <= j+117){
					 verif = 4;
			 } 
			 else if(par2>= i-59 && par2 <= i-32 && par3>= j+99 && par3 <= j+117){
				 verif = 6;
			 }
			 else if(par2>= i-100 && par2 <= i-71 && par3>= j+129 && par3 <= j+147){
					 verif = 7;
			 } 
			 else if(par2>= i-59 && par2 <= i-32 && par3>= j+129 && par3 <= j+147){
				 verif = 8;
			 }
			 else if(par2>= i-100 && par2 <= i-71 && par3>= j+159 && par3 <= j+177){
					 verif = 9;
			 }
			 else if(par2>= i-59 && par2 <= i-32 && par3>= j+159 && par3 <= j+177){
				 verif = 10;
			 }
			 
		        return verif;
		  
			  
			
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
		  ItemStack var10;
		  i=i+7;
		  j=j+10;
		  var10 = new ItemStack(Item.compass);
		  itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i-100, j);
		  itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i-100, j);

		  var10 = new ItemStack(Block.brick);
		  itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i-100, j+30);
		  itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i-100, j+30);

		  var10 = new ItemStack(Block.plantRed);
		  itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i-60, j+30);
		  itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i-60, j+30);

		  var10 = new ItemStack(Item.redstone);
		  itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i-100, j+60);
		  itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i-100, j+60);

		  var10 = new ItemStack(Block.railPowered);
		  itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i-60, j+60);
		  itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i-60, j+60);

		  var10 = new ItemStack(Item.bucketLava);
		  itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i-100, j+90);
		  itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i-100, j+90);

		  var10 = new ItemStack(Item.appleRed);
		  itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i-60, j+90);
		  itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i-60, j+90);

		  var10 = new ItemStack(Item.axeSteel);
		  itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i-100, j+120);
		  itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i-100, j+120);

		  var10 = new ItemStack(Item.swordGold);
		  itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i-60, j+120);
		  itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i-60, j+120);

		  var10 = new ItemStack(Item.potion, 1, 0);
		  itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i-100, j+150);
		  itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i-100, j+150);

		  var10 = new ItemStack(Item.stick);
		  itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i-60, j+150);
		  itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc.renderEngine, var10, i-60, j+150);

		  GL11.glDisable(GL11.GL_LIGHTING);
		  itemRenderer.zLevel = 0.0F;
		  this.zLevel = 0.0F;
	  }


	  protected void actionPerformed(GuiButton par1GuiButton)
	  {
		  boolean inv = false;
		  if (par1GuiButton.id == 0)
		  {
			  this.contShop.slotRef.resetSlot();
			  this.mc.thePlayer.potion = false;
			  this.mc.displayGuiScreen(new GuiAchievements(this.mc.statFileWriter));
		  }
		  if (par1GuiButton.id == 1)
		  {
			  this.contShop.slotRef.resetSlot();
			  this.mc.thePlayer.potion = false;
			  this.mc.displayGuiScreen(new GuiStats(this, this.mc.statFileWriter));
		  }
		  if (par1GuiButton.id == 2)
		  {
			  this.contShop.slotRef.resetSlot();
			  this.mc.thePlayer.potion = false;
			  this.mc.displayGuiScreen(new GuiTeleport(this.mc, this.mc.thePlayer));
		  }
		  if (par1GuiButton.id == 3)
		  {
			  this.contShop.slotRef.resetSlot();
			  this.mc.thePlayer.potion = false;
			  this.mc.displayGuiScreen(new GuiBoutique(this.mc.thePlayer, this.mc));       
			  if(this.mc.theWorld.isRemote){
				//  this.mc.getSendQueue().addToSendQueue(new Packet133Money(this.mc.thePlayer));
			  }
		  }  
		  if (par1GuiButton.id == 4)
		  {
			  this.contShop.slotRef.resetSlot();
			  this.mc.thePlayer.potion = false;
			  this.mc.displayGuiScreen(new GuiInventory(this.mc.thePlayer));       
		  } 
		  if (par1GuiButton.id == 5)
		  {
			  this.contShop.slotRef.resetSlot();
			  this.mc.thePlayer.potion = true;
			  this.mc.displayGuiScreen(new GuiContainerCrafts(this.mc.thePlayer));       
		  }
		  
		  if (par1GuiButton.id == 7 || par1GuiButton.id == 9)
		  {
			  this.check1.drawButton1(this.mc, 0, 0, !inv);
			  this.check2.drawButton1(this.mc, 0, 0, inv);
			  this.remove = true;
		  }
		  if (par1GuiButton.id == 8 || par1GuiButton.id == 10)
		  {
			  this.check2.drawButton1(this.mc, 0, 0, !inv);
			  this.check1.drawButton1(this.mc, 0, 0, inv);
			  this.remove = true;      
		  }

		  if (par1GuiButton.id == 6)
		  {
			  String ID = this.contShop.slotRef.getId();
			  
			  String type;
				
				if(this.quantite.getText().equals("") || this.quantite.getText().equals("_"))
					this.quantite.setText("1");


				if(this.check1.enabled)
					type = "unite";
				else 
					type = "stack";
				
				if(ID == null){
					this.erreur = true;
					this.message = "Tu doit choisir quelque chose à acheter";
					return;
				}
				if(this.mc.thePlayer.money <= 0){
					this.message = "Tu n'as pas assez d'argent";
					this.erreur = true;
					return;
				}
			  mc.thePlayer.sendChatMessage("/shop "+type+" "+ID);
			  mc.thePlayer.closeScreen();
			  this.mc.thePlayer.potion = false;
		  }
//          if(par1GuiButton.id == 11)
//          {
//          	this.mc.thePlayer.potion = true;
//          	this.mc.displayGuiScreen(new GuiProfils(this.mc.thePlayer, this.mc));
//          }
		  
		  
		  
	  }

	   public int func_74230_h()
	   {
		   return field_74241_p;
	   }

	   public static InventoryBasic getInventory()
	   {
		   return inventory;
	   }

}

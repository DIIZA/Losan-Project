package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import Losan.Gui.GuiBoutique;
import Losan.Gui.GuiContainerCrafts;
import Losan.Gui.GuiContainerShop;
import Losan.Gui.GuiTeleport;

public class GuiInventory extends InventoryEffectRenderer
{
	GuiButton btn_GuiTeleport;//ajout
	GuiButton btn_GuiBoutique;//ajout
	GuiButton btn_GuiCraft;//ajout
	GuiButton btn_GuiShop;//ajout
	GuiButton btn_scsDebug;//ajout
	
    /**
     * x size of the inventory window in pixels. Defined as float, passed as int
     */
    private float xSize_lo;

    /**
     * y size of the inventory window in pixels. Defined as float, passed as int.
     */
    private float ySize_lo;

    public GuiInventory(EntityPlayer par1EntityPlayer)
    {
        super(par1EntityPlayer.inventoryContainer);
        this.allowUserInput = true;
        par1EntityPlayer.addStat(AchievementList.openInventory, 1);
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        if (this.mc.playerController.isInCreativeMode())
        {
            this.mc.displayGuiScreen(new GuiContainerCreative(this.mc.thePlayer));
        }
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        this.controlList.clear();

        int i;
    	if(!this.mc.thePlayer.getActivePotionEffects().isEmpty())
    		i = 160 + (width - xSize -200) / 2;
    	else
    		i = (width - xSize) / 2;
    	int j = (height - ySize) / 2;
    	btn_GuiTeleport= new GuiButton(2, i+175, j, 67, 20, StatCollector.translateToLocal("Téléportation"));
    	controlList.add(btn_GuiTeleport);
    	btn_GuiBoutique= new GuiButton(3, i+175, j+20, 67, 20, StatCollector.translateToLocal("Commerce")); 
    	controlList.add(btn_GuiBoutique);
    	btn_GuiCraft= new GuiButton(4, i+175, j+40, 67, 20, StatCollector.translateToLocal("Les crafts")); 
    	controlList.add(btn_GuiCraft);
    	btn_GuiShop= new GuiButton(5, i+175, j+60, 67, 20, StatCollector.translateToLocal("Boutique")); 
    	controlList.add(btn_GuiShop);
    	btn_scsDebug = new GuiButton(6, this.width -50, 3, 47, 20, "scs debug");
    	controlList.add(btn_scsDebug);
//    	controlList.add(new GuiButton(10, i+175, j+80, 67, 20, "Profils"));
        
        if (this.mc.playerController.isInCreativeMode())
        {
            this.mc.displayGuiScreen(new GuiContainerCreative(this.mc.thePlayer));
        }
        else
        {
            super.initGui();
        }
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.crafting"), 86, 16, 4210752);
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        super.drawScreen(par1, par2, par3);
        this.xSize_lo = (float)par1;
        this.ySize_lo = (float)par2;
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        int var4 = this.mc.renderEngine.getTexture("/gui/inventory.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(var4);
        int var5 = this.guiLeft;
        int var6 = this.guiTop;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
        func_74223_a(this.mc, var5 + 51, var6 + 75, 30, (float)(var5 + 51) - this.xSize_lo, (float)(var6 + 75 - 50) - this.ySize_lo);
    }

    public static void func_74223_a(Minecraft par0Minecraft, int par1, int par2, int par3, float par4, float par5)
    {
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par1, (float)par2, 50.0F);
        GL11.glScalef((float)(-par3), (float)par3, (float)par3);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        float var6 = par0Minecraft.thePlayer.renderYawOffset;
        float var7 = par0Minecraft.thePlayer.rotationYaw;
        float var8 = par0Minecraft.thePlayer.rotationPitch;
        GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-((float)Math.atan((double)(par5 / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        par0Minecraft.thePlayer.renderYawOffset = (float)Math.atan((double)(par4 / 40.0F)) * 20.0F;
        par0Minecraft.thePlayer.rotationYaw = (float)Math.atan((double)(par4 / 40.0F)) * 40.0F;
        par0Minecraft.thePlayer.rotationPitch = -((float)Math.atan((double)(par5 / 40.0F))) * 20.0F;
        par0Minecraft.thePlayer.rotationYawHead = par0Minecraft.thePlayer.rotationYaw;
        GL11.glTranslatef(0.0F, par0Minecraft.thePlayer.yOffset, 0.0F);
        RenderManager.instance.playerViewY = 180.0F;
        RenderManager.instance.renderEntityWithPosYaw(par0Minecraft.thePlayer, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        par0Minecraft.thePlayer.renderYawOffset = var6;
        par0Minecraft.thePlayer.rotationYaw = var7;
        par0Minecraft.thePlayer.rotationPitch = var8;
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }

    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.id == 0)
        {
            this.mc.displayGuiScreen(new GuiAchievements(this.mc.statFileWriter));
        }

        if (par1GuiButton.id == 1)
        {
            this.mc.displayGuiScreen(new GuiStats(this, this.mc.statFileWriter));
        }
        
        if (par1GuiButton.id == 2)
        {
        	this.mc.thePlayer.potion = false;
            this.mc.displayGuiScreen(new GuiTeleport(this.mc, this.mc.thePlayer));
        }
        if (par1GuiButton.id == 3)
        {
        	this.mc.thePlayer.closeScreen();
        	this.mc.thePlayer.potion = false;
        	this.mc.displayGuiScreen(new GuiBoutique(this.mc.thePlayer, this.mc));
        	if(this.mc.theWorld.isRemote){   
//                this.mc.getSendQueue().addToSendQueue(new Packet133Money(this.mc.thePlayer));
            }
        } 
        if (par1GuiButton.id == 4)
        {
        	this.mc.thePlayer.closeScreen();
        	this.mc.thePlayer.potion = true;
        	this.mc.displayGuiScreen(new GuiContainerCrafts(this.mc.thePlayer));
        }
        if (par1GuiButton.id == 5)
        {
        	this.mc.thePlayer.closeScreen();
        	this.mc.thePlayer.potion = true;
        	this.mc.displayGuiScreen(new GuiContainerShop(this.mc.thePlayer));
        }
        if (par1GuiButton.id == 6)
        {
        	this.mc.thePlayer.closeScreen();
        	this.mc.thePlayer.potion = true;
        	this.mc.thePlayer.sendChatMessage("/scs reload");
        }
//        if(par1GuiButton.id == 10)
//        {
//        	this.mc.thePlayer.potion = true;
//        	this.mc.displayGuiScreen(new GuiProfils(this.mc.thePlayer, this.mc));
//        }
        
    }
}

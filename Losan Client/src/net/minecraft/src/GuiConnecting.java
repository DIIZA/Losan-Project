package net.minecraft.src;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;

public class GuiConnecting extends GuiScreen
{
    /** A reference to the NetClientHandler. */
    private NetClientHandler clientHandler;

    /** True if the connection attempt has been cancelled. */
    private boolean cancelled = false;
    
    public int cooldownTimer;
    public String host;
    public int port;
    public boolean canLogin;
    public boolean isLogging = true;

    public GuiConnecting(Minecraft par1Minecraft, ServerData par2ServerData)
    {
        this.mc = par1Minecraft;
        ServerAddress var3 = ServerAddress.func_78860_a(par2ServerData.serverIP);
        par1Minecraft.loadWorld((WorldClient)null);
        par1Minecraft.setServerData(par2ServerData);
        this.host = var3.getIP();
        this.port = var3.getPort();
//        this.spawnNewServerThread(var3.getIP(), var3.getPort());
    }

    public GuiConnecting(Minecraft par1Minecraft, String par2Str, int par3)
    {
        this.mc = par1Minecraft;
        par1Minecraft.loadWorld((WorldClient)null);
        this.host = par2Str;
        this.port = par3;
//        this.spawnNewServerThread(par2Str, par3);
    }

    private void spawnNewServerThread(String par1Str, int par2)
    {
        System.out.println("Connecting to " + par1Str + ", " + par2);
        (new ThreadConnectToServer(this, par1Str, par2)).start();
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
    	super.updateScreen();
    	
    	cooldownTimer++;
    	
        if (this.clientHandler != null)
        {
            this.clientHandler.processReadPackets();
        }
    }

    /**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
    protected void keyTyped(char par1, int par2) {}

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        StringTranslate var1 = StringTranslate.getInstance();
        this.controlList.clear();
        this.controlList.add(new GuiButton(0, this.width / 2 - 98, this.height-20, 196, 21, "Annuler"));
    }

    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.id == 0)
        {
            this.cancelled = true;

            if (this.clientHandler != null)
            {
                this.clientHandler.disconnect();
            }

            this.mc.displayGuiScreen(new GuiMainMenu());
        }
    }

    /**
     * Draws the screen and all the components in it.
     * 
     * inspiré du systeme de cartasiane
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        this.drawDefaultBackground();
        
        int bg = mc.renderEngine.getTexture("/title/chargement.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(bg);
        GL11.glPushMatrix();
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.mc.renderEngine.getTexture("/title/chargement.png"));
   	 if(this.width <=427)
   		 GL11.glScalef((float)1.7F, 1.7F, 1.0F);
   	 else
   		 GL11.glScalef((float)(1280/this.width)+0.5F, (float)(768/this.height)+0.5F, 1.0F);
       this.drawTexturedModalRect(0, 0, 0, 0, 640, 384);

       
        GL11.glPopMatrix();
//        drawHorizontalLine(0, width, height - 50, 0xff838383);
//        drawGradientRect(0, height - 50, width, height-35, 0xaa535353, 0xdd232323);
//        drawGradientRect(0, height - 35, width, height, 0xdd232323, 0xee000000);
        drawHorizontalLine(0, this.width, this.height-47, 0xff000000);
        drawHorizontalLine(0, this.width, this.height-46, 0xff737373);
        
        this.drawRect(0, this.height-45, this.width, this.height, 0xff333333);
//        drawRect(0, 0, width, 25, 0x99000000);
        
        String q = "\2477Le saviez-vous ?\247f ";
        //fontRenderer.drawString(q + tip, width/2 - (fontRenderer.getStringWidth(q + tip)/2), 9, 0xffffffff);
//        
//        StringTranslate var4 = StringTranslate.getInstance();
//
//        if(this.canLogin){
//        if (this.clientHandler == null)
//        {
//            this.drawCenteredString(this.fontRenderer, var4.translateKey("connect.connecting"), width / 2, height - 44, 0xffffff);
//            this.drawCenteredString(this.fontRenderer, "", width / 2, height - 44, 0xffffff);
//        }
//        else
//        {
//            this.drawCenteredString(this.fontRenderer, var4.translateKey("connect.authorizing"), width / 2, height - 44, 0xffffff);
//            this.drawCenteredString(this.fontRenderer, this.clientHandler.field_72560_a, width / 2, height - 44, 0xffffff);
//        }
//        }
        
        if(cooldownTimer < 100)
        {
            drawCenteredString(fontRenderer, "Chargement du monde ...", width / 2, height - 44, 0xffffff);
        }
        else if(cooldownTimer >= 100)
        {        	
        	if(canLogin)
        	{
                drawCenteredString(fontRenderer, "Authentification...", width / 2, height - 44, 0xffffff);
        	}
        	else
        	{
                drawCenteredString(fontRenderer, "Une erreur s'est produite...", width / 2, height - 44, 0xffffff);
        	}
        }
        
        if(cooldownTimer >= 93)
        {
            if(isLogging)
            {
            	spawnNewServerThread(host, port);
                canLogin = true;
            	isLogging = false;
//            	this.cooldownTimer = 0;
            }
        }
        
        if(cooldownTimer >= 100)
        {
        	drawRect(this.width/2 - 96, this.height - 32 , this.width / 2 + 96 , this.height - 22, 0xfd8d8d80);
        	drawRect(this.width / 2 - 5, this.height - 31, this.width / 2 + 95, this.height - 23, 0xf0000000);
            drawRect(this.width / 2 - 95, this.height - 31, this.width / 2 + 95, this.height - 23, 0xf00aa000);
            fontRenderer.drawString("100 %", width/2 - (fontRenderer.getStringWidth("100 %")/2), height - 32, 0xffffffff);
        }
        else
        {
        	drawRect(this.width/2 - 96, this.height - 32 , this.width / 2 + 96 , this.height - 22, 0xfd8d8d80);
        	drawRect(this.width / 2 - 95, this.height - 31, this.width / 2 + 95, this.height - 23, 0xf0000000);
        	drawRect(this.width / 2 - 95, this.height - 31, this.width/2 - 95 + cooldownTimer*2 - 8, height - 23, 0xf00aa000);
            fontRenderer.drawString(cooldownTimer+" %", width/2 - (fontRenderer.getStringWidth(cooldownTimer+" %")/2), height - 32, 0xffffffff);
        }
        
        super.drawScreen(par1, par2, par3);
    }

    /**
     * Sets the NetClientHandler.
     */
    static NetClientHandler setNetClientHandler(GuiConnecting par0GuiConnecting, NetClientHandler par1NetClientHandler)
    {
        return par0GuiConnecting.clientHandler = par1NetClientHandler;
    }

    static Minecraft func_74256_a(GuiConnecting par0GuiConnecting)
    {
        return par0GuiConnecting.mc;
    }

    static boolean isCancelled(GuiConnecting par0GuiConnecting)
    {
        return par0GuiConnecting.cancelled;
    }

    static Minecraft func_74254_c(GuiConnecting par0GuiConnecting)
    {
        return par0GuiConnecting.mc;
    }

    /**
     * Gets the NetClientHandler.
     */
    static NetClientHandler getNetClientHandler(GuiConnecting par0GuiConnecting)
    {
        return par0GuiConnecting.clientHandler;
    }

    static Minecraft func_74249_e(GuiConnecting par0GuiConnecting)
    {
        return par0GuiConnecting.mc;
    }

    static Minecraft func_74250_f(GuiConnecting par0GuiConnecting)
    {
        return par0GuiConnecting.mc;
    }

    static Minecraft func_74251_g(GuiConnecting par0GuiConnecting)
    {
        return par0GuiConnecting.mc;
    }
}

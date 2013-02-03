package Losan.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.GuiInventory;
import net.minecraft.src.GuiSmallButton;
import net.minecraft.src.GuiTextField;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.StatCollector;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import Losan.Container.ContainerBoutique;

public class GuiBoutique extends GuiContainer //ajout
{
	private GuiButton bouton;
	private GuiTextField montant;
	private GuiTextField quantite;
	private GuiTextField prix;
	private GuiTextField destinataire;
	private GuiTextField money;
	
	GuiButton btn_GuiTeleport;
	GuiButton btn_GuiCraft;
	GuiButton btn_GuiInv;
	GuiButton btn_GuiShop;
	
	private int keybox;

	private GuiCheckBox check1;
	private GuiCheckBox check2;
	private GuiCheckBox check3;
	private GuiCheckBox check4;

	public ContainerBoutique cont;
	private EntityPlayer p;
	private boolean remove;
	private int tuto;
	private boolean ici;
	private long time;
	private long refTime;
	private int slot;
	private InventoryPlayer pInv;
	private ItemStack stack;
	private Minecraft mc;
	private boolean commerce;
	private String erreur;
	private boolean error;
	private float total;
	
    private float xSize_lo;
    private float ySize_lo;
	
	
	private Container x;
	
	public GuiBoutique(EntityPlayer par1Player, Minecraft minecraft)
	{		
		super(new ContainerBoutique(par1Player.inventory));
		
		this.mc = minecraft;
		this.cont = par1Player.cont;
		this.allowUserInput = true;
		this.p = par1Player;
		this.remove = true;
		this.tuto = 0;
		this.ici = false;
		this.keybox = 0;
		this.time = 0;
		this.refTime = 99999999;
		this.slot = 0;
		this.pInv = par1Player.inventory;
		this.stack = null;
		par1Player.onGuiBoutique = true;
		this.commerce = false;
		this.error = false;
		

	}

    public NetClientHandler getSendQueue()
    {
        return mc.thePlayer != null ? mc.thePlayer.sendQueue : null;
    }

	public void initGui()
	{
		controlList.clear();
		int i = (this.width - this.xSize) / 2;
		int j = (this.height - this.ySize) / 2;
		
		this.montant = new GuiTextField(this.fontRenderer, i + 4, j + 32, 50, 10);
		this.montant.setText("0");
		this.montant.setMaxStringLength(10);
		this.montant.setEnableBackgroundDrawing(true);
		this.montant.setVisible(true);
		this.montant.setTextColor(0x00ff00);
		
		this.quantite = new GuiTextField(this.fontRenderer, i + 4, j + 52, 50, 10);
		this.quantite.setText("0");
		this.quantite.setMaxStringLength(11);
		this.quantite.setEnableBackgroundDrawing(true);
		this.quantite.setVisible(true);
		this.quantite.setTextColor(0x00ff00);
		
		this.prix = new GuiTextField(this.fontRenderer, i + 4, j + 110, 50, 10);
        this.prix.setText("ex: 10000");
        this.prix.setMaxStringLength(9);
        this.prix.setEnableBackgroundDrawing(true);
        this.prix.setVisible(true);
        this.prix.setTextColor(0xffffff);
        
        this.destinataire = new GuiTextField(this.fontRenderer, i + 90, j + 110, 80, 10);
        this.destinataire.setText("ex: dermenslof");
        this.destinataire.setMaxStringLength(20);
        this.destinataire.setEnableBackgroundDrawing(true);
        this.destinataire.setVisible(true);
        this.destinataire.setTextColor(0xffffff);
        
        this.money = new GuiTextField(this.fontRenderer, i + 4, j + 130, 168, 10);
        this.money.setText(String.valueOf(this.mc.thePlayer.money)+" LS");
        this.money.setMaxStringLength(100);
        this.money.setEnableBackgroundDrawing(true);
        this.money.setVisible(true);
        this.money.setTextColor(0x00ff00);
		
		this.bouton = new GuiButton(1, i + 112, j + 62, 60, 20,  StatCollector.translateToLocal("Créer"));
		controlList.add(this.bouton);

		
		this.check1 = new GuiCheckBox(2, i + 112, j + 14);
		controlList.add(check1);
		this.check2 = new GuiCheckBox(3, i + 112, j + 24);
		controlList.add(check2);
		this.check3 = new GuiCheckBox(4, i + 112, j + 34);
		controlList.add(check3);
		this.check4 = new GuiCheckBox(5, i + 112, j + 44);
		controlList.add(check4);
		
		controlList.add(new GuiButton(10, i + 75, j + 55, 10, 20,  "<"));
		controlList.add(new GuiButton(11, i + 90, j + 55, 10, 20,  ">"));
		
		controlList.add(new GuiInvisibleButton(6, i + 112, j + 14));
		controlList.add(new GuiInvisibleButton(7, i + 112, j + 24));
		controlList.add(new GuiInvisibleButton(8, i + 112, j + 34));
		controlList.add(new GuiInvisibleButton(9, i + 112, j + 44));

		
		
		
		controlList.add(new GuiSmallButton(12, i + 82, j + 142, 90, 20,  StatCollector.translateToLocal("envoyer")));
		
		btn_GuiTeleport= new GuiButton(13, i+175, j, 67, 20, StatCollector.translateToLocal("Téléportation"));
    	controlList.add(btn_GuiTeleport);
    	btn_GuiCraft= new GuiButton(15, i+175, j+20, 67, 20, StatCollector.translateToLocal("Les crafts")); 
    	controlList.add(btn_GuiCraft);
    	btn_GuiShop= new GuiButton(17, i+175, j+40, 67, 20, StatCollector.translateToLocal("Boutique")); 
    	controlList.add(btn_GuiShop);
    	btn_GuiInv= new GuiButton(16, i+175, j+60, 67, 20, StatCollector.translateToLocal("Inventaire")); 
    	controlList.add(btn_GuiInv);
		
//    	controlList.add(new GuiButton(18, i+175, j+80, 67, 20, "Profils"));
    	
		this.check1.drawButton1(this.mc, 0, 0, true);
		
		super.initGui();
	}


	public void drawScreen(int i, int j, float f)
	{
		super.drawScreen(i, j, f);
		int var5 = this.guiLeft;
        int var6 = this.guiTop;
        this.xSize_lo = (float)i;
        this.ySize_lo = (float)j-100;
	    
	}

	    

	protected void drawGuiContainerForegroundLayer(int par1, int par2){}

	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		int var4 = this.mc.renderEngine.getTexture("/gui/boutique.png");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(var4);
		int j = this.guiLeft;
		int k = this.guiTop;
		this.drawTexturedModalRect(j, k, 0, 0, this.xSize, this.ySize);
		this.montant.drawTextBox();
		this.quantite.drawTextBox();
        this.prix.drawTextBox();
        this.destinataire.drawTextBox();
        this.money.drawTextBox();
		
		this.fontRenderer.drawString(StatCollector.translateToLocal("Commerce"), j+(this.xSize/2)-(StatCollector.translateToLocal("Commerce").length()*2), k+4, 0xffffff);
		if(StatCollector.translateToLocal("container.money").equals("Payment"))
			this.fontRenderer.drawString("____________________________", j+4, k+this.ySize - 96 + 8, 0xffffff);
		else
			this.fontRenderer.drawString("_____________________________________", j+4, k+this.ySize - 96 + 8, 0xffffff);
		
		this.fontRenderer.drawString(StatCollector.translateToLocal("Transaction"), j+(this.xSize/2)-(StatCollector.translateToLocal("Transaction").length()*2), k+this.ySize - 96 + 16, 0xffffff);
		
		if(this.check1.enabled)
			this.fontRenderer.drawString(StatCollector.translateToLocal("vendre"), j+125, k+14, 0xffff00);
		else
			this.fontRenderer.drawString(StatCollector.translateToLocal("vendre"), j+125, k+14, 0xffffff);
		if(this.check2.enabled)
			this.fontRenderer.drawString(StatCollector.translateToLocal("acheter"), j+125, k+24, 0xffff00);
		else
			this.fontRenderer.drawString(StatCollector.translateToLocal("acheter"), j+125, k+24, 0xffffff);
		if(this.check3.enabled)
			this.fontRenderer.drawString(StatCollector.translateToLocal("vitrine"), j+125, k+34, 0xffff00);
		else
			this.fontRenderer.drawString(StatCollector.translateToLocal("vitrine"), j+125, k+34, 0xffffff);
		if(this.check4.enabled)
			this.fontRenderer.drawString(StatCollector.translateToLocal("effacer"), j+125, k+44, 0xffff00);
		else
			this.fontRenderer.drawString(StatCollector.translateToLocal("effacer"), j+125, k+44, 0xffffff);
		
		this.fontRenderer.drawString(StatCollector.translateToLocal("prix"), j+4, k+22, 0xffffff);
		this.fontRenderer.drawString(StatCollector.translateToLocal("quantité"), j+4, k+42, 0xffffff);
		
		this.fontRenderer.drawString(StatCollector.translateToLocal("montant"), j+4, k+100, 0xffffff);
		this.fontRenderer.drawString(StatCollector.translateToLocal("destinataire"), j+90, k+100, 0xffffff);
		this.fontRenderer.drawString(StatCollector.translateToLocal("mon argent"), j+4, k+120, 0xffffff);	
		
		if(this.error){	
			this.fontRenderer.drawString(this.erreur, j+25, k-12, 0xff0000);
		}else if(this.ici){
			this.fontRenderer.drawString("    Il manque un bloc/item ...", j+25, k-12, 0xff0000);
			this.fontRenderer.drawString("ICI", j+82, k+36, 0xff0000);
		}else{
			this.fontRenderer.drawString("", j+25, k-12, 0xff0000);
			this.fontRenderer.drawString("", j+82, k+36, 0xff0000);
		}
		
		if(this.check4.enabled)
			this.bouton = new GuiButton(1, j + 112, k + 62, 60, 20,  StatCollector.translateToLocal("Supprimer"));
		else
			this.bouton = new GuiButton(1, j + 112, k + 62, 60, 20,  StatCollector.translateToLocal("Créer"));
	}

	protected void mouseClicked(int i, int j, int k)
	{
		if(this.ici || this.error){
			this.ici = false;
			this.error = false;
		}
		this.montant.setFocused(false);
		this.quantite.setFocused(false);
		super.mouseClicked(i, j, k);
		if(this.remove)
		{
			this.montant.mouseClickedSP1(i, j, k, this.montant);
			this.quantite.mouseClickedSP1(i, j, k, this.quantite);
		}
		 this.prix.mouseClickedSP(i, j, k, this.prix);
         this.destinataire.mouseClickedSP(i, j, k, this.destinataire);
	}




	protected void keyTyped(char c, int i)
	{
//        if (c == 1 || i == this.mc.gameSettings.keyBindProfils.keyCode)
//        {
//            this.mc.displayGuiScreen(new GuiProfils(this.mc.thePlayer, this.mc));
//        }
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
		{
			p.onGuiBoutique = false;
			p.closeScreen();
		}
		this.keybox = i;		
		if(this.destinataire.isFocused())			
			this.destinataire.textboxKeyTyped(c, i);
		else
			super.keyTyped(c, i);
		if(this.remove)
		{

			if(c == '.' || c == '\t'){
				if(c =='\t')
				{
					if(this.montant.isFocused())
					{
						this.quantite.setFocused(true);
						this.montant.setFocused(false);
						if(this.quantite.getText().equals("0"))
							this.quantite.setText("");
						if(this.montant.getText().equals(""))
							this.montant.setText("0");
					}
					else if(this.quantite.isFocused())
					{
						this.montant.setFocused(true);
						this.quantite.setFocused(false);
						if(this.montant.getText().equals("0"))
							this.montant.setText("");
						if(this.quantite.getText().equals(""))
							this.quantite.setText("0");
					}
				}					
				this.montant.textboxKeyTyped(c, i);
				this.quantite.textboxKeyTyped(c, i);
				return;
			}
			
			try {
				int x = Integer.parseInt(String.valueOf(c)); 
			}catch(Exception ex){			
				return;
			}
			
			this.montant.textboxKeyTyped(c, i);
			this.quantite.textboxKeyTyped(c, i);
		}
	
		if(c != '.' || c != '\t'){
				try {
					int x = Integer.parseInt(String.valueOf(c)); 
				}catch(Exception ex){			
					return;
				}
		}
		
			this.prix.textboxKeyTyped(c, i);

			if(!this.prix.getText().equals("ex: 10000")){
				if(this.prix.getText().equals("")){
					this.money.setText(String.valueOf(this.mc.thePlayer.money)+" LS");
					return;
				}
				this.total = this.mc.thePlayer.money - Float.parseFloat(this.prix.getText());
				String argent = String.valueOf(this.total);
				this.money.setText(argent+" LS");		
			}
			else
			{
				this.money.setText(String.valueOf(this.mc.thePlayer.money)+" LS");			
			}
			if(this.total <0)
				this.money.setTextColor(0xff0000);
			else
				this.money.setTextColor(0x00ff00);
		
	}


	public void updateScreen()
	{
		String x= this.prix.getText();
		
		if(!x.equals("ex: 10000") && !x.equals("_") && !x.equals(""))
			this.money.setText(String.valueOf(this.mc.thePlayer.money - Float.parseFloat(this.prix.getText()))+" LS");
		if(x.equals("")){
			this.money.setTextColor(0x00ff00);
			this.money.setText(String.valueOf(this.mc.thePlayer.money)+" LS");
		}
		
		this.time += 1;
		
		super.updateScreen();
		
		if (Keyboard.isKeyDown(Keyboard.KEY_BACK))
		{	
			if((this.refTime == 99999999) || ((((this.refTime)+3) <= this.time)))
			{
				this.refTime = this.time;
				this.montant.textboxKeyTyped('\b', this.keybox);
				this.quantite.textboxKeyTyped('\b', this.keybox);	
				this.prix.textboxKeyTyped('\b', this.keybox);
				this.destinataire.textboxKeyTyped('\b', this.keybox);
			}
		}
		if (!p.isEntityAlive() || p.isDead)
		{
			p.closeScreen();
			p.onGuiBoutique = false;
		}
		if(!this.remove)
		{
			this.montant.setText("Non requis");
			this.quantite.setText("Non requis");
			this.montant.setTextColor(0x787878);
			this.quantite.setTextColor(0x787878);
		}else{
			this.montant.setTextColor(0x00ff00);
			this.quantite.setTextColor(0x00ff00);
		}
	}


	protected void actionPerformed(GuiButton guibutton)
	{
		boolean inv = false;
		if (guibutton.id == 1)
		{
			String ID = this.cont.slotRef.getId();

			
			String type;
			
			if(this.quantite.getText().equals("") || this.quantite.getText().equals("_"))
				this.quantite.setText("0");
			if(this.montant.getText().equals("") || this.montant.getText().equals("_"))
				this.montant.setText("0");

			if(this.check1.enabled)
				type = "sell";
			else if(this.check2.enabled)
				type = "buy";
			else if(this.check3.enabled)
				type = "display";
			else 
				type = "remove";
			
			String txt;
			if (type.equals("remove"))
			{
				mc.thePlayer.sendChatMessage("/scs remove");
				mc.thePlayer.closeScreen();
				return;
			}
			if (type.equals("display"))
			{
				if(ID == null)
				{
					this.ici = true;
					return;
				}
				mc.thePlayer.sendChatMessage("/scs display "+ID);
				this.mc.thePlayer.scs = true;
				mc.thePlayer.closeScreen();
				return;
			}
			
			if(ID == null){
				this.ici = true;
				return;
	        } 
			
	        if(Integer.parseInt(this.quantite.getText()) <= 0){
	        	this.erreur = "La quantité doit être 1 ou plus";
	        	this.error = true;
	        	return;
	        }

	        mc.thePlayer.sendChatMessage("/scs "+type+" "+ID+" "+this.quantite.getText().toLowerCase()+" "+this.montant.getText().toLowerCase());
	        this.mc.thePlayer.scs = true;
			mc.thePlayer.closeScreen();
			p.onGuiBoutique = false;
		}
		if (guibutton.id == 2 || guibutton.id == 6)
		{
			this.check1.drawButton1(this.mc, 0, 0, !inv);
			this.check2.drawButton1(this.mc, 0, 0, inv);
			this.check3.drawButton1(this.mc, 0, 0, inv);
			this.check4.drawButton1(this.mc, 0, 0, inv);
			this.remove = true;
		}
		if (guibutton.id == 3 || guibutton.id == 7)
		{;
			this.check2.drawButton1(this.mc, 0, 0, !inv);
			this.check1.drawButton1(this.mc, 0, 0, inv);
			this.check3.drawButton1(this.mc, 0, 0, inv);
			this.check4.drawButton1(this.mc, 0, 0, inv);
			this.remove = true;
		}
		if (guibutton.id == 4 || guibutton.id == 8)
		{
			this.check3.drawButton1(this.mc, 0, 0, !inv);
			this.check1.drawButton1(this.mc, 0, 0, inv);
			this.check2.drawButton1(this.mc, 0, 0, inv);
			this.check4.drawButton1(this.mc, 0, 0, inv);
			this.remove = false;
		}
		if (guibutton.id == 5 || guibutton.id == 9)
		{
			this.check4.drawButton1(this.mc, 0, 0, !inv);
			this.check1.drawButton1(this.mc, 0, 0, inv);
			this.check2.drawButton1(this.mc, 0, 0, inv);
			this.check3.drawButton1(this.mc, 0, 0, inv);
			this.remove = false;
		}
		if(guibutton.id == 10)
		{
			for(int x=this.slot;x>=0;x--)
			{
				if(x < 0)
				x = 35;
				
				ItemStack ref = pInv.getStackInSlot(x);
				if(ref != null){
					if(ref == this.stack)
						continue;
					else
					{
						this.slot = x;
						this.stack = ref;
						setSlot(x);
						return;
					}
				}
			}
//			this.erreur = " Ton inventaire est vide ...";
//			this.error = true;
		}
		if(guibutton.id == 11)
		{
			for(int x=this.slot;x<=35;x++)
			{
				if(x > 35)
				x = 0;
				
				ItemStack ref = pInv.getStackInSlot(x);
				if(ref != null){
					if(ref == this.stack)
						continue;
					else
					{
						this.slot = x;
						this.stack = ref;
						setSlot(x);
						return;
					}
				}
			}
//			this.erreur = " Ton inventaire est vide ...";
//			this.error = true;
		}
		if (guibutton.id == 12)
        {
			if(this.mc.thePlayer.money <= 0){
				this.erreur = "    Tu n'as pas assez d'argent";
				this.error = true;
				return;
			}
			
			if(this.destinataire.getText().equals("") || this.destinataire.getText().equals("ex: dermenslof") || this.prix.getText().equals("") || this.prix.getText().equals("ex: 10000") || (Integer.parseInt(this.prix.getText()) == 0))
			{
				try {
					int x = Integer.parseInt(String.valueOf(this.prix.getText())); 
				}catch(Exception ex){	
					this.erreur = "  Le montant doit être numérique";
					this.error = true;
					return;
				}
				if((Integer.parseInt(this.prix.getText()) == 0) && !this.prix.getText().equals("ex: 10000"))
					this.erreur = "  Le montant ne peut pas être 0";
				else if( this.destinataire.getText().equals("ex: dermenslof"))
				    this.erreur = "Tu doit rentrer un destinataire";
				else
					this.erreur = "  Il manque un/des paramètre(s)";
				this.error = true;
				return;
			}
			if(this.total < 0){
				this.erreur = "    Tu n'as pas assez d'argent";
				this.error = true;
				return;
			}

            mc.thePlayer.sendChatMessage("/money pay "+this.destinataire.getText().toLowerCase()+" "+this.prix.getText().toLowerCase());
            mc.thePlayer.closeScreen();
            p.onGuiBoutique = false;
        }
		if (guibutton.id == 13)
        {
			this.mc.thePlayer.potion = false;
           this.mc.displayGuiScreen(new GuiTeleport(this.mc, this.mc.thePlayer));
        }
        if (guibutton.id == 15)
        {
        	this.mc.thePlayer.potion = true;
        	this.mc.displayGuiScreen(new GuiContainerCrafts(this.mc.thePlayer));
        }
        if (guibutton.id == 16)
        {
        	this.mc.thePlayer.potion = false;
        	this.mc.displayGuiScreen(new GuiInventory(this.mc.thePlayer));
        }
        if (guibutton.id == 17)
        {
        	this.mc.thePlayer.potion = true;
        	this.mc.displayGuiScreen(new GuiContainerShop(this.mc.thePlayer));
        }
        
//        if(guibutton.id == 18)
//        {
//        	this.mc.thePlayer.potion = true;
//        	this.mc.displayGuiScreen(new GuiProfils(this.mc.thePlayer, this.mc));
//        }
	}
	
	private void setSlot(int x)
	{
		ItemStack ref = pInv.getStackInSlot(x);
		String ID = this.cont.slotRef.getId();
		
		if(ID != null)
			this.cont.slotRef.resetId();
		
		this.cont.slotRef.setId(ref);		
	}
}
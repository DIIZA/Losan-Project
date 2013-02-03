package Losan.Utils;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.GuiIngame;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.OpenGlHelper;
import net.minecraft.src.RenderHelper;
import net.minecraft.src.RenderManager;
import net.minecraft.src.StatCollector;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntitySkull;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class DescriptionFinder {
	
	public static boolean fixChat = true;
	public static int decompte = 80;
	
	/**
	 * m�thode principale, check le pointeur et affiche le gui si le pointeur retourne quelque chose 
	 * ET si la touche I � �t� press�e
	 */
	public static void checkGuiDesc(GuiIngame gui){
		//innitialisation des donn�es
    	int id = -1;
		int data = -1;
		String name = "";
		TileEntity ti;
		boolean verif = false;
		gui.name = "";
		gui.id = 0;
		gui.desc = "";
		gui.data = 0;
		gui.item = null;
		
		//si le pointeur retourne quelque chose
		if(gui.mc.objectMouseOver != null){
			decompte = 80;
			//r�cup�ration des donn�es
			id = gui.mc.theWorld.getBlockId(gui.mc.objectMouseOver.blockX, gui.mc.objectMouseOver.blockY, gui.mc.objectMouseOver.blockZ);
			ti = gui.mc.theWorld.getBlockTileEntity(gui.mc.objectMouseOver.blockX, gui.mc.objectMouseOver.blockY, gui.mc.objectMouseOver.blockZ);			
			data = gui.mc.theWorld.getBlockMetadata(gui.mc.objectMouseOver.blockX, gui.mc.objectMouseOver.blockY, gui.mc.objectMouseOver.blockZ);			
			Block b = Block.blocksList[id];
			Item i = Item.itemsList[id];
			
			
			//v�rification si l'objet provient d'in item
			for(int itemId: gui.list){
				if(itemId == id){
					verif = true;
					break;
				}
			}
			
			if(id == 34){
				gui.item = new ItemStack(b); 
				gui.id = gui.item.itemID;
				gui.name = "Extension de piston";
			}else if(id == 36){
				gui.item = new ItemStack(i); 
				gui.id = gui.item.itemID;
				gui.name = "Piston en mouvement";
			}else if(verif)//si c'est un item
				id = DescriptionFinder.updateDataItem(i, id, data, ti, name, gui);
			else if(b != null){//si c'est un block
				id = DescriptionFinder.updateDataBlock(b, id, data, name, gui);
			}else{//ou alors si c'est une entity
				id = 0;
				DescriptionFinder.updateDataEntity(name, gui);
			}			
		}
		
		if(id != -1)//si on a bien r�cup�r� quelque chose
			gui.pointage = true;
		else
			gui.pointage = false;

		//si le pointeur retourne quelque chose � afficher et le la touche I a �t� enfonc�e
		if(gui.pointage){
						
			if(gui.desc.equals("") || gui.desc.equals(".desc"))//si la description n'a pas �t� trouv�e, on la remplace par la phrase suivante
				gui.desc = "Pas de d�scription";

			//si la traduction n'existe pas ou n'a pas �t� r�cup�r�e pou X raisons on r�cup�re le nom brut
			if(gui.name.contains(".name")){
				gui.name = gui.name.replaceAll(".name", "");
				gui.name = gui.name.replaceAll("tile.", "");
				gui.name = gui.name.replaceAll("item.", "");
				gui.name = gui.name.replaceAll("entity.", "");
			}
		}
		if(gui.screenDesc) {
			// slide du gui vers la gauche
			gui.decalage-=20;
			if(gui.decalage <= 0){
				gui.decalage = 0;
				gui.screenblock = true;
			}
		}else{//si on ne pointe plus vers un object
			//on r�innitialise nootre variable de d�t�ction de la touche I
//			gui.screenDesc = false;
			
			//slide du gui vers la droite
			gui.decalage+=20;
			if(gui.decalage >= 153){
				gui.decalage = 153;
				gui.screenblock = true;
			}
			
		}
		
    }
    
	/**
	 * traitement des donn�es de l'item
	 */	
    public static int updateDataItem(Item i, int ID, int data, TileEntity ti, String name, GuiIngame gui){
    	//on r�cup�re le nom de l'item
    	try{
			name = i.getItemName();
		}catch(Exception ex){}
    	
    	//fix pour les items provenants d'un block
		if(ID == 117) 
			gui.item = new ItemStack(Item.brewingStand, 1, data);
		else if(ID == 140) 
			gui.item = new ItemStack(Item.flowerPot, 1, data);
		else if(ID == 144){
			gui.item = new ItemStack(Item.skull, 1, ((TileEntitySkull)ti).skullType);
			gui.data = ((TileEntitySkull)ti).skullType;
		}else if(ID == 93) 
			gui.item = new ItemStack(Item.redstoneRepeater, 1, data);
		else if(ID == 26) 
			gui.item = new ItemStack(Item.bed, 1, data);
		else if(ID == 118) 
			gui.item = new ItemStack(Item.cauldron, 1, data);
		else if(ID == 55) 
			gui.item = new ItemStack(Item.redstone, 1, data);
		else 
			gui.item = new ItemStack(i, 1, data);
		
		//change l'id du block par celui de l'item
		gui.id = gui.item.itemID;
		
		//on re-r�cup�re le nom de l'item si l'item � �t� chang�e
		name = gui.item.getItemName();
		
		//traitement du nom de l'item
		name = name.replaceAll("tile.", "item.");
		gui.desc = StatCollector.translateToLocal(name+".desc");
		gui.name = StatCollector.translateToLocal(name+".name");
		gui.data = data;
		
		//si la d�scription n'a pas �t� trouv�e, on on la rend vide
		if(gui.desc.equals(name+".desc"))
			gui.desc = "";
		
		return gui.id;
    }
    
	/**
	 * traitement des donn�es du block
	 */	
    public static int updateDataBlock(Block b, int id, int data, String name, GuiIngame gui){
    	//innitialisation du sous-nom du block
    	String subName = "";
    	
    	//on r�cup�re le nom du block
    	try{
			name = b.getBlockName(); //tile.cloth				
		}catch(Exception ex){}
    	
    	//on r�cup�re l'item � afficher et l'id
    	gui.item = new ItemStack(b, 1, data);
    	gui.id = id;
    	
    	//on v�rifie su le block est de type Coloriz�
    	subName = checkSubName(subName, name, data);
    	
    	//on traduit le nom et la description
    	gui.desc = StatCollector.translateToLocal(name+".desc");
		gui.name = StatCollector.translateToLocal(name+subName+".name");
		gui.data = data;

		//si la d�scription n'a pas �t� trouv�e, on on la rend vide
		if(gui.desc.equals(name+".desc"))
			gui.desc = "";
		
		return id;
    }
    
	/**
	 * v�rification si le block a des noms de couleurs (comme la laine)
	 */	
    private static String checkSubName(String subName, String name, int data){
    	//on v�rifie par rapport � son nom
    	if(name.equalsIgnoreCase("tile.Cloth") || name.equalsIgnoreCase("tile.coloredGlass") || name.equalsIgnoreCase("tile.moquette") || name.equalsIgnoreCase("tile.coloredGlowStone")){
    		//en fonction du m�tadata du bloc on r�cup�re le sous nom
    		switch (data){
    		case 15:
    			subName=".black";
    			break;
    		case 14:
    			subName=".red";
    			break;
    		case 13:
    			subName=".green";
    			break;
    		case 12:
    			subName=".brown";
    			break;
    		case 11:
    			subName=".blue";
    			break;
    		case 10:
    			subName=".purple";
    			break;
    		case 9:
    			subName=".cyan";
    			break;
    		case 8:
    			subName=".silver";
    			break;
    		case 7:
    			subName=".gray";
    			break;
    		case 6:
    			subName=".pink";
    			break;
    		case 5:
    			subName=".lime";
    			break;
    		case 4:
    			subName=".yellow";
    			break;
    		case 3:
    			subName=".lightBlue";
    			break;
    		case 2:
    			subName=".magenta";
    			break;
    		case 1:
    			subName=".orange";
    			break;
    		case 0:
    			subName=".white";
    			break;
    		}
    	}
    	return subName;
    }

    /**
	 * traitement des donn�es de l'entity
	 */	
    public static int updateDataEntity(String name, GuiIngame gui){
    	//r�cup�ration de l'entity et de son nom
		try{
			Entity  e = gui.mc.objectMouseOver.entityHit;
			name = e.getEntityName();
			
			//si c'est vivant, on efface l'item pr�c�dant pour ne pas l'afficher et on innitialise le mob � afficher
			if(e instanceof EntityLiving){
				gui.mob = (EntityLiving)e;				
				gui.item = null;
			}			
		}catch(Exception ex){}

		//fix entity sous forme de block qui sont des items. XD super phrase
		if(name.equals("entity.ItemFrame.name")){
			name = "item.frame.name";
			gui.item = new ItemStack(Item.itemFrame);
			gui.id = gui.item.itemID;
		}else if(name.equals("Peinture")){
			name = "item.painting.name";
			gui.item = new ItemStack(Item.painting);
			gui.id = gui.item.itemID;
		}else if(name.equals("Wagonnet")){
			name = "item.minecart.name";
			gui.item = new ItemStack(Item.minecartEmpty);
			gui.id = gui.item.itemID;
		}
		
		// traduction du nom du bloc et de la d�scription
		gui.name = StatCollector.translateToLocal(name);
		name = name.replaceAll(".name", ".desc");
		gui.desc = StatCollector.translateToLocal(name);
		
		//si la d�scription n'a pas �t� trouv�e, on on la rend vide
		if(gui.desc.equals(name))
			gui.desc = "";
		
		return gui.id;
    }
	
    /**
	 * affichage du gui
	 */	
    public static void drawCadre(int x, int y, GuiIngame gui){
    	//on dessine le fond du gui (violet fonc�)
    	gui.drawRect(x-153+gui.decalage, 34, x-3+gui.decalage, 104, 0xe1100110);
    	
    	//on dessine le cadre (violet clair)
        gui.drawVerticalLine(x-152+gui.decalage, 34, 103, 0xf5500550);
        gui.drawVerticalLine(x-5+gui.decalage, 34, 103, 0xf5500550);
        gui.drawHorizontalLine(x-152+gui.decalage, x-5+gui.decalage, 35, 0xf5500550);
        gui.drawHorizontalLine(x-152+gui.decalage, x-5+gui.decalage, 102, 0xf5500550);
       
    	//on dessine le cadre de l'object � afficher
        gui.drawRect(x-143+gui.decalage, 38, x-119+gui.decalage, 62, 0xfd8d8d80);
        
    	//on dessine le fond de l'object � afficher
        gui.drawRect(x-142+gui.decalage, 39, x-120+gui.decalage, 61, 0xf0000000);
       
        //affichage du nom et de l'id:data
        drawNameAndId(x, y, gui);
        
        //on affiche le fond de la d�scription
        gui.drawRect(x-147+gui.decalage, 68, x-9+gui.decalage, 98, 0xc0000000);
       
        //affichage de la d�scription
        drawDesc(x, y, gui);
    }
    
    /**
	 * traitement du nom et de l'id puis affichage dans le gui
	 */	
    private static void drawNameAndId(int x, int y, GuiIngame gui){

    	//si le nom existe ET qu'il 24 caract�res ou moins
    	if(gui.name != null && gui.name.length() <= 24){
    		//on affiche le cadre addapt�
    		gui.drawRect(x-107+gui.decalage, 38, x-9+gui.decalage, 62, 0xc0000000);
    		
    		//on affiche le nom
    		gui.drawString(gui.mc.fontRenderer, gui.name, x+gui.decalage-100, 40, 0xd8d8d8);
    		
    		//si pas d'id, on affiche rien
    		if(gui.id == 0)
    			;
    		else if(gui.data == 0)//si pas de m�tadata
    			gui.drawString(gui.mc.fontRenderer, "ID: "+gui.id, x+gui.decalage-100, 50, 0xd8d8d8);
    		else //sinon il y a m�tadata
    			gui.drawString(gui.mc.fontRenderer, "ID: "+gui.id+":"+gui.data, x+gui.decalage-100, 50, 0xd8d8d8);
    	}else{
    		// le nom va d�pacer du cadre, alors on trace un cadre plus grand
    		gui.drawRect(x-115+gui.decalage, 38, x-9+gui.decalage, 62, 0xc0000000);
    		
    		//on affiche le nom
    		gui.drawString(gui.mc.fontRenderer, gui.name, x+gui.decalage-112, 40, 0xd8d8d8);
    		
    		//si pas d'id, on affiche rien
    		if(gui.id == 0)
    			;
    		else if(gui.data == 0)//si pas de m�tadata
    			gui.drawString(gui.mc.fontRenderer, "ID: "+gui.id, x+gui.decalage-112, 50, 0xd8d8d8);
    		else//sinon il y a m�tadata
    			gui.drawString(gui.mc.fontRenderer, "ID: "+gui.id+":"+gui.data, x+gui.decalage-112, 50, 0xd8d8d8);
    	}
    }
    
    /**
	 * traitement de la d�scription et affichage dans le gui 
	 */	
    private static void drawDesc(int x, int y, GuiIngame gui){
    	//si la d�scription n'existe pas, on s'en va
    	if(gui.desc == null)
        	return;
        
    	//on r�cup�re le nombre de caract�re de la d�scription (espaces compris)
        int C = gui.desc.length();
       
        //si la d�scription fais une ligne
        if(C<= 34){
        	//on affiche la d�scription et on s'en va
        	gui.drawString(gui.mc.fontRenderer, gui.desc, x+gui.decalage-145, 70, 0xd8d8d8);
        	return;
        }
        
        //la description fait 2 ligne ou plus
        //on cherche le premier espace dans les 34 premiers caract�res
        for( int c = 34; c>-1;c--){
        	//on r�cup�re le caract�re � la position c
        	char t = gui.desc.charAt(c);
        	
        	//si c'est un espace
        	if(t==' '){
        		//on enregistre la position de l'espace
        		C = c;
        		break;
        	}
        }
        //on d�coupe notre premi�re ligne
        String desc = gui.desc.substring(0, C);
        
        //et on r�cup�re le reste
        String desc1 = gui.desc.substring(C+1, gui.desc.length());
        
        //affichage de la premi�re ligne
        gui.drawString(gui.mc.fontRenderer, desc, x+gui.decalage-145, 70, 0xd8d8d8);
        
        //on recommence la m�me proc�dure pour la ou les lignes suivantes
        String desc2 = desc1;
        C = desc2.length();
        if(desc2.length()<= 34){
        	gui.drawString(gui.mc.fontRenderer, desc1, x+gui.decalage-145, 78, 0xd8d8d8);
        	return;
        }
        for(int o=34 ; o>-1;o--){
        	char t = desc1.charAt(o);
        	if(t==' '){
        		C = o;
        		break;
        	}         	
        }

        desc = desc2.substring(0, C);
        desc1 = desc2.substring(C+1, desc2.length());
        gui.drawString(gui.mc.fontRenderer, desc, x+gui.decalage-145, 78, 0xd8d8d8);
        gui.drawString(gui.mc.fontRenderer, desc1, x+gui.decalage-145, 86, 0xd8d8d8); 	

    }

    /**
	 * Affichage de l'entity dans le gui
	 */
	public static void displayMob(int x, int y, GuiIngame gui){
    	
            GL11.glEnable(GL11.GL_COLOR_MATERIAL);
            GL11.glPushMatrix();
            GL11.glTranslatef((float)((x-130)+gui.decalage), (float)60, 50.0F);
            GL11.glScalef((float)(-10), (float)10, (float)10);
            GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
            float var6 = gui.mob.renderYawOffset;
            float var7 = gui.mob.rotationYaw;
            float var8 = gui.mob.rotationPitch;         
            
            GL11.glRotatef(gui.mc.thePlayer.rotationYaw-43, 0.0F, 1.0F, 0.0F);
            RenderHelper.enableStandardItemLighting();
            GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, gui.mob.yOffset, 0.0F);
            RenderManager.instance.playerViewY = 180.0F;
            RenderManager.instance.renderEntityWithPosYaw(gui.mob, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
//            gui.mob.renderYawOffset = var6;
            gui.mob.rotationYaw = var7;
            gui.mob.rotationPitch = var8;
            GL11.glPopMatrix();
            RenderHelper.disableStandardItemLighting();
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
	
	public static void decompte(GuiIngame gui){
		--decompte;

		if((decompte <= 0) || (Mouse.isButtonDown(0) && gui.id == 112)){
			decompte = 80;
			gui.pointage = false;
			gui.screenDesc = false;
		}
	}
}

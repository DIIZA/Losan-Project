package Losan.Utils;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import Losan.Gui.GuiContainerCrafts;

public class CraftingFinder {
	
	public static int spawn;
	
	public static void set(GuiContainerCrafts gui, ItemStack ref){ //ajout
		
		if(ref.getItem() == new ItemStack(Block.stone, 1, 0).getItem())
		{
			gui.recipe = 1;
			gui.vide = false;
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Block.cobblestone, 1));
				gui.contCrafts.slotCrafts.setSlot(8, gui.setSmelt());
		}
		else if(ref.getItem() == new ItemStack(Block.planks).getItem())
		{
			gui.vide = false;
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.wood, 1, ref.getItemDamage()));
				
		}
		else if(ref.getItem() == new ItemStack(Block.blockLapis).getItem())
		{
			gui.vide = false;
			for(int x=0; x<9; x++)
				gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.dyePowder, 1, 4));
		}
		else if(ref.getItem() == new ItemStack(Block.dispenser).getItem())
		{
			gui.vide = false;
			for(int x=0; x<9; x++){
				if(x == 4)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.bow, 1, ref.getItemDamageForDisplay()));
				else if(x == 7)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.redstone, 1, ref.getItemDamageForDisplay()));
				else
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.cobblestone, 1, ref.getItemDamageForDisplay()));
				
			}
		}
		else if(ref.getItem() == new ItemStack(Block.sandStone).getItem())
		{
			gui.vide = false;
			if(ref.getIconIndex() == new ItemStack(Block.sandStone, 1, 0).getIconIndex()){
				for(int x=0; x<9; x++){
					if(x == 3 || x == 4 || x == 6 || x == 7)
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.sand, 1));
				}
			}
			if(ref.getIconIndex() == new ItemStack(Block.sandStone, 1, 1).getIconIndex()){
				for(int x=0; x<9; x++){
					if(x == 4 || x == 7)
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.stoneSingleSlab, 1, 1));
				}
			}
			if(ref.getIconIndex() == new ItemStack(Block.sandStone, 1, 2).getIconIndex()){
				for(int x=0; x<9; x++){
					if(x == 3 || x == 4 || x == 6 || x == 7)
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.sandStone, 1, 2));
				}
			}
		}
		else if(ref.getItem() == new ItemStack(Block.music).getItem())
		{
			gui.vide = false;
			for(int x=0; x<9; x++){
				if(x == 4)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.redstone, 1));
				else
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.planks, 1));
				
			}
		}
		else if(ref.getItem() == new ItemStack(Block.railPowered).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(Block.railPowered, 6));
			for(int x=0; x<9; x++){
				if(x == 0 || x == 2 || x == 3 || x == 5 || x == 6 || x == 8)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.ingotGold, 1));
				else if(x == 4)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.stick, 1));
				else if(x == 7)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.redstone, 1));
				
			}
		}
		else if(ref.getItem() == new ItemStack(Block.railDetector).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(Block.railDetector, 6));
			for(int x=0; x<9; x++){
				if(x == 0 || x == 2 || x == 3 || x == 5 || x == 6 || x == 8)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.ingotIron, 1));
				else if(x == 4)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.pressurePlateStone, 1));
				else if(x == 7)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.redstone, 1));
				
			}
		}
		else if(ref.getItem() == new ItemStack(Block.pistonStickyBase).getItem())
		{
			gui.vide = false;
			for(int x=0; x<9; x++){
				if(x == 4)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.slimeBall, 1));
				else if(x == 7)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.pistonBase, 1));
				
			}
		}
		else if(ref.getItem() == new ItemStack(Block.pistonBase).getItem())
		{
			gui.vide = false;
			for(int x=0; x<9; x++){
				if(x == 3 || x == 5 || x == 6|| x == 8)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.cobblestone, 1));
				if(x == 0 || x == 1 || x == 2)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.planks, 1));
				else if(x == 4)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.ingotIron, 1));
				else if(x == 7)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.redstone, 1));
				
			}
		}
		else if(ref.getItem() == new ItemStack(Block.cloth).getItem())
		{
			
			gui.vide = false;
			if(ref.getItemDamage() == 0){
				gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.silk, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.silk, 1));
				gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.silk, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.silk, 1));
				
			}
			else
			{	
//				if(conterHexa != 1)
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.cloth, 1, gui.counterHexa()));
			}
			if(ref.getItemDamage() == 1){

				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 14));
			}
			if(ref.getItemDamage() == 2){

				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 13));
			}
			if(ref.getItemDamage() == 3){

				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 12));
			}
			if(ref.getItemDamage() == 4){

				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 11));
			}
			if(ref.getItemDamage() == 5){

				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 10));
			}
			if(ref.getItemDamage() == 6){

				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 9));
			}
			if(ref.getItemDamage() == 7){

				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 7));
			}
			if(ref.getItemDamage() == 8){

				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 8));
			}
			if(ref.getItemDamage() == 9){

				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 6));
			}
			if(ref.getItemDamage() == 10){

				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 5));
			}
			if(ref.getItemDamage() == 11){

				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 4));
			}
			if(ref.getItemDamage() == 12){

				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 3));
			}
			if(ref.getItemDamage() == 13){

				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 2));
			}
			if(ref.getItemDamage() == 14){

				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 1));
			}
			if(ref.getItemDamage() == 15){
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 0));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.blockGold).getItem())
		{
			gui.vide = false;
			for(int x=0; x<9; x++)
				gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.ingotGold, 1));
		}
		else if(ref.getItem() == new ItemStack(Block.blockSteel).getItem())
		{
			gui.vide = false;
			for(int x=0; x<9; x++)
				gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.ingotIron, 1));
		}
		else if(ref.getItem() == new ItemStack(Block.stoneSingleSlab).getItem())
		{
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 6, ref.getItemDamage()));
			gui.vide = false;
			if(ref.getItemDamage() == 0){
				gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Block.stone, 1, 0));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.stone, 1, 0));
				gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Block.stone, 1, 0));
			}
			else if(ref.getItemDamage() == 1){
				gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Block.sandStone, 1, 0));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.sandStone, 1, 0));
				gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Block.sandStone, 1, 0));
			}
			else if(ref.getItemDamage() == 3){
				gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Block.cobblestone, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.cobblestone, 1));
				gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Block.cobblestone, 1));
			}
			else if(ref.getItemDamage() == 4){
				gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Block.brick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.brick, 1));
				gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Block.brick, 1));
			}
			else{
				gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Block.stoneBrick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.stoneBrick, 1));
				gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Block.stoneBrick, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.brick).getItem())
		{
			gui.vide = false;
			if(ref.getItemDamage() == 0){
				gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.brick, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.brick, 1));
				gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.brick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.brick, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.tnt).getItem())
		{
			gui.vide = false;
			for(int x=0; x<9; x++){
				if(x == 0 || x == 2 || x == 4|| x == 6 || x == 8)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.gunpowder, 1));
				if(x == 1 || x == 3 || x == 5|| x == 7)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.sand, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.bookShelf).getItem())
		{
			gui.vide = false;
			for(int x=0; x<9; x++){
				if(x == 3 || x == 4 || x == 5)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.book, 1));
				else
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.planks, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.torchWood).getItem())
		{
			gui.vide = false;
					gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
					gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.coal, 1));

		}
		else if(ref.getItem() == new ItemStack(Block.stairCompactPlanks).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
			for(int x=0; x<9; x++){
				if(x == 0 || x == 3 || x == 4 || x == 6 || x == 7 || x == 8)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.planks, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.stairCompactCobblestone).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
			for(int x=0; x<9; x++){
				if(x == 0 || x == 3 || x == 4 || x == 6 || x == 7 || x == 8)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.cobblestone, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.stairsBrick).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
			for(int x=0; x<9; x++){
				if(x == 0 || x == 3 || x == 4 || x == 6 || x == 7 || x == 8)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.brick, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.stairsNetherBrick).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
			for(int x=0; x<9; x++){
				if(x == 0 || x == 3 || x == 4 || x == 6 || x == 7 || x == 8)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.netherBrick, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.stairsSandStone).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
			for(int x=0; x<9; x++){
				if(x == 0 || x == 3 || x == 4 || x == 6 || x == 7 || x == 8)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.sandStone, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.stairsStoneBrickSmooth).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
			for(int x=0; x<9; x++){
				if(x == 0 || x == 3 || x == 4 || x == 6 || x == 7 || x == 8)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.stoneBrick, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.stairsWoodBirch).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
			for(int x=0; x<9; x++){
				if(x == 0 || x == 3 || x == 4 || x == 6 || x == 7 || x == 8)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.planks, 1, 2));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.stairsWoodJungle).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
			for(int x=0; x<9; x++){
				if(x == 0 || x == 3 || x == 4 || x == 6 || x == 7 || x == 8)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.planks, 1, 3));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.stairsWoodSpruce).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
			for(int x=0; x<9; x++){
				if(x == 0 || x == 3 || x == 4 || x == 6 || x == 7 || x == 8)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.planks, 1, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.chest).getItem())
		{
			gui.vide = false;
			for(int x=0; x<9; x++){
				if(x != 4)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.planks, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.blockDiamond).getItem())
		{
			gui.vide = false;
			for(int x=0; x<9; x++){
				gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.diamond, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.workbench).getItem())
		{
			gui.vide = false;
			for(int x=0; x<9; x++){
				if(x == 7 || x == 3 || x == 4 || x == 6)
				gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.planks, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.stoneOvenIdle).getItem())
		{
			gui.vide = false;
			for(int x=0; x<9; x++){
				if(x != 4)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.cobblestone, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.ladder).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 3));
			for(int x=0; x<9; x++){
				if(x != 1 && x != 7)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.stick, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.rail).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 16));
			for(int x=0; x<9; x++){
				if(x == 0 || x == 2 || x == 3 || x == 5 || x == 6 || x == 8)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.ingotIron, 1));
			}
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Block.lever).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.cobblestone, 1));
		}
		else if(ref.getItem() == new ItemStack(Block.pressurePlatePlanks).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Block.planks, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.planks, 1));
		}
		else if(ref.getItem() == new ItemStack(Block.pressurePlateStone).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Block.stone, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.stone, 1));
		}
		else if(ref.getItem() == new ItemStack(Block.torchRedstoneActive).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.redstone, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Block.stoneOvenActive).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.stone, 1));
		}
		else if(ref.getItem() == new ItemStack(Block.ice).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.recipe = 0;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.iceCube, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.iceCube, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.iceCube, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.iceCube, 1));
		}
		else if(ref.getItem() == new ItemStack(Block.blockSnow).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.snowball, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.snowball, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.snowball, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.snowball, 1));
		}
		else if(ref.getItem() == new ItemStack(Block.blockClay).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.clay, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.clay, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.clay, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.clay, 1));
		}
		else if(ref.getItem() == new ItemStack(Block.jukebox).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			for(int x=0; x<9; x++){
				if(x == 4)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.diamond, 1));	
				else
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.planks, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.fence).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 2));
			for(int x=0; x<9; x++){
				if(x > 2)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.stick, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.glowStone).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.lightStoneDust, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.lightStoneDust, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.lightStoneDust, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.lightStoneDust, 1));
		}
		else if(ref.getItem() == new ItemStack(Block.pumpkinLantern).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.pumpkin, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.torchWood, 1));
		}
		else if(ref.getItem() == new ItemStack(Block.trapdoor).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 2));
			for(int x=0; x<9; x++){
				if(x > 2)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.planks, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.stoneBrick).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Block.stone, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.stone, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Block.stone, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.stone, 1));
		}
		else if(ref.getItem() == new ItemStack(Block.fenceIron).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 16));
			for(int x=0; x<9; x++){
				if(x > 2)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.ingotIron, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.thinGlass).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 16));
			for(int x=0; x<9; x++){
				if(x > 2)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.glass, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.fenceGate).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			int a = 0;

			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.stick, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.planks, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.stick, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.stick, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.planks, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.stick, 1));

					

		}
		else if(ref.getItem() == new ItemStack(Block.netherFence).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 6));
			for(int x=0; x<9; x++){
				if(x > 2)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.netherBrick, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.enchantmentTable).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));

			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.book, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.diamond, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.obsidian, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.diamond, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Block.obsidian, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.obsidian, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Block.obsidian, 1));
		}
		else if(ref.getItem() == new ItemStack(Block.redstoneLampIdle).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));

			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.redstone, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.redstone, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.glowStone, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.redstone, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.redstone, 1));
		}
		else if(ref.getItem() == new ItemStack(Block.woodSingleSlab).getItem())
		{
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 6, ref.getItemDamage()));
			gui.vide = false;
				gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Block.planks, 1, ref.getItemDamage()));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.planks, 1, ref.getItemDamage()));
				gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Block.planks, 1, ref.getItemDamage()));
		}
		else if(ref.getItem() == new ItemStack(Block.enderChest).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			for(int x=0; x<9; x++){
				if(x == 4)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.eyeOfEnder, 1));	
				else
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.obsidian, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.tripWireSource).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.ingotIron, 1));	
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.planks, 1));	
		}
		else if(ref.getItem() == new ItemStack(Block.blockEmerald).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			for(int x=0; x<9; x++){
				gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.emerald, 1));	
			}	
		}
		else if(ref.getItem() == new ItemStack(Block.freezera).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			for(int x=0; x<9; x++){
				if(x == 4)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.redstone, 1));
				else
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.ingotIron, 1));
			}	
		}
		else if(ref.getItem() == new ItemStack(Block.fut).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			
				gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.ingotIron, 1));	
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.ingotIron, 1));	
				gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.ingotIron, 1));	
				gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.stick, 1));	
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));	
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.stick, 1));	
				gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.ingotIron, 1));	
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.ingotIron, 1));	
				gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.ingotIron, 1));	
				
		}
		else if(ref.getItem() == new ItemStack(Block.poubelle).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			
				gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.ingotIron, 1));	
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.ingotIron, 1));	
				gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.ingotIron, 1));	
				gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.paper, 1));		
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.paper, 1));	
				gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.paper, 1));	
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.paper, 1));	
				gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.paper, 1));	
				
		}
		else if(ref.getItem() == new ItemStack(Block.etagereBois).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			
				gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Block.pressurePlatePlanks, 1));	
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.pressurePlatePlanks, 1));	
				gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.stick, 1));						
		}
		else if(ref.getItem() == new ItemStack(Block.chaise).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Block.fence, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Block.pressurePlatePlanks, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.pressurePlatePlanks, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Block.pressurePlatePlanks, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Block.fence, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Block.fence, 1));
		}
		else if(ref.getItem() == new ItemStack(Block.chaiseModerne).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Block.cloth, 1, 15));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Block.moquette, 1, 7));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.moquette, 1, 7));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Block.moquette, 1, 7));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Block.cloth, 1, 15));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Block.cloth, 1, 15));
		}
		else if(ref.getItem() == new ItemStack(Block.Redstone).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			for(int x=0; x<9; x++){
				gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.redstone, 1));	
			}	
		}
		else if(ref.getItem() == new ItemStack(Block.coloredGlowStone).getItem())
		{
			gui.vide = false;
			
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.coloredGlowStone, 1, gui.counterHexa()));			
			
			if(ref.getItemDamage() == 0){
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 15));	
			}
			else if(ref.getItemDamage() == 1){
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 14));	
			}	
			else if(ref.getItemDamage() == 2){
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 13));	
			}	
			else if(ref.getItemDamage() == 3){
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 12));	
			}	
			else if(ref.getItemDamage() == 4){
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 11));	
			}	
			else if(ref.getItemDamage() == 5){
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 10));	
			}	
			else if(ref.getItemDamage() == 6){
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 9));	
			}	
			else if(ref.getItemDamage() == 7){
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 7));	
			}	
			else if(ref.getItemDamage() == 8){
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 8));	
			}	
			else if(ref.getItemDamage() == 9){
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 6));	
			}	
			else if(ref.getItemDamage() == 10){
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 5));	
			}
			else if(ref.getItemDamage() == 11){
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 4));	
			}	
			else if(ref.getItemDamage() == 12){
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 3));	
			}	
			else if(ref.getItemDamage() == 13){
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 2));	
			}	
			else if(ref.getItemDamage() == 14){
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 1));	
			}	
			else if(ref.getItemDamage() == 15){
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 0));	
			}	
		}
		else if(ref.getItem() == new ItemStack(Block.Color_Glass).getItem())
		{
			gui.vide = false;
			
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.Color_Glass, 1, gui.counterHexa()));

			
			if(ref.getItemDamage() == 0){
				
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 15));	
			}
			if(ref.getItemDamage() == 1){
				
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 14));	
			}	
			if(ref.getItemDamage() == 2){
				
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 13));	
			}	
			if(ref.getItemDamage() == 3){
				
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 12));	
			}	
			if(ref.getItemDamage() == 4){
				
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 11));	
			}	
			if(ref.getItemDamage() == 5){
				
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 10));	
			}	
			if(ref.getItemDamage() == 6){
				
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 9));	
			}	
			if(ref.getItemDamage() == 7){
				
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 7));	
			}	
			if(ref.getItemDamage() == 8){
				
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 8));	
			}	
			if(ref.getItemDamage() == 9){
				
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 6));	
			}	
			if(ref.getItemDamage() == 10){
				
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 5));	
			}
			if(ref.getItemDamage() == 11){
				
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 4));	
			}	
			if(ref.getItemDamage() == 12){
				
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 3));	
			}	
			if(ref.getItemDamage() == 13){
				
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 2));	
			}	
			if(ref.getItemDamage() == 14){
				
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 1));	
			}	
			if(ref.getItemDamage() == 15){
				
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 0));	
			}	
		}
		else if(ref.getItem() == new ItemStack(Block.moquette).getItem())
		{
			gui.vide = false;
			if(!gui.last){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1, gui.lastDamage));
				ref = new ItemStack((Block.moquette), 1, gui.lastDamage);
				
			}
			gui.lastDamage = ref.getItemDamage();
			
			
			if(gui.time <=25)
			{
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 3, ref.getItemDamage()));
				
				gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Block.cloth, 1, ref.getItemDamage()));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.cloth, 1, ref.getItemDamage()));
				gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Block.cloth, 1, ref.getItemDamage()));
			}
			else if(gui.time>25)
			{
				if(ref.getItemDamage() == 0){
					gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.moquette, 1));
					gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 15));	
				}
				else if(ref.getItemDamage() == 1){
					gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.moquette, 1));
					gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 14));	
				}	
				else if(ref.getItemDamage() == 2){
					gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.moquette, 1));
					gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 13));	
				}	
				else if(ref.getItemDamage() == 3){
					gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.moquette, 1));
					gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 12));	
				}	
				else if(ref.getItemDamage() == 4){
					gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.moquette, 1));
					gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 11));	
				}	
				else if(ref.getItemDamage() == 5){
					gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.moquette, 1));
					gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 10));	
				}	
				else if(ref.getItemDamage() == 6){
					gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.moquette, 1));
					gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 9));	
				}	
				else if(ref.getItemDamage() == 7){
					gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.moquette, 1));
					gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 7));	
				}	
				else if(ref.getItemDamage() == 8){
					gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.moquette, 1));
					gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 8));	
				}	
				else if(ref.getItemDamage() == 9){
					gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.moquette, 1));
					gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 6));	
				}	
				else if(ref.getItemDamage() == 10){
					gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.moquette, 1));
					gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 5));	
				}
				else if(ref.getItemDamage() == 11){
					gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.moquette, 1));
					gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 4));	
				}	
				else if(ref.getItemDamage() == 12){
					gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.moquette, 1));
					gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 3));	
				}	
				else if(ref.getItemDamage() == 13){
					gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.moquette, 1));
					gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 2));	
				}	
				else if(ref.getItemDamage() == 14){
					gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.moquette, 1));
					gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 1));	
				}	
				else if(ref.getItemDamage() == 15){
					gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.moquette, 1));
					gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 0));	
				}
			}
			gui.last=false;
		}
		else if(ref.getItem() == new ItemStack(Block.obsidian).getItem())
		{
			
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
//			if(gui.base>100){
				gui.recipe = 2;
				gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.bucketLava, 1));
				gui.contCrafts.slotCrafts.setSlot(8, gui.setFreeze());
//			}else if(gui.base<=100){
//				for(int x=0; x<9; x++)
//					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.ingotObsidian, 1));
//				
//			}
		}
		
		
		
		else if(ref.getItem() == new ItemStack(Block.Escalier_Wool_BLANC).getItem())
		{
			gui.vide = false;
			
			if(gui.time>25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.Escalier_Wool_BLANC, 1));
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 15));
			}else if(gui.time<=25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
				for(int x=0; x<9; x++)
					if (x != 1 && x!=2 && x!=5)
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.cloth, 1, 0));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.Escalier_Wool_ORANGE).getItem())
		{
			gui.vide = false;
			
			if(gui.time>25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.Escalier_Wool_BLANC, 1));
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 14));
			}else if(gui.time<=25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
				for(int x=0; x<9; x++)
					if (x != 1 && x!=2 && x!=5)
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.cloth, 1, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.Escalier_Wool_MAGENTA).getItem())
		{
			gui.vide = false;
			
			if(gui.time>25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.Escalier_Wool_BLANC, 1));
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 13));
			}else if(gui.time<=25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
				for(int x=0; x<9; x++)
					if (x != 1 && x!=2 && x!=5)
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.cloth, 1, 2));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.Escalier_Wool_BLEUCIEL).getItem())
		{
			gui.vide = false;
			
			if(gui.time>25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.Escalier_Wool_BLANC, 1));
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 12));
			}else if(gui.time<=25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
				for(int x=0; x<9; x++)
					if (x != 1 && x!=2 && x!=5)
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.cloth, 1, 3));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.Escalier_Wool_JAUNE).getItem())
		{
			gui.vide = false;
			
			if(gui.time>25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.Escalier_Wool_BLANC, 1));
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 11));
			}else if(gui.time<=25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
				for(int x=0; x<9; x++)
					if (x != 1 && x!=2 && x!=5)
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.cloth, 1, 4));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.Escalier_Wool_VERTCLAIR).getItem())
		{
			gui.vide = false;
			
			if(gui.time>25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.Escalier_Wool_BLANC, 1));
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 10));
			}else if(gui.time<=25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
				for(int x=0; x<9; x++)
					if (x != 1 && x!=2 && x!=5)
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.cloth, 1, 5));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.Escalier_Wool_ROSE).getItem())
		{
			gui.vide = false;
			
			if(gui.time>25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.Escalier_Wool_BLANC, 1));
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 9));
			}else if(gui.time<=25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
				for(int x=0; x<9; x++)
					if (x != 1 && x!=2 && x!=5)
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.cloth, 1, 6));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.Escalier_Wool_GRIS).getItem())
		{
			gui.vide = false;
			
			if(gui.time>25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.Escalier_Wool_BLANC, 1));
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 8));
			}else if(gui.time<=25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
				for(int x=0; x<9; x++)
					if (x != 1 && x!=2 && x!=5)
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.cloth, 1, 7));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.Escalier_Wool_GRISCLAIR).getItem())
		{
			gui.vide = false;
			
			if(gui.time>25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.Escalier_Wool_BLANC, 1));
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 7));
			}else if(gui.time<=25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
				for(int x=0; x<9; x++)
					if (x != 1 && x!=2 && x!=5)
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.cloth, 1, 8));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.Escalier_Wool_AQUA).getItem())
		{
			gui.vide = false;
			
			if(gui.time>25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.Escalier_Wool_BLANC, 1));
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 6));
			}else if(gui.time<=25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
				for(int x=0; x<9; x++)
					if (x != 1 && x!=2 && x!=5)
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.cloth, 1, 9));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.Escalier_Wool_VIOLET).getItem())
		{
			gui.vide = false;
			
			if(gui.time>25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.Escalier_Wool_BLANC, 1));
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 5));
			}else if(gui.time<=25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
				for(int x=0; x<9; x++)
					if (x != 1 && x!=2 && x!=5)
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.cloth, 1, 10));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.Escalier_Wool_BLEU).getItem())
		{
			gui.vide = false;
			
			if(gui.time>25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.Escalier_Wool_BLANC, 1));
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 4));
			}else if(gui.time<=25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
				for(int x=0; x<9; x++)
					if (x != 1 && x!=2 && x!=5)
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.cloth, 1, 11));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.Escalier_Wool_MARRON).getItem())
		{
			gui.vide = false;
			
			if(gui.time>25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.Escalier_Wool_BLANC, 1));
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 3));
			}else if(gui.time<=25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
				for(int x=0; x<9; x++)
					if (x != 1 && x!=2 && x!=5)
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.cloth, 1, 12));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.Escalier_Wool_VERT).getItem())
		{
			gui.vide = false;
			
			if(gui.time>25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.Escalier_Wool_BLANC, 1));
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 2));
			}else if(gui.time<=25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
				for(int x=0; x<9; x++)
					if (x != 1 && x!=2 && x!=5)
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.cloth, 1, 13));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.Escalier_Wool_ROUGE).getItem())
		{
			gui.vide = false;
			
			if(gui.time>25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.Escalier_Wool_BLANC, 1));
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 1));
			}else if(gui.time<=25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
				for(int x=0; x<9; x++)
					if (x != 1 && x!=2 && x!=5)
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.cloth, 1, 14));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.Escalier_Wool_BLACK).getItem())
		{
			gui.vide = false;
			
			if(gui.time>25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.Escalier_Wool_BLANC, 1));
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 0));
			}else if(gui.time<=25){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
				for(int x=0; x<9; x++)
					if (x != 1 && x!=2 && x!=5)
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.cloth, 1, 15));
			}
		}
		else if(ref.getItem() == new ItemStack(Item.shovelWood).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Block.planks, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.shovelStone).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Block.cobblestone, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.shovelSteel).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.ingotIron, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.shovelGold).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.ingotGold, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.shovelDiamond).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.diamond, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.shovelRubis).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.rubis, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.shovelEmeraude).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.emerald, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		
		
		else if(ref.getItem() == new ItemStack(Item.swordWood).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Block.planks, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.planks, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.swordStone).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Block.cobblestone, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.cobblestone, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.swordSteel).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.ingotIron, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.ingotIron, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.swordGold).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.ingotGold, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.ingotGold, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.swordDiamond).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.diamond, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.diamond, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.swordRubis).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.rubis, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.rubis, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.swordEmeraude).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.emerald, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.emerald, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		
		
		else if(ref.getItem() == new ItemStack(Item.axeWood).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Block.planks, 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Block.planks, 1));
				gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Block.planks, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.axeStone).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Block.cobblestone, 1));
				gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Block.cobblestone, 1));
				gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Block.cobblestone, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.axeSteel).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.ingotIron, 1));
				gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.ingotIron, 1));
				gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.ingotIron, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.axeGold).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.ingotGold, 1));
				gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.ingotGold, 1));
				gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.ingotGold, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.axeDiamond).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.diamond, 1));
				gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.diamond, 1));
				gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.diamond, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.axeRubis).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.rubis, 1));
				gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.rubis, 1));
				gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.rubis, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.axeEmeraude).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.emerald, 1));
				gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.emerald, 1));
				gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.emerald, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		
		
		else if(ref.getItem() == new ItemStack(Item.pickaxeWood).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Block.planks, 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Block.planks, 1));
				gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Block.planks, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.pickaxeStone).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Block.cobblestone, 1));
				gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Block.cobblestone, 1));
				gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Block.cobblestone, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.pickaxeSteel).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.ingotIron, 1));
				gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.ingotIron, 1));
				gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.ingotIron, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.pickaxeGold).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.ingotGold, 1));
				gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.ingotGold, 1));
				gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.ingotGold, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.pickaxeDiamond).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.diamond, 1));
				gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.diamond, 1));
				gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.diamond, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.pickaxeRubis).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.rubis, 1));
				gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.rubis, 1));
				gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.rubis, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.pickaxeEmeraude).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.emerald, 1));
				gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.emerald, 1));
				gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.emerald, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		
		else if(ref.getItem() == new ItemStack(Item.hoeWood).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Block.planks, 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Block.planks, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.hoeStone).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Block.cobblestone, 1));
				gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Block.cobblestone, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.hoeSteel).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.ingotIron, 1));
				gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.ingotIron, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.hoeGold).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.ingotGold, 1));
				gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.ingotGold, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.hoeDiamond).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.diamond, 1));
				gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.diamond, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.hoeRubis).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.rubis, 1));
				gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.rubis, 1));

				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.hoeEmeraude).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.emerald, 1));
				gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.emerald, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.flintAndSteel).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.ingotIron, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.flint, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.bow).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.silk, 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.silk, 1));
				gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.silk, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.arrow).getItem())
		{
			gui.vide = false;				
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.flint, 1));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.stick, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.feather, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.coal).getItem())
		{
			if(ref.getItemDamage() == 1){
			gui.vide = false;				
			gui.recipe = 1;
			if(gui.counterHexa() >3)
				gui.lastTime = 0;
				gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Block.wood, 1, gui.counterHexa()));
				gui.contCrafts.slotCrafts.setSlot(8, gui.setSmelt());
			}
		}
		else if(ref.getItem() == new ItemStack(Item.diamond).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 9));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.blockDiamond, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.ingotGold).getItem())
		{
			gui.vide = false;
			if(gui.base <=60){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 9));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.blockGold, 1));
			}
			else if(gui.base > 60 && gui.base <= 150){
				gui.recipe = 1;
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Block.oreGold, 1));
				gui.contCrafts.slotCrafts.setSlot(8, gui.setSmelt());
			}
			else if(gui.base > 150){
				gui.vide = false;
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 9));
				for(int x = 0;x<9;x++)		
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.goldNugget, 1));
				
			}
		}
		else if(ref.getItem() == new ItemStack(Item.ingotIron).getItem())
		{
			gui.vide = false;
			if(gui.base <=100){
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 9));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.blockSteel, 1));
			}
			else if(gui.base >100){
				gui.recipe = 1;
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
				gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Block.blockSteel, 1));
				gui.contCrafts.slotCrafts.setSlot(8, gui.setSmelt());
			}
		}
		else if(ref.getItem() == new ItemStack(Item.stick).getItem())
		{
			gui.vide = false;
			if(gui.counterHexa() >3)
				gui.lastTime = 0;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.planks, 1, gui.counterHexa()));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.planks, 1, gui.counterHexa()));
		}
		else if(ref.getItem() == new ItemStack(Item.bowlEmpty).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
			if(gui.counterHexa() >3)
				gui.lastTime = 0;
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Block.planks, 1, gui.counterHexa()));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.planks, 1, gui.counterHexa()));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Block.planks, 1, gui.counterHexa()));
		}
		else if(ref.getItem() == new ItemStack(Item.bowlSoup).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Block.mushroomBrown, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.mushroomRed, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.bowlEmpty, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.bread).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.wheat, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.wheat, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.wheat, 1));
		}
		
		
		
		else if(ref.getItem() == new ItemStack(Item.helmetChain).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Block.fire, 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Block.fire, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Block.fire, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Block.fire, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Block.fire, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.helmetDiamond).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.diamond, 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.diamond, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.diamond, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.diamond, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.diamond, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.helmetEmeraude).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.emerald, 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.emerald, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.emerald, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.emerald, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.emerald, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.helmetGold).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.ingotGold, 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.ingotGold, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.ingotGold, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.ingotGold, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.ingotGold, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.helmetLeather).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.leather, 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.leather, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.leather, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.leather, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.leather, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.helmetLezard).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.lezardSkin, 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.lezardSkin, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.lezardSkin, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.lezardSkin, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.lezardSkin, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.helmetRubis).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.rubis, 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.rubis, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.rubis, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.rubis, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.rubis, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.helmetSteel).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.ingotIron, 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.ingotIron, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.ingotIron, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.ingotIron, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.ingotIron, 1));
		}

			
	
		else if(ref.getItem() == new ItemStack(Item.plateChain).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Block.fire, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.fire, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Block.fire, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Block.fire, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Block.fire, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Block.fire, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.fire, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Block.fire, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.plateDiamond).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.diamond, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.diamond, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.diamond, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.diamond, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.diamond, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.diamond, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.diamond, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.diamond, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.plateEmeraude).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.emerald, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.emerald, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.emerald, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.emerald, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.emerald, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.emerald, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.emerald, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.emerald, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.plateGold).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.ingotGold, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.ingotGold, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.ingotGold, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.ingotGold, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.ingotGold, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.ingotGold, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.ingotGold, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.ingotGold, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.plateLeather).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.leather, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.leather, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.leather, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.leather, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.leather, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.leather, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.leather, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.leather, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.plateLezard).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.lezardSkin, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.lezardSkin, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.lezardSkin, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.lezardSkin, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.lezardSkin, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.lezardSkin, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.lezardSkin, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.lezardSkin, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.plateRubis).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.rubis, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.rubis, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.rubis, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.rubis, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.rubis, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.rubis, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.rubis, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.rubis, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.plateSteel).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.ingotIron, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.ingotIron, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.ingotIron, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.ingotIron, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.ingotIron, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.ingotIron, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.ingotIron, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.ingotIron, 1));
		}
		
		
		
		
		else if(ref.getItem() == new ItemStack(Item.legsChain).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Block.fire, 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Block.fire, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Block.fire, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Block.fire, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Block.fire, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Block.fire, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Block.fire, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.legsDiamond).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.diamond, 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.diamond, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.diamond, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.diamond, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.diamond, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.diamond, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.diamond, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.legsEmeraude).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.emerald, 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.emerald, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.emerald, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.emerald, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.emerald, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.emerald, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.emerald, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.legsGold).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.ingotGold, 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.ingotGold, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.ingotGold, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.ingotGold, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.ingotGold, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.ingotGold, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.ingotGold, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.legsLeather).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.leather, 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.leather, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.leather, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.leather, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.leather, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.leather, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.leather, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.legsLezard).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.lezardSkin, 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.lezardSkin, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.lezardSkin, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.lezardSkin, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.lezardSkin, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.lezardSkin, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.lezardSkin, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.legsRubis).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.rubis, 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.rubis, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.rubis, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.rubis, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.rubis, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.rubis, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.rubis, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.legsSteel).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.ingotIron, 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.ingotIron, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.ingotIron, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.ingotIron, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.ingotIron, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.ingotIron, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.ingotIron, 1));
		}
		
		
		
		
		else if(ref.getItem() == new ItemStack(Item.bootsChain).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Block.fire, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Block.fire, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Block.fire, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Block.fire, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.bootsDiamond).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.diamond, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.diamond, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.diamond, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.diamond, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.bootsEmeraude).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.emerald, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.emerald, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.emerald, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.emerald, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.bootsGold).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.ingotGold, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.ingotGold, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.ingotGold, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.ingotGold, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.bootsLeather).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.leather, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.leather, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.leather, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.leather, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.bootsLezard).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.lezardSkin, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.lezardSkin, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.lezardSkin, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.lezardSkin, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.bootsRubis).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.rubis, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.rubis, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.rubis, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.rubis, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.bootsSteel).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.ingotIron, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.ingotIron, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.ingotIron, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.ingotIron, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.porkCooked).getItem())
		{
			gui.vide = false;
			gui.recipe = 1;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.porkRaw, 1));
			gui.contCrafts.slotCrafts.setSlot(8, gui.setSmelt());
		}
		else if(ref.getItem() == new ItemStack(Item.beefCooked).getItem())
		{
			gui.vide = false;
			gui.recipe = 1;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.beefRaw, 1));
			gui.contCrafts.slotCrafts.setSlot(8, gui.setSmelt());
		}
		else if(ref.getItem() == new ItemStack(Item.chickenCooked).getItem())
		{
			gui.vide = false;
			gui.recipe = 1;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.chickenRaw, 1));
			gui.contCrafts.slotCrafts.setSlot(8, gui.setSmelt());
		}
		else if(ref.getItem() == new ItemStack(Item.fishCooked).getItem())
		{
			gui.vide = false;
			gui.recipe = 1;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.fishRaw, 1));
			gui.contCrafts.slotCrafts.setSlot(8, gui.setSmelt());
		}
		else if(ref.getItem() == new ItemStack(Item.painting).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			for(int x=0;x<9;x++)
				if(x!=4)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.stick, 1));
				else
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.cloth, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.appleGold, 1, 1).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1, 1));
				for(int x=0;x<9;x++)
					if(x!=4)
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.blockGold, 1));
					else
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.appleRed, 1));
			
			
		}
		else if(ref.getItem() == new ItemStack(Item.appleGold, 1, 0).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1, 0));
			
				for(int x=0;x<9;x++)
					if(x!=4)
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.goldNugget, 1));
					else
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.appleRed, 1));
			
		}
		else if(ref.getItem() == new ItemStack(Item.sign).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 3));
			if(gui.counterHexa() > 3)
				gui.lastTime = 0;
			for(int x=0;x<9;x++)
				if(x<6)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.planks, 1, gui.counterHexa()));
				else if(x == 7)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.doorWood).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 3));
			if(gui.counterHexa() > 3)
				gui.lastTime = 0;
			for(int x=0;x<9;x++)
				if(x!=0 && x!=3 && x!=6)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.planks));
		}
		else if(ref.getItem() == new ItemStack(Item.bucketEmpty).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			if(gui.counterHexa() > 3)
				gui.lastTime = 0;
			for(int x=0;x<9;x++)
				if(x==3 || x==7 || x==5)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.glass, 1, gui.counterHexa()));
		}
		else if(ref.getItem() == new ItemStack(Item.minecartEmpty).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			for(int x=0;x<9;x++)
				if(x!=0 && x!=1 && x!=2 && x!=4)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.ingotIron, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.doorSteel).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 3));
			for(int x=0;x<9;x++)
				if(x!=0 && x!=3 && x!=6)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.ingotIron, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.boat).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			if(gui.counterHexa() > 3)
				gui.lastTime = 0;
			for(int x=0;x<9;x++)
				if(x!=0 && x!=1 && x!=2 && x!=4)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.planks, 1, gui.counterHexa()));
		}
		else if(ref.getItem() == new ItemStack(Item.brick).getItem())
		{
			gui.vide = false;
			gui.recipe = 1;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.clay, 1));
			gui.contCrafts.slotCrafts.setSlot(8, gui.setSmelt());
			
		}
		else if(ref.getItem() == new ItemStack(Item.paper).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 3));
			for(int x=6;x<9;x++)		
				gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.reed, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.book).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			for(int x=1;x<9;x++)
				if(x==3)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.leather, 1));
				else if(x==1 || x==4 || x==7)	
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.paper, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.minecartCrate).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			for(int x=0;x<9;x++)
				if(x==4)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.chest, 1));
				else if(x!=0 && x!=1 && x!=2 && x!=4)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.ingotIron, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.minecartPowered).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			for(int x=0;x<9;x++)
				if(x==4)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.stoneOvenIdle, 1));
				else if(x!=0 && x!=1 && x!=2 && x!=4)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.ingotIron, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.compass).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			for(int x=0;x<9;x++)
				if(x==4)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.redstone, 1));
				else if(x==1 || x==3 || x==5 || x==7)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.ingotIron, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.fishingRod).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			for(int x=0;x<9;x++)
				if(x==5 || x==8)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.silk, 1));
				else if(x==6 || x==4 || x==2)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.pocketSundial).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			for(int x=0;x<9;x++)
				if(x==4)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.diamond, 1));
				else if(x==1 || x==3 || x==5 || x==7)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.ingotGold, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.dyePowder).getItem())
		{
			gui.vide = false;
			if(ref.getItemDamage() == 14)
			{
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 2, 14));
				gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.dyePowder, 1, 1));
				gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.dyePowder, 1, 11));
			}
			else if(ref.getItemDamage() == 2)
			{
				gui.recipe = 1;
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 2, 2));
				gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Block.cactus, 1));
				gui.contCrafts.slotCrafts.setSlot(8, gui.setSmelt());
			}
			else if(ref.getItemDamage() == 15)
			{
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 3, 15));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.bone, 1));
			}
			else if(ref.getItemDamage() == 7)
			{
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 2, 7));
				gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.dyePowder, 1, 8));
				gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.dyePowder, 1, 15));
			}
			else if(ref.getItemDamage() == 8)
			{
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 2, 8));
				gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.dyePowder, 1, 0));
				gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.dyePowder, 1, 15));
			}

			else if(ref.getItemDamage() == 11)
			{
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 2, 11));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.plantYellow, 1));
			}
			else if(ref.getItemDamage() == 10)
			{
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 2, 10));
				gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.dyePowder, 1, 2));
				gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.dyePowder, 1, 15));
			}
			else if(ref.getItemDamage() == 6)
			{
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 2, 6));
				gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.dyePowder, 1, 4));
				gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.dyePowder, 1, 2));
			}
			else if(ref.getItemDamage() == 12)
			{
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 2, 12));
				gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.dyePowder, 1, 4));
				gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.dyePowder, 1, 15));
			}
			else if(ref.getItemDamage() == 5)
			{
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 2, 5));
				gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.dyePowder, 1, 4));
				gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.dyePowder, 1, 1));
			}
			else if(ref.getItemDamage() == 13)
			{
				gui.vide = false;
				if(gui.counterHexa()>2)
					gui.lastTime = 0;
				if(gui.counterHexa() == 0){
					gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 2, 13));
					gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.dyePowder, 1, 5));
					gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.dyePowder, 1, 9));
				}
				else if(gui.counterHexa() == 1){
					gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4, 13));
					gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.dyePowder, 1, 4));
					gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.dyePowder, 1, 15));
					gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.dyePowder, 1, 1));
					gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.dyePowder, 1, 1));
				}
				else if(gui.counterHexa() == 2){
					gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 2, 13));
					gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.dyePowder, 1, 4));
					gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.dyePowder, 1, 9));
					gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.dyePowder, 1, 1));
				}
			}
			else if(ref.getItemDamage() == 9)
			{
				gui.vide = false;
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 2, 9));
				gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.dyePowder, 1, 1));
				gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.dyePowder, 1, 15));
			}
			else if(ref.getItemDamage() == 1)
			{
				gui.vide = false;
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 2, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.plantRed, 1, 1));
			}
			else if(ref.getItemDamage() == 4)
			{
				gui.vide = false;
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 9, 4));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.blockLapis, 1, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Item.sugar).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.reed, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.cake).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			for(int x=0;x<9;x++)
				if(x<3)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.bucketMilk, 1));
				else if(x>=3 && x<=5)
					if(x==4)
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.egg, 1));
					else
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.sugar, 1));
				else
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.wheat, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.bed).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			for(int x=0;x<9;x++)
				if(x>2 && x<=5)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.cloth, 1));
				else if(x>5)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.planks, 1));
		}
		else if(ref.getItem() == new ItemStack(Block.redstoneRepeaterActive).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			for(int x=0;x<9;x++)
				if(x>=3 && x<=5)
					if(x==4)
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.redstone, 1));
					else
						gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.torchRedstoneActive, 1));
				else if(x>5)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.stone, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.cookie).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.wheat, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.dyePowder, 1, 3));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.wheat, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.map).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			for(int x=0;x<9;x++){
				if(x==4)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.compass, 1));
				else
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.paper, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Item.shears).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));

					gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.ingotIron, 1));
					gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.ingotIron, 1));
		}
		else if(ref.getItem() == new ItemStack(Block.melon).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));

			for(int x=0;x<9;x++)
				gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.melon, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.melon).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 9));

				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.melon, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.pumpkinSeeds).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));

				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.pumpkin, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.melonSeeds).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));

				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.melon, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.blazePowder).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 2));

				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.blazeRod, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.magmaCream).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));

				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.slimeBall, 1));
				gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.blazePowder, 1));
		}
		else if(ref.getItem() == new ItemStack(Block.brewingStand).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			for(int x=4;x<9;x++)
				if(x==4)
					gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.blazeRod, 1));
				else if(x!=5)
					gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.cobblestone, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.eyeOfEnder).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
					gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.blazePowder, 1));
					gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.enderPearl, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.glassBottle).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
					gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Block.glass, 1));
					gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.glass, 1));
					gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Block.glass, 1));
		}
//		else if(ref.getItem() == new ItemStack(Item.ingotObsidian).getItem())
//		{
//			gui.vide = false;
//			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
//			for(int x=3;x<9;x++)
//				gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.obsidianNugget, 1));
//		}
//		else if(ref.getItem() == new ItemStack(Item.obsidianNugget).getItem())
//		{
//			gui.vide = false;
//			gui.recipe = 1;
//			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
//			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Block.obsidian, 1));
//			gui.contCrafts.slotCrafts.setSlot(8, gui.setSmelt());
//		}
		else if(ref.getItem() == new ItemStack(Item.iceCube).getItem())
		{
			gui.vide = false;
			gui.recipe = 2;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 4));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.bucketWater, 1));
			gui.contCrafts.slotCrafts.setSlot(8, gui.setFreeze());
		}
		else if(ref.getItem() == new ItemStack(Item.glaceChocolat).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.dyePowder, 1, 3));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.iceCube, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.glaceCherry).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.cherry, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.iceCube, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.glaceApple).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.appleRed, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.iceCube, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.verreVide).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Block.glass, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Block.glass, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Block.glass, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.glass, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Block.glass, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.verrePlein).getItem())
		{
			gui.vide = false;
			gui.recipe = 3;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.orge, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.verreVide, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.bucketWater, 1));
		}
		else if(ref.getItem() == new ItemStack(Block.anvil).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Block.blockSteel, 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Block.blockSteel, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Block.blockSteel, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.ingotIron, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.ingotIron, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.ingotIron, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.ingotIron, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.goldenCarrot).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.goldNugget, 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.goldNugget, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.goldNugget, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.goldNugget, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.carrot, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.goldNugget, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.goldNugget, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.goldNugget, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.goldNugget, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.emptyMap).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.paper, 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.paper, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.paper, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.paper, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.compass, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.paper, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.paper, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.paper, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.paper, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.itemFrame).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Item.stick, 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.stick, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.stick, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.stick, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.leather, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.stick, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Item.stick, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.stick, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Item.stick, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.carrotOnAStick).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.fishingRod, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.carrot, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.flowerPot).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Item.brick, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.brick, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.brick, 1));
		}
		else if(ref.getItem() == new ItemStack(Block.cobblestoneWall).getItem())
		{
			gui.vide = false;
			
			ItemStack bloc;
			if(ref.getItemDamage() == 0){
				bloc = new ItemStack(Block.cobblestone, 1);
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(Block.cobblestoneWall, 6, 0));
			}
			else
			{
				bloc = new ItemStack(Block.cobblestoneMossy, 1);
				gui.contCrafts.slotRef.setSlot(0, new ItemStack(Block.cobblestoneWall, 6, 1));
			}
			gui.contCrafts.slotCrafts.setSlot(3, bloc);
			gui.contCrafts.slotCrafts.setSlot(4, bloc);
			gui.contCrafts.slotCrafts.setSlot(5, bloc);
			gui.contCrafts.slotCrafts.setSlot(6, bloc);
			gui.contCrafts.slotCrafts.setSlot(7, bloc);
			gui.contCrafts.slotCrafts.setSlot(8, bloc);
		}
		else if(ref.getItem() == new ItemStack(Item.bakedPotato).getItem())
		{
			gui.vide = false;
			gui.recipe = 1;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Item.potato, 1));
			gui.contCrafts.slotCrafts.setSlot(8, gui.setSmelt());
		}
		else if(ref.getItem() == new ItemStack(Block.beacon).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(0, new ItemStack(Block.glass, 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Block.glass, 1));
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Block.glass, 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Block.glass, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.netherStar, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Block.glass, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Block.obsidian, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.obsidian, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Block.obsidian, 1));

		}
		else if(ref.getItem() == new ItemStack(Item.pumpkinPie).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(3, new ItemStack(Block.pumpkin, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.sugar, 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.egg, 1));
		}
		else if(ref.getItem() == new ItemStack(Block.woodenButton).getItem())
		{
			gui.vide = false;
			if(gui.counterHexa() > 3)
				gui.lastTime = 0;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.planks, 1, gui.counterHexa()));
			
		}
		else if(ref.getItem() == new ItemStack(Item.brewingStand).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.blazeRod, 1));
			gui.contCrafts.slotCrafts.setSlot(6, new ItemStack(Block.cobblestone, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Block.cobblestone, 1));
			gui.contCrafts.slotCrafts.setSlot(8, new ItemStack(Block.cobblestone, 1));
			
		}
		else if(ref.getItem() == new ItemStack(Item.cauldron).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			for(int x=0;x<9;x++)
				if(x != 1 && x!= 4)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.ingotIron, 1));		
		}
		else if(ref.getItem() == new ItemStack(Block.Charbon).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			for(int x=0;x<9;x++)
				
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.coal, 1));		
		}
		else if(ref.getItem() == new ItemStack(Block.blockRubis).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			for(int x=0;x<9;x++)
				
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.rubis, 1));		
		}
		else if(ref.getItem() == new ItemStack(Block.Jumper).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			for(int x=0;x<9;x++){
				if(x!= 4)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.stone, 1));
				else
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.emerald, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.Speeder).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			for(int x=0;x<9;x++){
				if(x!= 4)
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Block.stone, 1));
				else
					gui.contCrafts.slotCrafts.setSlot(x, new ItemStack(Item.diamond, 1));
			}
		}
		else if(ref.getItem() == new ItemStack(Block.glass, 1, 0).getItem())
		{
			gui.recipe = 1;
			gui.vide = false;
			gui.contCrafts.slotCrafts.setSlot(2, new ItemStack(Block.sand, 1));
				gui.contCrafts.slotCrafts.setSlot(8, gui.setSmelt());
		}
		else if(ref.getItem() == new ItemStack(Block.stoneButton).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.stone, 1));
			
		}
		else if(ref.getItem() == new ItemStack(Item.speckledMelon).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.goldNugget, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.melon, 1));
			
		}
		else if(ref.getItem() == new ItemStack(Item.fireballCharge).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 3));
			gui.contCrafts.slotCrafts.setSlot(1, new ItemStack(Item.gunpowder, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.coal, 1));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.blazePowder, 1));
			
		}
		else if(ref.getItem() == new ItemStack(Item.writableBook).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 1));
			gui.contCrafts.slotCrafts.setSlot(5, new ItemStack(Item.feather, 1));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.dyePowder, 1, 0));
			gui.contCrafts.slotCrafts.setSlot(7, new ItemStack(Item.book, 1));
			
		}
		else if(ref.getItem() == new ItemStack(Item.emerald).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 9));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.blockEmerald, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.rubis).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 9));
				gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Block.blockRubis, 1));
		}
		else if(ref.getItem() == new ItemStack(Item.goldNugget).getItem())
		{
			gui.vide = false;
			gui.contCrafts.slotRef.setSlot(0, new ItemStack(ref.getItem(), 9));
			gui.contCrafts.slotCrafts.setSlot(4, new ItemStack(Item.ingotGold, 1));

			
		}
		else
		{
			gui.contCrafts.slotCrafts.resetSlot();
		}
		
	}

}
package entity;

import java.awt.Color;
import java.util.Arrays;

public class GameBoard {

	private  Field[] gameboard;

	public GameBoard(){
		gameboard =  new Field[21];
		gameboard[0] = new Territory("Tribe Encampment", Color.PINK, Color.ORANGE,"Territory, Costs 1000",1000,null,100, false);
		gameboard[1] = new Territory("Crater", Color.PINK, Color.BLUE, "Territory, Costs 1500",1500,null,300, false);
		gameboard[2] = new Territory("Mountain", Color.PINK, Color.GREEN,"Territory, Costs 2000.",2000,null,500, false);
		gameboard[3] = new Territory("Cold Desert", Color.PINK, Color.YELLOW,"Territory, Costs 3000",3000,null,700, false);
		gameboard[4] = new Territory("Black cave", Color.PINK, Color.DARK_GRAY,"Territory, Costs 4000",4000,null,1000, false);
		gameboard[5] = new Territory("The werewall", Color.PINK, Color.MAGENTA,"Territory, Costs 4300",4300,null,1300, false);
		gameboard[6] = new Territory("Mountain village", Color.PINK, Color.CYAN,"Territory, Costs 4750",4750,null,1600, false);
		gameboard[7] = new Territory("South Citadel", Color.PINK, Color.ORANGE,"Territory, Costs 5000",5000,null,2000, false);
		gameboard[8] = new Territory("Palace gates", Color.PINK, Color.WHITE,"Territory, Costs 5500",5500,null,2600, false);
		gameboard[9] = new Territory("Tower", Color.PINK, Color.BLUE,"Territory, Costs 6000",6000,null,3200, false);
		gameboard[10] = new Territory("Castle", Color.PINK, Color.LIGHT_GRAY,"Territory, Costs 8000",8000,null,4000, false);
		gameboard[11] = new Refuge("Walled city", Color.BLUE,Color.YELLOW,"Refuge, you get 5000 ",5000);
		gameboard[12] = new Refuge("Monastery", Color.BLUE, Color.YELLOW,"Refuge, you get 500",500);
		gameboard[13] = new LaborCamp("Huts in the mountain",Color.GRAY,Color.CYAN,"Labor Camp, costs 2500",2500,null,100,false);
		gameboard[14] = new LaborCamp("The pit",Color.GRAY,Color.CYAN,"Labor Camp, costs 2500",2500,null,100,false);
		gameboard[15] = new Tax("Goldmine",Color.GRAY,Color.BLUE,"Tax, pay 2000",2000,false);
		gameboard[16] = new Tax("Caravan",Color.GRAY,Color.BLUE,"Tax, pay 4000 or 10% of total assets",4000,true);
		gameboard[17] = new Fleet("Second Sail",Color.GRAY,Color.ORANGE,"Fleet, costs 4000",4000,null,false);
		gameboard[18] = new Fleet("Sea Grover",Color.GRAY,Color.BLUE,"Fleet, costs 4000",4000,null,false);
		gameboard[19] = new Fleet("The Bucaneeers",Color.GRAY,Color.WHITE,"Fleet, costs 4000",4000,null,false);
		gameboard[20] = new Fleet("Privateer armade",Color.GRAY,Color.RED,"Fleet, costs 4000",4000,null,false);
	}
	
	public Field getField  (int fieldNumber){
		return  gameboard[fieldNumber];
	}


	

	
}
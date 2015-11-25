package entity;

import java.awt.Color;

public class GameBoard {

private  Field[] gameboard;


public GameBoard(){
	gameboard =  new Field[21];
	gameboard[0] = new Territory("Tribe Encampment", Color.PINK, Color.ORANGE,"Watch out for the dangerous Woodoo Tribe Trolls.",1000,null,100, false);
	gameboard[1] = new Territory("Crater", Color.PINK, Color.BLUE, "Du har fundet en skat i taarnet, og finder 250, heldige dig.",1500,null,300, false);
	gameboard[2] = new Territory("Mountain", Color.PINK, Color.GREEN,"Du har fundet en skat i taarnet, og finder 250, heldige dig.",2000,null,500, false);
	gameboard[3] = new Territory("Cold Desert", Color.PINK, Color.YELLOW,"Du har fundet en skat i taarnet, og finder 250, heldige dig.",3000,null,700, false);
	gameboard[4] = new Territory("Black cave", Color.PINK, Color.DARK_GRAY,"Du har fundet en skat i taarnet, og finder 250, heldige dig.",4000,null,1000, false);
	gameboard[5] = new Territory("The werewall", Color.PINK, Color.MAGENTA,"Du har fundet en skat i taarnet, og finder 250, heldige dig.",4300,null,1300, false);
	gameboard[6] = new Territory("Mountain village", Color.PINK, Color.CYAN,"Du har fundet en skat i taarnet, og finder 250, heldige dig.",4750,null,1600, false);
	gameboard[7] = new Territory("South Citadel", Color.PINK, Color.ORANGE,"Du har fundet en skat i taarnet, og finder 250, heldige dig.",5000,null,2000, false);
	gameboard[8] = new Territory("Palace gates", Color.PINK, Color.WHITE,"Du har fundet en skat i taarnet, og finder 250, heldige dig.",5500,null,2600, false);
	gameboard[9] = new Territory("Tower", Color.PINK, Color.BLUE,"Du har fundet en skat i taarnet, og finder 250, heldige dig.",6000,null,3200, false);
	gameboard[10] = new Territory("Castle", Color.PINK, Color.LIGHT_GRAY,"Du har fundet en skat i taarnet, og finder 250, heldige dig.",8000,null,4000, false);
	gameboard[11] = new Refuge("Walled city", Color.BLUE,Color.YELLOW,"Du blev bollet i røven",5000);
	gameboard[12] = new Refuge("Monastery", Color.BLUE, Color.YELLOW,"Du blev bollet i røven",500);
	gameboard[13] = new LaborCamp("Huts in the mountain",Color.GRAY,Color.CYAN,"swag",2500,null,100,false);
	gameboard[14] = new LaborCamp("The pit",Color.GRAY,Color.CYAN,"swag",2500,null,100,false);
	gameboard[15] = new Tax("Goldmine",Color.GRAY,Color.BLUE,"swag",2000,false);
	gameboard[16] = new Tax("Caravan",Color.GRAY,Color.BLUE,"You ran into a Caravan, and had to pay alot to get free of them again.",4000,true);
	gameboard[17] = new Fleet("Second Sail",Color.GRAY,Color.ORANGE,"swag",4000,null,false);
	gameboard[18] = new Fleet("Sea Grover",Color.GRAY,Color.BLUE,"swag",4000,null,false);
	gameboard[19] = new Fleet("The Bucaneeers",Color.GRAY,Color.WHITE,"swag",4000,null,false);
	gameboard[20] = new Fleet("Privateer armade",Color.GRAY,Color.RED,"swag",4000,null,false);
	
}
public Field getField  (int fieldNumber){
	return  gameboard[fieldNumber];
}



}


package controller;


import java.awt.Color;

import desktop_codebehind.Car;
import desktop_fields.Field;
import desktop_fields.Street;
import desktop_resources.GUI;
import entity.Player;
import entity.GameBoard;
import entity.Player;
import controller.GameController;


public class GUIController {
	
private GameBoard g;	
private Field f;
private static Car[] carArray;
	
GUIController(GameBoard g){
this.g = g;
}



public Street getFieldValues(int iterator){
	
	return new Street.Builder()
			.setTitle(g.getField(iterator).getFieldName())
			.setSubText("" + (iterator+1) + "")
			.setBgColor(g.getField(iterator).getBackgroundColor())
			.setDescription(g.getField(iterator).getDescription())
		
		
			
			.setDescription(g.getField(iterator).getDescription())
			.build();
	
	
	
}


public void startGame(){

	// Koden til felterne
	Field[] fields = new Field[21];
	for(int i = 0;i < fields.length;i++){
		fields[i] = getFieldValues(i);
	}
	GUI.create(fields);
}


public Car setCar(Color c1, Color c2){
	
	// Laver et nyt objekt af typen Car og returner dette
	 return new Car.Builder()
		.typeTractor()
		.patternHorizontalDualColor()
		.primaryColor(c1)
		.secondaryColor(c2)
		.build();
}


Car car1 = setCar(Color.ORANGE, Color.RED);
Car car2 = setCar(Color.WHITE, Color.BLACK);
Car car3 = setCar(Color.BLUE, Color.GRAY);
Car car4 = setCar(Color.PINK, Color.GREEN);
Car car5 = setCar(Color.CYAN, Color.BLACK);
Car car6 = setCar(Color.WHITE, Color.MAGENTA);






//sender en besked og knaptekster der spørger om hvor mange spillere der skal med
	public int GUIbuttons5(String beskedtekst, String knaptekst1, String knaptekst2, String knaptekst3, String knaptekst4, String knaptekst5){
	String players = 	GUI.getUserButtonPressed(beskedtekst, knaptekst1, knaptekst2, knaptekst3, knaptekst4, knaptekst5);
	int pn = Integer.parseInt(players);
		
		for(int i = 0; i<=pn-1 ;i++){
			carArray = new Car[]{car1,car2,car3,car4,car5,car6};
			GUI.addPlayer("Player " + (i+1),3000,carArray[i]);
		}
		
		return pn ;
	}



//updater spillerscore
public void updatesPlayerScore(Player player){
	GUI.setBalance(player.getPiece().getPlayerName(), player.getBalance());
}

//sætter terninger
public void setDices(DiceCup dicecup){
	GUI.setDice(dicecup.getDice(1), dicecup.getDice(2));
}

//placerer brik
public void placePiece(Player p, int field){
	GUI.setCar(field, p.getPiece().getPlayerName());
}

public void showMessage(String besked){
	GUI.showMessage(besked);
}

public void RemovePiece(Player p, int field){
	
	// removes car 
	GUI.removeCar(field, p.getPiece().getPlayerName());

}

public void remooveCar(Player p){
	GUI.removeAllCars(p.getPiece().getPlayerName());
}


public void closeGame(){
	GUI.close();
}


}


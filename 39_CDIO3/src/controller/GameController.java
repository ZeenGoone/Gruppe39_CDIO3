package controller;

import controller.GUIController;
import desktop_resources.GUI;
import controller.DiceCup;
import entity.GameBoard;
import entity.Player;

public class GameController {
	private static GameBoard gb;
	private static GUIController gc;
	private static DiceCup dc;

	private static Player playerArray[];
	public static void main(String args[]){

		gb = new GameBoard();
		gc = new GUIController(gb);
		dc = new DiceCup();
		gc.startGame();	

		// Finder ud af hvor mange spillere der er, og returnere det som en int

		
		int numberOfPlayers = gc.GUIbuttons5("How  many players", "2", "3", "4", "5", "6");

		// Placere spillere ind i et array, og laver spillere tilsvarende til antallet Bruger har angivet

		playerArray = new Player[numberOfPlayers];

		for (int i = 0 ; i <= numberOfPlayers - 1 ; i++) {
			playerArray[i] = new Player();

			System.out.println("Vi har Spiller: " + (i+1));
		}


		while(true){
			for(int j=0;j<playerArray.length;j++){

				playRound(playerArray[j]);
				gc.showMessage("Current tur: Player" + (j+1));	
			}

		}


	}

	public static void playRound(Player p){
		
		fjernAlt(p);
		
		//kaster med terning
		dc.RollDices();
		
		//s�tter ternings �jne p� GUI
		gc.setDices(dc);
		
		

		// tilf�jer slaget til spillerens totale sum
		p.addTotalSum(dc.getSum());

		//rykker spillerens brik, s� langt som spilleren har sl�et
		movePiece(p,p.getTotalSum());

		//afg�rer hvad der sker
		gb.getField(p.getTotalSum()-1).landOnField(p);
		
		
		//updater player score
		gc.updatesPlayerScore(p);
	}

	public static void movePiece(Player p, int field){
		gc.placePiece(p, field);
	}
	public static void fjernAlt(Player p){
		gc.remooveCar(p);
	}

}

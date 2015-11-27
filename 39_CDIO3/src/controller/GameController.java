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
	public static boolean  vinder = false;
	private static Player playerArray[];
	private static int bankruptCounter = 0;
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
		}

		while(!vinder){
			for(int j=0;j<playerArray.length;j++){
				if(playerArray[j].isBankrupt())
					continue;
				gc.showMessage("Player " + (j+1) +  " click OK to roll");	
				playRound(playerArray[j]);
			}
			bankruptChecker();
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

		//updater player score for alle spiller
		for(int j=0;j<playerArray.length;j++){
			gc.updatesPlayerScore(playerArray[j]);
		}

		//Fort�ller spilleren hvad han landte p�
		gc.showMessage(p.getPiece().getPlayerName()+" landed on " + gb.getField(p.getTotalSum()-1).getFieldName());

		//tjekker om nogle er g�et bankerot og t�lkler 1 om hvis de er
		if(p.getBalance() < 0){
			gc.showMessage(p.getPiece().getPlayerName() + " er bankerot ");
			p.setBankrupt(true);
			gc.remooveCar(p);
			bankruptCounter++;
		}
	}

	public static void movePiece(Player p, int field){
		gc.placePiece(p, field);
	}
	public static void fjernAlt(Player p){
		gc.remooveCar(p);
	}
	//Leger med bankruptchecker
	public static void bankruptChecker(){
		if(bankruptCounter>= playerArray.length-1){
			vinder = true;
			gc.closeGame();
		}
	}
}

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
	
		removePiece(p);

		//kaster med terning
		dc.RollDices();

		//sï¿½tter ternings ï¿½jne pï¿½ GUI
		gc.setDices(dc);

		// tilfï¿½jer slaget til spillerens totale sum
		p.addTotalSum(dc.getSum());

		//rykker spillerens brik, sï¿½ langt som spilleren har slï¿½et
		movePiece(p,p.getTotalSum());

		//afgï¿½rer hvad der sker
		gb.getField(p.getTotalSum()-1).landOnField(p);

		//updater player score for alle spiller
		for(int j=0;j<playerArray.length;j++){
			gc.updatesPlayerScore(playerArray[j]);
		}

		//Fortï¿½ller spilleren hvad han landte pï¿½
		gc.showMessage(p.getPiece().getPlayerName()+" landed on " + gb.getField(p.getTotalSum()-1).getFieldName());

		//tjekker om nogle er gï¿½et bankerot og tï¿½lkler 1 om hvis de er
		if(p.getBalance() < 0){
			gc.showMessage(p.getPiece().getPlayerName() + " er bankerot ");
			p.setBankrupt(true);
			gc.remooveCar(p);
			bankruptCounter++;
		}
	}
		//flytter en spillers brik
	public static void movePiece(Player p, int field){
		gc.placePiece(p, field);
	}
	// fjerner en spillers brik
	public static void removePiece(Player p){
		gc.remooveCar(p);
	}
	//tjekker om nogle spiller er gået bankrupt og lukker, hvis alle på nær 1 er
	public static void bankruptChecker(){
		if(bankruptCounter>= playerArray.length-1){
			vinder = true;
			gc.closeGame();
		}
	}
}

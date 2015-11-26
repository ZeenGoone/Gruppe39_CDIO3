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

			System.out.println("Vi har Spiller: " + (i+1));
		}


		while(!vinder){
			for(int j=0;j<playerArray.length;j++){
				if(playerArray[j].isBankrupt())
					continue;
				gc.showMessage("Player" + (j+1) +  "click OK to roll");	
				playRound(playerArray[j]);
			
			}
			bankruptChecker();
		}


	}

	public static void playRound(Player p){

		fjernAlt(p);

		//kaster med terning
		dc.RollDices();

		//sætter ternings øjne på GUI
		gc.setDices(dc);



		// tilføjer slaget til spillerens totale sum
		p.addTotalSum(dc.getSum());

		//rykker spillerens brik, så langt som spilleren har slået
		movePiece(p,p.getTotalSum());

		//afgører hvad der sker
		gb.getField(p.getTotalSum()-1).landOnField(p);
		
		//Fortæller spilleren hvad han landte på
		gc.showMessage(p.getPiece().getPlayerName()+"landed on " + gb.getField(p.getTotalSum()-1).getFieldName());
		
		//updater player score for alle spiller
		for(int j=0;j<playerArray.length;j++){
			gc.updatesPlayerScore(playerArray[j]);
		}
		//tjekker om nogle er gået bankerot og tælkler 1 om hvis de er
		if(p.getBalance()<=0){
			gc.showMessage(p.getPiece().getPlayerName() + "er gået kold ");
			p.setBankrupt(true);
			bankruptCounter++;
		}
			System.out.println(p.isBankrupt());
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
	
	//	}

}

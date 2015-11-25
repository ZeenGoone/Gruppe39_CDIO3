package controller;

import desktop_resources.GUI;
import entity.Player;

public class GameController {

	private static Player PlayerArray[];


// Metode til at finde antal spillere, skal nok flyttes når vi har et bedre sted for den.
	public static void selectPlayers () {

		// Finder ud af hvor mange spillere der er, og returnere det som en int
		
		String X = GUIbuttons5("How many players are you?", "2", "3", "4", "5", "6");	
		int numberOfPlayers = Integer.parseInt(X);

		// Placere spillere ind i et array, og laver spillere tilsvarende til antallet Bruger har angivet

		PlayerArray = new Player[numberOfPlayers];

		for (int Z = 0 ; Z <= numberOfPlayers - 1 ; Z++) {
			PlayerArray[Z] = new Player();


			System.out.println("Vi har Spiller: " + (Z+1));

		}
		
	}
	// sender en besked og knaptekst til GUI via 
	public static String GUIbuttons5(String beskedtekst, String knaptekst1, String knaptekst2, String knaptekst3, String knaptekst4, String knaptekst5){
		return GUI.getUserButtonPressed(beskedtekst, knaptekst1, knaptekst2, knaptekst3, knaptekst4, knaptekst5);
	}




}




package entity;

public class Piece {

	// Initialiserer attribut
	private int playerNumber;

	// Konstruktoer giver brikken et spillernummer den hører til
	public Piece(int playerNumber){
		this.playerNumber = playerNumber;
	}

	public int getPlayerNumber(){
		// Returner hvilket spillernummer objektet(brik) hoerer til
		return this.playerNumber;
	}

	public String getPlayerName(){
		// Returner SpillerNavn baseret paa spillernummer
		return "Player " + playerNumber;
	}
}
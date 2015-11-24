	package entity;

public class Player {

	// Initialiserer attributter
	private static int maxPlayers = 0;
	private int startAmount = 30000;
	private Account account = new Account();
	private Piece playerPiece;

	// Konstruktoer tae�ller maxspillere 1 op og en brik bliver tildelt med et spillernummer
	public Player(){
		++maxPlayers;
		playerPiece = new Piece(maxPlayers);
	}

	// opdaterer spillerens beholdning
	public int updateAmount(int updating){
		return account.addBalance(updating);
	}
	
	// set metode til kontos beholdning
	public void setBalance(int value){
		account.setBalance(value);
	}
	// get metoder
	public int getBalance(){
		return account.getBalance();
	}
	public Piece getPiece(){
		return this.playerPiece;
	}
	
}

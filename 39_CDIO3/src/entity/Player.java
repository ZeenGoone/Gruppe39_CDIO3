	package entity;

public class Player {

	// Initialiserer attributter
	private static int maxPlayers = 0;
	private int startAmount = 30000;
	private Account account = new Account();
	private Piece playerPiece;
	private boolean isBankrupt = false;
	private int fleetCount;

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

	public boolean isBankrupt() {
		return isBankrupt;
	}

	public void setBankrupt(boolean isBankrupt) {
		this.isBankrupt = isBankrupt;
	}

	public int getFleetCount() {
		return fleetCount;
	}

	public void setFleetCount(int fleetCount) {
		this.fleetCount = fleetCount;
	}
	
	
	
}
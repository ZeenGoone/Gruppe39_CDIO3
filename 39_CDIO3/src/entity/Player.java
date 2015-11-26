	package entity;

public class Player {

	// Initialiserer attributter
	private static int maxPlayers = 0;
	private int startAmount = 3000;
	private Account account = new Account();
	private Piece playerPiece;
	private int totalSum;
	private boolean isBankrupt = false;
	private int fleetCount;
	private int laborCampCount;

	// Konstruktoer tae�ller maxspillere 1 op og en brik bliver tildelt med et spillernummer
	public Player(){
		++maxPlayers;
		playerPiece = new Piece(maxPlayers);
		setBalance(startAmount);
	}

	// opdaterer spillerens beholdning
	public int updateBalance(int updating){
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
	
	public int getTotalSum() {
		if(totalSum>21){
			this.totalSum = totalSum-21;
		}
		return totalSum;
	}


	public void addTotalSum(int totalSum) {
		this.totalSum += totalSum;
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

	public void addFleetsOwned() {
		this.fleetCount++ ;
	}
	
	public int getLaborCampCount() {
		return laborCampCount;
	}

	public void addLaborCampsOwned() {
		this.laborCampCount++ ;
	}
	
	
}

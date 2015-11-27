package entity;

public class Player {

	// Initialiserer attributter
	private static int maxPlayers = 0;
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
		setBalance(account.getBalance());
	}
	public int getTotalSum() {
		if(totalSum>21){
			this.totalSum = totalSum-21;
		}
		return totalSum;
	}
	public Piece getPiece(){ return this.playerPiece; }
	public int getFleetCount() { return fleetCount;	}
	public int getLaborCampCount() { return laborCampCount;	}
	public int getBalance(){ return account.getBalance(); }
	public int updateBalance(int updating){	return account.addBalance(updating); }
	public boolean isBankrupt() { return isBankrupt; }
	public void setBankrupt(boolean isBankrupt) { this.isBankrupt = isBankrupt;	}
	public void setBalance(int value){ account.setBalance(value); }
	public void addLaborCampsOwned() { this.laborCampCount++; }
	public void addFleetsOwned() { this.fleetCount++; }
	public void addTotalSum(int totalSum) {	this.totalSum += totalSum; }
}
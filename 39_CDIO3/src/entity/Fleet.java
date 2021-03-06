package entity;

import java.awt.Color;

public class Fleet extends Ownable {

	//attributter
	private int rent1 = 500;
	private int rent2 = 1000;
	private int rent3 = 2000;
	private int rent4 = 4000;

	//konstruktor
	public Fleet( String fieldName, Color foregroundColor, Color backColor, String description, int price, Player owner, boolean isowned) {
		super(fieldName, price, foregroundColor, backColor, description, owner, isowned);
	}

	//Hvad sker n�r man lander p� dette felt
	@Override
	public void landOnField(Player player){
		//Hvis felt ikke er koebt, bliver feltet k�bt automatisk
		if (!getOwned()) {
			if(player.getBalance() >= getPrice()) {
				setOwner(player);
				player.updateBalance(-getPrice());
				getOwner().addFerryOwned();
			}
		}
		//Hvis feltet er koebt, betales hyre til ejer
		else {
			player.updateBalance(-getRent());
			getOwner().updateBalance(getRent());
		}	
	}
	//Bestemmelse af rent for fleet feltet
	@Override
	public int getRent() {
		System.out.println("rammer getRent");
		switch(getOwner().getFerryCount()){
		case 1: return rent1;
		case 2: return rent2;
		case 3: return rent3;
		case 4: return rent4;
		}
		return rent1;
	}
}
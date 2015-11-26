package entity;

import java.awt.Color;

public abstract class Ownable extends Field {

	private int price;
	private Player owner;
	private boolean isOwned;

	//konstruktor
	public Ownable( String fieldName, int price, Color foregroundColor, Color backColor, String description, Player owner, boolean isOwned) {
		super(fieldName, foregroundColor, backColor, description);
		this.price = price;
		this.owner = owner;
		this.isOwned = false;
	}

	public abstract int getRent();
	
	//public abstract int getRent(DiceCup dc);

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Player getOwner () {
		return owner;
	}
	public void setOwner (Player owner) {
		this.owner = owner;
	}

	public boolean getOwned() {
		return isOwned;
	}
	public void setOwned(boolean isOwned) {
		this.isOwned = isOwned;
	}

}

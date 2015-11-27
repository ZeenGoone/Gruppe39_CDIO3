package entity;

import java.awt.Color;

public class Territory extends Ownable {

	private int rent;

	public Territory(String fieldName, Color forgroundColor, Color backgroundColor, String description, int price,
			Player owner,  int rent, boolean isOwned) {
		super(fieldName, price, forgroundColor, backgroundColor, description, owner, isOwned);
		this.rent = rent;
	}

	@Override
	public int getRent() { return rent; }
	public void setRent(int rent){ this.rent = rent; }

	@Override
	public void landOnField(Player player) {
		//hvis feltet ikke er ejet
		if(!getOwned()){
			//tjekker om spilleren har r�d
			if(player.getBalance()>= getPrice()){
				//s�tter ham som ejer og tager penge
				setOwner(player);
				player.updateBalance(-getPrice());
				setOwned(true);
				System.out.println(player.getPiece().getPlayerName() + "just bought" + getFieldName());
			}
		}
		else{
			if(getOwner().getBalance()<=0){
				System.out.println("owner is ded LOL");
			}
			else{
				getOwner().updateBalance(getRent());
				player.updateBalance(-getRent());
				System.out.println(player.getPiece().getPlayerName() + "just payed" + getOwnerName());
			}
		}
	}	
}
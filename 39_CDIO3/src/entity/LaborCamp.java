package entity;

import java.awt.Color;
import controller.DiceCup;


public class LaborCamp  extends Ownable {

	private int rent;
	private DiceCup diceCup;
	
	
	public LaborCamp(String fieldName, Color forgroundColor, Color backgroundColor, String description, int price,
			Player owner,  int rent, boolean isOwned) {
		
		super(fieldName, price, forgroundColor, backgroundColor, description, owner, isOwned);
		
		this.rent = rent;
	}

	@Override
	public int getRent() {
		
		return rent;
	}

	
	public void setRent(int rent){
		this.rent = rent;
	}

	@Override
	public void landOnField(Player player) {
	//hvis feltet ikke er ejet
		if(!getOwned()){
			
		//tjekker om spilleren har råd
			
		if(player.getBalance()>= getPrice()){
			//sætter ham som ejer og tager penge
			setOwner(player);
			player.updateBalance(-getPrice());
			setOwned(true);
			getOwner().addLaborCampsOwned();
			System.out.println(player.getPiece().getPlayerName() + " just bought " + getFieldName());
		}
	}
	else{
		diceCup.RollDices();
		
		getOwner().updateBalance((getRent())*(diceCup.getSum())*(getOwner().getLaborCampCount()));
		player.updateBalance(-((getRent())*(diceCup.getSum())*(getOwner().getLaborCampCount())));
		System.out.println("The dices rolled a total of " + diceCup.getSum());
		System.out.println(player.getPiece().getPlayerName() + " just payed " + getOwner());
	}
	}	
		
	
}
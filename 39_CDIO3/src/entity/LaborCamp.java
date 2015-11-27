package entity;

import java.awt.Color;
import controller.DiceCup;
import desktop_resources.GUI;


public class LaborCamp  extends Ownable {

	// for testing only:
	private int diceSum;
	private static boolean testing = false;
	
	// initializing attributes
	private int rent;
	private DiceCup dc;

	public LaborCamp(String fieldName, Color forgroundColor, Color backgroundColor, String description, int price,
			Player owner,  int rent, boolean isOwned) {

		super(fieldName, price, forgroundColor, backgroundColor, description, owner, isOwned);
		this.rent = rent;
	}

	@Override
	public int getRent() { return rent;	}
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
				getOwner().addLaborCampsOwned();
			}
		}
		else{
			if(getOwner().getBalance()<=0){
				if(player.getBalance()>= getPrice()){
					setOwner(player);
					player.updateBalance(-getPrice());
				}
			}
			else{
				dc = new DiceCup();
				dc.RollDices();
				diceSum = dc.getSum();
				if(!testing){ GUI.showMessage("You rolled : " + dc.getSum()); }
				getOwner().updateBalance((getRent())*(dc.getSum())*(getOwner().getLaborCampCount()));
				player.updateBalance(-(getRent())*(dc.getSum())*(getOwner().getLaborCampCount()));
			}
		}	
	}
	// for testing purposes only
	public int getLaborDiceRoll(){
		return diceSum;
	}
	public static void setTesting(boolean test){
		testing = test;
	}
}
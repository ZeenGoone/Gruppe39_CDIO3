package entity;

import java.awt.Color;

public class Tax {

	private String description;
	private int price;

	public Tax(String fieldName, Color forgroundColor, Color backgroundColor, String description, int price) {

		this.price = price;
		this.description = description;
	}


	public void landOnField(Player player) {


		//Spilleren betaler enten 10% af Balance eller 4000, alt efter hvad der koster ham mindst

		if(((player.getBalance())/10) >= getPrice()){
			player.updateBalance(-getPrice());
			System.out.println(description);

		}
		else{
			if(((player.getBalance())/10) < getPrice()){
				player.updateBalance(-((player.getBalance())/10));
				System.out.println(description);
			}
		}
	}	


	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	

}


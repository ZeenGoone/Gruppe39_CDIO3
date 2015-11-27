package entity;

import java.awt.Color;

public class Refuge extends Field {
	private int bonus;

	public Refuge(String fieldName, Color forgroundColor, Color backgroundColor, String description, int bonus) {
		super(fieldName, forgroundColor, backgroundColor, description);
		this.bonus = bonus;
	}

	@Override
	public void landOnField(Player player) {
		player.updateBalance(getBonus());
		System.out.println(player.getPiece().getPlayerName() + "got bonus:" + bonus);

	}
	public int getBonus(){ return bonus; }
}
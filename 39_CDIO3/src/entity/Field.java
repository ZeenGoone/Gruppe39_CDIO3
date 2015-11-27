package entity;

import java.awt.Color;

public abstract class Field {

	private String fieldName;
	private  Color forgroundColor;
	private  Color backgroundColor;
	private String description;

	public Field(String fieldName, Color forgroundColor, Color backgroundColor, String description) {
		super();
		this.fieldName = fieldName;
		this.forgroundColor = forgroundColor;
		this.backgroundColor = backgroundColor;
		this.description = description;
	}

	public abstract void landOnField(Player player);

	public String getFieldName() {
		return fieldName;
	}

	public Color getForgroundColor() {
		return forgroundColor;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public String getDescription() {
		return description;
	}
}
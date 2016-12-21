package com.tek.interview.question.data;

/*
 * represents an item, contains a price and a description.
 *
 */
public class Item {
	private String description;
	private float price;

	public Item(String description, float price) {
		this.description = description;
		this.price = price;
	}

	/*
	 * Below methods are getters and setters for price, description states of an Item.
	 *
	 */
	public String getDescription() {
		return description;
	}

	public float getPrice() {
		return price;
	}
}

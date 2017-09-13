package com.teksystems.order.version2.model;

/**
 * Represents an item, contains a price and a description.
 */
public class Item {

	private String description;
	private float price;

	/**
	 * @param description
	 * @param price
	 */
	public Item(String description, float price) {
		super();
		this.description = description;
		this.price = price;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return price
	 */
	public float getPrice() {
		return price;
	}
}
package com.teksystems.order.version2.model;

/**
 * Represents an order line which contains the @link Item and the quantity.
 *
 */
public class OrderLine {

	private int quantity;
	private Item item;

	/**
	 * @param item Item of the order
	 * 
	 * @param quantity Quantity of the item
	 */
	public OrderLine(Item item, int quantity) throws Exception {
		if (item == null) {
			System.err.println("ERROR - Item is NULL");
			throw new Exception("Item is NULL");
		}
		assert quantity > 0;
		// BUG Fix - Initialize instance variables
		this.item = item;
		this.quantity = quantity;
	}

	/**
	 *
	 * @return item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 *
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}
}
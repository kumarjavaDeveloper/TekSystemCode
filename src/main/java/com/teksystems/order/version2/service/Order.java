package com.teksystems.order.version2.service;

import java.util.ArrayList;
import java.util.List;

import com.teksystems.order.version2.model.OrderLine;

/**
 * Order class which contains multiple {@link OrderLine} elements
 *
 */
public class Order implements IOrderService {

	private List<OrderLine> orderLines;

	/**
	 * Add Order to collection
	 * 
	 * @param orderLine
	 * @throws IllegalArgumentException
	 */
	public void add(OrderLine o) throws Exception {
		if (o == null) {
			System.out.println("ERROR - Order is NULL");
			throw new IllegalArgumentException("Order is NULL");
		}
		// BUG Fix : Initialize orderLines collection
		if(orderLines == null) {
			orderLines = new ArrayList<OrderLine>();
		}
		orderLines.add(o);
	}

	/**
	 * Return size of shopping cart
	 * 
	 * @return
	 */
	public int size() {
		return orderLines.size();
	}

	/**
	 * Get the order at given index position
	 * 
	 * @param index
	 * @return OrderLine
	 */
	public OrderLine get(int index) {
		return orderLines.get(index);
	}

	/**
	 * Clear the shopping cart
	 */
	public void clear() {
		this.orderLines.clear();
	}
}
package com.teksystems.order;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.teksystems.order.version2.model.Item;
import com.teksystems.order.version2.model.OrderLine;
import com.teksystems.order.version2.service.Order;
import com.teksystems.order.version2.utility.Calculator;

public class OrderTest {

	private Order order;

	@Before
	public void init() {
		order = new Order();
	}

	@After
	public void destroy() {
		order = null;
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddUsingNull() throws Exception {
		order.add(null);
	}

	/**
	 * Tests add and size methods
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAdd() throws Exception {
		order.add(new OrderLine(new Item("Laptop", 782.94f), 1));
		order.add(new OrderLine(new Item("Mobile", 231.56f), 1));

		Assert.assertTrue(order.size() > 0);
		Assert.assertEquals(2, order.size());
	}

	/**
	 * Tests Order Get method
	 */
	@Test
	public void testGet() throws Exception {
		Item item1 = new Item("Laptop", 782.942f);
		Item item2 = new Item("Mobile", 231.557f);

		OrderLine orderLine1 = new OrderLine(item1, 10);
		OrderLine orderLine2 = new OrderLine(item2, 20);

		order.add(orderLine1);
		order.add(orderLine2);

		// check order lines
		Assert.assertNotNull(order.get(0));
		Assert.assertEquals(orderLine1, order.get(0));
		Assert.assertEquals(orderLine2, order.get(1));

		// check item price
		Assert.assertEquals(782.94f, Calculator.rounding(order.get(0).getItem().getPrice()), 0.001);
		Assert.assertEquals(231.56f, Calculator.rounding(order.get(1).getItem().getPrice()), 0.001);

		// check order quantity
		Assert.assertEquals(10, order.get(0).getQuantity());
		Assert.assertEquals(20, order.get(1).getQuantity());

		// check item description
		Assert.assertEquals("Laptop", order.get(0).getItem().getDescription());
		Assert.assertEquals("Mobile", order.get(1).getItem().getDescription());

	}
}
package com.teksystems.order;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.teksystems.order.version2.model.Item;
import com.teksystems.order.version2.model.OrderLine;
import com.teksystems.order.version2.service.Order;
import com.teksystems.order.version2.utility.Calculator;

public class CalculatorTest {

	private Calculator calculator;

	@Before
	public void init() {
		calculator = new Calculator();
	}

	@After
	public void destroy() {
		calculator = null;
	}

	/**
	 * Test Rounding Feature
	 */
	@Test
	public void testRounding() {
		Assert.assertEquals(13.73, Calculator.rounding(13.729), 0.001);
		Assert.assertEquals(237.83, Calculator.rounding(237.832), 0.001);
	}

	/**
	 * Assertions are not added here as method doesn't return a value
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCalculate() throws Exception {

		Map<String, Order> orderMap = new LinkedHashMap<String, Order>();

		Order o1 = new Order();
		o1.add(new OrderLine(new Item("Laptop", 762.93f), 1));
		orderMap.put("Order 1", o1);

		Order o2 = new Order();
		o2.add(new OrderLine(new Item("Mobile", 231.53f), 1));
		orderMap.put("Order 2", o2);
		calculator.calculate(orderMap);
	}
}
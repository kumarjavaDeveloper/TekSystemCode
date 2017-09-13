package com.teksystems.order.version2.utility;

import java.text.DecimalFormat;
import java.util.Map;

import com.teksystems.order.version2.service.Order;

public class Calculator {

	/**
	 * DecimalFormat to round data to 2 decimal places
	 */
	private static final DecimalFormat formatter = new DecimalFormat("#.00");
	
	/** 
	 * Round of data with 2 decimal places.
	 * 
	 * @param value
	 * @return
	 */
	// Bug Fix - Existing method round off value to int, so using DecimalFormat to round it to double
	public static double rounding(double value) {
		return new Double(formatter.format(value));
		//return ( (int) (value * 100)) / 100;		
	}

	/**
	 * Receives a collection of orders. For each order, iterates on the order lines 
	 * and calculate the total price which is the item's (price * quantity) + taxes.
	 * 
	 * For each order, print the total Sales Tax paid and Total price without taxes for 
	 * this order
	 */
	public void calculate(Map<String, Order> o) {

		double grandtotal = 0;

		// Iterate through the orders
		for (Map.Entry<String, Order> entry : o.entrySet()) {
			System.out.println("*******" + entry.getKey() + "*******");
			// BUG Fix - This line is not needed
			// grandtotal = 0;

			Order r = entry.getValue();

			double totalTax = 0;
			double total = 0;

			// Iterate through the items in the order
			// BUG Fix - Run the loop from 0 to (size - 1)
			for (int i = 0; i < r.size(); i++) {

				// Calculate the taxes
				double tax = 0;

				// BUG Fix - Convert to lower case and do the comparision
				if (r.get(i).getItem().getDescription().toLowerCase().contains("imported")) {
					// Extra 5% tax on imported items
					tax = rounding(r.get(i).getItem().getPrice() * 0.15); 
				} else {
					tax = rounding(r.get(i).getItem().getPrice() * 0.10);
				}

				// BUG Fix - Should Use rounding function instead of Math.floor which gives wrong result
				// Calculate the total price
				double totalprice = r.get(i).getItem().getPrice() + rounding(tax);

				// Print out the item's details and total price
				// BUG Fix - Should Use rounding function instead of Math.floor which gives wrong result
				System.out.println(r.get(i).getQuantity() + " " + r.get(i).getItem().getDescription() + ": " + rounding(totalprice));

				// Keep a running total
				totalTax += tax;
				total += r.get(i).getItem().getPrice();
			}

			// Print out the total taxes
			// Bug Fix - Should Use rounding function instead of Math.floor which gives wrong result
			System.out.println("Sales Tax: " + rounding(totalTax));

			// BUG - Commented this line to avoid wrong calculation
			// total = total + totalTax;

			// Bug Fix - Should Use rounding function instead of Math.floor which gives wrong result
			System.out.println("Total: " + rounding(total * 100) / 100);
			grandtotal += total;
		}

		System.out.println("Sum of orders: " + rounding(grandtotal * 100) / 100);
	}
}
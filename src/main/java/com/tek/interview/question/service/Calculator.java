package com.tek.interview.question.service;

import java.util.Map;

import com.tek.interview.question.data.Order;

public class Calculator {
	private static final double NON_IMPORTED_TAX = 0.10;
	private static final double IMPORTED_TAX = 0.15;
	private static final String IMPORTED = "imported";

	/**
	 * receives a collection of orders. For each order, iterates on the order lines and calculate the total price which
	 * is the item's price * quantity * taxes.
	 * 
	 * For each order, print the total Sales Tax paid and Total price without taxes for this order
	 */
	public float calculate(Map<String, Order> o) {
		float grandtotal = 0;
		// Iterate through the orders
		for (Map.Entry<String, Order> entry : o.entrySet()) {
			System.out.println("*******" + entry.getKey() + "*******");
			Order order = entry.getValue();

			float totalTax = 0;
			float total = 0;

			for (int i = 0; i < order.getOrderLines().size(); i++) {
				float tax;
				if (order.getOrderLines().get(i).getItem().getDescription().toLowerCase().contains(IMPORTED)) {
					tax = (float) (order.getOrderLines().get(i).getItem().getPrice() * IMPORTED_TAX); // Extra 5% tax on
				} else {
					tax = (float) (order.getOrderLines().get(i).getItem().getPrice() * NON_IMPORTED_TAX);
				}
				float totalprice = order.getOrderLines().get(i).getItem().getPrice() * order.getOrderLines().get(i).getQuantity();
				System.out.println(order.getOrderLines().get(i).getItem().getDescription() + ": " + totalprice);
				totalTax += tax;
				total += totalprice;
			}

			System.out.println("Sales Tax: " + totalTax);
			System.out.println("Total: " + total);
			grandtotal += total + totalTax;
		}
		System.out.println("Sum of orders: " + grandtotal);
		return grandtotal;
	}
}

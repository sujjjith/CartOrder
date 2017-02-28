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
	public static double rounding(double value) {
		return Math.round(value*100.0)/100.0;
	}

		public double calculate(Map<String, Order> o) {

			double grandtotal = 0;

			// Iterate through the orders
			for (Map.Entry<String, Order> entry : o.entrySet()) {
				System.out.println("*******" + entry.getKey() + "*******");

				Order r = entry.getValue();

				double totalTax = 0;
				double total = 0;

				// Iterate through the items in the order
				for (int i = 0; i < r.size(); i++) {

					// Calculate the taxes
					double tax = 0;

					if (r.get(i).getItem().getDescription().toLowerCase().contains(IMPORTED)) {
						tax = rounding(r.get(i).getItem().getPrice() * IMPORTED_TAX); // Extra 5% tax on
						// imported items
					} else {
						tax = rounding(r.get(i).getItem().getPrice() * NON_IMPORTED_TAX);
					}

					// Calculate the total price
					double totalprice = r.get(i).getItem().getPrice() + tax;

					// Print out the item's total price
					System.out.println(r.get(i).getItem().getDescription() + ": " + Math.round(totalprice*100.0)/100.0);

					// Keep a running total
					totalTax += tax;
					total += r.get(i).getItem().getPrice();
				}

				// Print out the total taxes
				System.out.println("Sales Tax: " + totalTax);

				//total = total ;

				// Print out the total amount
				System.out.println("Total: " + Math.ceil(total * 100) / 100);
				grandtotal += total;
			}

			System.out.println("Sum of orders: " + Math.ceil(grandtotal * 100) / 100);

		return grandtotal;
	}
}

/**
 * 
 */
package com.tek.interview.question.data;

import java.util.ArrayList;
import java.util.List;

/**
 * represents an order which contains the list of Orderlines.
 *
 */
public class Order {
	private List<OrderLine> orderLines = new ArrayList<OrderLine>();

	public void add(OrderLine ol) throws Exception {
		if (ol == null) {
			System.err.println("ERROR - Order is NULL");
			throw new IllegalArgumentException("Order is NULL");
		}
		orderLines.add(ol);
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}
}

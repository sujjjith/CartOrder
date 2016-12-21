package com.tek.interview.question.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.tek.interview.question.data.Item;
import com.tek.interview.question.data.Order;
import com.tek.interview.question.data.OrderLine;

public class CalculatorTest {
	@Test
	public void testPositiveOfCalculator() throws Exception{
		Map<String, Order> orders = new HashMap<String, Order>();
		//First order
		Order fo = new Order();
		Item firstOrderItem1 = new Item("book", (float) 12.49);
		OrderLine foOrderLine1 = new OrderLine(firstOrderItem1, 2);
		fo.add(foOrderLine1);
		
		Item foItem2 = new Item("music CD", (float) 14.99);
		OrderLine foOrderLine2 = new OrderLine(foItem2, 1);
		fo.add(foOrderLine2);
		
		Item foItem3 = new Item("chocolate bar", (float) 0.85);
		OrderLine foOrderLine3 = new OrderLine(foItem3, 1);
		fo.add(foOrderLine3);
		
		orders.put("Order 1", fo);


		//Second order
		Order so = new Order();
		Item soItem1 = new Item("imported box of chocolate", 10);
		OrderLine soOrderLine1 = new OrderLine(soItem1, 1);
		so.add(soOrderLine1);
		
		Item soItem2 = new Item("imported bottle of perfume",(float) 47.50);
		OrderLine soOrderLine2 = new OrderLine(soItem2, 1);
		so.add(soOrderLine2);
		
		orders.put("Order 2", so);

		//Third order
		Order to = new Order();
		Item toItem1 = new Item("Imported bottle of perfume",(float) 27.99);
		OrderLine toOrderLine1 = new OrderLine(toItem1, 1);
		to.add(toOrderLine1);
		
		Item toItem2 = new Item("bottle of perfume", (float) 18.99);
		OrderLine toOrderLine2 = new OrderLine(toItem2, 1);
		to.add(toOrderLine2);
		
		Item toItem3 = new Item("packet of headache pills", (float) 9.75);
		OrderLine toOrderLine3 = new OrderLine(toItem3,1);
		to.add(toOrderLine3);
		
		Item toItem4 = new Item("box of importd chocolates", (float) 11.25);
		OrderLine toOrderLine4 = new OrderLine(toItem4, 1);
		to.add(toOrderLine4);
		
		orders.put("Order 3", to);
		
		assertEquals(185.9555, new Calculator().calculate(orders),0.1);
	}
	
	@Test(expected=Exception.class)
	public void testWithNoItem_Calculator() throws Exception{
		Order fo = new Order();
		OrderLine foOrderLine1 = new OrderLine(null, 2);
		fo.add(foOrderLine1);
	}
	
	@Test(expected=Exception.class)
	public void testWithNoOrder_Calculator() throws Exception{
		Order fo = new Order();
		fo.add(null);
	}

}

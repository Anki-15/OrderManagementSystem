package com.assignment.order;

import java.util.ArrayList;

public interface OrderManagementService 
{
	 void viewOrder();
	void sortOrder(int value);
	 void deleteOrder(String id);
	 void report(Order orderheader);
	 void addData(String orderId, String description, String deliveryAddress, String oderDate,String amount,String deliveryDate);
	 void markAsDelivered(String id);
	
	
}

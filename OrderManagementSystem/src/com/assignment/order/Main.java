package com.assignment.order;

import java.util.Scanner;
import java.io.IOException;


public class Main 
{

	public static void main(String[] args) throws IOException {
		OrderManagementServiceImpl orderheader=new OrderManagementServiceImpl();
        Order o1=new Order();
        o1.setOrderId("orderId");
        o1.setDescription("Description");
        o1.setDeliveryAddress("Delivery Address");
        o1.setOderDate("OrderDate");
        o1.setAmount("Amount");
        o1.setDeliveryDate("DeliveryDate");
        FileOperations fl= new FileOperations();
        fl.createFile(o1);

		System.out.println("************Order Management System*************");
		System.out.println("enter the choice");
		System.out.println("1.Add Order");
		System.out.println("2.View Order List");
		System.out.println("3.View By Order Id");
		System.out.println("4.Sort Order");
		System.out.println("5.Delete Order by Id");
		System.out.println("6.Mark as Delivered");
		System.out.println("7.Generate Report");
		System.out.println("8.Exit");
		int choice;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter choice");
		choice=sc.nextInt();
		OrderManagementServiceImpl order1=new OrderManagementServiceImpl();
	    while(choice!=8)
		{
	    	switch(choice)
	    	{
	    		case 1:
	    		String input="y";
	    		while(input.compareToIgnoreCase("y")==0)
	    		{
	    		order1.inputData();
	    		System.out.println("Do you want to enter more order details(Y/N)\r\n"
	    				+ "If Y: Enter another order.\r\n"
	    				+ "If N: Show the menu.\r\n"
	    				);
	    		input=sc.next();
	    		}
	    		break;
	    		case 2:
	    			
	    		//orderheader.viewOrder();	
	    		order1.viewOrder();
	    		
	    		break;
	    		case 3:
	    		System.out.println("enter the orderId");
	    		String or=sc.next();
	    		order1.viewOrder(or);
	    		break;
	    		case 4:
	    			System.out.println("enter the property based on which you waznt to sort");
	    			System.out.println("1.OrderId");
	    			System.out.println("2.Description");
	    			System.out.println("3.Delivery Address");
	    			System.out.println("4.Order date");
	    			System.out.println("5.amount");
	    			System.out.println("6.delivery date");
	    			int ch=sc.nextInt();
	    			order1.sortOrder(ch);
	    		break;
	    		case 5:
	    			String input2="y";
	    			while(input2.compareToIgnoreCase("y")==0)
		    		{
	    				System.out.println("enter the order id which is to be deleted");
		    			String id=sc.next();
		    			order1.deleteOrder(id);
		    			System.out.println("Do you want to enter delete mode details(Y/N)\r\n"
		    				+ "If Y: Enter another order.\r\n"
		    				+ "If N: Show the menu.\r\n"
		    				);
		    				input2=sc.next();
		    		}
	    			
	    		break;
	    		case 6:
	    			String input1="y";
	    			while(input1.compareToIgnoreCase("y")==0)
		    		{
	    				System.out.println("enter the order id which needs to be marked as delivered");
		    			String oid=sc.next();
		    			order1.markAsDelivered(oid);
		    			System.out.println("Do you want to mark another Order as Delivered(Y/N))\r\n"
		    				+ "If Y: Enter another order.\r\n"
		    				+ "If N: Show the menu.\r\n"
		    				);
		    				input1=sc.next();
		    		}
	    		break;
	    		case 7:
	    			order1.report(o1);
	    		break;
	    		case 8:
	    			System.exit(0);
    	}
	    	System.out.println("enter choice");
			choice=sc.nextInt();
	    
		}
	}
		
}



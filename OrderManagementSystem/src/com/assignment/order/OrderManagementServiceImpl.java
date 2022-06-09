package com.assignment.order;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class OrderManagementServiceImpl implements OrderManagementService{
	 String orderId;
	 String description;
	 String deliveryAddress;
	 String oderDate;
	 String amount;
	 String deliveryDate;
	 String delivered="no";
	 List<Order>arr=new ArrayList<Order>();
	 public void inputData()
	 {
		 FileOperations fo = new FileOperations();
		 arr = fo.readFile();
		 Scanner sc= new Scanner(System.in);
		 String []Orders = new String[arr.size()];
		 	int flag=1;
		 	while(flag==1)
		 	{
		 		int flagOrder=1;
				while(flagOrder==1)
				{
			 		System.out.println("enter orderid");
					orderId=sc.nextLine();
					int j =0;
					for(Order i:arr)
					{
						
						Orders[j] = i.getOrderId();
						j++;
						
					}
					for(String str:Orders)
					{
						if(orderId.compareToIgnoreCase(str)==0)
						{
							flagOrder=1;
							flag=1;
							System.out.println("enter unique orderId");
							
						}
						else
						{
							flagOrder=0;
							flag=0;
							//System.out.println("false");
						}
					}
				}
		 	
				System.out.println("enter description");
				description=sc.nextLine();
				System.out.println("enter Delivery Address");
				deliveryAddress=sc.nextLine();
				 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
				 LocalDateTime now = LocalDateTime.now();  
				 oderDate=dtf.format(now);
				System.out.println("enter amount");
				amount=sc.nextLine();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
				Calendar cal= Calendar.getInstance();
				try
				{
					cal.setTime(sdf.parse(oderDate));
				}
				catch(ParseException e)
				{
					//e.printStackTrace();
				}
				cal.add(Calendar.DAY_OF_MONTH, 5);
				deliveryDate= sdf.format(cal.getTime());
				flag=0;
		 	}
		    addData(orderId,description,deliveryAddress,oderDate,amount,deliveryDate);
	 }
	 Order order=new Order();
	@Override
	public void addData(String orderId,String description,String deliveryAddress,String oderDate, String amount,String deliveryDate) 
	{
		//Order order=new Order();
		order.setOrderId(orderId);
		order.setDescription(description);
		order.setDeliveryAddress(deliveryAddress);
		order.setOderDate(oderDate);
		order.setAmount(amount);
		order.setDeliveryDate(deliveryDate);
		arr.add(order);
		FileOperations op=new FileOperations();
		System.out.println("Data entry");
		//myWriter=Writer.nullWriter();
		op.writeFile(order);
	}
	@Override
	public void viewOrder() 
	{
		FileOperations fo = new FileOperations();
		arr = fo.readFile();
		for(int i=0;i<arr.size();i++)
		{
			
			System.out.println(arr.get(i).getOrderId()+" | "+arr.get(i).getDescription()+" | "+arr.get(i).getDeliveryAddress()+" | "+arr.get(i).getOderDate()+" | "+arr.get(i).getAmount()+" | "+arr.get(i).getDeliveryDate());
		}
	}
	public void viewOrder(String orderId)
	{
		FileOperations fo = new FileOperations();
		arr = fo.readFile();
		for(int i=0;i<arr.size();i++)
		{
			if (arr.get(i).getOrderId().compareToIgnoreCase(orderId)==0) {
			System.out.println("OrderId : "+arr.get(i).getOrderId());
			System.out.println("Description : "+arr.get(i).getDescription());
			System.out.println("Delivery Address : "+arr.get(i).getDeliveryAddress());
			System.out.println("Order Date : "+arr.get(i).getOderDate());
			System.out.println("Amount : "+arr.get(i).getAmount());
			System.out.println("Delivery date : "+arr.get(i).getDeliveryDate());
		}
		}
	}
	
	@Override
	public void sortOrder(int ch) 
	{
		FileOperations fo = new FileOperations();
		arr = fo.readFile();
		List<Order>arr1=new ArrayList<Order>();
		arr1 = fo.readFile();
		Order orderheader = arr1.get(0);
		arr.remove(0);
		System.out.println(orderheader.getOrderId() + " | " + orderheader.getDescription() + " | " + orderheader.getDeliveryAddress()  + " | " + orderheader.getOderDate() + " | " +orderheader.getAmount() + " | " + orderheader.getDeliveryDate());
		switch (ch)
		{
			case 1:
				arr.sort((o1, o2) -> o1.getOrderId().compareTo(o2.getOrderId()));
				for (Order obj :arr) 
				{
		            System.out.println(obj.getOrderId() + " | " + obj.getDescription() + " | " + obj.getDeliveryAddress()  + " | " + obj.getOderDate() + " | " +obj.getAmount() + " | " + obj.getDeliveryDate());
				}
			break;
			case 2:
				arr.sort((o1, o2) -> o1.getDescription().compareTo(o2.getDescription()));
				for (Order obj :arr) 
				{
		            System.out.println(obj.getOrderId() + " | " + obj.getDescription() + " | " + obj.getDeliveryAddress()  + " | " + obj.getOderDate() + " | " +obj.getAmount() + " | " + obj.getDeliveryDate());
				}
			break;
			case 3:
				arr.sort((o1, o2) -> o1.getDeliveryAddress().compareTo(o2.getDeliveryAddress()));
				for (Order obj :arr) 
				{
		            System.out.println(obj.getOrderId() + " | " + obj.getDescription() + " | " + obj.getDeliveryAddress()  + " | " + obj.getOderDate() + " | " +obj.getAmount() + " | " + obj.getDeliveryDate());
				}
			break;
			case 4:
				arr.sort((o1, o2) -> o1.getOderDate().compareTo(o2.getOderDate()));
				for (Order obj :arr) 
				{
		            System.out.println(obj.getOrderId() + " | " + obj.getDescription() + " | " + obj.getDeliveryAddress()  + " | " + obj.getOderDate() + " | " +obj.getAmount() + " | " + obj.getDeliveryDate());
				}
			break;
			case 5:
				arr.sort((o1, o2) -> o1.getAmount().compareTo(o2.getAmount()));
				for (Order obj :arr) 
				{
		            System.out.println(obj.getOrderId() + " | " + obj.getDescription() + " | " + obj.getDeliveryAddress()  + " | " + obj.getOderDate() + " | " +obj.getAmount() + " | " + obj.getDeliveryDate());
				}
			break;
			case 6:
				arr.sort((o1, o2) -> o1.getDeliveryDate().compareTo(o2.getDeliveryDate()));
				for (Order obj :arr) 
				{
		            System.out.println(obj.getOrderId() + " | " + obj.getDescription() + " | " + obj.getDeliveryAddress()  + " | " + obj.getOderDate() + " | " +obj.getAmount() + " | " + obj.getDeliveryDate());
				}
			break;
		}
	}
				

	@Override
	public void deleteOrder(String id) 
	{
		FileOperations fo = new FileOperations();
		arr = fo.readFile();
		int i=0,j=0;
		int []index = new int[arr.size()];
		for (Order itr : arr)
		{
			
			if(itr.getOrderId().compareToIgnoreCase(id)==0)
			{
			index[j] = i;
			j++;
			}
			else
			{
				System.out.println("Order Id is not available");
				i++;
			}
	
		}
		for (i=0;i<=j;i++)
		{
			arr.remove(index[i]);
		}
        fo.Delete(arr);
        
	}

	@Override
	public void report(Order orderheader) 
	{
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);

	    ReaderThread reader = new ReaderThread(queue);
	    WriterThread writer = new WriterThread(queue);

	    new Thread(reader).start();
	    new Thread(writer).start();
	    System.out.println("successfully wrote to the file");
	}
	@Override
	public void markAsDelivered(String id) 
	{
		FileOperations fo = new FileOperations();
		arr = fo.readFile();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		 LocalDateTime now = LocalDateTime.now();  
		for(int i=0;i<arr.size();i++)
		{
			id=arr.get(i).getOrderId();
			System.out.println("delivery Date = "+arr.get(i).getDeliveryDate()+"\r\n"+"current time: "+dtf.format(now));
			
			
			if((dtf.format(now).compareTo(arr.get(i).getDeliveryDate())>0))
			{
				System.out.println("Order will be  delivered on "+arr.get(i).getDeliveryDate());
				
			}
			else if((dtf.format(now).compareTo(arr.get(i).getDeliveryDate())==0))
			{
				System.out.println("successfully delivered");
				delivered="yes";
			}
		}
	}

}

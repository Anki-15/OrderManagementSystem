package com.assignment.order;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileOperations 
{
	
		public  void writeFile(Order orderheader)
		{
			try 
			{
				 Files.write(Paths.get("Orders.txt"), (orderheader.getOrderId()+"|"+orderheader.getDescription()+"|"+orderheader.getDeliveryAddress()+"|"+orderheader.getOderDate()+"|"+orderheader.getAmount()+"|"+orderheader.getDeliveryDate() +"\r\n").getBytes(), StandardOpenOption.APPEND);
			      System.out.println("Successfully wrote to the file.");
			 } 
			catch (IOException e)
				{
			      System.out.println("An error occurred.");
			      //e.printStackTrace();
			    }
		}
		public  void createFile(Order orderheader)
		{
			try 
			{
				Files.write(Paths.get("Orders.txt"), (orderheader.getOrderId()+"|"+orderheader.getDescription()+"|"+orderheader.getDeliveryAddress()+"|"+orderheader.getOderDate()+"|"+orderheader.getAmount()+"|"+orderheader.getDeliveryDate() +"\r\n").getBytes(), StandardOpenOption.CREATE_NEW);
			      System.out.println("Successfully Created a file.");
			 } 
			catch (IOException e)
				{
			      System.out.println("File Exists.");
			    }
		}
		
		public  void Delete(List<Order>arr)
		{
			File f = new File("Orders.txt");
			File f1 = new File("ArchiveOrder.txt");
			if (f1.exists()) {
			f1.delete();
			}
			f.renameTo(f1);
			
			Order o1=new Order();
	        o1.setOrderId("orderId");
	        o1.setDescription("Description");
	        o1.setDeliveryAddress("Delivery Address");
	        o1.setOderDate("OrderDate");
	        o1.setAmount("Amount");
	        o1.setDeliveryDate("DeliveryDate");
	        FileOperations fl= new FileOperations();
	        fl.createFile(o1);
	        
	        for (Order O:arr)
	        {
	        fl.writeFile(O);
	        }
		}
		
		public ArrayList<Order> readFile()
		{
			Stream<String> lines;
			try {
				lines = Files.lines(Paths.get("Orders.txt"));
				List<String> result = lines.collect(Collectors.toList());
				ArrayList<Order> list = new ArrayList<Order>();
				Order O[] = new Order[result.size()];
				
				for(int i=0;i<result.size();i++)
				{
					
					String s=result.get(i);
					O[i] = new Order();
					s = s.replace("|",",");
					String[] s2 = s.split(",");
					
					O[i].setOrderId(s2[0]);
					O[i].setDescription(s2[1]);
					O[i].setDeliveryAddress(s2[2]);
					O[i].setOderDate(s2[3]);
					O[i].setAmount(s2[4]);
					O[i].setDeliveryDate(s2[5]);					
				}
				
				
				
				list.addAll(Arrays.asList(O));
				return list;
				
					
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}		
		}
		
	 }



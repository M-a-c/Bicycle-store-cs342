package edu.uic.cs342.group1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.ArrayList;

import edu.uic.cs342.group1.Client.saveType;

public class BikeStore {
	//these three functions will be all we need to save/load as text file or saved objects
	public enum saveType { CUSTOMER, INVENTORY, LOWSTOCK }
	
	public static void main(String[] args) throws IOException, ClassNotFoundException{
  
        Customer cust = new Customer();
        PrintManager p = new PrintManager();
        Container inventory = new Container();
        Container receipt = new Container();
        Item i;
	String input;
		
	    System.out.print("Simple Bicyle Store\n"
		    	+ "Group #1 \n\n"
		    	+ "Project Lead: Bunty Patel\n"
		    	+ "Member: Mac Carter, Arkadiusz Pamula, Brad Cortright, Guiquan Liu\n");
	
	    System.out.println("Starting Program");

		//these 11 items (or some variation) will be saved to a save file and loaded as base inventory; will need to make sure the .sav
		//file is in the file we turn in and in the correct folder.
		Bike bike1 = new Bike("Bike", 128.30, 0.0, "Used", 5.0, 10.3,"Trev's Auto", 98.10, "555", 66666, 10, false, false, "Street", 7, "Red",10);
		Bike bike2 = new Bike("Bike", 210.26, 0.0, "New", 5.10, 9.3, "Hot Rod", 156.36, "45710", 54545, 0, true, true, "Mountain", 4, "Blue",0);
		Bike bike3 = new Bike("Bike", 98.75, 0.25, "Used", 5.33, 8.7, "Genny's", 76.33, "2014", 3232, 2, true, false, "Dirt", 3, "Green",2);
		Bike bike4 = new Bike("Bike", 178.77, 0.10, "New", 5.0, 10.77,"Trev's Auto", 160.99, "555", 10247, 0, false, false, "Dirt", 12, "Red",0);
		Bike bike5 = new Bike("Bike", 269.69, 0.0, "New", 6.22, 9.1,"Trev's Auto", 198.72, "10258", 62547, 10, false, false, "Street", 1, "Green",10);
		Part part1 = new Part("Gear", 3.33, 3.6, "Used", .75, .42, "Wholesaler's Inc", 1.75, "12", 111, 32, false, false, 7.75, 32);
		Part part2 = new Part("Pedal", 12.99, 0.0, "New", 5.7, 7.32, "Year's Best", 8.55, "7548", 8563, 1, true, false, 16.21, 1);
		Part part3 = new Part("Chain", 6.75, 0.0, "New", .36, 5.2, "New Parts", 4.86, "36501", 7452, 0, true, true, 10.87, 0);
		Part part4 = new Part("Wheel", 54.55, 2.5, "New", 6.85, .15, "Wholesaler's Inc", 42.11, "1200", 99147, 17, false, false, 95.22, 17);
		Part part5 = new Part("Seat", 20.36, .30, "Used", 2.25, 10.36, "Hot Rod", 17.00, "12", 980, 9, false, false, 39.75, 9);
		Part part6 = new Part("Reflective Mirrors", 10.99, 0.0, "New", .25, 1.75, "New Parts", 7.75, "1665", 147, 20, false, false, 17.55, 20);
		
		
		inventory.addItem(bike1);
		inventory.addItem(bike2);
		inventory.addItem(bike3);
		inventory.addItem(part1);
		inventory.addItem(part2);
		inventory.addItem(part3);
		inventory.addItem(bike4);
		inventory.addItem(part4);
		inventory.addItem(part5);
		inventory.addItem(bike5);
		inventory.addItem(part6);
		
		save(inventory, saveType.INVENTORY);

	    PrintCommand();
        Scanner s = new Scanner(System.in);
        
        while(s.hasNext())
        {
        	input = takeInput(s);
        	char ch = input.charAt(0);
        	
        	// Quits the program
        	if(ch == 'q')
            {
            	System.out.println("Quitting Program");
                s.close();
                return;
            }
        	//****read file not done
        	else if (ch == 'r')
        	{
        		System.out.println("\nReading file....\n");
        		inventory = load();
        	}
        	//write file
        	else if(ch == 'w')
        	{
        		System.out.println("\nWriting file....\n");
        		save(inventory, saveType.INVENTORY);
        	}
            
            // look up items
            else if(ch == 'l')
            {
            	System.out.print("Please enter item bar code you want to look up: ");
            	
            	String name =  s.nextLine();
            
            	i = cust.ItemLookup(name);
            }
            
            //customer check out
            else if(ch == 'c')
            {
             	System.out.println("Please tell me what type of customer you are?");
            	System.out.println("     1. Normal  ");
            	System.out.println("     2. Vetrran  ");
            	System.out.println("     3. Preferred Customer  ");
            	System.out.println("     4. Tax Exempt  ");
            	System.out.print("Please choose a number: ");
            	
            	//customer type
            	int type = s.nextInt();
            	//item name
            	String name;
            	double subtotal =0.0;
            	
            	// Create new ArrayList.
            	Container cart = new Container();
            	
            	System.out.println("Please enter the item name you want to add to cart, f to finish and proceed to checkout");
            	
            	//take item name
            	name = s.nextLine();
            	
            	while(! name.equals("f"))
            	{
            		i = cust.ItemLookup(name);
            		
            		//check if low stock
            		if(i.isLowStock())
            		{
            			
            			System.out.println("Item is low stock, and only "+ i.getQuantity()+" item left");
            		}
            		
            		//check if out of stock
            		else if (i.isOutOfStock())
            		{
            			System.out.println("Item is out of stock");
            		}
            		
            		else
            		{
            			System.out.println("Please enter the amount for the item you just added.");
                    	
                    	int amount = s.nextInt();
                    	
                    	i.setQuantity(amount);
                    	
                    	cart.addItem(i);
                    	
                    	// Loop through elements.
                    	
                    	System.out.println("Items: ");
                    	
                    	//********** need to get size of container list*********
                    	for (int j = 0; j < cart.size(); j++) {
                    	    Item it = cart.getItem(j);
                    	    subtotal = subtotal+ it.getPrice()*it.getQuantity();
                    	    System.out.println(i+". "+it.getName() + "X"+ it.getQuantity()+ "  ");
                    	}
                    	System.out.println("Subtotal: $ "+ subtotal);
                    	
                    	System.out.println("Please enter the item name you want to add to cart"
                    			+ " f to finish and proceed to checkout");
                    	
                    	name = s.nextLine();
            		}
                }
            	System.out.println("Calculating the final price...");
            	
            	double fp = cust.getPrice(subtotal);
            
            	System.out.println("Final price is "+ fp + "comfirm payment? Y - yes, N - No ");
            	
            	String cfstring = s.next();
            	
            	cfstring.toUpperCase();
            	char cf = cfstring.charAt(0);
            	
            	if(cf == 'Y')
            	{
            		//update inventory 
            		//********NOT DONE  need size of container list also********
            		
            		//save inventory
            		save(cart, saveType.INVENTORY);
            		
            		//save cart
            		save(cart, saveType.CUSTOMER);
            	}
            	
            	else if(cf == 'N')
            	{
            		System.out.println("Cart clean...");
            	}
            		
            }
            
            //Print purchase list
            else if(ch == 'p')
            {
            	//p.printlist(PurchaseList);
            }
            
            //print contain in stock
            else if(ch =='i')
            {
            	//p.printlist(containInStock);
            }
            
            else
            {
                System.out.println ("Invalid command input");
                System.out.println ("Clearing until End of Line *" + s.nextLine() + "*");
            }   
            System.out.print ("\nEnter a command: ");

        }
        System.out.println("Quiting Program - EOF reached\n"); 
	}
	
	public static void PrintCommand()
	{
	    System.out.println("r - Read file");
	    System.out.println("w - Write file");
	    System.out.println("l — Look up items");
        System.out.println("c - Customer check out");
        System.out.println("p - Print purchase list");
        System.out.println("o - Print contain out of stock");
        System.out.println("q - Quits the program\n");
        System.out.print ("Please enter a command: ");
	}
	
	public static String takeInput(Scanner s)
	{
		String command = s.next();
		return command;
	}
	
	public static Container load() throws IOException, ClassNotFoundException{
		Container tempCont = new Container();
		FileInputStream loadFile = new FileInputStream("SaveObj.sav");
		ObjectInputStream loadCont = new ObjectInputStream(loadFile);
		tempCont = (Container) loadCont.readObject();
		loadCont.close();
		return tempCont;
	}
	
	public static void save(Container items, saveType typeOfSave) throws IOException{
		switch (typeOfSave){
		
			case INVENTORY: 
				FileOutputStream saveFile = new FileOutputStream("Inventory.sav");
				ObjectOutputStream saveObj = new ObjectOutputStream(saveFile);
				saveObj.writeObject(items);
				saveObj.close();
				break;
				
			case CUSTOMER: 
				String printStrCust;
				Iterator custIter = items.createIterator();
				Item tmpCust;
				FileWriter saveCust = new FileWriter("customer.txt");
				
				while (custIter.hasNext()){
					 tmpCust = (Item)custIter.next();
						 printStrCust = "Name: " + tmpCust.getName();
					 saveCust.write(printStrCust);
					 
					 if (tmpCust.getName() == "Bike"){
						 printStrCust = "\r\nColor: " + ((Bike)tmpCust).getColor() + "\r\nSpeed: " + ((Bike)tmpCust).getSpeed();
					 saveCust.write(printStrCust);
					 }
					printStrCust = "\r\nPrice: $" + tmpCust.getPrice() + 
				    "\r\nQty: " + tmpCust.getQuantity() + "\r\n\r\n";
					saveCust.write(printStrCust);
				}
				saveCust.close();
				break;
				
			case LOWSTOCK: 
				String printStr;
				Iterator stockIter = items.createIterator();
				Item tmpStock;
				FileWriter saveStock = new FileWriter("Low_stock.txt");
				
				while (stockIter.hasNext()){
					 tmpStock = (Item)stockIter.next();
					printStr = "Name: " + tmpStock.getName() + "\r\nNumber in stock: " + tmpStock.getStock() + "\r\n********************" + 
				    "\r\nPlease order " + tmpStock.getStock() * 2 + "\r\nSold by: " + tmpStock.getSupplierName() + 
				    "\r\nSupplier price: $" + tmpStock.getSupplierPrice() + "\r\nSupplier's ID for item: " + 
				    tmpStock.getReorderNumber() + "\r\n--------------------\r\n\r\n";
					saveStock.write(printStr);
				}
				saveStock.close();
				break;
				
			default: break;
		}
	}

}

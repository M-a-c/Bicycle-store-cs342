package edu.uic.cs342.group1;

import java.util.Scanner;
import java.util.ArrayList;

public class BikeStore {
	public static void main(String[] args) {

        Customer cust = new Customer();
        PrintManager p = new PrintManager();
        Container containInStock = null;
        Container PurchaseList;
        Item i;
	    String input;
		
	    System.out.print("Simple Bicyle Store\n"
		    	+ "Group #1 \n\n"
		    	+ "Project Lead: Bunty Patel\n"
		    	+ "Member: Mac Carter, Arkadiusz Pamula, Brad Cortright, Guiquan Liu\n");
	
	    System.out.println("Starting Program");

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
        		containInStock = readFile();
        	}
        	//write file
        	else if(ch == 'w')
        	{
        		System.out.println("\nWriting file....\n");
        		writeFile(containInStock);
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
            	ArrayList<Item> cart = new ArrayList<Item>();
            	
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
                    	
                    	cart.add(i);
                    	
                    	// Loop through elements.
                    	
                    	System.out.println("Items: ");
                    	for (int j = 0; j < cart.size(); j++) {
                    	    Item it = cart.get(j);
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
            		//write file
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
	
	public static Container readFile()
	{
		// need code
		// get containInStock
		return null;
	}
	
	public static void writeFile(Container c)
	{
		//need code
	}

}

package edu.uic.cs342.group1;

import java.util.Scanner;
import java.util.ArrayList;

public class BikeStore {
	public static void main(String[] args) {

        Customer cust;
        printManager p = new PrintManager();
        Container containInStock;
        //Container containOutStock;
        //Container containSoldList;
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
        	//read file 
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
            	System.out.print("Please eneter item bar code you want to look up: ");
            	
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
            	
            	// Create new ArrayList.
            	ArrayList<Item> cart = new ArrayList<>();
            	
            	System.out.println("Please enter the item name you want to add to cart, q to proceed to checkout");
            	
            	//take item name
            	name = s.nextLine();
            	char n = name.charAt(0);
            	
            	while(n != 'q')
            	{
            		i = cust.ItemLoopup(name);
                	System.out.println("Please enter the amount for the item you just added.");
                	
                	int amount = s.nextInt();
                	
                	i.setQuantity(amount);
                	
                	cart.add(i);
                	
                	// Loop through elements.
                	System.out.println("Subtotal: ");
                	for (int j = 0; j < cart.size(); j++) {
                	    Item it = cart.get(j);
                	    System.out.println(i+". "+it.getName() + "X"+ it.getQuantity()+ "  ");
                	}
                	
                	System.out.println("Please enter the item name you want to add to cart, q to proceed to checkout");
                	
                	name = s.nextLine();
                	
            	}
            	System.out.println("Calculating the final price...");
            	
            	int fp = cust.finalprice(type, cart);
            
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
            
            //print sold list
            else if(ch == 's')
            {
            	//p.printlist(containSoldList);
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
        	
        	//print contain out of stock
            else if(ch =='o')
            {
            	//p.printoutofstock(containOutStock);
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
        System.out.println("s - Print sold list");
        System.out.println("p - Print purchase list");
        System.out.println("i — Print contain in stock");
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
		//need code
		// get containInStock
		//retrun continer;
	}
	
	public static void writeFile(Container c)
	{
		//need code
	}

}

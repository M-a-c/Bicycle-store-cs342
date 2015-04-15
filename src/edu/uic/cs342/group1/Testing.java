package test;
import java.io.*;
import java.util.Arrays;

public class Testing {
/*This is saving as a string to a text file. Imagine the delimeters are replaced with each element we want 
 * to save on a new line with appropriate descriptors in the text, i.e. "Price: " etc. It is just one of my 
 * test attempts to see how it'd work. Just to give an idea of how text files will be written
 */
	public enum Items{
		BIKE, GEAR, CHAIN
	}
	
	public static void main (String[] args) throws IOException{
		String name = "Bike";
		double price = 27.2;
		int count = 4;
		boolean lowStock = true;
		
		String mystr = name +"/" + price +"/" + count +"/" + lowStock + "\n";
		System.out.println(mystr);
		BufferedWriter save = new BufferedWriter(new FileWriter("test.txt"));
		save.write(mystr);
		save.close();
		
		BufferedReader load = new BufferedReader(new FileReader("test.txt"));
		String[] tempStr;
		mystr = load.readLine();
		tempStr = mystr.split("/");
		load.close();
		name = tempStr[0];
		price = Double.parseDouble(tempStr[1]);
		count = Integer.parseInt(tempStr[2]);
		lowStock = Boolean.parseBoolean(tempStr[3]);
		System.out.println("AFTER LOAD\n");
		System.out.println(name + " "  + price + " " + count +" " + lowStock);
		System.out.println("ORDINAL: " + Items.BIKE.ordinal() +" "+ Items.GEAR.ordinal() +" "+ Items.CHAIN.ordinal());
		
		
		
	}
	
	
}

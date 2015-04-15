/*this version was a test to see how saving objects and loading objects would work. Again, just me 
 * trying to figure out the mechanics and experimenting. 
 */
import java.io.IOException;
import java.util.*;
import java.io.*;
public class SaveLoadObjectTestClient {

	public static void main (String[] args) throws IOException, ClassNotFoundException{
		SaveLoadObjectTest bike1 = new SaveLoadObjectTest("Bike", 23.2, 4, true);
		SaveLoadObjectTest part1 = new SaveLoadObjectTest("Gear", 1.2, 1, true);
		SaveLoadObjectTest part2 = new SaveLoadObjectTest("Chain", 3.65, 9, false);
		SaveLoadObjectTest part3 = new SaveLoadObjectTest("Pedal", 4.66, 10, false);
		
		ArrayList<SaveLoadObjectTest> list = new ArrayList<>();
		list.add(bike1);
		list.add(part1);
		list.add(part2);
		list.add(part3);
		
		for (int i = 0; i < 4;  ++i){
		System.out.println("Contents of list: " + list.get(i).name + " " + list.get(i).price + " " + list.get(i).count + " " + list.get(i).lowStock);
		}
	
	
	FileOutputStream saveFile = new FileOutputStream("SaveObj.sav");
	ObjectOutputStream save = new ObjectOutputStream(saveFile);
	for (int i = 0; i < 4;  ++i){
		save.writeObject((list.get(i)));
	}
	save.close();
	
	FileInputStream loadFile = new FileInputStream("SaveObj.sav");
	ObjectInputStream load = new ObjectInputStream(loadFile);
	ArrayList<SaveLoadObjectTest> listRead = new ArrayList<>();
	
	for (int i = 0; i < 4;  ++i){
	listRead.add((SaveLoadObjectTest) load.readObject());
	}
	load.close();
	
	System.out.println();
	
	for (int i = 0; i < 4;  ++i){
		System.out.println("Contents of list after Read: " + listRead.get(i).name + " " + listRead.get(i).price + " " + listRead.get(i).count + " " + listRead.get(i).lowStock);
		}
	
}
}

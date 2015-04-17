
import java.io.*;


public class Client {
	
	public enum saveType { CUSTOMER, INVENTORY, LOWSTOCK }
	
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
	
	
	public static Container load() throws IOException, ClassNotFoundException{
		Container tempCont = new Container();
		FileInputStream loadFile = new FileInputStream("SaveObj.sav");
		ObjectInputStream loadCont = new ObjectInputStream(loadFile);
		tempCont = (Container) loadCont.readObject();
		loadCont.close();
		return tempCont;
	}
	
	
	public static void main (String[] args) throws IOException, ClassNotFoundException{
	Container inventory = new Container();

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
	
	
	Bike bikeTest = (Bike)inventory.getItem(0);
	Part partTest = (Part)inventory.getItem(5);
	System.out.println("Bike test: " + bikeTest.getColor());
	System.out.println("Part test: " + partTest.getBulkPrice());
	
	save(inventory, saveType.INVENTORY);
	Container loadCont = new Container();

	loadCont = load();
	
	bikeTest = (Bike)loadCont.getItem(2);
	partTest = (Part)loadCont.getItem(7);

	System.out.println("Bike test: " + bikeTest.getColor());
	System.out.println("Part test: " + partTest.getBulkPrice());
	
	save(inventory, saveType.LOWSTOCK);
	save(inventory, saveType.CUSTOMER);

	}
}

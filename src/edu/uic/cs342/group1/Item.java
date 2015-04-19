package edu.uic.cs342.group1;

public class Item {
	
	//Private variables of item.
	private String name;
	private double price;
	private double promotion;
	private String description;
	private double sqftOccupied;
	private double weight;
	private String supplierName;//added;UML diagram needs updating
	private double supplierPrice;
	private String reorderNumber;
	private int barcode;
	private int stock;
	private int quantity;
	
	//constructor																									//added
	public Item(String name,double price,double promotion,String description,double sqftOccupied,double weight,String supplierName, 
			    double supplierPrice, String reorderNumber,int barcode,int stock, int q){
		this.name = name;
		this.price = price;
		this.promotion = promotion;
		this.description = description;
		this.sqftOccupied = sqftOccupied;
		this.weight = weight;
		this.supplierName = supplierName;//added UML?
		this.supplierPrice = supplierPrice;
		this.reorderNumber = reorderNumber;
		this.barcode = barcode;
		this.stock = stock;
		this.quantity = q;

	}
	//Default constructor
	public Item(){
		this.name = "";
		this.price = 0;
		this.promotion = 0;
		this.description = "";
		this.sqftOccupied = 0;
		this.weight = 0;
		this.supplierName = "";
		this.supplierPrice = 0;
		this.reorderNumber = "";
		this.barcode = 0;
		this.stock = 0;
		this.quantity = 0;
	}
	
	public Item copyItem() {
		return null;
	}
	public void printInfo() {
		System.out.println("Name: " + this.name);
		System.out.println("Price: " + this.price);
		System.out.println("Promotion: " + this.promotion);
		System.out.println("Description: " + this.description);
		System.out.println("Square Foot Occupied: " + this.sqftOccupied);
		System.out.println("Weight: " + this.weight);
		System.out.println("Supplier Price: " + this.supplierPrice);
		System.out.println("Reorder Number: " + this.reorderNumber);
		System.out.println("Barcode: " + this.barcode);
		System.out.println("Low Stock: " + (stock < 5));
		System.out.println("Out of Stock: " + (stock == 0));
		System.out.println("Stock: " + this.stock);
	}
	//All getters and setters.
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setQuantity(int q) {
		this.quantity = q;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPromotion() {
		return promotion;
	}
	public void setPromotion(double promotion) {
		this.promotion = promotion;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getSqftOccupied() {
		return sqftOccupied;
	}
	public void setSqftOccupied(double sqftOccupied) {
		this.sqftOccupied = sqftOccupied;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String newName) {
		this.supplierName = newName;
	}
	public double getSupplierPrice() {
		return supplierPrice;
	}
	public void setSupplierPrice(double supplierPrice) {
		this.supplierPrice = supplierPrice;
	}
	public String getReorderNumber() {
		return reorderNumber;
	}
	public void setReorderNumber(String reorderNumber) {
		this.reorderNumber = reorderNumber;
	}
	public int getBarcode() {
		return barcode;
	}
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public boolean isLowStock() {
		return (stock < 5 && stock > 0);
	}
	public boolean isOutOfStock() {
		return (stock == 0);
	}
	
}
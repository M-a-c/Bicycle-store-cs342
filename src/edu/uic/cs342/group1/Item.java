package edu.uic.cs342.group1;

public class Item {
	
	//Private variables of item.
	private String name;
	private double price;
	private double promotion;
	private String description;
	private double sqftOccupied;
	private double weight;
	private double supplierPrice;
	private String reorderNumber;
	private int barcode;
	private int stock;
	private boolean lowStock;
	private boolean outOfStock;
	private int quantity;
	
	//constructor
	public Item(String name,double price,double promotion,String description,double sqftOccupied,double weight,double supplierPrice,String reorderNumber,int barcode,int stock,boolean lowStock,boolean outOfStock, int q){
		this.name = name;
		this.price = price;
		this.promotion = promotion;
		this.description = description;
		this.sqftOccupied = sqftOccupied;
		this.weight = weight;
		this.supplierPrice = supplierPrice;
		this.reorderNumber = reorderNumber;
		this.barcode = barcode;
		this.stock = stock;
		this.lowStock = lowStock;
		this.outOfStock = outOfStock;
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
		this.supplierPrice = 0;
		this.reorderNumber = "";
		this.barcode = 0;
		this.stock = 0;
		this.lowStock = true;//if everything is 0, these are certainly true
		this.outOfStock = true;
		this.quantity = 0;
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
		return lowStock;
	}
	public void setLowStock(boolean lowStock) {
		this.lowStock = lowStock;
	}
	public boolean isOutOfStock() {
		return outOfStock;
	}
	public void setOutOfStock(boolean outOfStock) {
		this.outOfStock = outOfStock;
	}
	
}

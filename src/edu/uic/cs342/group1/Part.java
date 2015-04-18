package edu.uic.cs342.group1;

import java.io.Serializable;
public class Part extends Item implements Serializable {//serialziable added for saving; UML change needed?

	//added for warning for Serializable interface;UML change? without it there's warnings but compiles and runs fine
	//with it works fine and no warnings, but I'm not sure it's need or what issues can arise with this
	//private static final long serialVersionUID = -1483927828949979355L;
	//Variables
	private double bulkPrice;//changed to double; UML change needed?

	//constructor
	public Part(int bulkPrice){
		super();
		this.bulkPrice = bulkPrice;
	}
	//default constructor
	public Part(){
		super();
		this.bulkPrice=1;//one item per the price.
	}
																														//added
	public Part(String name, double price, double promotion, String description, double sqftOccupied, double weight, String supplierName, 
			    double supplierPrice, String reorderNumber, int barcode, int stock, boolean lowStock, boolean outOfStock, double bulkPrice, int q){
		super(name, price, promotion, description, sqftOccupied, weight, supplierName, supplierPrice, reorderNumber, barcode, stock, lowStock, outOfStock, q);
		this.bulkPrice = bulkPrice;
	}
	
	
	//getters and setters
	public double getBulkPrice() {
		return bulkPrice;
	}
	public void setBulkPrice(int bulkPrice) {
		this.bulkPrice = bulkPrice;
	}

	
}

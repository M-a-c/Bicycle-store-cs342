package edu.uic.cs342.group1;

public class Part extends Item {
	//Variables
	private int bulkPrice;

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
	
	public Part(String name,double price,double promotion,String description,double sqftOccupied,double weight,double supplierPrice,String reorderNumber,int barcode,int stock,boolean lowStock,boolean outOfStock,int bulkPrice){
		super(name,price,promotion,description,sqftOccupied,weight,supplierPrice,reorderNumber,barcode,stock,lowStock,outOfStock);
		this.bulkPrice = bulkPrice;
	}
	
	
	//getters and setters
	public int getBulkPrice() {
		return bulkPrice;
	}
	public void setBulkPrice(int bulkPrice) {
		this.bulkPrice = bulkPrice;
	}

	
}

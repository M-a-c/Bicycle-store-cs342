package edu.uic.cs342.group1;

public class Bike extends Item{
	
	public Bike(String type,int speed,String color){
		super();
		this.type=type;
		this.speed=speed;
		this.color=color;
	}
	//Default constructor
	public Bike(){
		super();
		this.type="";
		this.speed=0;
		this.color="";
	}	
	public Bike(String name,double price,double promotion,String description,double sqftOccupied,double weight,double supplierPrice,String reorderNumber,int barcode,int stock,boolean lowStock,boolean outOfStock,int bulkPrice,String type,int speed,String color, int q){
		super(name,price,promotion,description,sqftOccupied,weight,supplierPrice,reorderNumber,barcode,stock,lowStock,outOfStock, q);
		this.type=type;
		this.speed=speed;
		this.color=color;
	}

	private String type;
	private int speed;
	private String color;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}

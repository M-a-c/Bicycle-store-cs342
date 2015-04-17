import java.io.Serializable;
public class Bike extends Item implements Serializable{//serialziable added for saving; UML change needed?

	//added for warning for Serializable interface;UML change? without it there's warnings but compiles and runs fine
	//with it works fine and no warnings, but I'm not sure it's need or what issues can arise with this
	//private static final long serialVersionUID = -1493830837646825989L;


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
	}																												//added
	public Bike(String name,double price,double promotion,String description,double sqftOccupied,double weight,String supplierName, 
			    double supplierPrice,String reorderNumber,int barcode,int stock,boolean lowStock,boolean outOfStock,String type,int speed,
			    String color, int q){
		super(name,price,promotion,description,sqftOccupied,weight,supplierName, supplierPrice,reorderNumber,barcode,stock,lowStock,outOfStock, q);
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

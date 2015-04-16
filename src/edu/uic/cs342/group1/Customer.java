package edu.uic.cs342.group1;
import java.util.*;

public class Customer {
	
	private int id;
	private String type;
	private FinalPrice calcPrice;
	private Container cart;
	private PrintManager p;
	
	public Customer(int id, String type){
		this.id = id;
		this.type = type;
	}
	
	public Customer(){
		super();
		this.id = 0;
		this.type = "";
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public Item ItemLookup(String name){
		
		// get barcode Item.getBarcode();
		
		return ;
	}
	
}

package edu.uic.cs342.group1;

public class Veteran implements FinalPrice {

	//assuming for now that veterans get a 10% discount on subtotal with 7% tax
	public double calculatePrice(double subtotal) {	
		return ((subtotal * 0.9) * 1.07);
	}
	
	public void getInfo() {
		System.out.println("Type: Veteran - Discount: 10% - Tax: 7%");
	}

}

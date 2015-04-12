package edu.uic.cs342.group1;

public class PreferredCustomer implements FinalPrice {

	//assuming for now that preferred customers get a 15% discount on subtotal with 7% tax
	public double calculatePrice(double subtotal) {
		return ((subtotal * .85) * 1.07);
	}

}

package edu.uic.cs342.group1;

public class Normal implements FinalPrice {
	
	//assuming 7% tax for now
	public double calculatePrice(double subtotal) {
		return (subtotal * 1.07);
	}

}

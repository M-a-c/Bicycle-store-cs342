package edu.uic.cs342.group1;

public class TaxExempt implements FinalPrice {
	
	public double calculatePrice(double subtotal) {
		return subtotal;
	}

}

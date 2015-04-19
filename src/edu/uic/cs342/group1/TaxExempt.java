package edu.uic.cs342.group1;

public class TaxExempt implements FinalPrice {
	
	public double calculatePrice(double subtotal) {
		return subtotal;
	}
	
	public void getInfo() {
		System.out.println("Type: Tax Exempt - Discount: 0% - Tax: 0%");
	}

}

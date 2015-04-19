package edu.uic.cs342.group1;

public class Normal implements FinalPrice {
	
	//assuming 7% tax for now
	public double calculatePrice(double subtotal) {
		return (subtotal * 1.07);
	}
	
	public void getInfo() {
		System.out.println("Type: Normal - Discount: 0% - Tax: 7%");
	}

}

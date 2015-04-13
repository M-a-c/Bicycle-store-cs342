package edu.uic.cs342.group1;
import java.util.*;

public class Container implements Aggregate {
	private ArrayList<Item> list = new ArrayList<Item>();
	
	@Override
	public Iterator createIterator() {
		Iterator i = new ItemIterator();
		return i;
	}
	
	public int getAmount(int index) { //fix argument in UML diagram
		return list.get(index).getQuantity();
	}
	
	public void changeAmount(int newAmt, int index) { //fix argument in UML diagram		
		list.get(index).setQuantity(newAmt);
	}
	
	public void addItem(Item itm) { //fix argument in UML diagram
		list.add(itm);
	}
	
	public Item getItem(int index) {
		return list.get(index);
	}
	
	public double calcRecommendedPrice(int index) {
		double purchasePrice = list.get(index).getSupplierPrice();
		//assuming it costs $0.01/sqft to store + $5 to hold the item in the store
		return (purchasePrice + 5.0) + (0.01*list.get(index).getSqftOccupied());
	}


	private class ItemIterator implements Iterator {
		private int currentIndex = 0;
		
		@Override
		public boolean hasNext() {
			return currentIndex < list.size();
		}

		@Override
		public Object next() {
			Object next = list.get(currentIndex);
			currentIndex++;
			return next;
		}

		@Override
		public boolean remove(Object it) {
			return list.remove((Item)it);
		}

	}


}

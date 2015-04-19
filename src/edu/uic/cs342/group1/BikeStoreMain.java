package edu.uic.cs342.group1;

import java.io.IOException;

public class BikeStoreMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		BikeStore bs = BikeStore.getInstance();
		bs.run();

	}

}

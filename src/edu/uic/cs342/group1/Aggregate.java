package edu.uic.cs342.group1;

public interface Aggregate {
	//aggregate class that will be the container
	//has to create an iterator to iterate through the aggregate
	public Iterator createIterator();
}

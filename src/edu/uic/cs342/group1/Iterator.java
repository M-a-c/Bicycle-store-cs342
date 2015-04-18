package edu.uic.cs342.group1;

public interface Iterator {
	public boolean hasNext();
	public Object next();
	public boolean remove(Object a); //fix this in UML diagram (needs an argument)
	public int getCurr();//Needed to reset current index/ADDED
	public void resetCurr();//Added; fix UML
}

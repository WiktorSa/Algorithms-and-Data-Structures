package main;
import iterator.NumberIterator;

public class Main22a 
{
	public static void main(String[] args) 
	{
		int przedzial1 = 14;
		int przedzial2 = 25;
		NumberIterator numberIterator = new NumberIterator(przedzial1, przedzial2);
		while (!numberIterator.isDone())
		{
			System.out.println(numberIterator.currentItem());
			numberIterator.next();
		}
	}
}

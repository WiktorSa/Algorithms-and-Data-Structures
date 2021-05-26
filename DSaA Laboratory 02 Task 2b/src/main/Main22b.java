package main;
import iterators.FilterIterator;
import iterators.NumberIterator;
import iterators.PrimeNumbers;

public class Main22b
{
	public static void main(String[] args) 
	{
		int przedzial1 = 0;
		int przedzial2 = 100;
		FilterIterator filterIterator = new FilterIterator(new NumberIterator(przedzial1, przedzial2), new PrimeNumbers());
		while (filterIterator.hasNext())
		{
			System.out.println(filterIterator.next());
		}
	}
}

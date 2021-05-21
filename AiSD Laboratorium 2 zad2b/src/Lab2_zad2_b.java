import java.util.NoSuchElementException;

class NumberIterator
{
	private int min;
	private int max;
	private int currentNumber;
	
	public NumberIterator(int min, int max)
	{
		this.min = min;
		this.max = max;
		currentNumber = min;
	}
	
	public void first()
	{
		currentNumber = min;
	}
	
	public void next() throws NoSuchElementException
	{
		if (!isDone()) {
			currentNumber ++;
		}
		
		else {
			throw new NoSuchElementException();
		}
	}
	
	public boolean isDone()
	{
		return currentNumber > max;
	}
	
	public int currentItem()
	{
		return currentNumber;
	}
}

@SuppressWarnings("hiding")
interface Predicate<Integer>
{
	boolean accept (int arg);
}

class PrimeNumbers implements Predicate<Integer>
{	
	public boolean accept(int number) 
	{
		if (number < 2) {
			return false;
		}
		
		else if (number == 2) {
			return true;
		}
		
		else if (number % 2 == 0) {
			return false;
		}
		
		else {
			for (int i=3; i<number; i+=2)
			{
				if (number % i == 0) {
					return false;
				}
			}
			
			return true;
		}
	}
}

class FilterIterator
{
	private NumberIterator iterator;
	private Predicate<Integer> predicate;
	
	private int elemNext = -1;
	private boolean bHasNext = true;
	
	public FilterIterator(NumberIterator iterator, Predicate<Integer> predicate) 
	{
		this.iterator = iterator;
		this.predicate = predicate;
		findNextValid();
	}
	
	private void findNextValid()
	{
		while (!iterator.isDone()) 
		{
			elemNext = iterator.currentItem();
			iterator.next();
			if (predicate.accept(elemNext)) {
				return;
			}
		}
		bHasNext = false;
		elemNext = -1;
	}
	
	public boolean hasNext()
	{
		return bHasNext;
	}
	
	public int next()
	{
		int nextValue = elemNext;
		findNextValid();
		return nextValue;
	}
}


public class Lab2_zad2_b
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

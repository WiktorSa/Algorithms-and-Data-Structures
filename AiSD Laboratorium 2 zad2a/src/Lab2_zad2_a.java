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


public class Lab2_zad2_a 
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

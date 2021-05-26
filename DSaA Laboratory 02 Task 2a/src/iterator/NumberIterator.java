package iterator;

import java.util.NoSuchElementException;

public class NumberIterator 
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

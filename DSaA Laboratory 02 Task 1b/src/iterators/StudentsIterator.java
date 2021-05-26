package iterators;
import java.util.NoSuchElementException;

public class StudentsIterator<T>
{
	private T[] array;
	private int pos = 0;
	
	public StudentsIterator(T[] array)
	{
		this.array = array;
	}
	
	public void first()
	{
		pos = 0;
	}
	
	public void next() throws NoSuchElementException
	{
		if (!isDone()) {
			pos ++;
		}
		
		else {
			throw new NoSuchElementException();
		}
	}
	
	public boolean isDone()
	{
		return pos >= array.length;
	}
	
	public T currentItem()
	{
		return array[pos];
	}
}

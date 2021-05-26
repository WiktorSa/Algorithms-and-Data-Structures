package iterators;

public class FilterIterator<T>
{
	private StudentsIterator<T> iterator;
	private Predicate<T> predicate;
	
	private T elemNext = null;
	private boolean bHasNext = true;
	
	public FilterIterator(StudentsIterator<T> iterator, Predicate<T> predicate) 
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
		elemNext = null;
	}
	
	public boolean hasNext()
	{
		return bHasNext;
	}
	
	public T next()
	{
		T nextValue = elemNext;
		findNextValid();
		return nextValue;
	}
}

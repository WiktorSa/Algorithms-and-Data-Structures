package iterators;

public class FilterIterator
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

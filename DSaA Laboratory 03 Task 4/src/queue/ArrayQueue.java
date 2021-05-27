package queue;

public class ArrayQueue<T>
{
	private int beginIndex = 0; // This will never change because we always take items from the first spot
	private int endIndex = 0; // The index of last item + 1
	private int size;
	private T queue[];
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int size) 
	{
		this.size = size;
		queue = (T[])new Object[size];
	}
	
	public boolean isEmpty()
	{
		return beginIndex == endIndex;
	}
	
	public boolean isFull()
	{
		return endIndex == size;
	}
	
	public T dequeue() throws EmptyQueueException
	{
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		// Our value to be returned
		T value = queue[beginIndex];
		
		// Changing placements in queue
		for (int i=0; i+1<endIndex; i++)
		{
			queue[i] = queue[i+1];
		}
		
		endIndex --; 	
			
		return value;
	}
	
	public void enqueue(T elemT) throws FullQueueException
	{
		if (isFull()) {
			throw new FullQueueException();
		}
		
		queue[endIndex++] = elemT;
	}
	
	public int size()
	{
		return size;
	}
}

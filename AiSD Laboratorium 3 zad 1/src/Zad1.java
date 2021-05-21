@SuppressWarnings("serial")
class EmptyQueueException extends Exception
{
	
}

@SuppressWarnings("serial")
class FullQueueException extends Exception 
{

}

class ArrayQueue<T>
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
}


public class Zad1 
{

	public static void main(String[] args) 
	{
		ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>(4);
		
		// Should return error
		try 
		{
			System.out.println(arrayQueue.dequeue());
		} 
		catch (EmptyQueueException e) 
		{
			System.out.println("Blad pusta kolejka\n");
		}
		
		// Should not return an error
		try 
		{
			arrayQueue.enqueue(1);
			arrayQueue.enqueue(4);
			arrayQueue.enqueue(35);
			arrayQueue.enqueue(12);
		} 
		catch (FullQueueException e) 
		{
			System.out.println("Blad pelna kolejka\n");
		}
		
		// Should return error
		try 
		{
			arrayQueue.enqueue(1);
		} 
		catch (FullQueueException e) 
		{
			System.out.println("Blad pelna kolejka\n");
		}
		
		// Should return all elements in queue
		try 
		{
			System.out.println(arrayQueue.dequeue());
			System.out.println(arrayQueue.dequeue());
			System.out.println(arrayQueue.dequeue());
			System.out.println(arrayQueue.dequeue());
		} 
		catch (EmptyQueueException e) 
		{
			System.out.println("Blad pusta kolejka\n");
		}
		
		System.out.println();
		
		// Should return error
		try 
		{
			System.out.println(arrayQueue.dequeue());
		} 
		catch (EmptyQueueException e) 
		{
			System.out.println("Blad pusta kolejka\n");
		}
	}

}

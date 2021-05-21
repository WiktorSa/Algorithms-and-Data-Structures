@SuppressWarnings("serial")
class EmptyQueueException extends Exception
{
	
}

@SuppressWarnings("serial")
class FullQueueException extends Exception 
{

}

@SuppressWarnings("serial")
class EmptyStackException extends Exception
{

}

@SuppressWarnings("serial")
class FullStackException extends Exception
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
	
	// This function returns the current size of the queue
	public int currentSize()
	{
		return endIndex;
	}
}

class StackQueue<T>
{
	private ArrayQueue<T> mainQueue;
	private ArrayQueue<T> helperQueue;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public StackQueue(int size) 
	{
		mainQueue = new ArrayQueue(size);
		helperQueue = new ArrayQueue(size);
	}
	
	public boolean isEmpty() 
	{
		return mainQueue.isEmpty();
	}
	
	public boolean isFull() 
	{
		return mainQueue.isFull();
	}

	public T pop() throws EmptyStackException 
	{
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		
		
		// Copying values to helper queue (except the last one in queue
		int currentSizeOfQueue = mainQueue.currentSize();
		for (int i=0; i+1<currentSizeOfQueue; i++)
		{
			try 
			{
				helperQueue.enqueue(mainQueue.dequeue());
			} 
			catch (FullQueueException | EmptyQueueException e) 
			{
				System.out.println("Blad podczas przenoszenia do helper queue"); // This should never print
			}
		}
		
		T elemT = null;
		try 
		{
			elemT = mainQueue.dequeue();
		} 
		catch (EmptyQueueException e) 
		{
			System.out.println("Blad podczas wykonywania operacji dequeue"); // This should never print
		}
		
		// Copying values back to main queue
		while(!helperQueue.isEmpty())
		{
			try 
			{
				mainQueue.enqueue(helperQueue.dequeue());
			} 
			catch (FullQueueException | EmptyQueueException e) 
			{
				System.out.println("Blad podczas przenoszenia do main queue"); // This should never print
			}
		}
			
		return elemT;
	}

	public void push(T elem) throws FullStackException
	{
		if(isFull()) {
			throw new FullStackException();
		}
		
		try 
		{
			mainQueue.enqueue(elem);
		} 
		catch (FullQueueException e) 
		{
			System.out.println("Blad poczas dodawania elementu do main queue"); // This should never print
		}
	}
}

public class Zad3 
{

	public static void main(String[] args) 
	{
		StackQueue<Integer> stack = new StackQueue<Integer>(4);
		
		try
		{
			System.out.println(stack.pop());
		} 
		catch (EmptyStackException e) 
		{
			System.out.println("Pusty stos\n"); // Should print
		}
		
		try
		{
			stack.push(4);
			stack.push(35);
			stack.push(21);
			stack.push(64);
		} 
		catch (FullStackException e) 
		{
			System.out.println("Pelen stos"); // Should not print
		}

		try 
		{
			stack.push(23);
		} 
		catch (FullStackException e) 
		{
			System.out.println("Pelen stos\n"); // Should print
		}
		
		try 
		{
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
		} 
		catch (EmptyStackException e) 
		{
			System.out.println("Pusty stos\n"); // Should not print
		}
		
		System.out.println();
		
		try 
		{
			System.out.println(stack.pop());
		} 
		catch (EmptyStackException e) 
		{
			System.out.println("Pusty stos\n"); // Should print
		}
	}

}

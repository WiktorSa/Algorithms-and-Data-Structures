package stack;

import queue.ArrayQueue;
import queue.EmptyQueueException;
import queue.FullQueueException;

public class StackQueue<T>
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
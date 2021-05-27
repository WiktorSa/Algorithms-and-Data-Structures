package main;

import queue.EmptyQueueException;
import queue.FullQueueException;
import queue.ArrayQueue;

public class Main31 
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

package main;
import heap.EmptyQueueException;
import heap.HeapPriorityQueue;

public class Lab81Main 
{
	// Displaying heap so that it would be easy to see that the property of the heap are preserved
	public static void displayHeap(HeapPriorityQueue heapPriorityQueue)
	{
		// How many items to display in a row
		int sizeOfRow = 1;
		// Index of our array
		int index = 0;
		while (index < heapPriorityQueue.size())
		{
			int numberElementsDisplayed = 0;
			while (index < heapPriorityQueue.size() && numberElementsDisplayed < sizeOfRow)
			{
				try 
				{
					System.out.print(heapPriorityQueue.getIndex(index) + " ");
				} 
				catch (IndexOutOfBoundsException | EmptyQueueException e)
				{
					System.out.println("\nCritical error");
					System.exit(-1);
				}
				index++;
				numberElementsDisplayed++;
			}
			sizeOfRow *= 2;
			System.out.println();
		}
		System.out.println();
	}
	
	public static void displayHeapInRow(HeapPriorityQueue heapPriorityQueue)
	{
		for (int i=0; i<heapPriorityQueue.size(); i++)
		{
			try 
			{
				System.out.print(heapPriorityQueue.getIndex(i) + " ");
			} 
			catch (IndexOutOfBoundsException | EmptyQueueException e) 
			{
				System.out.println("\nCritical error");
				System.exit(-1);
			}
		}
	}
	
	public static void main(String[] args) 
	{
		HeapPriorityQueue heapPriorityQueue = new HeapPriorityQueue();
		heapPriorityQueue.enqueue(65);
		heapPriorityQueue.enqueue(32);
		heapPriorityQueue.enqueue(15);
		heapPriorityQueue.enqueue(76);
		heapPriorityQueue.enqueue(24);
		heapPriorityQueue.enqueue(63);
		heapPriorityQueue.enqueue(10);
		System.out.println("Showing the heap as array");
		displayHeapInRow(heapPriorityQueue);
		System.out.println("\nShowing heap in a way that shows the relation between a parent and a child");
		displayHeap(heapPriorityQueue);
		
		System.out.println("Showing the first element of the heap");
		try 
		{
			System.out.println(heapPriorityQueue.first());
		} 
		catch (EmptyQueueException e) 
		{
			System.out.println("Empty heap");
		}
		System.out.println("Showing the size of the heap");
		System.out.println(heapPriorityQueue.size() + "\n");
		
		heapPriorityQueue.enqueue(45);
		System.out.println("Showing the heap after performing enqueue(45)");
		displayHeap(heapPriorityQueue);
		
		try 
		{
			System.out.println("Dequeue operation. Showing the first value");
			System.out.println(heapPriorityQueue.dequeue());
		} 
		catch (EmptyQueueException e) 
		{
			System.out.println("Empty heap");
		}
		
		System.out.println("Showing the heap");
		displayHeap(heapPriorityQueue);
		
		try 
		{
			System.out.println("Remove element at index 3");
			System.out.println(heapPriorityQueue.removeIndex(3));
		} 
		catch (IndexOutOfBoundsException | EmptyQueueException e) 
		{
			System.out.println("Incorrect index");
		}
		
		System.out.println("Showing the heap");
		displayHeap(heapPriorityQueue);
		
		try 
		{
			System.out.println("Changing the priority of the second element to 1");
			heapPriorityQueue.changePriority(2, 1);
		} 
		catch (IndexOutOfBoundsException | EmptyQueueException e) 
		{
			System.out.println("Incorrect index");
		}
		
		displayHeap(heapPriorityQueue);
		
		heapPriorityQueue.sort();
		System.out.println("Showing array after sorting");
		displayHeapInRow(heapPriorityQueue);
	}
}

package heap;

public class HeapPriorityQueue
{
	int[] array;
	
	public HeapPriorityQueue() 
	{
		array = new int[0];
	}
	
	public void clear()
	{
		array = new int[0];
	}
	
	public int size()
	{
		return array.length;
	}
	
	public boolean isEmpty()
	{
		return array.length == 0;
	}
	
	public boolean isFull()
	{
		return false;
	}
	
	public int first() throws EmptyQueueException
	{
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		
		return array[0];
	}
	
	// Function used for testing
	// Just returns the value at the given index
	public int getIndex(int index) throws EmptyQueueException, IndexOutOfBoundsException
	{
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		
		if (index >= array.length || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		return array[index];
	}
	
	public void enqueue(int value)
	{
		add(value);
		swim(array.length - 1);
	}
	
	public int dequeue() throws EmptyQueueException
	{
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		
		int result = array[0];
		// Maintaining the property of the heap
		if (array.length > 1) {
			array[0] = array[array.length - 1];
			sink(0);
		}
		removeLastElement();
		
		return result;
	}
	
	// Logic:
	// Our element goes to the top of the heap (we change it's value to max)
	// We erase this element using dequeue
	// We return the old value
	public int removeIndex(int index) throws EmptyQueueException, IndexOutOfBoundsException
	{
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		
		if (index >= array.length || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		int result = array[index];
		array[index] = array[0] + 1;
		swim(index);
		dequeue();
		
		return result;
	}
	
	public void changePriority(int index, int newPriority) throws EmptyQueueException, IndexOutOfBoundsException
	{
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		
		if (index >= array.length || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		int oldPriority = array[index]; 
		array[index] = newPriority;
		
		// Maintaining the property of the heap
		if (newPriority > oldPriority) {
			swim(index);
		}
		else {
			sink(index);
		}
	}
	
	public void sort()
	{
		// Heap adjustment
		for (int i=(array.length-1)/2; i>=0; i--)
		{
			sink(i, array.length);
		}
		
		// Making sure that our heap is sorted
		for (int i=array.length-1; i>0; i--)
		{
			swap(i, 0);
			sink(0, i);
		}
	}
	
	// Add an element to the end of the list
	private void add(int value)
	{
		int[] copy = new int[array.length+1];
		for (int i=0; i<array.length; i++)
		{
			copy[i] = array[i];
		}
		copy[array.length] = value;
		array = copy;
	}
	
	// Erase the last element from the array
	private void removeLastElement()
	{
		int[] copy = new int[array.length-1];
		// Index of our copy array
		for (int i=0; i<array.length-1; i++)
		{
			copy[i] = array[i];
		}
		array = copy;
	}
	
	private void swap(int index1, int index2)
	{
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	// Go up
	private void swim(int index)
	{
		int parent;
		while (array[index] > array[parent = (index-1)/2])
		{
			swap(index, parent);
			index = parent;
		}
	}
	
	// Go down
	private void sink(int index)
	{
		boolean isDone = false;
		int child;
		while (!isDone && (child = 2*index+1) < array.length)
		{
			if (child < array.length-1 && array[child] < array[child+1]) {
				child++;
			}
			
			if (array[index] < array[child]) {
				swap(index, child);
				index = child;
			}
			else {
				isDone = true;
			}
			
		}
	}
	
	// Sink function used for sorting
	private void sink(int idx, int n)
	{
		int idxOfBigger = 2 * idx + 1;
		if (idxOfBigger < n) {
			if (idxOfBigger + 1 < n && array[idxOfBigger] < array[idxOfBigger+1]) {
				idxOfBigger++;
			}
			if (array[idx] < array[idxOfBigger]) {
				swap(idx, idxOfBigger);
				sink(idxOfBigger, n);
			}
		}
	}
}

package stack;

public class ArrayStack<T>
{
	private T array[];
	private int topIndex = 0;
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int maxSize) 
	{
		array = (T[])(new Object[maxSize]);
	}
	
	public boolean isEmpty() 
	{
		return topIndex == 0;
	}
	
	public boolean isFull()
	{
		return topIndex == array.length;
	}

	public T pop() throws EmptyStackException 
	{
		if(isEmpty())
			throw new EmptyStackException();
		
		return array[--topIndex];
	}

	public void push(T elem) throws FullStackException
	{
		if (isFull()) {
			throw new FullStackException();
		}
		array[topIndex++] = elem;
	}
	
	// Return the first element of the stack without removing it
	public T top() throws EmptyStackException {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return array[topIndex-1];
	}
	
	public int size()
	{
		return array.length;
	}
}

package stack;

//Note - we don't need to implement isFull method because this stack will never be full (because of resizing)
public class ArrayStack<T>
{
	private T array[];
	private int topIndex = 0;
	private int maxSize;
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int maxSize) 
	{
		this.maxSize = maxSize;
		array = (T[])(new Object[maxSize]);
	}
	
	public boolean isEmpty() 
	{
		return topIndex == 0;
	}

	@SuppressWarnings("unchecked")
	public T pop() throws EmptyStackException 
	{
		if(isEmpty())
			throw new EmptyStackException();
		
		T elemT = array[--topIndex];
		
		// If maxSize = 4 and topIndex = 1 than we only have 1 element in stack and that's why we decrease size
		// We include (double) because size may not always be divisible by 4
		if ((double)(topIndex) <= (double)(maxSize)/4) {
			int newSize = maxSize/2;
			T[] newArray = (T[])(new Object[newSize]);
			
			for (int i=0; i<topIndex; i++)
			{
				newArray[i] = array[i];
			}
			
			array = newArray;
			maxSize = newSize;
		}
		
		return elemT;
	}

	@SuppressWarnings("unchecked")
	public void push(T elem)
	{
		array[topIndex++] = elem;
		
		// If maxSize = 4 and topIndex = 3 than we have 3 elements in stack and that's why we increase size
		if ((double)(topIndex) >= (double)(3*maxSize)/4) {
			int newSize = maxSize*2;
			T[] newArray = (T[])(new Object[newSize]);
					
			for (int i=0; i<topIndex; i++)
			{
				newArray[i] = array[i];
			}
					
			array = newArray;
			maxSize = newSize;
		}
	}
	
	// Returning the max size of the stack
	public int maxSize()
	{
		return maxSize;
	}
}

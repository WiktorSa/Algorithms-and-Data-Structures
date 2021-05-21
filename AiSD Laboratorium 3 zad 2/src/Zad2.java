
@SuppressWarnings("serial")
class EmptyStackException extends Exception
{

}

// Note - we don't need to implement isFull method because this stack will never be full (because of resizing)
class ArrayStack<T>
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

public class Zad2 
{

	public static void main(String[] args) 
	{
		ArrayStack<Integer> stack = new ArrayStack<Integer>(4);
		
		// Should return error
		try 
		{
			System.out.println(stack.pop());
		} 
		catch (EmptyStackException e) 
		{
			System.out.println("Pusty stos\n");
		}
		
		// Should return 4
		System.out.println(stack.maxSize() + "\n");
		
		stack.push(1);
		stack.push(23);
		stack.push(34);
		
		// Should return 8
		System.out.println(stack.maxSize() + "\n");
		
		// Should return 34
		try 
		{
			System.out.println(stack.pop() + "\n");
		} 
		catch (EmptyStackException e) 
		{
			System.out.println("Pusty stos\n");
		}
		
		// Should return 4
		System.out.println(stack.maxSize() + "\n");
		
		// This should increase size after 15/4 = 3.75 which rounds up to 4 elements
		stack = new ArrayStack<Integer>(5);
		System.out.println(stack.maxSize() + "\n");
		stack.push(1);
		stack.push(23);
		stack.push(34);
		System.out.println(stack.maxSize() + "\n");
		stack.push(2);
		System.out.println(stack.maxSize() + "\n");

	}

}

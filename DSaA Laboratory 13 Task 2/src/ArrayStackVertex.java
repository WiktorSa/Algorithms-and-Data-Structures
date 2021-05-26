
public class ArrayStackVertex 
{
	private Vertex array[];
	private int topIndex = 0;
	private int maxSize;
	
	public ArrayStackVertex(int maxSize) 
	{
		this.maxSize = maxSize;
		array = new Vertex[maxSize];
	}
	
	public boolean isEmpty() 
	{
		return topIndex == 0;
	}
	
	public boolean isFull()
	{
		return topIndex == array.length;
	}

	public Vertex pop() throws EmptyStackException 
	{
		if(isEmpty()) {
			throw new EmptyStackException();
		}
			
		return array[--topIndex];
	}

	public void push(Vertex vertex) throws FullStackException
	{
		if (isFull()) {
			throw new FullStackException();
		}
		
		array[topIndex++] = vertex;
	}
	
	// Returning the max size of the stack
	public int maxSize()
	{
		return maxSize;
	}
	
	public void printWholeStack()
	{
		if ((isEmpty())) {
			System.out.println("Empty stack");
		}
		
		for (int i=topIndex-1; i>=0; i--)
		{
			System.out.println(array[i].toString(false));
		}
		System.out.println();
	}
	
}

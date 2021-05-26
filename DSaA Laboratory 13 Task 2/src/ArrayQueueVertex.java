
class ArrayQueueVertex
{
	private int beginIndex = 0; // This will never change because we always take items from the first spot
	private int endIndex = 0; // The index of last item + 1
	private int size;
	private Vertex queue[];
	
	public ArrayQueueVertex(int size) 
	{
		this.size = size;
		queue = new Vertex[size];
	}
	
	public boolean isEmpty()
	{
		return beginIndex == endIndex;
	}
	
	public boolean isFull()
	{
		return endIndex == size;
	}
	
	public Vertex dequeue() throws EmptyQueueException
	{
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		// Our value to be returned
		Vertex value = queue[beginIndex];
		
		// Changing placements in queue
		for (int i=0; i+1<endIndex; i++)
		{
			queue[i] = queue[i+1];
		}
		
		endIndex --; 	
			
		return value;
	}
	
	public void enqueue(Vertex vertex) throws FullQueueException
	{
		if (isFull()) {
			throw new FullQueueException();
		}
		
		queue[endIndex++] = vertex;
	}

	public Vertex first() throws EmptyQueueException
	{
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		
		return queue[0];
	}

	public void printWholeQueue()
	{
		if (isEmpty()) {
			System.out.println("Empty queue");
		}
		
		for (int i=0; i<endIndex; i++)
		{
			System.out.println(queue[i].toString(true));
		}
		System.out.println();
	}

}
package list;

public class OneWayListAsQueue<E>
{
	@SuppressWarnings("rawtypes")
	Element head;
	
	public OneWayListAsQueue() 
	{
		head = null;
	}
	
	// Add an element to the queue (this will be the last element in the list)
	@SuppressWarnings({ "rawtypes" })
	public void add(Element element)
	{
		if (head == null) {
			head = element;
			return;
		}
		
		Element tail = head;
		while (tail.getNext() != null) 
		{
			tail = tail.getNext();
		}
		tail.setNext(element);
	}
	
	// Get an element from the list-queue (this will be the first element)
	@SuppressWarnings({ "rawtypes" })
	public Element get() 
	{
		if (head == null) {
			return null;
		}
		
		Element retiringElement = head;
		head = head.getNext();
		return retiringElement;
	}

	// Return whether the list-queue is empty
	public boolean isEmpty()
	{
		return head == null;
	}

	// Reset the list-queue
	public void clear()
	{
		head = null;
	}
}

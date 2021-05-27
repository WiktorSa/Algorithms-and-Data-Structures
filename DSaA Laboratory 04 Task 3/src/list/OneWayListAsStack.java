package list;

public class OneWayListAsStack<E>
{
	@SuppressWarnings("rawtypes")
	Element head;
	
	public OneWayListAsStack() 
	{
		head = null;
	}
	
	// Add an element to the stack (this will be the last element in the list)
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
	
	// Get an element from the list-stack (this will be the last element)
	@SuppressWarnings({ "rawtypes" })
	public Element get() 
	{
		if (head == null) {
			return null;
		}
		
		if (head.getNext() == null) {
			Element retiringElement = head;
			head = null;
			return retiringElement;
		}
		
		Element secondFromLastElement = head;
		Element tail = head.getNext();
		// Doing this loop until we have two last elements in our list
		while (tail.getNext() != null)
		{
			secondFromLastElement = tail;
			tail = tail.getNext();
		}
		secondFromLastElement.setNext(null);
		return tail;
	}

	// Return whether the list-stack is empty
	public boolean isEmpty()
	{
		return head == null;
	}

	// Reset the list-stack
	public void clear()
	{
		head = null;
	}
}

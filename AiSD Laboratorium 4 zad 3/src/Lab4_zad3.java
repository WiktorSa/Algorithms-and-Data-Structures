class Element<E>
{
	private E value;
	@SuppressWarnings("rawtypes")
	private Element next;
	 
	Element(E value)
	{
		this.value = value;
		this.next = null;
	}
	
	public E getValue() 
	{
		return value;
	}
	
	public void setValue(E value) 
	{
		this.value = value;
	}
		 
	@SuppressWarnings("rawtypes")
	public Element getNext() 
	{
		return next;
	}
		 
	@SuppressWarnings("rawtypes")
	public void setNext(Element next) 
	{
		this.next = next;
	}
	
	public String toString()
	{
		return value.toString();
	}
}

class OneWayListAsQueue<E>
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

class OneWayListAsStack<E>
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

public class Lab4_zad3 
{

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) 
	{
		OneWayListAsQueue<Integer> oneWayListAsQueue = new OneWayListAsQueue();
		oneWayListAsQueue.add(new Element(13));
		oneWayListAsQueue.add(new Element(54));
		oneWayListAsQueue.add(new Element(23));
		oneWayListAsQueue.add(new Element(83));
		oneWayListAsQueue.add(new Element(65));
		
		System.out.println("Prezentacja listy jako kolejki. Powinno pojawic sie 13 54 23 83 65 a potem null");
		while(!oneWayListAsQueue.isEmpty())
		{
			System.out.println(oneWayListAsQueue.get());
		}
		System.out.println(oneWayListAsQueue.get());
		
		System.out.println();
		
		OneWayListAsStack<Integer> OneWayListAsStack = new OneWayListAsStack();
		OneWayListAsStack.add(new Element(13));
		OneWayListAsStack.add(new Element(54));
		OneWayListAsStack.add(new Element(23));
		OneWayListAsStack.add(new Element(83));
		OneWayListAsStack.add(new Element(65));
		
		System.out.println("Prezentacja listy jako stosu. Powinno pojawic sie 65 83 23 54 13 a potem null");
		while(!OneWayListAsStack.isEmpty())
		{
			System.out.println(OneWayListAsStack.get());
		}
		System.out.println(OneWayListAsStack.get());
		
		
	}

}

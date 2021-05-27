package list;

public class OneWayList<E>
{
	@SuppressWarnings("rawtypes")
	Element head;
	
	public OneWayList() 
	{
		head = null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addEnd(E e)
	{
		Element newElement = new Element(e);
		if (head == null) {
			head = newElement;
		}
		else {
			Element tail = head;
			while (tail.getNext() != null) 
			{
				tail = tail.getNext();
			}
			tail.setNext(newElement);
		}
	}
	
	// Insert somewhere in a list
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void insert(int pos, E e)
	{
		if (pos < 0) {
			System.out.println("Incorrect index");
			return;
		}
		else {
			
			Element newElement = new Element(e);
			if (pos == 0) {
				newElement.setNext(head);
				head = newElement;
			}
			
			else {
				Element actualElement = head;
				pos --; // We need to be pointing at the element before the element at the given position
				while(pos > 0 && actualElement != null)
				{
					pos--;
					actualElement=actualElement.getNext();
				}
				
				if (actualElement == null) {
					System.out.println("Incorrect index");
				}
				else {
					newElement.setNext(actualElement.getNext());
					actualElement.setNext(newElement);
				}
			}
		}
	}
	
	// Get a value of the element from the list
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public E get(int index) 
	{
		if (index < 0) {
			return null;
		}
		
		Element actualElement = head;
		
		while(index > 0 && actualElement != null)
		{
			index--;
			actualElement = actualElement.getNext();
		}
		
		if (actualElement == null) {
			return null;
		}
		else {
			return (E) actualElement.getValue();
		}
	}
	
	// Set the value of the element of the list
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public E set(int pos, E e)
	{
		if (pos < 0) {
			return null;
		}
		
		Element actualElement = head;
		
		while(pos > 0 && actualElement != null)
		{
			pos--;
			actualElement = actualElement.getNext();
		}
		
		if(actualElement==null) {
			return null;
		}
			
		E elementData = (E) actualElement.getValue();
		actualElement.setValue(e);
		return elementData;
	}

	// Check if any element contains this value
	@SuppressWarnings("rawtypes")
	public boolean contains(E e)
	{
		Element actualElement = head;
		while (actualElement != null) 
		{
			if (actualElement.getValue() == e) {
				return true;
			}
			
			actualElement = actualElement.getNext();
		}
		
		return false;
	}

	// Return the current amount of items in a list
	@SuppressWarnings("rawtypes")
	public int size()
	{
		int size = 0;
		Element actualElement = head;
		
		while (actualElement != null) 
		{
			size ++;
			actualElement = actualElement.getNext();
		}
		
		return size;
	}

	// Reset the list
	public void clear()
	{
		head = null;
	}

	// Delete an element given position
	@SuppressWarnings("rawtypes")
	public Element deletePos(int pos)
	{
		if (pos < 0) {
			return null;
		}
		
		if(head == null) {
			return null;
		}
			
		if(pos == 0){
			Element retiringElement = head;
			head = head.getNext();
			return retiringElement;
		}
		
		Element actualElement=head;
		pos --; // We need to be pointing at the element before the element at the given position
		
		while(pos > 0 && actualElement != null)
		{
			pos--;
			actualElement = actualElement.getNext();
		}
		
		if (actualElement == null || actualElement.getNext() == null) {
			return null;
		}
		
		else {
			Element retiringElement = actualElement.getNext();
			actualElement.setNext(actualElement.getNext().getNext());
			return retiringElement;
		}
	}

	// Delete an element given the value
	@SuppressWarnings("rawtypes")
	public boolean delete(E e)
	{
		Element actualElement = head;
		while (actualElement != null && actualElement.getNext() != null) 
		{
			if (actualElement.getNext().getValue() == e) {
				// Skipping the element with the value
				actualElement.setNext(actualElement.getNext().getNext());
				return true;
			}
			
			actualElement = actualElement.getNext();
		}
		
		return false;
	}

	// Delete an element given the element itself
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public E deleteEl(Element e)
	{
		Element actualElement = head;
		while (actualElement != null && actualElement.getNext() != null) 
		{
			if (actualElement.getNext().getValue() == e.getValue()) {
				// Skipping this element
				E retiringValue = (E) actualElement.getNext().getValue();
				actualElement.setNext(actualElement.getNext().getNext());
				return retiringValue;
			}
			
			actualElement = actualElement.getNext();
		}
		
		return null;
	}

	// Show the whole list
	@SuppressWarnings("rawtypes")
	public void showList()
	{
		Element actualElement = head;
		while (actualElement != null) 
		{
			System.out.println(actualElement.toString());
			actualElement = actualElement.getNext();
		}
	}
}
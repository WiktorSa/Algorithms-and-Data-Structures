package list;

public class TwoWayCycledList<E>
{
	@SuppressWarnings("rawtypes")
	Element sentinel;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TwoWayCycledList()
	{
		sentinel = new Element(null);
		sentinel.setNext(sentinel);
		sentinel.setPrev(sentinel);
	}
	
	@SuppressWarnings("rawtypes")
	public Element getSentinel()
	{
		return sentinel;
	}
	
	@SuppressWarnings("rawtypes")
	private Element getElement(int index)
	{
		Element element = sentinel.getNext();
		int counter = 0;
		while(element != sentinel && counter<index)
		{
			counter++;
			element = element.getNext();
		}
		
		if(element == sentinel) {
			throw new IndexOutOfBoundsException();
		}
			
		return element;
	}
	
	@SuppressWarnings("rawtypes")
	private Element getElement(E value)
	{
		Element element = sentinel.getNext();
		while(element != sentinel && !value.equals(element.getValue()))
		{
			element = element.getNext();
		}
		
		if(element == sentinel) {
			return null;
		}
			
		return element;
	}
	
	public boolean isEmpty()
	{
		return sentinel.getNext() == sentinel;
	}
	
	public void clear()
	{
		sentinel.setNext(sentinel);
		sentinel.setPrev(sentinel);
	}
	
	public boolean contains(E value)
	{
		return indexOf(value) != -1;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public E get(int index)
	{
		Element element = getElement(index);
		return (E) element.getValue();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public E set(int index, E value)
	{
		Element element = getElement(index);
		E retiringValue = (E) element.getValue();
		element.setValue(value);
		return retiringValue;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void add(E value)
	{
		Element newElement = new Element(value);
		sentinel.insertBefore(newElement);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void add(int index, E value)
	{
		Element newElement = new Element(value);
		if(index == 0) {
			sentinel.insertAfter(newElement);
		}
		else{
			Element element = getElement(index-1);
			element.insertAfter(newElement);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public int indexOf(E value)
	{
		Element element = sentinel.getNext();
		int counter = 0;
		while(element!=sentinel && !element.getValue().equals(value)){
			counter++;
			element = element.getNext();
		}
		
		if(element == sentinel) {
			return -1;
		}
			
		return counter;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public E remove(int index)
	{
		Element element = getElement(index);
		element.remove();
		return (E) element.getValue();
	}
	
	@SuppressWarnings("rawtypes")
	public boolean remove(E value)
	{
		Element element = getElement(value);
		if (element == null) {
			return false;
		}
		
		element.remove();
		return true;
	}
	
	@SuppressWarnings("rawtypes")
	public int size()
	{
		Element element = sentinel.getNext();
		int counter=0;
		while(element != sentinel)
		{
			counter++;
			element = element.getNext();
		}
		
		return counter;
	}
	
	// Show all values starting from beginning
	@SuppressWarnings("rawtypes")
	public void showAllValuesInListFromBeginning()
	{
		Element currentElement = sentinel.getNext();
		
		while (currentElement != sentinel)
		{
			System.out.println(currentElement.getValue());
			currentElement = currentElement.getNext();
		}
	}
	
	// Show all values starting from beginning
	@SuppressWarnings("rawtypes")
	public void showAllValuesInListFromEnd()
	{
		Element currentElement = sentinel.getPrev();
		
		while (currentElement != sentinel)
		{
			System.out.println(currentElement.getValue());
			currentElement = currentElement.getPrev();
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addAListToTheEnd(TwoWayCycledList<E> twoWayCycledList)
	{
		Element addedListSentinel = twoWayCycledList.getSentinel();
		// Function add(E value) adds a value before the sentinel so we need
		// to iterate from the beginning to mantain order
		Element currentElement = addedListSentinel.getNext();
		
		while (currentElement != addedListSentinel)
		{
			// We will need to create a new Element object to avoid any unwanted results
			this.add((E) currentElement.getValue());
			currentElement = currentElement.getNext();
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addAListAtTheGivenPosition(TwoWayCycledList<E> twoWayCycledList, int position)
	{
		Element addedListSentinel = twoWayCycledList.getSentinel();
		// We start from the end of the list because add function (int position, E value)
		// Puts values after given element so to mantain order we need to start from the end
		Element currentElement = addedListSentinel.getPrev();
		
		while (currentElement != addedListSentinel)
		{
			// We will need to create a new Element object to avoid any unwanted results
			this.add(position, (E) currentElement.getValue());
			currentElement = currentElement.getPrev();
		}
	}
}

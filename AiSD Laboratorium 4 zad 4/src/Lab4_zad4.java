
class Element<E>
{
	private E value;
	@SuppressWarnings("rawtypes")
	private Element next;
	@SuppressWarnings("rawtypes")
	private Element prev;
	
	public Element(E value)
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

	@SuppressWarnings("rawtypes")
	public Element getPrev() 
	{
		return prev;
	}

	@SuppressWarnings("rawtypes")
	public void setPrev(Element prev) 
	{
		this.prev = prev;
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
	public void insertAfter(Element element)
	{
		element.setNext(this.getNext());
		element.setPrev(this);
		this.getNext().setPrev(element);
		this.setNext(element);
	}
	
	@SuppressWarnings("rawtypes")
	public void insertBefore(Element element)
	{
		element.setNext(this);
		element.setPrev(this.getPrev());
		this.getPrev().setNext(element);
		this.setPrev(element);
	}
	
	public void remove()
	{
		this.getNext().setPrev(this.getPrev());
		this.getPrev().setNext(this.getNext());
	}
	
}

class TwoWayCycledList<E>
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

public class Lab4_zad4 
{

	public static void main(String[] args) 
	{
		TwoWayCycledList<Integer> twoWayCycledList = new TwoWayCycledList<Integer>();
		twoWayCycledList.add(1);
		twoWayCycledList.add(24);
		twoWayCycledList.add(12);
		
		System.out.println("Iteracja od poczatku listy do konca listy (powinno pojawic sie 1, 24, 12)");
		twoWayCycledList.showAllValuesInListFromBeginning();
		System.out.println();
		
		System.out.println("Iteracja od konca listy do poczatku listy (powinno pojawic sie 12, 24, 1)");
		twoWayCycledList.showAllValuesInListFromEnd();
		System.out.println();
		
		TwoWayCycledList<Integer> twoWayCycledList2 = new TwoWayCycledList<Integer>();
		twoWayCycledList2.add(4);
		twoWayCycledList2.add(28);
		twoWayCycledList2.add(423);
		
		twoWayCycledList.addAListToTheEnd(twoWayCycledList2);
		System.out.println("Dodanie listy 2 do listy 1 na koncu. Powinno sie pojawic 1, 24, 12, 4, 28, 423");
		twoWayCycledList.showAllValuesInListFromBeginning();
		
		TwoWayCycledList<Integer> twoWayCycledList3 = new TwoWayCycledList<Integer>();
		twoWayCycledList3.add(13);
		twoWayCycledList3.add(21);
		twoWayCycledList3.add(43);
		System.out.println();
		
		twoWayCycledList2.addAListAtTheGivenPosition(twoWayCycledList3, 1);
		System.out.println("Dodanie listy 3 przed elementem 28 listy 2 na koncu. Powinno sie pojawic 4, 13, 21, 43, 28, 423");
		twoWayCycledList2.showAllValuesInListFromBeginning();
	}

}

package list;

public class Element<E>
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

package list;

public class Element<E>
{
	private E value;
	@SuppressWarnings("rawtypes")
	private Element next;
	 
	public Element(E value)
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

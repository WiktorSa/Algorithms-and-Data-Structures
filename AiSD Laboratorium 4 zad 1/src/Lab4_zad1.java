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

class OneWayList<E>
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
			System.out.println("Nieprawidlowy indeks");
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
					System.out.println("Nieprawidlowy indeks");
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
			if (actualElement.getNext().equals(e)) {
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
	public void wyswietlListe()
	{
		Element actualElement = head;
		while (actualElement != null) 
		{
			System.out.println(actualElement.toString());
			actualElement = actualElement.getNext();
		}
	}
}

public class Lab4_zad1 
{

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) 
	{
		OneWayList<Integer> oneWayList = new OneWayList<Integer>();
		oneWayList.addEnd(1);
		oneWayList.addEnd(2);
		oneWayList.addEnd(3);
		
		System.out.println("Wyswietlenie listy nr 1: Powinno pokazac sie 1, 2, 3");
		oneWayList.wyswietlListe();
		System.out.println();
		
		oneWayList.insert(1, 4);
		System.out.println("Wyswietlenie listy nr 2 (dodanie 4 na pozycji 1): Powinno pokazac sie 1, 4, 2, 3");
		oneWayList.wyswietlListe();
		System.out.println();
		
		System.out.println("Zdobycie elementu z pozycji 2. Powinno pokazac sie 2");
		System.out.println(oneWayList.get(2));
		System.out.println();
		
		oneWayList.set(3, 7);
		System.out.println("Wyswietlenie listy nr 3 (zmiana wartosci na pozycji 3 na 7): Powinno pokazac sie 1, 4, 2, 7");
		oneWayList.wyswietlListe();
		System.out.println();
		
		System.out.println("Wyswietlenie czy element 2 jest w liscie a potem czy element 8 jest w lisce. Powinno pokazac sie true, false");
		System.out.println(oneWayList.contains(2));
		System.out.println(oneWayList.contains(8));
		System.out.println();
		
		System.out.println("Wyswietlnie rozmiaru listy. Powinno pokazac sie 4");
		System.out.println(oneWayList.size());
		System.out.println();
		
		oneWayList.clear();
		oneWayList.addEnd(10);
		oneWayList.addEnd(15);
		oneWayList.addEnd(14);
		oneWayList.addEnd(24);
		oneWayList.addEnd(8);
		System.out.println("Wyswietlenie listy nr 4 (wyczyszczenie i dodanie elementow). Powinno pokazac sie 10, 15, 14, 24, 8");
		oneWayList.wyswietlListe();
		System.out.println();
		
		System.out.println("Zwrocenie i kasacja elementu na pozycji 3. Powinno wyswietlic sie 24");
		System.out.println(oneWayList.deletePos(3));
		System.out.println();
		
		System.out.println("Wyswietlenie listy nr 5 (kasacja elementu na pozycji 3). Powinno pokazac sie 10, 15, 14, 8");
		oneWayList.wyswietlListe();
		System.out.println();
		
		System.out.println("Kasacja elementu o wartosci 15. Powinno wyswietlic sie true");
		System.out.println(oneWayList.delete(15));
		System.out.println();
		
		System.out.println("Wyswietlenie listy nr 6 (kasacja elementu o wartosci 15). Powinno pokazac sie 10, 14, 8");
		oneWayList.wyswietlListe();
		System.out.println();
		
		System.out.println("Kasacja elementu Element(8). Powinno wyswietlic sie 8");
		System.out.println(oneWayList.deleteEl(new Element(8)));
		System.out.println();
		
		System.out.println("Wyswietlenie listy nr 7 (kasacja elementu Element(8)). Powinno pokazac sie 10, 14");
		oneWayList.wyswietlListe();
		System.out.println();
		
		System.out.println("Testowanie skrajnych warunkow. Wynikiem powinien byc false, null albo inni odpowiedni komunikat");
		oneWayList.insert(-1, 2);
		oneWayList.insert(3, 1);
		System.out.println(oneWayList.get(-1));
		System.out.println(oneWayList.get(2));
		System.out.println(oneWayList.set(-1, 1));
		System.out.println(oneWayList.set(2, 1));
		System.out.println(oneWayList.deletePos(-1));
		System.out.println(oneWayList.deletePos(2));
		System.out.println(oneWayList.delete(1));
		System.out.println(oneWayList.deleteEl(new Element(1)));
	}

}

import java.util.ArrayList;
import java.util.Comparator;

public class CompoundComparator implements Comparator<Osoba> 
{
	private ArrayList<Comparator<Osoba>> _comparators;
	
	public CompoundComparator() 
	{
		_comparators = new ArrayList<Comparator<Osoba>>();
	}
	
	public void addComparator(Comparator<Osoba> comparator)
	{
		_comparators.add(comparator);
	}
	
	public int compare(Osoba osoba, Osoba osoba2) throws ClassCastException
	{
		int result = 0;
		for (Comparator<Osoba> comparator : _comparators)
		{
			result = comparator.compare(osoba, osoba2);
			
			if (result != 0) {
				break;
			}
		}
		
		return result;
	}
}


package comparator;
import java.util.ArrayList;
import java.util.Comparator;

import person.Person;

public class CompoundComparator implements Comparator<Person> 
{
	private ArrayList<Comparator<Person>> _comparators;
	
	public CompoundComparator() 
	{
		_comparators = new ArrayList<Comparator<Person>>();
	}
	
	public void addComparator(Comparator<Person> comparator)
	{
		_comparators.add(comparator);
	}
	
	public int compare(Person person, Person person2) throws ClassCastException
	{
		int result = 0;
		for (Comparator<Person> comparator : _comparators)
		{
			result = comparator.compare(person, person2);
			
			if (result != 0) {
				break;
			}
		}
		
		return result;
	}
}


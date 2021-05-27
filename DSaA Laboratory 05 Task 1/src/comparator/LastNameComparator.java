package comparator;
import java.util.Comparator;

import person.Person;

public class LastNameComparator implements Comparator<Person>
{
	public int compare(Person person, Person person2) 
	{
		return person.getLastName().compareTo(person2.getLastName());
	}
	
}

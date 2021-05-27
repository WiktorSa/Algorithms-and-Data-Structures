package comparator;
import java.util.Comparator;

import person.Person;

public class FirstNameComparator implements Comparator<Person>
{
	public int compare(Person person, Person person2) 
	{
		return person.getFirstName().compareTo(person2.getFirstName());
	}
	
}

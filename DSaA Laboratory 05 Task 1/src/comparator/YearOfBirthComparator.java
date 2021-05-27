package comparator;
import java.util.Comparator;

import person.Person;

public class YearOfBirthComparator implements Comparator<Person>
{
	public int compare(Person person, Person person2) 
	{
		return person.getYearOfBirth() - person2.getYearOfBirth();
	}
	
}

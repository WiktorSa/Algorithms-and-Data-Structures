package sortingAlgorithms;
import java.util.Comparator;

import person.Person;

public class InsertSort 
{
	private Comparator<Person> _comparator;
	private boolean usingComparable;
	
	public InsertSort(Comparator<Person> _comparator, boolean usingComparable) 
	{
		this._comparator = _comparator;
		this.usingComparable = usingComparable;
	}
	
	@SuppressWarnings("unused")
	public Person[] sort(Person[] people)
	{
		for (int i=1; i<people.length; i++)
		{
			Person person = people[i];
			Person tempPerson = null;
			int j = 0; 
			
			// Version one of our algorithm - using comparable
			if (usingComparable) {
				// Finding the place for our new person to fit into the already sorted part of the array
				for (j = i; j > 0 && person.compareTo(tempPerson = people[j-1]) < 0; j--)
				{
					Person swapPerson = people[j-1];
					people[j-1] = people[j];
					people[j] = swapPerson;
				}
				
				// Fitting the person in the right spot in the already sorted array
				people[j] = person;
			}
			
			// Version two of our algorithm - using comparator
			else {
				// Finding the place for our new person to fit into the already sorted part of the array
				for (j = i; j > 0 && _comparator.compare(person, tempPerson = people[j-1]) < 0; j--)
				{
					Person swapPerson = people[j-1];
					people[j-1] = people[j];
					people[j] = swapPerson;
				}
				
				// Fitting the person in the right spot in the already sorted array
				people[j] = person;
			}
		}
		
		return people;
	}
}

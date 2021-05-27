package sortingAlgorithms;
import java.util.Comparator;

import person.Person;

public class BubbleSort 
{
	private Comparator<Person> _comparator;
	private boolean usingComparable;
	
	public BubbleSort(Comparator<Person> _comparator, boolean usingComparable) 
	{
		this._comparator = _comparator;
		this.usingComparable = usingComparable;
	}
	
	public Person[] sort(Person[] people)
	{
		int size = people.length;
		for (int pass = 1; pass < size; pass++)
		{
			for (int left=0; left < (size-pass); left++)
			{
				int right = left + 1;
				
				// Version one of our algorithm - using Comparable
				if (usingComparable){
					if (people[left].compareTo(people[right]) > 0) {
						Person swapPerson = people[left];
						people[left] = people[right];
						people[right] = swapPerson;
					}
				}
				
				// Version two of our algorithm - using Comparator
				else {
					if (_comparator.compare(people[left], people[right]) > 0) {
						Person swapPerson = people[left];
						people[left] = people[right];
						people[right] = swapPerson;
					}
				}
			}
		}
		
		return people;
	}
}
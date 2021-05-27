package main;
import list.OneWayList;

public class Main42 
{
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) 
	{
		// Implementation of Josephus problem (k = 3)
		System.out.println("Josephus problem implementation for n = 41 and k = 3");
		int n = 41;
		int k = 3;
		OneWayList<Integer> oneWayList = new OneWayList();
		for (int i=1; i<=n; i++)
		{
			oneWayList.addEnd(i);
		}
		
		int positionOfEleminatedPerson = k-1; // Indexing in a list starts from 0
		while (oneWayList.size() != 1)
		{
			System.out.println(oneWayList.deletePos(positionOfEleminatedPerson).getValue());
			
			positionOfEleminatedPerson = positionOfEleminatedPerson + k - 1; // Move k positions to right (let's not forget that one person got eliminated)
			
			// We have gone out of range of people
			while (positionOfEleminatedPerson >= oneWayList.size()) 
			{
				positionOfEleminatedPerson = positionOfEleminatedPerson - oneWayList.size();
			}
		}
		System.out.println("The person that survived: " + oneWayList.deletePos(0).getValue());
		
		System.out.println();
		
		// Implementation of Josephus problem (k = 2)
		System.out.println("Josephus problem implementation for n = 41 and k = 2");
		n = 41;
		k = 2;
		oneWayList.clear();
		for (int i=1; i<=n; i++)
		{
			oneWayList.addEnd(i);
		}
		
		positionOfEleminatedPerson = k-1; // Indexing in a list starts from 0
		while (oneWayList.size() != 1)
		{
			System.out.println(oneWayList.deletePos(positionOfEleminatedPerson).getValue());
			
			positionOfEleminatedPerson = positionOfEleminatedPerson + k - 1; // Move k positions to right (let's not forget that one person got eliminated)
			
			// We have gone out of range of people
			while (positionOfEleminatedPerson >= oneWayList.size()) 
			{
				positionOfEleminatedPerson = positionOfEleminatedPerson - oneWayList.size();
			}
		}
		System.out.println("The person that survived: " + oneWayList.deletePos(0).getValue());
	}

}

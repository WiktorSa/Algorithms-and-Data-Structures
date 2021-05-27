package main;

import comparator.CompoundComparator;
import comparator.FirstNameComparator;
import comparator.LastNameComparator;
import comparator.YearOfBirthComparator;
import person.Person;
import sortingAlgorithms.BubbleSort;
import sortingAlgorithms.InsertSort;
import sortingAlgorithms.SelectSort;

public class Main51 
{	
	public static void displayData(Person[] people)
	{
		System.out.println(String.format("%-20s %-20s %-20s", "Nazwisko", "Imie", "Rok Urodzenia"));
		for (Person person : people)
		{
			System.out.println(person.toString());
		}
		// Empty Enter
		System.out.println();
	}
	
	public static void main(String[] args) 
	{
		// Declaration of our array of people
		Person[] people = new Person[5];
		people[0] = new Person("Sadowy", "Wiktor", 2001);
		people[1] = new Person("Sokolowski", "Michal", 2001);
		people[2] = new Person("Anikiej", "Antoni", 1995);
		people[3] = new Person("Kochanowski", "Mikolaj", 1992);
		people[4] = new Person("Kochanowski", "Andrzej", 2005);
		
		// Declaring Comparators
		FirstNameComparator firstNameComparator = new FirstNameComparator();
		LastNameComparator lastNameComparator = new LastNameComparator();
		YearOfBirthComparator yearOfBirthComparator = new YearOfBirthComparator();
		CompoundComparator compoundComparator = new CompoundComparator();
		compoundComparator.addComparator(lastNameComparator);
		compoundComparator.addComparator(yearOfBirthComparator);
		compoundComparator.addComparator(firstNameComparator);
		
		// Declaring sortingAlgorithms
		InsertSort insertSortUsingImieComparator = new InsertSort(firstNameComparator, false);
		InsertSort insertSortUsingNazwiskoComparator = new InsertSort(lastNameComparator, false);
		InsertSort insertSortUsingRokUrodzeniaComparator = new InsertSort(yearOfBirthComparator, false);
		InsertSort insertSortUsingCompoundComparator = new InsertSort(compoundComparator, false);
		InsertSort insertSortUsingComparable = new InsertSort(null, true);
		
		BubbleSort bubbleSortUsingImieComparator = new BubbleSort(firstNameComparator, false);
		BubbleSort bubbleSortUsingNazwiskoComparator = new BubbleSort(lastNameComparator, false);
		BubbleSort bubbleSortUsingRokUrodzeniaComparator = new BubbleSort(yearOfBirthComparator, false);
		BubbleSort bubbleSortUsingCompoundComparator = new BubbleSort(compoundComparator, false);
		BubbleSort bubbleSortUsingComparable = new BubbleSort(null, true);
		
		SelectSort selectSortUsingImieComparator = new SelectSort(firstNameComparator, false);
		SelectSort selectSortUsingNazwiskoComparator = new SelectSort(lastNameComparator, false);
		SelectSort selectSortUsingRokUrodzeniaComparator = new SelectSort(yearOfBirthComparator, false);
		SelectSort selectSortUsingCompoundComparator = new SelectSort(compoundComparator, false);
		SelectSort selectSortUsingComparable = new SelectSort(null, true);
		
		System.out.println("Unsorted list of people");
		displayData(people);
		
		System.out.println("InsertSort using firstNameComparator");
		insertSortUsingImieComparator.sort(people);
		displayData(people);
		
		System.out.println("InsertSort using lastNameComparator");
		insertSortUsingNazwiskoComparator.sort(people);
		displayData(people);
		
		System.out.println("InsertSort using yearOfBirthComparator");
		insertSortUsingRokUrodzeniaComparator.sort(people);
		displayData(people);
		
		System.out.println("InsertSort using compoundComparator");
		insertSortUsingCompoundComparator.sort(people);
		displayData(people);
		
		System.out.println("InsertSort using comparable");
		insertSortUsingComparable.sort(people);
		displayData(people);
		
		System.out.println("BubbleSort using firstNameComparator");
		bubbleSortUsingImieComparator.sort(people);
		displayData(people);
		
		System.out.println("BubbleSort using lastNameComparator");
		bubbleSortUsingNazwiskoComparator.sort(people);
		displayData(people);
		
		System.out.println("BubbleSort using yearOfBirthComparator");
		bubbleSortUsingRokUrodzeniaComparator.sort(people);
		displayData(people);
		
		System.out.println("BubbleSort using compoundComparator");
		bubbleSortUsingCompoundComparator.sort(people);
		displayData(people);
		
		System.out.println("BubbleSort using comparable");
		bubbleSortUsingComparable.sort(people);
		displayData(people);

		System.out.println("SelectSort using firstNameComparator");
		selectSortUsingImieComparator.sort(people);
		displayData(people);
		
		System.out.println("SelectSort using lastNameComparator");
		selectSortUsingNazwiskoComparator.sort(people);
		displayData(people);
		
		System.out.println("SelectSort using yearOfBirthComparator");
		selectSortUsingRokUrodzeniaComparator.sort(people);
		displayData(people);
		
		System.out.println("SelectSort using compoundComparator");
		selectSortUsingCompoundComparator.sort(people);
		displayData(people);
		
		System.out.println("SelectSort using comparable");
		selectSortUsingComparable.sort(people);
		displayData(people);
	}

}

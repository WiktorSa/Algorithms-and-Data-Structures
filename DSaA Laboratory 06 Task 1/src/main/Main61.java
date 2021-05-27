package main;
import java.util.Random;

import sortingAlgorithms.BubbleSort;
import sortingAlgorithms.InsertSort;
import sortingAlgorithms.SelectSort;
import sortingAlgorithms.SortingAlgorithm;

public class Main61 
{
	public static void displayData(int[] array)
	{
		for (int i=0; i<array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static int[] fillArrayWithRandomData(int[] array)
	{
		// Using seed to ensure the same random data
		Random random = new Random(1001);
		for (int i=0; i<array.length; i++)
		{
			array[i] = random.nextInt(100);
		}
		return array;
	}
	
	public static int[] fillArrayWithReversedData(int[] array)
	{
		int length = array.length;
		for (int i=0; i<length; i++)
		{
			array[i] = length - i;
		}
		return array;
	}
	
	public static int[] fillArrayWithSortedData(int[] array)
	{
		int length = array.length;
		for (int i=0; i<length; i++)
		{
			array[i] = i;
		}
		return array;
	}
	
	// Sorting Algorithm - any of these algorithms SelectSort, InsertSort, BubbleSort
	// typeOfData - Random, Reversed, Sorted
	public static void displayInfoAboutSorting(SortingAlgorithm sortingAlgorithm, String typeOfData)
	{
		int[] array;
		int[] sizes = new int[]{8, 32, 128, 512, 1024};
		System.out.println("Used sorting: " + sortingAlgorithm.getNameOfSortingAlgorithm());
		System.out.println("Type of data: " + typeOfData);
		System.out.println(String.format("%-20s %-20s %-20s", "Number of data", "Number of comparisions", "Number of rewrites"));
		for (int i=0; i<sizes.length; i++)
		{
			array = new int[sizes[i]];
			
			if (typeOfData.equals("Random")) {
				array = fillArrayWithRandomData(array);
			}
			
			else if (typeOfData.equals("Reversed")) {
				array = fillArrayWithReversedData(array);
			}
			
			else if (typeOfData.equals("Sorted")) {
				array = fillArrayWithSortedData(array);
			}
			
			else {
				System.out.println("Wrong type of data");
				return;
			}
			
			sortingAlgorithm.sort(array);
			System.out.println(String.format("%-20d %-20d %-20d", sizes[i], sortingAlgorithm.getNumberOfComparisions(), sortingAlgorithm.getNumberOfAssignments()));
		}
		System.out.println();
 	}
	
	public static void main(String[] args) 
	{	
		int[] array = new int[8];
		// Using interface to make displaying info about sorting easier
		SortingAlgorithm bubbleSort = new BubbleSort();
		SortingAlgorithm insertSort = new InsertSort();
		SortingAlgorithm selectSort = new SelectSort();
		
		array = fillArrayWithRandomData(array);
		System.out.println("Showing that algorithms work well");
		displayData(array);
		
		array = bubbleSort.sort(array);
		System.out.println("BubbleSort");
		displayData(array);
		
		array = fillArrayWithRandomData(array);
		array = insertSort.sort(array);
		System.out.println("InsertSort");
		displayData(array);
		
		array = fillArrayWithRandomData(array);
		array = selectSort.sort(array);
		System.out.println("SelectSort");
		displayData(array);
		
		
		System.out.println("\nShowing info about sorting\n");
		displayInfoAboutSorting(bubbleSort, "Random");
		displayInfoAboutSorting(bubbleSort, "Reversed");
		displayInfoAboutSorting(bubbleSort, "Sorted");
		displayInfoAboutSorting(insertSort, "Random");
		displayInfoAboutSorting(insertSort, "Reversed");
		displayInfoAboutSorting(insertSort, "Sorted");
		displayInfoAboutSorting(selectSort, "Random");
		displayInfoAboutSorting(selectSort, "Reversed");
		displayInfoAboutSorting(selectSort, "Sorted");
	}

}

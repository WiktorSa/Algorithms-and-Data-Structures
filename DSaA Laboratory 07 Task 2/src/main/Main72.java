package main;
import java.util.Random;

import sortingAlgorithms.HeapSort;
import sortingAlgorithms.MergeSort;
import sortingAlgorithms.QuickSort;
import sortingAlgorithms.SortingAlgorithm;

public class Main72
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
			array[i] = random.nextInt();
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
		int[] sizes = new int[]{10000, 100000, 1000000};
		System.out.println("Used sorting: " + sortingAlgorithm.getNameOfSortingAlgorithm());
		System.out.println("Type of data: " + typeOfData);
		System.out.println(String.format("%-20s %-20s", "Number of data", "Time (in nanoseconds)"));
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
			
			long start = System.nanoTime();
			sortingAlgorithm.sort(array, 0, array.length-1);
			long end = System.nanoTime();
			System.out.println(String.format("%-20d %-20d", sizes[i], (end-start)));
		}
		System.out.println();
 	}
	
	public static void main(String[] args) 
	{	
		int[] array = new int[8];
		// Using interface to make displaying info about sorting easier
		SortingAlgorithm mergeSort = new MergeSort();
		SortingAlgorithm quickSort = new QuickSort();
		SortingAlgorithm heapSort = new HeapSort();
		
		array = fillArrayWithRandomData(array);
		System.out.println("Showing that algorithms work");
		displayData(array);
		
		array = mergeSort.sort(array, 0, array.length-1);
		System.out.println("MergeSort");
		displayData(array);
		
		array = fillArrayWithRandomData(array);
		array = quickSort.sort(array, 0, array.length);
		System.out.println("QuickSort");
		displayData(array);
		
		array = fillArrayWithRandomData(array);
		array = heapSort.sort(array, 0, 0);
		System.out.println("HeapSort");
		displayData(array);
		
		System.out.println("\nDisplay info about sorting\n");
		displayInfoAboutSorting(mergeSort, "Random");
		displayInfoAboutSorting(quickSort, "Random");
		displayInfoAboutSorting(heapSort, "Random");
		displayInfoAboutSorting(mergeSort, "Reversed");
		displayInfoAboutSorting(quickSort, "Reversed");
		displayInfoAboutSorting(heapSort, "Reversed");
		displayInfoAboutSorting(mergeSort, "Sorted");
		displayInfoAboutSorting(quickSort, "Sorted");
		displayInfoAboutSorting(heapSort, "Sorted");
	}

}
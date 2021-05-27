package main;
import java.util.Random;

import heap.HeapSort;
import searchingAlgorithms.BinarySearch;
import searchingAlgorithms.LinearSearch;

public class Lab82Main 
{
	public static void displayArray(int[] array)
	{
		for (int i=0; i<array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	// This function will create random 100 arrays and perform all the needed things to gather the right statistics to analyse
	public static void performTest()
	{
		LinearSearch linearSearch = new LinearSearch();
		HeapSort heapSort = new HeapSort();
		BinarySearch binarySearch = new BinarySearch();
		System.out.println("Perform test on 100 random arrays\n");
		for (int i=0; i<100; i++)
		{
			Random random = new Random(i);
			int[] array = new int[random.nextInt(10000)];
			for (int j=0; j<array.length; j++)
			{
				array[j] = random.nextInt(3000);
			}
			
			int randomItemToSearch = random.nextInt(3000);
			
			linearSearch.search(array, randomItemToSearch);
			array = heapSort.sort(array);
			binarySearch.search(array, randomItemToSearch);
		}
		
		System.out.println("Results for linear search");
		System.out.println("No successful searches: " + linearSearch.getNoSuccessfulSearches());
		System.out.println("Average number of comparisions (successful searches): " + ((double)linearSearch.getNoSuccessfulComparisions()/linearSearch.getNoSuccessfulSearches()));
		System.out.println("No failed searches: " + linearSearch.getNoFailedSearches());
		System.out.println("Average number of comparisions (failed searches): " + ((double)linearSearch.getNoFailedComparisions()/linearSearch.getNoFailedSearches()));
		System.out.println("Average number of comparisions: " + (double)(linearSearch.getNoSuccessfulComparisions() + linearSearch.getNoFailedComparisions()) / (linearSearch.getNoSuccessfulSearches() + linearSearch.getNoFailedSearches()));
	
		System.out.println();
		
		System.out.println("Results for binary search");
		System.out.println("No successful searches: " + binarySearch.getNoSuccessfulSearches());
		System.out.println("Average number of comparisions (successful searches): " + ((double)binarySearch.getNoSuccessfulComparisions()/binarySearch.getNoSuccessfulSearches()));
		System.out.println("No failed searches: " + binarySearch.getNoFailedSearches());
		System.out.println("Average number of comparisions (failed searches): " + ((double)binarySearch.getNoFailedComparisions()/binarySearch.getNoFailedSearches()));
		System.out.println("Average number of comparisions: " + (double)(binarySearch.getNoSuccessfulComparisions() + binarySearch.getNoFailedComparisions()) / (binarySearch.getNoSuccessfulSearches() + binarySearch.getNoFailedSearches()));
	}

	public static void main(String[] args) 
	{
		int[] array = new int[] {8, 7, 4, 6, 2, 5};
		LinearSearch linearSearch = new LinearSearch();
		HeapSort heapSort = new HeapSort();
		BinarySearch binarySearch = new BinarySearch();
		
		System.out.println("Testing if linear search works");
		displayArray(array);
		int pos = linearSearch.search(array, 6);
		System.out.println("Linear search showed that 6 is on the position: " + pos);
		System.out.println("Number of comparisions: " + (linearSearch.getNoSuccessfulComparisions() + linearSearch.getNoFailedComparisions()));
		
		array = heapSort.sort(array);
		System.out.println("Array after heap sort");
		displayArray(array);
		int pos2 = binarySearch.search(array, 6);
		System.out.println("Binary search showed that 6 is on position: " + pos2);
		System.out.println("Number of comparisions: " + (binarySearch.getNoSuccessfulComparisions() + binarySearch.getNoFailedComparisions()));
		
		System.out.println("\nAfter showing that all functions work we start our experiment\n");
		performTest();
	}

}

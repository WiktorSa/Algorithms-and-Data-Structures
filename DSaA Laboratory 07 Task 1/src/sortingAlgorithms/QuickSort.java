package sortingAlgorithms;
import java.util.Random;

public class QuickSort implements SortingAlgorithm
{
	private int numberOfComparisions;
	private int numberOfAssignments;
	Random random = new Random(1001);
	
	public QuickSort() 
	{
		numberOfComparisions = 0;
		numberOfAssignments = 0;
	}
	
	public int[] sort(int[] array, int startIndex, int endIndex)
	{
		if (endIndex - startIndex > 1) {
			int partition = partition(array, startIndex, endIndex);
			sort(array, startIndex, partition );
			sort(array, partition + 1, endIndex);
			return array;
		}
		
		return array;
	}
	
	private int partition(int[] array, int nFrom, int nTo)
	{
		int rnd = nFrom + random.nextInt(nTo - nFrom);
		swap(array, nFrom, rnd);
		numberOfAssignments += 3;
		int value = array[nFrom];
		
		int idxBigger = nFrom + 1;
		int idxLower = nTo - 1;
		do 
		{
			while (idxBigger<=idxLower && array[idxBigger] <= value) 
			{
				idxBigger++;
				numberOfComparisions++;
			}
			// Comparision to exit the loop
			numberOfComparisions++;
			
			while (array[idxLower] > value) 
			{
				idxLower --;
				numberOfComparisions++;
			}
			// Comparision to exit the loop
			numberOfComparisions++;
			
			if (idxBigger < idxLower) {
				swap(array, idxBigger, idxLower);
				numberOfAssignments += 3;
			}
			
		} while (idxBigger<idxLower);
		
		swap(array,idxLower,nFrom);
		numberOfAssignments += 3;
		
		return idxLower;
	}
	
	private void swap(int[] array, int left, int right)
	{
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	// We need to reset our results in separate function
	// Because sorting function is too complex to reset it there
	public void resetData()
	{
		numberOfAssignments = 0;
		numberOfComparisions = 0;
	}

	public int getNumberOfComparisions() 
	{
		return numberOfComparisions;
	}

	public void setNumberOfComparisions(int numberOfComparisions) 
	{
		this.numberOfComparisions = numberOfComparisions;
	}

	public int getNumberOfAssignments() 
	{
		return numberOfAssignments;
	}

	public void setNumberOfAssignments(int numberOfAssignments) 
	{
		this.numberOfAssignments = numberOfAssignments;
	}
	
	public String getNameOfSortingAlgorithm()
	{
		return "QuickSort";
	}
}
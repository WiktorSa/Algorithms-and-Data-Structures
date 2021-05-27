package sortingAlgorithms;

public interface SortingAlgorithm 
{
	public int[] sort(int[] array);
	public int getNumberOfComparisions();
	public int getNumberOfAssignments();
	public String getNameOfSortingAlgorithm();
}

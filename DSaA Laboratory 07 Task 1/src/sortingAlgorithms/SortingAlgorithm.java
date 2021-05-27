package sortingAlgorithms;

public interface SortingAlgorithm 
{
	public int[] sort(int[] array, int startIndex, int endIndex);
	public int getNumberOfComparisions();
	public int getNumberOfAssignments();
	public String getNameOfSortingAlgorithm();
	public void resetData();
}

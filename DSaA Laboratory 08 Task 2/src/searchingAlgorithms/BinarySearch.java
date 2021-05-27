package searchingAlgorithms;

public class BinarySearch 
{
	private int noSuccessfulSearches;
	private int noSuccessfulComparisions;
	private int noFailedSearches;
	private int noFailedComparisions;
	
	public BinarySearch() 
	{
		noSuccessfulSearches = 0;
		noSuccessfulComparisions = 0;
		noFailedSearches = 0;
		noFailedComparisions = 0;
	}
	
	public int search(int[] array, int searchedItem)
	{
		int noOfComparisions = 0;
		
		int left = 0;
		int right = array.length - 1;
		int middle = 0;
		while (left <= right)
		{
			middle = (left + right) / 2;
			if (array[middle] == searchedItem) {
				noOfComparisions++;
				noSuccessfulSearches++;
				noSuccessfulComparisions += noOfComparisions;
				return middle;
			}
			else if(array[middle] < searchedItem) {
				left = middle + 1;
			}
			else {
				right = middle - 1;
			}
			noOfComparisions ++;
		}
		
		noFailedSearches++;
		noFailedComparisions += noOfComparisions;
		return -1;
	}
	
	public int getNoSuccessfulSearches() 
	{
		return noSuccessfulSearches;
	}

	public void setNoSuccessfulSearches(int noSuccessfulSearches) 
	{
		this.noSuccessfulSearches = noSuccessfulSearches;
	}

	public int getNoSuccessfulComparisions() 
	{
		return noSuccessfulComparisions;
	}

	public void setNoSuccessfulComparisions(int noSuccessfulComparisions) 
	{
		this.noSuccessfulComparisions = noSuccessfulComparisions;
	}

	public int getNoFailedSearches() 
	{
		return noFailedSearches;
	}

	public void setNoFailedSearches(int noFailedSearches) {
		this.noFailedSearches = noFailedSearches;
	}

	public int getNoFailedComparisions() {
		return noFailedComparisions;
	}

	public void setNoFailedComparisions(int noFailedComparisions) 
	{
		this.noFailedComparisions = noFailedComparisions;
	}

}

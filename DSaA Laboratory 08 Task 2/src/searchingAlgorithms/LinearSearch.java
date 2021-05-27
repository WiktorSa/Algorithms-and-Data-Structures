package searchingAlgorithms;

public class LinearSearch 
{
	private int noSuccessfulSearches;
	private int noSuccessfulComparisions;
	private int noFailedSearches;
	private int noFailedComparisions;
	
	public LinearSearch() 
	{
		noSuccessfulSearches = 0;
		noSuccessfulComparisions = 0;
		noFailedSearches = 0;
		noFailedComparisions = 0;
	}
	
	public int search(int[] array, int searchedItem)
	{
		int noOfComparisions = 0;
		
		int pos = 0;
		for (int number : array)
		{
			if (number == searchedItem) {
				noOfComparisions++;
				noSuccessfulSearches++;
				noSuccessfulComparisions += noOfComparisions;
				return pos;
			}
			else {
				noOfComparisions++;
				pos++;
			}
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

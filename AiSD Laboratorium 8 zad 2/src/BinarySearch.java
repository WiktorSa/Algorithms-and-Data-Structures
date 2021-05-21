
public class BinarySearch 
{
	private int liczbaWyszukanTrafionych;
	private int wyszukaniaTrafioneLiczbaPorownan;
	private int liczbaWyszukanChybionych;
	private int wyszukaniaChybioneLiczbaPorownan;
	
	public BinarySearch() 
	{
		liczbaWyszukanTrafionych = 0;
		wyszukaniaTrafioneLiczbaPorownan = 0;
		liczbaWyszukanChybionych = 0;
		wyszukaniaChybioneLiczbaPorownan = 0;
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
				liczbaWyszukanTrafionych++;
				wyszukaniaTrafioneLiczbaPorownan += noOfComparisions;
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
		
		liczbaWyszukanChybionych++;
		wyszukaniaChybioneLiczbaPorownan += noOfComparisions;
		return -1;
	}

	public int getLiczbaWyszukanTrafionych() {
		return liczbaWyszukanTrafionych;
	}

	public void setLiczbaWyszukanTrafionych(int liczbaWyszukanTrafionych) {
		this.liczbaWyszukanTrafionych = liczbaWyszukanTrafionych;
	}

	public int getWyszukaniaTrafioneLiczbaPorownan() {
		return wyszukaniaTrafioneLiczbaPorownan;
	}

	public void setWyszukaniaTrafioneLiczbaPorownan(int wyszukaniaTrafioneLiczbaPorownan) {
		this.wyszukaniaTrafioneLiczbaPorownan = wyszukaniaTrafioneLiczbaPorownan;
	}

	public int getLiczbaWyszukanChybionych() {
		return liczbaWyszukanChybionych;
	}

	public void setLiczbaWyszukanChybionych(int liczbaWyszukanChybionych) {
		this.liczbaWyszukanChybionych = liczbaWyszukanChybionych;
	}

	public int getWyszukaniaChybioneLiczbaPorownan() {
		return wyszukaniaChybioneLiczbaPorownan;
	}

	public void setWyszukaniaChybioneLiczbaPorownan(int wyszukaniaChybioneLiczbaPorownan) {
		this.wyszukaniaChybioneLiczbaPorownan = wyszukaniaChybioneLiczbaPorownan;
	}
}


public class LinearSearch 
{
	private int liczbaWyszukanTrafionych;
	private int wyszukaniaTrafioneLiczbaPorownan;
	private int liczbaWyszukanChybionych;
	private int wyszukaniaChybioneLiczbaPorownan;
	
	public LinearSearch() 
	{
		liczbaWyszukanTrafionych = 0;
		wyszukaniaTrafioneLiczbaPorownan = 0;
		liczbaWyszukanChybionych = 0;
		wyszukaniaChybioneLiczbaPorownan = 0;
	}
	
	public int search(int[] array, int searchedItem)
	{
		int noOfComparisions = 0;
		
		int pos = 0;
		for (int number : array)
		{
			if (number == searchedItem) {
				noOfComparisions++;
				liczbaWyszukanTrafionych++;
				wyszukaniaTrafioneLiczbaPorownan += noOfComparisions;
				return pos;
			}
			else {
				noOfComparisions++;
				pos++;
			}
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

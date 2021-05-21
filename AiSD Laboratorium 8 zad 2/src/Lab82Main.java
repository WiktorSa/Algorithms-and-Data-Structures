import java.util.Random;

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
	public static void test()
	{
		LinearSearch linearSearch = new LinearSearch();
		HeapSort heapSort = new HeapSort();
		BinarySearch binarySearch = new BinarySearch();
		System.out.println("Przeprowadzenie testu na 100 losowych tablicach\n");
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
		
		System.out.println("Wyniki dla wyszukiwania liniowego");
		System.out.println("Liczba wyszukan trafionych: " + linearSearch.getLiczbaWyszukanTrafionych());
		System.out.println("Srednia liczba porownan (wyszukania trafione): " + ((double)linearSearch.getWyszukaniaTrafioneLiczbaPorownan()/linearSearch.getLiczbaWyszukanTrafionych()));
		System.out.println("Liczba wyszukan chybionych: " + linearSearch.getLiczbaWyszukanChybionych());
		System.out.println("Srednia liczba porownan (wyszukania chybione): " + ((double)linearSearch.getWyszukaniaChybioneLiczbaPorownan()/linearSearch.getLiczbaWyszukanChybionych()));
		System.out.println("Srednia liczba porownan: " + (double)(linearSearch.getWyszukaniaTrafioneLiczbaPorownan() + linearSearch.getWyszukaniaChybioneLiczbaPorownan()) / (linearSearch.getLiczbaWyszukanTrafionych() + linearSearch.getLiczbaWyszukanChybionych()));
	
		System.out.println();
		
		System.out.println("Wyniki dla wyszukiwania binarnego na posortowanej tablicy");
		System.out.println("Liczba wyszukan trafionych: " + binarySearch.getLiczbaWyszukanTrafionych());
		System.out.println("Srednia liczba porownan (wyszukania trafione): " + ((double)binarySearch.getWyszukaniaTrafioneLiczbaPorownan()/binarySearch.getLiczbaWyszukanTrafionych()));
		System.out.println("Liczba wyszukan chybionych: " + binarySearch.getLiczbaWyszukanChybionych());
		System.out.println("Srednia liczba porownan (wyszukania chybione): " + ((double)binarySearch.getWyszukaniaChybioneLiczbaPorownan()/binarySearch.getLiczbaWyszukanChybionych()));
		System.out.println("Srednia liczba porownan: " + (double)(binarySearch.getWyszukaniaTrafioneLiczbaPorownan() + binarySearch.getWyszukaniaChybioneLiczbaPorownan()) / (binarySearch.getLiczbaWyszukanTrafionych() + binarySearch.getLiczbaWyszukanChybionych()));
	}

	public static void main(String[] args) 
	{
		int[] array = new int[] {8, 7, 4, 6, 2, 5};
		LinearSearch linearSearch = new LinearSearch();
		HeapSort heapSort = new HeapSort();
		BinarySearch binarySearch = new BinarySearch();
		
		System.out.println("Testowanie poprawnego dzialania funkcji na 6 elementowej tablicy");
		displayArray(array);
		int pos = linearSearch.search(array, 6);
		System.out.println("Wyszukiwanie liniowe pokazalo, ze liczba 6 jest na pozycji: " + pos);
		System.out.println("Laczna liczba porownan: " + (linearSearch.getWyszukaniaTrafioneLiczbaPorownan() + linearSearch.getWyszukaniaChybioneLiczbaPorownan()));
		
		array = heapSort.sort(array);
		System.out.println("Tablica po posortowaniu HeapSort");
		displayArray(array);
		int pos2 = binarySearch.search(array, 6);
		System.out.println("Wyszukiwanie binarne na posortowanej tablicy pokazalo, ze liczba 6 jest na pozycji: " + pos2);
		System.out.println("Laczna liczba porownan: " + (binarySearch.getWyszukaniaTrafioneLiczbaPorownan() + binarySearch.getWyszukaniaChybioneLiczbaPorownan()));
		
		System.out.println("\nPo upewnieniu sie, ze wszystkie funkcje dobrze dzialaja rozpoczynamy test\n");
		test();
	}

}

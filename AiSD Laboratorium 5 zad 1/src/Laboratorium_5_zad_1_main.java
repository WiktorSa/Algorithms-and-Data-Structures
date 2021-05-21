public class Laboratorium_5_zad_1_main 
{	
	public static void displayData(Osoba[] osoby)
	{
		System.out.println(String.format("%-20s %-20s %-20s", "Nazwisko", "Imie", "Rok Urodzenia"));
		for (Osoba osoba : osoby)
		{
			System.out.println(osoba.toString());
		}
		// Empty Enter
		System.out.println();
	}
	
	public static void main(String[] args) 
	{
		// Declaration of our array of people
		Osoba[] osoby = new Osoba[5];
		osoby[0] = new Osoba("Sadowy", "Wiktor", 2001);
		osoby[1] = new Osoba("Sokolowski", "Michal", 2001);
		osoby[2] = new Osoba("Anikiej", "Antoni", 1995);
		osoby[3] = new Osoba("Kochanowski", "Mikolaj", 1992);
		osoby[4] = new Osoba("Kochanowski", "Andrzej", 2005);
		
		// Declaring Comparators
		ImieComparator imieComparator = new ImieComparator();
		NazwiskoComparator nazwiskoComparator = new NazwiskoComparator();
		RokUrodzeniaComparator rokUrodzeniaComparator = new RokUrodzeniaComparator();
		CompoundComparator compoundComparator = new CompoundComparator();
		compoundComparator.addComparator(nazwiskoComparator);
		compoundComparator.addComparator(rokUrodzeniaComparator);
		compoundComparator.addComparator(imieComparator);
		
		// Declaring sortingAlgorithms
		InsertSort insertSortUsingImieComparator = new InsertSort(imieComparator, false);
		InsertSort insertSortUsingNazwiskoComparator = new InsertSort(nazwiskoComparator, false);
		InsertSort insertSortUsingRokUrodzeniaComparator = new InsertSort(rokUrodzeniaComparator, false);
		InsertSort insertSortUsingCompoundComparator = new InsertSort(compoundComparator, false);
		InsertSort insertSortUsingComparable = new InsertSort(null, true);
		
		BubbleSort bubbleSortUsingImieComparator = new BubbleSort(imieComparator, false);
		BubbleSort bubbleSortUsingNazwiskoComparator = new BubbleSort(nazwiskoComparator, false);
		BubbleSort bubbleSortUsingRokUrodzeniaComparator = new BubbleSort(rokUrodzeniaComparator, false);
		BubbleSort bubbleSortUsingCompoundComparator = new BubbleSort(compoundComparator, false);
		BubbleSort bubbleSortUsingComparable = new BubbleSort(null, true);
		
		SelectSort selectSortUsingImieComparator = new SelectSort(imieComparator, false);
		SelectSort selectSortUsingNazwiskoComparator = new SelectSort(nazwiskoComparator, false);
		SelectSort selectSortUsingRokUrodzeniaComparator = new SelectSort(rokUrodzeniaComparator, false);
		SelectSort selectSortUsingCompoundComparator = new SelectSort(compoundComparator, false);
		SelectSort selectSortUsingComparable = new SelectSort(null, true);
		
		System.out.println("Nieposortowana lista osob");
		displayData(osoby);
		
		System.out.println("InsertSort za pomoca ImieComparator. Osoby beda posortowane po imieniu");
		insertSortUsingImieComparator.sort(osoby);
		displayData(osoby);
		
		System.out.println("InsertSort za pomoca NazwiskoComparator. Osoby beda posortowane po nazwisku");
		insertSortUsingNazwiskoComparator.sort(osoby);
		displayData(osoby);
		
		System.out.println("InsertSort za pomoca RokUrodzeniaComparator. Osoby beda posortowane po roku urodzenia");
		insertSortUsingRokUrodzeniaComparator.sort(osoby);
		displayData(osoby);
		
		System.out.println("InsertSort za pomoca CompoundComparator. Osoby beda posortowane po nazwisku, roku urodzenia, imieniu");
		insertSortUsingCompoundComparator.sort(osoby);
		displayData(osoby);
		
		System.out.println("InsertSort za pomoca Comparable. Osoby beda posortowane po nazwisku, imieniu, roku urodzenia");
		insertSortUsingComparable.sort(osoby);
		displayData(osoby);
		
		System.out.println("BubbleSort za pomoca ImieComparator. Osoby beda posortowane po imieniu");
		bubbleSortUsingImieComparator.sort(osoby);
		displayData(osoby);
		
		System.out.println("BubbleSort za pomoca NazwiskoComparator. Osoby beda posortowane po nazwisku");
		bubbleSortUsingNazwiskoComparator.sort(osoby);
		displayData(osoby);
		
		System.out.println("BubbleSort za pomoca RokUrodzeniaComparator. Osoby beda posortowane po roku urodzenia");
		bubbleSortUsingRokUrodzeniaComparator.sort(osoby);
		displayData(osoby);
		
		System.out.println("BubbleSort za pomoca CompoundComparator. Osoby beda posortowane po nazwisku, roku urodzenia, imieniu");
		bubbleSortUsingCompoundComparator.sort(osoby);
		displayData(osoby);
		
		System.out.println("BubbleSort za pomoca Comparable. Osoby beda posortowane po nazwisku, imieniu, roku urodzenia");
		bubbleSortUsingComparable.sort(osoby);
		displayData(osoby);

		System.out.println("SelectSort za pomoca ImieComparator. Osoby beda posortowane po imieniu");
		selectSortUsingImieComparator.sort(osoby);
		displayData(osoby);
		
		System.out.println("SelectSort za pomoca NazwiskoComparator. Osoby beda posortowane po nazwisku");
		selectSortUsingNazwiskoComparator.sort(osoby);
		displayData(osoby);
		
		System.out.println("SelectSort za pomoca RokUrodzeniaComparator. Osoby beda posortowane po roku urodzenia");
		selectSortUsingRokUrodzeniaComparator.sort(osoby);
		displayData(osoby);
		
		System.out.println("SelectSort za pomoca CompoundComparator. Osoby beda posortowane po nazwisku, roku urodzenia, imieniu");
		selectSortUsingCompoundComparator.sort(osoby);
		displayData(osoby);
		
		System.out.println("SelectSort za pomoca Comparable. Osoby beda posortowane po nazwisku, imieniu, roku urodzenia");
		selectSortUsingComparable.sort(osoby);
		displayData(osoby);
	}

}

import java.util.Comparator;

// Sortowanie przez wybor
public class SelectSort 
{
	private Comparator<Osoba> _comparator;
	private boolean usingComparable;
	
	public SelectSort(Comparator<Osoba> _comparator, boolean usingComparable) 
	{
		this._comparator = _comparator;
		this.usingComparable = usingComparable;
	}
	
	public Osoba[] sort(Osoba[] osoby)
	{
		int n = osoby.length;
		  
        // Our goal is to find the minimum element of the array and move it to the front of 
        for (int i = 0; i < n-1; i++)
        {
        	// Assuming the minimal value is on ths index
        	// If we find another value that is smaller than on this index we will change the index
            int minimalIndex = i;
            for (int j = i+1; j < n; j++)
            {
            	// Version one of our algorithm - using Comparable
            	if (usingComparable) {
            		if (osoby[j].compareTo(osoby[minimalIndex]) < 0) {
            			minimalIndex = j;
            		}
            	}
            	
            	// Version two of our algorithm - using Comparator
            	else {
            		if (_comparator.compare(osoby[j], osoby[minimalIndex]) < 0) {
            			minimalIndex = j;
            		}
				}
            }
  
            // Swapping the minimal element with the first element of unsorted part of the array
            Osoba swapOsoba = osoby[minimalIndex];
            osoby[minimalIndex] = osoby[i];
            osoby[i] = swapOsoba;
        }
		
		return osoby;
	}
}

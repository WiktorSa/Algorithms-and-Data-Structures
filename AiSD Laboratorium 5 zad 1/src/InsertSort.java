import java.util.Comparator;

// Sortowanie przez wstawianie
public class InsertSort 
{
	private Comparator<Osoba> _comparator;
	private boolean usingComparable;
	
	public InsertSort(Comparator<Osoba> _comparator, boolean usingComparable) 
	{
		this._comparator = _comparator;
		this.usingComparable = usingComparable;
	}
	
	@SuppressWarnings("unused")
	public Osoba[] sort(Osoba[] osoby)
	{
		for (int i=1; i<osoby.length; i++)
		{
			Osoba osoba = osoby[i];
			Osoba tempOsoba = null;
			int j = 0; 
			
			// Version one of our algorithm - using comparable
			if (usingComparable) {
				// Finding the place for our new person to fit into the already sorted part of the array
				for (j = i; j > 0 && osoba.compareTo(tempOsoba = osoby[j-1]) < 0; j--)
				{
					Osoba swapOsoba = osoby[j-1];
					osoby[j-1] = osoby[j];
					osoby[j] = swapOsoba;
				}
				
				// Fitting the person in the right spot in the already sorted array
				osoby[j] = osoba;
			}
			
			// Version two of our algorithm - using comparator
			else {
				// Finding the place for our new person to fit into the already sorted part of the array
				for (j = i; j > 0 && _comparator.compare(osoba, tempOsoba = osoby[j-1]) < 0; j--)
				{
					Osoba swapOsoba = osoby[j-1];
					osoby[j-1] = osoby[j];
					osoby[j] = swapOsoba;
				}
				
				// Fitting the person in the right spot in the already sorted array
				osoby[j] = osoba;
			}
		}
		
		return osoby;
	}
}

import java.util.Comparator;

// Sortowanie babelkowe
public class BubbleSort 
{
	private Comparator<Osoba> _comparator;
	private boolean usingComparable;
	
	public BubbleSort(Comparator<Osoba> _comparator, boolean usingComparable) 
	{
		this._comparator = _comparator;
		this.usingComparable = usingComparable;
	}
	
	public Osoba[] sort(Osoba[] osoby)
	{
		int size = osoby.length;
		for (int pass = 1; pass < size; pass++)
		{
			for (int left=0; left < (size-pass); left++)
			{
				int right = left + 1;
				
				// Version one of our algorithm - using Comparable
				if (usingComparable){
					if (osoby[left].compareTo(osoby[right]) > 0) {
						Osoba swapOsoba = osoby[left];
						osoby[left] = osoby[right];
						osoby[right] = swapOsoba;
					}
				}
				
				// Version two of our algorithm - using Comparator
				else {
					if (_comparator.compare(osoby[left], osoby[right]) > 0) {
						Osoba swapOsoba = osoby[left];
						osoby[left] = osoby[right];
						osoby[right] = swapOsoba;
					}
				}
			}
		}
		
		return osoby;
	}
}
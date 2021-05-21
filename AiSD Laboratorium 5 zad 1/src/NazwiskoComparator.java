import java.util.Comparator;

public class NazwiskoComparator implements Comparator<Osoba>
{
	public int compare(Osoba osoba, Osoba osoba2) 
	{
		return osoba.getNazwisko().compareTo(osoba2.getNazwisko());
	}
	
}

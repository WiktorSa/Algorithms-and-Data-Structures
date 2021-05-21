import java.util.Comparator;

public class ImieComparator implements Comparator<Osoba>
{
	public int compare(Osoba osoba, Osoba osoba2) 
	{
		return osoba.getImie().compareTo(osoba2.getImie());
	}
	
}

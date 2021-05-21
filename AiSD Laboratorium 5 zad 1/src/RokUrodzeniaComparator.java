import java.util.Comparator;

public class RokUrodzeniaComparator implements Comparator<Osoba>
{
	public int compare(Osoba osoba, Osoba osoba2) 
	{
		return osoba.getRokUrodzenia() - osoba2.getRokUrodzenia();
	}
	
}

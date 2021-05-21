public class Osoba implements Comparable<Osoba>
{
	private String nazwisko;
	private String imie;
	private int rokUrodzenia;
	
	public Osoba(String nazwisko, String imie, int rokUrodzenia) 
	{
		this.nazwisko = nazwisko;
		this.imie = imie;
		this.rokUrodzenia = rokUrodzenia;
	}

	public String getNazwisko() 
	{
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) 
	{
		this.nazwisko = nazwisko;
	}

	public String getImie() 
	{
		return imie;
	}

	public void setImie(String imie) 
	{
		this.imie = imie;
	}

	public int getRokUrodzenia() 
	{
		return rokUrodzenia;
	}

	public void setRokUrodzenia(int rokUrodzenia) 
	{
		this.rokUrodzenia = rokUrodzenia;
	}
	
	public String toString() 
	{
		return String.format("%-20s %-20s %4d", nazwisko, imie, rokUrodzenia);
	}

	@Override
	public int compareTo(Osoba osoba) 
	{
		int result = nazwisko.compareTo(osoba.getNazwisko());
		if (result == 0) {
			result = imie.compareTo(osoba.getImie());
			if (result == 0) {
				result = rokUrodzenia - osoba.getRokUrodzenia();
			}
		}
		// TODO Auto-generated method stub
		return result;
	}
}

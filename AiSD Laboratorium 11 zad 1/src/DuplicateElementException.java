// Exception, ktore wygeneruje sie gdy klucze beda sie powtarzaly w drzewie
@SuppressWarnings("serial")
public class DuplicateElementException extends Throwable
{
	int key;
	
	public DuplicateElementException(int key)
	{
		this.key = key;
	}
	
	public String toString()
	{
		return "Ten klucz juz sie pojawil: " + key;
	}
}
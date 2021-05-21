public class DoubleHash 
{
	private Integer[] array = new Integer[1000];
	private int noElements = 0;
	private int noSuccesses = 0;
	private int noTriesSuccess = 0;
	private int noFails = 0;
	private int noTriesFail = 0;
	
	public DoubleHash() 
	{
	}
	
	// Zakladam, ze value = key dla uproszczenia
	public Integer get(int key)
	{
		int noTries = 0;
		
		int hash = generateHash(key);
		int secondHash = generateSecondHash(key);
		int i = 0;
		
		while (array[hash] != null)
		{
			if (array[hash] == key) {
				noTries++;
				noTriesSuccess += noTries;
				noSuccesses++;
				return array[hash];
			}
			
			noTries++;
			
			hash = (hash + i * secondHash) % array.length;
			i++;
		}
		
		noTriesFail += noTries;
		noFails++;
		
		return null;
	}
	
	// Zakladam, ze value = key dla uproszczenia
	public void put(int key)
	{
		int hash = generateHash(key);
		int secondHash = generateSecondHash(key);
		int i = 0;
		
		// Jezeli cos juz jest na danej pozycji to idziemy dalej
		while (array[hash] != null)
		{
			hash = (hash + i * secondHash) % array.length;
			i++;
		}
		
		array[hash] = key;
		noElements++;
	}
	
	// Zakladam, ze value = key dla uproszczenia
	public boolean containsKey(int key)
	{
		int noTries = 0;
		
		int hash = generateHash(key);
		int secondHash = generateSecondHash(key);
		int i = 0;
		
		while (array[hash] != null)
		{
			if (array[hash] == key) {
				noTries++;
				noTriesSuccess += noTries;
				noSuccesses++;
				return true;
			}
			
			noTries++;
			
			hash = (hash + i * secondHash) % array.length;
			i++;
		}
		
		noTriesFail += noTries;
		noFails++;
		
		return false;
	}
	
	public int size()
	{
		return array.length;
	}
	
	public boolean isEmpty()
	{
		return noElements == 0;
	}
	
	private int generateHash(int key)
	{
		return key % array.length;
	}
	
	private int generateSecondHash(int key)
	{
		return 7 - (key % 7);
	}
	
	public void dump()
	{
		for (int i=0; i<array.length; i++)
		{
			if (i % 10 == 0 && i != 0) {
				System.out.println();
			}
			
			String value;
			if (array[i] == null) {
				value = null;
			}
			else {
				value = array[i].toString();
			}
			
			System.out.print(String.format("%-6s", value));
		}
	}
	
	public double getAverageNoTriesSuccess()
	{
		return (double)(noTriesSuccess) / noSuccesses;
	}
	
	public double getAverageNoTriesFail()
	{
		return (double)(noTriesFail) / noFails;
	}
	
	public double getAverageNoTries()
	{
		return (double)(noTriesSuccess + noTriesFail) / (noSuccesses + noFails);
	}

	public void resetResults()
	{
		noSuccesses = 0;
		noTriesSuccess = 0;
		noFails = 0;
		noTriesFail = 0;
	}
}
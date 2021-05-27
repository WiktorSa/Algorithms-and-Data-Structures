package hash;

public abstract class Hash 
{
	private Integer[] array = new Integer[1000];
	private int noElements = 0;
	private int noSuccesses = 0;
	private int noTriesSuccess = 0;
	private int noFails = 0;
	private int noTriesFail = 0;
	
	public Integer get(int key)
	{
		int noTries = 0;
		int hash = generateHash(key);
		
		while (array[hash] != null)
		{
			if (array[hash] == key) {
				noTries++;
				noTriesSuccess += noTries;
				noSuccesses++;
				resetOffset();
				return array[hash];
			}
			
			noTries++;
			
			// Insuring that our hash will always be positive
			hash = generateOffset(key, array.length);
		}
		
		noTriesFail += noTries;
		noFails++;
		resetOffset();
		return null;
	}
	
	public void put(int key)
	{
		int hash = generateHash(key);
		
		// Using offset here
		while (array[hash] != null)
		{
			hash = (hash + 1) % array.length;
		}
		
		array[hash] = key;
		noElements++;
	}
	
	public boolean containsKey(int key)
	{
		int hash = generateHash(key);
		
		while (array[hash] != null)
		{
			if (array[hash] == key) {
				resetOffset();
				return true;
			}
			
			// Insuring that our hash will always be positive
			hash = generateOffset(key, array.length);
		}
		
		resetOffset();
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
	
	protected int generateHash(int key)
	{
		return key % array.length;
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
	
	protected abstract int generateOffset(int key, int arrayLength);
	protected abstract void resetOffset();
}

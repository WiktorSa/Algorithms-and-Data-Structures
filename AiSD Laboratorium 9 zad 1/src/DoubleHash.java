public class DoubleHash 
{
	private Integer[] array = new Integer[10];
	private int noElements = 0;
	
	public DoubleHash() 
	{
	}
	
	// Zakladam, ze value = key dla uproszczenia
	public Integer get(int key)
	{
		int hash = generateHash(key);
		int secondHash = generateSecondHash(key);
		int i = 0;
		
		while (array[hash] != null)
		{
			if (array[hash] == key) {
				return array[hash];
			}
			
			hash = (hash + i * secondHash) % array.length;
			i++;
		}
		
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
		resize();
	}
	
	// Zakladam, ze value = key dla uproszczenia
	public boolean containsKey(int key)
	{
		int hash = generateHash(key);
		int secondHash = generateSecondHash(key);
		int i = 0;
		
		while (array[hash] != null)
		{
			if (array[hash] == key) {
				return true;
			}
			
			hash = (hash + i * secondHash) % array.length;
			i++;
		}
		
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
	
	private void resize()
	{
		if (array.length * 0.7 < noElements) {
			Integer[] temp = array;
			array = new Integer[temp.length * 2];
			
			for (int i = 0; i < temp.length; i++) 
			{
				if (temp[i] != null) {
					put(temp[i]);
					noElements--;
				}
			}
			
		}
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
}

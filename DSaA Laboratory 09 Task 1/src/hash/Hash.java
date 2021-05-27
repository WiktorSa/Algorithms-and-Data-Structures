package hash;

public abstract class Hash 
{
	private Integer[] array = new Integer[10];
	private int noElements = 0;
	
	public Integer get(int key)
	{
		int hash = generateHash(key);
		
		while (array[hash] != null)
		{
			if (array[hash] == key) {
				resetOffset();
				return array[hash];
			}
			
			// Insuring that our hash will always be positive
			hash = generateOffset(key, array.length);
		}
		
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
		resize();
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

	protected abstract int generateOffset(int key, int arrayLength);
	protected abstract void resetOffset();
}

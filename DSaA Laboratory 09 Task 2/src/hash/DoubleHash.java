package hash;

public class DoubleHash extends Hash
{
	private int i = 0;
	
	public DoubleHash() 
	{
		super();
	}

	@Override
	protected int generateOffset(int key, int arrayLength) 
	{
		return Math.floorMod(generateHash(key) + ++i * generateSecondHash(key), arrayLength);
	}
	
	private int generateSecondHash(int key)
	{
		return 7 - (key % 7);
	}

	@Override
	protected void resetOffset() 
	{
		i = 0;
	}
}

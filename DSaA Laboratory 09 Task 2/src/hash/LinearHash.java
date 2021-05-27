package hash;
public class LinearHash extends Hash
{
	private int i = 0;
	
	public LinearHash() 
	{
		super();
	}

	@Override
	protected int generateOffset(int key, int arrayLength) 
	{
		return Math.floorMod(generateHash(key) + ++i, arrayLength);
	}

	@Override
	protected void resetOffset() 
	{
		i = 0;
	}
	
}

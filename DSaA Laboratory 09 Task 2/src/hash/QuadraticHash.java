package hash;

public class QuadraticHash extends Hash
{
	int i = 0;
	int sign = 1;
	
	public QuadraticHash()
	{
		super();
	}

	@Override
	protected int generateOffset(int key, int arrayLength) 
	{
		if (sign == 1) {
			i++;
		}
		
		int offset = i * i * sign;
		sign *= -1;
		
		return Math.floorMod(generateHash(key) + offset, arrayLength);
	}

	@Override
	protected void resetOffset() 
	{
		i = 0;
		sign = 1;
	}
}

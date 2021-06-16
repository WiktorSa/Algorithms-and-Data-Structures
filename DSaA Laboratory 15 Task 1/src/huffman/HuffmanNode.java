package huffman;

public class HuffmanNode 
{
	private Character character = Character.MIN_VALUE;
	private Integer frequency = null;
	private HuffmanNode left = null;
	private HuffmanNode right = null;

	public HuffmanNode(Character character, Integer frequency) 
	{
		this.character = character;
		this.frequency = frequency;
	}
	
	public HuffmanNode(Character character, Integer frequency, HuffmanNode left, HuffmanNode right)
	{
		this.character = character;
		this.frequency = frequency;
		this.left = left;
		this.right = right;
	}
	
	public Integer getFrequency() 
	{
		return frequency;
	}

	public void setFrequency(Integer frequency) 
	{
		this.frequency = frequency;
	}

	public Character getCharacter() 
	{
		return character;
	}
	
	public void setCharacter(char character) 
	{
		this.character = character;
	}
	
	public HuffmanNode getLeft() 
	{
		return left;
	}
	
	public void setLeft(HuffmanNode left) 
	{
		this.left = left;
	}
	
	public HuffmanNode getRight() 
	{
		return right;
	}
	
	public void setRight(HuffmanNode right) 
	{
		this.right = right;
	}
	
}


public class Node 
{
	private int value;
	private Node parent;
	private int rank = 0;
	
	public Node(int value) 
	{
		this.value = value;
		parent = this;
	}

	public int getValue() 
	{
		return value;
	}

	public void setValue(int value) 
	{
		this.value = value;
	}

	public Node getParent() 
	{
		return parent;
	}

	public void setParent(Node parent) 
	{
		this.parent = parent;
	}

	
	public int getRank() 
	{
		return rank;
	}
	

	public void setRank(int rank) 
	{
		this.rank = rank;
	}
}

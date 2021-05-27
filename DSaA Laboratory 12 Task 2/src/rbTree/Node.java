package rbTree;
public class Node 
{
	private Node left;
    private Node right;
    private int key;
    private String color;

    // The color of the node is by default red
    public Node(int key, String color) 
    {
    	this.left = null;
    	this.right = null;
        this.key = key;
        this.color = color;
    }

    public Node(Node node) 
    {
        this.left = node.left;
        this.right = node.right;
        this.key = node.key;
        this.color = node.color;
    }

    public Node getLeft() 
    {
        return left;
    }

    public Node getRight() 
    {
        return right;
    }

    public int getKey() 
    {
        return key;
    }
    
    public String getColor() 
	{
		return color;
	}
    
    public void setLeft(Node left) 
    {
        this.left = left;
    }

    public void setRight(Node right) 
    {
        this.right = right;
    }

    public void setKey(int key)
    {
    	this.key = key;
    }

	public void setColor(String color) 
	{
		this.color = color;
	}

		
}

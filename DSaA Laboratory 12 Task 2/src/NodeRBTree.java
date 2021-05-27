public class NodeRBTree 
{
	private NodeRBTree left;
    private NodeRBTree right;
    private int key;
    private String color;

    // The color of the node is by default red
    public NodeRBTree(int key, String color) 
    {
    	this.left = null;
    	this.right = null;
        this.key = key;
        this.color = color;
    }

    public NodeRBTree(NodeRBTree node) 
    {
        this.left = node.left;
        this.right = node.right;
        this.key = node.key;
        this.color = node.color;
    }

    public NodeRBTree getLeft() 
    {
        return left;
    }

    public NodeRBTree getRight() 
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
    
    public void setLeft(NodeRBTree left) 
    {
        this.left = left;
    }

    public void setRight(NodeRBTree right) 
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

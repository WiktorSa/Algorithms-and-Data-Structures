
public class NodeBSTTree 
{
	private NodeBSTTree left;
    private NodeBSTTree right;
    private int key;

    public NodeBSTTree(int key) 
    {
        this.key = key;
    }

    public NodeBSTTree(NodeBSTTree node) 
    {
        this.left = node.left;
        this.right = node.right;
        this.key = node.key;
    }

    public NodeBSTTree getLeft() 
    {
        return left;
    }

    public NodeBSTTree getRight() 
    {
        return right;
    }

    public int getKey() 
    {
        return key;
    }
    
    public void setLeft(NodeBSTTree left) 
    {
        this.left = left;
    }

    public void setRight(NodeBSTTree right) 
    {
        this.right = right;
    }

    public void setKey(int key)
    {
    	this.key = key;
    }
}

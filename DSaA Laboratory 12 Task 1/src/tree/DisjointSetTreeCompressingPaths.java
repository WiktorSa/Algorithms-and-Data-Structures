package tree;

public class DisjointSetTreeCompressingPaths extends DisjointSetTree
{
	public DisjointSetTreeCompressingPaths(int n)
	{
		super(n);
	}
	
	// With compression
	public Node find(int value)
	{
		// First we need our original node
		Node node = findNode(value);
		Node temp = node.getParent();
		
		// Searching for the most in front parent
		while (temp.getParent() != temp)
		{
			temp = temp.getParent();
		}
		
		node.setParent(temp);
		return temp;
	}
	
	public void union(int x, int y)
	{
		Node node1 = find(x);
		Node node2 = find(y);
		
		// The are already friends
		if (node1 == node2) {
			return;
		}
				
		node1.setParent(node2);
		// Is already in another path
		nodes.remove(node2);
	}
	
}

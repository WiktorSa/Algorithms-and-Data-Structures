package tree;

public class DisjointSetTreeStabilization extends DisjointSetTree
{
	public DisjointSetTreeStabilization(int n)
	{
		super(n);
	}
	
	// Without compression
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
		
		return temp;
	}
	
	// With height stabilization
	public void union(int x, int y)
	{
		Node node1 = find(x);
		Node node2 = find(y);
		
		// The are already friends
		if (node1 == node2) {
			return;
		}
		
		// Is already in another path
		nodes.remove(node2);
		
		// Using ranks to control the height
		if (node1.getRank() < node2.getRank()) {
			node2.setParent(node1);
		}
		
		else if (node2.getRank() < node1.getRank()) {
			node1.setParent(node2);
		}
		
		else {
			node1.setParent(node2);
			node2.setRank(node2.getRank() + 1);
		}
	}
	
}
import java.util.ArrayList;

// Drzewo z kompresja sciezek
public class DisjointSetTreeCompressingPaths 
{
	private ArrayList<Node> nodes;
	private int n;
	
	public DisjointSetTreeCompressingPaths(int n)
	{
		this.n = n;
		makeSet();
	}
	
	public void makeSet()
	{
		nodes = new ArrayList<Node>();
		for (int i=0; i<n; i++)
		{
			nodes.add(new Node(i));
		}
	}
	
	// Z kompresja
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
	
	// Find nodes separately
	private Node findNode(int value)
	{
		Node temp = null;
		
		for (int i=0; i<nodes.size(); i++)
		{
			temp = nodes.get(i);
			
			if (temp.getValue() == value) {
				return temp;
			}
			
			while (temp.getParent() != temp)
            {
            	temp = temp.getParent();
            	if (temp.getValue() == value) {
            		return temp;
            	}
            }
		}
		
		return null;
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
	
	public void printSet() 
	{
        for(int i = 0; i < nodes.size(); i++) 
        {
            System.out.println("\nKolejna œcie¿ka: ");
            Node temp = nodes.get(i);

            System.out.println(temp.getValue());
            while (temp.getParent() != temp)
            {
            	temp = temp.getParent();
            	System.out.println(temp.getValue());
            }
        }
	}
}

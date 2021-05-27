package tree;

import java.util.ArrayList;

public abstract class DisjointSetTree 
{
	protected ArrayList<Node> nodes;
	protected int n;
	
	public DisjointSetTree(int n)
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
	
	// Find nodes separately
	protected Node findNode(int value)
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
	
	public void printSet() 
	{
        for(int i = 0; i < nodes.size(); i++) 
        {
            System.out.println("\nNext path: ");
            Node temp = nodes.get(i);

            System.out.println(temp.getValue());
            while (temp.getParent() != temp)
            {
            	temp = temp.getParent();
            	System.out.println(temp.getValue());
            }
        }
	}

	public abstract Node find(int value);
	public abstract void union(int x, int y);
}

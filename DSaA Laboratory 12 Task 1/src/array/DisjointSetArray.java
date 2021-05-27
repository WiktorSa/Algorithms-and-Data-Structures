package array;

public abstract class DisjointSetArray 
{
	protected int[] parent;
	
	public DisjointSetArray(int n)
	{
		parent = new int[n];
		makeSet();
	}
	
	public void makeSet()
	{
		for (int i = 0; i < parent.length; i++) 
		{
            parent[i] = i;
        }
	}
	
	public void union(int x, int y)
	{
		int xRep = find(x);
		int yRep = find(y);
		
		parent[xRep] = yRep;
	}
	
	public void printSet()
	{
		for (int i=0; i<parent.length; i++)
		{
			int temp = i;
			String s = "";
			
			while (parent[temp] != temp) 
			{
				s += temp + " -> ";
				
				temp = parent[temp];
			}
			
			s += temp + " -> ";
			
			System.out.println(s);
		}
	}
	
	public abstract int find(int x);
}

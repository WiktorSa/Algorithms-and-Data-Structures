// Zbior rozlaczny z kompresja
public class DisjointSetArray
{
	private int[] parent;
	
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
	
	// Z rownowazemiem
	public int find(int x)
	{
		// Searching for the mostInFrontParent
		int single_parent = parent[x];
		while (parent[single_parent] != single_parent)
		{
			single_parent = parent[single_parent];
		}
		
		parent[x] = single_parent;
		
		return single_parent;
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
}

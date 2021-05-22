
// Zbior rozlaczny bez kompresji i rownowazenia
public class DisjointSetArrayNotCompressing 
{
	private int[] parent;
	
	public DisjointSetArrayNotCompressing(int n)
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
	
	// Bez rownowazenia
	public int find(int x)
	{	
		if (parent[x] == x) {
			return x;
		}
		
		else {
			return find(parent[x]);
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
}
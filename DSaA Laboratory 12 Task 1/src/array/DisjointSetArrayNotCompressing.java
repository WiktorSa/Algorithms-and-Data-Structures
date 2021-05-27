package array;

public class DisjointSetArrayNotCompressing extends DisjointSetArray
{
	public DisjointSetArrayNotCompressing(int n)
	{
		super(n);
	}
	
	// Without compression
	public int find(int x)
	{	
		if (parent[x] == x) {
			return x;
		}
		
		else {
			return find(parent[x]);
		}
	}
}
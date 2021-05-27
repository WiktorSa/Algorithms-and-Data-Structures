package array;

public class DisjointSetArrayCompressing extends DisjointSetArray
{
	public DisjointSetArrayCompressing(int n)
	{
		super(n);
	}
	
	// With compression
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
	
}

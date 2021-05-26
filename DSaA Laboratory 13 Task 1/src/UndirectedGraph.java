
public class UndirectedGraph extends Graph
{
	public UndirectedGraph() 
	{
		super();
	}

	// Link vertex with key2 to the vertex with key1 (both ways)
	public void link(int key1, int key2)
	{
		Vertex vertex1 = findVertex(key1);
		Vertex vertex2 = findVertex(key2);
		
		if (vertex1 != null && vertex2 != null) {
			vertex1.getVertices().add(vertex2);
			vertex2.getVertices().add(vertex1);
		}
		
		else {
			System.out.println("At least one vertex doesn't exist");
		}
	}

}

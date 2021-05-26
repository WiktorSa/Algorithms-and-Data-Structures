
public class DirectGraph extends Graph
{
	public DirectGraph() 
	{
		super();
	}
	
	// Link vertex with key2 to the vertex with key1
	public void link(int key1, int key2)
	{
		Vertex vertex1 = findVertex(key1);
		Vertex vertex2 = findVertex(key2);
		
		if (vertex1 != null && vertex2 != null) {
			vertex1.getVertices().add(vertex2);
		}
		
		else {
			System.out.println("At least one vertex doesn't exist");
		}
	}
	
}

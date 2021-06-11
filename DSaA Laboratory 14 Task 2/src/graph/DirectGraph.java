package graph;
import java.util.TreeSet;

public abstract class DirectGraph 
{
	// Vertices used in a graph
	protected TreeSet<Vertex> vertices = new TreeSet<Vertex>();
	
	// Add new vertex to our Graph
	public void add(int key)
	{
		for (Vertex vertex : vertices)
		{
			if (vertex.getKey() == key) {
				System.out.println("This node is already in our graph");
				return;
			}
		}
		
		vertices.add(new Vertex(key));
	}
	
	// Find vertex in our arrayList
	public Vertex findVertex(int key)
	{
		for (Vertex vertex : vertices)
		{
			if (vertex.getKey() == key) {
				return vertex;
			}
		}
		
		return null;
	}
	
	// Link vertex with key2 to the vertex with key1
	public void link(int key1, int key2, int weight)
	{
		Vertex vertex1 = findVertex(key1);
		Vertex vertex2 = findVertex(key2);
		
		if (vertex1 != null && vertex2 != null) {
			vertex1.getVertices().put(vertex2, weight);
		}
		
		else {
			System.out.println("At least one vertex doesn't exist");
		}
	}
	
	public void printAdjacencyMatrix()
	{
		System.out.print("      ");
		for (Vertex vertex : vertices)
		{
			System.out.print(String.format("%-6s", vertex.getKey()));
		}
		System.out.println();
		
		for (Vertex outerVertex : vertices)
		{
			System.out.print(String.format("%-6s", outerVertex.getKey()));
			
			Object[] outerVertices = outerVertex.getVertices().keySet().toArray();
			for (Vertex insideVertex : vertices)
			{
				if (outerVertex.equals(insideVertex)) {
					System.out.print("0     ");
				}
				
				else {
					boolean wasFound = false;
					
					for (int i=0; i<outerVertices.length; i++)
					{
						if (insideVertex.equals(outerVertices[i])) {
							System.out.print(outerVertex.getVertices().get(insideVertex) + "     ");
							wasFound = true;
							break;
						}
					}
					
					if (!wasFound) {
						System.out.print("inf   ");
					}
				}
			}
			
			System.out.println();
		}
	}
	
	public void printAdjacencyList()
	{
		for (Vertex outerVertex : vertices)
		{
			System.out.print(outerVertex.getKey() + " -> ");
			
			for (Vertex insideVertex : outerVertex.getVertices().keySet())
			{
					System.out.print(insideVertex.getKey() + "/" + outerVertex.getVertices().get(insideVertex) + " -> ");
			}
			
			System.out.println();
		}
	}
	
	public abstract void alg(int keyStart, int keyEnd);
}

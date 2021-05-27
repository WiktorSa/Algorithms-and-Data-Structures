package graph;
import java.util.TreeSet;

public abstract class Graph 
{
	// Vertices used in a graph
	protected TreeSet<Vertex> vertices;
	
	public Graph() 
	{
		vertices = new TreeSet<Vertex>();
	}
	
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
			
			for (Vertex insideVertex : vertices)
			{
				if (outerVertex.getVertices().contains(insideVertex)) {
					System.out.print("1     ");
				}
				else {
					System.out.print("0     ");
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
			
			for (Vertex insideVertex : vertices)
			{
				if (outerVertex.getVertices().contains(insideVertex)) {
					System.out.print(insideVertex.getKey() + " -> ");
				}
			}
			
			System.out.println();
		}
	}
	
	public abstract void link(int key1, int key2);
}

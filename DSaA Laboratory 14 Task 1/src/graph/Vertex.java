package graph;
import java.util.HashMap;

public class Vertex implements Comparable<Vertex>
{
	private int key;
	// Vertices to which our vertex has access to with the weight of the path
	private HashMap<Vertex, Integer> vertices = new HashMap<Vertex, Integer>();
	
	public Vertex(int key)
	{
		this.key = key;
	}

	public int getKey() 
	{
		return key;
	}

	public void setKey(int key) 
	{
		this.key = key;
	}

	public HashMap<Vertex, Integer> getVertices() 
	{
		return vertices;
	}

	public void setVertices(HashMap<Vertex, Integer> vertices) 
	{
		this.vertices = vertices;
	}

	@Override
	public int compareTo(Vertex vertex) 
	{
		return key > vertex.getKey() ? 1 : 0;
	}
	
	@Override
	public boolean equals(Object vertex)
	{
		return key == ((Vertex) vertex).getKey();
	}

}

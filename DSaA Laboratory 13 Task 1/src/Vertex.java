import java.util.ArrayList;

public class Vertex implements Comparable<Vertex>
{
	private int key;
	// Vertices to which our vertex has access
	private ArrayList<Vertex> vertices = new ArrayList<Vertex>();
	
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

	public ArrayList<Vertex> getVertices() 
	{
		return vertices;
	}

	public void setVertices(ArrayList<Vertex> vertices) 
	{
		this.vertices = vertices;
	}

	@Override
	public int compareTo(Vertex vertex) 
	{
		return key > vertex.getKey() ? 1 : 0;
	}
	
}

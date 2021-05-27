package graph;
import java.util.ArrayList;

public class Vertex implements Comparable<Vertex>
{
	private int key;
	// Vertices to which our vertex has access
	private ArrayList<Vertex> vertices = new ArrayList<Vertex>();
	// Parameters used for BFS
	ColorVertex color = ColorVertex.WHITE;
	private Vertex parent = null;
	private int distance = Integer.MAX_VALUE;
	// Parameters used for DFS
	private boolean wasVisited = false;
	
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

	public ColorVertex getColor() 
	{
		return color;
	}

	public void setColor(ColorVertex color) 
	{
		this.color = color;
	}

	public int getDistance() 
	{
		return distance;
	}

	public void setDistance(int distance) 
	{
		this.distance = distance;
	}

	public Vertex getParent() 
	{
		return parent;
	}

	public void setParent(Vertex parent) 
	{
		this.parent = parent;
	}
	
	public boolean getWasVisited() 
	{
		return wasVisited;
	}

	public void setWasVisited(boolean wasVisited) 
	{
		this.wasVisited = wasVisited;
	}

	public String toString(boolean isBFSSearch)
	{
		String string = ("Key: " + key + "\n");
		
		if (isBFSSearch) {
			string += ("Color: " + color + "\n");
			string += ("Distance: " + distance + "\n");
			
			if (parent == null) {
				string += ("Parent: " + "No Parent\n");
			}
			else {
				string += ("Parent: \n" + parent.toString(isBFSSearch));
			}
		}
		
		else {
			string += ("Was visited at least once: " + wasVisited);
		}
		
		return string;
	}
}

package kruskal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import graph.UndirectedGraph;
import graph.Vertex;

public class Kruskal extends UndirectedGraph
{
	// Get every edge in the vertices
	private ArrayList<Edge> makeSetEdges() 
	{
		ArrayList<Edge> edges = new ArrayList<>();
		
		for (Vertex outerVertex : this.vertices)
		{
			for (Vertex insideVertex : outerVertex.getVertices().keySet())
			{
				edges.add(new Edge(new Vertex(outerVertex.getKey()), new Vertex(insideVertex.getKey()), outerVertex.getVertices().get(insideVertex)));
			}
		}
		
		return edges;
	}
	
	// Create vertices that will be later based on the result and used for BFS search
	private ArrayList<Vertex> makeSetVertices()
	{
		ArrayList<Vertex> verticesKruskal = new ArrayList<Vertex>();
		for (Vertex vertex : this.vertices)
		{
			verticesKruskal.add(new Vertex(vertex.getKey()));
		}
		
		return verticesKruskal;
	}
	
	// Checks if a new edge connects to different trees (using BFS)
	private boolean isConnectingDifferentTrees(ArrayList<Vertex> verticesKruskal, Vertex startVertex, Vertex endVertex) 
	{
		boolean [] wasVisited = new boolean[verticesKruskal.size()];
		for (int i=0; i<wasVisited.length; i++)
		{
			wasVisited[i] = false;
		}
		
		LinkedList<Vertex> queue = new LinkedList<Vertex>();
		queue.add(verticesKruskal.get(verticesKruskal.indexOf(startVertex)));
		
		while (queue.size() > 0)
		{
			Vertex  firstVertexInQueue = queue.poll();
			
			for (Vertex vertex : firstVertexInQueue.getVertices().keySet())
			{
				
				if (vertex.equals(endVertex)) {
					return false;
				}
				
				// Note - because we constantly create new connections the vertices of vertices won't have proper connections
				// That's why we need to take the vertices from verticesKruskal
				if (!wasVisited[verticesKruskal.indexOf(vertex)]) {
					wasVisited[verticesKruskal.indexOf(vertex)] = true;
					queue.add(verticesKruskal.get(verticesKruskal.indexOf(vertex)));
				}
			}
		}
		
		// There is no connection
		return true;
	}
	
	@Override
	public void alg() 
	{
		ArrayList<Edge> result = new ArrayList<Edge>();
		ArrayList<Vertex> verticesKruskal = makeSetVertices();
		ArrayList<Edge> edges = makeSetEdges();
		
		Collections.sort(edges, new WeightsComparator());
		
		// The first connection will always be in the result
		Edge firstEdge = edges.remove(0);
		System.out.println("Added the first edge: " + firstEdge.getSource().getKey() + " <-> " + firstEdge.getDestination().getKey() + " Weight: " + firstEdge.getWeight() + "\n");
		result.add(firstEdge);
		verticesKruskal.get(verticesKruskal.indexOf(firstEdge.getSource())).getVertices().put(firstEdge.getDestination(), firstEdge.getWeight());
		verticesKruskal.get(verticesKruskal.indexOf(firstEdge.getDestination())).getVertices().put(firstEdge.getSource(), firstEdge.getWeight());
		for (Edge edge : edges)
		{
			System.out.println("Trying to add this edge: " + edge.getSource().getKey() + " <-> " + edge.getDestination().getKey() + " Weight: " + edge.getWeight());
			
			Vertex startVertex = edge.getSource();
			Vertex endVertex = edge.getDestination();
			
			if (isConnectingDifferentTrees(verticesKruskal, startVertex, endVertex)) {
				verticesKruskal.get(verticesKruskal.indexOf(startVertex)).getVertices().put(endVertex, edge.getWeight());
				verticesKruskal.get(verticesKruskal.indexOf(endVertex)).getVertices().put(startVertex, edge.getWeight());
				result.add(edge);
				System.out.println("Edge added successfully\n");
			}
			
			else {
				System.out.println("We reject this edge because we already path leading from the source to destination\n");
			}
		}
		
		System.out.println("All edges in the result:");
		int sum = 0;
		for (Edge edge : result)
		{
			System.out.println(edge.getSource().getKey() + " <-> " + edge.getDestination().getKey() + " Weight: " + edge.getWeight());
			sum += edge.getWeight();
		}
		System.out.println("Sum of all weights: " + sum);
	}

}

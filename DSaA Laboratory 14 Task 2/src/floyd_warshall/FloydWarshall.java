package floyd_warshall;

import graph.DirectGraph;
import graph.Vertex;

public class FloydWarshall extends DirectGraph
{
	private static int INF = 100000;
	
	private int[][] getAdjacencyMatrix() 
	{
		int[][] adjacencyMatrix = new int[vertices.size()][vertices.size()];
		
		int i = 0;
		int j = 0;
		for (Vertex outerVertex : vertices)
		{
			j = 0;
			
			Object[] outerVertices = outerVertex.getVertices().keySet().toArray();
			for (Vertex insideVertex : vertices)
			{
				if (outerVertex.equals(insideVertex)) {
					adjacencyMatrix[i][j] = 0;
				}
				
				else {
					boolean wasFound = false;
					
					for (int k=0; k<outerVertices.length; k++)
					{
						if (insideVertex.equals(outerVertices[k])) {
							adjacencyMatrix[i][j] = outerVertex.getVertices().get(insideVertex);
							wasFound = true;
							break;
						}
					}
					
					if (!wasFound) {
						adjacencyMatrix[i][j] = INF;
					}
				}
				
				j++;
			}
			

			i++;
		}
		
		return adjacencyMatrix;
	}
	
	public void alg(int keyStart, int keyEnd)
	{
		Integer startIndex = null;
		Integer endIndex = null;
		int q=0;
		for (Vertex vertex : vertices)
		{
			if (vertex.getKey() == keyStart) {
				startIndex = q;
			}
			
			if (vertex.getKey() == keyEnd) {
				endIndex = q;
			}
			
			q++;
		}
		
		if (startIndex == null || endIndex == null) {
			System.out.println("At least one vertex doesn't exist");
			return;
		}
		
		int[][] adjacencyMatrix = getAdjacencyMatrix();
		int v = vertices.size();
		
		int dist[][] = new int[v][v];
		
		for (int i=0; i<v; i++)
		{
			for (int j=0; j<v; j++)
			{
				dist[i][j] = adjacencyMatrix[i][j];
			}
		}
		
		for (int k=0; k<v; k++)
		{
			for (int i=0; i<v; i++)
			{
				for (int j=0; j<v; j++)
				{
					if (dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		
		System.out.println("The shortest path between every pair of vertices");
		for (int i=0; i<v; i++)
		{
			for (int j=0; j<v; j++)
			{
				System.out.print("Distance between: " + ((Vertex) vertices.toArray()[i]).getKey() + " and " + ((Vertex) vertices.toArray()[j]).getKey() + ": ");
				if (dist[i][j] == INF) {
					System.out.print("INF");
				}
				else {
					System.out.print(dist[i][j]);
				}
				System.out.println();
			}
			System.out.println();
		}
		
		System.out.println("Distance between given vertices: " + ((Vertex) vertices.toArray()[startIndex]).getKey() + " and " + ((Vertex) vertices.toArray()[endIndex]).getKey() + ": " + dist[startIndex][endIndex]);
	}
}

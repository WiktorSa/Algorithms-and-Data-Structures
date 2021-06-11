package prim;

import graph.UndirectedGraph;
import graph.Vertex;

public class Prim extends UndirectedGraph
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
	
	private int minKey(int key[], boolean mstSet[])
	{
		int min = Integer.MAX_VALUE;
		int min_index = -1;
		
		for (int v=0; v < vertices.size(); v++)
		{
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}
		}
		
		return min_index;
	}
			
	@Override
	public void alg() 
	{
		int[][] adjacencyMatrix = getAdjacencyMatrix();
		int v = vertices.size();
		
		int parent[] = new int[v];
		int key[] = new int[v];
		
		boolean mstSet[] = new boolean[v];
		
		for (int i=0; i<v; i++)
		{
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		
		key[0] = 0;
		parent[0] = -1;
		
		System.out.println("Note the first vertex we connect to is the vertex with the lowest key (by default)\n");
		for (int count=0; count<v -1; count++)
		{
			System.out.println("Iteration: " + count);
			System.out.println("Vertices that were already visited");
			for (int i=0; i<v; i++)
			{
				if (mstSet[i] == true) {
					System.out.println(((Vertex) vertices.toArray()[i]).getKey());
				}
			}
			
			System.out.println("\nSet of keys (we will go to the vertex that we haven't visited yet and the distance is the shortest)");
			for (int i=0; i<v; i++)
			{
				System.out.println(key[i]);
			}
			
			System.out.println("\nSet of parents (we will use this set of indexes to later display proper relationship within vertices)");
			for (int i=0; i<v; i++)
			{
				System.out.println(key[i]);
			}
			
			int u = minKey(key, mstSet);
			
			mstSet[u] = true;
			
			System.out.println("\nIndex of the vertex to which we should connect: " + u);
			System.out.println("Vertex (key) to which we should connect next " + ((Vertex) vertices.toArray()[u]).getKey() + "\n\n");
			
			for (int j=0; j<v; j++)
			{
				if (adjacencyMatrix[u][j] != 0 && mstSet[j] == false && adjacencyMatrix[u][j] < key[j]) {
					parent[j] = u;
					key[j] = adjacencyMatrix[u][j];
				}
			}
		}
		
		System.out.println("All edges in the result");
		for (int i=1; i<v; i++)
		{
			System.out.println(((Vertex) vertices.toArray()[parent[i]]).getKey() + " <-> " + ((Vertex) vertices.toArray()[i]).getKey() + " Weight: " + adjacencyMatrix[i][parent[i]]);
		}
	}

}

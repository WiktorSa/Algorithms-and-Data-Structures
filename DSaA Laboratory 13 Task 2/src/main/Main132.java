package main;
import graph.Graph;
import graph.UndirectedGraph;
import queue.EmptyQueueException;
import queue.FullQueueException;
import stack.EmptyStackException;
import stack.FullStackException;

public class Main132 
{
	public static void main(String[] args) 
	{
		Graph undirectedGraph = new UndirectedGraph();
		undirectedGraph.add(1);
		undirectedGraph.add(2);
		undirectedGraph.add(3);
		undirectedGraph.add(4);
		undirectedGraph.add(5);
		undirectedGraph.add(6);
		undirectedGraph.add(7);
		undirectedGraph.add(8);
		undirectedGraph.link(1, 8);
		undirectedGraph.link(8, 7);
		undirectedGraph.link(1, 2);
		undirectedGraph.link(2, 3);
		undirectedGraph.link(2, 4);
		undirectedGraph.link(3, 4);
		undirectedGraph.link(3, 5);
		undirectedGraph.link(4, 6);
		undirectedGraph.link(5, 6);
		
		System.out.println("Adjacency matrix for undirected graph");
		undirectedGraph.printAdjacencyMatrix();
		System.out.println("\nAdjacency list for undirected graph");
		undirectedGraph.printAdjacencyList();
		
		try 
		{
			System.out.println("\nDoing BFS on vertex with key 1 (warning - because we show a parent of the vertex it may show a lot of keys)");
			undirectedGraph.BFS(1);
		} 
		// This exception should never happen
		catch (EmptyQueueException | FullQueueException e) 
		{
			System.out.println("Critical error");
			System.exit(-1);
		}
		
		System.out.println("Searching for path between vector with key 1 and vector with key 6");
		undirectedGraph.printPath(1, 6);
		System.out.println("Searching for path between vector with key 1 and vector with key 9");
		undirectedGraph.printPath(1, 9);
		
		try 
		{
			System.out.println("\nDoing DFS on vertex with key 1");
			undirectedGraph.DFS(1);
		} 
		// This exception should never happen
		catch (FullStackException | EmptyStackException e) 
		{
			System.out.println("Critical error");
			System.exit(-1);
		}
	}
}

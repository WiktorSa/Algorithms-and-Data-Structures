package main;
import graph.DirectGraph;
import graph.Graph;
import graph.UndirectedGraph;

public class Main131 
{
	public static void main(String[] args) 
	{
		System.out.println("Direct graph\n");
		
		Graph directGraph = new DirectGraph();
		directGraph.add(1);
		directGraph.add(2);
		directGraph.add(3);
		directGraph.add(4);
		directGraph.add(5);
		directGraph.link(1, 2);
		directGraph.link(1, 3);
		directGraph.link(2, 3);
		directGraph.link(4, 5);
		directGraph.link(5, 2);
		directGraph.link(5, 3);
		
		System.out.println("Adjacency matrix for direct graph");
		directGraph.printAdjacencyMatrix();
		System.out.println("\nAdjacency list for direct graph");
		directGraph.printAdjacencyList();
		
		System.out.println("\nMaking a link between vertex with key 1 and vertex with key 5\n");
		directGraph.link(1, 5);
		System.out.println("Adjacency matrix for direct graph");
		directGraph.printAdjacencyMatrix();
		System.out.println("\nAdjacency list for direct graph");
		directGraph.printAdjacencyList();
		
		System.out.println("\nUndirected graph\n");
		
		Graph undirectedGraph = new UndirectedGraph();
		undirectedGraph.add(1);
		undirectedGraph.add(2);
		undirectedGraph.add(3);
		undirectedGraph.add(4);
		undirectedGraph.add(5);
		undirectedGraph.link(1, 2);
		undirectedGraph.link(2, 3);
		undirectedGraph.link(2, 3);
		undirectedGraph.link(4, 5);
		undirectedGraph.link(5, 2);
		undirectedGraph.link(5, 3);
		
		System.out.println("Adjacency matrix for undirected graph");
		undirectedGraph.printAdjacencyMatrix();
		System.out.println("\nAdjacency list for undirected graph");
		undirectedGraph.printAdjacencyList();
		
		System.out.println("\nMaking a link between vertex with key 1 and vertex with key 5\n");
		undirectedGraph.link(1, 5);
		System.out.println("Adjacency matrix for undirected graph");
		undirectedGraph.printAdjacencyMatrix();
		System.out.println("\nAdjacency list for undirected graph");
		undirectedGraph.printAdjacencyList();
	}
}

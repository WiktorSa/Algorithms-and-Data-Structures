package main;

import floyd_warshall.FloydWarshall;
import graph.DirectGraph;

public class Main142 
{
	public static void main(String[] args) 
	{
		DirectGraph floydWarshall = new FloydWarshall();
		floydWarshall.add(1);
		floydWarshall.add(2);
		floydWarshall.add(3);
		floydWarshall.add(4);
		floydWarshall.add(5);
		floydWarshall.add(6);
		floydWarshall.add(7);
		floydWarshall.add(8);
		floydWarshall.link(1, 2, 3);
		floydWarshall.link(1, 3, 15);
		floydWarshall.link(1, 4, 20);
		floydWarshall.link(1, 5, 1);
		floydWarshall.link(1, 6, 1);
		floydWarshall.link(2, 7, 2);
		floydWarshall.link(3, 4, 1);
		floydWarshall.link(3, 8, 4);
		floydWarshall.link(5, 1, 1);
		floydWarshall.link(6, 2, 1);
		floydWarshall.link(6, 7, 5);
		floydWarshall.link(7, 6, 5);
		floydWarshall.link(7, 8, 5);
		floydWarshall.link(8, 3, 3);
		floydWarshall.link(8, 4, 9);
		
		System.out.println("Adjacency matrix");
		floydWarshall.printAdjacencyMatrix();
		System.out.println("\nAdjacency list");
		floydWarshall.printAdjacencyList();
		System.out.println("\nFloyd-Warshall algorithm");
		floydWarshall.alg(1, 4);
	}
}

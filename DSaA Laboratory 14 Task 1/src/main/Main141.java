package main;
import graph.UndirectedGraph;
import kruskal.Kruskal;
import prim.Prim;

public class Main141 
{
	public static void main(String[] args) 
	{
		UndirectedGraph kruskal = new Kruskal();
		kruskal.add(1);
		kruskal.add(2);
		kruskal.add(3);
		kruskal.add(4);
		kruskal.add(5);
		kruskal.add(6);
		kruskal.add(7);
		kruskal.add(8);
		kruskal.link(1, 2, 4);
		kruskal.link(1, 4, 2);
		kruskal.link(1, 5, 3);
		kruskal.link(2, 3, 2);
		kruskal.link(2, 5, 3);
		kruskal.link(2, 6, 8);
		kruskal.link(3, 6, 9);
		kruskal.link(4, 7, 5);
		kruskal.link(5, 7, 5);
		kruskal.link(5, 8, 1);
		kruskal.link(6, 8, 7);
		kruskal.link(7, 8, 6);
		
		System.out.println("Adjacency matrix");
		kruskal.printAdjacencyMatrix();
		System.out.println("\nAdjacency list");
		kruskal.printAdjacencyList();
		System.out.println("\nKruskal algorithm");
		kruskal.alg();
		
		UndirectedGraph prim = new Prim();
		prim.add(1);
		prim.add(2);
		prim.add(3);
		prim.add(4);
		prim.add(5);
		prim.add(6);
		prim.add(7);
		prim.add(8);
		prim.link(1, 2, 4);
		prim.link(1, 4, 2);
		prim.link(1, 5, 3);
		prim.link(2, 3, 2);
		prim.link(2, 5, 3);
		prim.link(2, 6, 8);
		prim.link(3, 6, 9);
		prim.link(4, 7, 5);
		prim.link(5, 7, 5);
		prim.link(5, 8, 1);
		prim.link(6, 8, 7);
		prim.link(7, 8, 6);
		System.out.println("\nPrim algorithm");
		prim.alg();
	}
	
}

package main;
import array.DisjointSetArray;
import array.DisjointSetArrayCompressing;
import array.DisjointSetArrayNotCompressing;
import tree.DisjointSetTree;
import tree.DisjointSetTreeCompressingPaths;
import tree.DisjointSetTreeStabilization;

public class Laby121Main 
{

	public static void main(String[] args) 
	{
		System.out.println("Analysing disjoint sets on arrays");
		DisjointSetArray disjointSetArrayNotCompressing = new DisjointSetArrayNotCompressing(10);
		
		System.out.println("Original set. Arrow means that the next element is the father of the previous one\nArrow pointint to nowhere means that this element is the parent to itself");
		disjointSetArrayNotCompressing.printSet();
		
		System.out.println("\nBasic operations on the set (no need for compression)");
		System.out.println("\nMake 7 the parent of 9");
		disjointSetArrayNotCompressing.union(9, 7);
		disjointSetArrayNotCompressing.printSet();
		System.out.println("\nMake 7 the parent of 8");
		disjointSetArrayNotCompressing.union(8, 7);
		disjointSetArrayNotCompressing.printSet();
		System.out.println("\nMake 2 the parent of 3");
		disjointSetArrayNotCompressing.union(3, 2);
		disjointSetArrayNotCompressing.printSet();
		System.out.println("\nMake 2 the parent of 7. Notice that elements 8 and 9 will be in a relation with element 2");
		disjointSetArrayNotCompressing.union(7, 2);
		disjointSetArrayNotCompressing.printSet();
		System.out.println("\nMake 4 the parent of 5");
		disjointSetArrayNotCompressing.union(5, 4);
		disjointSetArrayNotCompressing.printSet();
		System.out.println("\nMake 5 the parent of 1. Notice that 1 will connect to 4 not 5 because 4 is a parent of 5");
		disjointSetArrayNotCompressing.union(5, 1);
		disjointSetArrayNotCompressing.printSet();
		System.out.println("\nMake 2 the parent of 1");
		disjointSetArrayNotCompressing.union(2, 1);
		disjointSetArrayNotCompressing.printSet();
		
		System.out.println("\nOperation find on element 7. You should see the 'highest' parent: " + disjointSetArrayNotCompressing.find(7));
		System.out.println("Because there was not path compression the set won't change");
		disjointSetArrayNotCompressing.printSet();
		
		
		System.out.println("\nNotice that when path compression is enabled the set will change (the path from the element to the highest 'parent' will be shortened");
		DisjointSetArray disjointSetArray = new DisjointSetArrayCompressing(10);
		disjointSetArray.union(9, 7);
		disjointSetArray.union(8, 7);
		disjointSetArray.union(3, 2);
		disjointSetArray.union(7, 2);
		disjointSetArray.union(5, 4);
		disjointSetArray.union(5, 1);
		disjointSetArray.union(2, 1);
		disjointSetArray.find(7);
		disjointSetArray.printSet();
		
		System.out.println("\nAnalysing disjoint sets on arrays");
		DisjointSetTree disjointSetTreeCompressingPaths = new DisjointSetTreeCompressingPaths(10);
		System.out.println("Original set (next element in the set is the parent of the previous element, the last element is it's own parent)");
		disjointSetTreeCompressingPaths.printSet();
		
		System.out.println("\nDoing union operations (the same operations as with arrays)");
		disjointSetTreeCompressingPaths.union(9, 7);
		disjointSetTreeCompressingPaths.union(8, 7);
		disjointSetTreeCompressingPaths.union(3, 2);
		disjointSetTreeCompressingPaths.union(7, 2);
		disjointSetTreeCompressingPaths.union(5, 4);
		disjointSetTreeCompressingPaths.union(5, 1);
		disjointSetTreeCompressingPaths.union(2, 1);
		
		System.out.println("\nLook of the set after doing union operations");
		disjointSetTreeCompressingPaths.printSet();
		System.out.println("\nFinding element 7 in our set: " + disjointSetTreeCompressingPaths.find(7).getValue());
		System.out.println("Notice the identical path compression as with the arrays");
		disjointSetTreeCompressingPaths.printSet();
		
		System.out.println("\nLet's analyse the tree where 3 is a parent of 2 which is a parent of 1, and 5 which is a parent of 6");
		disjointSetTreeCompressingPaths.makeSet();
		disjointSetTreeCompressingPaths.union(6, 5);
		disjointSetTreeCompressingPaths.union(3, 2);
		disjointSetTreeCompressingPaths.union(2, 1);
		disjointSetTreeCompressingPaths.printSet();
		System.out.println("\nLet's say we want to make the relation between 5 and 1. There are both ways to do it");
		System.out.println("Method 1. union(5, 1)");
		disjointSetTreeCompressingPaths.union(5, 1);
		disjointSetTreeCompressingPaths.printSet();
		System.out.println("\nMethod 2. union(1, 5)");
		disjointSetTreeCompressingPaths.makeSet();
		disjointSetTreeCompressingPaths.union(6, 5);
		disjointSetTreeCompressingPaths.union(3, 2);
		disjointSetTreeCompressingPaths.union(2, 1);
		disjointSetTreeCompressingPaths.union(1, 5);
		disjointSetTreeCompressingPaths.printSet();
		System.out.println("\nNotice that the heights of the tree vary depending on the chosen method");
		
		System.out.println("In the tree with height stabilization the relationship is established in such a way that the final tree will have the lowest height");
		System.out.println("\nMethod1 1. union (5, 1)");
		DisjointSetTree disjointSetTreeStabilization = new DisjointSetTreeStabilization(10);
		disjointSetTreeStabilization.union(6, 5);
		disjointSetTreeStabilization.union(3, 2);
		disjointSetTreeStabilization.union(2, 1);
		disjointSetTreeStabilization.union(1, 5);
		disjointSetTreeStabilization.printSet();
		System.out.println("\nMethod 2. union (1, 5)");
		disjointSetTreeStabilization.makeSet();
		disjointSetTreeStabilization.union(6, 5);
		disjointSetTreeStabilization.union(3, 2);
		disjointSetTreeStabilization.union(2, 1);
		disjointSetTreeStabilization.union(5, 1);
		disjointSetTreeStabilization.printSet();
		System.out.println("\nYou can see that both operations return the same result (and it's the smallest tree)");
		System.out.println("\n\nWe end the analysis of the disjoint sets");
	}

}

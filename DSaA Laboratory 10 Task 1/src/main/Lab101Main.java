package main;
import tree.BSTTree;
import tree.DuplicateElementException;

public class Lab101Main 
{
	public static void main(String[] args) 
	{
		BSTTree bstTree = new BSTTree();
		System.out.println("Inserting nodes with values 7, 5, 10, 3, 8, 12");
		try 
		{
			bstTree.insert(7);
			bstTree.insert(5);
			bstTree.insert(10);
			bstTree.insert(3);
			bstTree.insert(8);
			bstTree.insert(12);
		} 
		catch (DuplicateElementException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println("Inorder");
		bstTree.inOrderWalk();
		System.out.println("\nPreorder");
		bstTree.preOrderWalk();
		System.out.println("\nPostorder");
		bstTree.postOrderWalk();
		
		System.out.println("\nFind node with key 7");
		System.out.println(bstTree.findNode(7));
		System.out.println("Find node with key 1");
		System.out.println(bstTree.findNode(1));
		
		System.out.println("Find the minimal key");
		System.out.println(bstTree.getMin());
		System.out.println("Find the maximal key");
		System.out.println(bstTree.getMax());
		System.out.println("The height of the tree");
		System.out.println(bstTree.getHeight());
		System.out.println("The number of nodes");
		System.out.println(bstTree.getNoNodes());
		System.out.println("The number of leaves");
		System.out.println(bstTree.getNoLeaves());
	}

}

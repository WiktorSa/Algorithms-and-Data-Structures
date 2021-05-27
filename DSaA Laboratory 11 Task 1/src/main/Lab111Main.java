package main;
import tree.DuplicateElementException;
import tree.RBTree;

public class Lab111Main 
{
	public static void main(String[] args) 
	{
		RBTree rbTree = new RBTree();
		System.out.println("Original look of the tree");
		try 
		{
			rbTree.insert(50);
			rbTree.insert(45);
			rbTree.insert(60);
			rbTree.insert(30);
			rbTree.insert(47);
			rbTree.insert(55);
			rbTree.insert(80);
			rbTree.insert(20);
			rbTree.insert(43);
			rbTree.insert(46);
			rbTree.insert(48);
		} 
		catch (DuplicateElementException e) 
		{
			e.printStackTrace();
		}
		
		rbTree.displayKeys();
		
		try 
		{
			rbTree.insert(35);
		} 
		catch (DuplicateElementException e) 
		{
			e.printStackTrace();
		}
		System.out.println("\nHow tree looks after inserting node with key 35\n");
		rbTree.displayKeys();;
		
		try 
		{
			rbTree.insert(49);
		} 
		catch (DuplicateElementException e) 
		{
			e.printStackTrace();
		}
		System.out.println("\nHow tree looks after inserting node with key 49\n");
		rbTree.displayKeys();
		
		try 
		{
			rbTree.insert(37);
		} 
		catch (DuplicateElementException e) 
		{
			e.printStackTrace();
		}
		System.out.println("\nHow tree looks after inserting node with key 37\n");
		rbTree.displayKeys();
		System.out.println("\nFinding node with key 37: " + rbTree.findNode(37).getKey());
		System.out.println("\nInorder");
		rbTree.inOrderWalk();
		System.out.println("\nPreorder");
		rbTree.preOrderWalk();
		System.out.println("\nPostorder");
		rbTree.postOrderWalk();
		System.out.println("\nHeight of the tree: " + rbTree.getHeight());
		System.out.println("Left subtree height: " + rbTree.getHeightLeftSubtree());
		System.out.println("Right subtree height: " + rbTree.getHeightRightSubtree());
		System.out.println("Number of nodes: " + rbTree.getNoNodes());
		System.out.println("Number of nodes for the left subtree: " + rbTree.getNoNodesLeftSubtree());
		System.out.println("Number of nodes for the right subtree: " + rbTree.getNoNodesRightSubtree());
	
		rbTree.deleteNode(37);
		System.out.println("\nTree after deleting node with key 37\n");
		rbTree.displayKeys();
		
		rbTree.deleteNode(49);
		System.out.println("\nTree after deleting node with key 49\n");
		rbTree.displayKeys();
		
		rbTree.deleteNode(35);
		System.out.println("\nTree after deleting node with key 35\n");
		rbTree.displayKeys();
		
	}
}

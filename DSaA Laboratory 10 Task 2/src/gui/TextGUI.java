package gui;
import java.util.InputMismatchException;
import java.util.Scanner;

import tree.BSTTree;
import tree.DuplicateElementException;
import tree.Node;

public class TextGUI 
{
	private BSTTree bstTree;
	
	public TextGUI(BSTTree bstTree)
	{
		this.bstTree = bstTree;
	}
	
	@SuppressWarnings("resource")
	public void startGUI()
	{
		boolean isFinished  = false;
		boolean displayInstructions = true;
		Scanner scanner = new Scanner(System.in);
		
		while (!isFinished)
		{
			if (displayInstructions) {
				System.out.println("Welcome. Choose an option");
				System.out.println("0 - quit");
				System.out.println("1 - insert a node with a given key");
				System.out.println("2 - display keys in order: inorder/preorder/postorder");
				System.out.println("3 - find the minimal key");
				System.out.println("4 - find minimal/maximal key");
				System.out.println("5 - get height/number of nodes/number of leaves");
				System.out.println("6 - display keys");
				System.out.println("7 - get the successor");
				System.out.println("8 - get the predecessor");
				System.out.println("9 - delete node with a given key");
				System.out.println("10 - get the height and number of nodes for each subtree (give a node from which you want to start)");
				System.out.println("11 - draw a tree");
				displayInstructions = false;
			}
			
			System.out.print("Choose option (to remind instructions press -1): ");
			int option = 0;
			try 
			{
				option = scanner.nextInt();
			} 
			catch (InputMismatchException e) 
			{
				System.out.println("Choose correct option");
				option = -2;
			}
			
			switch (option) {
			case 1:
				insert();
				break;
				
			case 2:
				displayAllOrders();
				break;
				
			case 3:
				findNode();
				break;
				
			case 4:
				displayMinAndMax();
				break;
				
			case 5:
				displayTreeParameters();
				break;
				
			case 6:
				displayKeys();
				break;
				
			case 7:
				displaySuccessor();
				break;
				
			case 8:
				displayPredecessor();
				break;
				
			case 9:
				deleteNode();
				break;
				
			case 10:
				displayHeightAndNoNodesForSubtree();
				break;
			
			case 11:
				drawTree();
				break;
				
			case 0:
				System.out.println("Closing the program");
				isFinished = true;
				break;
				
			case -1:
				displayInstructions = true;
				break;

			default:
				System.out.println("Choose correct option");
				break;
			}
			System.out.println();
		}
	}
	
	@SuppressWarnings("resource")
	private void insert()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Give key to insert in the tree: ");
		int key = scanner.nextInt();
		try 
		{
			bstTree.insert(key);
			System.out.println("Key inserted: " + key);
		} 
		catch (DuplicateElementException e) 
		{
			System.out.println("The node with a given key already exists: " + key);
		}
	}
	
	private void displayAllOrders()
	{
		System.out.println("Inorder");
		bstTree.inOrderWalk();
		System.out.println("\nPreorder");
		bstTree.preOrderWalk();
		System.out.println("\nPostorder");
		bstTree.postOrderWalk();
		System.out.println();
	}
	
	@SuppressWarnings("resource")
	private void findNode()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Podaj klucz wezla do znalezenia w drzewie: ");
		int key = scanner.nextInt();
		Node foundNode = bstTree.findNode(key);
		if (foundNode != null) {
			System.out.println("Node found: " + foundNode.getKey());
		}
		else {
			System.out.println("Node failed to found");
		}
	}
	
	private void displayMinAndMax()
	{
		System.out.println("Minimal key: " + bstTree.getMin());
		System.out.println("Maximal key: " + bstTree.getMax());
	}
	
	private void displayTreeParameters()
	{
		System.out.println("Height: " + bstTree.getHeight());
		System.out.println("Number of nodes: " + bstTree.getNoNodes());
		System.out.println("Number of leaves: " + bstTree.getNoLeaves());
	}
	
	private void displayKeys()
	{
		bstTree.displayKeys();
	}
	
	@SuppressWarnings("resource")
	private void displaySuccessor()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Give key: ");
		int key = scanner.nextInt();
		int foundKey = bstTree.getSuccessor(key);
		if (foundKey != -1) {
			System.out.println("Successor: " + foundKey);
		}
		else {
			System.out.println("No successor");
		}
	}
	
	@SuppressWarnings("resource")
	private void displayPredecessor()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Give key: ");
		int key = scanner.nextInt();
		int foundKey = bstTree.getPredecessor(key);
		if (foundKey != -1) {
			System.out.println("Predecessor: " + foundKey);
		}
		else {
			System.out.println("No predecessor");
		}
	}
	
	@SuppressWarnings("resource")
	private void deleteNode()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Give key: ");
		int key = scanner.nextInt();
		bstTree.delete(key);
		System.out.println("Key deleted");
	}

	@SuppressWarnings("resource")
	private void displayHeightAndNoNodesForSubtree()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Give key: ");
		int key = scanner.nextInt();
		Node foundNode = bstTree.findNode(key);
		if (foundNode != null) {
			System.out.println("Parameters for subtrees of the given node: " + foundNode.getKey());
			System.out.println("Left height: " + bstTree.getHeightSubtree(foundNode.getLeft()));
			System.out.println("Left number of nodes: " + bstTree.getNoNodesSubtree(foundNode.getLeft()));
			System.out.println("Right height: " + bstTree.getHeightSubtree(foundNode.getRight()));
			System.out.println("Right number of nodes: " + bstTree.getNoNodesSubtree(foundNode.getRight()));
		}
		else {
			System.out.println("Node with a given key doesn't exist");
		}
	}
	
	private void drawTree()
	{
		BSTTreePrinter bstTreePrinter = new BSTTreePrinter(bstTree);
		bstTreePrinter.print();
	}
}

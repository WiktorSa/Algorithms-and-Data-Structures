package main;
import tree.Tree234;

public class Lab112 
{
	public static void main(String[] args) 
	{
		Tree234 tree = new Tree234();
        tree.insert(100);
        tree.insert(10);
        tree.insert(200);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(50);
        tree.insert(5);
        System.out.println("Tree after inserting nodes with keys 100, 10, 200, 30, 20, 40, 50, 5");
        tree.displayTree();
        tree.insert(78);
        tree.insert(23);
        System.out.println("\nTree after inserting nodes with keys 78, 23 w podanej kolejnosci");
        tree.displayTree();
        System.out.println();
        System.out.println("Finding node with a key 50: " + tree.find(50));
        System.out.println("Find node with a key 220: " + tree.find(220));
        System.out.println("Minimal key: " + tree.getMin());
        System.out.println("Maximal key: " + tree.getMax());
        System.out.println("Successor of the node with key 20: " + tree.getSuccessor(20));
        System.out.println("Predecessor of the node with key 20: " + tree.getPredecessor(20));
	}

}

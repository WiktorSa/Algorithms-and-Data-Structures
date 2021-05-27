package tree;
import java.util.NoSuchElementException;

public class BSTTree 
{
	private Node _root;
	
	public BSTTree() 
	{
		_root = null;
	}
	
	public void insert(int key) throws DuplicateElementException
	{
		_root = insert(_root, key);
	}
	
	private Node insert(Node node, int key) throws DuplicateElementException
	{
		if (node == null) {
			node = new Node(key);
		}
		
		else {
			if (key < node.getKey()) {
				node.setLeft(insert(node.getLeft(), key));
			}
			else if (key > node.getKey()) {
				node.setRight(insert(node.getRight(), key));
			}
			else {
				throw new DuplicateElementException(key);
			}
		}
		
		return node;
	}
	
	public void inOrderWalk()
	{
		inOrderWalk(_root);
	}
	
	private void inOrderWalk(Node node)
	{
		if (node != null) {
			inOrderWalk(node.getLeft());
			System.out.print(node.getKey() + " ");
			inOrderWalk(node.getRight());
		}
	}
	
	public void preOrderWalk()
	{
		preOrderWalk(_root);
	}
	
	private void preOrderWalk(Node node)
	{
		if (node != null) {
			System.out.print(node.getKey() + " ");
			preOrderWalk(node.getLeft());
			preOrderWalk(node.getRight());
		}
	}
	
	public void postOrderWalk()
	{
		postOrderWalk(_root);
	}
	
	private void postOrderWalk(Node node)
	{
		if (node != null) {
			postOrderWalk(node.getLeft());
			postOrderWalk(node.getRight());
			System.out.print(node.getKey() + " ");
		}
	}
	
	public Node findNode(int key)
	{
		Node temp = _root;
		while (temp != null)
		{
			if (temp.getKey() == key) {
				return temp;
			}
			else if (temp.getKey() < key) {
				temp = temp.getRight();
			}
			else {
				temp = temp.getLeft();
			}
		}
		
		return null;
	}
	
	public int getMin()
	{
		if (_root == null) {
			throw new NoSuchElementException();
		}
		
		Node node = getMin(_root);
		
		return node.getKey();
	}
	
	private Node getMin(Node node)
	{
		while (node.getLeft() != null)
		{
			node = node.getLeft();
		}
		
		return node;
	}
	
	public int getMax()
	{
		if (_root==null) {
			throw new NoSuchElementException();
		}
		
		Node node = getMax(_root);
		return node.getKey();
	}
	
	private Node getMax(Node node) 
	{
		while (node.getRight() != null)
		{
			node=node.getRight();
		}
		
		return node;
	}
	
	public int getHeight()
	{
		return getHeight(_root);
	}
	
	private int getHeight(Node node)
	{
		if (node == null) {
			return 0;
		}
		
		else {
			int leftHeight = getHeight(node.getLeft());
			int rightHeight = getHeight(node.getRight());
			
			return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
		}
	}
	
	public int getNoNodes()
	{
		return 1 + getNoNodes(_root);
	}
	
	private int getNoNodes(Node node)
	{
		if (node == null) {
			return -1;
		}
		else {
			int noNodesLeft = 1 + getNoNodes(node.getLeft());
			int noNodesRight = 1 + getNoNodes(node.getRight());
			
			return noNodesLeft + noNodesRight;
		}
	}
	
	public int getNoLeaves()
	{
		return getNoLeaves(_root);
	}
	
	private int getNoLeaves(Node node)
	{
		if (node == null) {
			return 0;
		}
		
		else if (node.getLeft() == null && node.getRight() == null) {
			return 1;
		}
		
		else {
			return getNoLeaves(node.getLeft()) + getNoLeaves(node.getRight());
		}
	}
	
	
}

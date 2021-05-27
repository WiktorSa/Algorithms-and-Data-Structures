import java.util.NoSuchElementException;

public class BSTTree 
{
	private NodeBSTTree _root;
	private double noComparisions = 0;
	
	public BSTTree() 
	{
		_root = null;
	}
	
	// Notka - ten typ drzewa nie moze miec kluczy duplikatow !!!
	public void insert(int key) throws DuplicateElementException
	{
		_root = insert(_root, key);
	}
	
	private NodeBSTTree insert(NodeBSTTree node, int key) throws DuplicateElementException
	{
		if (node == null) {
			node = new NodeBSTTree(key);
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
	
	private void inOrderWalk(NodeBSTTree node)
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
	
	private void preOrderWalk(NodeBSTTree node)
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
	
	private void postOrderWalk(NodeBSTTree node)
	{
		if (node != null) {
			postOrderWalk(node.getLeft());
			postOrderWalk(node.getRight());
			System.out.print(node.getKey() + " ");
		}
	}
	
	public NodeBSTTree findNode(int key)
	{
		NodeBSTTree temp = _root;
		while (temp != null)
		{
			if (temp.getKey() == key) {
				noComparisions += 1;
				return temp;
			}
			else if (temp.getKey() < key) {
				noComparisions += 2;
				temp = temp.getRight();
			}
			else {
				noComparisions += 2;
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
		
		NodeBSTTree node = getMin(_root);
		
		return node.getKey();
	}
	
	private NodeBSTTree getMin(NodeBSTTree node)
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
		
		NodeBSTTree node = getMax(_root);
		return node.getKey();
	}
	
	private NodeBSTTree getMax(NodeBSTTree node) 
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
	
	// Ide po kazdym z wezlow i szukam polaczenia, ktore jest najdluzsze
	private int getHeight(NodeBSTTree node)
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
	
	// Ide po kazdym z wezlow i licze rekurencyjnie liczbe wezlow
	private int getNoNodes(NodeBSTTree node)
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
	
	private int getNoLeaves(NodeBSTTree node)
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

	public double getNoComparisions() 
	{
		return noComparisions;
	}
	
	public void setNoComparisions(double noComparisions) 
	{
		this.noComparisions = noComparisions;
	}

}

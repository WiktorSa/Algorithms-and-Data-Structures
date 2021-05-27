package tree;
import java.util.NoSuchElementException;

public class BSTTree 
{
	private Node _root;
	
	public BSTTree() 
	{
		_root = null;
	}
	
	public Node getRoot()
	{
		return _root;
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
		// Licze w przyszlosc liczbe wezlow (wiec jak nie ma tam wezla to zwracam -1 zeby nie naliczyc dodatkowych wezlow)
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

	public void displayKeys()
	{
		if (_root == null) {
			System.out.println("Brak elementow w drzewie");
		}
		else {
			displayKeys(_root, 0);
		}
	}
	
	private void displayKeys(Node node, int height)
	{
		if (node != null) {
			displayKeys(node.getRight(), height+1);
			
			for (int i=0; i<height; i++)
			{
				System.out.print("        ");
			}
			
			System.out.println(node.getKey());
			
			displayKeys(node.getLeft(), height+1);
		}
	}
	
	public int getSuccessor(int key)
	{
		Node successorNode = getSuccessor(_root, key);
		return successorNode == null ? -1 : successorNode.getKey();
	}
	
	private Node getSuccessor(Node node, int key)
	{
		if (node == null) {
			throw new NoSuchElementException();
		}
		
		if (node.getKey() == key) {
			if (node.getRight() != null) {
				return getMin(node.getRight());
			}
			else {
				return null;
			}
		}
		
		else if (node.getKey() > key) {
			Node retNode = getSuccessor(node.getLeft(), key);
			return retNode == null ? node : retNode;
		}
		
		else {
			return getSuccessor(node.getRight(), key);
		}
	}

	public int getPredecessor(int key)
	{
		Node predecessorNode = getPredecessor(_root, key);
		return predecessorNode == null ? -1 : predecessorNode.getKey();
	}
	
	private Node getPredecessor(Node node, int key)
	{
		if (node == null) {
			throw new NoSuchElementException();
		}
		
		// Poprzednik to bedzie max w lewym poddrzewie
		if (node.getKey() == key) {
			if (node.getLeft() != null) {
				return getMax(node.getLeft());
			}
			else {
				return null;
			}
		}
		
		// Poprzednik jest w prawym poddrzewie (lub obecny node jest poprzednikiem)
		else if (node.getKey() < key) {
			Node retNode = getPredecessor(node.getRight(), key);
			return retNode == null ? node : retNode;
		}
		
		// Idziemy dalej po lewym poddrzewie
		else {
			return getPredecessor(node.getLeft(), key);
		}
	}

	public void delete(int key)
	{
		_root = delete(key, _root);
	}
	
	private Node delete(int key, Node node) 
	{
		if (node == null) {
			throw new NoSuchElementException();
		}
		
		else {
			if (key < node.getKey()) {
				node.setLeft(delete(key, node.getLeft()));
			}
			else if (key > node.getKey()) {
				node.setRight(delete(key, node.getRight()));
			}
			else if (node.getLeft() != null && node.getRight() != null) {
				node.setRight(detachMin(node, node.getRight()));
			}
			else {
				node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
			}
		}
		
		return node;
	}
	
	private Node detachMin(Node del, Node node)
	{
		if (node.getLeft() != null) {
			node.setLeft(detachMin(del, node.getLeft()));
		}
		else {
			del.setKey(node.getKey());
			node = node.getRight();
		}
		
		return node;
	}

	public int getHeightSubtree(Node node)
	{
		return getHeight(node);
	}
	
	public int getNoNodesSubtree(Node node)
	{
		return 1 + getNoNodes(node);
	}
}

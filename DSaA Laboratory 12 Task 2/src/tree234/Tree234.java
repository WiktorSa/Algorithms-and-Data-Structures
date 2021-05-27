package tree234;
import java.util.NoSuchElementException;

public class Tree234 
{
	private Node root = new Node();
	private double noComparisions = 0;
	
	public void insert(int key)
	{
		Node node = root;
		while (true)
		{
			if (node.isFull()) {
				split(node);
				node = node.getParent();
				node = getNextChild(node, key);
			}
			else if (node.isLeaf()) {
				break;
			}
			else {
				node = getNextChild(node, key);
			}
		}
		
		node.insertKey(key);
	}
	
	private void split(Node node)
	{
		Integer itemC = node.removeItem();
		Integer itemB = node.removeItem();
		Node parent;
		Node child2 = node.disconnect(2);
		Node child3 = node.disconnect(3);
		Node newNode = new Node();
		
		if (node == root) {
			root = new Node();
			parent = root;
			root.connect(0, node);
		}
		else {
			parent = node.getParent();
		}
		
		int itemIndex = parent.insertKey(itemB);
		int noItems = parent.getNumItems();
		
		for (int j=noItems-1; j>itemIndex; j--)
		{
			Node temp = parent.disconnect(j);
			parent.connect(j+1, temp);
		}
		
		parent.connect(itemIndex+1, newNode);
		
		newNode.insertKey(itemC);
		newNode.connect(0, child2);
		newNode.connect(1, child3);
	}
	
	public Node find(Integer key)
	{
		Node node = root;
		while (true)
		{
			if (node.findItem(key) != null) {
				noComparisions += 1;
				return node;
			}
			else if (node.isLeaf()) {
				noComparisions += 2;
				return null;
			}
			else {
				noComparisions += 2;
				node = getNextChild(node, key);
			}
		}
	}
	
	public void displayTree()
	{
		recDisplayTree(root, 0, 0);
	}
	
	private void recDisplayTree(Node thisNode, int level, int childNumber)
	{
		System.out.println("level=" + level + " child=" + childNumber + " ");
		thisNode.displayNode();
		
		int numItems = thisNode.getNumItems();
		for (int j=0; j<numItems+1; j++)
		{
			Node nextNode = thisNode.getChild(j);
			if (nextNode != null) {
				recDisplayTree(nextNode, level+1, j);
			}
			else {
				return;
			}
		}
	}
	
	public Integer getMin()
	{
		return getMin(root);
	}
	
	private Integer getMin(Node node)
	{
		if (node == null) {
			return null;
		}
		
		if (node.getChild(0) != null) {
			return getMin(node.getChild(0));
		}
		
		return node.getKey(0);
	}
	
	public Integer getMax()
	{
		return getMax(root);
	}
	
	private Integer getMax(Node node)
	{
		if (node == null) {
			return null;
		}
		
		if (node.getnoChildrenNotNull() != 0 && node.getChild(node.getnoChildrenNotNull()-1) != null) {
			return getMax(node.getChild(node.getnoChildrenNotNull()-1));
		}
		
		return node.getKey(node.getNumItems()-1);
	}
	
	public Integer getSuccessor(int key)
	{
		return getSuccessor(root, key);
	}
	
	private Integer getSuccessor(Node node, int key)
	{
		if (node == null) {
			throw new NoSuchElementException();
		}
		
		for (int i=0; i<node.getNumItems(); i++)
		{
			if (node.getKey(i) == key) {
				// Child contains the successor
				if (node.getChild(i+1) != null) {
					return getMin(node.getChild(i+1));
				}
				
				// The next value in row is the successor
				else if (i+1 < node.getNumItems() && node.getKey(i+1) != null) {
					return node.getKey(i+1);
				}
				
				else {
					return null;
				}
			}
			
			// We move to the left to search for the successor
			else if (node.getKey(i) > key) {
				Integer retKey = getSuccessor(node.getChild(i), key);
				return retKey == null ? node.getKey(i) : retKey;
			}
			
			// The successor is either the next key in the same row or is in the child
			else if (i+1 < node.getNumItems() && node.getKey(i+1) != null && node.getKey(i+1) > key) {
				Integer retKey = getSuccessor(node.getChild(i+1), key);
				return retKey == null ? node.getKey(i+1) : retKey;
			}
			
			// We ran out of possible keys in the row so we our last option is to check the last child
			else if (i+1 == node.getNumItems()) {
				return getSuccessor(node.getChild(i+1), key);
			}
		}
		
		return null;
	}
	
	public Integer getPredecessor(Integer key)
	{
		return getPredecessor(root, key);
	}
	
	private Integer getPredecessor(Node node, int key)
	{
		if (node == null) {
			throw new NoSuchElementException();
		}
		
		for (int i=node.getNumItems()-1; i >= 0; i--)
		{
			if (node.getKey(i) == key) {
				// Child contains the predecessor
				if (node.getChild(i) != null) {
					return getMax(node.getChild(i));
				}
				
				// The previous value in row is the predecessor
				else if (i-1 >= 0 && node.getKey(i-1) != null) {
					return node.getKey(i-1);
				}
				
				else {
					return null;
				}
			}
			
			// We move to the right in search of the predecessor
			else if (node.getKey(i) < key) {
				Integer retKey = getPredecessor(node.getChild(i+1), key);
				return retKey == null ? node.getKey(i) : retKey;
			}
			
			// The precedessor is either the previous key in the row or is in the previous child
			else if (i-1 >= 0 && node.getKey(i-1) < key) {
				Integer retKey = getPredecessor(node.getChild(i), key);
				return retKey == null ? node.getKey(i-1) : retKey;
			}
			
			// We ran out of possible keys in the row so we our last option is to check the first child
			else if (i == 0) {
				return getPredecessor(node.getChild(i), key);
			}
		}
		
		return null;
	}	

	public Node getNextChild(Node node, int key)
	{
		int j=0;
		for (; j<node.getNumItems(); j++)
		{
			if (key < node.getKey(j)) {
				noComparisions += 1;
				return node.getChild(j);
			}
			noComparisions += 1;
		}
		
		return node.getChild(j);
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

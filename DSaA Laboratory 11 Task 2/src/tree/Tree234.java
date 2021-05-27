package tree;
import java.util.NoSuchElementException;

public class Tree234 
{
	Node root = new Node();
	
	public void insert(int key)
	{
		Node node = root;
		while (node != null)
		{
			if (node.isFull()) {
				split(node);
				node = node.getParent().getNextNode(key);
			}
			else if (node.isLeaf()) {
				break;
			}
			else {
				node = node.getNextNode(key);
			}
		}
		
		node.insertKey(key);
	}
	
	private void split(Node node)
	{
		int key1 = node.remove(1);
		int key2 = node.remove(2);
		Node child2 = node.disconnect(2);
		Node child3 = node.disconnect(3);
		
		Node newRight = new Node();
		newRight.insertKey(key2);
		newRight.connect(0, child2);
		newRight.connect(1, child3);
		
		if (node == root) {
			root = new Node();
			root.insertKey(key1);
	        root.connect(0, node);
	        root.connect(1, newRight);
	        node.setParent(root);
	        newRight.setParent(root);
		}
		else {
			int loc = node.getParent().insertKey(key1);
			Node parent = node.getParent();
			int i;
			for (i = node.getParent().getNumItems(); i > loc + 1; i--)
			{
				parent.connect(i, parent.getChild(i-1));
			}
			node.getParent().connect(i, newRight);
			newRight.setParent(parent);
		}
	}
	
	public Integer find(Integer key)
	{
		Node node = root;
		while (node != null)
		{
			Integer item = node.findItem(key);
			if (item == null) {
				node = node.getNextNode(key);
			}
			else {
				return item;
			}
		}
		
		return null;
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
}

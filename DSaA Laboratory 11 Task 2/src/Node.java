
public class Node 
{
	private static final Integer ORDER = 4;
	private Integer numItems = 0;
	private Integer noChildrenNotNull = 0;
	private Node parent;
	private Node childArray[] = new Node[ORDER];
	private Integer keyArray[] = new Integer[ORDER-1];
	
	public Integer findItem(Integer keyToFind)
	{
		for (Integer key : keyArray)
		{
			if (key != null && key.equals(keyToFind)) {
				return key;
			}
		}
		return null;
	}
	
	public void displayNode()
	{
		for (int i=0; i<numItems; i++)
		{
			System.out.print(keyArray[i] + " ");
		}
		System.out.println();
	}
	
	public Integer getNumItems()
	{
		return numItems;
	}
	
	public Integer getnoChildrenNotNull()
	{
		return noChildrenNotNull;
	}
	
	public Node getChild(int index)
	{
		return childArray[index];
	}
	
	public Integer getKey(int index)
	{
		return keyArray[index];
	}
	
	public Integer remove(int index)
	{
		int item = keyArray[index];
		keyArray[index] = null;
		numItems--;
		return item;
	}
	
	public Node disconnect(int index)
	{
		Node node = childArray[index];
		if (childArray[index] != null) {
			noChildrenNotNull--;
		}
		childArray[index] = null;
        return node;
	}
	
	public void connect(int index, Node node)
	{
		if (childArray[index] == null) {
			noChildrenNotNull++;
		}
		childArray[index] = node;
    }

    public Node getParent()
    {
        return parent;
    }

    public void setParent(Node node)
    {
        parent = node;
    }

    public boolean isFull()
    {
        return numItems == 3;
    }
    
    public int insertKey(int key)
    {
    	int i=0;
    	for(; i<numItems; i++)
    	{
    		if (key < keyArray[i]) {
    			for (int j=numItems; j > i; j--)
    			{
    				keyArray[j] = keyArray[j-1];
    			}
    			break;
    		}
    		else if (key == keyArray[i]) {
    			return -1;
    		}
    	}
    	keyArray[i] = key;
    	numItems++;
    	return i;
    }
    
    public Node getNextNode(int key)
    {
    	for (int i=0; i<numItems; i++)
    	{
    		if (key < keyArray[i]) {
    			return childArray[i];
    		}
    	}
    	return childArray[numItems];
    }
    
    public boolean isLeaf()
    {
    	return childArray[0] == null;
    }
}

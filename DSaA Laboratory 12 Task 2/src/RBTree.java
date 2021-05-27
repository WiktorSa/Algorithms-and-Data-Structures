public class RBTree 
{
	private NodeRBTree _root;
	private NodeRBTree TNULL;
	private double noComparision = 0;
	
	public RBTree() 
	{
		TNULL = new NodeRBTree(-1, "BLACK");
	    _root = TNULL;
	}
	
	private NodeRBTree getParent(NodeRBTree x)
	{
		// No parent
		if (x == _root) {
			return null;
		}
		
		NodeRBTree y = _root;
		
		while (y != TNULL)
		{
			if (y.getLeft() == x || y.getRight() == x) {
				return y;
			}
			
			// Parent is on the right
			if (y.getKey() < x.getKey()) {
				y = y.getRight();
			}
			
			else {
				y = y.getLeft();
			}
		}
		
		// Key wasn't found
		return null;
	}
	
	private NodeRBTree getGrandParent(NodeRBTree x)
	{
		// No grandparent
		if (x == _root || x == _root.getLeft() || x == _root.getRight()) {
			return null;
		}
		
		return getParent(getParent(x));
	}
	
	// Note - keys cannot repeat
	public void insert(int key) throws DuplicateElementException
	{
		NodeRBTree node = new NodeRBTree(key, "RED");
		node.setLeft(TNULL);
		node.setRight(TNULL);
		
		NodeRBTree y = null;
		NodeRBTree x = _root;
		
		while (x != TNULL) 
		{
			y = x;
			if (node.getKey() == x.getKey()) {
				throw new DuplicateElementException(node.getKey());
			}
			
			if (node.getKey() < x.getKey()) {
				x = x.getLeft();
			}
			else {
				x = x.getRight();
			}
		}
		
//		node.setParent(y);
		if (y == null) {
			_root = node;
		}
		else if (node.getKey() < y.getKey()) {
			y.setLeft(node);
		}
		else {
			y.setRight(node);
		}
		
		// Our new node is the root
		if (getParent(node) == null) {
			node.setColor("BLACK");
			return;
		}
		
		// If grandparent is also null simply return
		if (getGrandParent(node) == null) {
			return;
		}
		
		fixInsert(node);
	}
	
	private void fixInsert(NodeRBTree k)
	{
		NodeRBTree uncle;
		while (k != _root && getParent(k).getColor().equals("RED"))
		{
			if (getParent(k) == getGrandParent(k).getRight()) {
				uncle = getGrandParent(k).getLeft();
				
				if (uncle.getColor().equals("RED")) {
					uncle.setColor("BLACK");
					getParent(k).setColor("BLACK");
					getGrandParent(k).setColor("RED");
					k = getGrandParent(k);
				}
				else {
					if (k == getParent(k).getLeft()) {
						k = getParent(k);
						rightRotate(k);
					}
					
					getParent(k).setColor("BLACK");
					getGrandParent(k).setColor("RED");
					leftRotate(getGrandParent(k));
				}
			}
			else {
				uncle = getGrandParent(k).getRight();
				
				if (uncle.getColor().equals("RED")) {
					uncle.setColor("BLACK");
					getParent(k).setColor("BLACK");
					getGrandParent(k).setColor("RED");
					k = getGrandParent(k);
				}
				
				else {
					if (k == getParent(k).getRight()) {
						k = getParent(k);
						leftRotate(k);
					}
					
					getParent(k).setColor("BLACK");
					getGrandParent(k).setColor("RED");
					rightRotate(getGrandParent(k));
				}
			}
		}
		
		_root.setColor("BLACK");
	}
	
	// Commenting all parts where you set the parent - we don't have connection to the parent
	private void leftRotate(NodeRBTree x)
	{
		NodeRBTree y = x.getRight();
		x.setRight(y.getLeft());
		if (y.getLeft() != TNULL) {
//			y.getLeft().setParent(x);
		}
		
//		y.setParent(x.getParent());
		
		if (getParent(x) == null) {
			_root = y;
		}
		else if (x == getParent(x).getLeft()) {
			getParent(x).setLeft(y);
		}
		else {
			getParent(x).setRight(y);
		}
		
		y.setLeft(x);
//		x.setParent(y);
	}
	
	private void rightRotate(NodeRBTree x)
	{
		NodeRBTree y = x.getLeft();
		x.setLeft(y.getRight());
		
		if (y.getRight() != TNULL) {
//			y.getRight().setParent(x);
		}
		
//		y.setParent(x.getParent());
		if (getParent(x) == null) {
			_root = y;
		}
		else if (x == getParent(x).getRight()) {
			getParent(x).setRight(y);
		}
		else {
			getParent(x).setLeft(y);
		}
		
		y.setRight(x);
//		x.setParent(y);
	}
	
	public NodeRBTree findNode(int key)
	{
		NodeRBTree temp = _root;
		while (temp != null)
		{
			if (temp.getKey() == key) {
				noComparision += 1;
				return temp;
			}
			else if (temp.getKey() < key) {
				noComparision += 2;
				temp = temp.getRight();
			}
			else {
				noComparision += 2;
				temp = temp.getLeft();
			}
		}
		
		return null;
	}
	
	public void inOrderWalk()
	{
		inOrderWalk(_root);
	}
	
	private void inOrderWalk(NodeRBTree node)
	{
		if (node != TNULL) {
			inOrderWalk(node.getLeft());
			System.out.println(node.getKey() + " " + node.getColor());
			inOrderWalk(node.getRight());
		}
	}
	
	public void preOrderWalk()
	{
		preOrderWalk(_root);
	}
	
	private void preOrderWalk(NodeRBTree node)
	{
		if (node != TNULL) {
			System.out.println(node.getKey() + " " + node.getColor());
			preOrderWalk(node.getLeft());
			preOrderWalk(node.getRight());
		}
	}
	
	public void postOrderWalk()
	{
		postOrderWalk(_root);
	}
	
	private void postOrderWalk(NodeRBTree node)
	{
		if (node != TNULL) {
			postOrderWalk(node.getLeft());
			postOrderWalk(node.getRight());
			System.out.println(node.getKey() + " " + node.getColor());
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
	
	private void displayKeys(NodeRBTree node, int height)
	{
		if (node != TNULL) {
			displayKeys(node.getRight(), height+1);
			
			for (int i=0; i<height; i++)
			{
				System.out.print("          ");
			}
			
			System.out.println(node.getKey() + "\\" + node.getColor());
			
			displayKeys(node.getLeft(), height+1);
		}
	}
	
	// Overall height
	public int getHeight()
	{
		return getHeight(_root);
	}
	
	public int getHeightLeftSubtree()
	{
		if (_root == TNULL) {
			System.out.println("To drzewo jest puste");
		}
		
		return getHeight(_root.getLeft());
	}
	
	public int getHeightRightSubtree()
	{
		if (_root == TNULL) {
			System.out.println("To drzewo jest puste");
		}
		
		return getHeight(_root.getRight());
	}
	
	// Ide po kazdym z wezlow i szukam polaczenia, ktore jest najdluzsze
	private int getHeight(NodeRBTree node)
	{
		if (node == TNULL) {
			return 0;
		}
		
		else {
			int leftHeight = getHeight(node.getLeft());
			int rightHeight = getHeight(node.getRight());
			
			return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
		}
	}
	
	// Overall no nodes
	public int getNoNodes()
	{
		return 1 + getNoNodes(_root);
	}
	
	public int getNoNodesLeftSubtree()
	{
		if (_root == TNULL) {
			System.out.println("To drzewo jest puste");
		}
		
		return 1 + getNoNodes(_root.getLeft());
	}
	
	public int getNoNodesRightSubtree()
	{
		if (_root == TNULL) {
			System.out.println("To drzewo jest puste");
		}
		
		return 1 + getNoNodes(_root.getRight());
	}
	
	// Ide po kazdym z wezlow i licze rekurencyjnie liczbe wezlow
	private int getNoNodes(NodeRBTree node)
	{
		// Licze w przyszlosc liczbe wezlow (wiec jak nie ma tam wezla to zwracam -1 zeby nie naliczyc dodatkowych wezlow)
		if (node == TNULL) {
			return -1;
		}
		else {
			int noNodesLeft = 1 + getNoNodes(node.getLeft());
			int noNodesRight = 1 + getNoNodes(node.getRight());
			
			return noNodesLeft + noNodesRight;
		}
	}
	
	public void deleteNode(int key)
	{
		deleteNodeHelper(_root, key);
	}
	
	// Commented all the parts that had the connection to the parent
	private void deleteNodeHelper(NodeRBTree node, int key)
	{
		NodeRBTree z = TNULL;
		NodeRBTree x, y;
		while (node != TNULL)
		{
			if (node.getKey() == key) {
				z = node;
			}
			
			if (node.getKey() <= key) {
				node = node.getRight();
			}
			
			else {
				node = node.getLeft();
			}
		}
		
		if (z == TNULL) {
			System.out.println("Nie ma takiego wezla");
			return;
		}
		
		y = z;
		String yOriginalColor = y.getColor();
		if (z.getLeft() == TNULL) {
			x = z.getRight();
			rbTransplant(z, z.getRight());
		}
		else if (z.getRight() == TNULL) {
			x = z.getLeft();
			rbTransplant(z, z.getLeft());
		}
		else {
			y = minimum(z.getRight());
			yOriginalColor = y.getColor();
			x = y.getRight();
			if (getParent(y) == z) {
//				x.setParent(y);
			}
			else {
				rbTransplant(y, y.getRight());
				y.setRight(z.getRight());
//				y.getRight().setParent(y);
			}
			
			rbTransplant(z, y);
			y.setLeft(z.getLeft());
//			y.getLeft().setParent(y);
			y.setColor(z.getColor());
		}
		
		if (yOriginalColor.equals("BLACK")) {
			fixDelete(x);
		}
	}
	
	// Commented all the parts that had the connection to the parent
	private void rbTransplant(NodeRBTree u, NodeRBTree v)
	{
		if (getParent(u) == null) {
			_root = v;
		}
		else if (u == getParent(u).getLeft()) {
			getParent(u).setLeft(v);
		}
		else {
			getParent(u).setRight(v);
		}
//		v.setParent(u.getParent());
	}
	
	public NodeRBTree minimum(NodeRBTree node) 
	{
		while (node.getLeft() != TNULL) 
		{
			node = node.getLeft();
		}
		
		return node;
	}
	
	// Commented all the parts that had the connection to the parent
	private void fixDelete(NodeRBTree x)
	{
		NodeRBTree s;
		while (x != _root && x.getColor().equals("BLACK"))
		{
			if (x == getParent(x).getLeft()) {
				s = getParent(x).getRight();
				if (s.getColor().equals("RED")) {
					s.setColor("BLACK");
					getParent(x).setColor("RED");
					leftRotate(getParent(x));
					s = getParent(x).getRight();
				}
				
				if (s.getLeft().getColor().equals("BLACK") && s.getRight().getColor().equals("BLACK")) {
					s.setColor("RED");
					x = getParent(x);
				}
				else {
					if (s.getRight().getColor().equals("BLACK")) {
						s.getLeft().setColor("BLACK");
						s.setColor("RED");
						rightRotate(s);
						s = getParent(x).getRight();
					}
					
					s.setColor(getParent(x).getColor());
					getParent(x).setColor("BLACK");
					s.getRight().setColor("BLACK");
					leftRotate(getParent(x));
					x = _root;
				}
			}
			else {
				s = getParent(x).getLeft();
				if (s.getColor().equals("RED")) {
					s.setColor("BLACK");
					getParent(x).setColor("RED");
					rightRotate(getParent(x));
					s = getParent(x).getLeft();
				}
				
				if (s.getRight().getColor().equals("BLACK") && s.getRight().getColor().equals("BLACK")) {
					s.setColor("RED");
					x = getParent(x);
				}
				else {
					if (s.getLeft().getColor().equals("BLACK")) {
						s.getRight().setColor("BLACK");
						s.setColor("RED");
						leftRotate(s);
						s = getParent(x).getLeft();
					}
					
					s.setColor(getParent(x).getColor());
					getParent(x).setColor("BLACK");
					s.getLeft().setColor("BLACK");
					rightRotate(getParent(x));
					x = _root;
				}
			}
		}
		x.setColor("BLACK");
	}

	public double getNoComparision() 
	{
		return noComparision;
	}
	
	public void setNoComparision(double noComparision) 
	{
		this.noComparision = noComparision;
	}
	
}

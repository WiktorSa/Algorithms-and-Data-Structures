
public class Lab111Main 
{
	public static void main(String[] args) 
	{
		RBTree rbTree = new RBTree();
		System.out.println("Pierwotny wyglad drzewa (elementy wstawiane tak, aby nie bylo potrzeby naprawy drzewa)");
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
		System.out.println("\nWyglad drzewa po wstawieniu 35\n");
		rbTree.displayKeys();;
		
		try 
		{
			rbTree.insert(49);
		} 
		catch (DuplicateElementException e) 
		{
			e.printStackTrace();
		}
		System.out.println("\nWyglad drzewa po wstawieniu 49\n");
		rbTree.displayKeys();
		
		try 
		{
			rbTree.insert(37);
		} 
		catch (DuplicateElementException e) 
		{
			e.printStackTrace();
		}
		System.out.println("\nWyglad drzewa po wstawieniu 37\n");
		rbTree.displayKeys();
		System.out.println("\nZnalezenie wezla o kluczu 37: " + rbTree.findNode(37).getKey());
		System.out.println("\nPorzadek inorder");
		rbTree.inOrderWalk();
		System.out.println("\nPorzadek preorder");
		rbTree.preOrderWalk();
		System.out.println("\nPorzadek postorder");
		rbTree.postOrderWalk();
		System.out.println("\nWysokosc drzewa: " + rbTree.getHeight());
		System.out.println("Wysokosc lewego poddrzewa: " + rbTree.getHeightLeftSubtree());
		System.out.println("Wysokosc prawego poddrzewa: " + rbTree.getHeightRightSubtree());
		System.out.println("Liczba wezlow drzewa: " + rbTree.getNoNodes());
		System.out.println("Liczba wezlow lewego poddrzewa: " + rbTree.getNoNodesLeftSubtree());
		System.out.println("Liczba wezlow prawego poddrzewa: " + rbTree.getNoNodesRightSubtree());
	
		rbTree.deleteNode(37);
		System.out.println("\nDrzewo po skasowaniu wezla 37\n");
		rbTree.displayKeys();
		
		rbTree.deleteNode(49);
		System.out.println("\nDrzewo po skasowaniu wezla 49\n");
		rbTree.displayKeys();
		
		rbTree.deleteNode(35);
		System.out.println("\nDrzewo po skasowaniu wezla 35\n");
		rbTree.displayKeys();
		
	}
}

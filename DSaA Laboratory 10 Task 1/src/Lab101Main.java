
public class Lab101Main 
{
	public static void main(String[] args) 
	{
		BSTTree bstTree = new BSTTree();
		System.out.println("Wstawiamy do drzewa wartosci 7, 5, 10, 3, 8, 12 w podanej kolejnosci");
		try 
		{
			bstTree.insert(7);
			bstTree.insert(5);
			bstTree.insert(10);
			bstTree.insert(3);
			bstTree.insert(8);
			bstTree.insert(12);
		} 
		catch (DuplicateElementException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println("Wyswietlenie kluczy w porzadku inorder");
		bstTree.inOrderWalk();
		System.out.println("\nWyswietlenie kluczy w porzadku preorder");
		bstTree.preOrderWalk();
		System.out.println("\nWyswietlenie kluczy w porzadku postorder");
		bstTree.postOrderWalk();
		
		System.out.println("\nZnajdowanie wezla o kluczu 7");
		System.out.println(bstTree.findNode(7));
		System.out.println("Znajdowanie wezla o kluczu 1");
		System.out.println(bstTree.findNode(1));
		
		System.out.println("Znajdowanie minimalnego klucza");
		System.out.println(bstTree.getMin());
		System.out.println("Znajdowanie maskymalnego klucza");
		System.out.println(bstTree.getMax());
		System.out.println("Znajdowanie wysokosci drzewa");
		System.out.println(bstTree.getHeight());
		System.out.println("Znajdowanie liczby wezlow");
		System.out.println(bstTree.getNoNodes());
		System.out.println("Znajdowanie liczby lisci");
		System.out.println(bstTree.getNoLeaves());
	}

}

import java.util.InputMismatchException;
import java.util.Scanner;

public class TextGUI 
{
	private BSTTree bstTree;
	
	public TextGUI(BSTTree bstTree)
	{
		this.bstTree = bstTree;
	}
	
	@SuppressWarnings("resource")
	public void startGUI()
	{
		boolean isFinished  = false;
		boolean displayInstructions = true;
		Scanner scanner = new Scanner(System.in);
		
		while (!isFinished)
		{
			if (displayInstructions) {
				System.out.println("Witamy w GUI. Wybierz opcje");
				System.out.println("0 - wyjdz");
				System.out.println("1 - wstaw wezel o podanym kluczu");
				System.out.println("2 - wyswietl klucze w porzadku inorder/preorder/postorder");
				System.out.println("3 - znajdz wezel o wskazanym kluczu");
				System.out.println("4 - znajdz klucz minimalny/maksymalny");
				System.out.println("5 - wyswietl wysokosc/liczbe wezlow/liczbe lisci drzewa");
				System.out.println("6 - wyswietl klucze (wartosci) poziomami");
				System.out.println("7 - wyszukaj nastepnika wskazanego wezla");
				System.out.println("8 - wyszukaj poprzednika wskazanego wezla");
				System.out.println("9 - usun wezel o wskazanym kluczu");
				System.out.println("10 - wyznacz wysokosc i liczbe wezlow dla kazdego poddrzewa (podajac wezel drzewa)");
				System.out.println("11 - Narysuj drzewo w trybie tekstowym");
				displayInstructions = false;
			}
			
			System.out.print("Wybierz opcje (celem przypomnienia instrukcji wpisz -1): ");
			int option = 0;
			try 
			{
				option = scanner.nextInt();
			} 
			catch (InputMismatchException e) 
			{
				System.out.println("Wybierz poprawna opcje");
				option = -2;
			}
			
			switch (option) {
			case 1:
				insert();
				break;
				
			case 2:
				displayAllOrders();
				break;
				
			case 3:
				findNode();
				break;
				
			case 4:
				displayMinAndMax();
				break;
				
			case 5:
				displayTreeParameters();
				break;
				
			case 6:
				displayKeys();
				break;
				
			case 7:
				displaySuccessor();
				break;
				
			case 8:
				displayPredecessor();
				break;
				
			case 9:
				deleteNode();
				break;
				
			case 10:
				displayHeightAndNoNodesForSubtree();
				break;
			
			case 11:
				drawTree();
				break;
				
			case 0:
				System.out.println("Konczenie pracy programu");
				isFinished = true;
				break;
				
			case -1:
				displayInstructions = true;
				break;

			default:
				System.out.println("Wybierz poprawna opcje");
				break;
			}
			System.out.println();
		}
	}
	
	@SuppressWarnings("resource")
	private void insert()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Podaj klucz do wstawienia w wezel: ");
		int key = scanner.nextInt();
		try 
		{
			bstTree.insert(key);
			System.out.println("Wpisano klucz: " + key);
		} 
		catch (DuplicateElementException e) 
		{
			System.out.println("Ten klucz juz jest w drzewie: " + key);
		}
	}
	
	private void displayAllOrders()
	{
		System.out.println("Klucze w porzadku inorder");
		bstTree.inOrderWalk();
		System.out.println("\nKlucze w porzadku preorder");
		bstTree.preOrderWalk();
		System.out.println("\nKlucze w porzadku postorder");
		bstTree.postOrderWalk();
		System.out.println();
	}
	
	@SuppressWarnings("resource")
	private void findNode()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Podaj klucz wezla do znalezenia w drzewie: ");
		int key = scanner.nextInt();
		Node foundNode = bstTree.findNode(key);
		if (foundNode != null) {
			System.out.println("Znaleziono wezel: " + foundNode.getKey());
		}
		else {
			System.out.println("Wezla nie znaleziono");
		}
	}
	
	private void displayMinAndMax()
	{
		System.out.println("Minimalna wartosc klucza: " + bstTree.getMin());
		System.out.println("Maksymalna wartosc klucza: " + bstTree.getMax());
	}
	
	private void displayTreeParameters()
	{
		System.out.println("Wysokosc drzewa: " + bstTree.getHeight());
		System.out.println("Licza wezlow: " + bstTree.getNoNodes());
		System.out.println("Liczba lisci: " + bstTree.getNoLeaves());
	}
	
	private void displayKeys()
	{
		bstTree.displayKeys();
	}
	
	@SuppressWarnings("resource")
	private void displaySuccessor()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Podaj klucz, ktorego nastepnika szukasz: ");
		int key = scanner.nextInt();
		int foundKey = bstTree.getSuccessor(key);
		if (foundKey != -1) {
			System.out.println("Nastepnik: " + foundKey);
		}
		else {
			System.out.println("Brak nastepnika");
		}
	}
	
	@SuppressWarnings("resource")
	private void displayPredecessor()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Podaj klucz, ktorego poprzednika szukasz: ");
		int key = scanner.nextInt();
		int foundKey = bstTree.getPredecessor(key);
		if (foundKey != -1) {
			System.out.println("Poprzednik: " + foundKey);
		}
		else {
			System.out.println("Brak nastepnika");
		}
	}
	
	@SuppressWarnings("resource")
	private void deleteNode()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Podaj klucz, ktory chcesz skasowac z drzewa: ");
		int key = scanner.nextInt();
		bstTree.delete(key);
		System.out.println("Usunieto dany klucz z drzewa");
	}

	@SuppressWarnings("resource")
	private void displayHeightAndNoNodesForSubtree()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Podaj klucz wezla dla ktorego chcesz zbadac poddrzewa: ");
		int key = scanner.nextInt();
		Node foundNode = bstTree.findNode(key);
		if (foundNode != null) {
			System.out.println("Parametry poddrzew wezla: " + foundNode.getKey());
			System.out.println("Wysokosc lewego poddrzewa: " + bstTree.getHeightSubtree(foundNode.getLeft()));
			System.out.println("Liczba wezlow lewego poddrzewa: " + bstTree.getNoNodesSubtree(foundNode.getLeft()));
			System.out.println("Wysokosc prawego poddrzewa: " + bstTree.getHeightSubtree(foundNode.getRight()));
			System.out.println("Liczba wezlow prawego poddrzewa: " + bstTree.getNoNodesSubtree(foundNode.getRight()));
		}
		else {
			System.out.println("Nie ma takiego wezla w drzewie");
		}
	}
	
	private void drawTree()
	{
		BSTTreePrinter bstTreePrinter = new BSTTreePrinter(bstTree);
		bstTreePrinter.print();
	}
}

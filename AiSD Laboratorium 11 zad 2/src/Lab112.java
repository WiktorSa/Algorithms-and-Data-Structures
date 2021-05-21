
public class Lab112 
{
	public static void main(String[] args) 
	{
		Tree234 tree = new Tree234();
        tree.insert(100);
        tree.insert(10);
        tree.insert(200);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(50);
        tree.insert(5);
        System.out.println("Wyswietlenie drzewa po wstawieniu kluczy 100, 10, 200, 30, 20, 40, 50, 5 w podanej kolejnosci");
        tree.displayTree();
        tree.insert(78);
        tree.insert(23);
        System.out.println("\nWyswietlenie drzewa po wstawieniu kluczy 78, 23 w podanej kolejnosci");
        tree.displayTree();
        System.out.println();
        System.out.println("Znalezenie wezla o kluczu 50: " + tree.find(50));
        System.out.println("Znalezenia wezla o kluczu 220: " + tree.find(220));
        System.out.println("Klucz minimalny: " + tree.getMin());
        System.out.println("Klucz maksymalny: " + tree.getMax());
        System.out.println("Nastepnik klucza 20: " + tree.getSuccessor(20));
        System.out.println("Poprzednik klucza 20: " + tree.getPredecessor(20));
	}

}

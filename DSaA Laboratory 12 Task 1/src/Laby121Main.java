

public class Laby121Main 
{

	// Czytasz wszystko od prawej do lewej (czyli 8 to parent[3] itd.)
	public static void main(String[] args) 
	{
		System.out.println("Analiza zbioru rozlacznego na bazie tablicy");
		DisjointSetArrayNotCompressing disjointSetArrayNotCompressing = new DisjointSetArrayNotCompressing(10);
		
		System.out.println("Poczatkowy wyglad zbioru. Strzalka oznacza, ze kolejny element jest rodzicem poprzedniego\nStrzalka prowadzaca donikad oznacza, ze element jest sam dla siebie rodzicem");
		disjointSetArrayNotCompressing.printSet();
		
		System.out.println("\nWykonujemy podstawowe operacje na zbiorze tak, zeby nie bylo potrzeby kompresji sciezki");
		System.out.println("\nUczynienie 7 rodzicem 9");
		disjointSetArrayNotCompressing.union(9, 7);
		disjointSetArrayNotCompressing.printSet();
		System.out.println("\nUczynienie 7 rodzicem 8.");
		disjointSetArrayNotCompressing.union(8, 7);
		disjointSetArrayNotCompressing.printSet();
		System.out.println("\nUczynienie 2 rodzicem 3");
		disjointSetArrayNotCompressing.union(3, 2);
		disjointSetArrayNotCompressing.printSet();
		System.out.println("\nUczynienie 2 rodzicem 7. Zauwazmy, ze elementy 8 i 9 beda mialy relacje z ta 2");
		disjointSetArrayNotCompressing.union(7, 2);
		disjointSetArrayNotCompressing.printSet();
		System.out.println("\nUczynienie 4 rodzicem 5");
		disjointSetArrayNotCompressing.union(5, 4);
		disjointSetArrayNotCompressing.printSet();
		System.out.println("\nUczynienie 1 rodzicem 5. Zauwazmy, ze 1 polaczy sie z 4, a nie z 5, bo 4 jest rodzicem 5");
		disjointSetArrayNotCompressing.union(5, 1);
		disjointSetArrayNotCompressing.printSet();
		System.out.println("\nUczynienie 1 rodzicem 2");
		disjointSetArrayNotCompressing.union(2, 1);
		disjointSetArrayNotCompressing.printSet();
		
		System.out.println("\nWykonujemy operacje find na elemencie 7. Powinnysmy dostac 1, bo ono jest w 'najwyzszej relacji' z 7: " + disjointSetArrayNotCompressing.find(7));
		System.out.println("Z powodu braku kompresji sciezek nie zauwazymy zadnych zmian");
		disjointSetArrayNotCompressing.printSet();
		
		
		System.out.println("\nZauwazmy, ze jezeli wykonamy operacje find na elemencie 7 w tablicy z kompresja sciezki \nto skroci sie droga elementu 7 do elementu 1 (nie bedzie elementu 2 na drodze) oraz elementow dla ktorych 7 jest rodzicem");
		DisjointSetArray disjointSetArray = new DisjointSetArray(10);
		disjointSetArray.union(9, 7);
		disjointSetArray.union(8, 7);
		disjointSetArray.union(3, 2);
		disjointSetArray.union(7, 2);
		disjointSetArray.union(5, 4);
		disjointSetArray.union(5, 1);
		disjointSetArray.union(2, 1);
		disjointSetArray.find(7);
		disjointSetArray.printSet();
		
		System.out.println("\nAnaliza zbioru rozlacznego na bazie drzewa");
		DisjointSetTreeCompressingPaths disjointSetTreeCompressingPaths = new DisjointSetTreeCompressingPaths(10);
		System.out.println("Poczatkowy wyglad zbioru (Kolejny element w sciezce to rodzic poprzedniego. Ostatni element jest sam dla siebie rodzicem)");
		disjointSetTreeCompressingPaths.printSet();
		
		System.out.println("\nWyglad zbioru po wykonacji operacji union (operacje union sa takie same jak w przypadku tablicy)");
		disjointSetTreeCompressingPaths.union(9, 7);
		disjointSetTreeCompressingPaths.union(8, 7);
		disjointSetTreeCompressingPaths.union(3, 2);
		disjointSetTreeCompressingPaths.union(7, 2);
		disjointSetTreeCompressingPaths.union(5, 4);
		disjointSetTreeCompressingPaths.union(5, 1);
		disjointSetTreeCompressingPaths.union(2, 1);
		
		System.out.println("\nWyglad zbioru po wykonacji operacji union (dostaniemy to samo co w przypadku tablicy)");
		disjointSetTreeCompressingPaths.printSet();
		System.out.println("\nWykonujemy operacje find na elemencie 7. Dostaniemy to samo co w przypadku tablicy: " + disjointSetTreeCompressingPaths.find(7).getValue());
		System.out.println("Zauwazmy, ze dochodzi do tej samej kompresji sciezki jak w przypadku tablicy z kompresja sciezki");
		disjointSetTreeCompressingPaths.printSet();
		
		System.out.println("\nZalozmy, ze mamy nastepujace drzewo gdzie 3 jest rodzicem 2, 2 rodzicem 1, a 5 rodzicem 6");
		disjointSetTreeCompressingPaths.makeSet();
		disjointSetTreeCompressingPaths.union(6, 5);
		disjointSetTreeCompressingPaths.union(3, 2);
		disjointSetTreeCompressingPaths.union(2, 1);
		disjointSetTreeCompressingPaths.printSet();
		System.out.println("\nZalozmy, ze chcemy utworzyc relacje miedzy 1 a 5. Mozemy to zrobic na dwa sposoby");
		System.out.println("Metoda 1. union(5, 1)");
		disjointSetTreeCompressingPaths.union(5, 1);
		disjointSetTreeCompressingPaths.printSet();
		System.out.println("\nMetoda 2. union(1, 5)");
		disjointSetTreeCompressingPaths.makeSet();
		disjointSetTreeCompressingPaths.union(6, 5);
		disjointSetTreeCompressingPaths.union(3, 2);
		disjointSetTreeCompressingPaths.union(2, 1);
		disjointSetTreeCompressingPaths.union(1, 5);
		disjointSetTreeCompressingPaths.printSet();
		System.out.println("\nZauwazmy, ze wysokosci obu drzew sie roznia w zaleznosci od wykonanej operacji.");
		
		System.out.println("W drzewie rownowazacym relacja pomiedzy dwoma relacjami jest tak ustalana, zeby koncowe drzewo mialo jak najmniejsza wysokosc");
		System.out.println("\nMetoda 1. union (5, 1)");
		DisjointSetTreeStabilization disjointSetTreeStabilization = new DisjointSetTreeStabilization(10);
		disjointSetTreeStabilization.union(6, 5);
		disjointSetTreeStabilization.union(3, 2);
		disjointSetTreeStabilization.union(2, 1);
		disjointSetTreeStabilization.union(1, 5);
		disjointSetTreeStabilization.printSet();
		System.out.println("\nMetoda 2. union (1, 5)");
		disjointSetTreeStabilization.makeSet();
		disjointSetTreeStabilization.union(6, 5);
		disjointSetTreeStabilization.union(3, 2);
		disjointSetTreeStabilization.union(2, 1);
		disjointSetTreeStabilization.union(5, 1);
		disjointSetTreeStabilization.printSet();
		System.out.println("\nWidzimy, ze obie operacje zwrocily to samo (i bylo to drzewo z najmniejsza wysokoscia)");
		System.out.println("\n\nTak konczymy analize roznych operacji na zbiorach rozlacznych (z roznymi ulepszeniami)");
	}

}

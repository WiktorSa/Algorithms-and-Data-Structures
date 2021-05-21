import java.util.Random;

public class Lab92Main 
{
	
	public static void main(String[] args) 
	{
		Random random = new Random(101);
		int[] valuesToInput = new int[900];
		LinearHash linearHash = new LinearHash();
		QuadraticHash quadraticHash = new QuadraticHash();
		DoubleHash doubleHash = new DoubleHash();
		
		for (int i=0; i<900; i++)
		{
			valuesToInput[i] = random.nextInt(10000);
		}
		
		for (int i=0; i<700; i++)
		{
			int value = valuesToInput[i];
			linearHash.put(value);
			quadraticHash.put(value);
			doubleHash.put(value);
		}
		
		// Kazdy test jest przeprowadzony na 500 liczbach nalezacych do tablicy oraz 500 liczbach nienalezacych do tablicy
		
		System.out.println("Testy dla wypelnienia 0.7\n");
		for (int i=0; i<500; i++)
		{
			int value1 = valuesToInput[random.nextInt(700)];
			int value2 = 10000 + random.nextInt(10000);
					
			linearHash.get(value1);
			linearHash.get(value2);
			quadraticHash.get(value1);
			quadraticHash.get(value2);
			doubleHash.get(value1);
			doubleHash.get(value2);
		}
		System.out.println("Probkowanie liniowe");
		System.out.println("Srednia liczba prob (wyszukiwania trafione) : " + linearHash.getAverageNoTriesSuccess());
		System.out.println("Srednia liczba prob (wyszukiwania chybione) : " + linearHash.getAverageNoTriesFail());
		System.out.println("Srednia liczba prob : " + linearHash.getAverageNoTries() + "\n");
		
		System.out.println("Probkowanie kwadratowe");
		System.out.println("Srednia liczba prob (wyszukiwania trafione) : " + quadraticHash.getAverageNoTriesSuccess());
		System.out.println("Srednia liczba prob (wyszukiwania chybione) : " + quadraticHash.getAverageNoTriesFail());
		System.out.println("Srednia liczba prob : " + quadraticHash.getAverageNoTries() + "\n");
		
		System.out.println("Podwojne haszowanie");
		System.out.println("Srednia liczba prob (wyszukiwania trafione) : " + doubleHash.getAverageNoTriesSuccess());
		System.out.println("Srednia liczba prob (wyszukiwania chybione) : " + doubleHash.getAverageNoTriesFail());
		System.out.println("Srednia liczba prob : " + doubleHash.getAverageNoTries() + "\n");
		
		linearHash.resetResults();
		quadraticHash.resetResults();
		doubleHash.resetResults();
		
		System.out.println("Testy dla wypelnienia 0.8\n");
		for (int i=0; i<100; i++)
		{
			int value = valuesToInput[700 + i];
			linearHash.put(value);
			quadraticHash.put(value);
			doubleHash.put(value);
		}
		
		for (int i=0; i<500; i++)
		{
			int value1 = valuesToInput[random.nextInt(800)];
			int value2 = 10000 + random.nextInt(10000);
					
			linearHash.get(value1);
			linearHash.get(value2);
			quadraticHash.get(value1);
			quadraticHash.get(value2);
			doubleHash.get(value1);
			doubleHash.get(value2);
		}
		System.out.println("Probkowanie liniowe");
		System.out.println("Srednia liczba prob (wyszukiwania trafione) : " + linearHash.getAverageNoTriesSuccess());
		System.out.println("Srednia liczba prob (wyszukiwania chybione) : " + linearHash.getAverageNoTriesFail());
		System.out.println("Srednia liczba prob : " + linearHash.getAverageNoTries() + "\n");
		
		System.out.println("Probkowanie kwadratowe");
		System.out.println("Srednia liczba prob (wyszukiwania trafione) : " + quadraticHash.getAverageNoTriesSuccess());
		System.out.println("Srednia liczba prob (wyszukiwania chybione) : " + quadraticHash.getAverageNoTriesFail());
		System.out.println("Srednia liczba prob : " + quadraticHash.getAverageNoTries() + "\n");
		
		System.out.println("Podwojne haszowanie");
		System.out.println("Srednia liczba prob (wyszukiwania trafione) : " + doubleHash.getAverageNoTriesSuccess());
		System.out.println("Srednia liczba prob (wyszukiwania chybione) : " + doubleHash.getAverageNoTriesFail());
		System.out.println("Srednia liczba prob : " + doubleHash.getAverageNoTries() + "\n");
		
		linearHash.resetResults();
		quadraticHash.resetResults();
		doubleHash.resetResults();

		System.out.println("Testy dla wypelnienia 0.9\n");
		for (int i=0; i<100; i++)
		{
			int value = valuesToInput[800 + i];
			linearHash.put(value);
			quadraticHash.put(value);
			doubleHash.put(value);
		}
		
		for (int i=0; i<500; i++)
		{
			int value1 = valuesToInput[random.nextInt(900)];
			int value2 = 10000 + random.nextInt(10000);
					
			linearHash.get(value1);
			linearHash.get(value2);
			quadraticHash.get(value1);
			quadraticHash.get(value2);
			doubleHash.get(value1);
			doubleHash.get(value2);
		}
		System.out.println("Probkowanie liniowe");
		System.out.println("Srednia liczba prob (wyszukiwania trafione) : " + linearHash.getAverageNoTriesSuccess());
		System.out.println("Srednia liczba prob (wyszukiwania chybione) : " + linearHash.getAverageNoTriesFail());
		System.out.println("Srednia liczba prob : " + linearHash.getAverageNoTries() + "\n");
		
		System.out.println("Probkowanie kwadratowe");
		System.out.println("Srednia liczba prob (wyszukiwania trafione) : " + quadraticHash.getAverageNoTriesSuccess());
		System.out.println("Srednia liczba prob (wyszukiwania chybione) : " + quadraticHash.getAverageNoTriesFail());
		System.out.println("Srednia liczba prob : " + quadraticHash.getAverageNoTries() + "\n");
		
		System.out.println("Podwojne haszowanie");
		System.out.println("Srednia liczba prob (wyszukiwania trafione) : " + doubleHash.getAverageNoTriesSuccess());
		System.out.println("Srednia liczba prob (wyszukiwania chybione) : " + doubleHash.getAverageNoTriesFail());
		System.out.println("Srednia liczba prob : " + doubleHash.getAverageNoTries() + "\n");
		
		linearHash.resetResults();
		quadraticHash.resetResults();
		doubleHash.resetResults();
	}

}

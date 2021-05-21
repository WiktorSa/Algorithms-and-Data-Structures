public class Lab81Main 
{
	// Displaying heap so that it would be easy to see that the property of the heap are preserved
	public static void displayHeap(HeapPriorityQueue heapPriorityQueue)
	{
		// How many items to display in a row
		int sizeOfRow = 1;
		// Index of our array
		int index = 0;
		while (index < heapPriorityQueue.size())
		{
			int numberElementsDisplayed = 0;
			while (index < heapPriorityQueue.size() && numberElementsDisplayed < sizeOfRow)
			{
				try 
				{
					System.out.print(heapPriorityQueue.getIndex(index) + " ");
				} 
				catch (IndexOutOfBoundsException | EmptyQueueException e)
				{
					System.out.println("\nBlad podczas wyswietalnia stogu");
					System.exit(-1);
				}
				index++;
				numberElementsDisplayed++;
			}
			sizeOfRow *= 2;
			System.out.println();
		}
		System.out.println();
	}
	
	public static void displayHeapInRow(HeapPriorityQueue heapPriorityQueue)
	{
		for (int i=0; i<heapPriorityQueue.size(); i++)
		{
			try 
			{
				System.out.print(heapPriorityQueue.getIndex(i) + " ");
			} 
			catch (IndexOutOfBoundsException | EmptyQueueException e) 
			{
				System.out.println("\nBlad podczas wyswietalnia stogu");
				System.exit(-1);
			}
		}
	}
	
	public static void main(String[] args) 
	{
		HeapPriorityQueue heapPriorityQueue = new HeapPriorityQueue();
		heapPriorityQueue.enqueue(65);
		heapPriorityQueue.enqueue(32);
		heapPriorityQueue.enqueue(15);
		heapPriorityQueue.enqueue(76);
		heapPriorityQueue.enqueue(24);
		heapPriorityQueue.enqueue(63);
		heapPriorityQueue.enqueue(10);
		System.out.println("Wyswietlanie pierwotnego stogu (tablica)");
		displayHeapInRow(heapPriorityQueue);
		System.out.println("\nWyswietlanie pierwotnego stogu (pokazujac relacje miedzy rodzicem a dzieckiem)");
		displayHeap(heapPriorityQueue);
		
		System.out.println("Wyswietlanie pierwszego elementu stogu");
		try 
		{
			System.out.println(heapPriorityQueue.first());
		} 
		catch (EmptyQueueException e) 
		{
			System.out.println("Nieuprawniona czynnosc. Pusty stog");
		}
		System.out.println("Wyswietlanie rozmiaru stogu");
		System.out.println(heapPriorityQueue.size() + "\n");
		
		heapPriorityQueue.enqueue(45);
		System.out.println("Wyswietlanie stogu po wykonaniu operacji enqueue(45) (pokazujac relacje miedzy rodzicem a dzieckiem)");
		displayHeap(heapPriorityQueue);
		
		try 
		{
			System.out.println("Operacja dequeue. Wyswietlenie pierwszej wartosci w kolejcce");
			System.out.println(heapPriorityQueue.dequeue());
		} 
		catch (EmptyQueueException e) 
		{
			System.out.println("Nieuprawniona czynnosc. Pusty stog");
		}
		
		System.out.println("Wyswietlanie stogu (pokazujac relacje miedzy rodzicem a dzieckiem)");
		displayHeap(heapPriorityQueue);
		
		try 
		{
			System.out.println("Pozbycie sie elementu na pozycji 3");
			System.out.println(heapPriorityQueue.removeIndex(3));
		} 
		catch (IndexOutOfBoundsException | EmptyQueueException e) 
		{
			System.out.println("Niewlasciwy indeks");
		}
		
		System.out.println("Wyswietlenie stogu");
		displayHeap(heapPriorityQueue);
		
		try 
		{
			System.out.println("Wyswietlanie stogu po zmianie priorytetu drugiego elementu w kolejce na 1");
			heapPriorityQueue.changePriority(2, 1);
		} 
		catch (IndexOutOfBoundsException | EmptyQueueException e) 
		{
			System.out.println("Niewlasciwy indeks");
		}
		
		displayHeap(heapPriorityQueue);
		
		heapPriorityQueue.sort();
		System.out.println("Wyswietlanie tablicy po jej posortowaniu");
		displayHeapInRow(heapPriorityQueue);
	}
}

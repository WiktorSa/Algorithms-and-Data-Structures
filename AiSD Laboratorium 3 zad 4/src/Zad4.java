import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
class EmptyQueueException extends Exception
{
	
}

@SuppressWarnings("serial")
class FullQueueException extends Exception 
{

}

@SuppressWarnings("serial")
class EmptyStackException extends Exception
{

}

@SuppressWarnings("serial")
class FullStackException extends Exception
{

}

class ArrayQueue<T>
{
	private int beginIndex = 0; // This will never change because we always take items from the first spot
	private int endIndex = 0; // The index of last item + 1
	private int size;
	private T queue[];
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int size) 
	{
		this.size = size;
		queue = (T[])new Object[size];
	}
	
	public boolean isEmpty()
	{
		return beginIndex == endIndex;
	}
	
	public boolean isFull()
	{
		return endIndex == size;
	}
	
	public T dequeue() throws EmptyQueueException
	{
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		// Our value to be returned
		T value = queue[beginIndex];
		
		// Changing placements in queue
		for (int i=0; i+1<endIndex; i++)
		{
			queue[i] = queue[i+1];
		}
		
		endIndex --; 	
			
		return value;
	}
	
	public void enqueue(T elemT) throws FullQueueException
	{
		if (isFull()) {
			throw new FullQueueException();
		}
		
		queue[endIndex++] = elemT;
	}
	
	public int size()
	{
		return size;
	}
}

class ArrayStack<T>
{
	private T array[];
	private int topIndex = 0;
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int maxSize) 
	{
		array = (T[])(new Object[maxSize]);
	}
	
	public boolean isEmpty() 
	{
		return topIndex == 0;
	}
	
	public boolean isFull()
	{
		return topIndex == array.length;
	}

	public T pop() throws EmptyStackException 
	{
		if(isEmpty())
			throw new EmptyStackException();
		
		return array[--topIndex];
	}

	public void push(T elem) throws FullStackException
	{
		if (isFull()) {
			throw new FullStackException();
		}
		array[topIndex++] = elem;
	}
	
	// Return the first element of the stack without removing it
	public T top() throws EmptyStackException {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return array[topIndex-1];
	}
	
	public int size()
	{
		return array.length;
	}
}



class RPN
{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayQueue<String> convertInfixToRPN(String[] infixNotation)
	{
		Map<String, Integer> precedence = new HashMap<String, Integer>();
		precedence.put("(", 0);
		precedence.put("*", 2);
		precedence.put("/", 2);
		precedence.put("+", 1);
		precedence.put("-", 1);
		
		ArrayQueue<String> arrayQueue = new ArrayQueue(infixNotation.length);
		ArrayStack<String> arrayStack = new ArrayStack(infixNotation.length);
		
		for (String token : infixNotation)
		{
			if ("(".equals(token)) {
				try 
				{
					arrayStack.push(token);
				} 
				catch (FullStackException e) 
				{
					System.out.println("Error");
				}
			}
			
			else if(")".equals(token)) {
				try 
				{
					while (!"(".equals(arrayStack.top())) {
						arrayQueue.enqueue(arrayStack.pop());
					}
					arrayStack.pop();
				} 
				catch (EmptyStackException | FullQueueException e) 
				{
					System.out.println("Error");
				}
			}
			
			// Than we have an operator like +
			else if (precedence.containsKey(token)) {
				try 
				{
					while (!arrayStack.isEmpty() && precedence.get(token) <= precedence.get(arrayStack.top()))
					{
						arrayQueue.enqueue(arrayStack.pop());
					}
					arrayStack.push(token);
				} 
				catch (EmptyStackException | FullQueueException | FullStackException e) 
				{
					System.out.println("Error");
				}
			}
			
			// Than we have a digit
			else {
				try 
				{
					arrayQueue.enqueue(token);
				} 
				catch (FullQueueException e) 
				{
					System.out.println("Error");
				}
			}
		}
		
		// Add anything that is still left in stack
		while (!arrayStack.isEmpty()) {
			try 
			{
				arrayQueue.enqueue(arrayStack.pop());
			} 
			catch (FullQueueException | EmptyStackException e) 
			{
				System.out.println("Error");
			}
        }
		
		return arrayQueue;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static double calculateRPN(ArrayQueue<String> arrayQueue)
	{
		ArrayStack<Double> arrayStack = new ArrayStack(arrayQueue.size());
		
		while (!arrayQueue.isEmpty()) 
		{
			// Collect value
			String value = null;
			try 
			{
				value = arrayQueue.dequeue();
			} 
			catch (EmptyQueueException e) 
			{
				System.out.println("ERROR");
			}
			
			// Check if its number
			try 
			{
				double liczba = Double.parseDouble(value);
				
				arrayStack.push(liczba);
				
			} 
			catch (Exception ex) 
			{
				
				double liczba1 = 0;
				double liczba2 = 0;
				try 
				{
					liczba1 = arrayStack.pop();
					liczba2 = arrayStack.pop();
				} 
				catch (EmptyStackException e) 
				{
					System.out.println("ERROR");
				}
				
				try 
				{
					if (value.equals("+")) {
						arrayStack.push(liczba1 + liczba2);
					} 
					
					else if (value.equals("-")) {
						arrayStack.push(liczba2 - liczba1);
					} 
					
					else if (value.equals("*")) {
						arrayStack.push(liczba1 * liczba2);
					}
					
					else {
						arrayStack.push(liczba2 / liczba1);
					}
				} 
				catch (FullStackException e) 
				{
					System.out.println("ERROR");
				}
			}
		}
		
		double result = 0;
		try 
		{
			result = arrayStack.pop();
		} 
		catch (EmptyStackException e) 
		{
			System.out.println("ERROR");
		}
		
		return result;
	}
}



public class Zad4 
{
	public static String[] readData()
	{
		BufferedReader bufferedReader = null;
		String[] data = null;
		try 
		{
			bufferedReader = new BufferedReader(new FileReader(new File("Zad4 - Dane.txt")));
			String row = bufferedReader.readLine();
			data = row.split("\\s+");
		}
		catch (IOException e) 
		{
			System.out.println("Blad podczas odczytu pliku");
			System.exit(-1);
		}
		finally 
		{
			try 
			{
				bufferedReader.close();
			} 
			catch (IOException e) 
			{
				System.out.println("Blad podczas zamykania pliku");
				System.exit(-1);
			}
		}
		
		return data;
	}
	
	// RPN - Reversed Polish Notation
	public static void main(String[] args) 
	{
		String[] data = readData();
		ArrayQueue<String> rpn = RPN.convertInfixToRPN(data);
		
		// Display the RNP
		System.out.print("In RPN form: ");
		ArrayQueue<String> rpnDisplay = RPN.convertInfixToRPN(data);
		while (!rpnDisplay.isEmpty()) 
		{
			try 
			{
				System.out.print(rpnDisplay.dequeue() + " ");
			} 
			catch (EmptyQueueException e) 
			{
				System.out.println("Error");
			}
		}
		
		System.out.println("\nValue: " + RPN.calculateRPN(rpn));
	}

}

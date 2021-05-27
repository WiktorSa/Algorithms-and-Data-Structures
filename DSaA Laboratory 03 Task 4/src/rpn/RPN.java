package rpn;

import java.util.HashMap;
import java.util.Map;

import queue.ArrayQueue;
import queue.EmptyQueueException;
import queue.FullQueueException;
import stack.ArrayStack;
import stack.EmptyStackException;
import stack.FullStackException;

public class RPN
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
				double number = Double.parseDouble(value);
				
				arrayStack.push(number);
				
			} 
			catch (Exception ex) 
			{
				
				double number1 = 0;
				double number2 = 0;
				try 
				{
					number1 = arrayStack.pop();
					number2 = arrayStack.pop();
				} 
				catch (EmptyStackException e) 
				{
					System.out.println("ERROR");
				}
				
				try 
				{
					if (value.equals("+")) {
						arrayStack.push(number1 + number2);
					} 
					
					else if (value.equals("-")) {
						arrayStack.push(number2 - number1);
					} 
					
					else if (value.equals("*")) {
						arrayStack.push(number1 * number2);
					}
					
					else {
						arrayStack.push(number2 / number1);
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

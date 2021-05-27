package main;

import stack.EmptyStackException;
import stack.FullStackException;
import stack.StackQueue;

public class Main33 
{

	public static void main(String[] args) 
	{
		StackQueue<Integer> stack = new StackQueue<Integer>(4);
		
		try
		{
			System.out.println(stack.pop());
		} 
		catch (EmptyStackException e) 
		{
			System.out.println("Empty stack\n"); // Should print
		}
		
		try
		{
			stack.push(4);
			stack.push(35);
			stack.push(21);
			stack.push(64);
		} 
		catch (FullStackException e) 
		{
			System.out.println("Full stack"); // Should not print
		}

		try 
		{
			stack.push(23);
		} 
		catch (FullStackException e) 
		{
			System.out.println("Full stack\n"); // Should print
		}
		
		try 
		{
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
		} 
		catch (EmptyStackException e) 
		{
			System.out.println("Empty stack\n"); // Should not print
		}
		
		System.out.println();
		
		try 
		{
			System.out.println(stack.pop());
		} 
		catch (EmptyStackException e) 
		{
			System.out.println("Empty stack\n"); // Should print
		}
	}

}

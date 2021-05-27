package main;

import stack.ArrayStack;
import stack.EmptyStackException;

public class Main32 
{

	public static void main(String[] args) 
	{
		ArrayStack<Integer> stack = new ArrayStack<Integer>(4);
		
		// Should return error
		try 
		{
			System.out.println(stack.pop());
		} 
		catch (EmptyStackException e) 
		{
			System.out.println("Empty stack\n");
		}
		
		// Should return 4
		System.out.println(stack.maxSize() + "\n");
		
		stack.push(1);
		stack.push(23);
		stack.push(34);
		
		// Should return 8
		System.out.println(stack.maxSize() + "\n");
		
		// Should return 34
		try 
		{
			System.out.println(stack.pop() + "\n");
		} 
		catch (EmptyStackException e) 
		{
			System.out.println("Empty stack\n");
		}
		
		// Should return 4
		System.out.println(stack.maxSize() + "\n");
		
		// This should increase size after 15/4 = 3.75 which rounds up to 4 elements
		stack = new ArrayStack<Integer>(5);
		System.out.println(stack.maxSize() + "\n");
		stack.push(1);
		stack.push(23);
		stack.push(34);
		System.out.println(stack.maxSize() + "\n");
		stack.push(2);
		System.out.println(stack.maxSize() + "\n");

	}

}

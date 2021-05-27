package main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import queue.ArrayQueue;
import queue.EmptyQueueException;
import rpn.RPN;

public class Main34 
{
	public static String[] readData()
	{
		BufferedReader bufferedReader = null;
		String[] data = null;
		try 
		{
			bufferedReader = new BufferedReader(new FileReader(new File("Task4 - Data.txt")));
			String row = bufferedReader.readLine();
			data = row.split("\\s+");
		}
		catch (IOException e) 
		{
			System.out.println("Error while reading a file");
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
				System.out.println("Error while closing a file");
				System.exit(-1);
			}
		}
		
		return data;
	}
	
	// RPN - Reverse Polish Notation
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

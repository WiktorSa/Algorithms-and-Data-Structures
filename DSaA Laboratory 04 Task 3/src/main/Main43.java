package main;

import list.Element;
import list.OneWayListAsQueue;
import list.OneWayListAsStack;

public class Main43 
{

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) 
	{
		OneWayListAsQueue<Integer> oneWayListAsQueue = new OneWayListAsQueue();
		oneWayListAsQueue.add(new Element(13));
		oneWayListAsQueue.add(new Element(54));
		oneWayListAsQueue.add(new Element(23));
		oneWayListAsQueue.add(new Element(83));
		oneWayListAsQueue.add(new Element(65));
		
		System.out.println("Presenting list as a queue. You should see: 13 54 23 83 65 null");
		while(!oneWayListAsQueue.isEmpty())
		{
			System.out.println(oneWayListAsQueue.get());
		}
		System.out.println(oneWayListAsQueue.get());
		
		System.out.println();
		
		OneWayListAsStack<Integer> OneWayListAsStack = new OneWayListAsStack();
		OneWayListAsStack.add(new Element(13));
		OneWayListAsStack.add(new Element(54));
		OneWayListAsStack.add(new Element(23));
		OneWayListAsStack.add(new Element(83));
		OneWayListAsStack.add(new Element(65));
		
		System.out.println("Presenting list as a stack. You should see: 65 83 23 54 13 null");
		while(!OneWayListAsStack.isEmpty())
		{
			System.out.println(OneWayListAsStack.get());
		}
		System.out.println(OneWayListAsStack.get());
		
		
	}

}

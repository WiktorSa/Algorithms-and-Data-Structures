package main;

import list.Element;
import list.OneWayList;

public class Main41 
{

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) 
	{
		OneWayList<Integer> oneWayList = new OneWayList<Integer>();
		oneWayList.addEnd(1);
		oneWayList.addEnd(2);
		oneWayList.addEnd(3);
		
		System.out.println("Showing list nr 1: You should see: 1, 2, 3");
		oneWayList.showList();
		System.out.println();
		
		oneWayList.insert(1, 4);
		System.out.println("Showing list nr 2 (adding 4 on position 1): You should see: 1, 4, 2, 3");
		oneWayList.showList();
		System.out.println();
		
		System.out.println("Getting element at position 2. You should see 2");
		System.out.println(oneWayList.get(2));
		System.out.println();
		
		oneWayList.set(3, 7);
		System.out.println("Showing list nr 3 (Changing value at position 3 to 7). You should see: 1, 4, 2, 7");
		oneWayList.showList();
		System.out.println();
		
		System.out.println("Showing if element 2 is in the list and later if element 8 is in the list. You should see: true, false");
		System.out.println(oneWayList.contains(2));
		System.out.println(oneWayList.contains(8));
		System.out.println();
		
		System.out.println("Showing the size of the list. You should see 4");
		System.out.println(oneWayList.size());
		System.out.println();
		
		oneWayList.clear();
		oneWayList.addEnd(10);
		oneWayList.addEnd(15);
		oneWayList.addEnd(14);
		oneWayList.addEnd(24);
		oneWayList.addEnd(8);
		System.out.println("Showing list nr 4 (Clearing and adding new elements). You should see: 10, 15, 14, 24, 8");
		oneWayList.showList();
		System.out.println();
		
		System.out.println("Deletion at position 3. You should see 24");
		System.out.println(oneWayList.deletePos(3));
		System.out.println();
		
		System.out.println("Showing list nr 5 (deleting element at position 3). Powinno pokazac sie 10, 15, 14, 8");
		oneWayList.showList();
		System.out.println();
		
		System.out.println("Deleting element of value 15. You should see true");
		System.out.println(oneWayList.delete(15));
		System.out.println();
		
		System.out.println("Showing list nr 6 (deleting element of value 15). You should see: 10, 14, 8");
		oneWayList.showList();
		System.out.println();
		
		System.out.println("Deleting Element(8). You should see 8");
		System.out.println(oneWayList.deleteEl(new Element(8)));
		System.out.println();
		
		System.out.println("Showing list nr 7 (deleting Element(8)). You should see: 10, 14");
		oneWayList.showList();
		System.out.println();
		
		System.out.println("Testing different conditions. You should see: false, null or another appropriate message");
		oneWayList.insert(-1, 2);
		oneWayList.insert(3, 1);
		System.out.println(oneWayList.get(-1));
		System.out.println(oneWayList.get(2));
		System.out.println(oneWayList.set(-1, 1));
		System.out.println(oneWayList.set(2, 1));
		System.out.println(oneWayList.deletePos(-1));
		System.out.println(oneWayList.deletePos(2));
		System.out.println(oneWayList.delete(1));
		System.out.println(oneWayList.deleteEl(new Element(1)));
	}

}

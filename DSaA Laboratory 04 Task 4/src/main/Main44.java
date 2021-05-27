package main;

import list.TwoWayCycledList;

public class Main44 
{

	public static void main(String[] args) 
	{
		TwoWayCycledList<Integer> twoWayCycledList = new TwoWayCycledList<Integer>();
		twoWayCycledList.add(1);
		twoWayCycledList.add(24);
		twoWayCycledList.add(12);
		
		System.out.println("Iteration from the beggining to the end of the list (you should see: 1, 24, 12)");
		twoWayCycledList.showAllValuesInListFromBeginning();
		System.out.println();
		
		System.out.println("Iteration from the end to the beginning of the list (You should see: 12, 24, 1)");
		twoWayCycledList.showAllValuesInListFromEnd();
		System.out.println();
		
		TwoWayCycledList<Integer> twoWayCycledList2 = new TwoWayCycledList<Integer>();
		twoWayCycledList2.add(4);
		twoWayCycledList2.add(28);
		twoWayCycledList2.add(423);
		
		twoWayCycledList.addAListToTheEnd(twoWayCycledList2);
		System.out.println("Adding list 2 to the list 1 at the end. You should see: 1, 24, 12, 4, 28, 423");
		twoWayCycledList.showAllValuesInListFromBeginning();
		
		TwoWayCycledList<Integer> twoWayCycledList3 = new TwoWayCycledList<Integer>();
		twoWayCycledList3.add(13);
		twoWayCycledList3.add(21);
		twoWayCycledList3.add(43);
		System.out.println();
		
		twoWayCycledList2.addAListAtTheGivenPosition(twoWayCycledList3, 1);
		System.out.println("Adding list 3 before the element 28 from the list 2. You should see: 4, 13, 21, 43, 28, 423");
		twoWayCycledList2.showAllValuesInListFromBeginning();
	}

}

package main;
import java.util.ArrayList;
import java.util.Random;

import bstTree.BSTTree;
import exceptions.DuplicateElementException;
import rbTree.RBTree;
import tree234.Tree234;

public class Laby122Main 
{
	public static void main(String[] args) 
	{
		// Collecting all the necessary info to put in our table
		// We perform 100 correct tests and 100 failed tests 10 times and take the average from it
		int[] noKeysInTree = new int[] {20, 50, 100, 200, 500, 1000, 2000, 5000};
		int noSimulations = 10;
		int noSearches = 100;
		ArrayList<Double> noComparisionSuccessBSTTree = new ArrayList<Double>();
		ArrayList<Double> noComparisionFailsBSTTree = new ArrayList<Double>();
		ArrayList<Double> noComparisionSuccessRBTree = new ArrayList<Double>();
		ArrayList<Double> noComparisionFailsRBTree = new ArrayList<Double>();
		ArrayList<Double> noComparisionSuccess234Tree = new ArrayList<Double>();
		ArrayList<Double> noComparisionFails234Tree = new ArrayList<Double>();
		// We use seed for reproducibilty
		Random random = new Random(11);
		int key = 0;
		
		for (int i=0; i<noKeysInTree.length; i++)
		{
			BSTTree bstTree = new BSTTree();
			RBTree rbTree = new RBTree();
			Tree234 tree234 = new Tree234();
			BSTTree fillerTree = new BSTTree();
			
			for (int j=0; j<noKeysInTree[i]; j++)
			{
				key = random.nextInt(50000);
				// Key cannot be in any of our trees
				while (fillerTree.findNode(key) != null) 
				{
					key = random.nextInt(50000);
				}
				
				try 
				{
					bstTree.insert(key);
					rbTree.insert(key);
					tree234.insert(key);
					fillerTree.insert(key);
				} 
				catch (DuplicateElementException e) 
				{
					System.out.println("Jezeli ta wiadomosc sie pojawia to oznacza, ze jest blad w kodzie");
				}
			}
			
			for (int j=0; j<noSimulations; j++)
			{
				// Successes
				for (int k=0; k<noSearches; k++)
				{
					key = random.nextInt(50000);
					while (fillerTree.findNode(key) == null) 
					{
						key = random.nextInt(50000);
					}
					
					bstTree.findNode(key);
					rbTree.findNode(key);
					tree234.find(key);
				}
			}
			
			noComparisionSuccessBSTTree.add(bstTree.getNoComparisions() / noSearches);
			noComparisionSuccessRBTree.add(rbTree.getNoComparision() / noSearches);
			noComparisionSuccess234Tree.add(tree234.getNoComparisions() / noSearches);
			bstTree.setNoComparisions(0);
			rbTree.setNoComparision(0);
			tree234.setNoComparisions(0);
			
			for (int j=0; j<noSimulations; j++)
			{
				// Fails
				for (int k=0; k<noSearches; k++)
				{
					key = random.nextInt(50000);
					while (fillerTree.findNode(key) != null) 
					{
						key = random.nextInt(50000);
					}
					
					bstTree.findNode(key);
					rbTree.findNode(key);
					tree234.find(key);
				}
			}
			
			noComparisionFailsBSTTree.add(bstTree.getNoComparisions() / noSearches);
			noComparisionFailsRBTree.add(rbTree.getNoComparision() / noSearches);
			noComparisionFails234Tree.add(tree234.getNoComparisions() / noSearches);
		}
		
		System.out.println("Experiment was made for different sizes of trees");
		System.out.println("Each time we made: " + noSearches + " searches and ran this experiment: " + noSimulations + " times and later we took the average number");
		System.out.println("We seperately analysed cases where key was in tree and where key wasn't in tree");
		System.out.println("\nResults of the experiment where key is in the tree");
		System.out.println(String.format("%15s%15s%15s%15s", "Number of keys", "BST tree", "RB tree", "2-3-4 tree"));
		for (int i=0; i<noKeysInTree.length; i++)
		{
			System.out.println(String.format("%15s%15s%15s%15s", String.valueOf((noKeysInTree[i])), noComparisionSuccessBSTTree.get(i).toString(), noComparisionSuccessRBTree.get(i).toString(), noComparisionSuccess234Tree.get(i).toString()));
		}
		System.out.println("\nResults of the experiment where key was not in the tree");
		System.out.println(String.format("%15s%15s%15s%15s", "Number of keys", "BST tree", "RB tree", "2-3-4 tree"));
		for (int i=0; i<noKeysInTree.length; i++)
		{
			System.out.println(String.format("%15s%15s%15s%15s", String.valueOf((noKeysInTree[i])), noComparisionFailsBSTTree.get(i).toString(), noComparisionFailsRBTree.get(i).toString(), noComparisionFails234Tree.get(i).toString()));
		}
		System.out.println("\nAverage results for both experiments");
		System.out.println(String.format("%15s%15s%15s%15s", "Number of keys", "BST tree", "RB tree", "2-3-4 tree"));
		for (int i=0; i<noKeysInTree.length; i++)
		{
			double value1 = Math.round((noComparisionSuccessBSTTree.get(i) + noComparisionFailsBSTTree.get(i)) / 2 * 100) / 100.0;
			double value2 = Math.round((noComparisionSuccessRBTree.get(i) + noComparisionFailsRBTree.get(i)) / 2 * 100) / 100.0;
			double value3 = Math.round((noComparisionSuccess234Tree.get(i) + noComparisionFails234Tree.get(i)) / 2 * 100) / 100.0;
			System.out.println(String.format("%15s%15s%15s%15s", String.valueOf((noKeysInTree[i])), String.valueOf(value1), String.valueOf(value2), String.valueOf(value3)));
		}
	}
}

package main;
import gui.TextGUI;
import tree.BSTTree;

public class Lab102Main 
{
	public static void main(String[] args) 
	{
		TextGUI textGUI = new TextGUI(new BSTTree());
		textGUI.startGUI();
	}

}

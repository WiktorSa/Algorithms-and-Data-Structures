package gui;
import tree.BSTTree;
import tree.Node;

public class BSTTreePrinter 
{
	BSTTree bstTree;
	
	public BSTTreePrinter(BSTTree bstTree)
	{
		this.bstTree = bstTree;
	}
	
	public void preOrderWalk(StringBuilder stringBuilder, String padding, String pointer, Node node)
	{
		if (node != null) {
			stringBuilder.append(padding);
			stringBuilder.append(pointer);
			stringBuilder.append(node.getKey());
			stringBuilder.append("\n");
			
			StringBuilder paddingBuilder = new StringBuilder(padding);
			paddingBuilder.append("|  ");
			
			String paddingForBoth = paddingBuilder.toString();
			String pointerForBoth = "\\--";
			
			preOrderWalk(stringBuilder, paddingForBoth, pointerForBoth, node.getLeft());
			preOrderWalk(stringBuilder, paddingForBoth, pointerForBoth, node.getRight());
		}
	}
	
	public void print()
	{
		StringBuilder stringBuilder = new StringBuilder();
		preOrderWalk(stringBuilder, "", "", bstTree.getRoot());
		System.out.println(stringBuilder.toString());
	}
}

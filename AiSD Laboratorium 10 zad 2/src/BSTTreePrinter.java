public class BSTTreePrinter 
{
	BSTTree bstTree;
	
	public BSTTreePrinter(BSTTree bstTree)
	{
		this.bstTree = bstTree;
	}
	
	// Uzywajac preorder jestesmy w stanie skonstruowac drzewo w ktorym ladnie widac polaczenia miedzy rodzicem a dzieckiem
	// Celem lepszej wizualizacji bedziemy dodawac tzw padding i pointer co pozwoli na jeszcze lepsza wizualizacje relacji miedzy rodzicem a dzieckiem
	public void preOrderWalk(StringBuilder stringBuilder, String padding, String pointer, Node node)
	{
		if (node != null) {
			stringBuilder.append(padding);
			stringBuilder.append(pointer);
			stringBuilder.append(node.getKey());
			stringBuilder.append("\n");
			
			// Konstruuje odnogi naszego drzewa, zeby ladnie pokazywaly relacje miedzy wezlami 
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

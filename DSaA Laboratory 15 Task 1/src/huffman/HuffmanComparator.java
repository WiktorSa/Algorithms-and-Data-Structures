package huffman;

import java.util.Comparator;

public class HuffmanComparator implements Comparator<HuffmanNode>
{
	public int compare(HuffmanNode huffmanNode1, HuffmanNode huffmanNode2)
	{
		return huffmanNode1.getFrequency() - huffmanNode2.getFrequency();
	}
}

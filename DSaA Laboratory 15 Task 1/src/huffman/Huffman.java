package huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Huffman 
{
	private Map<Character, String> huffmanCode = new HashMap<>();
	private HuffmanNode root = null;
	private String text = null;
	private StringBuilder sb = new StringBuilder();
	
	private void encode(HuffmanNode root, String str)
	{
		if (root == null) {
			return;
		}
		
		if (isLeaf(root)) {
			huffmanCode.put(root.getCharacter(), str.length() > 0 ? str : "1");
		}
		
		encode(root.getLeft(), str + '0');
		encode(root.getRight(), str + '1');
	}
	
	private int decode(HuffmanNode root, int index, StringBuilder sb)
	{
		if (root == null) {
			return index;
		}
		
		if (isLeaf(root)) {
			System.out.println(root.getCharacter());
			return index;
		}
		
		index++;
		
		root = (sb.charAt(index) == '0') ? root.getLeft() : root.getRight();
		index = decode(root, index, sb);
		return index;
	}
	
	private boolean isLeaf(HuffmanNode root)
	{
		return root.getLeft() == null && root.getRight() == null;
	}
	
	public void buildHuffmanTree(String text)
	{
		if (text == null || text.length() == 0) {
			return;
		}
		
		this.text = text;
		
		// Count the frequency of appearance of each character
		Map<Character, Integer> freq = new HashMap<>();
		for (char c: text.toCharArray())
		{
			freq.put(c, freq.getOrDefault(c, 0) + 1);
		}
		
		PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>(new HuffmanComparator());
		
		for (Entry<Character, Integer> entry : freq.entrySet())
		{
			priorityQueue.add(new HuffmanNode(entry.getKey(), entry.getValue()));
		}
		
		while (priorityQueue.size() != 1)
		{
			HuffmanNode left = priorityQueue.poll();
			HuffmanNode right = priorityQueue.poll();
			
			int sum = left.getFrequency() + right.getFrequency();
			priorityQueue.add(new HuffmanNode(null, sum, left, right));
		}
		
		root = priorityQueue.peek();
		huffmanCode = new HashMap<>();
		// Encode every character with a proper code
		encode(root, "");
		
		System.out.println("Huffman codes: " + huffmanCode);
	}
	
	public void encodeWholeString()
	{
		System.out.println("Text is: " + text);
		
		sb = new StringBuilder();
		for (char c: text.toCharArray())
		{
			sb.append(huffmanCode.get(c));
		}
		
		System.out.println("The encoded string: " + sb);
	}
	
	public void decodeWholeString()
	{
		System.out.println("The decoded string is: ");
		
		if (isLeaf(root)) {
			while (root.getFrequency() > 0) 
			{
				System.out.println(root.getCharacter());
				root.setFrequency(root.getFrequency() + 1);
			}
		}
		
		else {
			int index = -1;
			while (index < sb.length() - 1)
			{
				index = decode(root, index, sb);
			}
		}
	}
	
}

package main;
import huffman.Huffman;

public class Main151 
{
	public static void main(String[] args) 
	{
		Huffman huffman = new Huffman();
		huffman.buildHuffmanTree("I love algorithms");
		huffman.encodeWholeString();
		huffman.decodeWholeString();
	}
	
}

package sortingAlgorithms;

public class HeapSort implements SortingAlgorithm
{
	public HeapSort() {}
	
	private void swap(int[] array, int left, int right)
	{
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	private void sink(int[] heap, int idx, int n)
	{
		int idxOfBigger = 2 * idx + 1;
		if (idxOfBigger < n) {
			if (idxOfBigger + 1 < n && heap[idxOfBigger] < heap[idxOfBigger+1]) {
				idxOfBigger++;
			}
			if (heap[idx] < heap[idxOfBigger]) {
				swap(heap, idx, idxOfBigger);
				sink(heap, idxOfBigger, n);
			}
		}
	}
	
	private void heapAdjustment(int[] heap, int n)
	{
		for (int i=(n-1)/2; i>=0; i--)
		{
			sink(heap, i, n);
		}
	}

	// Filler arguments won't be used. There are here only to 
	// fill the requirements for the interface
	@Override
	public int[] sort(int[] array, int filler, int filler2) 
	{
		heapSort(array, array.length);
		return array;
	}
	
	private void heapSort(int[] heap, int n)
	{
		heapAdjustment(heap, n);
		for (int i=n-1; i>0; i--)
		{
			swap(heap, i, 0);
			sink(heap, 0, i);
		}
	}

	@Override
	public String getNameOfSortingAlgorithm() 
	{
		return "HeapSort";
	}
}

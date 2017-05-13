package mamm.alg.sort;

import static org.testng.Assert.assertTrue;
import mamm.alg.datastructure.Heap;

import org.testng.annotations.Test;

public class HeapSortTest {
	
	@Test
	public void oneElementMaxHeap(){
		Integer [] list = {5};
		HeapSort.sort(Heap.MAX, list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void twoElementsDesordenedMaxHeap(){
		Integer [] list = {5, 2};
		HeapSort.sort(Heap.MAX, list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void twoElementsOrdenedMaxHeap(){
		Integer [] list = {2, 3};
		HeapSort.sort(Heap.MAX, list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void threeElementsOrdenedAcendingMaxHeap(){
		Integer [] list = {2, 3, 4};
		HeapSort.sort(Heap.MAX, list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void threeElementsDesordenedMaxHeap(){
		Integer [] list = {4, 2, 3};
		HeapSort.sort(Heap.MAX, list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void threeElementsOrdenedDescendingMaxHeap(){
		Integer [] list = {4, 3, 2};
		HeapSort.sort(Heap.MAX, list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void desordenedMaxHeap(){
		Integer [] list = {5, 2, 4, 6, 1, 3};
		HeapSort.sort(Heap.MAX, list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void ordenedAscendingMaxHeap(){
		Integer [] list = {1, 2, 3, 4, 5, 6};
		HeapSort.sort(Heap.MAX, list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void ordenedDescendingMaxHeap(){
		Integer [] list = {6, 5, 4, 3, 2, 1};
		HeapSort.sort(Heap.MAX, list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void oneElementMinHeap(){
		Integer [] list = {5};
		HeapSort.sort(Heap.MIN, list);
		assertTrue(SortUtil.isOrdenedDescending(list), "Sorting failure");
	}
	
	@Test
	public void twoElementsDesordenedMinHeap(){
		Integer [] list = {5, 2};
		HeapSort.sort(Heap.MIN, list);
		assertTrue(SortUtil.isOrdenedDescending(list), "Sorting failure");
	}
	
	@Test
	public void twoElementsOrdenedMinHeap(){
		Integer [] list = {2, 3};
		HeapSort.sort(Heap.MIN, list);
		assertTrue(SortUtil.isOrdenedDescending(list), "Sorting failure");
	}
	
	@Test
	public void threeElementsOrdenedAcendingMinHeap(){
		Integer [] list = {2, 3, 4};
		HeapSort.sort(Heap.MIN, list);
		assertTrue(SortUtil.isOrdenedDescending(list), "Sorting failure");
	}
	
	@Test
	public void threeElementsDesordenedMinHeap(){
		Integer [] list = {4, 2, 3};
		HeapSort.sort(Heap.MIN, list);
		assertTrue(SortUtil.isOrdenedDescending(list), "Sorting failure");
	}
	
	@Test
	public void threeElementsOrdenedDescendingMinHeap(){
		Integer [] list = {4, 3, 2};
		HeapSort.sort(Heap.MIN, list);
		assertTrue(SortUtil.isOrdenedDescending(list), "Sorting failure");
	}
	
	@Test
	public void desordenedMinHeap(){
		Integer [] list = {5, 2, 4, 6, 1, 3};
		HeapSort.sort(Heap.MIN, list);
		assertTrue(SortUtil.isOrdenedDescending(list), "Sorting failure");
	}
	
	@Test
	public void ordenedAscendingMinHeap(){
		Integer [] list = {1, 2, 3, 4, 5, 6};
		HeapSort.sort(Heap.MIN, list);
		assertTrue(SortUtil.isOrdenedDescending(list), "Sorting failure");
	}
	
	@Test
	public void ordenedDescendingMinHeap(){
		Integer [] list = {6, 5, 4, 3, 2, 1};
		HeapSort.sort(Heap.MIN, list);
		assertTrue(SortUtil.isOrdenedDescending(list), "Sorting failure");
	}
}

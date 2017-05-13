package mamm.alg.sort;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class QuickSortTest {
	
	@Test
	public void oneElement(){
		Integer [] list = {5};
		QuickSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void twoElementsDesordened(){
		Integer [] list = {5, 2};
		QuickSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void twoElementsOrdened(){
		Integer [] list = {2, 3};
		QuickSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void desordened(){
		Integer [] list = {5, 2, 4, 6, 1, 3};
		QuickSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void ordenedAscending(){
		Integer [] list = {1, 2, 3, 4, 5, 6};
		QuickSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void ordenedDescending(){
		Integer [] list = {6, 5, 4, 3, 2, 1};
		QuickSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	


	
	
	@Test
	public void oneElementUsingRandomized(){
		Integer [] list = {5};
		QuickSort.randomizedSort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void twoElementsDesordenedUsingRandomized(){
		Integer [] list = {5, 2};
		QuickSort.randomizedSort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void twoElementsOrdenedUsingRandomized(){
		Integer [] list = {2, 3};
		QuickSort.randomizedSort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void desordenedUsingRandomized(){
		Integer [] list = {5, 2, 4, 6, 1, 3};
		QuickSort.randomizedSort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void ordenedAscendingUsingRandomized(){
		Integer [] list = {1, 2, 3, 4, 5, 6};
		QuickSort.randomizedSort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void ordenedDescendingUsingRandomized(){
		Integer [] list = {6, 5, 4, 3, 2, 1};
		QuickSort.randomizedSort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
}

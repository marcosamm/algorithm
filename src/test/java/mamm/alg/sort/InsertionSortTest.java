package mamm.alg.sort;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class InsertionSortTest {
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void sortNullArray(){
		InsertionSort.sort(null);
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void sortEmptyArray(){
		InsertionSort.sort(new Integer[0]);
	}
	
	@Test
	public void oneElement(){
		Integer [] list = {5};
		InsertionSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void twoElementsDesordened(){
		Integer [] list = {5, 2};
		InsertionSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void twoElementsOrdened(){
		Integer [] list = {2, 3};
		InsertionSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void desordened(){
		Integer [] list = {5, 2, 4, 6, 1, 3};
		InsertionSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void ordenedAscending(){
		Integer [] list = {1, 2, 3, 4, 5, 6};
		InsertionSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void ordenedDescending(){
		Integer [] list = {6, 5, 4, 3, 2, 1};
		InsertionSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
}

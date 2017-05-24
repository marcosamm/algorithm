package mamm.alg.sort;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class CountingSortTest {
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void sortNullArray(){
		CountingSort.sort(null, null, 0);
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void sortByCharacterNullArray(){
		CountingSort.sortByCharacter(null, 0);
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void sortByDigitNullArray(){
		CountingSort.sortByDigit(null, 0);
	}
	
	@Test
	public void oneElement(){
		Integer [] list = {5};
		Integer [] ordenedList = new Integer[list.length];
		CountingSort.sort(list, ordenedList);
		assertTrue(SortUtil.isOrdenedAcending(ordenedList), "Sorting failure");
	}
	
	@Test
	public void twoElementsDesordened(){
		Integer [] list = {5, 2};
		Integer [] ordenedList = new Integer[list.length];
		CountingSort.sort(list, ordenedList);
		assertTrue(SortUtil.isOrdenedAcending(ordenedList), "Sorting failure");
	}
	
	@Test
	public void twoElementsOrdened(){
		Integer [] list = {2, 3};
		Integer [] ordenedList = new Integer[list.length];
		CountingSort.sort(list, ordenedList);
		assertTrue(SortUtil.isOrdenedAcending(ordenedList), "Sorting failure");
	}
	
	@Test
	public void desordened(){
		Integer [] list = {5, 2, 4, 6, 1, 3};
		Integer [] ordenedList = new Integer[list.length];
		CountingSort.sort(list, ordenedList);
		assertTrue(SortUtil.isOrdenedAcending(ordenedList), "Sorting failure");
	}
	
	@Test
	public void ordenedAscending(){
		Integer [] list = {1, 2, 3, 4, 5, 6};
		Integer [] ordenedList = new Integer[list.length];
		CountingSort.sort(list, ordenedList);
		assertTrue(SortUtil.isOrdenedAcending(ordenedList), "Sorting failure");
	}
	
	@Test
	public void ordenedDescending(){
		Integer [] list = {6, 5, 4, 3, 2, 1};
		Integer [] ordenedList = new Integer[list.length];
		CountingSort.sort(list, ordenedList);
		assertTrue(SortUtil.isOrdenedAcending(ordenedList), "Sorting failure");
	}
	
	@Test
	public void eightElements(){
		Integer [] list = {2, 5, 3, 0, 2, 3, 0, 3};
		Integer [] ordenedList = new Integer[list.length];
		CountingSort.sort(list, ordenedList);
		assertTrue(SortUtil.isOrdenedAcending(ordenedList), "Sorting failure");
	}
}

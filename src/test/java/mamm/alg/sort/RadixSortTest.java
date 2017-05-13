package mamm.alg.sort;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class RadixSortTest {
	
	@Test
	public void oneElement(){
		Integer [] list = {5};
		RadixSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void twoElementsDesordened(){
		Integer [] list = {5, 2};
		RadixSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void twoElementsOrdened(){
		Integer [] list = {2, 3};
		RadixSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void desordened(){
		Integer [] list = {5, 2, 4, 6, 1, 3};
		RadixSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void ordenedAscending(){
		Integer [] list = {1, 2, 3, 4, 5, 6};
		RadixSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void ordenedDescending(){
		Integer [] list = {6, 5, 4, 3, 2, 1};
		RadixSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void eightElements(){
		Integer [] list = {2, 5, 3, 0, 2, 3, 0, 3};
		RadixSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void multiplesElements(){
		Integer [] list = {170, 45, 75, 90, 802, 24, 2, 66};
		RadixSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	


	
	
	@Test
	public void oneStringElement(){
		String [] list = {"A"};
		RadixSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void twoStringElementsDesordened(){
		String [] list = {"B", "A"};
		RadixSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void twoStringElementsOrdened(){
		String [] list = {"A", "B"};
		RadixSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void stringDesordened(){
		String [] list = {"B", "C", "A", "E", "D"};
		RadixSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void stringOrdenedAscending(){
		String [] list = {"A", "B", "C", "D", "E"};
		RadixSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void stringOrdenedDescending(){
		String [] list = {"E", "D", "C", "B", "A"};
		RadixSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void stringMultiplesElements(){
		String [] list = {"COW", "DOG", "SEA", "RUG", "ROW", "MOB", "BOX", "TAB", "BAR", "EAR", "TAR", "DIG", "BIG", "TEA", "NOW", "FOX"};
		RadixSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
}

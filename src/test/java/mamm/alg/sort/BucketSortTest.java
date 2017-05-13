package mamm.alg.sort;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class BucketSortTest {
	
	@Test
	public void oneElement(){
		Float [] list = {0.1f};
		BucketSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void twoElementsDesordened(){
		Float [] list = {0.5f, 0.2f};
		BucketSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void twoElementsOrdened(){
		Float [] list = {0.2f, 0.3f};
		BucketSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void desordened(){
		Float [] list = {0.5f, 0.2f, 0.4f, 0.6f, 0.1f, 0.3f};
		BucketSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void ordenedAscending(){
		Float [] list = {0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f};
		BucketSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void ordenedDescending(){
		Float [] list = {0.6f, 0.5f, 0.4f, 0.3f, 0.2f, 0.1f};
		BucketSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
}

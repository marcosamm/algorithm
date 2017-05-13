package mamm.alg.sort;

import static org.testng.Assert.assertTrue;
import mamm.alg.datastructure.Element;

import org.testng.annotations.Test;

public class BucketSortTest {
	
	@Test
	public void oneElement(){
		@SuppressWarnings("unchecked")
		Element<Float, Object> [] list = new Element[1];
		list[0] = new Element<Float, Object>(0.1f,null);
		BucketSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void twoElementsDesordened(){
		@SuppressWarnings("unchecked")
		Element<Float, Object> [] list = new Element[2];
		list[0] = new Element<Float, Object>(0.5f,null);
		list[1] = new Element<Float, Object>(0.2f,null);
		BucketSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void twoElementsOrdened(){
		@SuppressWarnings("unchecked")
		Element<Float, Object> [] list = new Element[2];
		list[0] = new Element<Float, Object>(0.2f,null);
		list[1] = new Element<Float, Object>(0.3f,null);
		BucketSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void desordened(){
		@SuppressWarnings("unchecked")
		Element<Float, Object> [] list = new Element[6];
		list[0] = new Element<Float, Object>(0.5f,null);
		list[1] = new Element<Float, Object>(0.2f,null);
		list[2] = new Element<Float, Object>(0.4f,null);
		list[3] = new Element<Float, Object>(0.6f,null);
		list[4] = new Element<Float, Object>(0.1f,null);
		list[5] = new Element<Float, Object>(0.3f,null);
		
		BucketSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void ordenedAscending(){
		@SuppressWarnings("unchecked")
		Element<Float, Object> [] list = new Element[6];
		list[0] = new Element<Float, Object>(0.1f,null);
		list[1] = new Element<Float, Object>(0.2f,null);
		list[2] = new Element<Float, Object>(0.3f,null);
		list[3] = new Element<Float, Object>(0.4f,null);
		list[4] = new Element<Float, Object>(0.5f,null);
		list[5] = new Element<Float, Object>(0.6f,null);
		BucketSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
	
	@Test
	public void ordenedDescending(){
		@SuppressWarnings("unchecked")
		Element<Float, Object> [] list = new Element[6];
		list[0] = new Element<Float, Object>(0.1f,null);
		list[1] = new Element<Float, Object>(0.2f,null);
		list[2] = new Element<Float, Object>(0.3f,null);
		list[3] = new Element<Float, Object>(0.4f,null);
		list[4] = new Element<Float, Object>(0.5f,null);
		list[5] = new Element<Float, Object>(0.6f,null);
		BucketSort.sort(list);
		assertTrue(SortUtil.isOrdenedAcending(list), "Sorting failure");
	}
}

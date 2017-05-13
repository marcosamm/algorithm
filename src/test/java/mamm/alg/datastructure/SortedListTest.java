package mamm.alg.datastructure;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;
import mamm.alg.sort.SortUtil;

import org.testng.annotations.Test;

public class SortedListTest {
	
	@Test
	public void search(){
		SortedList<Integer> linkedList = new SortedList<Integer>();
		Integer i1 = 1;
		Integer i2 = 2;
		Integer i3 = 3;
		
		assertEquals(0, linkedList.getSize());
		linkedList.insert(i1);
		assertEquals(1, linkedList.getSize());
		linkedList.insert(i2);
		assertEquals(2, linkedList.getSize());
		linkedList.insert(i3);
		assertEquals(3, linkedList.getSize());
		
		assertEquals(i1, linkedList.search(i1).getValue());
		assertEquals(i2, linkedList.search(i2).getValue());
		assertEquals(i3, linkedList.search(i3).getValue());
	}
	
	@Test
	public void delete(){
		SortedList<Integer> linkedList = new SortedList<Integer>();
		Integer i1 = 1;
		Integer i2 = 2;
		Integer i3 = 3;
		
		assertEquals(0, linkedList.getSize());
		linkedList.insert(i1);
		assertEquals(1, linkedList.getSize());
		assertEquals(i1, linkedList.search(i1).getValue());
		linkedList.insert(i2);
		assertEquals(2, linkedList.getSize());
		assertEquals(i2, linkedList.search(i2).getValue());
		linkedList.insert(i3);
		assertEquals(3, linkedList.getSize());
		assertEquals(i3, linkedList.search(i3).getValue());
		
		linkedList.delete(i2);
		assertEquals(2, linkedList.getSize());
		assertEquals(i1, linkedList.search(i1).getValue());
		assertNull(linkedList.search(i2));
		assertEquals(i3, linkedList.search(i3).getValue());
	}
	
	@Test
	public void oneElement(){
		Float [] list = {0.1f};
		SortedList<Float> linkedList = new SortedList<Float>();
		linkedList.insertAll(list);
		assertEquals(1, linkedList.toArray().length, "Different Sizes");
		assertTrue(SortUtil.isOrdenedAcending(linkedList.toArray()), "Sorting failure");
	}
	
	@Test
	public void twoElementsDesordened(){
		Float [] list = {0.5f, 0.2f};
		SortedList<Float> linkedList = new SortedList<Float>();
		linkedList.insertAll(list);
		assertEquals(2, linkedList.toArray().length, "Different Sizes");
		assertTrue(SortUtil.isOrdenedAcending(linkedList.toArray()), "Sorting failure");
	}
	
	@Test
	public void twoElementsOrdened(){
		Float [] list = {0.2f, 0.3f};
		SortedList<Float> linkedList = new SortedList<Float>();
		linkedList.insertAll(list);
		assertEquals(2, linkedList.toArray().length, "Different Sizes");
		assertTrue(SortUtil.isOrdenedAcending(linkedList.toArray()), "Sorting failure");
	}
	
	@Test
	public void desordened(){
		Float [] list = {0.5f, 0.2f, 0.4f, 0.6f, 0.1f, 0.3f};
		SortedList<Float> linkedList = new SortedList<Float>();
		linkedList.insertAll(list);
		assertEquals(6, linkedList.toArray().length, "Different Sizes");
		assertTrue(SortUtil.isOrdenedAcending(linkedList.toArray()), "Sorting failure");
	}
	
	@Test
	public void ordenedAscending(){
		Integer [] list = {1, 2, 3, 4, 5, 6};
		SortedList<Integer> linkedList = new SortedList<>();
		linkedList.insertAll(list);
		assertEquals(6, linkedList.toArray().length, "Different Sizes");
		assertTrue(SortUtil.isOrdenedAcending(linkedList.toArray()), "Sorting failure");
	}
	
	@Test
	public void ordenedDescending(){
		Integer [] list = {6, 5, 4, 3, 2, 1};
		SortedList<Integer> linkedList = new SortedList<>();
		linkedList.insertAll(list);
		assertEquals(6, linkedList.toArray().length, "Different Sizes");
		assertTrue(SortUtil.isOrdenedAcending(linkedList.toArray()), "Sorting failure");
	}
}

package mamm.alg.datastructure;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;
import mamm.alg.sort.SortUtil;

import org.testng.annotations.Test;

public class SortedListTest {
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void insertNullElement(){
		SortedList<Integer,Object> linkedList = new SortedList<>();
		linkedList.insert(null);
	}
	
	@Test
	public void search(){
		SortedList<Integer,Object> linkedList = new SortedList<>();
		Element<Integer, Object> e1 = new Element<>(1, null);
		Element<Integer, Object> e2 = new Element<>(2, null);
		Element<Integer, Object> e3 = new Element<>(3, null);
		
		assertEquals(0, linkedList.getSize());
		linkedList.insert(e1);
		assertEquals(1, linkedList.getSize());
		linkedList.insert(e2);
		assertEquals(2, linkedList.getSize());
		linkedList.insert(e3);
		assertEquals(3, linkedList.getSize());
		
		assertEquals(e1, linkedList.search(e1).getElement());
		assertEquals(e2, linkedList.search(e2).getElement());
		assertEquals(e3, linkedList.search(e3).getElement());
	}
	
	@Test
	public void delete(){
		SortedList<Integer,Object> linkedList = new SortedList<>();
		Element<Integer, Object> e1 = new Element<>(1, null);
		Element<Integer, Object> e2 = new Element<>(2, null);
		Element<Integer, Object> e3 = new Element<>(3, null);
		
		assertEquals(0, linkedList.getSize());
		linkedList.insert(e1);
		assertEquals(1, linkedList.getSize());
		assertEquals(e1, linkedList.search(e1).getElement());
		linkedList.insert(e2);
		assertEquals(2, linkedList.getSize());
		assertEquals(e2, linkedList.search(e2).getElement());
		linkedList.insert(e3);
		assertEquals(3, linkedList.getSize());
		assertEquals(e3, linkedList.search(e3).getElement());
		
		linkedList.delete(e2);
		assertEquals(2, linkedList.getSize());
		assertEquals(e1, linkedList.search(e1).getElement());
		assertNull(linkedList.search(e2));
		assertEquals(e3, linkedList.search(e3).getElement());
	}
	
	@Test
	public void oneElement(){
		Float [] list = {0.1f};
		SortedList<Float,Object> linkedList = new SortedList<>();
		linkedList.insertAll(list);
		assertEquals(1, linkedList.getKeyArray().length, "Different Sizes");
		assertTrue(SortUtil.isOrdenedAcending(linkedList.getKeyArray()), "Sorting failure");
	}
	
	@Test
	public void twoElementsDesordened(){
		Float [] list = {0.5f, 0.2f};
		SortedList<Float,Object> linkedList = new SortedList<>();
		linkedList.insertAll(list);
		assertEquals(2, linkedList.getKeyArray().length, "Different Sizes");
		assertTrue(SortUtil.isOrdenedAcending(linkedList.getKeyArray()), "Sorting failure");
	}
	
	@Test
	public void twoElementsOrdened(){
		Float [] list = {0.2f, 0.3f};
		SortedList<Float,Object> linkedList = new SortedList<>();
		linkedList.insertAll(list);
		assertEquals(2, linkedList.getKeyArray().length, "Different Sizes");
		assertTrue(SortUtil.isOrdenedAcending(linkedList.getKeyArray()), "Sorting failure");
	}
	
	@Test
	public void desordened(){
		Float [] list = {0.5f, 0.2f, 0.4f, 0.6f, 0.1f, 0.3f};
		SortedList<Float,Object> linkedList = new SortedList<>();
		linkedList.insertAll(list);
		assertEquals(6, linkedList.getKeyArray().length, "Different Sizes");
		assertTrue(SortUtil.isOrdenedAcending(linkedList.getKeyArray()), "Sorting failure");
	}
	
	@Test
	public void ordenedAscending(){
		Integer [] list = {1, 2, 3, 4, 5, 6};
		SortedList<Integer,Object> linkedList = new SortedList<>();
		linkedList.insertAll(list);
		assertEquals(6, linkedList.getKeyArray().length, "Different Sizes");
		assertTrue(SortUtil.isOrdenedAcending(linkedList.getKeyArray()), "Sorting failure");
	}
	
	@Test
	public void ordenedDescending(){
		Integer [] list = {6, 5, 4, 3, 2, 1};
		SortedList<Integer,Object> linkedList = new SortedList<>();
		linkedList.insertAll(list);
		assertEquals(6, linkedList.getKeyArray().length, "Different Sizes");
		assertTrue(SortUtil.isOrdenedAcending(linkedList.getKeyArray()), "Sorting failure");
	}
}

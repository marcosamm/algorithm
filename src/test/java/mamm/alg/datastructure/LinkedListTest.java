package mamm.alg.datastructure;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class LinkedListTest {
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void insertNullElement(){
		LinkedList<Integer,Integer> linkedList = new LinkedList<>();
		linkedList.insert(null);
	}
	
	@Test
	public void search(){
		LinkedList<Integer,Integer> linkedList = new LinkedList<>();
		Element<Integer, Integer> e1 = new Element<>(1, null);
		Element<Integer, Integer> e2 = new Element<>(2, null);
		Element<Integer, Integer> e3 = new Element<>(3, null);
		
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
		LinkedList<Integer,Integer> linkedList = new LinkedList<>();
		Element<Integer, Integer> e1 = new Element<>(1, null);
		Element<Integer, Integer> e2 = new Element<>(2, null);
		Element<Integer, Integer> e3 = new Element<>(3, null);
		
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
		linkedList.delete(e3);
		linkedList.delete(e1);
		assertTrue(linkedList.isEmpty());
	}
}

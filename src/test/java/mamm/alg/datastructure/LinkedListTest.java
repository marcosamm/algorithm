package mamm.alg.datastructure;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

public class LinkedListTest {
	
	@Test
	public void search(){
		LinkedList<Integer,Integer> LinkedList2 = new LinkedList<>();
		Element<Integer, Integer> e1 = new Element<>(1, null);
		Element<Integer, Integer> e2 = new Element<>(2, null);
		Element<Integer, Integer> e3 = new Element<>(3, null);
		
		assertEquals(0, LinkedList2.getSize());
		LinkedList2.insert(e1);
		assertEquals(1, LinkedList2.getSize());
		LinkedList2.insert(e2);
		assertEquals(2, LinkedList2.getSize());
		LinkedList2.insert(e3);
		assertEquals(3, LinkedList2.getSize());
		
		assertEquals(e1, LinkedList2.search(e1).getElement());
		assertEquals(e2, LinkedList2.search(e2).getElement());
		assertEquals(e3, LinkedList2.search(e3).getElement());
	}
	
	@Test
	public void delete(){
		LinkedList<Integer,Integer> LinkedList2 = new LinkedList<>();
		Element<Integer, Integer> e1 = new Element<>(1, null);
		Element<Integer, Integer> e2 = new Element<>(2, null);
		Element<Integer, Integer> e3 = new Element<>(3, null);
		
		assertEquals(0, LinkedList2.getSize());
		LinkedList2.insert(e1);
		assertEquals(1, LinkedList2.getSize());
		assertEquals(e1, LinkedList2.search(e1).getElement());
		LinkedList2.insert(e2);
		assertEquals(2, LinkedList2.getSize());
		assertEquals(e2, LinkedList2.search(e2).getElement());
		LinkedList2.insert(e3);
		assertEquals(3, LinkedList2.getSize());
		assertEquals(e3, LinkedList2.search(e3).getElement());
		
		LinkedList2.delete(e2);
		assertEquals(2, LinkedList2.getSize());
		assertEquals(e1, LinkedList2.search(e1).getElement());
		assertNull(LinkedList2.search(e2));
		assertEquals(e3, LinkedList2.search(e3).getElement());
	}
}

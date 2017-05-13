package mamm.alg.datastructure;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

public class LinkedListTest {
	
	@Test
	public void search(){
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
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
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
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
}

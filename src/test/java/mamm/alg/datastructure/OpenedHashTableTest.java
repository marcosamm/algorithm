package mamm.alg.datastructure;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

public class OpenedHashTableTest {
	private final Integer [] ints = {10, 22, 31, 4, 15, 28, 18, 88, 59};
	
	
	
	@Test
	public void divisionMethodLinearProbing(){
		OpenedHashTable<Object> hashTable = new OpenedHashTable<>(11);
		for(Integer i : ints){
			hashTable.put(i, i);
		}
		
		String expected = 
				 "[22, 88, null, null, 4, 15, 28, 18, 59, 31, 10]\n";
		assertEquals(hashTable.toString(), expected);
		
		assertEquals(hashTable.get(ints[ints.length/2]), ints[ints.length/2]);
		assertEquals(hashTable.getSize(), ints.length);
		Integer removed = ints[ints.length/2];
		hashTable.remove(removed);
		assertNull(hashTable.get(removed));
		assertEquals(hashTable.getSize(), ints.length-1);
		
		expected = 
				"[22, 88, null, null, 4, DEL, 28, 18, 59, 31, 10]\n";
		assertEquals(hashTable.toString(), expected);
		assertEquals(hashTable.toString(), expected);
	}
	
	@Test
	public void divisionMethodQuadraticProbing(){
		OpenedHashTable<Object> hashTable = new OpenedHashTable<>(11, 1.0f, 3.0f);
		for(Integer i : ints){
			hashTable.put(i, i);
		}
		
		String expected = 
				 "[22, 59, null, 88, 4, null, 28, 18, 15, 31, 10]\n";
		assertEquals(hashTable.toString(), expected);
		
		assertEquals(hashTable.get(ints[ints.length/2]), ints[ints.length/2]);
		assertEquals(hashTable.getSize(), ints.length);
		Integer removed = ints[ints.length/2];
		hashTable.remove(removed);
		assertNull(hashTable.get(removed));
		assertEquals(hashTable.getSize(), ints.length-1);
		
		expected = 
				"[22, 59, null, 88, 4, null, 28, 18, DEL, 31, 10]\n";
		assertEquals(hashTable.toString(), expected);
		assertEquals(hashTable.toString(), expected);
	}
}
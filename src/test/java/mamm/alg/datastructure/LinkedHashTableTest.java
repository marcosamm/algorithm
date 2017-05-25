package mamm.alg.datastructure;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import mamm.alg.datastructure.HashTable.HashMethod;

import org.testng.annotations.Test;

public class LinkedHashTableTest {
	private final Integer i0 = 0;
	private final Integer i1 = 1;
	private final Integer i2 = 2;
	private final Integer i3 = 3;
	
	@Test
	public void searchDivisionMethod(){
		LinkedHashTable<Object> hashTable = new LinkedHashTable<>(2);
		assertEquals(0, hashTable.getSize());
		hashTable.put(i0, i0);
		assertEquals(1, hashTable.getSize());
		hashTable.put(i1, i1);
		assertEquals(2, hashTable.getSize());
		hashTable.put(i2, i2);
		assertEquals(3, hashTable.getSize());
		hashTable.put(i3, i3);
		assertEquals(4, hashTable.getSize());
		
		assertEquals(i0, hashTable.get(i0));
		assertEquals(i1, hashTable.get(i1));
		assertEquals(i2, hashTable.get(i2));
		assertEquals(i3, hashTable.get(i3));
	}
	
	@Test
	public void deleteDivisionMethod(){
		LinkedHashTable<Object> hashTable = new LinkedHashTable<>(2);
		
		assertEquals(0, hashTable.getSize());
		hashTable.put(i0, i0);
		assertEquals(1, hashTable.getSize());
		hashTable.put(i1, i1);
		assertEquals(2, hashTable.getSize());
		assertEquals(i1, hashTable.get(i1));
		hashTable.put(i2, i2);
		assertEquals(3, hashTable.getSize());
		assertEquals(i2, hashTable.get(i2));
		hashTable.put(i3, i3);
		assertEquals(4, hashTable.getSize());
		assertEquals(i3, hashTable.get(i3));
		
		hashTable.remove(i2);
		assertEquals(3, hashTable.getSize());
		assertEquals(i1, hashTable.get(i1));
		assertNull(hashTable.get(i2));
		assertEquals(i3, hashTable.get(i3));
	}
	
	@Test
	public void colisionDivisionMethod(){
		LinkedHashTable<Object> hashTable = new LinkedHashTable<>(5);
		
		for(int i = -20; i <= 20; i++){
			hashTable.put(i, i);
		}
		
		String expected = 
				 "[0] => 20, 15, 10, 5, 0, -5, -10, -15, -20\n"
				+"[1] => 16, 11, 6, 1, -1, -6, -11, -16\n"
				+"[2] => 17, 12, 7, 2, -2, -7, -12, -17\n"
				+"[3] => 18, 13, 8, 3, -3, -8, -13, -18\n"
				+"[4] => 19, 14, 9, 4, -4, -9, -14, -19\n";
		
		assertEquals(3, hashTable.get(3));
		assertEquals(41, hashTable.getSize());
		assertEquals(hashTable.toString(), expected);
	}
	
	@Test
	public void searchMultiplicationMethod(){
		LinkedHashTable<Object> hashTable = new LinkedHashTable<>(2, HashMethod.MULTIPLICATION);
		assertEquals(0, hashTable.getSize());
		hashTable.put(i0, i0);
		assertEquals(1, hashTable.getSize());
		hashTable.put(i1, i1);
		assertEquals(2, hashTable.getSize());
		hashTable.put(i2, i2);
		assertEquals(3, hashTable.getSize());
		hashTable.put(i3, i3);
		assertEquals(4, hashTable.getSize());
		
		assertEquals(i0, hashTable.get(i0));
		assertEquals(i1, hashTable.get(i1));
		assertEquals(i2, hashTable.get(i2));
		assertEquals(i3, hashTable.get(i3));
	}
	
	@Test
	public void deleteMultiplicationMethod(){
		LinkedHashTable<Object> hashTable = new LinkedHashTable<>(2, HashMethod.MULTIPLICATION);
		
		assertEquals(0, hashTable.getSize());
		hashTable.put(i0, i0);
		assertEquals(1, hashTable.getSize());
		hashTable.put(i1, i1);
		assertEquals(2, hashTable.getSize());
		assertEquals(i1, hashTable.get(i1));
		hashTable.put(i2, i2);
		assertEquals(3, hashTable.getSize());
		assertEquals(i2, hashTable.get(i2));
		hashTable.put(i3, i3);
		assertEquals(4, hashTable.getSize());
		assertEquals(i3, hashTable.get(i3));
		
		hashTable.remove(i2);
		assertEquals(3, hashTable.getSize());
		assertEquals(i1, hashTable.get(i1));
		assertNull(hashTable.get(i2));
		assertEquals(i3, hashTable.get(i3));
	}
	
	@Test
	public void colisionMultiplicationMethod(){
		LinkedHashTable<Object> hashTable = new LinkedHashTable<>(5, HashMethod.MULTIPLICATION);
		
		for(int i = -20; i <= 20; i++){
			hashTable.put(i, i);
		}
		
		String expected = 
				 "[0] => 18, 13, 10, 5, 0, -5, -10, -13, -18\n"
				+"[1] => 20, 15, 7, 2, -2, -7, -15, -20\n"
				+"[2] => 17, 12, 9, 4, -4, -9, -12, -17\n"
				+"[3] => 19, 14, 11, 6, 1, -1, -6, -11, -14, -19\n"
				+"[4] => 16, 8, 3, -3, -8, -16\n";
		
		assertEquals(3, hashTable.get(3));
		assertEquals(41, hashTable.getSize());
		assertEquals(hashTable.toString(), expected);
	}
	
	@Test
	public void searchUniversalMethod(){
		LinkedHashTable<Object> hashTable = new LinkedHashTable<>(6, 17);
		assertEquals(0, hashTable.getSize());
		hashTable.put(i0, i0);
		assertEquals(1, hashTable.getSize());
		hashTable.put(i1, i1);
		assertEquals(2, hashTable.getSize());
		hashTable.put(i2, i2);
		assertEquals(3, hashTable.getSize());
		hashTable.put(i3, i3);
		assertEquals(4, hashTable.getSize());
		
		assertEquals(i0, hashTable.get(i0));
		assertEquals(i1, hashTable.get(i1));
		assertEquals(i2, hashTable.get(i2));
		assertEquals(i3, hashTable.get(i3));
	}
	
	@Test
	public void deleteUniversalMethod(){
		LinkedHashTable<Object> hashTable = new LinkedHashTable<>(6, 17);
		
		assertEquals(0, hashTable.getSize());
		hashTable.put(i0, i0);
		assertEquals(1, hashTable.getSize());
		hashTable.put(i1, i1);
		assertEquals(2, hashTable.getSize());
		assertEquals(i1, hashTable.get(i1));
		hashTable.put(i2, i2);
		assertEquals(3, hashTable.getSize());
		assertEquals(i2, hashTable.get(i2));
		hashTable.put(i3, i3);
		assertEquals(4, hashTable.getSize());
		assertEquals(i3, hashTable.get(i3));
		
		hashTable.remove(i2);
		assertEquals(3, hashTable.getSize());
		assertEquals(i1, hashTable.get(i1));
		assertNull(hashTable.get(i2));
		assertEquals(i3, hashTable.get(i3));
	}
	
	@Test
	public void colisionUniversalMethod(){
		LinkedHashTable<Object> hashTable = new LinkedHashTable<>(6, 17, 3, 13);
		
		for(int i = 0; i <= 20; i++){
			hashTable.put(i, i);
		}
		
		String expected = 
				 "[0] => 11, 9, 7\n"
				+"[1] => 17, 15, 13, 0\n"
				+"[2] => 19, 6, 4, 2\n"
				+"[3] => 12, 10, 8\n"
				+"[4] => 18, 16, 14, 1\n"
				+"[5] => 20, 5, 3\n";
		
		assertEquals(3, hashTable.get(3));
		assertEquals(21, hashTable.getSize());
		assertEquals(hashTable.toString(), expected);
	}
}
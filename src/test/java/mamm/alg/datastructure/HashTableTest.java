package mamm.alg.datastructure;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

public class HashTableTest {
	
	@Test
	public void search(){
		HashTable<Object> hashTable = new HashTable<>(2);
		Integer i0 = 0;
		Integer i1 = 1;
		Integer i2 = 2;
		Integer i3 = 3;
		
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
	public void delete(){
		HashTable<Object> hashTable = new HashTable<>(2);
		Integer i0 = 0;
		Integer i1 = 1;
		Integer i2 = 2;
		Integer i3 = 3;
		
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
	public void colision(){
		HashTable<Object> hashTable = new HashTable<>(5);
		Integer i0 = 0;
		Integer i1 = 1;
		Integer i2 = 2;
		Integer i3 = 3;
		Integer i4 = 4;
		Integer i5 = 5;
		Integer i6 = 6;
		Integer i1n = -1;
		Integer i2n = -2;
		Integer i3n = -3;
		Integer i4n = -4;
		Integer i5n = -5;
		Integer i6n = -6;
		
		hashTable.put(i0, i0);
		hashTable.put(i1, i1);
		hashTable.put(i2, i2);
		hashTable.put(i3, i3);
		hashTable.put(i4, i4);
		hashTable.put(i5, i5);
		hashTable.put(i6, i6);
		hashTable.put(i1n, i1n);
		hashTable.put(i2n, i2n);
		hashTable.put(i3n, i3n);
		hashTable.put(i4n, i4n);
		hashTable.put(i5n, i5n);
		hashTable.put(i6n, i6n);
		
		String esperada = 
				 "[0] => -5, 5, 0\n"
				+"[1] => -6, -1, 6, 1\n"
				+"[2] => -2, 2\n"
				+"[3] => -3, 3\n"
				+"[4] => -4, 4\n";
		
		assertEquals(i3n, hashTable.get(i3n));
		assertEquals(13, hashTable.getSize());
		assertEquals(hashTable.toString(), esperada);
	}
}

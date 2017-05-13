package mamm.alg.sort;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class SortUtilTest {
	
	@Test
	public void desordened(){
		Integer [] list = {5, 2, 4, 6, 1, 3};
		assertFalse(SortUtil.isOrdenedAcending(list));
		assertFalse(SortUtil.isOrdenedDescending(list));
	}
	
	@Test
	public void ordenedAscending(){
		Integer [] list = {1, 2, 3, 4, 5, 6};
		assertTrue(SortUtil.isOrdenedAcending(list));
		assertFalse(SortUtil.isOrdenedDescending(list));
	}
	
	@Test
	public void ordenedDescending(){
		Integer [] list = {6, 5, 4, 3, 2, 1};
		assertFalse(SortUtil.isOrdenedAcending(list));
		assertTrue(SortUtil.isOrdenedDescending(list));
	}
}

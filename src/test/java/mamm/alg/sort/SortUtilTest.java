package mamm.alg.sort;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class SortUtilTest {
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void isOrdenedAcendingNullArray(){
		Integer [] list = null;
		SortUtil.isOrdenedAcending(list);
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void isOrdenedDescendingNullArray(){
		Integer [] list = null;
		SortUtil.isOrdenedDescending(list);
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void getHighestPossibleValueOfNullValue(){
		SortUtil.getHighestPossibleValueOf(null);
	}
	
	@Test(expectedExceptions = RuntimeException.class)
	public void getHighestPossibleValueOfObjectWithoutMinMaxValue(){
		SortUtil.getHighestPossibleValueOf(new String());
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void getLowestPossibleValueOfNullValue(){
		SortUtil.getLowestPossibleValueOf(null);
	}
	
	@Test(expectedExceptions = RuntimeException.class)
	public void getLowestPossibleValueOfObjectWithoutMinMaxValue(){
		SortUtil.getLowestPossibleValueOf(new String());
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void getMinValueWithNullValue(){
		SortUtil.getMinValue(null);
	}
	
	@Test
	public void getMinValue(){
		Integer [] list = {5, 2, 4, 6, 1, 3};
		assertEquals(SortUtil.getMinValue(list), new Integer(1));
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void getMaxValueWithNullValue(){
		SortUtil.getMaxValue(null);
	}
	
	@Test
	public void getMaxValue(){
		Integer [] list = {5, 2, 4, 6, 1, 3};
		assertEquals(SortUtil.getMaxValue(list), new Integer(6));
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void sameNumberOfDigitsWithNullArray(){
		SortUtil.sameNumberOfDigits(null);
	}
	
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

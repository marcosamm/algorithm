package mamm.alg.search;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class MaxSubarrayTest {
	Integer [] list1 = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
	Integer [] list2 = {10, 5, -17, 20, 50, -1, 3, -30, 10};
	Integer [] list3 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void findMaximumSubarrayRecursiveEmptyArray(){
		MaxSubarray maxSubarray = new MaxSubarray();
		maxSubarray.findMaximumSubarrayRecursive(new Integer[0]);
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void findMaximumSubarrayLinearEmptyArray(){
		MaxSubarray maxSubarray = new MaxSubarray();
		maxSubarray.findMaximumSubarrayLinear(new Integer[0]);
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void findMaximumSubarrayRecursiveNullArray(){
		MaxSubarray maxSubarray = new MaxSubarray();
		maxSubarray.findMaximumSubarrayRecursive(null);
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void findMaximumSubarrayLinearNullArray(){
		MaxSubarray maxSubarray = new MaxSubarray();
		maxSubarray.findMaximumSubarrayLinear(null);
	}
	
	@Test
	public void testRecursive1(){
		MaxSubarray maxSubarray = new MaxSubarray();
		MaxSubarray.MaxCrossingValues maxCrossingValues = maxSubarray.findMaximumSubarrayRecursive(list1);
		assertEquals(maxCrossingValues.getMaxLeft(), 7, "Error in max-left");
		assertEquals(maxCrossingValues.getMaxRight(), 10, "Error in max-right");
		assertEquals(maxCrossingValues.getSum(), 43, "Error in sum");
	}
	
	@Test
	public void testLinear1(){
		MaxSubarray maxSubarray = new MaxSubarray();
		MaxSubarray.MaxCrossingValues maxCrossingValues = maxSubarray.findMaximumSubarrayLinear(list1);
		assertEquals(maxCrossingValues.getMaxLeft(), 7, "Error in max-left");
		assertEquals(maxCrossingValues.getMaxRight(), 10, "Error in max-right");
		assertEquals(maxCrossingValues.getSum(), 43, "Error in sum");
	}
	
	@Test
	public void testRecursive2(){
		MaxSubarray maxSubarray = new MaxSubarray();
		MaxSubarray.MaxCrossingValues maxCrossingValues = maxSubarray.findMaximumSubarrayRecursive(list2);
		assertEquals(maxCrossingValues.getMaxLeft(), 3, "Error in max-left");
		assertEquals(maxCrossingValues.getMaxRight(), 6, "Error in max-right");
		assertEquals(maxCrossingValues.getSum(), 72, "Error in sum");
	}
	
	@Test
	public void testLinear2(){
		MaxSubarray maxSubarray = new MaxSubarray();
		MaxSubarray.MaxCrossingValues maxCrossingValues = maxSubarray.findMaximumSubarrayLinear(list2);
		assertEquals(maxCrossingValues.getMaxLeft(), 3, "Error in max-left");
		assertEquals(maxCrossingValues.getMaxRight(), 6, "Error in max-right");
		assertEquals(maxCrossingValues.getSum(), 72, "Error in sum");
	}
	
	@Test
	public void testRecursive3(){
		MaxSubarray maxSubarray = new MaxSubarray();
		MaxSubarray.MaxCrossingValues maxCrossingValues = maxSubarray.findMaximumSubarrayRecursive(list3);
		assertEquals(maxCrossingValues.getMaxLeft(), 3, "Error in max-left");
		assertEquals(maxCrossingValues.getMaxRight(), 6, "Error in max-right");
		assertEquals(maxCrossingValues.getSum(), 6, "Error in sum");
	}
	
	@Test
	public void testLinear3(){
		MaxSubarray maxSubarray = new MaxSubarray();
		MaxSubarray.MaxCrossingValues maxCrossingValues = maxSubarray.findMaximumSubarrayLinear(list3);
		assertEquals(maxCrossingValues.getMaxLeft(), 3, "Error in max-left");
		assertEquals(maxCrossingValues.getMaxRight(), 6, "Error in max-right");
		assertEquals(maxCrossingValues.getSum(), 6, "Error in sum");
	}
}

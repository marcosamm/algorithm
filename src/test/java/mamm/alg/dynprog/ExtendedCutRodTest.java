package mamm.alg.dynprog;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class ExtendedCutRodTest {
	private final Float [] prices = {0f, 1f, 5f, 8f, 9f, 10f, 17f, 17f, 20f, 24f, 30f};
	private ExtendedCutRod cutRod = new ExtendedCutRod(prices);
	
	@Test
	public void recursiveCutRod(){
		assertEquals(cutRod.recursiveCutRod(1), 1f);
		assertEquals(cutRod.getRecursiveCutRodSolution(1), "1");
		assertEquals(cutRod.recursiveCutRod(2), 5f);
		assertEquals(cutRod.getRecursiveCutRodSolution(2), "2");
		assertEquals(cutRod.recursiveCutRod(3), 8f);
		assertEquals(cutRod.getRecursiveCutRodSolution(3), "3");
		assertEquals(cutRod.recursiveCutRod(4), 10f);
		assertEquals(cutRod.getRecursiveCutRodSolution(4), "2 2");
		assertEquals(cutRod.recursiveCutRod(5), 13f);
		assertEquals(cutRod.getRecursiveCutRodSolution(5), "2 3");
		assertEquals(cutRod.recursiveCutRod(6), 17f);
		assertEquals(cutRod.getRecursiveCutRodSolution(6), "6");
		assertEquals(cutRod.recursiveCutRod(7), 18f);
		assertTrue(cutRod.getRecursiveCutRodSolution(7).equals("1 6") || cutRod.getRecursiveCutRodSolution(6).equals("2 2 3"));
		assertEquals(cutRod.recursiveCutRod(8), 22f);
		assertEquals(cutRod.getRecursiveCutRodSolution(8), "2 6");
		assertEquals(cutRod.recursiveCutRod(9), 25f);
		assertEquals(cutRod.getRecursiveCutRodSolution(9), "3 6");
		assertEquals(cutRod.recursiveCutRod(10), 30f);
		assertEquals(cutRod.getRecursiveCutRodSolution(10), "10");
	}
	
	@Test
	public void bottomUpCutRod(){
		String 
		expected = "1";
		assertEquals(cutRod.getBottomUpCutRodSolution(1), expected);
		
		assertEquals(cutRod.bottomUpCutRod(1), 1f);
		assertEquals(cutRod.getBottomUpCutRodSolution(1), "1");
		assertEquals(cutRod.bottomUpCutRod(2), 5f);
		assertEquals(cutRod.getBottomUpCutRodSolution(2), "2");
		assertEquals(cutRod.bottomUpCutRod(3), 8f);
		assertEquals(cutRod.getBottomUpCutRodSolution(3), "3");
		assertEquals(cutRod.bottomUpCutRod(4), 10f);
		assertEquals(cutRod.getBottomUpCutRodSolution(4), "2 2");
		assertEquals(cutRod.bottomUpCutRod(5), 13f);
		assertEquals(cutRod.getBottomUpCutRodSolution(5), "2 3");
		assertEquals(cutRod.bottomUpCutRod(6), 17f);
		assertEquals(cutRod.getBottomUpCutRodSolution(6), "6");
		assertEquals(cutRod.bottomUpCutRod(7), 18f);
		assertTrue(cutRod.getBottomUpCutRodSolution(7).equals("1 6") || cutRod.getBottomUpCutRodSolution(6).equals("2 2 3"));
		assertEquals(cutRod.bottomUpCutRod(8), 22f);
		assertEquals(cutRod.getBottomUpCutRodSolution(8), "2 6");
		assertEquals(cutRod.bottomUpCutRod(9), 25f);
		assertEquals(cutRod.getBottomUpCutRodSolution(9), "3 6");
		assertEquals(cutRod.bottomUpCutRod(10), 30f);
		assertEquals(cutRod.getBottomUpCutRodSolution(10), "10");
	}
}
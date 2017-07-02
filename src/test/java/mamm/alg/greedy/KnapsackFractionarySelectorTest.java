package mamm.alg.greedy;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class KnapsackFractionarySelectorTest {
	
	
	@Test
	public void cormemExample(){
		int [] w = {10, 20, 30};
		Float [] v = {60f, 100f, 120f};
		KnapsackFractionarySelector knapsack = new KnapsackFractionarySelector(w, v);
		assertEquals(knapsack.fractionarySelector(50), 240f);
		String expected = 
				"0: 10kg x $6.0 = $60.0\n"+
				"1: 20kg x $5.0 = $100.0\n"+
				"2: 20kg x $4.0 = $80.0\n"+
				"Tot.: $240.0";
		assertEquals(knapsack.getKnapsackString(), expected);
	}
	
	@Test
	public void capacity0(){
		int [] w = {1, 2, 3};
		Float [] v = {6f, 10f, 12f};
		KnapsackFractionarySelector knapsack = new KnapsackFractionarySelector(w, v);
		assertEquals(knapsack.fractionarySelector(0), 0f);
		String expected = "Tot.: $0.0";
		assertEquals(knapsack.getKnapsackString(), expected);
	}
	
	@Test(expectedExceptions=IllegalArgumentException.class)
	public void incompatiblesLengths(){
		int [] w = {10, 20};
		Float [] v = {60f, 100f, 120f};
		new KnapsackFractionarySelector(w, v);
	}
	
	@Test(expectedExceptions=IllegalArgumentException.class)
	public void nullArrayS(){
		int [] w = null;
		Float [] v = {60f, 100f, 120f};
		new KnapsackFractionarySelector(w, v);
	}
	
	@Test(expectedExceptions=IllegalArgumentException.class)
	public void nullArrayF(){
		int [] w = {10, 20, 30};
		Float [] v = null;
		new KnapsackFractionarySelector(w, v);
	}
	
	@Test(expectedExceptions=IllegalArgumentException.class)
	public void emptyArrays(){
		int [] w = {};
		Float [] v = {};
		new KnapsackFractionarySelector(w, v);
	}
}
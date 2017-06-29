package mamm.alg.greedy;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class KnapsackTest {
	
	
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
}
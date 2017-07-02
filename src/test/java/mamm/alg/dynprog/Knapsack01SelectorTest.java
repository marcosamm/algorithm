package mamm.alg.dynprog;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class Knapsack01SelectorTest {
	
	
	@Test
	public void cormemExample(){
		int [] w = {10, 20, 30};
		Float [] v = {60f, 100f, 120f};
		Knapsack01Selector knapsack = new Knapsack01Selector(w, v, 50);
		assertEquals(knapsack.select(), 220f);
		String expected = 
				"2: 30kg - $120.0\n"+
				"1: 20kg - $100.0\n"+
				"Tot.: $220.0";
		assertEquals(knapsack.getKnapsackString(), expected);
	}
	
	@Test
	public void noneEelement(){
		int [] w = {10, 20, 30};
		Float [] v = {60f, 100f, 120f};
		Knapsack01Selector knapsack = new Knapsack01Selector(w, v, 9);
		assertEquals(knapsack.select(), 0f);
		String expected = 
				"Tot.: $0.0";
		assertEquals(knapsack.getKnapsackString(), expected);
	}
	
	@Test
	public void firstEelement(){
		int [] w = {10, 20, 30};
		Float [] v = {60f, 100f, 120f};
		Knapsack01Selector knapsack = new Knapsack01Selector(w, v, 10);
		assertEquals(knapsack.select(), 60f);
		String expected = 
				"0: 10kg - $60.0\n"+
				"Tot.: $60.0";
		assertEquals(knapsack.getKnapsackString(), expected);
		
		knapsack = new Knapsack01Selector(w, v, 19);
		assertEquals(knapsack.select(), 60f);
		assertEquals(knapsack.getKnapsackString(), expected);
	}
	
	@Test
	public void secondEelement(){
		int [] w = {10, 20, 30};
		Float [] v = {60f, 100f, 120f};
		Knapsack01Selector knapsack = new Knapsack01Selector(w, v, 20);
		assertEquals(knapsack.select(), 100f);
		String expected = 
				"1: 20kg - $100.0\n"+
				"Tot.: $100.0";
		assertEquals(knapsack.getKnapsackString(), expected);
		
		knapsack = new Knapsack01Selector(w, v, 29);
		assertEquals(knapsack.select(), 100f);
		assertEquals(knapsack.getKnapsackString(), expected);
	}
	
	@Test
	public void lastEelement(){
		int [] w = {10, 20, 30};
		Float [] v = {60f, 100f, 120f};
		Knapsack01Selector knapsack = new Knapsack01Selector(w, v, 30);
		assertEquals(knapsack.select(), 120f);
		String expected = 
				"2: 30kg - $120.0\n"+
				"Tot.: $120.0";
		assertEquals(knapsack.getKnapsackString(), expected);
		
		knapsack = new Knapsack01Selector(w, v, 39);
		assertEquals(knapsack.select(), 120f);
		assertEquals(knapsack.getKnapsackString(), expected);
	}
	
	@Test(expectedExceptions=IllegalArgumentException.class)
	public void incompatiblesLengths(){
		int [] w = {10, 20};
		Float [] v = {60f, 100f, 120f};
		new Knapsack01Selector(w, v, 50);
	}
	
	@Test(expectedExceptions=IllegalArgumentException.class)
	public void nullArrayS(){
		int [] w = null;
		Float [] v = {60f, 100f, 120f};
		new Knapsack01Selector(w, v, 50);
	}
	
	@Test(expectedExceptions=IllegalArgumentException.class)
	public void nullArrayF(){
		int [] w = {10, 20, 30};
		Float [] v = null;
		new Knapsack01Selector(w, v, 50);
	}
	
	@Test(expectedExceptions=IllegalArgumentException.class)
	public void emptyArrays(){
		int [] w = {};
		Float [] v = {};
		new Knapsack01Selector(w, v, 50);
	}
}
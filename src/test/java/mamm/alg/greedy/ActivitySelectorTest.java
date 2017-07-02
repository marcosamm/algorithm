package mamm.alg.greedy;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ActivitySelectorTest {
	
	
	@Test
	public void recursive(){
		int [] s = {1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
		int [] f = {4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
		ActivitySelector actSel = new ActivitySelector(s, f);
		assertEquals(actSel.recursiveActivitySelector(), "A1 A4 A8 A11");
	}
	
	@Test
	public void interative(){
		int [] s = {1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
		int [] f = {4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
		ActivitySelector actSel = new ActivitySelector(s, f);
		assertEquals(actSel.iterativeActivitySelector(), "A1 A4 A8 A11");
	}
	
	@Test(expectedExceptions=IllegalArgumentException.class)
	public void incompatiblesLengths(){
		int [] s = {1, 3, 0, 5, 3, 5, 6, 8, 8, 2};
		int [] f = {4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
		new ActivitySelector(s, f);
	}
	
	@Test(expectedExceptions=IllegalArgumentException.class)
	public void nullArrayS(){
		int [] s = null;
		int [] f = {4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
		new ActivitySelector(s, f);
	}
	
	@Test(expectedExceptions=IllegalArgumentException.class)
	public void nullArrayF(){
		int [] s = {2};
		int [] f = null;
		new ActivitySelector(s, f);
	}
	
	@Test(expectedExceptions=IllegalArgumentException.class)
	public void emptyArrays(){
		int [] s = {};
		int [] f = {};
		new ActivitySelector(s, f);
	}
}
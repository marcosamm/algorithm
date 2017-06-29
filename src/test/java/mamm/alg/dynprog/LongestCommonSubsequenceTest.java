package mamm.alg.dynprog;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class LongestCommonSubsequenceTest {
	
	
	@Test
	public void cormenExample(){
		char [] x = {'A', 'B', 'C', 'B', 'D', 'A', 'B'};
		char [] y = {'B', 'D', 'C', 'A', 'B', 'A'};
		LongestCommonSubsequence lcs = new LongestCommonSubsequence(x, y);
		assertEquals(lcs.getLcs(), "BCBA");
	}
	
	@Test
	public void cormenExercise15_4_1(){
		char [] x = {'0', '1', '0', '1', '1', '0', '1', '1', '0'};
		char [] y = {'1', '0', '0', '1', '0', '1', '0', '1'};
		LongestCommonSubsequence lcs = new LongestCommonSubsequence(x, y);
		assertEquals(lcs.getLcs(), "010101");
	}
}
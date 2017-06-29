package mamm.alg.dynprog;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ExtendedMatrixChainTest {
	//A1(30x35), A2(35x15), A3(15x5), A4(5x10), A5(10x20) and A6(20x25)
	private final int [] dimensions = {30, 35, 15, 5, 10, 20, 25};
	private ExtendedMatrixChain matrixChain = new ExtendedMatrixChain(dimensions);
	
	@Test
	public void cormenExample(){
		assertEquals(matrixChain.getOptimalParents(), "((A1 (A2 A3)) ((A4 A5) A6))");
	}
}
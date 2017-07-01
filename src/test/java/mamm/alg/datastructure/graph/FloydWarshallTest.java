package mamm.alg.datastructure.graph;

import static mamm.alg.datastructure.graph.FloydWarshall.INF;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;


public class FloydWarshallTest {
	Integer [][] w = 
		{
			{  0,   3,   8, INF,  -4},
			{INF,   0, INF,   1,   7},
			{INF,   4,   0, INF, INF},
			{  2, INF,  -5,   0, INF},
			{INF, INF, INF,   6,   0},
		};
	
	@Test
	public void cormemExample(){
		FloydWarshall fw = new FloydWarshall(w);
		assertFalse(fw.calc());
		String expected =
			"D:\n" +
			"0 1 -3 2 -4\n" +
			"3 0 -4 1 -1\n" +
			"7 4 0 5 3\n" +
			"2 -1 -5 0 -2\n" +
			"8 5 1 6 0\n" +
			"\n" +
			"P:\n" +
			"NIL 2 3 4 0\n" +
			"3 NIL 3 1 0\n" +
			"3 2 NIL 1 0\n" +
			"3 2 3 NIL 0\n" +
			"3 2 3 4 NIL\n" +
			"\n" +
			"SHORTEST PATHS:\n" +
			"0-0: 0\n" +
			"0-1: 0 4 3 2 1\n" +
			"0-2: 0 4 3 2\n" +
			"0-3: 0 4 3\n" +
			"0-4: 0 4\n" +
			"1-0: 1 3 0\n" +
			"1-1: 1\n" +
			"1-2: 1 3 2\n" +
			"1-3: 1 3\n" +
			"1-4: 1 3 0 4\n" +
			"2-0: 2 1 3 0\n" +
			"2-1: 2 1\n" +
			"2-2: 2\n" +
			"2-3: 2 1 3\n" +
			"2-4: 2 1 3 0 4\n" +
			"3-0: 3 0\n" +
			"3-1: 3 2 1\n" +
			"3-2: 3 2\n" +
			"3-3: 3\n" +
			"3-4: 3 0 4\n" +
			"4-0: 4 3 0\n" +
			"4-1: 4 3 2 1\n" +
			"4-2: 4 3 2\n" +
			"4-3: 4 3\n" +
			"4-4: 4\n";
		assertEquals(fw.getStringCheck(), expected);
	}
}
package mamm.alg.app;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.reporters.Files;

public class FloydWarshallAppTest {
	
	@Test
	public void directory() throws IOException{
		FilenameFilter ff = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith("input.txt");
			}
		};
		File folder = new File("src/test/resources/floydwarshall/");
		for(File file : folder.listFiles(ff)){
			FloydWarshallApp fwApp = new FloydWarshallApp();
			fwApp.process(file.getAbsolutePath());
			String expected = Files.readFile(new File(file.getAbsolutePath().replace("input", "output")));
			assertEquals(fwApp.getStringCheck(), expected);
		}
	}
	
	@Test
	public void shortestPath() throws IOException{
		File file = new File("src/test/resources/floydwarshall/cormen_example_input.txt");
		FloydWarshallApp fwApp = new FloydWarshallApp();
		fwApp.process(file.getAbsolutePath());
		assertEquals(fwApp.getShortestPath(0, 3), "0 4 3");
	}
	
	@Test
	public void prints() throws IOException{
		File file = new File("src/test/resources/floydwarshall/cormen_example_input.txt");
		FloydWarshallApp fwApp = new FloydWarshallApp();
		fwApp.process(file.getAbsolutePath());
		String expectedMatrixD =
			"0 1 -3 2 -4\n" +
			"3 0 -4 1 -1\n" +
			"7 4 0 5 3\n" +
			"2 -1 -5 0 -2\n" +
			"8 5 1 6 0\n";
		assertEquals(fwApp.getMatrixD(), expectedMatrixD);
		String expectedMatrixP =
			"NIL 2 3 4 0\n" +
			"3 NIL 3 1 0\n" +
			"3 2 NIL 1 0\n" +
			"3 2 3 NIL 0\n" +
			"3 2 3 4 NIL\n";
		assertEquals(fwApp.getMatrixP(), expectedMatrixP);
		assertEquals(fwApp.getQtdVertices(), 5);
	}
	
	@Test(expectedExceptions = IOException.class)
	public void invalidNumberOfVertices() throws IOException{
		File file = new File("src/test/resources/floydwarshall/invalid_number_of_vertices_in.txt");
		FloydWarshallApp fwApp = new FloydWarshallApp();
		fwApp.process(file.getAbsolutePath());
	}
	
	@Test(expectedExceptions = IOException.class)
	public void invalidNoneNumberOfVertices() throws IOException{
		File file = new File("src/test/resources/floydwarshall/invalid_none_number_of_vertices_in.txt");
		FloydWarshallApp fwApp = new FloydWarshallApp();
		fwApp.process(file.getAbsolutePath());
	}
	
	@Test(expectedExceptions = IOException.class)
	public void invalidNumberNegativeOfVertices() throws IOException{
		File file = new File("src/test/resources/floydwarshall/invalid_number_negative_of_vertices_in.txt");
		FloydWarshallApp fwApp = new FloydWarshallApp();
		fwApp.process(file.getAbsolutePath());
	}
	
	@Test(expectedExceptions = IOException.class)
	public void invalidNumberOfWeightsOneLineVertices() throws IOException{
		File file = new File("src/test/resources/floydwarshall/invalid_numbers_of_weights_one_line_in.txt");
		FloydWarshallApp fwApp = new FloydWarshallApp();
		fwApp.process(file.getAbsolutePath());
	}
	
	@Test(expectedExceptions = IOException.class)
	public void invalidNumberOfRows() throws IOException{
		File file = new File("src/test/resources/floydwarshall/invalid_number_of_rows_in.txt");
		FloydWarshallApp fwApp = new FloydWarshallApp();
		fwApp.process(file.getAbsolutePath());
	}
	
	@Test(expectedExceptions = IOException.class)
	public void invalidNumberOfColumns() throws IOException{
		File file = new File("src/test/resources/floydwarshall/invalid_number_of_columns_in.txt");
		FloydWarshallApp fwApp = new FloydWarshallApp();
		fwApp.process(file.getAbsolutePath());
	}
	
	@Test(expectedExceptions = IOException.class)
	public void invalidWhileLineColumn() throws IOException{
		File file = new File("src/test/resources/floydwarshall/invalid_while_line_column_in.txt");
		FloydWarshallApp fwApp = new FloydWarshallApp();
		fwApp.process(file.getAbsolutePath());
	}
	
	@Test
	public void negativeCycle() throws IOException{
		File file = new File("src/test/resources/floydwarshall/negative_cycle_input.txt");
		FloydWarshallApp fwApp = new FloydWarshallApp();
		fwApp.process(file.getAbsolutePath());
		assertEquals(fwApp.getShortestPath(0, 3), "Negative cycle detected");
	}
	
	@Test(expectedExceptions=IllegalArgumentException.class)
	public void negativeParameterI() throws IOException{
		File file = new File("src/test/resources/floydwarshall/negative_cycle_input.txt");
		FloydWarshallApp fwApp = new FloydWarshallApp();
		fwApp.process(file.getAbsolutePath());
		assertEquals(fwApp.getShortestPath(-1, 3), "");
	}
	
	@Test(expectedExceptions=IllegalArgumentException.class)
	public void negativeParameterJ() throws IOException{
		File file = new File("src/test/resources/floydwarshall/negative_cycle_input.txt");
		FloydWarshallApp fwApp = new FloydWarshallApp();
		fwApp.process(file.getAbsolutePath());
		assertEquals(fwApp.getShortestPath(1, -3), "");
	}
	
	@Test(expectedExceptions=IllegalArgumentException.class)
	public void overParameterI() throws IOException{
		File file = new File("src/test/resources/floydwarshall/negative_cycle_input.txt");
		FloydWarshallApp fwApp = new FloydWarshallApp();
		fwApp.process(file.getAbsolutePath());
		assertEquals(fwApp.getShortestPath(10, 3), "");
	}
	
	@Test(expectedExceptions=IllegalArgumentException.class)
	public void overParameterJ() throws IOException{
		File file = new File("src/test/resources/floydwarshall/negative_cycle_input.txt");
		FloydWarshallApp fwApp = new FloydWarshallApp();
		fwApp.process(file.getAbsolutePath());
		assertEquals(fwApp.getShortestPath(0, 10), "");
	}
}
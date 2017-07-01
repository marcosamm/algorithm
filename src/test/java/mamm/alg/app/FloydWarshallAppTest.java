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
		File file = new File("src/test/resources/floydwarshall/cormem_example_input.txt");
		FloydWarshallApp fwApp = new FloydWarshallApp();
		fwApp.process(file.getAbsolutePath());
		assertEquals(fwApp.getShortestPath(0, 3), "0 4 3");
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
		File file = new File("src/test/resources/floydwarshall/invalid_number_of_weights_one_line_in.txt");
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
}
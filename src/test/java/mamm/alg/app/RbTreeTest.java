package mamm.alg.app;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.reporters.Files;

public class RbTreeTest {
	
	@Test
	public void directory() throws IOException{
		FilenameFilter ff = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith("input.txt");
			}
		};
		File folder = new File("src/test/resources/");
		for(File file : folder.listFiles(ff)){
			RbTree rbTree = new RbTree();
			rbTree.process(file.getAbsolutePath());
			String expected = Files.readFile(new File(file.getAbsolutePath().replace("input", "output")));
			assertEquals(rbTree.getStringCheck(), expected); 
		}
		
		
	}
}
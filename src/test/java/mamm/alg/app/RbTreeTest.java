package mamm.alg.app;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

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
		File folder = new File("src/test/resources/rbtree/");
		for(File file : folder.listFiles(ff)){
			RbTree rbTree = new RbTree();
			rbTree.process(file.getAbsolutePath());
			String expected = Files.readFile(new File(file.getAbsolutePath().replace("input", "output")));
			assertEquals(rbTree.getStringCheck(), expected); 
		}
	}
	
	@Test
	public void rbSearch() throws IOException{
		File file = new File("src/test/resources/rbtree/dicionario2_input.txt");
		RbTree rbTree = new RbTree();
		rbTree.process(file.getAbsolutePath());
		assertNull(rbTree.rbSearch("teste"));
		assertEquals(rbTree.rbSearch("abuso").getKey(), "abuso");
		assertNull(rbTree.rbSearch(""));
		assertNull(rbTree.rbSearch(null));
	}
	
	@Test(expectedExceptions = UnknownError.class)
	public void invalidOperation() throws IOException{
		File file = new File("src/test/resources/rbtree/invalid_operation_in.txt");
		RbTree rbTree = new RbTree();
		rbTree.process(file.getAbsolutePath());
	}
}
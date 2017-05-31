package mamm.alg.app;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.reporters.Files;

public class RbTreeTest {
	
	@Test(enabled=false)
	public void file1() throws IOException{
		RbTree rbTree = new RbTree();
		rbTree.process("src/test/resources/dict1_input.txt");
		String expected = Files.readFile(new File("src/test/resources/dict1_output.txt"));
		assertEquals(rbTree.getStringCheck(), expected);
	}
}
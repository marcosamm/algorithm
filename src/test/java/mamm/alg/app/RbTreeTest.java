package mamm.alg.app;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

public class RbTreeTest {
	
	@Test
	public void file1() throws IOException{
		RbTree rbTree = new RbTree();
		//TODO Pegar arquivo relativo
		rbTree.process("/home/marcos/git/algorithm/src/main/resources/dicionario1.txt");
		String esperada = "";
		assertEquals(rbTree.getStringCheck(), esperada);
	}
}
package mamm.alg.app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import mamm.alg.datastructure.BinaryTree.WalkOrder;
import mamm.alg.datastructure.BinaryTreeNode;
import mamm.alg.datastructure.RedBlackTree;

public class RbTreeApp {
	RedBlackTree<String, String> rbTree;
	
	public RbTreeApp() {
		rbTree = new RedBlackTree<>();
	}
	
	public void process(Path pathFile) throws IOException {
		List<String> lines = Files.readAllLines(pathFile);
		for (String line : lines) {
			String [] lineSplit = line.split(" "); 
			String word = lineSplit[0];
			String operation = lineSplit[1];
			BinaryTreeNode<String, String> n = rbTree.search(word);
			if(operation.equals("1")){
				if(n == null){
					rbTree.insert(word, null);
				}else{
					System.out.println("Word already inserted: " + word);
				}
			}else if(operation.equals("0")){
				if(n != null){
					System.out.println("Removing word: " + n.getKey().toString());
					rbTree.delete(n);
					rbPrint();
					rbCheck();
				}else{
					System.out.println("Word not found or previously removed: " + word);
				}
			}else{
				throw new UnknownError("Unknown operation");
			}
		}
	}
	
	public BinaryTreeNode<String, String> rbSearch(String key){
		BinaryTreeNode<String, String> n = null;
		if(key != null && !key.isEmpty()){
			n = rbTree.search(key);
			if(n != null){
				System.out.println("Found word: " + n.getKey().toString());
			}else{
				System.out.println("Word not found or previously removed: " + key);
			}
		}else{
			rbPrint();
			rbCheck();
		}
		return n;
	}
	
	public void rbPrint(){
		System.out.println(rbTree.treeWalk(WalkOrder.IN_ORDER));
	}
	
	public void rbCheck(){
		System.out.println(rbTree.extendedPreOrderTreeWalk());
	}
	
	public String getStringCheck(){
		return rbTree.extendedPreOrderTreeWalk();
	}
	
	public void process(String fileName) throws IOException{
		process(new File(fileName).toPath());
	}
}

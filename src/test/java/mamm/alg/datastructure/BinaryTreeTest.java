package mamm.alg.datastructure;

import static org.testng.Assert.assertEquals;
import mamm.alg.datastructure.BinaryTree.WalkOrder;

import org.testng.annotations.Test;

public class BinaryTreeTest {
	private final Integer [] ints = {10, 22, 31, 4, 15, 28, 18, 88, 59};
	
	@Test
	public void walks(){
		BinaryTree<Integer, Object> tree = new BinaryTree<>();
		for(Integer i : ints){
			tree.insert(i, null);
		}
		
		String 
		expected = "10, 4, 22, 15, 18, 31, 28, 88, 59";
		assertEquals(tree.treeWalk(WalkOrder.PRE_ORDER), expected);
		expected = "4, 10, 15, 18, 22, 28, 31, 59, 88";
		assertEquals(tree.treeWalk(WalkOrder.IN_ORDER), expected);
		expected = "4, 18, 15, 28, 59, 88, 31, 22, 10";
		assertEquals(tree.treeWalk(WalkOrder.POST_ORDER), expected);
		expected = "10, 4, 22, 15, 31, 18, 28, 88, 59";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), expected);
		expected = "88, 59, 31, 28, 22, 18, 15, 10, 4";
		assertEquals(tree.treeWalk(WalkOrder.INVERSE_ORDER), expected);
	}
	
	@Test
	public void height(){
		BinaryTree<Integer, Object> tree = new BinaryTree<>();
		for(Integer i : ints){
			tree.insert(i, null);
		}
		assertEquals(tree.getHeight(), 4);
		
		tree = new BinaryTree<>();
		tree.insert(ints[0], null);
		assertEquals(tree.getHeight(), 0);
		tree.insert(ints[1], null);
		assertEquals(tree.getHeight(), 1);
	}
	
	@Test
	public void minimumMaximum(){
		BinaryTree<Integer, Object> tree = new BinaryTree<>();
		for(Integer i : ints){
			tree.insert(i, null);
		}
		assertEquals(tree.getHeight(), 4);
		assertEquals(tree.minimum().getKey().intValue(), 4);
		assertEquals(tree.maximum().getKey().intValue(), 88);
	}
	
	
	@Test
	public void predecessor(){
		BinaryTree<Integer, Object> tree = new BinaryTree<>();
		for(Integer i : ints){
			tree.insert(i, null);
		}
		
		assertEquals(tree.predecessor(tree.search(10)).getKey().intValue(), 4);
		assertEquals(tree.predecessor(tree.search(22)).getKey().intValue(), 18);
		assertEquals(tree.predecessor(tree.search(31)).getKey().intValue(), 28);
		
		Integer [] ints2 = {10, 8, 7, 9, 15, 12, 11, 14, 18, 17, 16};
		tree = new BinaryTree<>();
		for(Integer i : ints2){
			tree.insert(i, null);
		}
		assertEquals(tree.predecessor(tree.search(16)).getKey().intValue(), 15);
	}
	
	@Test
	public void sucessor(){
		BinaryTree<Integer, Object> tree = new BinaryTree<>();
		for(Integer i : ints){
			tree.insert(i, null);
		}
		assertEquals(tree.sucessor(tree.search(4)).getKey().intValue(), 10);
		assertEquals(tree.sucessor(tree.search(10)).getKey().intValue(), 15);
		assertEquals(tree.sucessor(tree.search(22)).getKey().intValue(), 28);
	}
	
	@Test
	public void deletion(){
		BinaryTree<Integer, Object> tree = new BinaryTree<>();
		for(Integer i : ints){
			tree.insert(i, null);
		}
		
		String expected = null;
		tree.delete(tree.search(22));
		expected = "10, 4, 28, 15, 31, 18, 88, 59";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), expected);
		tree.delete(tree.search(10));
		expected = "15, 4, 28, 18, 31, 88, 59";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), expected);
		tree.delete(tree.search(88));
		expected = "15, 4, 28, 18, 31, 59";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), expected);
		tree.delete(tree.search(31));
		expected = "15, 4, 28, 18, 59";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), expected);
		tree.delete(tree.search(59));
		expected = "15, 4, 28, 18";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), expected);
		tree.delete(tree.search(28));
		expected = "15, 4, 18";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), expected);
		expected = 
				"(NIL, 15, 4, 18)\n"+
				"(15, 4, NIL, NIL)\n"+
				"(15, 18, NIL, NIL)\n"
		;
		assertEquals(tree.extendedPreOrderTreeWalk(), expected);
		
	}
}
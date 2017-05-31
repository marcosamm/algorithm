package mamm.alg.datastructure;

import static org.testng.Assert.assertEquals;
import mamm.alg.datastructure.BinaryTree.WalkOrder;

import org.testng.annotations.Test;

public class RedBlackTreeTest {
	private final Integer [] ints = {10, 22, 31, 4, 15, 28, 18, 88, 59};
	private final Integer [] ints2 = {500, 600, 700, 400, 300, 200, 100, 50, 25, 800, 900, 1000, 1100, 850, 875, 1200, 1300, 950, 550, 575, 150, 580, 585, 586, 587, 588};
	private final Integer [] ints3 = {10, 22, 31, 4, 15, 28, 18, 88, 59, 29};
	
	private final Integer [] intsInsertFixupLeftCases123 = {11, 2, 14, 1, 7, 15, 5, 8}; //Include 4
	private final Integer [] intsInsertFixupRightCases123 = {11, 2, 20, 1, 15, 25, 13, 16}; //Include 18
	
	private final Integer [] intsDeleteFixupLeftCases123 = {11, 2, 20, 1, 3, 15, 25, 13, 16}; //Remove 3, 1, and 2
	
	@Test
	public void walks(){
		RedBlackTree<Integer, Object> tree = new RedBlackTree<>();
		for(Integer i : ints){
			tree.insert(i, null);
		}
		
		String 
		expected = "22, 10, 4, 15, 18, 31, 28, 88, 59";
		assertEquals(tree.treeWalk(WalkOrder.PRE_ORDER), expected);
		expected = "4, 10, 15, 18, 22, 28, 31, 59, 88";
		assertEquals(tree.treeWalk(WalkOrder.IN_ORDER), expected);
		expected = "4, 18, 15, 10, 28, 59, 88, 31, 22";
		assertEquals(tree.treeWalk(WalkOrder.POST_ORDER), expected);
		expected = "22, 10, 31, 4, 15, 28, 88, 18, 59";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), expected);
		expected = "88, 59, 31, 28, 22, 18, 15, 10, 4";
		assertEquals(tree.treeWalk(WalkOrder.INVERSE_ORDER), expected);
	}
	
	@Test
	public void height(){
		RedBlackTree<Integer, Object> tree = new RedBlackTree<>();
		for(Integer i : ints){
			tree.insert(i, null);
		}
		assertEquals(tree.getHeight(), 3);
		
		tree = new RedBlackTree<>();
		tree.insert(ints[0], null);
		assertEquals(tree.getHeight(), 0);
		tree.insert(ints[1], null);
		assertEquals(tree.getHeight(), 1);
	}
	
	@Test
	public void minimumMaximum(){
		RedBlackTree<Integer, Object> tree = new RedBlackTree<>();
		for(Integer i : ints){
			tree.insert(i, null);
		}
		assertEquals(tree.getHeight(), 3);
		assertEquals(tree.minimum().getKey().intValue(), 4);
		assertEquals(tree.maximum().getKey().intValue(), 88);
	}
	
	
	@Test
	public void predecessor(){
		RedBlackTree<Integer, Object> tree = new RedBlackTree<>();
		for(Integer i : ints){
			tree.insert(i, null);
		}
		
		assertEquals(tree.predecessor(tree.search(10)).getKey().intValue(), 4);
		assertEquals(tree.predecessor(tree.search(22)).getKey().intValue(), 18);
		assertEquals(tree.predecessor(tree.search(31)).getKey().intValue(), 28);
	}
	
	@Test
	public void sucessor(){
		RedBlackTree<Integer, Object> tree = new RedBlackTree<>();
		for(Integer i : ints){
			tree.insert(i, null);
		}
		assertEquals(tree.sucessor(tree.search(4)).getKey().intValue(), 10);
		assertEquals(tree.sucessor(tree.search(10)).getKey().intValue(), 15);
		assertEquals(tree.sucessor(tree.search(22)).getKey().intValue(), 28);
	}
	
	@Test
	public void insertionFixupLeftCases(){
		RedBlackTree<Integer, Object> tree = new RedBlackTree<>();
		String expected = null;
		for(Integer i : intsInsertFixupLeftCases123){
			tree.insert(i, null);
		}
		expected = "11, 2, 14, 1, 7, 15, 5, 8";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), expected);		
		expected = ""+
				"(NIL, 11, preto, 1, 2, 14)\n"+
				"(11, 2, vermelho, 1, 1, 7)\n"+
				"(2, 1, preto, 0, NIL, NIL)\n"+
				"(2, 7, preto, 0, 5, 8)\n"+
				"(7, 5, vermelho, 0, NIL, NIL)\n"+
				"(7, 8, vermelho, 0, NIL, NIL)\n"+
				"(11, 14, preto, 0, NIL, 15)\n"+
				"(14, 15, vermelho, 0, NIL, NIL)\n"
		;
		assertEquals(tree.extendedPreOrderTreeWalk(), expected);
		
		//Add 4
		tree.insert(4, null);
		expected = "7, 2, 11, 1, 5, 8, 14, 4, 15";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), expected);		
		expected = ""+
				"(NIL, 7, preto, 1, 2, 11)\n"+
				"(7, 2, vermelho, 1, 1, 5)\n"+
				"(2, 1, preto, 0, NIL, NIL)\n"+
				"(2, 5, preto, 0, 4, NIL)\n"+
				"(5, 4, vermelho, 0, NIL, NIL)\n"+
				"(7, 11, vermelho, 1, 8, 14)\n"+
				"(11, 8, preto, 0, NIL, NIL)\n"+
				"(11, 14, preto, 0, NIL, 15)\n"+
				"(14, 15, vermelho, 0, NIL, NIL)\n"
		;
		assertEquals(tree.extendedPreOrderTreeWalk(), expected);
	}
	
	@Test
	public void insertionFixupRightCases(){
		RedBlackTree<Integer, Object> tree = new RedBlackTree<>();
		String expected = null;
		for(Integer i : intsInsertFixupRightCases123){
			tree.insert(i, null);
		}
		expected = "11, 2, 20, 1, 15, 25, 13, 16";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), expected);		
		expected = ""+
				"(NIL, 11, preto, 1, 2, 20)\n"+
				"(11, 2, preto, 0, 1, NIL)\n"+
				"(2, 1, vermelho, 0, NIL, NIL)\n"+
				"(11, 20, vermelho, 1, 15, 25)\n"+
				"(20, 15, preto, 0, 13, 16)\n"+
				"(15, 13, vermelho, 0, NIL, NIL)\n"+
				"(15, 16, vermelho, 0, NIL, NIL)\n"+
				"(20, 25, preto, 0, NIL, NIL)\n"
		;
		assertEquals(tree.extendedPreOrderTreeWalk(), expected);
		
		//Add 18
		tree.insert(18, null);
		expected = "15, 11, 20, 2, 13, 16, 25, 1, 18";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), expected);
		expected = ""+
				"(NIL, 15, preto, 1, 11, 20)\n"+
				"(15, 11, vermelho, 1, 2, 13)\n"+
				"(11, 2, preto, 0, 1, NIL)\n"+
				"(2, 1, vermelho, 0, NIL, NIL)\n"+
				"(11, 13, preto, 0, NIL, NIL)\n"+
				"(15, 20, vermelho, 1, 16, 25)\n"+
				"(20, 16, preto, 0, NIL, 18)\n"+
				"(16, 18, vermelho, 0, NIL, NIL)\n"+
				"(20, 25, preto, 0, NIL, NIL)\n"
		;
		assertEquals(tree.extendedPreOrderTreeWalk(), expected);
	}
	
	@Test(enabled=false)
	public void insertionsFixup(){
		RedBlackTree<Integer, Object> tree = new RedBlackTree<>();
		String expected = null;
		for(Integer i : ints2){
			tree.insert(i, null);
		}
		
		expected = "580, 400, 800, 200, 550, 600, 1000, 50, 300, 500, 575, 586, 700, 875, 1200, 25, 100, 585, 587, 850, 900, 1100, 1300, 150, 588, 950";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), expected);
	}
	
	@Test(enabled=false)
	public void deletionSimpleCase(){
		RedBlackTree<Integer, Object> tree = new RedBlackTree<>();
		String expected = null;

		//z.left == nil
		tree.insert(2, null);
		tree.insert(3, null);		
		expected = ""+
				"(NIL, 2, preto, 0, NIL, 3)\n"+
				"(2, 3, vermelho, 0, NIL, NIL)\n"
		;
		assertEquals(tree.extendedPreOrderTreeWalk(), expected);
		tree.delete(tree.search(2));
		expected = ""+
				"(NIL, 3, preto, 0, NIL, NIL)\n"
		;
		assertEquals(tree.extendedPreOrderTreeWalk(), expected);
		
		//z.left != nil and z.right == nil
		tree = new RedBlackTree<>();
		tree.insert(2, null);
		tree.insert(1, null);		
		expected = ""+
				"(NIL, 2, preto, 0, 1, NIL)\n"+
				"(2, 1, vermelho, 0, NIL, NIL)\n"
		;
		assertEquals(tree.extendedPreOrderTreeWalk(), expected);
		tree.delete(tree.search(2));
		expected = ""+
				"(NIL, 1, preto, 0, NIL, NIL)\n"
		;
		assertEquals(tree.extendedPreOrderTreeWalk(), expected);
		
		//z.left != nil and z.right != nil and y.parent == z
		tree = new RedBlackTree<>();
		tree.insert(2, null);
		tree.insert(1, null);
		tree.insert(4, null);
		expected = ""+
				"(NIL, 2, preto, 0, 1, 4)\n"+
				"(2, 1, vermelho, 0, NIL, NIL)\n"+
				"(2, 4, vermelho, 0, NIL, NIL)\n"
		;
		assertEquals(tree.extendedPreOrderTreeWalk(), expected);
		tree.delete(tree.search(2));
		expected = ""+
				"(NIL, 4, preto, 0, 1, NIL)\n"+
				"(4, 1, vermelho, 0, NIL, NIL)\n"
		;
		assertEquals(tree.extendedPreOrderTreeWalk(), expected);
		
		//z.left != nil and z.right != nil and y.parent != z
		tree = new RedBlackTree<>();
		tree.insert(2, null);
		tree.insert(1, null);
		tree.insert(4, null);
		tree.insert(3, null);
		expected = ""+
				"(NIL, 2, preto, 1, 1, 4)\n"+
				"(2, 1, preto, 0, NIL, NIL)\n"+
				"(2, 4, preto, 0, 3, NIL)\n"+
				"(4, 3, vermelho, 0, NIL, NIL)\n"
		;
		assertEquals(tree.extendedPreOrderTreeWalk(), expected);
		tree.delete(tree.search(2));
		expected = ""+
				"(NIL, 3, preto, 1, 1, 4)\n"+
				"(3, 1, preto, 0, NIL, NIL)\n"+
				"(3, 4, preto, 0, NIL, NIL)\n"
		;
		assertEquals(tree.extendedPreOrderTreeWalk(), expected);
	}
	
	@Test
	public void deletionFixupLeftCases(){
		RedBlackTree<Integer, Object> tree = new RedBlackTree<>();
		String expected = null;
		for(Integer i : intsDeleteFixupLeftCases123){
			tree.insert(i, null);
		}		
		expected = ""+
				"(NIL, 11, preto, 1, 2, 20)\n"+
				"(11, 2, preto, 0, 1, 3)\n"+
				"(2, 1, vermelho, 0, NIL, NIL)\n"+
				"(2, 3, vermelho, 0, NIL, NIL)\n"+
				"(11, 20, vermelho, 1, 15, 25)\n"+
				"(20, 15, preto, 0, 13, 16)\n"+
				"(15, 13, vermelho, 0, NIL, NIL)\n"+
				"(15, 16, vermelho, 0, NIL, NIL)\n"+
				"(20, 25, preto, 0, NIL, NIL)\n"
		;
		assertEquals(tree.extendedPreOrderTreeWalk(), expected);
		
		//Remove 3 - simple case
		tree.delete(tree.search(3));		
		expected = ""+
				"(NIL, 11, preto, 1, 2, 20)\n"+
				"(11, 2, preto, 0, 1, NIL)\n"+
				"(2, 1, vermelho, 0, NIL, NIL)\n"+
				"(11, 20, vermelho, 1, 15, 25)\n"+
				"(20, 15, preto, 0, 13, 16)\n"+
				"(15, 13, vermelho, 0, NIL, NIL)\n"+
				"(15, 16, vermelho, 0, NIL, NIL)\n"+
				"(20, 25, preto, 0, NIL, NIL)\n"
		;
		assertEquals(tree.extendedPreOrderTreeWalk(), expected);
		
		//Remove 1 - simple case
		tree.delete(tree.search(1));		
		expected = ""+
				"(NIL, 11, preto, 1, 2, 20)\n"+
				"(11, 2, preto, 0, NIL, NIL)\n"+
				"(11, 20, vermelho, 1, 15, 25)\n"+
				"(20, 15, preto, 0, 13, 16)\n"+
				"(15, 13, vermelho, 0, NIL, NIL)\n"+
				"(15, 16, vermelho, 0, NIL, NIL)\n"+
				"(20, 25, preto, 0, NIL, NIL)\n"
		;
		assertEquals(tree.extendedPreOrderTreeWalk(), expected);
		
		//Remove 2 - case
		tree.delete(tree.search(2));
		expected = "20, 11, 25, 2, 15, 1, 16";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), expected);
		expected = ""+
				"(NIL, 15, preto, 1, 11, 20)\n"+
				"(15, 11, vermelho, 1, 2, 13)\n"+
				"(11, 2, preto, 0, 1, NIL)\n"+
				"(2, 1, vermelho, 0, NIL, NIL)\n"+
				"(11, 13, preto, 0, NIL, NIL)\n"+
				"(15, 20, vermelho, 1, 16, 25)\n"+
				"(20, 16, preto, 0, NIL, 18)\n"+
				"(16, 18, vermelho, 0, NIL, NIL)\n"+
				"(20, 25, preto, 0, NIL, NIL)\n"
		;
		assertEquals(tree.extendedPreOrderTreeWalk(), expected);
	}
	
	@Test(enabled=false)
	public void deletion(){
		RedBlackTree<Integer, Object> tree = new RedBlackTree<>();
		for(Integer i : ints3){
			tree.insert(i, null);
		}
		
		String expected = null;
		expected = "22, 10, 31, 4, 15, 28, 88, 18, 29, 59";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), expected);
		tree.delete(tree.search(22));
		expected = "28, 10, 31, 4, 15, 88, 18, 59";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), expected);
		tree.delete(tree.search(10));
		expected = "28, 15, 31, 4, 18, 88, 59";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), expected);
		tree.delete(tree.search(15));
		expected = "28, 18, 31, 4, 88, 59";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), expected);
		tree.delete(tree.search(4));
		expected = "28, 18, 31, 88, 59";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), expected);
		tree.delete(tree.search(88));
		expected = "28, 18, 31, 59";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), expected);
		tree.delete(tree.search(31));
		expected = "28, 18, 59";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), expected);
	}
	
	@Test(enabled=false)
	public void deletionFixup(){
		RedBlackTree<Integer, Object> tree = new RedBlackTree<>();
		for(Integer i : ints2){
			tree.insert(i, null);
		}
		
		tree.delete(tree.search(100));
		tree.delete(tree.search(50));
		tree.delete(tree.search(1000));
		tree.delete(tree.search(900));
		tree.delete(tree.search(300));
		tree.delete(tree.search(700));
		String expected = null;
		expected = "580, 400, 800, 200, 550, 600, 1000, 50, 300, 500, 575, 586, 700, 875, 1200, 25, 100, 585, 587, 850, 900, 1100, 1300, 150, 588, 950";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), expected);
	}
	
	@Test
	public void extendedPreOrderTreeWalk(){
		RedBlackTree<Integer, Object> tree = new RedBlackTree<>();
		for(Integer i : ints){
			tree.insert(i, null);
		}
		
		String expected = ""+
				"(NIL, 22, preto, 1, 10, 31)\n"+
				"(22, 10, vermelho, 1, 4, 15)\n"+
				"(10, 4, preto, 0, NIL, NIL)\n"+
				"(10, 15, preto, 0, NIL, 18)\n"+
				"(15, 18, vermelho, 0, NIL, NIL)\n"+
				"(22, 31, vermelho, 1, 28, 88)\n"+
				"(31, 28, preto, 0, NIL, NIL)\n"+
				"(31, 88, preto, 0, 59, NIL)\n"+
				"(88, 59, vermelho, 0, NIL, NIL)\n"
		;
		assertEquals(tree.extendedPreOrderTreeWalk(), expected);
	}
}
package mamm.alg.datastructure;

import static org.testng.Assert.assertEquals;
import mamm.alg.datastructure.BinaryTree.WalkOrder;

import org.testng.annotations.Test;

public class RedBlackTreeTest {
	private final Integer [] ints = {10, 22, 31, 4, 15, 28, 18, 88, 59};
	private final Integer [] ints2 = {500, 600, 700, 400, 300, 200, 100, 50, 25, 800, 900, 1000, 1100, 850, 875, 1200, 1300, 950, 550, 575, 150, 580, 585, 586, 587, 588};
	private final Integer [] ints3 = {10, 22, 31, 4, 15, 28, 18, 88, 59, 29};
	
	@Test
	public void walks(){
		RedBlackTree<Integer, Object> tree = new RedBlackTree<>();
		for(Integer i : ints){
			tree.insert(i, null);
		}
		
		String 
		esperada = "22, 10, 4, 15, 18, 31, 28, 88, 59";
		assertEquals(tree.treeWalk(WalkOrder.PRE_ORDER), esperada);
		esperada = "4, 10, 15, 18, 22, 28, 31, 59, 88";
		assertEquals(tree.treeWalk(WalkOrder.IN_ORDER), esperada);
		esperada = "4, 18, 15, 10, 28, 59, 88, 31, 22";
		assertEquals(tree.treeWalk(WalkOrder.POST_ORDER), esperada);
		esperada = "22, 10, 31, 4, 15, 28, 88, 18, 59";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), esperada);
		esperada = "88, 59, 31, 28, 22, 18, 15, 10, 4";
		assertEquals(tree.treeWalk(WalkOrder.INVERSE_ORDER), esperada);
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
	public void insertionFixup(){
		RedBlackTree<Integer, Object> tree = new RedBlackTree<>();
		for(Integer i : ints2){
			tree.insert(i, null);
		}
		
		String esperada = null;
		esperada = "580, 400, 800, 200, 550, 600, 1000, 50, 300, 500, 575, 586, 700, 875, 1200, 25, 100, 585, 587, 850, 900, 1100, 1300, 150, 588, 950";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), esperada);
	}
	
	@Test
	public void deletion(){
		RedBlackTree<Integer, Object> tree = new RedBlackTree<>();
		for(Integer i : ints3){
			tree.insert(i, null);
		}
		
		String esperada = null;
		esperada = "22, 10, 31, 4, 15, 28, 88, 18, 29, 59";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), esperada);
		tree.delete(tree.search(22));
		esperada = "28, 10, 31, 4, 15, 88, 18, 59";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), esperada);
		tree.delete(tree.search(10));
		esperada = "28, 15, 31, 4, 18, 88, 59";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), esperada);
		tree.delete(tree.search(15));
		esperada = "28, 18, 31, 4, 88, 59";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), esperada);
		tree.delete(tree.search(4));
		esperada = "28, 18, 31, 88, 59";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), esperada);
		tree.delete(tree.search(88));
		esperada = "28, 18, 31, 59";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), esperada);
		tree.delete(tree.search(31));
		esperada = "28, 18, 59";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), esperada);
	}
	
	@Test
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
		String esperada = null;
		esperada = "580, 400, 800, 200, 550, 600, 1000, 50, 300, 500, 575, 586, 700, 875, 1200, 25, 100, 585, 587, 850, 900, 1100, 1300, 150, 588, 950";
		assertEquals(tree.treeWalk(WalkOrder.BY_LEVEL_ORDER), esperada);
	}
	
	@Test
	public void extendedPreOrderTreeWalk(){
		RedBlackTree<Integer, Object> tree = new RedBlackTree<>();
		for(Integer i : ints){
			tree.insert(i, null);
		}
		
		String esperada = ""+
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
		assertEquals(tree.extendedPreOrderTreeWalk(), esperada);
	}
}
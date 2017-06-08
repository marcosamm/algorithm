package mamm.alg.datastructure;

import static mamm.alg.datastructure.RedBlackTreeNode.Color.BLACK;
import static mamm.alg.datastructure.RedBlackTreeNode.Color.RED;
import mamm.alg.datastructure.RedBlackTreeNode.Color;


public class RedBlackTree<T extends Comparable<T>, E> extends BinaryTree<T, E>{
	
	private boolean recalcBlackHeight;
	
	public RedBlackTree() {
		nil = new RedBlackTreeNode<T, E>(null, null, BLACK);
		root = nil;
		recalcBlackHeight = true;
	}
	
	@Override
	public void insert(T key, E value){
		insert(new RedBlackTreeNode<T,E>(key, value, RED));
		recalcBlackHeight = true;
	}
	
	@Override
	protected void insert(BinaryTreeNode<T, E> z) {
		super.insert(z);
		insertFixup(z);
	}
	
	private void insertFixup(BinaryTreeNode<T, E> z){
		while(((RedBlackTreeNode<T,E>) z.getParent()).getColor() == RED){
			if(z.getParent() == z.getParent().getParent().getLeft()){
				RedBlackTreeNode<T,E> y = (RedBlackTreeNode<T,E>) z.getParent().getParent().getRight();
				if(y.getColor() == RED){
					((RedBlackTreeNode<T,E>) z.getParent()).setColor(BLACK);			//case 1
					y.setColor(BLACK);													//case 1
					((RedBlackTreeNode<T,E>) z.getParent().getParent()).setColor(RED);	//case 1
					z = (RedBlackTreeNode<T,E>) z.getParent().getParent();				//case 1
				}else{
					if(z == z.getParent().getRight()){
						z = (RedBlackTreeNode<T,E>) z.getParent();						//case 2
						leftRotate(z);													//case 2
					}
					((RedBlackTreeNode<T,E>) z.getParent()).setColor(BLACK);			//case 3
					((RedBlackTreeNode<T,E>) z.getParent().getParent()).setColor(RED);	//case 3
					rightRotate(z.getParent().getParent());								//case 3
				}
			}else{
				RedBlackTreeNode<T,E> y = (RedBlackTreeNode<T,E>) z.getParent().getParent().getLeft();
				if(y.getColor() == RED){
					((RedBlackTreeNode<T,E>) z.getParent()).setColor(BLACK);			//case 1
					y.setColor(BLACK);													//case 1
					((RedBlackTreeNode<T,E>) z.getParent().getParent()).setColor(RED);	//case 1
					z = (RedBlackTreeNode<T,E>) z.getParent().getParent();				//case 1
				}else{
					if(z == z.getParent().getLeft()){
						z = (RedBlackTreeNode<T,E>) z.getParent();						//case 2
						rightRotate(z);													//case 2
					}
					((RedBlackTreeNode<T,E>) z.getParent()).setColor(BLACK);			//case 3
					((RedBlackTreeNode<T,E>) z.getParent().getParent()).setColor(RED);	//case 3
					leftRotate(z.getParent().getParent());								//case 3
				}
			}
		}
		((RedBlackTreeNode<T,E>) root).setColor(BLACK);
	}
	
	@Override
	public void delete(BinaryTreeNode<T,E> z){
		if(z == null || !(z instanceof RedBlackTreeNode)){
			throw new IllegalArgumentException("Unexpected type: " + z);
		}
		BinaryTreeNode<T,E> x = null;
		RedBlackTreeNode<T,E> y = (RedBlackTreeNode<T,E>) z;
		Color originalColor = y.getColor();
		if(z.getLeft() == nil){
			x = z.getRight();
			transplant(z, z.getRight());
		}else if(z.getRight() == nil){
			x = z.getLeft();
			transplant(z, z.getLeft());
		}else {
			y = (RedBlackTreeNode<T,E>) minimum(z.getRight());
			originalColor = y.getColor();
			x = y.getRight();
			if(y.getParent() == z){
				x.setParent(y);
			}else {
				transplant(y, y.getRight());
				y.setRight(z.getRight());
				y.getRight().setParent(y);
			}
			transplant(z, y);
			y.setLeft(z.getLeft());
			y.getLeft().setParent(y);
			y.setColor(((RedBlackTreeNode<T,E>)z).getColor());
		}
		if(originalColor == BLACK /*&& x != nil*/){
			deleteFixup((RedBlackTreeNode<T,E>) x);
		}
		recalcBlackHeight = true;
	}
	
	void deleteFixup(RedBlackTreeNode<T,E> x){
		while (x != root && x.getColor() == BLACK){
			if(x == x.getParent().getLeft()){
				RedBlackTreeNode<T,E> w = (RedBlackTreeNode<T,E>) x.getParent().getRight();
				if(w.getColor() == RED){
					w.setColor(BLACK);												//case 1
					((RedBlackTreeNode<T,E>)x.getParent()).setColor(RED);			//case 1
					leftRotate(x.getParent());										//case 1
					w = (RedBlackTreeNode<T,E>) x.getParent().getRight();			//case 1
				}
				if(((RedBlackTreeNode<T,E>)w.getLeft()).getColor() == BLACK && ((RedBlackTreeNode<T,E>)w.getRight()).getColor() == BLACK){
					w.setColor(RED);												//case 2
					x = (RedBlackTreeNode<T,E>) x.getParent();						//case 2
				} else {
					if(((RedBlackTreeNode<T,E>)w.getRight()).getColor() == BLACK){
						((RedBlackTreeNode<T,E>)w.getLeft()).setColor(BLACK);		//case 3
						w.setColor(RED);											//case 3
						rightRotate(w);												//case 3
						w = (RedBlackTreeNode<T,E>) x.getParent().getRight();		//case 3
					}
					w.setColor(((RedBlackTreeNode<T,E>)x.getParent()).getColor());	//case 4
					((RedBlackTreeNode<T,E>)x.getParent()).setColor(BLACK);			//case 4
					((RedBlackTreeNode<T,E>)w.getRight()).setColor(BLACK);			//case 4
					leftRotate(x.getParent());										//case 4
					x = (RedBlackTreeNode<T,E>) root;								//case 4
				}
			}else{
				RedBlackTreeNode<T,E> w = (RedBlackTreeNode<T,E>) x.getParent().getLeft();
				if(w.getColor() == RED){
					w.setColor(BLACK);												//case 1
					((RedBlackTreeNode<T,E>)x.getParent()).setColor(RED);			//case 1
					rightRotate(x.getParent());										//case 1
					w = (RedBlackTreeNode<T,E>) x.getParent().getLeft();			//case 1
				}
				if(((RedBlackTreeNode<T,E>)w.getRight()).getColor() == BLACK && ((RedBlackTreeNode<T,E>)w.getLeft()).getColor() == BLACK){
					w.setColor(RED);												//case 2
					x = (RedBlackTreeNode<T,E>) x.getParent();						//case 2
				} else {
					if(((RedBlackTreeNode<T,E>)w.getLeft()).getColor() == BLACK){
						((RedBlackTreeNode<T,E>)w.getRight()).setColor(BLACK);		//case 3
						w.setColor(RED);											//case 3
						leftRotate(w);												//case 3
						w = (RedBlackTreeNode<T,E>) x.getParent().getLeft();		//case 3
					}
					w.setColor(((RedBlackTreeNode<T,E>)x.getParent()).getColor());	//case 4
					((RedBlackTreeNode<T,E>)x.getParent()).setColor(BLACK);			//case 4
					((RedBlackTreeNode<T,E>)w.getLeft()).setColor(BLACK);			//case 4
					rightRotate(x.getParent());										//case 4
					x = (RedBlackTreeNode<T,E>) root;								//case 4
				}
			}
		}
		x.setColor(BLACK);
	}
	
	public String extendedPreOrderTreeWalk(){
		if(recalcBlackHeight){
			calcBlackHeight((RedBlackTreeNode<T,E>)root);
			recalcBlackHeight = false;
		}
		StringBuilder s = new StringBuilder();
		extendedPreOrderTreeWalk((RedBlackTreeNode<T,E>)root, s);
		return s.toString();
	}
	
	private void extendedPreOrderTreeWalk(RedBlackTreeNode<T,E> n, StringBuilder s){
		if(n != nil){
			s.append(n.toString());
			s.append("\n");
			extendedPreOrderTreeWalk((RedBlackTreeNode<T,E>)n.getLeft(), s);
			extendedPreOrderTreeWalk((RedBlackTreeNode<T,E>)n.getRight(), s);
		}
	}
	
	private void calcBlackHeight(RedBlackTreeNode<T,E> n){
		if(n == nil){
			n.setBlackHeight(1);
		}else{
			calcBlackHeight((RedBlackTreeNode<T,E>)n.getLeft());
			int blackHeightLeft = ((RedBlackTreeNode<T,E>)n.getLeft()).getBlackHeight();
			if(n.getLeft() != nil && ((RedBlackTreeNode<T,E>)n.getLeft()).getColor() == BLACK){
				blackHeightLeft++;
			}
			calcBlackHeight((RedBlackTreeNode<T,E>)n.getRight());
			int blackHeightRight = ((RedBlackTreeNode<T,E>)n.getRight()).getBlackHeight();
			if(n.getRight() != nil && ((RedBlackTreeNode<T,E>)n.getRight()).getColor() == BLACK){
				blackHeightRight++;
			}
			n.setBlackHeight(Math.max(blackHeightLeft, blackHeightRight));
		}
	}
}

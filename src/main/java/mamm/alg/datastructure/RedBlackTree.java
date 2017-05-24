package mamm.alg.datastructure;

import static mamm.alg.datastructure.RedBlackTreeNode.Color.BLACK;
import static mamm.alg.datastructure.RedBlackTreeNode.Color.RED;
import mamm.alg.datastructure.RedBlackTreeNode.Color;


public class RedBlackTree<T extends Comparable<T>, E> extends BinaryTree<T, E>{
	
	public RedBlackTree() {
		nil = new RedBlackTreeNode<T, E>(null, null, BLACK);
		root = nil;
	}
	
	@Override
	public void insert(T key, E value){
		insert(new RedBlackTreeNode<T,E>(key, value, RED));
	}
	
	@Override
	protected void insert(BinaryTreeNode<T, E> z) {
		super.insert(z);
		insertFixup(z);
	}
	
	private void insertFixup(BinaryTreeNode<T, E> n){
		RedBlackTreeNode<T,E> z = (RedBlackTreeNode<T,E>) n;
		while(((RedBlackTreeNode<T,E>) z.getParent()).getColor() == RED){
			if(z.getParent().equals(z.getParent().getParent().getLeft())){
				RedBlackTreeNode<T,E> y = (RedBlackTreeNode<T,E>) z.getParent().getParent().getRight();
				if(y.getColor() == RED){
					((RedBlackTreeNode<T,E>) z.getParent()).setColor(BLACK);
					y.setColor(BLACK);
					((RedBlackTreeNode<T,E>) z.getParent().getParent()).setColor(RED);
					z = (RedBlackTreeNode<T,E>) z.getParent().getParent();
				}else{
					if(z.equals(z.getParent().getRight())){
						z = (RedBlackTreeNode<T,E>) z.getParent();
						leftRotate(z);
					}
					((RedBlackTreeNode<T,E>) z.getParent()).setColor(BLACK);
					((RedBlackTreeNode<T,E>) z.getParent().getParent()).setColor(RED);
					rightRotate(z.getParent().getParent());
				}
			}else{
				RedBlackTreeNode<T,E> y = (RedBlackTreeNode<T,E>) z.getParent().getParent().getLeft();
				if(y.getColor() == RED){
					((RedBlackTreeNode<T,E>) z.getParent()).setColor(BLACK);
					y.setColor(BLACK);
					((RedBlackTreeNode<T,E>) z.getParent().getParent()).setColor(RED);
					z = (RedBlackTreeNode<T,E>) z.getParent().getParent();
				}else{
					if(z.equals(z.getParent().getLeft())){
						z = (RedBlackTreeNode<T,E>) z.getParent();
						rightRotate(z);
					}
					((RedBlackTreeNode<T,E>) z.getParent()).setColor(BLACK);
					((RedBlackTreeNode<T,E>) z.getParent().getParent()).setColor(RED);
					leftRotate(z.getParent().getParent());
				}
			}
		}
		((RedBlackTreeNode<T,E>) root).setColor(BLACK);
	}
	
	private void leftRotate(BinaryTreeNode<T, E> x){
		BinaryTreeNode<T,E> y = x.getRight();
		x.setRight(y.getLeft());
		if(y.getLeft() != nil){
			y.getLeft().setParent(x);
		}
		y.setParent(x.getParent());
		if(x.getParent() == nil){
			root = y;
		}else if(x == x.getParent().getLeft()){
			x.getParent().setLeft(y);
		}else{
			x.getParent().setRight(y);
		}
		y.setLeft(x);
		x.setParent(y);
	}
	
	private void rightRotate(BinaryTreeNode<T, E> x){
		BinaryTreeNode<T,E> y = x.getLeft();
		x.setLeft(y.getRight());
		if(y.getRight() != nil){
			y.getRight().setParent(x);
		}
		y.setParent(x.getParent());
		if(x.getParent() == nil){
			root = y;
		}else if(x == x.getParent().getRight()){
			x.getParent().setRight(y);
		}else{
			x.getParent().setLeft(y);
		}
		y.setRight(x);
		x.setParent(y);
	}
	
	@Override
	public void delete(BinaryTreeNode<T,E> z){
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
		if(originalColor == BLACK && x != nil){
			deleteFixup((RedBlackTreeNode<T,E>) x);
		}
	}
	
	void deleteFixup(RedBlackTreeNode<T,E> x){
		while (x != root && x.getColor() == BLACK){
			if(x == x.getParent().getLeft()){
				RedBlackTreeNode<T,E> w = (RedBlackTreeNode<T,E>) x.getParent().getRight();
				if(w.getColor() == RED){
					w.setColor(BLACK);										//case 1
					((RedBlackTreeNode<T,E>)x.getParent()).setColor(RED);	//case 1
					leftRotate(x.getParent());								//case 1
					w = (RedBlackTreeNode<T,E>) x.getParent().getRight();	//case 1
				}
				if(((RedBlackTreeNode<T,E>)w.getLeft()).getColor() == BLACK && ((RedBlackTreeNode<T,E>)w.getRight()).getColor() == BLACK){
					w.setColor(RED);										//case 2
					x = (RedBlackTreeNode<T,E>) x.getParent();				//case 2
				} else {
					if(((RedBlackTreeNode<T,E>)w.getRight()).getColor() == BLACK){
						((RedBlackTreeNode<T,E>)w.getLeft()).setColor(BLACK);		//case 3
						w.setColor(RED);											//case 3
						rightRotate(w);												//case 3
						w = (RedBlackTreeNode<T,E>) w.getParent().getRight();		//case 3
					}
					w.setColor(((RedBlackTreeNode<T,E>)x.getParent()).getColor());	//case 4
					((RedBlackTreeNode<T,E>)x.getParent()).setColor(BLACK);			//case 4
					leftRotate(x.getParent());										//case 4
					x = (RedBlackTreeNode<T,E>) root;								//case 4
				}
			}else{
				RedBlackTreeNode<T,E> w = (RedBlackTreeNode<T,E>) x.getParent().getLeft();
				if(w.getColor() == RED){
					w.setColor(BLACK);										//case 1
					((RedBlackTreeNode<T,E>)x.getParent()).setColor(RED);	//case 1
					rightRotate(x.getParent());								//case 1
					w = (RedBlackTreeNode<T,E>) x.getParent().getLeft();	//case 1
				}
				if(((RedBlackTreeNode<T,E>)w.getRight()).getColor() == BLACK && ((RedBlackTreeNode<T,E>)w.getLeft()).getColor() == BLACK){
					w.setColor(RED);												//case 2
					x = (RedBlackTreeNode<T,E>) x.getParent();						//case 2
				} else {
					if(((RedBlackTreeNode<T,E>)w.getLeft()).getColor() == BLACK){
						((RedBlackTreeNode<T,E>)w.getRight()).setColor(BLACK);		//case 3
						w.setColor(RED);											//case 3
						leftRotate(w);												//case 3
						w = (RedBlackTreeNode<T,E>) w.getParent().getLeft();		//case 3
					}
					w.setColor(((RedBlackTreeNode<T,E>)x.getParent()).getColor());	//case 4
					((RedBlackTreeNode<T,E>)x.getParent()).setColor(BLACK);			//case 4
					rightRotate(x.getParent());										//case 4
					x = (RedBlackTreeNode<T,E>) root;								//case 4
				}
			}
		}
		x.setColor(BLACK);
	}
	
	public String extendedPreOrderTreeWalk(){
		StringBuilder s = new StringBuilder();
		extendedPreOrderTreeWalk((RedBlackTreeNode<T,E>)root, s);
		return s.toString();
	}
	
	public void extendedPreOrderTreeWalk(RedBlackTreeNode<T,E> n, StringBuilder s){
		if(n != nil){
			writeNode(n, s);
			s.append("\n");
			extendedPreOrderTreeWalk((RedBlackTreeNode<T,E>)n.getLeft(), s);
			extendedPreOrderTreeWalk((RedBlackTreeNode<T,E>)n.getRight(), s);
		}
	}
	
	public void writeNode(RedBlackTreeNode<T,E> n, StringBuilder sb) {
		sb.append("(");
		if(n.getParent().getKey() == null){
			sb.append("NIL");
		}else{
			sb.append(n.getParent().getKey().toString());
		}
		sb.append(", ");
		sb.append(n.getKey().toString());
		sb.append(", ");
		sb.append(n.getColor()==Color.RED?"vermelho":"preto");
		sb.append(", ");
		sb.append(blackHeight(n));
		sb.append(", ");
		if(n.getLeft().getKey() == null){
			sb.append("NIL");
		}else{
			sb.append(n.getLeft().getKey().toString());
		}
		sb.append(", ");
		if(n.getRight().getKey() == null){
			sb.append("NIL");
		}else{
			sb.append(n.getRight().getKey().toString());
		}
		sb.append(")");
	}
	
	public int blackHeight(RedBlackTreeNode<T,E> n){
		if(n == nil){
			return 0;
		}
		int blackHeightLeft = blackHeight((RedBlackTreeNode<T,E>)n.getLeft());
		if(n.getLeft() != nil && ((RedBlackTreeNode<T,E>)n.getLeft()).getColor() == BLACK){
			blackHeightLeft++;
		}
		int blackHeightRight = blackHeight((RedBlackTreeNode<T,E>)n.getRight());
		if(n.getRight() != nil && ((RedBlackTreeNode<T,E>)n.getRight()).getColor() == BLACK){
			blackHeightRight++;
		}
		return Math.max(blackHeightLeft, blackHeightRight);
	}
}

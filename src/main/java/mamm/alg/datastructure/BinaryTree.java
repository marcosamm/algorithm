package mamm.alg.datastructure;


public class BinaryTree<T extends Comparable<T>, E> {
	public static final int NODE_VIEW_LENGHT = 2;
	
	public enum WalkOrder {
		PRE_ORDER,
		IN_ORDER,
		POST_ORDER,
		BY_LEVEL_ORDER,
		INVERSE_ORDER;
	}
	protected BinaryTreeNode<T,E> root;
	protected int size;
	
	protected BinaryTreeNode<T, E> nil;
	
	public BinaryTree() {
		nil = new BinaryTreeNode <T, E>(null, null);
		root = nil;
	}
	
	public String treeWalk(WalkOrder walkOrder){
		StringBuilder s = new StringBuilder();
		switch (walkOrder) {
			case PRE_ORDER:
				preOrderTreeWalk(root, s);
				break;
			case IN_ORDER:
			default:
				inOrderTreeWalk(root, s);
				break;
			case POST_ORDER:
				postOrderTreeWalk(root, s);
				break;
			case BY_LEVEL_ORDER:
				byLevelTreeWalk(root, s);
				break;
			case INVERSE_ORDER:
				inverseOrderTreeWalk(root, s);
				break;
		}
		return s.toString();
	}
	
	public void preOrderTreeWalk(BinaryTreeNode<T,E> n, StringBuilder s){
		if(n != nil){
			s.append(n.getKey().toString());
			if(n.getLeft() != nil){
				s.append(", ");
			}
			preOrderTreeWalk(n.getLeft(), s);
			if(n.getRight() != nil){
				s.append(", ");
			}
			preOrderTreeWalk(n.getRight(), s);
		}
	}
	
	public void inOrderTreeWalk(BinaryTreeNode<T,E> n, StringBuilder s){
		if(n != nil){
			inOrderTreeWalk(n.getLeft(), s);
			if(n.getLeft() != nil){
				s.append(", ");
			}
			s.append(n.getKey().toString());
			if(n.getRight() != nil){
				s.append(", ");
			}
			inOrderTreeWalk(n.getRight(), s);
		}
	}
	
	public void postOrderTreeWalk(BinaryTreeNode<T,E> n, StringBuilder s){
		if(n != nil){
			postOrderTreeWalk(n.getLeft(), s);
			if(n.getLeft() != nil){
				s.append(", ");
			}
			postOrderTreeWalk(n.getRight(), s);
			if(n.getRight() != nil){
				s.append(", ");
			}
			s.append(n.getKey().toString());
		}
	}
	
	public void byLevelTreeWalk(BinaryTreeNode<T,E> root, StringBuilder s){
		Queue<BinaryTreeNode<T,E>> level = new Queue<BinaryTreeNode<T,E>>(size);
		if(root != nil){
			level.enqueue(root);
		}
		while(!level.isEmpty()){
			BinaryTreeNode<T,E> node = level.dequeue();
			s.append(node.getKey().toString());
			if(node.getLeft() != nil){
				level.enqueue(node.getLeft());
			}
			if(node.getRight() != nil){
				level.enqueue(node.getRight());
			}
			if(!level.isEmpty()){
				s.append(", ");
			}
		}
	}
	
	public void inverseOrderTreeWalk(BinaryTreeNode<T,E> n, StringBuilder s){
		if(n != nil){
			inverseOrderTreeWalk(n.getRight(), s);
			if(n.getRight() != nil){
				s.append(", ");
			}
			s.append(n.getKey().toString());
			if(n.getLeft() != nil){
				s.append(", ");
			}
			inverseOrderTreeWalk(n.getLeft(), s);
		}
	}
	
	public int getHeight(){
		return getHeight(root) - 1;
	}
	
	private int getHeight(BinaryTreeNode<T,E> n){
		int height = 0;
		if(n != nil){
			int hLeft = getHeight(n.getLeft());
			int hRight = getHeight(n.getRight());
			height = Math.max(hLeft, hRight) + 1;
		}
		return height;
	}
	
	public BinaryTreeNode<T,E> search(T key){
		BinaryTreeNode<T,E> n = root;
		while(n != nil && !n.getKey().equals(key)){
			if(key.compareTo(n.getKey()) < 0){
				n = n.getLeft();
			}else{
				n = n.getRight();
			}
		}
		return n;
	}
	
	public BinaryTreeNode<T,E> minimum(){
		return minimum(root);
	}
	
	public BinaryTreeNode<T,E> minimum(BinaryTreeNode<T,E> node){
		BinaryTreeNode<T,E> minimum = null;
		if(node != nil){
			minimum = node;
			while(minimum.getLeft() != nil){
				minimum = minimum.getLeft();
			}
		}
		return minimum;
	}
	
	public BinaryTreeNode<T,E> maximum(){
		return maximum(root);
	}
	
	public BinaryTreeNode<T,E> maximum(BinaryTreeNode<T,E> node){
		BinaryTreeNode<T,E> maximum = null;
		if(node != nil){
			maximum = node;
			while(maximum.getRight() != nil){
				maximum = maximum.getRight();
			}
		}
		return maximum;
	}

	public void insert(T key, E value){
		insert(new BinaryTreeNode<T,E>(key, value));
	}
	
	protected void insert(BinaryTreeNode<T,E> z){
		BinaryTreeNode<T,E> y = nil;
		BinaryTreeNode<T,E> x = root;
		while(x != nil){
			y = x;
			if(z.compareTo(x) < 0){
				x = x.getLeft();
			}else{
				x = x.getRight();
			}
		}
		z.setParent(y);
		if(y == nil){
			root = z;
		}else if(z.compareTo(y) < 0){
			y.setLeft(z);
		}else{
			y.setRight(z);
		}
		z.setLeft(nil);
		z.setRight(nil);
		size++;
	}
	
	public BinaryTreeNode<T,E> predecessor(BinaryTreeNode<T,E> node){
		BinaryTreeNode<T,E> predecessor = null;
		if(node.getLeft() != nil){
			predecessor = maximum(node.getLeft());
		}else{
			predecessor = node.getParent();
			while(predecessor != nil && node == predecessor.getLeft()){
				node = predecessor;
				predecessor = predecessor.getParent();
			}
		}
		return predecessor;
	}
	
	public BinaryTreeNode<T,E> sucessor(BinaryTreeNode<T,E> node){
		BinaryTreeNode<T,E> sucessor = null;
		if(node.getRight() != nil){
			sucessor = minimum(node.getRight());
		}else{
			sucessor = node.getParent();
			while(sucessor != nil && node == sucessor.getRight()){
				node = sucessor;
				sucessor = sucessor.getParent();
			}
		}
		return sucessor;
	}
	
	public void transplant(BinaryTreeNode<T,E> old, BinaryTreeNode<T,E> fresh){
		if(old.getParent() == nil){
			root = fresh;
		} else if(old == old.getParent().getLeft()){
			old.getParent().setLeft(fresh);
		}else{
			old.getParent().setRight(fresh);
		}
		fresh.setParent(old.getParent());
	}
	
	public void delete(BinaryTreeNode<T,E> z){
		if(z.getLeft() == nil){
			transplant(z, z.getRight());
		}else if(z.getRight() == nil){
			transplant(z, z.getLeft());
		}else {
			BinaryTreeNode<T,E> y = minimum(z.getRight());
			if(!y.getParent().equals(z)){
				transplant(y, y.getRight());
				y.setRight(z.getRight());
				y.getRight().setParent(y);
			}
			transplant(z, y);
			y.setLeft(z.getLeft());
			y.getLeft().setParent(y);
		}
	}
	
	protected void leftRotate(BinaryTreeNode<T, E> x){
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
	
	protected void rightRotate(BinaryTreeNode<T, E> x){
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
	
	public String extendedPreOrderTreeWalk(){
		StringBuilder s = new StringBuilder();
		extendedPreOrderTreeWalk(root, s);
		return s.toString();
	}
	
	protected void extendedPreOrderTreeWalk(BinaryTreeNode<T,E> n, StringBuilder s){
		if(n != nil){
			s.append(n.toString());
			s.append("\n");
			extendedPreOrderTreeWalk(n.getLeft(), s);
			extendedPreOrderTreeWalk(n.getRight(), s);
		}
	}
}

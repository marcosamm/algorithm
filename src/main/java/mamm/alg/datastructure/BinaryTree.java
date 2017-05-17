package mamm.alg.datastructure;

import lombok.Getter;
import lombok.Setter;

public class BinaryTree<T extends Comparable<T>, E> {
	public static final int NODE_VIEW_LENGHT = 2;
	
	@Getter
	class TreeNode implements Comparable<TreeNode>{
		@Setter
		private TreeNode parent;
		@Setter
		private TreeNode left;
		@Setter
		private TreeNode right;
		
		private T key;
		private E value;
		
		TreeNode(T key, E value){
			this.key = key;
			this.value = value;
		}

		@Override
		public int compareTo(TreeNode o) {
			return getKey().compareTo(o.getKey());
		}
		
		@Override
		public boolean equals(Object obj) {
			boolean equals = false;
			if(obj != null){
				@SuppressWarnings("unchecked")
				TreeNode o = (TreeNode) obj;
				return getKey().equals(o.getKey());
			}
			return equals;
		}
		
		@Override
		public String toString() {
			if(key != null){
				return getKey().toString();
			}
			return null;
		}
	}
	
	enum WalkOrder {
		PRE_ORDER,
		IN_ORDER,
		POST_ORDER,
		BY_LEVEL_ORDER,
		INVERSE_ORDER;
	}
	@Getter
	private TreeNode root;
	@Getter
	private int size;
	
	public BinaryTree() {
	}
	
	public String treeWalk(WalkOrder walkOrder){
		StringBuilder s = new StringBuilder();
		s.append("[");
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
		s.append("]");
		return s.toString();
	}
	
	public void preOrderTreeWalk(TreeNode n, StringBuilder s){
		if(n != null){
			s.append(n.getKey().toString());
			if(n.getLeft() != null){
				s.append(", ");
			}
			preOrderTreeWalk(n.getLeft(), s);
			if(n.getRight() != null){
				s.append(", ");
			}
			preOrderTreeWalk(n.getRight(), s);
		}
	}
	
	public void inOrderTreeWalk(TreeNode n, StringBuilder s){
		if(n != null){
			inOrderTreeWalk(n.getLeft(), s);
			if(n.getLeft() != null){
				s.append(", ");
			}
			s.append(n.getKey().toString());
			if(n.getRight() != null){
				s.append(", ");
			}
			inOrderTreeWalk(n.getRight(), s);
		}
	}
	
	public void postOrderTreeWalk(TreeNode n, StringBuilder s){
		if(n != null){
			postOrderTreeWalk(n.getLeft(), s);
			if(n.getLeft() != null){
				s.append(", ");
			}
			postOrderTreeWalk(n.getRight(), s);
			if(n.getRight() != null){
				s.append(", ");
			}
			s.append(n.getKey().toString());
		}
	}
	
	public void byLevelTreeWalk(TreeNode root, StringBuilder s){
		Queue<TreeNode> level = new Queue<BinaryTree<T,E>.TreeNode>(size);
		if(root != null){
			level.enqueue(root);
		}
		while(!level.isEmpty()){
			TreeNode node = level.dequeue();
			s.append(node.getKey().toString());
			if(node.getLeft() != null){
				level.enqueue(node.getLeft());
			}
			if(node.getRight() != null){
				level.enqueue(node.getRight());
			}
			if(!level.isEmpty()){
				s.append(", ");
			}
		}
	}
	
	public void inverseOrderTreeWalk(TreeNode n, StringBuilder s){
		if(n != null){
			inverseOrderTreeWalk(n.getRight(), s);
			if(n.getRight() != null){
				s.append(", ");
			}
			s.append(n.getKey().toString());
			if(n.getLeft() != null){
				s.append(", ");
			}
			inverseOrderTreeWalk(n.getLeft(), s);
		}
	}
	/*
	public void printTree(){
		StringBuilder [] sbs = new StringBuilder[getHeight()+1];
		for (int i=0; i< sbs.length; i++) {
			sbs[i] = new StringBuilder();
		}
		printTree(root, sbs, 0);
	}
	
	public void printTree(Node node, StringBuilder[] sbs, int i){
		int height = getHeight();
		while(node != null){
			sbs[i].append(String.format("%1$"+(height-i)*NODE_VIEW_LENGHT+ "s", ""));
			sbs[i].append(String.format("%1$"+NODE_VIEW_LENGHT+ "s", node.getKey().toString()));
			if(node.getLeft() != null){
				printTree()
			}
			if(node.getRight() != null){
				level.enqueue(node.getRight());
			}
			if(!level.isEmpty()){
				s.append(", ");
			}
		}
	}*/
	
	public int getHeight(){
		return getHeight(root) - 1;
	}
	
	private int getHeight(TreeNode n){
		int height = 0;
		if(n != null){
			int hLeft = getHeight(n.getLeft());
			int hRight = getHeight(n.getRight());
			height = Math.max(hLeft, hRight) + 1;
		}
		return height;
	}
	
	public TreeNode search(T key){
		TreeNode n = root;
		while(n != null && !n.getKey().equals(key)){
			if(key.compareTo(n.getKey()) < 0){
				n = n.getLeft();
			}else{
				n = n.getRight();
			}
		}
		return n;
	}
	
	public TreeNode minimum(){
		return minimum(root);
	}
	
	public TreeNode minimum(TreeNode node){
		TreeNode minimum = null;
		if(node != null){
			minimum = node;
			while(minimum.getLeft() != null){
				minimum = minimum.getLeft();
			}
		}
		return minimum;
	}
	
	public TreeNode maximum(){
		return maximum(root);
	}
	
	public TreeNode maximum(TreeNode node){
		TreeNode maximum = null;
		if(node != null){
			maximum = node;
			while(maximum.getRight() != null){
				maximum = maximum.getRight();
			}
		}
		return maximum;
	}

	public void insert(T key, E value){
		TreeNode z = new TreeNode(key, value);
		
		TreeNode y = null;
		TreeNode x = root;
		while(x != null){
			y = x;
			if(z.compareTo(x) < 0){
				x = x.getLeft();
			}else{
				x = x.getRight();
			}
		}
		z.setParent(y);
		if(y == null){
			root = z;
		}else if(z.compareTo(y) < 0){
			y.setLeft(z);
		}else{
			y.setRight(z);
		}
		size++;
	}
	
	public TreeNode predecessor(TreeNode node){
		TreeNode predecessor = null;
		if(node.getLeft() != null){
			predecessor = maximum(node.getLeft());
		}else{
			predecessor = node.getParent();
			while(predecessor != null && node.compareTo(predecessor.getLeft())==0){
				node = predecessor;
				predecessor = predecessor.getParent();
			}
		}
		return predecessor;
	}
	
	public TreeNode sucessor(TreeNode node){
		TreeNode sucessor = null;
		if(node.getRight() != null){
			sucessor = minimum(node.getRight());
		}else{
			sucessor = node.getParent();
			while(sucessor != null && node.equals(sucessor.getRight())){
				node = sucessor;
				sucessor = sucessor.getParent();
			}
		}
		return sucessor;
	}
	
	public void transplant(TreeNode old, TreeNode fresh){
		if(old.getParent() == null){
			root = fresh;
		} else if(old.equals(old.getParent().getLeft())){
			old.getParent().setLeft(fresh);
		}else{
			old.getParent().setRight(fresh);
		}
		if(fresh != null){
			fresh.setParent(old.getParent());
		}
	}
	
	public void delete(TreeNode z){
		if(z.getLeft() == null){
			transplant(z, z.getRight());
		}else if(z.getRight() == null){
			transplant(z, z.getLeft());
		}else {
			TreeNode y = minimum(z.getRight());
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
}

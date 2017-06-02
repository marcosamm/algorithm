package mamm.alg.datastructure;

import lombok.Getter;
import lombok.Setter;

@Getter
public class BinaryTreeNode <T extends Comparable<T>, E> implements Comparable<BinaryTreeNode<T,E>>{
	@Setter
	protected BinaryTreeNode<T, E> parent;
	@Setter
	protected BinaryTreeNode<T, E> left;
	@Setter
	protected BinaryTreeNode<T, E> right;
	
	protected T key;
	protected E value;
	
	BinaryTreeNode(T key, E value){
		this.key = key;
		this.value = value;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		if(parent == null){
			sb.append("null");
		}else if(parent.getKey() == null){
			sb.append("NIL");
		}else{
			sb.append(parent.getKey().toString());
		}
		sb.append(", ");
		if(key == null){
			sb.append("NIL");
		}else{
			sb.append(key.toString());
		}
		sb.append(", ");
		if(left == null){
			sb.append("null");
		}else if (left.getKey() == null){
			sb.append("NIL");
		}else{
			sb.append(left.getKey().toString());
		}
		sb.append(", ");
		if(right == null){
			sb.append("null");
		}else if(right.getKey() == null){
			sb.append("NIL");
		}else{
			sb.append(right.getKey().toString());
		}
		sb.append(")");
		return sb.toString();
	}
	
	public void writeNode(RedBlackTreeNode<T,E> n, StringBuilder sb) {
		
	}

	@Override
	public int compareTo(BinaryTreeNode<T, E> o) {
		return getKey().compareTo(o.getKey());
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean equals = false;
		if(obj != null){
			@SuppressWarnings("unchecked")
			BinaryTreeNode<T,E> o = (BinaryTreeNode<T,E>) obj;
			equals = getKey().equals(o.getKey());
		}
		return equals;
	}
}
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		BinaryTreeNode<T, E> other = (BinaryTreeNode<T,E>) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
}
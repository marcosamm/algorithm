package mamm.alg.datastructure;

import lombok.Getter;
import lombok.Setter;

@Getter
public class BinaryTreeNode <T extends Comparable<T>, E> implements Comparable<BinaryTreeNode<T,E>>{
	@Setter
	private BinaryTreeNode<T, E> parent;
	@Setter
	private BinaryTreeNode<T, E> left;
	@Setter
	private BinaryTreeNode<T, E> right;
	
	private T key;
	private E value;
	
	BinaryTreeNode(T key, E value){
		this.key = key;
		this.value = value;
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
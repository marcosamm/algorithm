package mamm.alg.datastructure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RedBlackTreeNode <T extends Comparable<T>, E> extends BinaryTreeNode<T, E>{
	enum Color{
		RED, BLACK;
	}
	
	private Color color;
	
	public RedBlackTreeNode(T key, E value, Color color){
		super(key, value);
		this.color = color;
	}
}
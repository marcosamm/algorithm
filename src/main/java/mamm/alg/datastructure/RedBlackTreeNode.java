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
		sb.append(color==Color.RED?"vermelho":"preto");
		sb.append(", ");
		//sb.append(blackHeight(n));
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
}
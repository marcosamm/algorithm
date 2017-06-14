package mamm.alg.datastructure.graph;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Edge<T> implements Comparable<Edge<T>>{
	protected Node<T> from;
	protected Node<T> to;
	protected Integer weight;
	
	@Override
	public int compareTo(Edge<T> o) {
		return weight.compareTo(o.getWeight());
	}
}

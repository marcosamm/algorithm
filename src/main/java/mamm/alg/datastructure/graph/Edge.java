package mamm.alg.datastructure.graph;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Edge<T extends VertexInterf> implements Comparable<Edge<T>>{
	protected Node<T> from;
	protected Node<T> to;
	protected Integer weight;
	
	@Override
	public int compareTo(Edge<T> o) {
		int c = weight.compareTo(o.getWeight());
		if(c == 0){
			c = from.getVertex().compareTo(o.from.getVertex());
		}
		if(c == 0){
			c = to.getVertex().compareTo(o.to.getVertex());
		}
		return c;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		Edge<T> other = (Edge<T>) obj;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return from.getLabel() + " -> (" + weight + ") -> " + to.getLabel();
	}
}

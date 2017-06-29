package mamm.alg.datastructure.graph;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vertex implements VertexInterf{
	private String label;
	
	public Vertex(String label){
		this.label = label;
	}

	@Override
	public int compareTo(VertexInterf o) {
		return label.compareTo(o.getLabel());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
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
		Vertex other = (Vertex) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return label;
	}
}

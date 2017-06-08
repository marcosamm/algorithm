package mamm.alg.datastructure;

import lombok.Getter;

@Getter
public class Element<T extends Comparable<T>, E> implements Comparable<Element<T, E>>{
	T key;
	E value;
	
	public Element(T key, E value){
		this.key = key;
		this.value = value;
	}
	
	@Override
	public int compareTo(Element<T, E> o) {
		return this.getKey().compareTo(o.getKey());
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
		Element<T, E> other = (Element<T, E>) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
}

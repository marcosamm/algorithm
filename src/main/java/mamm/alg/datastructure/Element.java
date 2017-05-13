package mamm.alg.datastructure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}

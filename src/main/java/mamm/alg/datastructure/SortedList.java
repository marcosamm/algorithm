package mamm.alg.datastructure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortedList<T extends Comparable<T>> extends LinkedList<T>{
	public void insert(T value){
		if(value == null){
			throw new IllegalArgumentException("value is null");
		}
		Element next = sentinel.getNext();
		while(!next.equals(sentinel) && value.compareTo(next.getValue()) > 0){
			next = next.getNext();
		}
		Element prev = next.getPrev();
		Element newElement = new Element(value);
		newElement.setNext(next);
		newElement.setPrev(prev);
		prev.setNext(newElement);
		next.setPrev(newElement);
		size++;
	}
	
	public void insertAll(T [] values){
		for(T value : values){
			insert(value);
		}
	}
}

package mamm.alg.datastructure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortedList<T extends Comparable<T>, E> extends LinkedList<T, E>{
	public void insert(Element<T,E> element){
		if(element == null){
			throw new IllegalArgumentException("element is null");
		}
		Link next = sentinel.getNext();
		while(!next.equals(sentinel) && element.compareTo(next.getElement()) > 0){
			next = next.getNext();
		}
		Link prev = next.getPrev();
		Link newLink = new Link(element);
		newLink.setNext(next);
		newLink.setPrev(prev);
		prev.setNext(newLink);
		next.setPrev(newLink);
		size++;
	}
	
	public void insertAll(T [] values){
		for(T value : values){
			insert(new Element<T, E>(value, null));
		}
	}
}

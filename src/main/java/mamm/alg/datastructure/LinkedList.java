package mamm.alg.datastructure;

import java.lang.reflect.Array;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkedList<T> {
	
	@Getter
	@Setter
	class Element {
		private Element prev;
		private T value;
		private Element next;
		
		public Element(T value){
			this.value = value;
			this.prev = this;
			this.next = this;
		}
		
		@Override
		public String toString() {
			return prev.getValue() + " <- " + value + " -> " + next.getValue();
		}
	}
	
	protected Element sentinel;
	protected int size;
	
	public LinkedList(){
		this.sentinel = new Element(null);
		size = 0;
	}
	
	public boolean isEmpty(){
		boolean isEmpty = false;
		if(sentinel.getNext() == sentinel){
			isEmpty = true;
		}
		return isEmpty;
	}
	
	public Element search(T value){
		Element e = sentinel.getNext();
		while(e != sentinel && !value.equals(e.getValue())){
			e = e.getNext();
		}
		if(e == sentinel){
			e = null;
		}
		return e;
	}
	
	public void insert(T value){
		if(value == null){
			throw new IllegalArgumentException("value is null");
		}
		Element newElement = new Element(value);
		Element next = sentinel.getNext();
		newElement.setNext(next);
		newElement.setPrev(sentinel);
		sentinel.setNext(newElement);
		next.setPrev(newElement);
		size++;
	}
	
	public void delete(Element element){
		Element prev = element.getPrev();
		Element next = element.getNext();
		prev.setNext(next);
		next.setPrev(prev);
		size--;
	}
	
	public void delete(T value){
		Element e = search(value);
		if(e != null){
			delete(e);
		}
	}
	
	public Element getFirst(){
		return sentinel.next;
	}
	
	public Element getLast(){
		return sentinel.prev;
	}
	
	public T[] toArray(){
		if(size > 0){
			Element e = sentinel.getNext();
			@SuppressWarnings("unchecked")
			T[] array = (T[]) Array.newInstance(e.getValue().getClass(), size);
			int i = 0;
			while(!e.equals(sentinel)){
				array[i] = e.getValue();
				e = e.getNext();
				i++;
			}
			return array;
		}else{
			@SuppressWarnings("unchecked")
			T[] array = (T[]) new Object[0];
			return array;
		}
	}
}

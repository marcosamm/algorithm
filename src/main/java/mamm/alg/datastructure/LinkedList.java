package mamm.alg.datastructure;

import java.lang.reflect.Array;

import lombok.Getter;
import lombok.Setter;

@Getter
public class LinkedList<T extends Comparable<T>, E> {
	
	@Getter
	@Setter
	class Link {
		private Link prev;
		private Element<T, E> element;
		private Link next;
		
		public Link(Element<T, E> element){
			this.element = element;
			this.prev = this;
			this.next = this;
		}
	}
	
	protected Link sentinel;
	protected int size;
	
	public LinkedList(){
		this.sentinel = new Link(null);
		size = 0;
	}
	
	public boolean isEmpty(){
		boolean isEmpty = false;
		if(sentinel.getNext() == sentinel){
			isEmpty = true;
		}
		return isEmpty;
	}
	
	public Link search(Element<T,E> element){
		Link e = sentinel.getNext();
		while(e != sentinel && !element.getKey().equals(e.getElement().getKey())){
			e = e.getNext();
		}
		if(e == sentinel){
			e = null;
		}
		return e;
	}
	
	public void insert(Element<T,E> element){
		if(element == null){
			throw new IllegalArgumentException("value is null");
		}
		Link newLink = new Link(element);
		Link next = sentinel.getNext();
		newLink.setNext(next);
		newLink.setPrev(sentinel);
		sentinel.setNext(newLink);
		next.setPrev(newLink);
		size++;
	}
	
	public void delete(Link link){
		Link prev = link.getPrev();
		Link next = link.getNext();
		prev.setNext(next);
		next.setPrev(prev);
		link.setNext(null);
		link.setPrev(null);
		size--;
	}
	
	public void delete(Element<T,E> element){
		Link e = search(element);
		if(e != null){
			delete(e);
		}
	}
	
	public Link getFirst(){
		return sentinel.next;
	}
	
	public Link getLast(){
		return sentinel.prev;
	}
	
	public T[] getKeyArray(){
		if(size > 0){
			Link e = sentinel.getNext();
			@SuppressWarnings("unchecked")
			T[] array = (T[]) Array.newInstance(e.getElement().getKey().getClass(), size);
			int i = 0;
			while(!e.equals(sentinel)){
				array[i] = e.getElement().getKey();
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
	
	public Element<T,E>[] toArray(){
		if(size > 0){
			Link e = sentinel.getNext();
			@SuppressWarnings("unchecked")
			Element<T,E>[] array = (Element<T,E>[]) Array.newInstance(e.getElement().getClass(), size);
			int i = 0;
			while(!e.equals(sentinel)){
				array[i] = e.getElement();
				e = e.getNext();
				i++;
			}
			return array;
		}else{
			@SuppressWarnings("unchecked")
			Element<T,E>[] array = (Element<T,E>[]) new Object[0];
			return array;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Link e = sentinel.getNext();
		while(!e.equals(sentinel)){
			sb.append(e.getElement().getKey().toString());
			if(!e.getNext().equals(sentinel)){
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	@Override
	protected void finalize() throws Throwable {
		while(sentinel.next != null){
			delete(sentinel.next);
		}
		super.finalize();
	}
}

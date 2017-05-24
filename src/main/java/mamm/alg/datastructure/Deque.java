package mamm.alg.datastructure;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

public class Deque<T> extends Queue<T> {
	
	public Deque(int capacity) {
		super(capacity);
	}

	public void addLast(T element){
		super.enqueue(element);
	}
	
	public void addFirst(T element){
		if(isFull()){
			throw new BufferOverflowException();
		}
		head--;
		if(head == -1){
			head = capacity - 1;
		}
		queue[head] = element;
	}
	
	public T removeFirst(){
		return dequeue();
	}
	
	public T removeLast(){
		if(isEmpty()){
			throw new BufferUnderflowException();
		}
		tail--;
		if(tail == -1){
			tail = capacity - 1;
		}
		T e = queue[tail];
		queue[tail] = null;
		return e;
	}
}

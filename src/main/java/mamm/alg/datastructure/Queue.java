package mamm.alg.datastructure;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

public class Queue<T> {
	private int head;
	private int tail;
	private int capacity;
	private T[] queue;
	
	
	@SuppressWarnings("unchecked")
	public Queue(int capacity){
		if(capacity < 1){
			throw new IllegalArgumentException("capacity < 1");
		}
		this.head = 0;
		this.tail = 0;
		this.capacity = capacity + 1;
		this.queue = (T[]) new Object[this.capacity];
	}
	
	public boolean isEmpty(){
		boolean isEmpty = false;
		if(head == tail){
			isEmpty = true;
		}
		return isEmpty;
	}
	
	public boolean isFull(){
		boolean isFull = false;
		int diff = tail - head;
		if(diff == -1 || diff == capacity - 1){
			isFull = true;
		}
		return isFull;
	}
	
	public void enqueue(T element){
		if(isFull()){
			throw new BufferOverflowException();
		}
		queue[tail] = element;
		tail++;
		if(tail == capacity){
			tail = 0;
		}
	}
	
	public T dequeue(){
		if(isEmpty()){
			throw new BufferUnderflowException();
		}
		T e = queue[head];
		queue[head] = null;
		head++;
		if(head == capacity){
			head = 0;
		}
		return e;
	}
	
	public int size(){
		int size = tail - head;
		if(tail < head){
			size = capacity - head + tail; 
		}
		return size;
	}
}

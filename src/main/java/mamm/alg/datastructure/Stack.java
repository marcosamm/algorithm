package mamm.alg.datastructure;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

public class Stack<T> {
	private int top;
	private int capacity;
	private T[] stack;
	
	
	@SuppressWarnings("unchecked")
	public Stack(int capacity){
		if(capacity < 1){
			throw new IllegalArgumentException("capacity < 1");
		}
		this.top = -1;
		this.capacity = capacity;
		this.stack = (T[]) new Object[capacity];
	}
	
	public boolean isEmpty(){
		boolean isEmpty = false;
		if(top < 0){
			isEmpty = true;
		}
		return isEmpty;
	}
	
	public boolean isFull(){
		boolean isFull = false;
		if(top == capacity - 1){
			isFull = true;
		}
		return isFull;
	}
	
	public void push(T element){
		if(isFull()){
			throw new BufferOverflowException();
		}
		top++;
		stack[top] = element;
	}
	
	public T pop(){
		if(isEmpty()){
			throw new BufferUnderflowException();
		}
		T e = stack[top];
		stack[top] = null;
		top--;
		return e;
	}
	
	public int getSize(){
		return top+1;
	}
}

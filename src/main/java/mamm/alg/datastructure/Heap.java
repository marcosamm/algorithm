package mamm.alg.datastructure;

import java.util.Arrays;

import lombok.Getter;
import lombok.Setter;

public class Heap <T extends Comparable<T>>{
	public static final int MIN = 0;
	public static final int MAX = 1;
	
	protected T[] a;
	
	@Getter
	@Setter
	protected int heapSize;
	
	public Heap(T[] a) {
		this.a = a;
		this.heapSize = a.length - 1;
	}
	
	protected int getParent(int i){
		return (i-1)/2;
	}
	
	protected int getLeft(int i){
		return 2*i + 1;
	}
	
	protected int getRight(int i){
		return 2*i + 2;
	}
	
	public int getLength(){
		return a.length;
	}
	
	public T get(int i){
		return a[i];
	}
	
	public void set(int i, T value){
		a[i] = value;
	}
	
	public void heapfy(int tipoHeap, int parent){
		int left = getLeft(parent);
		int right = getRight(parent);
		/*
		 * largest if tipoHeap = MAX
		 * smaller if tipoHeap = MIN
		 */
		int largestOrSmaller = 0;
		if((left <= heapSize) 
			&& (
				(tipoHeap == MAX && a[left].compareTo(a[parent]) > 0)
				|| (tipoHeap == MIN && a[left].compareTo(a[parent]) < 0)
			)
		){
			largestOrSmaller = left;
		}else{
			largestOrSmaller = parent;
		}
		if((right <= heapSize) 
			&& (
				(tipoHeap == MAX && a[right].compareTo(a[largestOrSmaller]) > 0)
				|| (tipoHeap == MIN && a[right].compareTo(a[largestOrSmaller]) < 0)
			)
		){
			largestOrSmaller = right;
		}
		if(largestOrSmaller != parent){
			T parentValue = a[parent];
			a[parent] = a[largestOrSmaller];
			a[largestOrSmaller] = parentValue;
			heapfy(tipoHeap, largestOrSmaller);
		}
	}
	
	public void buildHeap(int tipoHeap){
		heapSize = a.length - 1;
		for(int i= (a.length-1)/2; i >= 0; i--){
			heapfy(tipoHeap, i);
		}
	} 
	
	public void buildMaxHeap(){
		buildHeap(MAX);
	}
	
	public void buildMinHeap(){
		buildHeap(MIN);
	}
	
	@Override
	public String toString() {
		return "heapSize: " + heapSize + "; a: " + Arrays.toString(a);
	}
}
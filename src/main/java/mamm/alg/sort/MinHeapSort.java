package mamm.alg.sort;

import java.util.Arrays;

public class MinHeapSort <T extends Comparable<T>> {
	class Heap {
		protected T[] a;
		protected int heapSize;
		
		public Heap(T[] a) {
			this.a = a;
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
		
		@Override
		public String toString() {
			return "heapSize: " + heapSize + "; a: " + Arrays.toString(a);
		}
	}
	
	private void minHeapfy(Heap h, int parent){
		int left = h.getLeft(parent);
		int right = h.getRight(parent);
		int smaller = 0;
		if((left <= h.heapSize) && (h.a[left].compareTo(h.a[parent]) < 0)){
			smaller = left;
		}else{
			smaller = parent;
		}
		if((right <= h.heapSize) && (h.a[right].compareTo(h.a[smaller]) < 0)){
			smaller = right;
		}
		if(smaller != parent){
			T parentValue = h.a[parent];
			h.a[parent] = h.a[smaller];
			h.a[smaller] = parentValue;
			minHeapfy(h, smaller);
		}
	}
	
	private void buildMinHeap(Heap h){
		h.heapSize = h.a.length - 1;
		for(int i= (h.a.length-1)/2; i >= 0; i--){
			minHeapfy(h, i);
		}
	}
	
	public void sort(T[] a){
		if(a == null || a.length == 0){
			throw new IllegalArgumentException("a.lenght == 0 or a == null");
		}
		Heap h = new Heap(a);
		buildMinHeap(h);
		for(int i = a.length - 1; i > 0; i--){
			T a0Value = a[0];
			h.a[0] = a[i];
			h.a[i] = a0Value;
			h.heapSize--;
			minHeapfy(h, 0);
		}
	}
}

package mamm.alg.sort;

import mamm.alg.datastructure.Heap;

public class HeapSort {
	public static <T extends Comparable<T>> void sort(int tipoHeap, Heap<T> h){
		h.buildHeap(tipoHeap);
		for(int i = h.getLength() - 1; i > 0; i--){
			T a0Value = h.get(0);
			h.set(0, h.get(i));
			h.set(i, a0Value);
			h.setHeapSize(h.getHeapSize() - 1);
			h.heapfy(tipoHeap, 0);
		}
	}
	
	public static <T extends Comparable<T>> void sort(int tipoHeap, T[] a){
		sort(tipoHeap, new Heap<T>(a));
	}
}

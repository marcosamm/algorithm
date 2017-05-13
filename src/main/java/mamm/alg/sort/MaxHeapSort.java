package mamm.alg.sort;

import mamm.alg.datastructure.Heap;

public class MaxHeapSort <T extends Comparable<T>> {
	public void sort(int tipoHeap, Heap<T> h){
		h.buildHeap(tipoHeap);
		for(int i = h.getLength() - 1; i > 0; i--){
			T a0Value = h.get(0);
			h.set(0, h.get(i));
			h.set(i, a0Value);
			h.setHeapSize(h.getHeapSize() - 1);
			h.heapfy(tipoHeap, 0);
		}
	}
}

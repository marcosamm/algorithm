package mamm.alg.sort;

import java.lang.reflect.Array;

public class MergeSort <T extends Comparable<T>> {
	private static <T extends Comparable<T>> void merge(T[] a, int p, int q, int r){
		int n1 = q - p + 1;
		int n2 = r - q;
		@SuppressWarnings("unchecked")
		T[] L = (T[]) Array.newInstance(a[0].getClass(), n1+1);
		@SuppressWarnings("unchecked")
		T[] R = (T[]) Array.newInstance(a[0].getClass(), n2+1);
		for(int i=0; i < n1; i++){
			L[i] = a[p + i];
		}
		for(int j=0; j < n2; j++){
			R[j] = a[q + j + 1];
		}
		L[n1] = SortUtil.getHighestPossibleValueOf(a[0]);
		R[n2] = SortUtil.getHighestPossibleValueOf(a[0]);
		int i=0;
		int j=0;
		for(int k=p; k <= r; k++){
			if(L[i].compareTo(R[j]) < 0){
				a[k] = L[i];
				i++;
			}else{
				a[k] = R[j];
				j++;
			}
		}
	}
	
	private static <T extends Comparable<T>> void mergeSort(T[] a, int p, int r){
		if(p < r){
			int q = (int) ((p+r)/2);
			mergeSort(a, p, q);
			mergeSort(a, q+1, r);
			merge(a, p, q, r);
		}
	}
	
	public static <T extends Comparable<T>> void sort(T[] a){
		if(a == null || a.length == 0){
			throw new IllegalArgumentException("a.lenght == 0 or a == null");
		}
		mergeSort(a, 0, a.length-1);
	}
}

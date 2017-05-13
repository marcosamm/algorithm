package mamm.alg.sort;

public class MaxSubarray <T extends Comparable<T>> {
	private T infinit;
	
	public MaxSubarray(T infinitValue){
		this.infinit = infinitValue;
	}
	
	private void merge(T[] a, int p, int q, int r){
		int n1 = q - p + 1;
		int n2 = r - q;
		@SuppressWarnings("unchecked")
		T[] L = (T[]) new Comparable[n1 + 1];
		@SuppressWarnings("unchecked")
		T[] R = (T[]) new Comparable[n2 + 1];
		for(int i=0; i < n1; i++){
			L[i] = a[p + i];
		}
		for(int j=0; j < n2; j++){
			R[j] = a[q + j + 1];
		}
		L[n1] = infinit;
		R[n2] = infinit;
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
	
	private void mergeSort(T[] a, int p, int r){
		if(p < r){
			int q = (int) ((p+r)/2);
			mergeSort(a, p, q);
			mergeSort(a, q+1, r);
			merge(a, p, q, r);
		}
	}
	
	public void sort(T[] a){
		mergeSort(a, 0, a.length-1);
	}
}

package mamm.alg.sort;

public class QuickSort {
	private static <T extends Comparable<T>> int partition(T[] a, int p, int r){
		T x = a[r];
		int i = p - 1;
		for(int j = p; j < r; j++){
			if(a[j].compareTo(x) <= 0){
				i++;
				T aux = a[i];
				a[i] = a[j];
				a[j] = aux;
			}
		}
		T aux = a[i+1];
		a[i+1] = a[r];
		a[r] = aux;
		return i+1;
	}
	
	public static <T extends Comparable<T>> void quickSort(T[] a, int p, int r){
		if(p < r){
			int q = partition(a, p, r);
			quickSort(a, p, q - 1);
			quickSort(a, q + 1, r);
		}
	}
	
	public static <T extends Comparable<T>> void sort(T[] a){
		quickSort(a, 0, a.length - 1);
	}
	
	private static <T extends Comparable<T>> int randomizedPartition(T[] a, int p, int r){
		int i = p + (int) (Math.random()*(r-p));
		T aux = a[i];
		a[i] = a[r];
		a[r] = aux;
		return partition(a, p, r);
	}
	
	public static <T extends Comparable<T>> void randomizedQuickSort(T[] a, int p, int r){
		if(p < r){
			int q = randomizedPartition(a, p, r);
			randomizedQuickSort(a, p, q - 1);
			randomizedQuickSort(a, q + 1, r);
		}
	}
	
	public static <T extends Comparable<T>> void randomizedSort(T[] a){
		randomizedQuickSort(a, 0, a.length - 1);
	}
}

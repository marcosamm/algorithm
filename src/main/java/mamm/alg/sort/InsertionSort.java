package mamm.alg.sort;


public class InsertionSort {
	public static <T extends Comparable<T>> void sort(T[] a){
		if(a == null || a.length == 0){
			throw new IllegalArgumentException("a.lenght == 0 or a == null");
		}
		for(int j=1; j < a.length; j++){
			T key = a[j];
			int i = j - 1;
			while(i >= 0 && a[i].compareTo(key) > 0){
				a[i+1] = a[i];
				i--;
			}
			a[i+1] = key;
		}
	}
}

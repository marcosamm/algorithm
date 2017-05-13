package mamm.alg.sort;

import mamm.alg.datastructure.SortedList;


public class BucketSort {
	public static void sort(Float[] a){
		int n = a.length;
		@SuppressWarnings("unchecked")
		SortedList<Float> [] b = new SortedList [n];
		for(int i=0; i < n; i++){
			b[i] = new SortedList<Float>();
		}
		for(int i= 0; i < n; i++){
			int iBucket = (int)(n*a[i]);
			b[iBucket].insert(a[i]);
		}
		int i=0;
		for(int j=0; j < b.length; j++){
			if(b[j].getSize() > 0){
				Float[] bi = b[j].toArray();
				for(int k=0; k < bi.length; k++){
					a[i] = bi[k];
					i++;
				}
			}
		}
	}
}

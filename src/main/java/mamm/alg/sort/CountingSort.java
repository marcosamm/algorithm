package mamm.alg.sort;

import java.util.Arrays;


public class CountingSort {
	public static void sort(Integer[] a, Integer[] b, int k){
		if(a == null){
			throw new IllegalArgumentException("a is null");
		}
		Integer [] c = new Integer[k+1];
		for(int i=0; i <= k; i++){
			c[i] = 0;
		}
		for(int j=0; j < a.length; j++){
			c[a[j]]++;
		}
		//c[i] agora contém o número de elementos iguais a i
		for(int i=1; i < c.length; i++){
			c[i] = c[i] + c[i-1];
		}
		//c[i] agora contém o número de elementos menores ou iguais a i
		for(int j = a.length - 1; j >= 0; j--){
			b[c[a[j]]-1] = a[j];
			c[a[j]]--;
		}
	}
	
	public static void sort(Integer[] a, Integer[] b){
		sort(a, b, SortUtil.getMaxValue(a));
	}
	
	public static void sortByDigit(Integer[] a, int d){
		if(a == null){
			throw new IllegalArgumentException("a is null");
		}
		Integer [] c = new Integer[10];
		Arrays.fill(c, 0);
		
		for(int j=0; j < a.length; j++){
			c[getDigit(d, a[j])]++;
		}
		//c[i] agora contém o número de elementos iguais a i
		for(int i=1; i < c.length; i++){
			c[i] = c[i] + c[i-1];
		}
		//c[i] agora contém o número de elementos menores ou iguais a i

		Integer [] b = new Integer[a.length];
		for(int j = a.length - 1; j >= 0; j--){
			b[c[getDigit(d, a[j])]-1] = a[j];
			c[getDigit(d, a[j])]--;
		}
		for(int i=0; i < a.length; i++){
			a[i] = b[i];
		}
	}
	
	public static Integer getDigit(int d, Integer value){
		return (int)((value/Math.pow(10, d-1))%10);
	}
	
	public static void sortByCharacter(String [] a, int d){
		if(a == null){
			throw new IllegalArgumentException("a is null");
		}
		Integer [] c = new Integer[256];
		Arrays.fill(c, 0);
		
		for(int j=0; j < a.length; j++){
			c[getChar(d, a[j])]++;
		}
		//c[i] agora contém o número de elementos iguais a i
		for(int i=1; i < c.length; i++){
			c[i] = c[i] + c[i-1];
		}
		//c[i] agora contém o número de elementos menores ou iguais a i

		String [] b = new String[a.length];
		for(int j = a.length - 1; j >= 0; j--){
			b[c[getChar(d, a[j])]-1] = a[j];
			c[getChar(d, a[j])]--;
		}
		for(int i=0; i < a.length; i++){
			a[i] = b[i];
		}
	}
	
	public static char getChar(int d, String value){
		return value.charAt(value.length() - d);
	}
}

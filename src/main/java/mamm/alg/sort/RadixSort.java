package mamm.alg.sort;


public class RadixSort {
	public static void sort(Integer [] a){
		if(a == null){
			throw new IllegalArgumentException("a is null");
		}
		Integer max = SortUtil.getMaxValue(a);
		int qtdDigitos = getNumberOfDigits(max);
		for(int i = 1; i <= qtdDigitos; i++){
			CountingSort.sortByDigit(a, i);
		}
	}
	
	public static int getNumberOfDigits(Integer number){
		return number.toString().length();
	}
	
	public static void sort(String [] a){
		if(a == null){
			throw new IllegalArgumentException("a is null");
		}
		if(!SortUtil.sameNumberOfDigits(a)){
			throw new IllegalArgumentException("Different number of digits");
		}
		int qtdDigitos = a[0].length();
		for(int i = 1; i <= qtdDigitos; i++){
			CountingSort.sortByCharacter(a, i);
		}
	}
}

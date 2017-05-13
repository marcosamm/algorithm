package mamm.alg.sort;

public class SortUtil {
	public static <T extends Comparable<T>> boolean isOrdenedAcending(T[] a){
		if(a == null){
			throw new IllegalArgumentException("a is null");
		}
		boolean ordened = true;
		
		for(int i = 1; i < a.length; i++){
			if(a[i-1].compareTo(a[i]) > 0){
				ordened = false;
				break;
			}
		}
		
		return ordened;
	}
	
	public static <T extends Comparable<T>> boolean isOrdenedDescending(T[] a){
		if(a == null){
			throw new IllegalArgumentException("a is null");
		}
		
		boolean ordened = true;
		
		for(int i = 1; i < a.length; i++){
			if(a[i-1].compareTo(a[i]) < 0){
				ordened = false;
				break;
			}
		}
		
		return ordened;
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> T getHighestPossibleValueOf(T t){
		if(t == null){
			throw new IllegalArgumentException("t is null");
		}
		T max = null;
		try {
			max = (T) t.getClass().getDeclaredField("MAX_VALUE").get(null);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			throw new RuntimeException("Could not find the greatest value");
		}
		return max;
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> T getLowestPossibleValueOf(T t){
		if(t == null){
			throw new IllegalArgumentException("t is null");
		}
		T min = null;
		try {
			min = (T) t.getClass().getDeclaredField("MIN_VALUE").get(null);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			throw new RuntimeException("Could not find the greatest value");
		}
		return min;
	}
	
	public static <T extends Comparable<T>> T getMaxValue(T[] array){
		T max = getLowestPossibleValueOf(array[0]);
		
		for(int i = 0; i < array.length; i++){
			if(array[i].compareTo(max) > 0){
				max = array[i];
			}
		}
		
		return max;
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> T getMinValue(T[] a){
		if(a == null){
			throw new IllegalArgumentException("a is null");
		}
		T max = null;
		try {
			max = (T) a[0].getClass().getDeclaredField("MAX_VALUE").get(null);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			throw new RuntimeException("Could not find the lowest value");
		}
		
		for(int i = 0; i < a.length; i++){
			if(a[i].compareTo(max) < 0){
				max = a[i];
			}
		}
		
		return max;
	}
	
	public static boolean sameNumberOfDigits(String [] a){
		if(a == null){
			throw new IllegalArgumentException("a is null");
		}
		boolean same = true;
		
		for(int i=1; i < a.length; i++){
			if(a[i-1].length() != a[i].length()){
				same = false;
				break;
			}
		}
		
		return same;
	}
}

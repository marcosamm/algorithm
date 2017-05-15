package mamm.alg.datastructure;

import lombok.Getter;
import lombok.Setter;



public abstract class AbstractHashTable <E> implements HashTable<Integer, E>{
	public static final float A = 0.6180339887f;
	
	@Getter
	@Setter
	protected int size;
	protected int m;
	private Integer a;
	private Integer b;
	private Integer p;
	private HashMethod hashMethod;
	
	public AbstractHashTable(int m){
		initialize(m, HashMethod.DIVISION, null, null, null);
	}
	
	public AbstractHashTable(int m, HashMethod hashMethod){
		if(hashMethod == HashMethod.UNVERSAL){
			throw new IllegalArgumentException("UNIVERSAL method needs p parameter, use the constructor HashTable(int m, int p)");
		}
		initialize(m, hashMethod, null, null, null);
	}
	
	public AbstractHashTable(int m, int p){
		Integer a = (int) (1 + Math.random()*(p-1));
		Integer b = (int) Math.random()*p; 
		initialize(m, HashMethod.UNVERSAL, p, a, b);
	}
	
	public AbstractHashTable(int m, int p, int a, int b){
		if(a < 1 || a > p - 1){
			throw new IllegalArgumentException("1 < a < p-1");
		}
		if(b < 0 || b > p - 1){
			throw new IllegalArgumentException("0 < b < p-1");
		}
		initialize(m, HashMethod.UNVERSAL, p, a, b);
	}
	
	protected void initialize(int m, HashMethod hashMethod, Integer p, Integer a, Integer b){
		if(m < 0){
			throw new IllegalArgumentException("m < 0");
		}
		this.m = m;
		this.hashMethod = hashMethod;
		this.size = 0;
		if(hashMethod == HashMethod.UNVERSAL){
			if(p == null || p < 0){
				throw new IllegalArgumentException("p > 0 and p must be a prime");
			}
			this.p = p;
			this.a = a;
			this.b = b;
		}
	}
	
	public int getHash(Integer key){
		int hash = 0;
		int k = Math.abs(key);
		
		switch (hashMethod) {
			case UNVERSAL:
				hash = (int) ( ((a*k+b) % p) % m);
				break;
			case MULTIPLICATION:
				hash = (int) (m*((k*A)%1));
				break;
			case DIVISION:
			default:
				hash = Math.abs(key) % m;
				break;
		}
		return hash;
	}
}
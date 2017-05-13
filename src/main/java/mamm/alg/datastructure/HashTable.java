package mamm.alg.datastructure;

import lombok.Getter;
import lombok.Setter;



public class HashTable <E> implements Hash<Integer, E>{
	public static final float A = 0.6180339887f;
	
	public enum HashMethod{
		DIVISION,
		MULTIPLICATION,
		UNVERSAL;
	}
	
	@Getter
	@Setter
	private int size;
	private LinkedList<Integer, E> [] t;
	private int m;
	private Integer a;
	private Integer b;
	private Integer p;
	private HashMethod hashMethod;
	
	public HashTable(int m){
		initialize(m, HashMethod.DIVISION, null, null, null);
	}
	
	public HashTable(int m, HashMethod hashMethod){
		if(hashMethod == HashMethod.UNVERSAL){
			throw new IllegalArgumentException("UNIVERSAL method needs p parameter, use the constructor HashTable(int m, int p)");
		}
		initialize(m, hashMethod, null, null, null);
	}
	
	public HashTable(int m, int p){
		Integer a = (int) (1 + Math.random()*(p-1));
		Integer b = (int) Math.random()*p; 
		initialize(m, HashMethod.UNVERSAL, p, a, b);
	}
	
	public HashTable(int m, int p, int a, int b){
		if(a < 1 || a > p - 1){
			throw new IllegalArgumentException("1 < a < p-1");
		}
		if(b < 0 || b > p - 1){
			throw new IllegalArgumentException("0 < b < p-1");
		}
		initialize(m, HashMethod.UNVERSAL, p, a, b);
	}
	
	@SuppressWarnings("unchecked")
	private void initialize(int m, HashMethod hashMethod, Integer p, Integer a, Integer b){
		if(m < 0){
			throw new IllegalArgumentException("m < 0");
		}
		this.m = m;
		this.hashMethod = hashMethod;
		this.size = 0;
		this.t = new LinkedList [m];
		for(int i=0; i < t.length; i++){
			t[i] = new LinkedList<Integer, E>();
		}
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
	
	public void put(Integer key, E value){
		int iList = getHash(key);
		t[iList].insert(new Element<Integer, E>(key, value));
		size++;
	}
	
	public E get(Integer key){
		E value = null;
		int iList = getHash(key);
		
		LinkedList<Integer, E>.Link e = t[iList].search(new Element<Integer, E>(key, null));
		if(e != null){
			value = e.getElement().getValue();
		}
		return value;
	}
	
	public void remove(Integer key){
		int iList = getHash(key);
		t[iList].delete(new Element<Integer, E>(key, null));
		size--;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i < t.length; i++) {
			sb.append("[").append(i).append("] => ");
			Integer [] a = t[i].getKeyArray();
			for(int j = 0; j < a.length; j++){
				sb.append(a[j].intValue());
				if(j != a.length - 1){
					sb.append(", ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
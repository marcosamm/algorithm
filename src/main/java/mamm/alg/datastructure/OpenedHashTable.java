package mamm.alg.datastructure;

import java.nio.BufferOverflowException;




public class OpenedHashTable <E> extends AbstractHashTable<E>{
	
	public enum OpenAddressType{
		LINEAR_PROBING,
		QUADRATIC_PROBING,
		DOUBLE_HASHING;
	}
	final Element<Integer, E> DELETED = new Element<Integer, E>(Integer.MIN_VALUE, null);
	
	private Element<Integer, E> [] t;
	private OpenAddressType openAddressType;
	private float c1 = 1;
	private float c2 = 0;
	
	/**
	 * Division Method + Linear Probing.
	 * @param m Hash length.
	 */
	public OpenedHashTable(int m){
		super(m);
		initialize(OpenAddressType.LINEAR_PROBING, 1.0f, 0.0f);
	}
	
	/**
	 * Division Method + Quadratic Probing.
	 * @param m Hash length.
	 * @param c1 Constant used in quadratic probing.
	 * @param c2 Constant used in quadratic probing.
	 */
	public OpenedHashTable(int m, float c1, float c2){
		super(m);
		initialize(OpenAddressType.QUADRATIC_PROBING, c1, c2);
	}
	
	public OpenedHashTable(int m, HashMethod hashMethod, OpenAddressType openAddressType){
		super(m, hashMethod);
		initialize(openAddressType, c1, c2);
	}
	
	public OpenedHashTable(int m, OpenAddressType openAddressType){
		super(m, m);
		this.openAddressType = openAddressType;
	}
	
	public OpenedHashTable(int m, OpenAddressType openAddressType, int a, int b, float c1, float c2){
		super(m, m, a, b);
		this.openAddressType = openAddressType;
		this.c1 = c1;
		this.c2 = c2;
	}
	
	@SuppressWarnings("unchecked")
	protected void initialize(OpenAddressType openAddressType, float c1, float c2){
		this.t = new Element [m];
		for(int i=0; i < t.length; i++){
			t[i] = null;
		}
		this.openAddressType = openAddressType;
		this.c1 = c1;
		this.c2 = c2;
	}
	
	public int getHash(Integer key, int attempt){
		int j = -1;
		switch (openAddressType) {
			case QUADRATIC_PROBING:
				j = (int) ((super.getHash(key) + c1*attempt + c2*attempt*attempt)%m);
				break;
			case DOUBLE_HASHING:
				
				break;
			case LINEAR_PROBING:
			default:
				j = (super.getHash(key) + attempt)%m;
				break;
		}
		return j;
	}
	
	public void put(Integer key, E value){
		int i = 0;
		do{
			int j = getHash(key, i);
			if(t[j] == null || t[j].equals(DELETED)){
				t[j] = new Element<Integer, E>(key, value);
				size++;
				break;
			}else{
				i++;
			}
		}while(i < m);
		if(i == m){
			throw new BufferOverflowException();
		}
	}
	
	public Integer indexOf(Integer key){
		Integer index = null;
		
		int i = 0;
		int j = 0;
		do{
			j = getHash(key, i);
			if(t[j].getKey().equals(key)){
				index = j;
				break;
			}else{
				i++;
			}
		}while(t[j] != null && !t[j].equals(DELETED));
		
		return index;
	}
	
	public E get(Integer key){
		E value = null;
		
		Integer index = indexOf(key);
		if(index != null){
			value = t[index].getValue();
		}
		
		return value;
	}
	
	public void remove(Integer key){
		Integer index = indexOf(key);
		if(index != null){
			t[index] = DELETED;
			size--;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int j = 0; j < t.length; j++){
			if(t[j] == null){
				sb.append("null");
			}else if(t[j].equals(DELETED)){
				sb.append("DEL");
			}else{
				sb.append(t[j].getKey().intValue());
			}
			if(j != t.length - 1){
				sb.append(", ");
			}
		}
		sb.append("]\n");
		return sb.toString();
	}
}
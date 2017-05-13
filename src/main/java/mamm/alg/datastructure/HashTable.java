package mamm.alg.datastructure;

import lombok.Getter;
import lombok.Setter;



public class HashTable <E> implements Hash<Integer, E>{
	@Getter
	@Setter
	private int size;
	private LinkedList<Integer, E> [] t;
	private int m;
	
	@SuppressWarnings("unchecked")
	public HashTable(int m){
		this.m = m;
		this.size = 0;
		this.t = new LinkedList [m];
		for(int i=0; i < t.length; i++){
			t[i] = new LinkedList<Integer, E>();
		}
	}
	
	public int getHash(Integer key){
		return Math.abs(key) % m;
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
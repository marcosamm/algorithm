package mamm.alg.datastructure;



public class HashTable <T extends Comparable<T>, E> implements Hash<T, E>{
	private int size;
	private LinkedList<T, E> [] t;
	
	public HashTable(int m){
		this.size = 0;
		this.t = new LinkedList [m];
	}
	
	public int getHash(T key){
		return 0;
	}
	
	public void put(T key, E value){
		int iList = getHash(key);
		t[iList].insert(new Element<T, E>(key, value));
		size++;
	}
	
	public E get(T key){
		int iList = getHash(key);
		return t[iList].search(new Element<T, E>(key, null)).getElement().getValue();
	}
	
	public void remove(T key){
		int iList = getHash(key);
		t[iList].delete(new Element<T, E>(key, null));
	}
}
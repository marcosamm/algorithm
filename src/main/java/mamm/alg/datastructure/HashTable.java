package mamm.alg.datastructure;


public interface HashTable<T extends Comparable<T>, E>{
	public enum HashMethod{
		DIVISION,
		MULTIPLICATION,
		UNVERSAL;
	}
	int getHash(T key);
	public void put(T key, E value);
	public E get(T key);
	public void remove(T key);
	public int getSize();
}
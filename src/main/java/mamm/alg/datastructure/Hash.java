package mamm.alg.datastructure;


public interface Hash<T extends Comparable<T>, E>{
	int getHash(T key);
	public void put(T key, E value);
	public E get(T key);
	public void remove(T key);
	public int getSize();
}
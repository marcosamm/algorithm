package mamm.alg.datastructure;




public class LinkedHashTable <E> extends AbstractHashTable<E>{
	
	private LinkedList<Integer, E> [] t;
	
	public LinkedHashTable(int m){
		super(m);
	}
	
	public LinkedHashTable(int m, HashMethod hashMethod){
		super(m, hashMethod);
	}
	
	public LinkedHashTable(int m, int p){
		super(m, p);
	}
	
	public LinkedHashTable(int m, int p, int a, int b){
		super(m, p, a, b);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void initialize(int m, HashMethod hashMethod, Integer p, Integer a, Integer b){
		super.initialize(m, hashMethod, p, a, b);
		this.t = new LinkedList [m];
		for(int i=0; i < t.length; i++){
			t[i] = new LinkedList<Integer, E>();
		}
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
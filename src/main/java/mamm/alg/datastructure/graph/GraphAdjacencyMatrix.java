package mamm.alg.datastructure.graph;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;


public class GraphAdjacencyMatrix<T extends VertexInterf> implements Graph<T> {
	public static final int MIN_SIZE = 10;
	
	int [][] adjMatrix;
	private int numVertices;
	private int numEdges;
	private int nullValue;
	
	private SortedSet<Integer> unUsedIndexes;
	private Map<T, Integer> usedInexes;
	
	public GraphAdjacencyMatrix(int initialCapacity, int nullValue) {
		this.nullValue = nullValue;
		adjMatrix = new int [initialCapacity][initialCapacity];
		for(int i=0; i < initialCapacity; i++){
			for(int j=0; j < initialCapacity; j++){
				adjMatrix[i][j] = nullValue;
			}
		}
		numVertices = 0;
		numEdges = 0;
		unUsedIndexes = new TreeSet<Integer>();
		usedInexes = new LinkedHashMap<>();
		for(int i=0; i < adjMatrix.length; i++){
			unUsedIndexes.add(i);
		}
	}

	@Override
	public void addVertex(T v) {
		if(numVertices == adjMatrix.length){
			resizeMatrix();
		}
		Integer i = unUsedIndexes.first();
		unUsedIndexes.remove(i);
		usedInexes.put(v, i);
		numVertices++;
	}

	@Override
	public void addEdge(T u, T v, int weight) {
		if(!usedInexes.containsKey(u)){
			throw new VertexNofFoundException("Vertex " + u.getLabel() + " not found");
		}
		if(!usedInexes.containsKey(v)){
			throw new VertexNofFoundException("Vertex " + v.getLabel() + " not found");
		}
		
		Integer iU = usedInexes.get(u);
		Integer iV = usedInexes.get(v);
		adjMatrix[iU][iV] = weight;
		numEdges++;
	}

	@Override
	public void removeVertex(T v) {
		Integer i = usedInexes.get(v);
		unUsedIndexes.add(i);
		usedInexes.remove(v);
		numVertices--;
		cleanMatrix(i);
		if(numVertices < adjMatrix.length/2){
			resizeMatrix();
		}
	}
	
	public void cleanMatrix(int index){
		int size = adjMatrix.length;
		for(int j=0; j < size; j++){
			adjMatrix[index][j] = nullValue;
		}
		for(int i=0; i < size; i++){
			adjMatrix[i][index] = nullValue;
		}
	}

	@Override
	public void removeEdge(T u, T v) {
		if(!usedInexes.containsKey(u)){
			throw new VertexNofFoundException("Vertex " + u.getLabel() + " not found");
		}
		if(!usedInexes.containsKey(v)){
			throw new VertexNofFoundException("Vertex " + v.getLabel() + " not found");
		}
		
		Integer iU = usedInexes.get(u);
		Integer iV = usedInexes.get(v);
		adjMatrix[iU][iV] = nullValue;
		numEdges--;
	}

	@Override
	public int getWeight(T u, T v) {
		Integer iU = usedInexes.get(u);
		Integer iV = usedInexes.get(v);
		return adjMatrix[iU][iV];
	}

	@Override
	public int getNumVertices() {
		return numVertices;
	}
	
	private void resizeMatrix(){
		int oldSize = adjMatrix.length;
		if(numVertices == oldSize){
			int newSize = 2*oldSize;
			int [][] newAdjMatrix = new int [newSize][newSize];
			for(int i=0; i < newSize; i++){
				for(int j=0; j < newSize; j++){
					if(i < oldSize && j < oldSize){
						newAdjMatrix[i][j] = adjMatrix[i][j];
					}else{
						newAdjMatrix[i][j] = nullValue;
					}
				}
				if(i >= oldSize){
					unUsedIndexes.add(i);
				}
			}
			adjMatrix = newAdjMatrix;
		}else if(numVertices < oldSize/2){
			int newSize = oldSize/2;
			compressMatrix();
			int [][] newAdjMatrix = new int [newSize][newSize];
			for(int i=0; i < newSize; i++){
				for(int j=0; j < newSize; j++){
					newAdjMatrix[i][j] = adjMatrix[i][j];
				}
			}
			for(Iterator<Integer> iterator = unUsedIndexes.iterator(); iterator.hasNext();){
				Integer element = iterator.next();
				if(element >= newSize){
					iterator.remove();
				}
			}
			adjMatrix = newAdjMatrix;
		}
	}
	
	private void compressMatrix(){
		int size = adjMatrix.length;
		for (Iterator<Entry<T, Integer>> iterator = usedInexes.entrySet().iterator(); iterator.hasNext();) {
			Entry<T, Integer> entry = iterator.next();
			Integer newIndex = unUsedIndexes.first();
			if(entry.getValue() > newIndex){
				unUsedIndexes.remove(newIndex);
				Integer oldIndex = entry.getValue();
				for(int j=0; j < size; j++){
					adjMatrix[newIndex][j] = adjMatrix[oldIndex][j];
					adjMatrix[oldIndex][j] = nullValue;
				}
				for(int i=0; i < size; i++){
					adjMatrix[i][newIndex] = adjMatrix[i][oldIndex];
					adjMatrix[i][oldIndex] = nullValue;
				}
				entry.setValue(newIndex);
				unUsedIndexes.add(oldIndex);
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getMatrixStringRepresentation(true));
		sb.append(getLegend());
		return sb.toString();
	}
	
	public String getMatrixStringRepresentation(boolean printIndex){
		int size = adjMatrix.length;
		int n = 1 + adjMatrix.length/10;
		String pattStr = "%1$-" + n + "s";
		String pattInt = "%" + n + "d";
		StringBuilder sb = new StringBuilder();
		if(printIndex){
			sb.append(String.format(pattStr, ""));
			sb.append("  ");//" ["
		
			for(int i=0; i < size; i++){
				sb.append(String.format(pattInt, i));
				if(i < size - 1){
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		for(int i=0; i < size; i++){
			if(printIndex){
				sb.append(String.format(pattInt, i));
			}
			sb.append(" [");
			for(int j=0; j < size; j++){
				sb.append(String.format(pattInt, adjMatrix[i][j]));
				if(j < size - 1){
					sb.append(" ");
				}
			}
			sb.append("]\n");
		}
		return sb.toString();
	}
	
	public String getLegend(){
		SortedSet<String> lengends = new TreeSet<String>();
		for (Iterator<Entry<T, Integer>> iterator = usedInexes.entrySet().iterator(); iterator.hasNext();) {
			Entry<T, Integer> entry = iterator.next();
			lengends.add(entry.getValue() + " - " + entry.getKey().getLabel());
		}
		StringBuilder sb = new StringBuilder();
		for(String legend : lengends){
			sb.append(legend);
			sb.append("\n");
		}
		return sb.toString();
	}
}

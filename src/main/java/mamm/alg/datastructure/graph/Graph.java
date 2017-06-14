package mamm.alg.datastructure.graph;

public interface Graph<T extends VertexInterf> {
	public void addVertex(T v) throws Exception;
	public void addEdge(T u, T v, int weight) throws Exception;
	public void removeVertex(T v);
	public void removeEdge(T u, T v);
	public int getWeight(T u, T v);
	public int getNumVertices();
}

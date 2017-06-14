package mamm.alg.datastructure.graph;

import java.lang.reflect.ParameterizedType;
import java.util.Map;
import java.util.TreeMap;

public class GraphAdjacencyList<V extends VertexInterf, N extends Node<V>, E extends Edge<V>> implements Graph<V> {
	private Class<N> nodeClass;
	private Class<E> edgeClass;
	
	
	Map<V,N> mapVN;
	
	@SuppressWarnings("unchecked")
	public GraphAdjacencyList() {
		super();
		this.mapVN = new TreeMap<>();
		this.nodeClass = (Class<N>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		this.edgeClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
	}

	@Override
	public void addVertex(V v) throws InstantiationException, IllegalAccessException {
		N node = nodeClass.newInstance();
		node.setVertex(v);
		mapVN.put(v, node);
	}

	@Override
	public void addEdge(V u, V v, int weight) throws InstantiationException, IllegalAccessException {
		N nU = mapVN.get(u);
		N nV = mapVN.get(v);
		E edge = edgeClass.newInstance();
		edge.setFrom(nU);
		edge.setTo(nV);
		edge.setWeight(weight);
		nU.addLeaveEdge(edge);
		nV.addEnterEdge(edge);
	}

	@Override
	public void removeVertex(V v) {
		N nV = mapVN.get(v);
		nV.removeLeavesEdges(nV.getLeavesEdges());
		for (Edge<V> enterEdge : nV.getEntersEdges()) {
			enterEdge.getFrom().removeEnterEdge(enterEdge);
		}
		mapVN.remove(v);
	}

	@Override
	public void removeEdge(V u, V v) {
		N nU = mapVN.get(u);
		N nV = mapVN.get(v);
		Edge<V> edge = nU.getLeaveEdge(v);
		nU.removeLeaveEdge(edge);
		nV.removeEnterEdge(edge);
	}

	@Override
	public int getWeight(V u, V v) {
		int weight = Integer.MAX_VALUE;
		N nU = mapVN.get(u);
		Edge<V> edge = nU.getLeaveEdge(v);
		if(edge != null){
			weight = edge.getWeight();
		}
		return weight;
	}

	@Override
	public int getNumVertices() {
		return mapVN.keySet().size();
	}
}

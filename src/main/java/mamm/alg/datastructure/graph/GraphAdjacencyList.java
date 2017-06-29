package mamm.alg.datastructure.graph;

import static mamm.alg.datastructure.graph.Node.Color.BLACK;
import static mamm.alg.datastructure.graph.Node.Color.GRAY;
import static mamm.alg.datastructure.graph.Node.Color.WHITE;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public abstract class GraphAdjacencyList<V extends VertexInterf, N extends Node<V>, E extends Edge<V>> implements Graph<V> {
	protected Map<V,N> mapVN = new TreeMap<>();
	//TODO Verificar se é necessário - Acho que será útil pra o algoritmo de Kruskal e Bellman-Ford
	protected Set<E> edges = new TreeSet<>();
	private int time;
	
	public GraphAdjacencyList() {
		super();
	}
	
	public abstract N newNode();
	public abstract E newEdge();

	@Override
	public void addVertex(V v) {
		N node = newNode();
		node.setVertex(v);
		mapVN.put(v, node);
	}

	@Override
	public void addEdge(V u, V v, int weight) {
		N nU = mapVN.get(u);
		N nV = mapVN.get(v);
		E edge = newEdge();
		edge.setFrom(nU);
		edge.setTo(nV);
		edge.setWeight(weight);
		nU.addLeaveEdge(edge);
		nV.addEnterEdge(edge);
		edges.add(edge);
	}

	@Override
	public void removeVertex(V v) {
		N nV = mapVN.get(v);
		Set<Edge<V>> leavesEdges = nV.getLeavesEdges();
		edges.removeAll(leavesEdges);
		nV.removeLeavesEdges(leavesEdges);
		Set<Edge<V>> entersEdges = nV.getEntersEdges();
		edges.removeAll(entersEdges);
		nV.removeEntersEdges(entersEdges);
		for (Edge<V> enterEdge : entersEdges) {
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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Entry<V, N> es : mapVN.entrySet()){
			sb.append(es.getValue().toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public void breadthFirstSearch(V s){
		breadthFirstSearch(mapVN.get(s));
	}
	
	public void breadthFirstSearch(N s){
		for (N u : mapVN.values()) {
			u.setColor(WHITE);
			u.setD(Integer.MAX_VALUE);
			u.setParent(null);
		}
		s.setColor(GRAY);
		s.setD(0);
		Queue<Node<V>> queue = new LinkedList<>();
		queue.add(s);
		while(!queue.isEmpty()){
			Node<V> u = queue.remove();
			for(Edge<V> e : u.getLeavesEdges()){
				Node<V> v = e.getTo();
				if(v.getColor() == WHITE){
					v.setColor(GRAY);
					v.setD(u.getD() + e.getWeight());
					v.setParent(u);
					queue.add(v);
				}
			}
			u.setColor(BLACK);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void printPath(N s, N v, StringBuilder sb){
		if(v == s){
			sb.append(s.getLabel());
		}else if(v.getParent() == null){
			throw new PathNofFoundException("No path from '" + s.getLabel() + "' to '" + v.getLabel() + "' exists");
		}else{
			printPath(s, (N) v.getParent(), sb);
			sb.append(" => ");
			sb.append(v.getLabel());
		}
	}
	
	public String getPath(V s, V v){
		StringBuilder sb = new StringBuilder();
		N nS = mapVN.get(s);
		N nV = mapVN.get(v);
		breadthFirstSearch(nS);
		printPath(nS, nV, sb);
		return sb.toString();
	}
	
	public void depthFirstSearch(){
		depthFirstSearch(null, null);
	}
	
	public void depthFirstSearch(LinkedList<V> topologicalList){
		depthFirstSearch(topologicalList, null);
	}
	
	public void depthFirstSearch(StringBuilder sb){
		depthFirstSearch(null, sb);
	}
	
	public void depthFirstSearch(LinkedList<V> topologicalList, StringBuilder sb){
		for (N u : mapVN.values()) {
			u.setColor(WHITE);
			u.setParent(null);
		}
		time = 0;
		for (N u : mapVN.values()) {
			if(u.getColor() == WHITE){
				if(sb != null && sb.length() > 0){
					sb.append(" ");
				}
				depthFirstSearchVisit(u, topologicalList, sb);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void depthFirstSearchVisit(N u, LinkedList<V> topologicalList, StringBuilder sb){
		time++;									//white vertex u has just been discovered
		u.setD(time);
		u.setColor(GRAY);
		if(sb != null){
			sb.append("(").append(u.getLabel());
		}
		for(Edge<V> e : u.getLeavesEdges()){	//explore edge (u,v)
			Node<V> v = e.getTo();
			if(v.getColor() == WHITE){
				v.setParent(u);
				if(sb != null){
					sb.append(" ");
				}
				depthFirstSearchVisit((N) v, topologicalList, sb);
				if(sb != null){
					sb.append(" ");
				}
			}
		}
		u.setColor(BLACK);						//blacken u; it is finished
		time++;
		u.setF(time);
		if(topologicalList != null){
			topologicalList.addFirst(u.getVertex());
		}
		if(sb != null){
			if(u.getD() == u.getF()-1){
				sb.append(" ");
			}
			sb.append(u.getLabel()).append(")");
		}
	}
}

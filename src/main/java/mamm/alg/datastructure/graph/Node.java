package mamm.alg.datastructure.graph;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node<T extends VertexInterf> {
	public static enum Color{
		WHITE, GRAY, BLACK;
	}
	
	private T vertex;
	
	private Set<Edge<T>> leavesEdges = new TreeSet<>();
	private Set<Edge<T>> entersEdges = new TreeSet<>();
	
	private Color color;
	private int d;
	private int f;
	private Node<T> parent;
	
	public Node(){
	}
	
	public Node(T vertex){
		this.vertex = vertex;
	}
	
	public String getLabel(){
		String label = null;
		if(vertex != null){
			label = vertex.getLabel();
		}
		return label;
	}
	
	public void addLeaveEdge(Edge<T> edge){
		leavesEdges.add(edge);
	}
	
	public void removeLeaveEdge(Edge<T> edge){
		leavesEdges.remove(edge);
	}
	
	public void removeLeavesEdges(Collection<Edge<T>> edges){
		leavesEdges.removeAll(edges);
	}
	
	public Edge<T> getLeaveEdge(T to){
		Edge<T> leavEdge = null;
		for (Edge<T> edge : leavesEdges) {
			if(edge.to.equals(to)){
				leavEdge = edge;
				break;
			}
		}
		return leavEdge;
	}
	
	public Set<Node<T>> getAdjacents(){
		Set<Node<T>> adjs = new TreeSet<>();
		for (Edge<T> edge : leavesEdges) {
			adjs.add(edge.to);
		}
		return adjs;
	}
	
	public void addEnterEdge(Edge<T> edge){
		entersEdges.add(edge);
	}
	
	public void removeEnterEdge(Edge<T> edge){
		entersEdges.remove(edge);
	}
	
	public void removeEntersEdges(Collection<Edge<T>> edges){
		entersEdges.removeAll(edges);
	}
	
	public Edge<T> getEnterEdge(T from){
		Edge<T> enterEdge = null;
		for (Edge<T> edge : entersEdges) {
			if(edge.to.equals(from)){
				enterEdge = edge;
				break;
			}
		}
		return enterEdge;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(vertex.getLabel());
		for(Edge<T> e : leavesEdges){
			sb.append(" => ");
			sb.append(e.to.getLabel());
		}
		return sb.toString();
	}
}

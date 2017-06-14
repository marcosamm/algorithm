package mamm.alg.datastructure.graph;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node<T> {
	private T vertex;
	
	private Set<Edge<T>> leavesEdges;
	private Set<Edge<T>> entersEdges;
	
	public Node(T vertex){
		this.vertex = vertex;
		leavesEdges = new TreeSet<>();
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
}

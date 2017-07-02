package mamm.alg.datastructure.graph;

import java.util.Collection;
import java.util.PriorityQueue;

import lombok.Getter;
import lombok.Setter;

public class MinimumSpanningTreePrim extends GraphAdjacencyList<Vertex, Node<Vertex>, Edge<Vertex>>{
	@Getter
	@Setter
	static class PrimNode extends Node<Vertex> implements Comparable<PrimNode>{
		boolean inQ = false;
		
		@Override
		public int compareTo(PrimNode o) {
			if(this.getD() < o.getD()){
				return -1;
			}else if(this.getD() > o.getD()){
				return 1;
			}
			return 0;
		}
	}
	
	@Override
	public Node<Vertex> newNode() {
		return new PrimNode();
	}
	@Override
	public Edge<Vertex> newEdge() {
		return new Edge<Vertex>();
	}
	
	public void mstPrim(Vertex r){
		Node<Vertex> root = mapVN.get(r);
		Collection<Node<Vertex>> vertices = mapVN.values();
		for(Node<Vertex> u : vertices){
			u.setD(Integer.MAX_VALUE); //u.d is key property
			u.setParent(null);
			((PrimNode) u).setInQ(true);
		}
		root.setD(0);
		PriorityQueue<Node<Vertex>> q = new PriorityQueue<>(vertices);
		while(!q.isEmpty()){
			PrimNode u = (PrimNode) q.remove();
			u.setInQ(false);
			for(Edge<Vertex> e : u.getLeavesEdges()){
				PrimNode v = (PrimNode) e.getTo();
				if(v.isInQ() && e.getWeight() < v.getD()){
					v.setParent(u);
					q.remove(v);
					//TODO Implements a PriorityQueue whith decreaseKey or use fibonacci heap
					v.setD(e.getWeight());
					q.add(v);
				}
			}
		}
	}
	
	public String getStringMstPrim(Vertex r){
		mstPrim(r);
		int weight = 0;
		StringBuilder sb = new StringBuilder();
		for(Node<Vertex> u : mapVN.values()){
			sb.append(u.getLabel()).append(" ");
			if(u.getParent() == null){
				sb.append("root");
			}else{
				weight += u.getD();
				sb.append("=(").append(u.getD()).append(")=> ").append(u.getParent().getLabel());
			}
			sb.append("\n");
		}
		sb.append("weight: ").append(weight);
		return sb.toString();
	}
}

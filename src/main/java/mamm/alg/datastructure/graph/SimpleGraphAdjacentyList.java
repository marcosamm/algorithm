package mamm.alg.datastructure.graph;

class SimpleGraphAdjacencyList extends GraphAdjacencyList<Vertex, Node<Vertex>, Edge<Vertex>> {		
	@Override
	public Node<Vertex> newNode() {
		return new Node<Vertex>();
	}
	
	@Override
	public Edge<Vertex> newEdge() {
		return new Edge<Vertex>();
	}
	
	
}
package mamm.alg.datastructure.graph;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


public class GraphAdjacencyListTest {
	Vertex v0 = new Vertex("1");
	Vertex v1 = new Vertex("1");
	Vertex v2 = new Vertex("2");
	Vertex v3 = new Vertex("3");
	Vertex v4 = new Vertex("4");
	Vertex v5 = new Vertex("5");
	Vertex v6 = new Vertex("6");
	Vertex v7 = new Vertex("7");
	Vertex v8 = new Vertex("8");
	Vertex v9 = new Vertex("9");
	Vertex v10 = new Vertex("10");
	Vertex v11 = new Vertex("11");
	Vertex v12 = new Vertex("12");
	
	private GraphAdjacencyList<VertexInterf, Node<VertexInterf>, Edge<VertexInterf>> getGraph() throws InstantiationException, IllegalAccessException {
		GraphAdjacencyList<VertexInterf, Node<VertexInterf>, Edge<VertexInterf>> g = new GraphAdjacencyList<>();
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);
		g.addVertex(v5);
		g.addVertex(v6);
		g.addEdge(v1, v2, 1);
		g.addEdge(v1, v4, 1);
		g.addEdge(v2, v5, 1);
		g.addEdge(v4, v2, 1);
		g.addEdge(v5, v4, 1);
		g.addEdge(v3, v5, 1);
		g.addEdge(v3, v6, 1);
		g.addEdge(v6, v6, 1);
		return g;
	}
	
	@Test
	public void insert() throws InstantiationException, IllegalAccessException{
		GraphAdjacencyList<VertexInterf, Node<VertexInterf>, Edge<VertexInterf>> g = getGraph();
		String expected = "\n";
		assertEquals(g.toString(), expected);
	}
}
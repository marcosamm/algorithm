package mamm.alg.datastructure.graph;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


public class GraphAdjacencyMatrixTest {
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
	
	private GraphAdjacencyMatrix<VertexInterf> getGraph() {
		GraphAdjacencyMatrix<VertexInterf> g = new GraphAdjacencyMatrix<VertexInterf>(6, 0);
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
	
	private GraphAdjacencyMatrix<VertexInterf> getExpandexGraph(){
		GraphAdjacencyMatrix<VertexInterf> g = getGraph();
		g.addVertex(v7);
		g.addVertex(v8);
		g.addVertex(v9);
		g.addVertex(v10);
		g.addEdge(v6, v7, 1);
		g.addEdge(v7, v8, 1);
		g.addEdge(v8, v9, 1);
		g.addEdge(v9, v10, 1);
		g.addEdge(v10, v6, 1);
		g.addEdge(v10, v1, 1);
		g.addEdge(v10, v8, 1);
		g.addEdge(v8, v6, 1);
		g.addEdge(v6, v4, 1);
		return g;
	}
	
	@Test
	public void insert(){
		GraphAdjacencyMatrix<VertexInterf> g = getGraph();
		String expected =
			"   0 1 2 3 4 5\n" +
			"0 [0 1 0 1 0 0]\n" +
			"1 [0 0 0 0 1 0]\n" +
			"2 [0 0 0 0 1 1]\n" +
			"3 [0 1 0 0 0 0]\n" +
			"4 [0 0 0 1 0 0]\n" +
			"5 [0 0 0 0 0 1]\n" +
			"0 - 1\n" +
			"1 - 2\n" +
			"2 - 3\n" +
			"3 - 4\n" +
			"4 - 5\n" +
			"5 - 6\n";
		assertEquals(g.toString(), expected);
	}
	
	@Test
	public void expandMatrix(){
		GraphAdjacencyMatrix<VertexInterf> g = getExpandexGraph();
		String expected =
				"     0  1  2  3  4  5  6  7  8  9 10 11\n" +
				" 0 [ 0  1  0  1  0  0  0  0  0  0  0  0]\n" +
				" 1 [ 0  0  0  0  1  0  0  0  0  0  0  0]\n" +
				" 2 [ 0  0  0  0  1  1  0  0  0  0  0  0]\n" +
				" 3 [ 0  1  0  0  0  0  0  0  0  0  0  0]\n" +
				" 4 [ 0  0  0  1  0  0  0  0  0  0  0  0]\n" +
				" 5 [ 0  0  0  1  0  1  1  0  0  0  0  0]\n" +
				" 6 [ 0  0  0  0  0  0  0  1  0  0  0  0]\n" +
				" 7 [ 0  0  0  0  0  1  0  0  1  0  0  0]\n" +
				" 8 [ 0  0  0  0  0  0  0  0  0  1  0  0]\n" +
				" 9 [ 1  0  0  0  0  1  0  1  0  0  0  0]\n" +
				"10 [ 0  0  0  0  0  0  0  0  0  0  0  0]\n" +
				"11 [ 0  0  0  0  0  0  0  0  0  0  0  0]\n" +
				"0 - 1\n" +
				"1 - 2\n" +
				"2 - 3\n" +
				"3 - 4\n" +
				"4 - 5\n" +
				"5 - 6\n" +
				"6 - 7\n" +
				"7 - 8\n" +
				"8 - 9\n" +
				"9 - 10\n";
		assertEquals(g.toString(), expected);	
	}
	
	@Test
	public void compressMatrix(){
		GraphAdjacencyMatrix<VertexInterf> g = getExpandexGraph();
		g.removeVertex(v10);
		g.removeVertex(v9);
		g.removeVertex(v8);
		g.removeVertex(v7);
		g.removeVertex(v6);
		String expected =
				"   0 1 2 3 4 5\n" +
				"0 [0 1 0 1 0 0]\n" +
				"1 [0 0 0 0 1 0]\n" +
				"2 [0 0 0 0 1 0]\n" +
				"3 [0 1 0 0 0 0]\n" +
				"4 [0 0 0 1 0 0]\n" +
				"5 [0 0 0 0 0 0]\n" +
				"0 - 1\n" +
				"1 - 2\n" +
				"2 - 3\n" +
				"3 - 4\n" +
				"4 - 5\n";
		assertEquals(g.toString(), expected);	
	}
	
	@Test
	public void expandAndCompressIntercalated(){
		GraphAdjacencyMatrix<VertexInterf> g = getExpandexGraph();
		g.removeVertex(v1);
		g.removeVertex(v3);
		g.removeVertex(v5);
		g.removeVertex(v7);
		g.removeVertex(v9);
		String expected =
				"   0 1 2 3 4 5\n" +
				"0 [1 0 0 1 0 0]\n" +
				"1 [0 0 0 0 0 0]\n" +
				"2 [1 0 0 0 0 0]\n" +
				"3 [0 1 0 0 0 0]\n" +
				"4 [1 0 1 0 0 0]\n" +
				"5 [0 0 0 0 0 0]\n" +
				"0 - 6\n" +
				"1 - 2\n" +
				"2 - 8\n" +
				"3 - 4\n" +
				"4 - 10\n";
		assertEquals(g.toString(), expected);	
	}
}
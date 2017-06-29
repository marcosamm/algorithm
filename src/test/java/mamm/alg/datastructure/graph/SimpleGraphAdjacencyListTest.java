package mamm.alg.datastructure.graph;

import static org.testng.Assert.assertEquals;

import java.util.LinkedList;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SimpleGraphAdjacencyListTest {
	GraphAdjacencyList<Vertex, Node<Vertex>, Edge<Vertex>> numericGraph;
	Vertex v1 = new Vertex("1");
	Vertex v2 = new Vertex("2");
	Vertex v3 = new Vertex("3");
	Vertex v4 = new Vertex("4");
	Vertex v5 = new Vertex("5");
	Vertex v6 = new Vertex("6");
	GraphAdjacencyList<Vertex, Node<Vertex>, Edge<Vertex>> alphabeticGraph;
	Vertex vs = new Vertex("s");
	Vertex vt = new Vertex("t");
	Vertex vu = new Vertex("u");
	Vertex vv = new Vertex("v");
	Vertex vw = new Vertex("w");
	Vertex vx = new Vertex("x");
	Vertex vy = new Vertex("y");
	Vertex vz = new Vertex("z");
	GraphAdjacencyList<Vertex, Node<Vertex>, Edge<Vertex>> clothingGraph;
	Vertex undershorts = new Vertex("undershorts");
	Vertex pants = new Vertex("pants");
	Vertex belt = new Vertex("belt");
	Vertex shirt = new Vertex("shirt");
	Vertex tie = new Vertex("tie");
	Vertex jacket = new Vertex("jacket");
	Vertex socks = new Vertex("socks");
	Vertex shoes = new Vertex("shoes");
	Vertex watch = new Vertex("watch");
	
	@BeforeTest
	public void setup() {
		numericGraph = new SimpleGraphAdjacencyList();
		numericGraph.addVertex(v1);
		numericGraph.addVertex(v2);
		numericGraph.addVertex(v3);
		numericGraph.addVertex(v4);
		numericGraph.addVertex(v5);
		numericGraph.addVertex(v6);
		numericGraph.addEdge(v1, v2, 1);
		numericGraph.addEdge(v1, v4, 1);
		numericGraph.addEdge(v2, v5, 1);
		numericGraph.addEdge(v4, v2, 1);
		numericGraph.addEdge(v5, v4, 1);
		numericGraph.addEdge(v3, v5, 1);
		numericGraph.addEdge(v3, v6, 1);
		numericGraph.addEdge(v6, v6, 1);
		
		alphabeticGraph = new SimpleGraphAdjacencyList();
		alphabeticGraph.addVertex(vs);
		alphabeticGraph.addVertex(vt);
		alphabeticGraph.addVertex(vu);
		alphabeticGraph.addVertex(vv);
		alphabeticGraph.addVertex(vw);
		alphabeticGraph.addVertex(vx);
		alphabeticGraph.addVertex(vy);
		alphabeticGraph.addVertex(vz);
		alphabeticGraph.addEdge(vs, vw, 1);
		alphabeticGraph.addEdge(vs, vz, 1);
		alphabeticGraph.addEdge(vt, vu, 1);
		alphabeticGraph.addEdge(vt, vv, 1);
		alphabeticGraph.addEdge(vu, vt, 1);
		alphabeticGraph.addEdge(vu, vv, 1);
		alphabeticGraph.addEdge(vv, vs, 1);
		alphabeticGraph.addEdge(vv, vw, 1);
		alphabeticGraph.addEdge(vw, vx, 1);
		alphabeticGraph.addEdge(vx, vz, 1);
		alphabeticGraph.addEdge(vy, vx, 1);
		alphabeticGraph.addEdge(vz, vw, 1);
		alphabeticGraph.addEdge(vz, vy, 1);
		
		clothingGraph = new SimpleGraphAdjacencyList();
		clothingGraph.addVertex(undershorts);
		clothingGraph.addVertex(pants);
		clothingGraph.addVertex(belt);
		clothingGraph.addVertex(shirt);
		clothingGraph.addVertex(tie);
		clothingGraph.addVertex(jacket);
		clothingGraph.addVertex(socks);
		clothingGraph.addVertex(shoes);
		clothingGraph.addVertex(watch);
		clothingGraph.addEdge(undershorts, pants, 1);
		clothingGraph.addEdge(undershorts, shoes, 1);
		clothingGraph.addEdge(pants, shoes, 1);
		clothingGraph.addEdge(pants, belt, 1);
		clothingGraph.addEdge(belt, jacket, 1);
		clothingGraph.addEdge(shirt, belt, 1);
		clothingGraph.addEdge(shirt, tie, 1);
		clothingGraph.addEdge(tie, jacket, 1);
		clothingGraph.addEdge(socks, shoes, 1);
	}
	
	@Test
	public void insert() {
		String expected = 
			"1 => 2 => 4\n" +
			"2 => 5\n" +
			"3 => 5 => 6\n" +
			"4 => 2\n" +
			"5 => 4\n" +
			"6 => 6\n";
		assertEquals(numericGraph.toString(), expected);
		
		expected = 
			"s => w => z\n" +
			"t => u => v\n" +
			"u => t => v\n" +
			"v => s => w\n" +
			"w => x\n" +
			"x => z\n" +
			"y => x\n" +
			"z => w => y\n";
		assertEquals(alphabeticGraph.toString(), expected);
		
		expected = 
				"belt => jacket\n" +
				"jacket\n" +
				"pants => belt => shoes\n" +
				"shirt => belt => tie\n" +
				"shoes\n" +
				"socks => shoes\n" +
				"tie => jacket\n" +
				"undershorts => pants => shoes\n" +
				"watch\n";
			assertEquals(clothingGraph.toString(), expected);
	}
	
	@Test
	public void shortestExistingPath() {
		String expected = "1 => 2 => 5";
		assertEquals(numericGraph.getPath(v1, v5), expected);
		
		expected = "t => v => s => z => y";
		assertEquals(alphabeticGraph.getPath(vt, vy), expected);
		
		expected = "undershorts => pants => belt => jacket";
		assertEquals(clothingGraph.getPath(undershorts, jacket), expected);
	}
	
	@Test(expectedExceptions=PathNofFoundException.class)
	public void shortestInexistingPath() {
		numericGraph.getPath(v1, v6);
	}
	
	@Test
	public void parentesis() {
		StringBuilder sb = new StringBuilder();
		numericGraph.depthFirstSearch(sb);
		String expected = "(1 (2 (5 (4 4) 5) 2) 1) (3 (6 6) 3)";
		assertEquals(sb.toString(), expected);
		
		sb = new StringBuilder();
		alphabeticGraph.depthFirstSearch(sb);
		expected = "(s (w (x (z (y y) z) x) w) s) (t (u (v v) u) t)";
		assertEquals(sb.toString(), expected);
		
		sb = new StringBuilder();
		clothingGraph.depthFirstSearch(sb);
		expected = "(belt (jacket jacket) belt) (pants (shoes shoes) pants) (shirt (tie tie) shirt) (socks socks) (undershorts undershorts) (watch watch)";
		assertEquals(sb.toString(), expected);
	}
	
	@Test
	public void topologicalSort() {
		LinkedList<Vertex> topologicalList = new LinkedList<>();
		clothingGraph.depthFirstSearch(topologicalList);
		StringBuilder sb = new StringBuilder();
		for (Vertex vertex : topologicalList) {
			if(sb.length() > 0){
				sb.append(" ");
			}
			sb.append(vertex.getLabel());
		}
		String expected = "watch undershorts socks shirt tie pants shoes belt jacket";
		assertEquals(sb.toString(), expected);
	}
}
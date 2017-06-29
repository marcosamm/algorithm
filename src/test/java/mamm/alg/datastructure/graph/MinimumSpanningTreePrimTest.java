package mamm.alg.datastructure.graph;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MinimumSpanningTreePrimTest {
	MinimumSpanningTreePrim mstPrimGraph;
	Vertex a = new Vertex("a");
	Vertex b = new Vertex("b");
	Vertex c = new Vertex("c");
	Vertex d = new Vertex("d");
	Vertex e = new Vertex("e");
	Vertex f = new Vertex("f");
	Vertex g = new Vertex("g");
	Vertex h = new Vertex("h");
	Vertex i = new Vertex("i");
	
	@BeforeTest
	public void setup() {
		mstPrimGraph = new MinimumSpanningTreePrim();
		mstPrimGraph.addVertex(a);
		mstPrimGraph.addVertex(b);
		mstPrimGraph.addVertex(c);
		mstPrimGraph.addVertex(d);
		mstPrimGraph.addVertex(e);
		mstPrimGraph.addVertex(f);
		mstPrimGraph.addVertex(g);
		mstPrimGraph.addVertex(h);
		mstPrimGraph.addVertex(i);
		mstPrimGraph.addEdge(a, b, 4);
		mstPrimGraph.addEdge(b, a, 4);
		mstPrimGraph.addEdge(a, h, 8);
		mstPrimGraph.addEdge(h, a, 8);
		mstPrimGraph.addEdge(b, c, 8);
		mstPrimGraph.addEdge(c, b, 8);
		mstPrimGraph.addEdge(b, h, 11);
		mstPrimGraph.addEdge(h, b, 11);
		mstPrimGraph.addEdge(c, d, 7);
		mstPrimGraph.addEdge(d, c, 7);
		mstPrimGraph.addEdge(c, f, 4);
		mstPrimGraph.addEdge(f, c, 4);
		mstPrimGraph.addEdge(c, i, 2);
		mstPrimGraph.addEdge(i, c, 2);
		mstPrimGraph.addEdge(d, e, 9);
		mstPrimGraph.addEdge(e, d, 9);
		mstPrimGraph.addEdge(d, f, 14);
		mstPrimGraph.addEdge(f, d, 14);
		mstPrimGraph.addEdge(e, f, 10);
		mstPrimGraph.addEdge(f, e, 10);
		mstPrimGraph.addEdge(f, g, 2);
		mstPrimGraph.addEdge(g, f, 2);
		mstPrimGraph.addEdge(g, h, 1);
		mstPrimGraph.addEdge(h, g, 1);
		mstPrimGraph.addEdge(g, i, 6);
		mstPrimGraph.addEdge(i, g, 6);
		mstPrimGraph.addEdge(i, h, 7);
		mstPrimGraph.addEdge(h, i, 7);
	}
	
	@Test
	public void cormemExample() {
		String expected = 
			"a root\n" +
			"b =(4)=> a\n" +
			"c =(4)=> f\n" +
			"d =(7)=> c\n" +
			"e =(9)=> d\n" +
			"f =(2)=> g\n" +
			"g =(1)=> h\n" +
			"h =(8)=> a\n" +
			"i =(2)=> c\n" +
			"weight: 37";
		assertEquals(mstPrimGraph.getStringMstPrim(a), expected);
	}
}
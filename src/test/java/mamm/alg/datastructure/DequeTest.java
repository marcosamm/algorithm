package mamm.alg.datastructure;

import static org.testng.Assert.assertEquals;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

import org.testng.annotations.Test;

public class DequeTest {
	
	@Test(expectedExceptions = BufferUnderflowException.class)
	public void removeFirstUnderflowException(){
		Deque<Integer> queue = new Deque<Integer>(3);
		queue.removeFirst();
	}
	
	@Test(expectedExceptions = BufferUnderflowException.class)
	public void removeLastUnderflowException(){
		Deque<Integer> queue = new Deque<Integer>(3);
		queue.removeLast();
	}
	
	@Test(expectedExceptions = BufferOverflowException.class)
	public void addFirstOverflowException(){
		Deque<Integer> queue = new Deque<Integer>(3);
		queue.addFirst(1);
		queue.addFirst(2);
		queue.addFirst(3);
		queue.addFirst(4);
	}
	
	@Test(expectedExceptions = BufferOverflowException.class)
	public void addLastOverflowException(){
		Deque<Integer> queue = new Deque<Integer>(3);
		queue.addLast(1);
		queue.addLast(2);
		queue.addLast(3);
		queue.addLast(4);
	}
	
	@Test
	public void addAndDequeue(){
		Deque<Integer> queue = new Deque<Integer>(3);
		Integer i1 = 1;
		Integer i2 = 2;
		Integer i3 = 3;
		
		assertEquals(0, queue.size());
		queue.addLast(i1);
		assertEquals(1, queue.size());
		queue.addFirst(i2);
		assertEquals(2, queue.size());
		queue.addLast(i3);
		assertEquals(3, queue.size());
		
		assertEquals(i2, queue.removeFirst());
		assertEquals(2, queue.size());
		assertEquals(i3, queue.removeLast());
		assertEquals(1, queue.size());
		assertEquals(i1, queue.removeFirst());
		assertEquals(0, queue.size());
	}
	
	@Test
	public void alternateEnqueueAndDequeue(){
		Deque<Integer> queue = new Deque<Integer>(3);
		Integer i1 = 1;
		Integer i2 = 2;
		Integer i3 = 3;
		
		assertEquals(0, queue.size());
		queue.addLast(i1);
		assertEquals(1, queue.size());
		queue.addFirst(i2);
		assertEquals(2, queue.size());
		queue.addLast(i3);
		assertEquals(3, queue.size());
		assertEquals(i2, queue.removeFirst());
		assertEquals(2, queue.size());
		queue.addLast(i2);
		assertEquals(3, queue.size());
		assertEquals(i2, queue.removeLast());
		assertEquals(2, queue.size());
		queue.addLast(i2);
		assertEquals(3, queue.size());
		assertEquals(i1, queue.removeFirst());
		assertEquals(2, queue.size());
		queue.addLast(i1);
		assertEquals(3, queue.size());
		assertEquals(i3, queue.removeFirst());
		assertEquals(2, queue.size());
		assertEquals(i2, queue.removeFirst());
		assertEquals(1, queue.size());
		assertEquals(i1, queue.removeFirst());
		assertEquals(0, queue.size());
	}
	
	@Test
	public void removeLastRotate(){
		Deque<Integer> queue = new Deque<Integer>(3);
		Integer i1 = 1;
		Integer i2 = 2;
		Integer i3 = 3;
		
		assertEquals(0, queue.size());
		queue.addFirst(i1);
		assertEquals(1, queue.size());
		queue.addFirst(i2);
		assertEquals(2, queue.size());
		queue.addFirst(i3);
		assertEquals(3, queue.size());
		
		queue.removeLast();
		assertEquals(2, queue.size());
		queue.removeLast();
		assertEquals(1, queue.size());
		queue.removeLast();
		assertEquals(0, queue.size());
	}
}

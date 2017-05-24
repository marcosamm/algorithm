package mamm.alg.datastructure;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

import org.testng.annotations.Test;

public class QueueTest {
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void capacityLessThanZero(){
		new Queue<Integer>(0);
	}
	
	@Test(expectedExceptions = BufferUnderflowException.class)
	public void underflowException(){
		Queue<Integer> queue = new Queue<Integer>(3);
		queue.dequeue();
	}
	
	@Test(expectedExceptions = BufferOverflowException.class)
	public void overflowException(){
		Queue<Integer> queue = new Queue<Integer>(3);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
	}
	
	@Test
	public void enqueueAndDequeue(){
		Queue<Integer> queue = new Queue<Integer>(3);
		Integer i1 = 1;
		Integer i2 = 2;
		Integer i3 = 3;
		
		assertEquals(0, queue.size());
		queue.enqueue(i1);
		assertEquals(1, queue.size());
		queue.enqueue(i2);
		assertEquals(2, queue.size());
		queue.enqueue(i3);
		assertEquals(3, queue.size());
		assertTrue(queue.isFull());
		assertEquals(i1, queue.dequeue());
		assertEquals(2, queue.size());
		assertEquals(i2, queue.dequeue());
		assertEquals(1, queue.size());
		assertEquals(i3, queue.dequeue());
		assertEquals(0, queue.size());
	}
	
	@Test
	public void alternateEnqueueAndDequeue(){
		Queue<Integer> queue = new Queue<Integer>(3);
		Integer i1 = 1;
		Integer i2 = 2;
		Integer i3 = 3;
		
		assertEquals(0, queue.size());
		queue.enqueue(i1);
		assertEquals(1, queue.size());
		queue.enqueue(i2);
		assertEquals(2, queue.size());
		queue.enqueue(i3);
		assertEquals(3, queue.size());
		assertEquals(i1, queue.dequeue());
		assertEquals(2, queue.size());
		queue.enqueue(i1);
		assertEquals(3, queue.size());
		assertEquals(i2, queue.dequeue());
		assertEquals(2, queue.size());
		queue.enqueue(i2);
		assertEquals(3, queue.size());
		assertEquals(i3, queue.dequeue());
		assertEquals(2, queue.size());
		queue.enqueue(i3);
		assertEquals(3, queue.size());
		assertEquals(i1, queue.dequeue());
		assertEquals(2, queue.size());
		assertEquals(i2, queue.dequeue());
		assertEquals(1, queue.size());
	}
}

package mamm.alg.datastructure;

import static org.testng.Assert.assertEquals;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

import org.testng.annotations.Test;

public class StackTest {
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void capacityLessThanZero(){
		new Stack<Integer>(0);
	}
	
	@Test(expectedExceptions = BufferUnderflowException.class)
	public void underflowException(){
		Stack<Integer> stack = new Stack<Integer>(3);
		stack.pop();
	}
	
	@Test(expectedExceptions = BufferOverflowException.class)
	public void overflowException(){
		Stack<Integer> stack = new Stack<Integer>(3);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
	}
	
	@Test
	public void pushAndPop(){
		Stack<Integer> stack = new Stack<Integer>(3);
		Integer i1 = 1;
		Integer i2 = 2;
		Integer i3 = 3;
		
		assertEquals(0, stack.getSize());
		stack.push(i1);
		assertEquals(1, stack.getSize());
		stack.push(i2);
		assertEquals(2, stack.getSize());
		stack.push(i3);
		assertEquals(3, stack.getSize());
		
		assertEquals(i3, stack.pop());
		assertEquals(2, stack.getSize());
		assertEquals(i2, stack.pop());
		assertEquals(1, stack.getSize());
		assertEquals(i1, stack.pop());
		assertEquals(0, stack.getSize());
	}
	
	@Test
	public void alternatePushAndPop(){
		Stack<Integer> stack = new Stack<Integer>(3);
		Integer i1 = 1;
		Integer i2 = 2;
		Integer i3 = 3;
		
		stack.push(i1);
		assertEquals(1, stack.getSize());
		stack.push(i2);
		assertEquals(2, stack.getSize());
		assertEquals(i2, stack.pop());
		assertEquals(1, stack.getSize());
		stack.push(i3);
		assertEquals(2, stack.getSize());
		assertEquals(i3, stack.pop());
		assertEquals(1, stack.getSize());
	}
}

package cz.mencik.testing.junit;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Test;

import cz.mencik.testing.Stack;

// this is a plain old JUnit test written in Java
public class JavaStackTest {

	@Test
	public void testLiFo() {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		assertEquals(2, stack.pop().intValue());
		assertEquals(1, stack.pop().intValue());
		assertTrue(stack.isEmpty());
	}

	@Test(expected = EmptyStackException.class)
	public void testEmptyStackPopThrowsException() {
		Stack<String> emptyStack = new Stack<>();
		emptyStack.pop();
	}
}

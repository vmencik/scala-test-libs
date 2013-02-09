package cz.mencik.testing;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.LinkedList;

public class Stack<T> {

	private LinkedList<T> list = new LinkedList<>();

	public void push(T item) {
		list.addLast(item);
	}

	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return list.removeLast();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public String toString() {
		return Arrays.toString(list.toArray());
	}
}

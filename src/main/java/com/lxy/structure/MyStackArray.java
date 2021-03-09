package com.lxy.structure;

import java.util.Arrays;

public class MyStackArray<T> {

	private Object[] objects;
	private int size;

	public MyStackArray() {
		objects = new Object[10];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public T peek() {
		T t = null;
		if (size > 0) {
			t = (T) objects[size - 1];
		}
		return t;
	}

	public void push(T t) {
		expandCapacity(size + 1);
		objects[size] = t;
		size++;
	}

	public T pop() {
		T t = peek();
		if (size > 0) {
			objects[size - 1] = null;
			size--;
		}
		return t;
	}

	public void expandCapacity(int size) {
		int len = objects.length;
		if (size > len) {
			size    = size * 3 / 2 + 1;
			objects = Arrays.copyOf(objects, size);
		}
	}

	public static void main(String[] args) {
		MyStackArray stack = new MyStackArray();
		stack.push("a");
		stack.push("aa");
		stack.push("aaa");
		stack.push("aaaa");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}

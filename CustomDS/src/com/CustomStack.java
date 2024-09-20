package com;

import java.util.Stack;

public class CustomStack<E> {
	private  E data [];
	private int top;
	private static final int DEF_CAPACITY = 10;
	private int capacity;
	
	public CustomStack() {
		this(DEF_CAPACITY);
		
	}
	public CustomStack(int capacity) {
		this.data = (E[]) new Object[capacity];
		this.capacity = capacity;
		top = -1;
	}
	public boolean isFull() {
		return top == capacity-1;
	}
	public boolean isEmpty() {
		return top == -1;
	}
	public E push(E item) {
		if(isFull()) {
			throw new IllegalStateException("Stack is full");
		}
		data[++top] = item;
		return item;
	}
	public E pop() {
		if(isEmpty()) {
			throw new IllegalStateException("Stack is Empty");
		}
		return data[top--];
		
	}
	public E peek() {
		if(isEmpty()) {
			throw new IllegalStateException("Stack is Empty");
		}
		return data[top];
		
	}
	public static void main(String[] args) {
		 CustomStack<String> stack = new CustomStack<String>(5);  // Create a stack of size 5
	        // Perform stack operations
//	        stack.push(10);
//	        stack.push(20);
//	        stack.push(30);
//	        stack.push(40);
//	        stack.push(50);
//	        stack.push(60);
	        stack.push("Satnam");
	        stack.push("Gurvinder");
	        stack.push("Maninder");
	        stack.push("Sukhvinder");
	        stack.push("Surjeet");
	        stack.pop();
	        stack.push("Parvinder");

	        System.out.println("Top element is: " + stack.peek());
	}
}

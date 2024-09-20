package com;

import java.util.Currency;

public class CustomSinglyLinkedList<E>{
	private Node <E> head;
	private int size;
	public CustomSinglyLinkedList() {
		size = 0;
		head = null;
	}
	public void add(E data) {
		Node<E>newNode = new Node<E>(data, null);
		if(head == null) {
			head = newNode;
			size ++;
			return;
		}
		Node<E>currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
		size++;
	}
	private void checkIndex(int index) {
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		
	}
	public void add( int index,E data) {
		checkIndex(index);
		Node<E>newNode = new Node<E>(data, null);
		if(index == 0) {
			newNode.next = head;
			head = newNode;
			size++;
			return;
		}
		Node<E>currenNode = head;
		for(int i = 0; i<index-1; i++) {
			currenNode = currenNode.next;
		}
		newNode.next = currenNode.next;
		currenNode.next = newNode;
		
	}
	public void printList() {
		Node<E>currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.data);
			currentNode = currentNode.next;
		}
	}
	public E remove(int index){
		checkIndex(index);
		if(index == 0 ) {
			E retData = head.data;
			head = head.next;
			size --;
			return retData;
		}
		Node<E>currentnode = head;
		for(int i = 0; i<index-1; i++) {
			currentnode = currentnode.next;
		}
		E retData = currentnode.next.data;
		currentnode.next = currentnode.next.next;
		size--;
		return retData;
		
	}
	public void remove(E data) {
		if(head == null) {
			throw new IllegalStateException("Linked List is empty");
		}
		if(head.data.equals(data)) {
			head = head.next;
			size --;
			return;
		}
		Node<E>currentNode = head;
		while (currentNode.next != null) {
			if(currentNode.next.data.equals(data))
			{
				currentNode.next = currentNode.next.next;
				size--;
				return;
			}
			currentNode = currentNode.next;
		}
	}
	private static class Node<E>{
		E data;
		Node <E>next;
		public Node(E data, Node<E> next) {
			super();
			this.data = data;
			this.next = next;
		}
	}
}

	

package com;

public class CustomDoublyLinkedList<E> {

	private Node <E> head;
	private int size;

	public CustomDoublyLinkedList() {
		size = 0;
		head = null;
	}
	public void add(E data) {
		Node<E>newNode = new Node<E>(data, null,null);
		if(head == null) {
			head = newNode;
			size ++;
			return;
		}
		Node<E>currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		newNode.prev = currentNode;
		currentNode.next = newNode;
		size++;
	}
	private void checkIndex(int index) {
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		
	}
	public void add( int index,E data) {
		checkIndex(index);
		Node<E>newNode = new Node<E>(data, null, null);
		if(index == 0) {
			head.prev = newNode;
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
		newNode.prev = currenNode;
		if (currenNode.next != null) {
			currenNode.next.prev = newNode;
		}
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
			head.prev = null;
			size --;
			return retData;
		}
		Node<E>currentnode = head;
		for(int i = 0; i<index-1; i++) {
			currentnode = currentnode.next;
		}
		E retData = currentnode.next.data;
		currentnode.next = currentnode.next.next;
		currentnode.next.prev = currentnode;
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
				currentNode.next.prev = currentNode;
				size--;
				return;
			}
			currentNode = currentNode.next;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static class Node<E>{
		E data;
		Node <E>next,prev;
		public Node(E data, Node<E> next,Node<E>prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}

}


package com;

import java.util.LinkedList;

public class CustomHashSetUsingNode<E> {
	private Node<E> buckets[];
	private int size;
	private static final int DEF_CAPACITY = 16;
	public CustomHashSetUsingNode() {
		this(DEF_CAPACITY);
	}
	public CustomHashSetUsingNode(int initialCapacity) {
		buckets = new Node[initialCapacity];
		size = 0;
	}
	private int getbucketIndex(E element) {
		return element == null ? 0 : Math.abs(element.hashCode()%buckets.length);
	}
	public boolean add(E element) {
		Node<E> bucket = buckets[getbucketIndex(element)];
		Node<E>newNode = new Node<E>(element, bucket);
		if(bucket == null) {
			buckets[getbucketIndex(element)] = newNode;
			size++;
			return true;
		}
		while(bucket.next != null) {
			if(bucket.next.element.equals(element)) {
				return false;
			}
		}
		bucket.next = newNode;
		return true;
	}
//	public boolean remove(E element) {
//		Node<E>bucket = buckets[getbucketIndex(element)];
//		if(bucket.element.equals(element)) {
//			size--;
//			buckets[getbucketIndex(element)] = bucket.next;
//			return true;
//		}
//		while(bucket.next !=null) {
//			if(bucket.next.element.equals(element)) {
//				bucket.next = bucket.next.next;
//				size--;
//				return true;
//			}
//			bucket = bucket.next;
//		}
//		return false;
//	}
	public boolean remove(E element) {
		Node<E>bucket = buckets[getbucketIndex(element)];
		Node<E>prev= null;
		while(bucket!=null) {
			if(bucket.element.equals(element)) {
				if(prev == null) {
					buckets[getbucketIndex(element)] = bucket.next;
				}
				else {
					prev.next = bucket.next;
				}
				return true;
			}
			prev= bucket;
			bucket = bucket.next;
		}
		return false;
	}
	private static class Node <E>{
		E element;
		Node next;
		public Node(E element, Node next) {
			this.element = element;
			this.next = next;
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

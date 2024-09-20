package com;

import java.util.HashSet;
import java.util.LinkedList;

public class CustomHashsetUsingLL<E> {
	private LinkedList<E> buckets [] ;
	private int size;
	private static final int DEF_CAPACITY = 16;
	public CustomHashsetUsingLL() {
		this(DEF_CAPACITY);
	}
	public CustomHashsetUsingLL(int initialCapacity) {
		buckets = new LinkedList[initialCapacity];
		for(int i = 0; i< initialCapacity; i++) {
			buckets[i] = new LinkedList<E>();
		}
		size = 0;
	}
	private int getbucketIndex(E element) {
		return element == null ? 0 : Math.abs(element.hashCode()%buckets.length);
	}
	public boolean add(E element) {
		LinkedList<E>bucket = buckets[getbucketIndex(element)];
		if(!bucket.contains(element)) {
			bucket.add(element);
			size++;
		}
		return false;
	}
	public boolean remove(E element) {
		LinkedList<E>bucket = buckets[getbucketIndex(element)];
		if(bucket.contains(element)) {
			bucket.remove();
			size--;
			return true;
		}
		return false;
	}
	public void printSet() {
		System.out.print("CustomHashSet: ");
		for(LinkedList<E> bucket : buckets) {
			for(E element : bucket) {
				System.out.print(element + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
	}

}

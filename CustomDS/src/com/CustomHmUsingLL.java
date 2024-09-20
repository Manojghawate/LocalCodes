package com;

import java.util.LinkedList;

public class CustomHmUsingLL<K,V> {
	private LinkedList<Entry<K, V>>buckets [] ;
	private static final int DEF_CAPACITY = 16;
	public CustomHmUsingLL() {
		this(DEF_CAPACITY);
	}
	public CustomHmUsingLL(int initialCapacity) {
		buckets = new LinkedList[DEF_CAPACITY];
		for(int i = 0; i< initialCapacity ; i++) {
			buckets[i] = new LinkedList<Entry<K,V>>();
		}
	}
	public int getBucketIndex(K key) {
		return key == null ? 0 : key.hashCode()%(buckets.length-1);
	}
	public V put(K key, V value) {
		int index = getBucketIndex(key);
		LinkedList<Entry<K, V>> bucket = buckets[index];
		for(Entry<K, V>entry:bucket) {
			if(entry.key.equals(key)) {
				V retValue = entry.value;
				entry.value = value;
				return retValue;
			}
		}
		bucket.add(new Entry<K,V>(key, value));
		return null;
	}
	public V get(K key) {
		int index = getBucketIndex(key);
		LinkedList<Entry<K, V>> bucket = buckets[index];
		for(Entry<K, V>entry:bucket) {
			if(entry.key.equals(key)) {
				return entry.value;
			}
		}
		return null;
	}
	public boolean remove(K key) {
		int index = getBucketIndex(key);
		LinkedList<Entry<K, V>> bucket = buckets[index];
		return bucket.removeIf(entry -> entry.key.equals(key));
	}
	private static class Entry<K,V>{
		K key;
		V value;
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
	}
	public static void main(String[] args) {
		CustomHmUsingLL<String, Integer> map = new CustomHmUsingLL<>();
		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);
		System.out.println("Value for 'One': " + map.get("One")); // Output: 1
		System.out.println("Value for 'Two': " + map.get("Two")); // Output: 2
		map.remove("Two");
		System.out.println("Value for 'Two' after removal: " + map.get("Two")); // Output: null

	}

}

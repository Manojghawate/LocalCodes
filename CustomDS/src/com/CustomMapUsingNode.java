package com;

public class CustomMapUsingNode<K,V> {
	private Entry<K, V>buckets [] ;
	private static final int DEF_CAPACITY = 16;

	public CustomMapUsingNode() {
		this(DEF_CAPACITY);
	}
	public CustomMapUsingNode(int initialCapacity) {
		buckets = new Entry[initialCapacity];
	}
	public int getBucketIndex(K key) {
		return key == null ? 0 : key.hashCode()%(buckets.length);
	}
	public V put(K key, V value) {
		int index = getBucketIndex(key);
		Entry<K,V>currentEntry = buckets[index];
		Entry<K, V>newEntry = new Entry<K,V>(key, value, null);
		if(currentEntry == null) {
			buckets[index] = newEntry;
			return null;
		}
		while(currentEntry.next != null) {
			if(currentEntry.key.equals(key)) {
				V retValue = currentEntry.value;
				currentEntry.value = value;
				return retValue;
			}
			currentEntry = currentEntry.next;
		}
		currentEntry.next = newEntry;
		return null;
	}
	public V get(K key) {
		int index = getBucketIndex(key);
		Entry<K,V>currentEntry = buckets[index];
		while(currentEntry != null) {
			if(currentEntry.key.equals(key)) {
				return currentEntry.value;
			}
			currentEntry = currentEntry.next;
		}
		return null;
	}
//	public boolean remove(K key) {
//		int index = getBucketIndex(key);
//		Entry<K,V>currentEntry = buckets[index];
//		if(currentEntry.key.equals(key)) {
//			 buckets[index] = currentEntry.next;
//			return true;
//		}
//		while(currentEntry.next != null) {
//			if(key.equals(currentEntry.next.key)) {
//				currentEntry.next = currentEntry.next.next;
//				return true;
//			}
//		}
//		return false;
//	}
	public boolean remove(K key) {
		int index = getBucketIndex(key);
		Entry<K,V>currentEntry = buckets[index];
		Entry<K,V>prev = null;
		while(currentEntry != null) {
			if(key.equals(currentEntry.key)) {
				if(prev ==null) {
					buckets[index] = currentEntry.next;
				}
				else {
					prev.next = currentEntry.next;
				}
				return true;
			}
			prev = currentEntry;
			currentEntry = currentEntry.next;
		}
		return false;
	}
	private static class Entry<K,V>{
		K key;
		V value;
		Entry<K, V>next;
		public Entry(K key, V value,Entry<K, V>next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

	}
	public static void main(String[] args) {
		CustomMapUsingNode<String, Integer> map = new CustomMapUsingNode<>();
		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);
		System.out.println("Value for 'One': " + map.get("One")); // Output: 1
		System.out.println("Value for 'Two': " + map.get("Two")); // Output: 2
		map.remove("Two");
		System.out.println("Value for 'Two' after removal: " + map.get("Two")); // Output: null

	}

}

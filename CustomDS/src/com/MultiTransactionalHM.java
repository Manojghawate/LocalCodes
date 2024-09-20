package com;

import java.util.HashMap;
import java.util.Stack;

public class MultiTransactionalHM <K, V> {
	private HashMap<K, V> committedMap;     // Committed data
	private Stack<HashMap<K, V>>transactions;
	public MultiTransactionalHM() {
		committedMap = new HashMap<K,V>();
		transactions = new Stack<HashMap<K,V>>();
	}
	public void begin() {
		transactions.push(new HashMap<K,V>());
	}
	public void put(K key, V value) {
		if(!transactions.isEmpty()) {
			transactions.peek().put(key, value);
		}
		else {
			committedMap.put(key, value);
		}
	}
	public V get(K key) {
		if(!transactions.isEmpty() && transactions.peek().containsKey(key)) {
			return transactions.peek().get(key);
		}
		else {
			return committedMap.get(key);
		}
	}
	public void commit() {
		if(!transactions.isEmpty()) {
			committedMap.putAll(transactions.pop());
		}else {
			throw new IllegalStateException("no transaction present to commit");
		}
	}
	public void rollBack() {
		if(!transactions.isEmpty()) {
			transactions.pop();
		}
		else {
			throw new IllegalStateException("no transaction present to commit");

		}
	}
	public static void main(String[] args) {
		 MultiTransactionalHM<String, String> map = new MultiTransactionalHM<>();
	        
	        map.put("Sachin", "Sehwagh");
	        System.out.println(map.get("Sachin")); // Prints: value1
	        
	        map.begin(); // Start transaction
	        map.put("Sachin", "Ganguly");
	        System.out.println(map.get("Sachin")); // Prints: value2 (within transaction)
	        
	        map.rollBack(); // Rollback changes
	        System.out.println(map.get("Sachin")); // Prints: value1 (after rollback)
	        
	        map.begin(); // Start new transaction
	        map.put("Sachin", "Dravid");
	        map.commit(); // Commit changes
	        System.out.println(map.get("Sachin"));

	}

}

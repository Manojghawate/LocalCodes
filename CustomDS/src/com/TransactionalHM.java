package com;

import java.util.HashMap;

public class TransactionalHM<K,V> {
	private HashMap<K, V>committedMap;
	private HashMap<K, V>tempMap;
	private boolean isTransactionPresent;
	public TransactionalHM() {
		this.committedMap = new HashMap<K,V>();
		this.isTransactionPresent = false;
	}
	public void begin() {
		if(isTransactionPresent) {
			throw new IllegalStateException("transaction is going on");
		}
		tempMap =  new HashMap<K,V>();
		isTransactionPresent = true;
	}
	public void put(K key, V value) {
		if(isTransactionPresent) {
			tempMap.put(key, value);
			return;
		}
		committedMap.put(key, value);
	}
	public V get(K key) {
		if(isTransactionPresent && tempMap.containsKey(key)) {
			return tempMap.get(key);
		}
		return committedMap.get(key);
	}
	public void commit() {
		if(!isTransactionPresent) {
			throw new IllegalStateException("Transaction not present to commit");
		}
		committedMap.putAll(tempMap);
		tempMap= null;
		isTransactionPresent = false;
	}
	public void rollBack() {
		if(!isTransactionPresent) {
			throw new IllegalStateException("Transaction not present to rollback");
		}
		tempMap=null;
		isTransactionPresent = false;
	}
	public static void main(String[] args) {
		

	}

}

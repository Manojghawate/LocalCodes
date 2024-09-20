package com;

import java.util.Arrays;
import java.util.Collection;

public class CustomArrayList <E> {
	private E[]data;
	private final static int DEF_CAPACITY = 10;
	private int size;
	public CustomArrayList() {
		this(DEF_CAPACITY);
	}
	public CustomArrayList(int initialCapacity) {
		data = (E[]) new Object[initialCapacity];
		this.size = 0;
		
	}
	private void checkCapacity(){
		if(size == data.length) {
			data = Arrays.copyOf(data, data.length*2);
		}
	}
	private void checkindex(int index){
		if(index>=size || index<0){
			throw new IllegalStateException("Invalid index passed");
		}
	}
	private void checkindexForAdd(int index){
		if(index>size || index<0){
			throw new IllegalStateException("Invalid index passed");
		}
	}
	public boolean add(E element) {
		checkCapacity();
		data[size++] = element;
		return true;
	}
	public int size() {
		return this.size;
	}
	public boolean contains(E element) {
		return Arrays.stream(data).anyMatch(e->e.equals(element));
	}
	public boolean containsAll(Collection<? extends E> elements) {
		for(E e : elements) {
			if(!contains(e))
				return false;
		}
		return true;
	}
	public boolean addAll(Collection<? extends E> elements) {
		elements.forEach(e->add(e));
		return elements.size()>0;
	}
	public boolean add(E element,int index) {
		checkCapacity();
		checkindexForAdd(index);
		for(int i = size; i>index ; i--) {
			data[i] = data[i-1];
		}
		data[index] = element;
		size++;
		return true;
	}
	
	public E get(int index) {
		checkindex(index);
		return data[index];
	}
	public E remove(int index) {
		checkindex(index);
		E retElement = data[index];
		for(int i = index; i<size-1; i++) {
			data[i] = data[i+1];
		}
		data[--size] = null;
		return retElement;
	}
	public static void main(String[] args) {
		CustomArrayList<Integer> list = new CustomArrayList<>();

        // Adding elements
        list.add(10);
        list.add(20);
        list.add(30);
        
        // Adding element at index 1
        list.add(1, 15);  // Inserts 15 at index 1
        
        // Output the list
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        
        // Removing element at index 1
        list.remove(1);
        
        // Output the list again
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
	

}

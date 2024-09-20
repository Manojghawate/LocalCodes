package com;

public class CustomQueue<E> {
	private  E data [];
	private int front;
	private int rear;
	private static final int DEF_CAPACITY = 10;
	public CustomQueue() {
		this(DEF_CAPACITY);
		
	}
	@SuppressWarnings("unchecked")
	public CustomQueue(int capacity) {
		this.data = (E[]) new Object[capacity];
		this.front = 0;
		this.rear = 0;
	}
	public void enQueue(E item) {
		if(isFull()) {
			throw new  IllegalStateException("Queue is full");
		}
		System.out.println(item + " added");
		data[rear] = item;
		rear = (rear+1)%data.length;
	}
	public E deQueue() {
		if(isEmpty()) {
			throw new  IllegalStateException("Queue is Empty");
		}
		E retItem = data[front];
		System.out.println(retItem + " removed");
		front = (front+1)%data.length;
		return retItem;
	}
	public E peek() {
		if(isEmpty()) {
			throw new  IllegalStateException("Queue is Empty");
		}
		return data[front];
		
	}
	public boolean isFull() {
		return (rear+1) % data.length == front;
	}
	public boolean isEmpty() {
		return front == rear;
	}
	public static void main(String[] args) {
		CustomQueue<String> stringQueue = new CustomQueue<>(5);

        // Perform queue operations with String type
        stringQueue.enQueue("Hello");
        stringQueue.enQueue("World");
        stringQueue.enQueue("Generics");
        stringQueue.deQueue();
        stringQueue.deQueue();
        stringQueue.enQueue("Sachin");
        stringQueue.enQueue("Sehawagh");
        stringQueue.enQueue("Saurav");
        stringQueue.enQueue("Anil");
        stringQueue.enQueue("Yuvraj");


        System.out.println("Front element is: " + stringQueue.peek());

        stringQueue.deQueue();
        stringQueue.deQueue();
        stringQueue.deQueue();
    
        System.out.println("Front element after dequeuing is: " + stringQueue.peek());


	}

}

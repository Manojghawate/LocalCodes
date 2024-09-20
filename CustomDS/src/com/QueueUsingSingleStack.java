package com;
import java.util.Stack;

class QueueUsingSingleStack {
    private Stack<Integer> stack;

    // Constructor
    public QueueUsingSingleStack() {
        stack = new Stack<>();
    }

    // Enqueue operation (push element into the stack)
    public void enqueue(int value) {
        stack.push(value);
    }

    // Dequeue operation (recursively pop to get the front element)
    public int dequeue() {
        // If stack is empty, the queue is empty
        if (stack.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        // Pop the top element from the stack
        int topElement = stack.pop();

        // If this is the last element in the stack, it's the front of the queue
        if (stack.isEmpty()) {
            return topElement;
        }
        // Recursively call dequeue to reach the front element
        int front = dequeue();

        // Push the popped element back onto the stack (to maintain the original order)
        stack.push(topElement);

        return front;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Peek the front element of the queue
    public int peek() {
        // Similar to dequeue, but without removing elements
        if (stack.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int topElement = stack.pop();
        if (stack.isEmpty()) {
            stack.push(topElement);
            return topElement;
        }

        int front = peek();
        stack.push(topElement);
        return front;
    }
    public static void main(String[] args) {
        QueueUsingSingleStack queue = new QueueUsingSingleStack();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued element: " + queue.dequeue()); // Should return 10
        System.out.println("Peek element: " + queue.peek());        // Should return 20

        queue.enqueue(40);
        System.out.println("Dequeued element: " + queue.dequeue()); // Should return 20
        System.out.println("Dequeued element: " + queue.dequeue()); // Should return 30
    
}
}




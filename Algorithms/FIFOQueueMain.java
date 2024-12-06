package Algorithms;

//Node class to represent a node in the queue
class Node {
    int data; // Data stored in the node
    Node next; // Pointer to the next node

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Queue class
class FIFOQueue {
    private Node front; // Pointer to the front of the queue
    private Node rear; // Pointer to the rear of the queue
    private int size; // Number of elements in the queue

    public FIFOQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Enqueue operation
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) { // If the queue is empty
            front = rear = newNode; // Both front and rear point to the new node
        } else {
            rear.next = newNode; // Add the new node to the end of the queue
            rear = newNode; // Update the rear pointer
        }
        size++; // Increment the size
        System.out.println(data + " enqueued to queue.");
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int data = front.data; // Get data from the front node
        front = front.next; // Move the front to the next node
        if (front == null) { // If the queue is now empty
            rear = null; // Set rear to null
        }
        size--; // Decrement the size of the queue
        return data;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data; // Return the front element without removing it
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Get the size of the queue
    public int size() {
        return size;
    }

}

public class FIFOQueueMain {
    public static void main(String[] args) {
        FIFOQueue queue = new FIFOQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Dequeued: " + queue.dequeue()); // Outputs 10
        System.out.println("Peek: " + queue.peek()); // Outputs 20
        System.out.println("Size: " + queue.size()); // Outputs 2
    }
}
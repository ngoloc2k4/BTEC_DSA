class Stack {
    private int maxSize; // Maximum size of the stack
    private int[] stackArray; // Array to hold stack elements
    private int top; // Index of the top element
    // Constructor

    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1; // Indicates that the stack is empty
    }

    // Push operation
    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("Stack Overflow: Cannot push to a full stack.");
        }
        stackArray[++top] = value; // Increment top and add the value
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow: Cannot pop from an empty stack.");
        }
        return stackArray[top--]; // Return the top value and decrement top
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty: Cannot peek.");
        }
        return stackArray[top]; // Return the top value without removing it
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return (top == -1); // Returns true if the stack is empty
    }

    // Check if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1); // Returns true if the stack is full
    }
}

public class StackDemo {
    public static void main(String[] args) {
        Stack stack = new Stack(5); // Create a stack of size 5
        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top element is: " + stack.peek()); // Outputs 30
        // Pop elements from the stack
        System.out.println("Popped: " + stack.pop()); // Outputs 30
        System.out.println("Top element after pop: " + stack.peek()); // Outputs 20
        // Check if the stack is empty
        System.out.println("Is the stack empty?" + stack.isEmpty()); // Outputs false
        // Pop all elements
        stack.pop();
        stack.pop();
        System.out.println("Is the stack empty after popping all elements? " + stack.isEmpty()); // Outputs true
    }
}

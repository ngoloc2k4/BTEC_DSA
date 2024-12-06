import java.util.EmptyStackException;

class Stack {
    private int[] stackArray; // Internal data is protected
    private int top;

    public Stack(int size) {
        stackArray = new int[size];
        top = -1;
    }

    public void push(int value) {
        if (top < stackArray.length - 1) {
            stackArray[++top] = value;
        }
    }

    public int pop() {
        if (top >= 0) {
            return stackArray[top--];
        } else {
            throw new EmptyStackException();
        }
    }
}

public void performOperations(Stack stack) {
    stack.push(1);
    stack.push(2);
    stack.pop();
}

void main(String[] args) {
    // Example usage of stack abstraction
    Stack stack = new Stack(5);
    stack.push(10);
    int item = stack.pop();

    performOperations(stack);
}

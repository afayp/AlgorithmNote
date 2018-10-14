package structure.Stack;

public class StackBaseOnArray {

    private int[] array;
    private int maxSize;
    private int top;

    public StackBaseOnArray(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[maxSize];
        this.top = -1;
    }

    public void push(int value) {
        if (top < maxSize -1) {
            array[++top] = value;
        }
    }

    public int pop() {
        return array[top--];
    }

    public int peek() {
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize-1;
    }
}

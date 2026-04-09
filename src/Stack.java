public class Stack {

    private String[] arr;
    private int top;
    private int capacity;

    public Stack(int size) {
        capacity = size;
        arr = new String[capacity];
        top = -1;
    }

    public void push(String x) {
        if (top == capacity - 1) {
            System.out.println("stack overflow");
            return;
        }
        arr[++top] = x;
    }

    public String pop() {
        if (top == -1) {
            System.out.println("stack empty");
            return null;
        }
        return arr[top--];
    }

    public String peek() {
        if (top == -1) {
            return null;
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
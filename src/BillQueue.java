public class BillQueue {

    static class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;

    public void offer(Object data) {
        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    public Object poll() {
        if (front == null) {
            return null;
        }

        Object data = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        Node current = front;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
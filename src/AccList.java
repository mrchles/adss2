public class AccList {

    static class Node {
        BankAccount data;
        Node next;

        Node(BankAccount data) {
            this.data = data;
        }
    }

    private Node head;

    public void add(BankAccount data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public BankAccount find(String username) {
        Node current = head;

        while (current != null) {
            if (current.data.getUsername().equalsIgnoreCase(username)) {
                return current.data;
            }
            current = current.next;
        }

        return null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void display() {
        Node current = head;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
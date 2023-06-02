package Hashing;

public class Node {
    private String key;
    private int data;
    private Node next;

    public Node(String key, int data) {
        this.key = key;
        this.data = data;
        this.next = null;
    }

    public String getKey() {
        return this.key;
    }
    public int getData() {
        return this.data;
    }
    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

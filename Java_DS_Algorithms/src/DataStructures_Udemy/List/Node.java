package DataStructures_Udemy.List;

public class Node {
    private int data;
    private Node next;  // It is the pointer to the next Node

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node() {
        this.next = null;
    }

    public int getData() {
        return this.data;
    }
    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

package DataStructures_Udemy.Trees;

public class QueueNode {
    private int data;
    private QueueNode next;  // It is the pointer to the next Node

    public QueueNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return this.data;
    }
    public void setData(int data) {
        this.data = data;
    }

    public QueueNode getNext() {
        return this.next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }
}

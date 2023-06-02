package DartGameProblem;

public class Queue {
    private Node first;
    private Node last;
    private int length;

    public Queue() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    public Queue(int data) {
        Node newNode = new Node(data);
        this.first = newNode;
        this.last = newNode;
        this.length = 1;
    }

    public Node getFirst() {
        return this.first;
    }
    public Node getLast() {
        return this.last;
    }
    public int getLength() {
        return this.length;
    }

    public void setFirst(Node node) {
        this.first = node;
    }
    public void setLast(Node node) {
        this.last = node;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            this.first = newNode;
        } else {
            last.setNext(newNode);
        }
        this.last = newNode;
        this.length++;
    }

    public void enqueue(Node node) {
        if (isEmpty()) {
            this.first = node;
        } else {
            last.setNext(node);
        }
        this.last = node;
        this.length++;
    }

    public Node dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node temp = this.first;
        if (this.first == this.last) {
            this.first = null;
            this.last = null;
        } else {
            this.first = first.getNext();
            temp.setNext(null);
        }
        this.length--;
        return temp;
    }


    public String toString() {
        Node temp = first;
        StringBuilder str = new StringBuilder();
        str.append("FIRST << ");
        while (temp != null) {
            str.append(temp.getData());
            str.append(" << ");
            temp = temp.getNext();
        }
        str.append("LAST");
        return str.toString();
    }
}

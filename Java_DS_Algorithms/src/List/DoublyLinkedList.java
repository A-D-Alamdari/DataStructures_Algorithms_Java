package List;

public class DoublyLinkedList {
    private DoublyNode head;
    private DoublyNode tail;
    private int length;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public DoublyLinkedList(int data) {
        DoublyNode node = new DoublyNode(data);
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    public Node getHead() {
        return this.head;
    }

    public void setHead(DoublyNode node) {
        this.head = node;
    }

    public Node getTail() {
        return this.tail;
    }

    public void setTail(DoublyNode node) {
        this.tail = node;
    }

    public int getLength() {
        return this.length;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void append(DoublyNode newNode) {
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
        }

        tail = newNode;
        length++;
    }

    public void append(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (isEmpty()) {
            head = newNode;
            tail = head;
            head.setPrevious(null);
            tail.setNext(null);
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        length++;
    }

//    public void append(DoublyNode newNode) {
//        if (isEmpty()) {
//            head = newNode;
//        } else {
//            tail.setNext(newNode);
//            newNode.setPrevious(tail);
//        }
//        tail = newNode;
//        length++;
//    }

    public void removeLast() {
        if (!isEmpty()) {
            tail = tail.getPrevious();
            if (tail != null) {
                DoublyNode previous = tail.getPrevious();
                tail.setNext(null);
                tail.setPrevious(previous);
            } else {
                head = null;
            }
            length--;
        }
    }

    public void insertFirst(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (!isEmpty()) {
            DoublyNode temp = head;
            head = newNode;
            head.setNext(temp);
            head.setPrevious(null);
        } else {
            head = newNode;
            tail = newNode;
        }
        length++;
    }

    public void insertFirst(DoublyNode newNode) {
        if (!isEmpty()) {
            DoublyNode temp = head;
            head = newNode;
            head.setPrevious(null);
            head.setNext(temp);
        } else {
            head = newNode;
            tail = newNode;
        }
        length++;
    }


    public String toString() {
        Node temp = head;
        StringBuilder str = new StringBuilder();
        str.append("NULL <-> ");
        while (temp != null) {
            str.append(temp.getData());
            str.append(" <-> ");
            temp = temp.getNext();
        }
        str.append("NULL");
        return str.toString();
    }

}

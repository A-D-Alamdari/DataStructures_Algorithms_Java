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

    /**
     * Check that the Doubly Linked List is empty or not.
     * @return: True, if the Doubly Linked List is empty, otherwise, False.
     */
    public boolean isEmpty() {
        return head == null;
    }


    /**
     * This method return the length or size of the Doubly Linked List.
     * @return: Length of the Doubly Linked List.
     */
    public int getSize() {
        if (isEmpty()) {
            return 0;
        } else {
            int count = 0;
            DoublyNode temp = head;
            while (temp != null) {
                count++;
                temp = (DoublyNode) temp.getNext();
            }
            return count;
        }
    }

    /**
     * This method append a new item to the end of a Doubly Linked List.
     * @param newNode: The Doubly Node to be added to the end of the Doubly Linked List.
     */
    public void append(DoublyNode newNode) {
        if (head == null) {     // Here we can use isEmpty() instead of (head == null)
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
        }
        tail = newNode;
        length++;
    }

    /**
     * This method create a Doubly Node with given parameter and add it to the end of the
     * Doubly Linked List
     * @param data: The value to be added to the Doubly Linked List.
     */
    public void append(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (isEmpty()) {
            head = newNode;
            tail = head;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        length++;
    }


    /**
     * This method remove the last item in a Doubly Linked List.
     */
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

    /**
     * This method insert a new value to beginning of the Doubly Linked List.
     * @param data: The value to be added to the Doubly Linked List.
     */
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

    /**
     * This method insert a new Doubly Node to beginning of the Doubly Linked List.
     * @param newNode: The Doubly Node to be added to the Doubly Linked List.
     */
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

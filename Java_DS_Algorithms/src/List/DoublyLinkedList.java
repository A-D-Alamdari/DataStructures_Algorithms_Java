package List;

public class DoublyLinkedList {
    private DoublyNode head;
    private DoublyNode tail;
    private int length;

    /**
     * Constructor to create an empty Doubly Linked List.
     */
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    /**
     * Constructor to create a Doubly Linked List with one node.
     * @param data: The value of the node.
     */
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
     * Remove and return the last element in the Doubly Linked List
     * @return : The removed item.
     */
    public DoublyNode pop() {
        if (isEmpty()) {
            return null;
        } else {
            DoublyNode temp = tail;
            if (tail == head) {
                head = null;
                tail = null;
            } else {
                tail = temp.getPrevious();
                tail.setNext(null);
                temp.setPrevious(null);
            }
            length--;
            return temp;
        }
    }


    /**
     * Another method to remove and return the last element in the Doubly Linked List
     * @return : The removed item.
     */
    public DoublyNode pop_2() {
        if (getSize() == 0) {
            return null;
        }
        DoublyNode temp = tail;
        tail = tail.getPrevious();
        tail.setNext(null);
        temp.setPrevious(null);
        length--;
        if (getSize() == 0) {
            head = null;
            tail = null;
        }
        return temp;
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


    /**
     * This method remove the first element in the Doubly Linked List
     */
    public void removeFirst() {
        if (!isEmpty()) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = (DoublyNode) head.getNext();
                head.setPrevious(null);
            }
        }
    }


    /**
     * This method remove and return the first element in the Doubly Linked List.
     * @return : The removed item.
     */
    public DoublyNode removeReturnFirst() {
        if (getSize() == 0) {
            return null;
        }
        DoublyNode temp = head;
        if (getSize() == 1) {
            head = null;
            tail = null;
        } else {
            head = (DoublyNode) temp.getNext();
            head.setPrevious(null);
        }
        length--;
        return temp;
    }


    /**
     * Get the DoublyNode at specified index.
     * @param index : Index of the node
     * @return The DoublyNode at the specified index
     */
    public DoublyNode getNodeAtIndex(int index) {
        if (index < 0 || index >= getSize()) {
            return null;
        }
        DoublyNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = (DoublyNode) temp.getNext();
        }
        return temp;
    }


    /**
     * Get the DoublyNode at specified index - MORE EFFICIENT METHOD
     * @param index : Index of the node
     * @return The DoublyNode at the specified index
     */
    public DoublyNode getNodeAtIndexEfficient(int index) {
        if (index < 0 || index >= getSize()) {
            return null;
        }
        DoublyNode temp = head;
        if (index < getSize() / 2) {
            for (int i = 0; i < index; i++) {
                temp = (DoublyNode) temp.getNext();
            }
        } else {
            temp = tail;
            for (int i = getSize() - 1; i > index; i--) {
                temp = temp.getPrevious();
            }
        }
        return temp;
    }


    /**
     * Set the value of a Node at specified index to a new value.
     * @param index : Index of the node which its value is changed.
     * @param data : The new value of the node at specified index.
     * @return true if it is done, false otherwise.
     */
    public boolean set_1(int index, int data) {
        DoublyNode temp = getNodeAtIndex(index);
        if (temp != null) {
            temp.setData(data);
            return true;
        }
        return false;
    }


    /**
     * Set the value of a Node at specified index to a new value.
     * @param index : Index of the node which its value is changed.
     * @param data : The new value of the node at specified index.
     * @return true if it is done, false otherwise.
     */
    public boolean set(int index, int data) {
        if (index < 0 || index > getSize()) {
            return false;
        }
        DoublyNode temp = getNodeAtIndex(index);
        if (temp != null) {
            temp.setData(data);
            return true;
        }
        return false;
    }


    /**
     * Insert a new element at the specified index.
     * @param index: The index where the new element will be added.
     * @param data: The value of new node.
     * @return: true if it is done, false otherwise.
     */
    public boolean insertAtIndex(int index, int data) {
        if (index < 0 || index > getSize()) {
            return false;
        }
        if (index == 0) {
            insertFirst(data);
            length++;
            return true;
        }
        if (index == getSize()) {
            append(data);
            length++;
            return true;
        }
        DoublyNode newNode = new DoublyNode(data);
        DoublyNode before = getNodeAtIndex(index - 1);
        DoublyNode after = (DoublyNode) before.getNext();
        before.setNext(newNode);
        newNode.setPrevious(before);
        newNode.setNext(after);
        after.setPrevious(newNode);
        length++;
        return true;
    }


    /**
     * Remove item from the Doubly Linked List at the specified index
     * @param index : index of the node we want to remove.
     * @return : The removed node.
     */
    public DoublyNode removeReturnFromIndex(int index) {
        if (index < 0 || index > getSize()) {
            return null;
        }
        if (index == 0) {
            length--;
            return removeReturnFirst();
        }
        if (index == getSize()) {
            length--;
            return pop();
        }
        DoublyNode temp = getNodeAtIndex(index);
        DoublyNode before = temp.getPrevious();
        DoublyNode after = (DoublyNode) temp.getNext();
        before.setNext(after);
        after.setPrevious(before);
        temp.setPrevious(null);
        temp.setNext(null);
        length--;
        return temp;
    }


    public void doubleList() {
        DoublyNode current = head;
        while (current != null) {
            DoublyNode newNode = new DoublyNode(current.getData());
            newNode.setNext(current.getNext());
            newNode.setPrevious(current);

            current.setNext(newNode);


            if (newNode.getNext() != null) {
                DoublyNode node = (DoublyNode) newNode.getNext();
                node.setPrevious(newNode);
            } else {
                tail = newNode;
            }

            current = (DoublyNode) newNode.getNext();
        }
        length *= 2;
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

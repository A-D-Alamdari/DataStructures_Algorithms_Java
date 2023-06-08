package DataStructures_Udemy.List;

public class DoublyLinkedList {
    private DoublyNode head;
    private DoublyNode tail;
    private int length;

    /**
     * Constructor to create an empty Doubly Linked DataStructures_Udemy.List.
     */
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    /**
     * Constructor to create a Doubly Linked DataStructures_Udemy.List with one node.
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
     * Check that the Doubly Linked DataStructures_Udemy.List is empty or not.
     * @return: True, if the Doubly Linked DataStructures_Udemy.List is empty, otherwise, False.
     */
    public boolean isEmpty() {
        return head == null;
    }


    /**
     * This method return the length or size of the Doubly Linked DataStructures_Udemy.List.
     * @return: Length of the Doubly Linked DataStructures_Udemy.List.
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
     * This method append a new item to the end of a Doubly Linked DataStructures_Udemy.List.
     * @param newNode: The Doubly Node to be added to the end of the Doubly Linked DataStructures_Udemy.List.
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
     * Doubly Linked DataStructures_Udemy.List
     * @param data: The value to be added to the Doubly Linked DataStructures_Udemy.List.
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
     * This method remove the last item in a Doubly Linked DataStructures_Udemy.List.
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
     * Remove and return the last element in the Doubly Linked DataStructures_Udemy.List
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
     * Another method to remove and return the last element in the Doubly Linked DataStructures_Udemy.List
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
     * This method insert a new value to beginning of the Doubly Linked DataStructures_Udemy.List.
     * @param data: The value to be added to the Doubly Linked DataStructures_Udemy.List.
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
     * This method insert a new Doubly Node to beginning of the Doubly Linked DataStructures_Udemy.List.
     * @param newNode: The Doubly Node to be added to the Doubly Linked DataStructures_Udemy.List.
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
     * This method remove the first element in the Doubly Linked DataStructures_Udemy.List
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
     * This method remove and return the first element in the Doubly Linked DataStructures_Udemy.List.
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
     * Remove item from the Doubly Linked DataStructures_Udemy.List at the specified index
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


    /**
     * This method uses Bubble Sort algorithm to make a Doubly Linked DataStructures_Udemy.List sorted.
     */
    public void bubbleSortDLL() {
        if (isEmpty() || getSize() == 1) {
            return; // Empty or single-element list, no need to sort
        }

        boolean swapped;
        do {
            swapped = false;
            DoublyNode current = head;
            while (current != null && current.getNext() != null) {
                if (current.getData() > current.getNext().getData()) {
                    // Swap the nodes
                    DoublyNode nextNode = (DoublyNode) current.getNext();
                    DoublyNode prevNode = current.getPrevious();
                    DoublyNode afterNextNode = (DoublyNode) nextNode.getNext();

                    if (prevNode != null) {
                        prevNode.setNext(nextNode);
                    } else {
                        head = nextNode;
                    }

                    nextNode.setPrevious(prevNode);
                    nextNode.setNext(current);
                    current.setPrevious(nextNode);
                    current.setNext(afterNextNode);

                    if (afterNextNode != null) {
                        afterNextNode.setPrevious(current);
                    } else {
                        tail = current;
                    }

                    swapped = true;
                } else {
                    current = (DoublyNode) current.getNext();
                }
            }
        } while (swapped);
    }


    /**
     * This method uses Merge Sort algorithm to make a Doubly Linked DataStructures_Udemy.List sorted.
     */
    public void mergeSortDLL() {
        head = mergeSort(head);
    }

    private DoublyNode mergeSort(DoublyNode head) {
        if (head == null || head.getNext() == null) {
            return head; // Base case: Empty list or single node
        }

        DoublyNode middle = getMiddleNode(head);
        DoublyNode nextOfMiddle = (DoublyNode) middle.getNext();

        middle.setNext(null);
        nextOfMiddle.setPrevious(null);

        DoublyNode left = mergeSort(head);
        DoublyNode right = mergeSort(nextOfMiddle);

        return merge(left, right);
    }

    /**
     * Helper Method
     * @param left
     * @param right
     * @return
     */
    private DoublyNode merge(DoublyNode left, DoublyNode right) {
        DoublyNode sorted = null;

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (left.getData() <= right.getData()) {
            sorted = left;
            sorted.setNext(merge((DoublyNode) left.getNext(), right));
            if (sorted.getNext() != null) {
                DoublyNode sortedNext = (DoublyNode) sorted.getNext();
                sortedNext.setPrevious(sorted);
            }
            sorted.setPrevious(null);
        } else {
            sorted = right;
            sorted.setNext(merge(left, (DoublyNode) right.getNext()));
            if (sorted.getNext() != null) {
                DoublyNode sortedNext = (DoublyNode) sorted.getNext();
                sortedNext.setPrevious(sorted);
            }
            sorted.setPrevious(null);
        }

        DoublyNode temp = sorted;
        while (temp.getNext() != null) {
            temp = (DoublyNode) temp.getNext();
        }
        tail = temp;

        return sorted;
    }

    /**
     * Helper Method
     * @param head
     * @return
     */
    private DoublyNode getMiddleNode(DoublyNode head) {
        if (head == null) {
            return head;
        }

        DoublyNode slow = head;
        DoublyNode fast = head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = (DoublyNode) slow.getNext();
            fast = (DoublyNode) fast.getNext().getNext();
        }

        return slow;
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

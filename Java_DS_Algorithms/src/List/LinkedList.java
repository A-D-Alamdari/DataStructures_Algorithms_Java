package List;

public class LinkedList {
    private Node head;  // Pointer to the first Node in the data structure
    private Node tail;  // Pointer to the last Node in the data structure
    private int length; // Length of Linked List

    /**
     * Constructor to create a new EMPTY Linked List
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    /**
     * Constructor to create a new Lined List with initial Node as Node(data)
     * @param data  : The data inside the first Node in Linked List
     */
    public LinkedList(int data) {
        Node node = new Node(data);
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    public Node getHead() {
        if (head == null) {
            return null;
        } else {
            return this.head;
        }
    }

    public Node getTail() {
        return this.tail;
    }

    public int getLength() {
        return this.length;
    }

    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Append method here, create a new Node by provided data as parameter, and
     * append newly created Node to the end of the LinkedList.
     * @param data : Data of the new Node
     */
    public void append(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        length++;
    }

    /**
     * Append method here, add a new Node by provided as parameter, and
     * append new Node to the end of the LinkedList.
     * @param newNode : New Node to be appended to the end of the Linked List.
     */
    public void append(Node newNode) {
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        length++;
    }

    /**
     * Insert method here, create a new Node by provided data as parameter, and
     * insert newly created Node to the beginning of the LinkedList.
     * @param data : Data of the new Node
     */
    public void insertFirst(int data) {
        Node newNode = new Node(data);
        if (!isEmpty()) {
            Node temp = head;
            head = newNode;
            head.setNext(temp);
        } else {
            head = newNode;
            tail = newNode;
        }
        length++;
    }

    /**
     * Insert method here, add a new Node by provided as parameter, and
     * insert new Node to the beginning of the LinkedList.
     * @param newNode : New Node to be inserted to the beginning of the Linked List.
     */
    public void insertFirst(Node newNode) {
        if (!isEmpty()) {
            Node temp = head;
            head = newNode;
            head.setNext(temp);
        } else {
            head = newNode;
        }
        length++;
    }

    /**
     * Another insert method, which is used the length of the Linked List not the isEmpty() method.
     * @param data : The data to be added to the Linked List at index 0.
     */
    public void prepend(int data) {
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(tail);
            head = newNode;
        }
        length++;
    }

    /**
     * This method insert a new Node, with specified value, at the particular index.
     * @param index : The index where the new Node will be added.
     * @param data : The value of the new Node which will be added to a Linked List at specified index.
     */
    public void insertAtIndex(int index, int data) {
        Node temp = getNodeAtIndex(index);
        if (temp != null) {
            if (index != 0) {
                Node previous = getPrevious(temp);
                Node newNode = new Node(data);
                previous.setNext(newNode);
                newNode.setNext(temp);
                length++;
            } else {
                insertFirst(data);
            }
        } else {
            if (index == length) {
                append(data);
            }
        }
    }

    /**
     * Another method to insert a new Node, with specified value, at the particular index.
     * @param index : The index where the new Node will be added.
     * @param data : The value of the new Node which will be added to a Linked List at specified index.
     * @return : True if the new data inserted, False if the data cannot be inserted at the specified index.
     */
    public boolean insertAtIndex_2(int index, int data) {
        if (index < 0 || index > getSize()) {
            return false;
        } else if (index == 0) {
            insertFirst(data);
            return true;
        } else if (index == getSize()) {
            append(data);
            return true;
        } else {
            Node newNode = new Node(data);
            Node temp = getNodeAtIndex(index - 1);
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
            return true;
        }

    }

    /**
     * It returns the Node's previous Node in a Linked List.
     * @param node : The Node which we want to get its previous Node.
     * @return : Previous Node of the specified Node.
     */
    public Node getPrevious(Node node) {
        Node temp = head;
        Node previous = null;
        while (temp != node) {
            previous = temp;
            temp = temp.getNext();
        }
        return previous;
    }

    /**
     * This function removes the last item inside a Linked List.
     */
    public void removeLast() {
        if (!isEmpty()) {
            tail = getPrevious(tail);
            if (tail != null) {
                tail.setNext(null);
            } else {
                head = null;
            }
            length--;
        }
    }

    /**
     * This function removes the last item inside a Linked List and return it.
     * This is the same as the pop() method.
     * @return : The removed last item in the Linked List
     */
    public Node removeReturnLast() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        Node previous = head;
        while (temp.getNext() != null) {
            previous = temp;
            temp = temp.getNext();
        }
        tail = previous;
        tail.setNext(null);
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    /**
     * It removes the last item in a Linked List and return it.
     * @return : The removed last item.
     */
    public Node pop() {
        if (!isEmpty()) {
            Node temp = tail;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = getPrevious(tail);
                tail.setNext(null);
            }
            length--;
            return temp;
        }
        return null;
    }

    /**
     * This function remove the first item inside a Linked List.
     */
    public void removeFirst() {
        if (!isEmpty()) {
            Node temp = head.getNext();
            if (head != tail) {
                head = temp;
            } else {
                head = null;
                tail = null;
            }
            length--;
        }
    }

    /**
     * The function which is remove the first item from a Linked List and return it.
     * @return temp: The first item which is removed from the Linked List
     */
    public Node removeReturnFirst() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        head = head.getNext();
        temp.setNext(null);
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    /**
     * This method returns the index of a Node which its value is specified.
     * @param data : The value which we want to get its index.
     * @return index : The index of the first occurrence of the data inside the Linked List.
     */
    public int getIndexOfNode(int data) {
        if (!isEmpty()) {
            int index = 0;
            Node temp = head;
            if (head != tail) {
                while (temp.getData() != data) {
                    temp = temp.getNext();
                    index++;
                }
                return index;
            }
            return index;
        }
        return -1;
    }

    /**
     * This method return the length or size of the Linked List.
     * @return Size/length of the Linked List
     */
    public int getSize() {
        if (isEmpty()) {
            return 0;
        } else {
            if (head == tail) {
                return 1;
            } else {
                int count = 0;
                Node temp = head;
                while (temp != null) {
                    temp = temp.getNext();
                    count++;
                }
                return count;
            }
        }
    }

    /**
     * This method returns the Node at the specified index.
     * @param index : The index of a Node which we want to return.
     * @return Node : The node at the specified index.
     */
    public Node getNodeAtIndex(int index) {
        if (index < 0 || index >= length) {
            return null;
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
            return temp;
        }
    }

    /**
     * This method remove the element of the Linked List at the specified index.
     * @param index : The index of the element that we want to remove.
     */
    public void removeFromIndex(int index) {
        if (index >= 0 && index < length) {
            if (index == 0) {
                Node temp = head.getNext();
                Node tempNext = temp.getNext();
                head = temp;
                temp.setNext(tempNext);
            } else {
                Node temp = getNodeAtIndex(index);
                Node previous = getPrevious(temp);
                previous.setNext(temp.getNext());
            }
            length--;
        }
    }

    /**
     * This is another method to remove the element of the Linked List at the specified index.
     * @param index : The index of the element that we want to remove.
     * @return : The Node at specified index which is removed from the Linked List.
     */
    public Node removeFromIndex_2(int index) {
        if (index < 0 || index >= getSize()) {
            return null;
        }
        if (index == 0) {
            return removeReturnFirst();
        }
        if (index == getSize() - 1) {
            return removeReturnLast();
        }

        Node prev = getNodeAtIndex(index - 1);
        Node temp = prev.getNext();

        prev.setNext(temp.getNext());
        temp.setNext(null);
        length--;
        return temp;
    }

    /**
     * Set data of a Node at particular index as specified value
     * @param index : index, where the Node's value will be changed
     * @param data : The value which will be inserted as a value of Node.
     * @return : it returns boolean value if it can add return true, else false.
     */
    public boolean setDataOfIndex(int index, int data) {
        Node temp = getNodeAtIndex(index);
        if (temp != null) {
            temp.setData(data);
            return true;
        } else {
            return false;
        }
    }


    /**
     * This method reverse the Linked List in place.
     */
    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.getNext();
            temp.setNext(before);
            before = temp;
            temp = after;
        }
    }

    /**
     * This method return the smallest value inside the Linked List.
     * @return : The smallest data in the Linked List.
     */
    public int smallest() {
        int min;
        Node temp = head;
        min = temp.getData();
        while (temp != null) {
            if (temp.getData() < min) {
                min = temp.getData();
            }
            temp = temp.getNext();
        }
        return min;
    }

    /**
     * This method return the largest value inside the Linked List.
     * @return : The largest data in the Linked List.
     */
    public int largest() {
        int max;
        Node temp;
        temp = head;
        max = temp.getData();
        while (temp != null) {
            if (temp.getData() > max) {
                max = temp.getData();
            }
            temp = temp.getNext();
        }
        return max;
    }


    /**
     * This method delete the second element in the Linked List
     */
    public void deleteSecond() {
        if (head.getNext() != null) {
            Node temp = head.getNext();
            Node tempN = temp.getNext();
            temp.setNext(null);
            head.setNext(tempN);
        }
    }

    /**
     * This method delete the second element in the Linked List and return it.
     * @return : The second element in the Linked List.
     */
    public Node deleteReturnSecond() {
        if (head.getNext() != null) {
            Node temp = head.getNext();
            Node tempN = temp.getNext();
            temp.setNext(null);
            head.setNext(tempN);
            return temp;
        }
        return null;
    }


    /**
     * Write a function that will delete the odd indexed elements from a singly
     * linked list. The function will also return the deleted nodes as a new linked list.
     * @return : The deleted nodes as a new linked list
     */
    public LinkedList oddIndexedElements() {
        LinkedList deleted = new LinkedList();
        if (isEmpty()) {
            return deleted;
        }
        if (head == tail || getSize() == 2) {
            tail.setNext(null);
            deleted.append(tail);
            this.head = tail;
        } else {
            for (int i = 1; i < getSize(); i = i + 2) {
                Node temp = getNodeAtIndex(i);
                if (i == 1) {
                    deleted.insertFirst(temp);
                    removeFromIndex(1);
                } else {
                    deleted.append(temp);
                    this.removeFromIndex(i);
                }
            }
        }
        return deleted;
    }

    public String toString() {
        Node temp = head;
        StringBuilder str = new StringBuilder();
        while (temp != null) {
            str.append(temp.getData());
            str.append(" -> ");
            temp = temp.getNext();
        }
        str.append("NULL");
        return str.toString();
    }
}

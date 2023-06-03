package List;

public class Queue {
    private Node first;
    private Node last;
    private int length;


    /**
     * Constructor to create an empty Queue.
     */
    public Queue() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }


    /**
     * Constructor to create a Queue with initial node with specified data value.
     * @param data : The value of the node.
     */
    public Queue(int data) {
        Node newNode = new Node(data);
        this.first = newNode;
        this.last = newNode;
        this.length = 1;
    }


    // Getter Methods
    public Node getFirst() {
        return this.first;
    }
    public Node getLast() {
        return this.last;
    }
    public int getLength() {
        return this.length;
    }

    // Setter Methods
    public void setFirst(Node node) {
        this.first = node;
    }
    public void setLast(Node node) {
        this.last = node;
    }


    /**
     * Check that the Queue is empty or not.
     * @return true if it is empty, false otherwise.
     */
    public boolean isEmpty() {
        return this.first == null;
    }


    /**
     * Enqueue or add a new item in a Queue.
     * @param data : The data value of the item to be added to the Queue.
     */
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {            // You can use length == 0 or size() == 0 as a condition for if statement
            this.first = newNode;
        } else {
            last.setNext(newNode);
        }
        this.last = newNode;
        this.length++;
    }


    /**
     * Enqueue or add a new item in a Queue.
     * @param node : The node to be added to the Queue
     */
    public void enqueue(Node node) {
        if (isEmpty()) {            // You can use length == 0 or size() == 0 as a condition for if statement
            this.first = node;
        } else {
            last.setNext(node);
        }
        this.last = node;
        this.length++;
    }


    /**
     * Dequeue or remove and return the item from the Queue.
     * @return : The node which is removed and returned.
     */
    public Node dequeue() {
        if (isEmpty()) {                    // You can use length == 0 or size() == 0 as a condition for if statement
            return null;
        }
        Node temp = this.first;
        if (this.first == this.last) {      // You can use length == 1 or size() == 1 as a condition for if statement
            this.first = null;
            this.last = null;
        } else {
            this.first = first.getNext();
            temp.setNext(null);
        }
        this.length--;
        return temp;
    }


    /**
     * Write a function that moves the element currently at the front of the
     * queue to the rear of the queue. Write the function for both array and
     * linked list implementations.
     */
    public void moveToRear() {
        Node temp = dequeue();
        enqueue(temp);
    }


    /**
     * Write a function that returns the maximum element in a queue. You are
     * only allowed to use enqueue, dequeue, isEmpty functions. The queue
     * must contain the same elements in the same order after the execution
     * of this function.
     */
    public int largest() {
        int max;
        Node tempN;
        Queue tempQ = new Queue();
        tempN = dequeue();
        tempQ.enqueue(tempN);
        max = tempN.getData();
        while (!isEmpty()) {
            tempN = dequeue();
            tempQ.enqueue(tempN);
            if (tempN.getData() > max) {
                max = tempN.getData();
            }
        }
        while (!tempQ.isEmpty()) {
            tempN = tempQ.dequeue();
            enqueue(tempN);
        }
        return max;
    }


    /**
     * For linked list implementation, write a function that moves the element
     * currently at the rear of the queue to the front of the queue.
     */
    public void moveToFront() {
        if (!isEmpty() || first != last) {
            Node temp = first;
            while (temp != last) {
                temp = temp.getNext();
            }
            temp.setNext(null);
            last.setNext(first);
            first = last;
            last = temp;
        }
    }


    /**
     * Write a function that adds a new element after the front element of the
     * queue. Write the function for both array and linked list implementations.
     */
    public void insertSecond(int data) {
        Node newNode = new Node(data);
        Node temp = first.getNext();
        first.setNext(newNode);
        newNode.setNext(temp);
    }

    /**
     * Write a function that adds a new element after the front element of the
     * queue. Write the function for both array and linked list implementations.
     */
    public void insertSecond(Node node) {
        Node temp = first.getNext();
        first.setNext(node);
        node.setNext(temp);
    }


    /**
     * Write a function that adds a new element after the K’th (K ! 0)
     * element of the queue. Write the function for both array and linked
     * list implementations. You can safely assume that, there are at least K
     * elements in the queue.
     */
    public void insertAfterKth(int k, int data) {
        Node newNode = new Node(data);
        Node temp = first;
        int count = 0;
        while (count != k) {
            temp = temp.getNext();
            count++;
        }
        Node tempNext = temp.getNext();
        temp.setNext(newNode);
        newNode.setNext(tempNext);
    }

    /**
     * Write a function that adds a new element after the K’th (K ! 0)
     * element of the queue. Write the function for both array and linked
     * list implementations. You can safely assume that, there are at least K
     * elements in the queue.
     */
    public void insertAfterKth(int k, Node node) {
        Node temp = first;
        int count = 0;
        while (count != k) {
            temp = temp.getNext();
            count++;
        }
        Node tempNext = temp.getNext();
        temp.setNext(node);
        node.setNext(tempNext);
    }


    /**
     * Write a function that deletes the element in the K’th (K ! 0) position
     * of the queue.
     */
    public void deleteKth(int k) {
        Node temp = first;
        int count = 0;
        if (k == 0) {
            dequeue();
        } else {
            if (k < size()) {
                while (count != (k - 1)) {
                    temp = temp.getNext();
                    count++;
                }
                Node tempNext = temp.getNext();
                Node tempNextNext = tempNext.getNext();
                temp.setNext(tempNextNext);
            }
        }
    }


    /**
     * This function returns the size of the Queue.
     * @return size of the Queue.
     */
    public int size() {
        int size = 0;
        Node temp = first;
        while (temp != null) {
            temp = temp.getNext();
            size++;
        }
        return size;
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

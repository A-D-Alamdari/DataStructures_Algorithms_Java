package List;

public class Stack {
    private Node top;
    private int height;


    /**
     * Constructor to create an empty Stack.
     */
    public Stack() {
        this.top = null;
        this.height = 0;
    }


    /**
     * Constructor to create a Stack with one item.
     * @param data: The value of the first Node in the Stack.
     */
    public Stack(int data) {
        Node newNode = new Node(data);
        this.top = newNode;
        height = 1;
    }


    public int getHeight() {
        return this.height;
    }


    /**
     * This method return the length or size of the Stack.
     * @return count: The number of elements inside the Stack.
     */
    public int getSize() {
        int count = 0;
        Node temp = top;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }


    /**
     * This method is to show the toppest item in a Stack
     * @return : The top item in a Stack
     */
    public Node peek() {
        return this.top;
    }


    /**
     * Check the Stack is empty or not
     * @return : true if it is empty, false otherwise.
     */
    public boolean isEmpty() {
        return this.top == null;
    }


    /**
     * Add a new item to the top of the Stack
     * @param data : The data value to be added into the Stack.
     */
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.setNext(top);
        top = newNode;
        height++;
    }


    /**
     * Another method to add a new item to the top of the Stack
     * @param data : The data value to be added into the Stack.
     */
    public void push_2(int data) {
        Node newNode = new Node(data);
        if (getSize() != 0) {
            newNode.setNext(top);
        }
        top = newNode;
        height++;
    }


    /**
     * Add a new Node to the top of the Stack.
     * @param node : The node to be added.
     */
    public void push(Node node) {
        node.setNext(top);
        top = node;
        height++;
    }


    /**
     * Remove and return the top item of the Stack.
     * @return : The top (recently added) node of the Stack.
     */
    public Node pop() {
        if (top != null) {
            Node temp = top;
            top = temp.getNext();
            height--;
            return temp;
        } else {
            return null;
        }
    }



    public String toString() {
        Node temp = top;
        StringBuilder str = new StringBuilder();
        str.append("TOP: ");
        while (temp != null) {
            str.append(temp.getData());
            str.append(" << ");
            temp = temp.getNext();
        }
        str.append("BOTTOM");
        return str.toString();
    }
}

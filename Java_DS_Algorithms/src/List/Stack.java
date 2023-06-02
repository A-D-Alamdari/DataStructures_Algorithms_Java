package List;

public class Stack {
    private Node top;
    private int height;

    public Stack() {
        this.top = null;
        this.height = 0;
    }

    public int getHeight() {
        return this.height;
    }

    public Node peek() {
        return this.top;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.setNext(top);
        top = newNode;
        height++;
    }
    public void push(Node node) {
        node.setNext(top);
        top = node;
        height++;
    }

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

    public void doubleStack() {
        Stack newStack = new Stack();
        while (!isEmpty()) {
            Node temp = pop();
            newStack.push(temp);
            newStack.push(temp);
        }
        System.out.println(newStack.toString());
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

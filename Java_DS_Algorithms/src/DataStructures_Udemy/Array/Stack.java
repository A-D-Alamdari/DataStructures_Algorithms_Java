package DataStructures_Udemy.Array;

public class Stack {
    private Element[] array;
    private int top;
    private int N;

    public Stack(int N) {
        this.N = N;
        array = new Element[N];
        this.top = -1;
    }

    public boolean isFull() {
        return top == N - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public Element peek() {
        return array[top];
    }

    public void push(Element element) {
        if (!isFull()) {
            top++;
            array[top] = element;
        }
    }

    public void push(int data) {
        Element element = new Element(data);
        if (!isFull()) {
            top++;
            array[top] = element;
        }
    }

    public Element pop() {
        if (!isEmpty()) {
            top--;
            return array[top + 1];
        } else {
            return null;
        }
    }

    public String toSting() {
        Element temp;
        StringBuilder str = new StringBuilder();
        str.append("TOP: ");
        for (int i = top; i >= 0; i--) {
            temp = array[i];
            str.append(temp.getData());
            str.append(" << ");

        }
        str.append("BOTTOM");
        return str.toString();

    }
}

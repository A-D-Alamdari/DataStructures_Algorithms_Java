package DataStructures_Udemy.List;

public class DoublyNode extends Node {
    private DoublyNode previous;

    public DoublyNode(int data) {
        super(data);
        previous = null;
    }

    public void setPrevious(DoublyNode previous) {
        this.previous = previous;
    }

    public DoublyNode getPrevious() {
        return this.previous;
    }
}

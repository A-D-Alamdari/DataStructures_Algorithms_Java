package Array;

public class Queue {
    private Element array[];
    private int first;
    private int last;
    private int N;

    public Queue(int N) {
        this.array = new Element[N];
        this.N = N;
        this.first = 0;
        this.last = 0;
    }

    public int getFirst() {
        return this.first;
    }
    public int getLast() {
        return this.last;
    }
    public int getN() {
        return this.N;
    }

    public void setFirst(int first) {
        this.first = first;
    }
    public void setLast() {
        this.last = last;
    }

    public boolean isFull() {
        if (this.first == (this.last + 1) % N) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (this.last == this.first) {
            return true;
        } else {
            return false;
        }
    }

    public void enqueue(int data) {
        Element element = new Element(data);
        if (!isFull()) {
            array[last] = element;
            last = (last + 1) % N;
        }
    }

    public Element dequeue() {
        Element result;
        if (!isEmpty()) {
            result = array[first];
            first = (first + 1) % N;
            return result;
        }
        return null;
    }

    /**
     * A function that moves the element currently at the rear of the
     * queue to the front of the queue.
     */
    public void bringFront() {
        first = (first - 1) % N;
        last = (last - 1) % N;
        array[first] = array[last];
    }


}

package Array;

/**
 * Describe how to implement the queue data structure using one stack.
 * Modify enqueue and dequeue operations to work on the new data structure.
 */
public class QueueByStack {
    Stack stack;
    int N;

    public QueueByStack(int N) {
        stack = new Stack(N);
    }

    /**
     * The function that adds a new element to the queue, according to the
     * modified queue definition, is given below. Since both queue and stack
     * data structures are rear-in data structures, in order to add a new element
     * to the modified queue, we only need to add the new element to
     * the stack belonging to the modified queue.
     */
    public void enqueue(Element element) {
        if (!stack.isFull()) {
            stack.push(element);
        }
    }

    public void enqueue(int data) {
        if (!stack.isFull()) {
            stack.push(data);
        }
    }

    /**
     * The function that removes one element from the queue, according to
     * the modified queue definition, is given below. The queue is a head out
     * but the stack is a rear out type data structure. In order to remove one
     * element from the new queue definition, we need to remove one element
     * from the stack belonging to the queue. In order to remove one element
     * from the stack, first all elements in the stack must be removed from the
     * stack and moved to a temporary stack, then again removed
     * from the temporary stack and moved to the original stack back.
     * The last element that is moved in the first phase is the element
     * we want to delete.
     */
    public Element dequeue() {
        Element element;
        Element result;
        Stack tempStack;
        if (!stack.isEmpty()) {
            tempStack = new Stack(N);
            while ((!stack.isEmpty())) {
                element = stack.pop();
                tempStack.push(element);
            }
            result = tempStack.pop();
            while (!tempStack.isEmpty()) {
                element = tempStack.pop();
                stack.push(element);
            }
            return result;
        }
        return null;
    }


}



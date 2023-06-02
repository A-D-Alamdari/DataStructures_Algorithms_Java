package Array;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(12);

        queue.enqueue(15);
        System.out.println(queue.getLast());
    }
}

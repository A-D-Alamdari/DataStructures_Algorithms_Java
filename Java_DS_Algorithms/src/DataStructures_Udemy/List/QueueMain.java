package DataStructures_Udemy.List;

public class QueueMain {
    public static void main(String[] args) {
        Queue myQ = new Queue(10);

        myQ.enqueue(20);
        myQ.enqueue(30);
        myQ.enqueue(new Node(40));

        System.out.println(myQ.size());
        System.out.println(myQ);

        System.out.println(myQ.dequeue().getData());
        System.out.println(myQ.size());
        System.out.println(myQ);

    }
}

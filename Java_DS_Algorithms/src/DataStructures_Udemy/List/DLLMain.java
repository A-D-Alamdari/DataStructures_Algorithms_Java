package DataStructures_Udemy.List;

public class DLLMain {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList(0);
        dll.append(10);

        dll.append(40);
        dll.append(400);
        dll.append(50);

        dll.append(480);
        dll.append(4800);
        dll.append(489);
        dll.append(4809);
        dll.append(450);
        dll.append(180);

        dll.append(100);
        dll.append(-10);
        dll.append(-20);

        dll.append(-50);
        System.out.println(dll.getSize());

        System.out.println(dll);
//        dll.bubbleSortDLL();
        System.out.println(dll);
        dll.mergeSortDLL();
        System.out.println(dll);

    }
}

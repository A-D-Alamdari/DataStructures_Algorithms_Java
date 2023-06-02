package List;

public class DLLMain {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList(0);
        dll.append(10);
        dll.append(20);
        dll.append(30);
        dll.append(40);
        System.out.println(dll.getSize());
        System.out.println(dll);
    }
}

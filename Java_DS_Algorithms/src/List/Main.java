package List;

public class Main {
    public static void main(String[] args) {
        LinkedList myLL = new LinkedList(10);
        myLL.append(20);
        myLL.append(30);
        myLL.append(40);

        System.out.println(myLL);
        myLL.insertAtIndex(4, 100);
        System.out.println(myLL.getSize());
        System.out.println(myLL.getLength());
        System.out.println(myLL);

    }
}

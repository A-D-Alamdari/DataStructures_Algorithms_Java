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
        myLL.insertAtIndex_2(0, -10);
        System.out.println(myLL);
        myLL.insertAtIndex_2(12, -20);
        System.out.println(myLL);
        myLL.insertAtIndex_2(6, 420);

        System.out.println(myLL.getSize());
        System.out.println(myLL);
        myLL.insertBeforeLast(new Node(333));


        System.out.println(myLL);
        myLL.AddToSortedList(421);
        myLL.move(new Node(-11), 4);
        System.out.println(myLL);
        myLL.deleteAll(100);
        System.out.println(myLL);
        System.out.println();

        LinkedList ll = new LinkedList(10);
        ll.append(20);
        ll.append(0);
        ll.append(11);
        ll.append(-14);
        ll.append(-6);
        ll.append(100);
        ll.append(66);

        System.out.println(ll);
        System.out.println();
        ll.descendingSort();
        System.out.println(ll);



    }

    public static LinkedList intersection(LinkedList l1, LinkedList l2) {
        LinkedList result = new LinkedList();
        Node curr1 = l1.getHead();
        Node curr2 = l2.getHead();

        while (curr1 != null && curr2 != null) {
            if (curr1.getData() == curr2.getData()) {
                result.append(curr1.getData());
                curr1 = curr1.getNext();
                curr2 = curr2.getNext();
            } else if (curr1.getData() < curr2.getData()) {
                curr1 = curr1.getNext();
            } else {
                curr2 = curr2.getNext();
            }
        }

        return result;
    }
}

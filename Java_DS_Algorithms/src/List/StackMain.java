package List;

public class StackMain {
    public static void main(String[] args) {
        Stack myS = new Stack();

        myS.push(10);
        myS.push(20);
        myS.push(30);

        System.out.println(myS.getSize());
    }
}

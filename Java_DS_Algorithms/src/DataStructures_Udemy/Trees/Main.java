package DataStructures_Udemy.Trees;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree myBST = new BinarySearchTree(47);

        myBST.insert(21);
        myBST.insert(27);
        myBST.insert(76);
        myBST.insert(52);
        myBST.insert(18);
        myBST.insert(82);
        myBST.insert(0);
        myBST.insert(100);



        myBST.prettyPrint();
        System.out.println();
        myBST.printSorted(myBST.getRoot());

    }
}

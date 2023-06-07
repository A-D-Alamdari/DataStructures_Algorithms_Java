package Tree_YT_GreatLearning;

import java.util.Scanner;

public class TreeDemo {

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    TreeNode root;

    public TreeDemo() {
        this.root = null;
    }

    public TreeNode insert(TreeNode root, int newData) {
        if (root == null) {
            root = new TreeNode(newData);
            return root;
        }
        if (root.data > newData) {
            root.left = insert(root.left, newData);
        } else if (root.data < newData) {
            root.right = insert(root.right, newData);
        }
        return root;
    }

    public TreeNode search(TreeNode root, int newData) {
        if (root == null || root.data == newData) {
            return root;
        }
        if (root.data > newData) {
            return search(root.left, newData);
        }
        return search(root.right, newData);
    }

    public void insertIntoTree(int newData) {
        root = insert(root, newData);
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public TreeNode searchTree(int newData) {
        return search(root, newData);
    }

    public void inOrderTraversal() {
        inOrder(root);
    }


    public static void main(String[] args) {
        TreeDemo bst = new TreeDemo();
        int n;
        int num;

        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();

        System.out.println("Enter " + n + " numbers: ");

        for (int i = 0; i < n; i++) {
            num = scan.nextInt();
            bst.insertIntoTree(num);
        }
        System.out.println("Tree number to be searched.");

        n = scan.nextInt();

        if (bst.searchTree(n) != null) {
            System.out.println("Number found.");
        } else {
            System.out.println("Number not found.");
        }

        System.out.println("Inorder traversal of binary search tree.");
        bst.inOrderTraversal();
    }

}

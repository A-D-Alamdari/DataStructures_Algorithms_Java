package Trees;

public class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return this.data;
    }
    public TreeNode getLeft() {
        return this.left;
    }
    public TreeNode getRight() {
        return this.right;
    }

    public void setData(int data) {
        this.data = data;
    }
    public void setLeft(TreeNode left) {
        this.left = left;
    }
    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void prettyPrint(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println(data);
        if (left != null) {
            left.prettyPrint(level + 1);
        }
        if (right != null) {
            right.prettyPrint(level + 1);
        }
    }
}

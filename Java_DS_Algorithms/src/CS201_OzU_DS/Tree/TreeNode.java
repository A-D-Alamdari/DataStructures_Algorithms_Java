package CS201_OzU_DS.Tree;

public class TreeNode {
    private int data;
    private TreeNode right;
    private TreeNode left;

    /**
     * Constructor of the TreeNode
     * @param data : The value of the TreeNode
     */
    public TreeNode(int data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }

    // Getters
    public TreeNode getRight() {
        return this.right;
    }
    public TreeNode getLeft() {
        return this.left;
    }
    public int getData() {
        return this.data;
    }

    // Setters
    public void setRight(TreeNode right) {
        this.right = right;
    }
    public void setLeft(TreeNode left) {
        this.left = left;
    }
    public void setData(int data) {
        this.data = data;
    }


}

package CS201_OzU_DS.Tree;

public class Tree {
    private TreeNode root;

    /**
     * Constructor of an empty Tree
     */
    public Tree() {
        this.root = null;
    }

    /**
     * Constructor of a Tree with specified data for root node.
     * @param data : Data value of the root node.
     */
    public Tree(int data) {
        TreeNode root = new TreeNode(data);
        this.root = root;
    }

    // Getter and Setter
    public TreeNode getRoot() {
        return this.root;
    }
    public void setRoot(int data) {
        this.root = new TreeNode(data);
    }
    public void setRoot(TreeNode root) {
        this.root = root;
    }



}

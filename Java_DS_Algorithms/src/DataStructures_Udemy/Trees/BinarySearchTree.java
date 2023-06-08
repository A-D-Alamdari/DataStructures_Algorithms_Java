package DataStructures_Udemy.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(int data) {
        TreeNode newTreeNode = new TreeNode(data);
        root = newTreeNode;
    }

    public TreeNode getRoot() {
        return this.root;
    }
    public void setRoot(int data) {
        TreeNode newTreeNode = new TreeNode(data);
        this.root = newTreeNode;
    }

    public boolean insert(int data) {
        TreeNode newTreeNode = new TreeNode(data);
        if (this.root == null) {
            this.root = newTreeNode;
            return true;
        }
        TreeNode temp = this.root;
        while (true) {
            if (newTreeNode.getData() == temp.getData()) {
                return false;
            }
            if (data < temp.getData()) {
                if (temp.getLeft() == null) {
                    temp.setLeft(newTreeNode);
                    return true;
                }
                temp = temp.getLeft();
            } else {
                if (temp.getRight() == null) {
                    temp.setRight(newTreeNode);
                    return true;
                }
                temp = temp.getRight();
            }
        }
    }

    public boolean isContains(int data) {
        if (root == null) {
            return false;
        }
        TreeNode temp = root;
        while (temp != null) {
            if (data < temp.getData()) {
                temp = temp.getLeft();
            } else if (data > temp.getData()) {
                temp = temp.getRight();
            } else {
                return true;
            }
        }
        return false;
    }


    // RECURSIVE METHODS
    private boolean recursiveContains(TreeNode currentTreeNode, int value) {
        if (currentTreeNode == null) {
            return false;
        }
        if (currentTreeNode.getData() == value) {
            return true;
        }
        if (value < currentTreeNode.getData()) {
            return recursiveContains(currentTreeNode.getLeft(), value);
        } else {
            return recursiveContains(currentTreeNode.getRight(), value);
        }
    }

    public boolean recursiveContains(int value) {
        return recursiveContains(root, value);
    }


    private TreeNode recursiveInsert(TreeNode currentTreeNode, int value) {
        if (currentTreeNode == null) {
            return new TreeNode(value);
        }
        if (value < currentTreeNode.getData()) {
            currentTreeNode.setLeft(recursiveInsert(currentTreeNode.getLeft(), value));
        } else {
            currentTreeNode.setRight(recursiveInsert(currentTreeNode.getRight(), value));
        }
        return currentTreeNode;
    }

    public void recursiveInsert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        }
        recursiveInsert(root, value);
    }


    private TreeNode deleteNode(TreeNode currentTreeNode, int value) {
        if (currentTreeNode == null) {
            return null;
        }
        if (value < currentTreeNode.getData()) {
            currentTreeNode.setLeft(deleteNode(currentTreeNode.getLeft(), value));
        } else if (value > currentTreeNode.getData()) {
            currentTreeNode.setRight(deleteNode(currentTreeNode.getRight(), value));
        } else {
            if (currentTreeNode.getLeft() == null && currentTreeNode.getRight() == null) {
                return null;
            } else if (currentTreeNode.getLeft() == null) {
                currentTreeNode = currentTreeNode.getRight();
            } else if (currentTreeNode.getRight() == null) {
                currentTreeNode = currentTreeNode.getLeft();
            } else {
                int subTreeMin = minValue(currentTreeNode.getRight());
                currentTreeNode.setData(subTreeMin);
                currentTreeNode.setRight(deleteNode(currentTreeNode.getRight(), subTreeMin));
            }
        }
        return currentTreeNode;
    }

    public void deleteNode(int value) {
        deleteNode(root, value);
    }


    public int minValue(TreeNode currentTreeNode) {
        while (currentTreeNode.getLeft() != null) {
            currentTreeNode = currentTreeNode.getLeft();
        }
        return currentTreeNode.getData();
    }

    public int maxValue(TreeNode currentTreeNode) {
        while (currentTreeNode.getRight() != null) {
            currentTreeNode = currentTreeNode.getRight();
        }
        return currentTreeNode.getData();
    }


    // TREE TRAVERSAL
    /**
     * Tree Traversal:
     *                  1) Breadth First Search
     *                  2) Depth First Search
     *                      2-1) PreOrder
     *                      2-2) PostOrder
     *                      2-3) InOrder
     */

    // Tree Traversal --> Breadth First Search
    public ArrayList<Integer> BFS() {
        TreeNode currentNode = root;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(currentNode);
        while (queue.size() > 0) {
            currentNode = queue.remove();
            results.add(currentNode.getData());
            if (currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }
        return results;
    }


    // Tree Traversal --> Depth First Search --> PreOrder
    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        class Traverse {
            Traverse(TreeNode currentNode) {
                results.add(currentNode.getData());
                if (currentNode.getLeft() != null) {
                    new Traverse(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    new Traverse(currentNode.getRight());
                }
            }
        }
        new Traverse(root);
        return results;
    }

    // Tree Traversal --> Depth First Search --> PostOrder
    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        class Traverse {
            Traverse(TreeNode currentNode) {
                if (currentNode.getLeft() != null) {
                    new Traverse(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    new Traverse(currentNode.getRight());
                }
                results.add(currentNode.getData());
            }
        }
        new Traverse(root);
        return results;
    }

    // Tree Traversal --> Depth First Search --> InOrder
    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        class Traverse {
            Traverse(TreeNode currentNode) {
                if (currentNode.getLeft() != null) {
                    new Traverse(currentNode.getLeft());
                }
                results.add(currentNode.getData());
                if (currentNode.getRight() != null) {
                    new Traverse(currentNode.getRight());
                }

            }
        }
        new Traverse(root);
        return results;
    }


    public int numberOfNonLeafNodes(TreeNode root) {
        if (root == null || (root.getLeft() == null && root.getRight() == null)) {
            return 0;
        }

        return 1 + numberOfNonLeafNodes(root.getLeft()) + numberOfNonLeafNodes(root.getRight());
    }

    public int numberOfMeanNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return numberOfMeanNodesHelper(root);
    }

    private int numberOfMeanNodesHelper(TreeNode node) {
        if (node == null || (node.getLeft() == null && node.getRight() == null)) {
            return 0;
        }
        int count = 0;
        if (node.getData() == (node.getLeft().getData() + node.getRight().getData()) / 2.0) {
            count++;
        }
        count += numberOfMeanNodesHelper(node.getLeft()) + numberOfMeanNodesHelper(node.getRight());
        return count;
    }

    public int leftistOrRightist(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int numLeftist = countLeftist(root);
        int numRightist = countRightist(root);

        return numLeftist - numRightist;
    }

    private int countLeftist(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (node.getLeft() != null && node.getRight() == null) {
            return 1 + countLeftist(node.getLeft());
        } else {
            return countLeftist(node.getLeft()) + countLeftist(node.getRight());
        }
    }

    private int countRightist(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (node.getRight() != null && node.getLeft() == null) {
            return 1 + countRightist(node.getRight());
        } else {
            return countRightist(node.getLeft()) + countRightist(node.getRight());
        }
    }

    public int totalHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return totalHeightHelper(root, 0);
    }

    private int totalHeightHelper(TreeNode node, int height) {
        if (node == null) {
            return 0;
        }
        return height + totalHeightHelper(node.getLeft(), height + 1) + totalHeightHelper(node.getRight(), height + 1);
    }

    public void printBetween(TreeNode root, int k1, int k2) {
        if (root == null) {
            return;
        }

        if (root.getData() > k1 && root.getData() < k2) {
            System.out.print(root.getData() + " ");
        }

        if (root.getData() > k1) {
            printBetween(root.getLeft(), k1, k2);
        }

        if (root.getData() < k2) {
            printBetween(root.getRight(), k1, k2);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.getLeft());
        int rightHeight = height(root.getRight());

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public void swapChildren(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);

        swapChildren(root.getLeft());
        swapChildren(root.getRight());
    }

    public int sumOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.getData() + sumOfTree(root.getLeft()) + sumOfTree(root.getRight());
    }

    public void deleteLeafNodes(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            root = null;
        } else {
            deleteLeafNodes(root.getLeft());
            deleteLeafNodes(root.getRight());
        }
    }

    public void printSorted(TreeNode root) {

        if (root == null) {
            return;
        }

        printSorted(root.getLeft());
        System.out.print(root.getData() + " ");
        printSorted(root.getRight());
    }

    public void prettyPrint(){
        if (root != null){
            root.prettyPrint(0);
        }
    }
}

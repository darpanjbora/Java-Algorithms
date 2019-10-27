package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    BinaryTreeNode root;

    BinaryTree() {
    }

    BinaryTree(int d) {
        root = new BinaryTreeNode(d);
    }

    /* Recursive approach of inOrder Traversal of Tree
     * Time Complexity: O(n)
     * Space Complexity: O(n) (implicit)
     */
    public void inOrder(BinaryTreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    /* Iterative  approach of inOrder Traversal of Tree
     * Time Complexity: O(n)
     * Space Complexity: O(n) (explicit)
     */
    public void inOrderWithoutRecursion(BinaryTreeNode root) {
        if (root == null) return;
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.empty()) {
            BinaryTreeNode temp = stack.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null)
                root = temp.right;
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
    }

    /* inOrder Traversal of Tree with using any extra space, Morris Traversal
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void inOrderMorrisTraversal(BinaryTreeNode root) {
        while (root != null) {
            if (root.left == null) {
                System.out.print(root.data + " ");
                root = root.right;
            } else {
                BinaryTreeNode prev = root.left;
                while (prev.right != null && prev.right != root)
                    prev = prev.right;
                if (prev.right == null) {
                    prev.right = root;
                    root = root.left;
                } else {
                    prev.right = null;
                    System.out.print(root.data + " ");
                    root = root.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new BinaryTreeNode(1);
        binaryTree.root.left = new BinaryTreeNode(2);
        binaryTree.root.right = new BinaryTreeNode(3);
        binaryTree.root.left.left = new BinaryTreeNode(4);
        binaryTree.root.left.right = new BinaryTreeNode(5);
        binaryTree.root.right.right = new BinaryTreeNode(6);
        binaryTree.root.left.left.right = new BinaryTreeNode(7);
        binaryTree.root.left.right.left = new BinaryTreeNode(8);
        binaryTree.root.right.right.left = new BinaryTreeNode(9);

        System.out.println("\nInOrder");
        binaryTree.inOrder(binaryTree.root);

        System.out.println("\nInOrderWithoutRecurion");
        binaryTree.inOrderWithoutRecursion(binaryTree.root);
        System.out.println("\nInOrderMorrisTraversal");
        binaryTree.inOrderMorrisTraversal(binaryTree.root);

    }
}

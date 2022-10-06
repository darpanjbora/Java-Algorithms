package Tree;

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

    /* Recursive approach of preOrder Traversal of Tree
     * Time Complexity: O(n)
     * Space Complexity: O(n) (implicit)
     */
    public void preOrder(BinaryTreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /* preOrder Traversal of Tree with using any extra space, Morris Traversal
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void preOrderMorrisTraversal(BinaryTreeNode root) {
        while (root != null) {
            if (root.left == null) {
                System.out.print(root.data + " ");
                root = root.right;
            } else {
                BinaryTreeNode prev = root.left;
                while (prev.right != null && prev.right != root)
                    prev = prev.right;
                if (prev.right == root) {
                    prev.right = null;
                    root = root.right;
                } else {
                    System.out.print(root.data + " ");
                    prev.right = root;
                    root = root.left;
                }
            }
        }
    }

    /* Recursive approach of postOrder Traversal of Tree
     * Time Complexity: O(n)
     * Space Complexity: O(n) (implicit)
     */
    public void postOrder(BinaryTreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    /* Iterative  approach of psotOrder Traversal of Tree using two stack
     * Time Complexity: O(n)
     * Space Complexity: O(n) (explicit)
     */
    public void iterativePostOrderTraversalTwoStack(BinaryTreeNode rootref) {
        if (rootref == null) return;
        Stack<BinaryTreeNode> stack1 = new Stack<BinaryTreeNode>();
        Stack<BinaryTreeNode> stack2 = new Stack<BinaryTreeNode>();
        stack1.push(rootref);
        while (!stack1.empty()) {
            BinaryTreeNode temp = stack1.pop();
            stack2.push(temp);
            if (temp.left != null) stack1.push(temp.left);
            if (temp.right != null) stack1.push(temp.right);
        }
        while (!stack2.empty()) {
            System.out.print(stack2.pop().data + " ");
        }
    }

    /* Iterative  approach of psotOrder Traversal of Tree using one stack
     * Time Complexity: O(n)
     * Space Complexity: O(n) (explicit)
     */
    public void iterativePostOrderTraversalOneStack(BinaryTreeNode rootref) {
        if (rootref == null) return;
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.push(rootref);
        BinaryTreeNode prev = rootref;
        while (!stack.empty()) {
            BinaryTreeNode top = stack.peek();
            if (top.left == null && top.right == null ||
                    top.left == prev || top.right == prev) {
                prev = stack.pop();
                System.out.print(prev.data + " ");

            } else if (top.left != null && top.right != null &&
                    (top.left != prev || top.right != prev)) {
                stack.push(top.right);
                stack.push(top.left);
            } else if (top.right != null && top.right != prev) {
                stack.push(top.right);
            } else if (top.left != null && top.left != prev) {
                stack.push(top.left);
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

        System.out.println("\nInOrderRecursively");
        binaryTree.inOrder(binaryTree.root);

        System.out.println("\nInOrderWithoutRecursion");
        binaryTree.inOrderWithoutRecursion(binaryTree.root);

        System.out.println("\nInOrderMorrisTraversal");
        binaryTree.inOrderMorrisTraversal(binaryTree.root);

        System.out.println("\nPreOrderRecursively");
        binaryTree.preOrder(binaryTree.root);

        System.out.println("\npreOrderMorrisTraversal");
        binaryTree.preOrderMorrisTraversal(binaryTree.root);

        System.out.println("\npostOrderRecursively");
        binaryTree.postOrder(binaryTree.root);

        System.out.println("\niterativePostOrderTraversalOneStack");
        binaryTree.iterativePostOrderTraversalOneStack(binaryTree.root);

        System.out.println("\niterativePostOrderTraversalOneStack");
        binaryTree.iterativePostOrderTraversalOneStack(binaryTree.root);
    }
}

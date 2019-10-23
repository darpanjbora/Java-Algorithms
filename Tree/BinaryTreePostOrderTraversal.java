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
    public void PostOrder(BinaryTreeNode root) {
        if (root == null) return;
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.data + " ");
    }

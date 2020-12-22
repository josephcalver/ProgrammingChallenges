package _4_4_CheckBalancedTree;

public class App {

    /*
    Check Balanced: Implement a function to check if a binary tree is balanced.
    For the purposes of this question, a balanced tree is defined to be a tree
    such that the heights of the two subtrees of any node never differ by more than one.
     */

    static class Node {

        int data;
        Node left;
        Node right;

    }

    public boolean isBalanced(Node root) {
        if (root == null) return true;

        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int getHeight(Node root) {
        if (root == null) return -1;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }


    public static void main(String[] args) {



    }

    public boolean isBalancedEfficient(Node root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    // this version is more efficient because it does height comparison of subtrees
    // on the way up (on return of recursive calls) rather than at the top of the tree
    // after all recursive calls are returned (the other version recurses through the
    // entire tree before checking, then recursing through entire tree for child nodes, etc., etc.)
    // Integer.MIN_VALUE is returned as error code if heightDiff > 1
    private int checkHeight(Node root) {
        if (root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heightDiff = leftHeight = rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }

    }

}

package _4_5_ValidateBST;

public class App {

    /*
    Validate BST: Implement a function to check ifa binary tree is a binary search tree.
     */

    static Integer lastVisited;

    public static boolean validateBST(Node root) {
        if (root == null) return true;

        // check left subtree
        if (!validateBST(root.left)) return false;

        if (lastVisited != null && root.data <= lastVisited) return false;

        lastVisited = root.data;

        // check right subtree
        if (!validateBST(root.right)) return false;

        return true;
    }

    static class Node {

        int data;
        Node left;
        Node right;

    }


    public static void main(String[] args) {



    }

    // Alternative solution using min/max values for each subtree
    public static boolean checkBST(Node n) {
        return checkBST(n, null, null);
    }

    private static boolean checkBST(Node n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }

        if ((min != null && n.data <= min) || (max != null && n.data > max)) {
            return false;
        }

        if (!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max)) {
            return false;
        }

        return true;
    }

}

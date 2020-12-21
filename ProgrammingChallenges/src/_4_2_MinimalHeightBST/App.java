package _4_2_MinimalHeightBST;

public class App {

    static class Node {

        int data;
        Node right;
        Node left;

        public Node(int data) {
            this.data = data;
        }

    }

    public static Node createMinimalBST(int[] arr) {
        return createMinimalBST(arr, 0, arr.length - 1);
    }

    private static Node createMinimalBST(int[] arr, int start, int end) {
        if (end < start) return null;

        int mid = (start + end) / 2;
        Node n = new Node(arr[mid]);
        n.left = createMinimalBST(arr, start, mid - 1);
        n.right = createMinimalBST(arr, mid + 1, end);
        return n;
    }

    public static void inorderTraversal(Node node) {

        if (node == null) return;

        inorderTraversal(node.left);
        System.out.print(node.data + " --> ");
        inorderTraversal(node.right);

    }


    public static void main(String[] args) {

        int[] nums  =  {1, 2, 3, 4, 5};

        Node root = createMinimalBST(nums);

        inorderTraversal(root);

    }

}

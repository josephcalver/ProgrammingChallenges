package _4_3_ListTreeDepths;

import java.util.ArrayList;
import java.util.LinkedList;

public class App {

    static class Node implements Comparable<Node> {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.data, other.data);
        }

    }

    public static ArrayList<LinkedList<Node>> createTreeLevelListsDFS(Node root) {
        ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
        createTreeLevelListsDFS(root, lists, 0);
        return lists;
    }

    private static void createTreeLevelListsDFS(Node root, ArrayList<LinkedList<Node>> lists, int level) {

        if (root == null) return;

        LinkedList<Node> list = null;
        // if level not contained in list of lists
        if (lists.size() == level) {
            list = new LinkedList<Node>();
        } else {
            list = lists.get(level);
        }

        list.add(root);
        createTreeLevelListsDFS(root.left, lists, level + 1);
        createTreeLevelListsDFS(root.right, lists, level + 1);
    }

    public static ArrayList<LinkedList<Node>> createTreeLevelListsBFS(Node root) {
        ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
        LinkedList<Node> current = new LinkedList<Node>();
        if (root != null) {
            current.add(root);
        }

        while (current.size() > 0) { // leaf nodes won't add children to 'current' list, so size will be 0, end
            lists.add(current); // add previous level
            LinkedList<Node> parents = current; // move to next level
            current = new LinkedList<Node>();
            for (Node parent : parents) {
                // visit children
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return lists;
    }


    public static void main(String[] args) {



    }

}

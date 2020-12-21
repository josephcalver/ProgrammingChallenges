package _4_1_RouteBetweenNodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class App {

    static class Node {

        public int data;
        public boolean visited = false;
        public List<Node> neighbourList;

        public Node(int data) {
            this.data = data;
            this.neighbourList = new ArrayList<Node>();
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public List<Node> getNeighbourList() {
            return neighbourList;
        }

        public void setNeighbourList(List<Node> neighbourList) {
            this.neighbourList = neighbourList;
        }
    }

    // BFS
    public static boolean search(Node start, int value) {

        if (start == null) return false;

        Queue<Node> q = new LinkedList<>();
        start.visited = true;
        q.add(start);

        while (!q.isEmpty()) {
            Node current = q.remove();
            System.out.print(current.data + " --> ");
            for (Node child : current.getNeighbourList()) {
                if (current.data == value) return true;
                if (!child.visited) {
                    child.visited = true;
                    q.add(child);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.neighbourList.add(n2);
        n1.neighbourList.add(n3);
        n2.neighbourList.add(n4);
        n3.neighbourList.add(n5);
        n3.neighbourList.add(n7);
        n4.neighbourList.add(n5);
        n5.neighbourList.add(n6);
        n6.neighbourList.add(n4);
        n6.neighbourList.add(n7);
        n7.neighbourList.add(n5);

        boolean routeExists = search(n1, 6);
        System.out.println();
        System.out.println(routeExists);

    }

}

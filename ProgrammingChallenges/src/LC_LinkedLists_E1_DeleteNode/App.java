package LC_LinkedLists_E1_DeleteNode;

public class App {

    static class ListNode {

      int val;
      ListNode next;

      ListNode(int x) {
          val = x;
      }

    }

    public static void deleteNode(ListNode node) {

        if (node == null) return;

        node.val = node.next.val;
        node.next = node.next.next;

    }

    public static void traverse(ListNode node) {

        if (node == null) return;

        System.out.print(node.val + " --> ");

        traverse(node.next);

    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(9);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        traverse(n1);
        System.out.println();

        deleteNode(n3);

        traverse(n1);

    }


}

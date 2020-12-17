package LC_LinkedLists_E3_ReverseLInkedList;

public class App {

    static class ListNode {

        int val;
        ListNode next;

        public ListNode (int val) {
            this.val = val;
        }

    }

    public static ListNode reverseList(ListNode head) {

        if (head == null) return head;

        ListNode current = head;
        ListNode temp;

        while (current.next != null) {
            temp = current.next;
            current.next = current.next.next;
            temp.next = head;
            head = temp;
        }

        return head;
    }

    public static void traverse(ListNode node) {

        if (node == null) return;

        System.out.print(node.val + " --> ");

        traverse(node.next);
    }

    public static ListNode reverseListRecursive(ListNode node) {
        System.out.println(node.val);

        if (node.next == null) return node;
        ListNode head = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return head;
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        traverse(n1);
        System.out.println();

        ListNode newHead = reverseListRecursive(n1);
        traverse(newHead);

    }

}

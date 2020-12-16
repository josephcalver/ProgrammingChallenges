package LC_LinkedLists_E2_DeleteNthNodeFromEnd;

public class App {

    static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head.next == null && n == 1) {
            return null;
        }

        ListNode runner = head;
        while (n > 0) {
            runner = runner.next;
            n--;
        }

        if (runner == null) {
            head = head.next;
            return head;
        }

        ListNode previous = head;
        while (runner.next != null) {
            runner = runner.next;
            previous = previous.next;
        }

        // if node is tail
        if (previous.next.next == null){
            previous.next = previous.next.next;
        } else {
            previous.next.val = previous.next.next.val;
            previous.next.next = previous.next.next.next;
        }

        return head;
    }

    public static void traverse(ListNode node) {

        if (node == null) return;

        System.out.print(node.val + " --> ");

        traverse(node.next);
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

        ListNode head = removeNthFromEndLCSolution(n1, 5);

        traverse(head);

    }

    public static ListNode removeNthFromEndLCSolution(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

}

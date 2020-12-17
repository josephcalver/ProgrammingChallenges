package LC_LinkedLists_E4_MergeLists;

public class App {

    static class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head;
        ListNode previous;

        if (l1.val <= l2.val) {
            head = l1;
            previous = l1;
            l1 = l1.next;
        } else {
            head = l2;
            previous = l2;
            l2 = l2.next;
        }

        while (l1 != null && l2 != null) {
//            System.out.println("Head = " + head.val);
//            System.out.println("Previous = " + previous.val);
//            System.out.println("l1 = " + l1.val);
//            System.out.println("l2 = " + l2.val);
            if (l1.val <= l2.val) {
                previous.next = l1;
                l1 = l1.next;
            } else {
                previous.next = l2;
                l2 = l2.next;
            }
            previous = previous.next;
        }

        if (l1 != null ) {
            previous.next  = l1;
        } else if (l2 != null) {
            previous.next = l2;
        }

        return head;
    }

    public static void traverse(ListNode node) {

        if (node == null) return;
        System.out.print(node.val + " --> ");
        traverse(node.next);
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(4);

        ListNode l2 = new ListNode(1);
        ListNode nn2 = new ListNode(3);
        ListNode nn3 = new ListNode(4);
//        ListNode nn4 = new ListNode(5);
//        ListNode nn5 = new ListNode(6);

        ListNode t1 = new ListNode(0);

        l1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        l2.next = nn2;
        nn2.next = nn3;
//        nn3.next = nn4;
//        nn4.next = nn5;

        traverse(l1);
        System.out.println();
        traverse(l2);
        System.out.println();

        ListNode head = mergeTwoLists(l1, l2);

        traverse(head);

    }

}

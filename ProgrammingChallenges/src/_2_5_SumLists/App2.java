package _2_5_SumLists;

public class App2 {

    public static void main(String[] args) {

        Node head1 = new Node(1);
        head1.setNext(new Node(2));
        head1.getNext().setNext(new Node(3));
        head1.getNext().getNext().setNext(new Node(4));

        Node head2 = new Node(5);
        head2.setNext(new Node(6));
        head2.getNext().setNext(new Node(7));

        Node answerHead = addLists(head1, head2, 0);

        while (answerHead != null) {
            System.out.print(answerHead.getData() + " --> ");
            answerHead = answerHead.getNext();
        }

        System.out.println();

        Node answerHead2 = addListsForward(head1, head2);

        while (answerHead != null) {
            System.out.print(answerHead.getData() + " --> ");
            answerHead = answerHead.getNext();
        }

    }

    public static Node addLists(Node n1, Node n2, int carry) {
        if (n1 == null && n2 == null && carry == 0) {
            return null;
        }

        Node result = new Node();
        int value = carry;
        if (n1 != null) {
            value += n1.getData();
        }
        if (n2 != null) {
            value += n2.getData();
        }
        result.setData(value % 10);

        // recurse
        if (n1 != null || n2 != null) {
            Node more = addLists(n1 == null ? null : n1.getNext(),
                                    n2 == null ? null : n2.getNext(),
                                    value >= 10 ? 1 : 0);
            result.setNext(more);
        }
        return result;
    }



    public static class PartialSum {
        public Node sum = null;
        public int carry = 0;
    }

    public static Node addListsForward(Node n1, Node n2) {
        int len1 = length(n1);
        int len2 = length(n2);

        // pad shorter list with zeros

        if (len1 < len2) {
            n1 = padList(n1, len2 - len1);
        } else {
            n2 = padList(n2, len1 - len2);
        }

        // add lists
        PartialSum sum = addListsHelper(n1, n2);

        // if carry left over, insert at front of list, else return list
        if (sum.carry == 0) {
            return sum.sum;
        } else {
            Node result = insertBefore(sum.sum, sum.carry);
            return result;
        }
    }

    private static PartialSum addListsHelper(Node n1, Node n2) {
        if (n1 == null && n2 == null) {
            PartialSum sum = new PartialSum();
            return sum;
        }

        // add smaller digits recursively
        PartialSum sum = addListsHelper(n1.getNext(), n2.getNext());

        // add carry to current data
        int val = sum.carry + n1.getData() + n2.getData();

        // insert sum of current digits
        Node full_result = insertBefore(sum.sum, val % 10);

        // return sum so far and carry the value
        sum.sum = full_result;
        sum.carry = val / 10;
        System.out.println(sum.sum.getData());
        return sum;
    }

    private static Node insertBefore(Node list, int data) {
        Node node = new Node(data);
        if (list != null) {
            node.setNext(list);
        }
        return node;
    }

    private static Node padList(Node n, int padding) {
        Node head = n;
        for (int i = 0; i < padding; i++) {
            head = insertBefore(head, 0);
        }
        return head;
    }

    private static int length(Node n) {
        int length = 0;
        while (n != null) {
            length++;
            n = n.getNext();
        }
        return length;
    }

}

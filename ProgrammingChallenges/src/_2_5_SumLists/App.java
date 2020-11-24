package _2_5_SumLists;

import LinkedList.LinkedList;
import LinkedList.Node;

public class App {

    public static void main(String[] args) {

        LinkedList<Integer> l1 = new LinkedList<Integer>();
        LinkedList<Integer> l2 = new LinkedList<Integer>();

        l1.insertTail(7);
        l1.insertTail(1);
        l1.insertTail(6);

        l1.traverse();

        l2.insertTail(5);
        l2.insertTail(9);
        l2.insertTail(2);

        l2.traverse();

        LinkedList<Integer> answer = sumLists(l1, l2);
        answer.traverse();
    }

    public static LinkedList<Integer> sumLists(LinkedList<Integer> l1, LinkedList<Integer> l2) {

        LinkedList<Integer> answer = new LinkedList<Integer>();
        Node<Integer> node1 = l1.getHead();
        Node<Integer> node2 = l2.getHead();
        int num1 = 0, num2 = 0, sum = 0, carry = 0, ones = 0;

        while (node1 != null || node2 != null) {
            num1 = node1.getData();
            num2 = node2.getData();
            sum = num1 + num2 + carry;
            //System.out.println("Sum = " + sum);
            carry = sum / 10;
            //System.out.println("Carry = " + carry);
            ones = sum % 10;
            answer.insertTail(ones);
            node1 = node1.getNextNode();
            node2 = node2.getNextNode();
        }
        return answer;
    }

}


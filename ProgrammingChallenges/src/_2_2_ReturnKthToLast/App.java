package _2_2_ReturnKthToLast;

import LinkedList.LinkedList;
import LinkedList.Node;

public class App {
	
public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insertTail(1);
		list.insertTail(2);
		list.insertTail(2);
		list.insertTail(3);
		list.insertTail(2);
		list.insertTail(4);
		list.insertTail(3);
		
		Node<Integer> kthToLast = returnKthToLast(list, 4);
		System.out.println(kthToLast);
		
	}

	public static Node<Integer> returnKthToLast(LinkedList<Integer> list, int k) {
		
		Node<Integer> p1 = list.getHead(), p2 = list.getHead();
		
		for (int i = 0; i < k; i++) {
			p1 = p1.getNextNode();
		}
		
		while (p1 != null) {
			p1 = p1.getNextNode();
			p2 = p2.getNextNode();
		}
		
		return p2;
	}

}

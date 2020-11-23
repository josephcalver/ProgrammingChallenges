package _2_1_RemoveDupsLinkedList;

import LinkedList.LinkedList;
import LinkedList.Node;

public class App {
	/*
	 * Remove Dups: Write code to remove duplicates from an unsorted li nked list. 
	 * FOLLOW UP
	 * How would you solve this problem if a temporary buffer is not allowed?
	 */
	
	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insertTail(1);
		list.insertTail(2);
		list.insertTail(2);
		list.insertTail(3);
		list.insertTail(2);
		list.insertTail(4);
		list.insertTail(3);
		
		list.traverse();
		
		LinkedList<Integer> dupsRemoved = removeDups(list);
		System.out.println();
		
		dupsRemoved.traverse();
		
	}
	
	public static LinkedList<Integer> removeDups(LinkedList<Integer> list) {
		
		Node<Integer> current = list.getHead();
		Node<Integer> runner;
		
		while (current.getNextNode() != null) {
			runner = current;
			while (runner.getNextNode() != null) {
				if (runner.getNextNode().getData() == current.getData()) {
					runner.setNextNode(runner.getNextNode().getNextNode());
				} else {
					runner = runner.getNextNode();
				}
			}
			current = current.getNextNode();
		}	
		return list;
	}

}

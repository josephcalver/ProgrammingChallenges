package _2_3_PartionLinkedList;

import LinkedList.LinkedList;
import LinkedList.Node;

/*
 * Partition: Write code to partition a linked list around a value x, such that all nodes less 
 * than x come before all nodes greater than or equal to x. If x is contained within the list, 
 * the values of x only need to be after the elements less than x (see below). 
 * The partition element x can appear anywhere in the "right partition"; it does not need to 
 * appear between the left and right partitions.
 * EXAMPLE
 * Input: 3 -) 5 -) 8 -) 5 -) 113 -) 2 -) 1[partition=5] 
 * Output: 3 -) 1 -) 2 -) 113 -) 5 -) 5 -) 8
 */

public class App {
	
public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insertTail(10);
		list.insertTail(25);
		list.insertTail(20);
		list.insertTail(35);
		list.insertTail(05);
		list.insertTail(40);
		list.insertTail(30);
		list.traverse();
		System.out.println();
		
		LinkedList<Integer> partitioned = partition(list, 25);
		partitioned.traverse();
		
	}

	public static LinkedList<Integer> partition(LinkedList<Integer> list, int value) {
		
		LinkedList<Integer> before = new LinkedList<>(), after = new LinkedList<>();
		Node<Integer> pointer = list.getHead();
		while (pointer != null) {
			if (pointer.getData() < value) {
				before.insertTail(pointer.getData());
			} else {
				after.insertTail(pointer.getData());
			}
			pointer = pointer.getNextNode();
		}
		
		if (before.getTail() != null && after.getHead() != null) {
			before.getTail().setNextNode(after.getHead());
		}
		return before;
	}

}

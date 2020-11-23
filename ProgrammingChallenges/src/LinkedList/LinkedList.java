package LinkedList;

public class LinkedList<T extends Comparable<T>> implements List<T> {
	
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public Node<T> getHead() {
		return this.head;
	}
	
	public Node<T> getTail() {
		return this.tail;
	}
	
	@Override
	public void insertHead(T data) {
		Node<T> newNode = new Node<T>(data);
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			newNode.setNextNode(this.head);
			this.head = newNode;
		}
		this.size++;
	}
	
	@Override
	public void insertTail(T data) {
		Node<T> newNode = new Node<T>(data);
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.setNextNode(newNode);
			this.tail = newNode;
		}
		this.size++;
	}
	
	@Override
	public void remove(T data) {
		if (this.head == null) {
			System.out.println("List is empty");
		} 
		
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else if (this.head.getData().compareTo(data) == 0) {
				this.head.setNextNode(this.head.getNextNode().getNextNode());
		} else {
			remove(data, this.head, this.head.getNextNode());
		}
		this.size--;
		if (this.size == 0) {
			this.head = null;
			this.tail = null;
		}
	}
	
	public void remove(T dataToRemove, Node<T> previousNode, Node<T> actualNode) {
		while (actualNode != null) {
			if (actualNode.getData().compareTo(dataToRemove) == 0) {
				previousNode.setNextNode(actualNode.getNextNode());
				actualNode = null;
				this.size--;
				return;
			}
			previousNode = actualNode;
			actualNode = actualNode.getNextNode();
		}
	}
	
	@Override
	public void removeHead() {
		if (this.head == null) {
			System.out.println("List is empty");
		} else if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.getNextNode();
		}
		this.size--;
	}
	
	@Override
	public void removeTail() {
		if (this.head == null) {
			System.out.println("List is empty");
		} else if (this.size == 1) {
			this.head = null;
			this.tail = null;
		}
		else {
			Node<T> node = this.head;
			while (node.getNextNode() != this.tail) {
				node = node.getNextNode();
			}
			node.setNextNode(null);
			this.tail = node;
		}
		this.size--;
	}
	
	@Override
	public void traverse() {
		if (this.head == null) {
			System.out.println("List is empty");
		}
		
		Node<T> node = this.head;
		while (node != null) {
			System.out.print(node.getData() + " --> ");
			node = node.getNextNode();
		}
		System.out.println();
	}
	
	@Override
	public int size() {
		return this.size;
	}
	
}
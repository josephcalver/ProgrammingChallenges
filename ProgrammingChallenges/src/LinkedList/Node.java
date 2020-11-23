package LinkedList;

public class Node<T extends Comparable<T>> {
	
	private T data;
	private Node<T> nextNode;
	
	public Node(T data) {
		this.data = data;
	}
	
	public T getData() {
		return this.data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public Node<T> getNextNode() {
		return this.nextNode;
	}
	
	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}
	
	public String toString() {
		return this.data.toString();
	}

}

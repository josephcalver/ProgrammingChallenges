package LinkedList;

public class App {

	public static void main(String[] args) {
		
		List<Integer> linkedList = new LinkedList<>();
		linkedList.insertHead(5);
		linkedList.insertHead(1);
		linkedList.insertTail(10);
		linkedList.traverse();
		linkedList.removeHead();
		linkedList.traverse();
		linkedList.removeTail();
		linkedList.traverse();
		System.out.println("Size = " + linkedList.size());
		linkedList.remove(5);
		linkedList.traverse();
	}
	
}

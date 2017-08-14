package stack;

public class Stack<T> implements Stackable<T> {

	private Node head;

	private int counter;

	private class Node {
		T data;
		Node next;
	}

	@Override
	public void push(T data) {
		Node memorizedNode = head;
		head = new Node();
		head.data = data;
		head.next = memorizedNode;
		counter++;
	}

	@Override
	public T pop() {
		if (head == null) {
			System.out.println("\nStack is empty!\n");
			return null;
		}
		T retObj = head.data;
		head = head.next;
		counter--;
		return retObj;
	}

	@Override
	public T peek() {
		if (head == null) {
			System.out.println("\nStack is empty!\n");
			return null;
		}
		return head.data;

		// return (head == null) ? null : head.data;
	}

	@Override
	public boolean isEmpty() {		
		return (head == null);
	}

	@Override
	public int size() {
		return counter;
	}

	@Override
	public void clear() {
		if (head == null) {
			System.out.println("\nStack is already empty!\n");
			return;
		}
		head = null;
		counter = 0;
		System.out.println("\nStack is successfully emptied!");
	}

	@Override
	public void print() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
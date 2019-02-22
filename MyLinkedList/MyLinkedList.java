public class MyLinkedList {
	private Node head;
	private int size;

	public void addFirst(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		size++;
	}
	
	public void addLast(int data) {
		if(head == null) {
			addFirst(data);
		}
		else {
			Node current = head;
			while(current.next != null) {
				current = current.next;
			}
			current.next = new Node(data);
			size++;
		}
	}
	
	public void addAt(int index, int data) {
		if (index <= 0) {
			addFirst(data);
		}
		else if(index >= size) {
			addLast(data);
		}
		else {
			Node current = head;
			for (int j = 0; j < index - 1; j++) {
				current = current.next;
			}
			Node next = current.next;
			current.next = new Node(data);
			current.next.next = next;
			size++;
		}
	}
	
	public int removeFirst() {
		if(head == null) return -1;
		else {
			Node removedNode = head;
			head = head.next;
			size--;
			return removedNode.data;
		}
	}
	
	public int removeLast() {
		if (size == 0) {
			return -1;
		}
		else if (size == 1) {
			return removeFirst();
		}
		else {
			Node current = head;
			for (int i = 0; i < size - 2; i++) {
				current = current.next;
			}
			Node removedNode = current.next;
			current.next = null;
			size--;
			return removedNode.data;
		}
	}
	
	public int removeAt(int index) {
		if (index <= 0) {
			return removeFirst();
		}
		else if (index >= size) {
			return removeLast();
		}
		else {
			Node current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			Node removedNode = current.next;
			current.next = current.next.next;
			size--;
			return removedNode.data;
		}
	}
	
		public void printList() {
			System.out.print("List: ");
			Node current = head;
			while (current != null) {
				System.out.print(current.data + " ");
				current = current.next;
		}
			System.out.println();
	}
	
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addLast(3);
		list.addLast(4);
		list.addAt(1, 2);
		list.addFirst(1);
		list.addAt(1, 5);
		
		list.printList();
		System.out.println("Remove at location 3: " + list.removeAt(3));
		System.out.println("Remove at location 3: " + list.removeAt(3));
		System.out.println("Remove first: " + list.removeFirst());
		System.out.println("Remove last: " + list.removeLast());
		System.out.println("Remove last: " + list.removeLast());
		list.printList();
	}


}

class Node{
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
	}
}

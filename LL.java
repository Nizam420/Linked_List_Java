package linkedlist.single;

//import java.util.Iterator;

public class LL {
	
	private Node head;
	private Node tail;
	private int size;
	public LL() {
		// TODO Auto-generated constructor stub
		this.size = 0;	
	}
	
private class Node {
	private int value;
	private Node next;
		
	public Node(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
		
	public Node(int value, Node next) {
			// TODO Auto-generated constructor stub
		this.value = value;
		this.next = next;
	}
}
	

	//insert at first position

	public void insertFirst(int val) {
		Node node = new Node(val);
		node.next = head;
		head = node;
		
		if (tail == null) {
			tail = head;
		}
		
		size++;
	}
	
	//insert at last position
	
	public void insertLast(int val) {
		if (tail == null) {
			insertFirst(val);
			return;
		}
		
		Node node = new Node(val);
		tail.next = node;
		tail = node;
		
		size++;
	}
	
	//insert at given position
	
	public void insert(int val, int index) {
		if (index == 0) {
			insertFirst(val);
			return;
		}
		if (index == size) {
			insertLast(val);
			return;
		}
		
		Node temp = head;
		for (int i = 1; i < index; i++) {
			temp = temp.next;
			
		}
		
		Node node = new Node(val, temp.next);
		temp.next = node;
		size++;
	}
	
//	insert using recursion
	
	public void insertRecur(int val, int index) {
		head = insertRec(val, index, head);
	}
	
	private Node insertRec(int val, int index, Node node) {
		if (index == 0) {
			Node temp = new Node(val, node);
			size++;
			return temp;
		}
		node.next = insertRec(val, index-1, node.next);
		return node;
	}
	
	//delete first node
	
	public int deleteFirst() {
		int val = head.value;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		size--;
		return val;
	}
	
	//delete last node
	
	public int deleteLast() {
		if (size <= 1) {
			return deleteFirst();
		}
		Node secondLast = get(size - 2);
		int val = tail.value;
		tail = secondLast;
		tail.next = null;
		return val;
	}
	
	//delete from specific position
	
	public int delete(int index) {
		if (index == 0) {
			return deleteFirst();
		}
		
		if (index == size - 1) {
			return deleteLast();
		}
		
		Node prev = get(index - 1);
		int val = prev.next.value;
		prev.next = prev.next.next;
		return val;
	}
	
	
	// find a node 
	
	public Node find(int value) {
		Node node = head;
		while (node != null) {
			if (node.value == value) {
				return node;
			}
			node = node.next;
		}
		return null;
	}
	
	//get a node
	
	public Node get(int index) {
		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	
	//diplsy linked list
	
	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + " -> ");
			temp = temp.next;
		}
		System.out.println("END");
	}
	
	//find duplicates
	
	public void duplicates() {
		Node node = head;
		while (node.next != null) {
			if (node.next != null &&  node.value == node.next.value) {
				node.next = node.next.next;
				size--;
			}
			else {
				node = node.next;
			}
		}
		tail = node;
		tail.next = null;
	}
	
	public static LL merge(LL first, LL second) {
		Node f = first.head;
		Node s = second.head;
		
		LL ans = new LL();
		
		while (f != null && s != null) {
			if (f.value < s.value) {
				ans.insertLast(f.value);
				f = f.next;
			}
			else {
				ans.insertLast(s.value);
				s = s.next;
			}
		}
		
		while (f != null) {
			ans.insertLast(f.value);
			f = f.next;
		}
		
		while (s != null) {
			ans.insertLast(s.value);
			s = s.next;
		}
		return ans;
	}
	
	public void bubbleSort() {
		bubbleSort(size - 1, 0);
	}
	
	private void bubbleSort(int row, int col) {
		// TODO Auto-generated method stub
		if (row == 0) {
			return;
		}
		if (col < row) {
			Node first = get(col);
			Node second = get(col + 1);
			
			if (first.value > second.value) {
				if (first == head) {
					head = second;
					first.next = second.next;
					second.next = first;
				}
				else if (second == tail) {
					Node prev = get(col - 1);
					prev.next = second;
					tail = first;
					first.next = null;
					second.next = tail;
				}
				else {
					Node prev = get(col - 1);
					prev.next = second;
					first.next = second.next;
					second.next = first;
				}
			}
			bubbleSort(row, col + 1);
		}
		else {
			bubbleSort(row - 1, col);
		}
	}
	
	private void reverseRec(Node node) {
		if (node == tail) {
			head = tail;
			return;
		}
		
		reverseRec(node.next);
		
		tail.next = node;
		tail = node;
		tail.next = null;
	}
	
	

	public static void main(String[] args) {
		LL first = new LL();
		LL second = new LL();
		
		first.insertLast(11);
		first.insertLast(3);
		first.insertLast(5);
		
		second.insertLast(1);
		second.insertLast(22);
		second.insertLast(9);
		second.insertLast(14);
		
		LL ans = LL.merge(first, second);
		ans.display();
		ans.bubbleSort();
		ans.display();
	}
}

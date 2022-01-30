package linkedlist.single;

public class Main {
	public static void main(String[] args) {
		LL list = new LL();
		list.insertFirst(44);
		list.insertFirst(34);
		list.insertFirst(99);
		list.insertFirst(66);
		list.insertFirst(33);
		
		list.insertLast(100);
		list.insertLast(101);
		list.insertLast(1001);
		
		list.insert(999, 3);
		
		list.display();
//		
//		System.out.println(list.deleteFirst());
//		System.out.println(list.deleteLast());
//		
//		list.display();
//		
//		System.out.println(list.delete(2));
//		list.display();
//		System.out.println(list.find(44));
		
//		DLL list = new DLL();
//		list.insertFirst(44);
//		list.insertFirst(34);
//		list.insertFirst(99);
//		list.insertFirst(66);
//		list.insertFirst(33);
//		list.insertLast(99);
//		
//		list.insert(33, 111);
//		
//		list.display();
		
//		CLL list = new CLL();
//		list.insert(44);
//		list.insert(99);
//		list.insert(88);
//		list.insert(11);
//		list.insert(22);
//		
//		list.display();
//		
//		list.delete(11);
//		list.display();
		
		list.insertRecur(23, 7);
		list.display();
	}
}

package idh.java;


public class MyLinkedList<T> {

	// Methods:
	// - add
	// - print
	// - get
	// - size
	
	class ListElement {
		T value;
		ListElement next;
	}
	
	ListElement first;
	
	public MyLinkedList() {
		first = null;
	}
	
	public void add(T element) {
		ListElement newElement = new ListElement();
		newElement.value = element;
		newElement.next = null;
		
		if (first == null) {
			first = newElement;
		} else {
			last().next = newElement;
		}
	}
	
	private ListElement last() {
		ListElement current = first;
		while(current.next != null) {
			current = current.next;
		}
		return current;
	}
	
	public void print() {
		System.out.print("[");
		ListElement current = first;
		while(current != null) {
			System.out.print(current.value);
			current = current.next;
		}
		System.out.print("]");
	}
	
	public static void main(String[] args) {
		MyLinkedList<String> ml1 = new MyLinkedList<String>();
		ml1.add("Hello");
		ml1.add("World");
		ml1.print();
		System.out.println();
		MyLinkedList<Student> ml2 = new MyLinkedList<Student>();
		ml2.add(new Student("Maria Müller"));
		ml2.print();
	}


}
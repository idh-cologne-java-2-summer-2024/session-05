package idh.java;


public class MyLinkedList<T> {

	// Methods:
	// - add
	// - print
	// - get
	// - size
	
	public static void main(String[] args) {
		MyLinkedList<String> ml1 = new MyLinkedList<String>();
		ml1.add("Hello");
		ml1.print();
		MyLinkedList<Student> ml2 = new MyLinkedList<Student>();
		ml2.add(new Student("Maria Müller"));
		ml2.print();
	}


}
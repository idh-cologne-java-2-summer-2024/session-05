package idh.java;

public class MyLinkedList<T> {

    class ListElement {
	T payload;
	ListElement next = null;

	public ListElement(T payload) {
	    this.payload = payload;
	}
    }

    ListElement first = null;

    public T get(int index) throws IndexOutOfBoundsException {
	if (first == null) {
	    throw new IndexOutOfBoundsException();
	} else {
	    int counter = 0;

	    ListElement current = first;
	    while (current != null) {
		current = current.next;
		counter++;
		if (counter == index) {
		    return current.payload;
		}
	    }

	    throw new IndexOutOfBoundsException();

	}

    }

    public int size() {
	if (first == null) {
	    return 0;
	} else {
	    int counter = 0;

	    ListElement current = first;
	    while (current != null) {
		current = current.next;
		counter++;
	    }

	    return counter;
	}
    }

    public void add(T element) {
	if (first == null) {
	    first = new ListElement(element);
	} else {

	    ListElement current = first;
	    while (current.next != null) {
		current = current.next;
	    }
	    current.next = new ListElement(element);

	}
    }

    public static void main(String[] args) {
	MyLinkedList<String> list = new MyLinkedList<String>();
	list.add("Hallo0");
	list.add("Hallo1");
	list.add("Hallo2");
	list.add("Hallo3");

	System.out.println(list.size());
	System.out.println(list.get(2));
    }

}
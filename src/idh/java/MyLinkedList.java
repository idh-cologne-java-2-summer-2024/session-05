package idh.java;

import java.util.NoSuchElementException;

/**
 * Diese Klasse beschriebt eine String-Liste (Datenstruktur), in die beliebig
 * viele Strings eingefügt und wieder gelöscht werden können. Die Klasse soll
 * die Nachteile eines Arrays, wie etwa die feste Größe oder die beim Löschen
 * einzelner Elemente entstehenden "Lücken", durch das Anbieten verschiedener
 * Hilfsmethoden ausgleichen. Man bezeichnet so etwas auch als eine Abstraktion
 * oder "Wrapper-Klasse", also eine "Verpackung" um etwas.
 * 
 * @author bkis
 *
 */
public class MyLinkedList<T> {

	ListElement first = null;

	/**
	 * Ein Konstruktor, dem man ein bereits bestehendes String-Array übergeben kann,
	 * welches als initiale Datenbasis für die StringList verwendet wird.
	 * 
	 * @param initialArray
	 */
	public MyLinkedList(T[] initialArray) {
	}

	/**
	 * Ein Konstruktor, der ganz ohne Argumente auskommt. Hier wird einfach eine
	 * festgelegte Anfangs-Länge des Arrays verwendet, indem ein anderer Konstruktor
	 * mit dem entsprechenden Wert aufgerufen wird.
	 */
	public MyLinkedList() {
	}

	/**
	 * Diese Methode fügt der StringList am Ende einen neuen String hinzu.
	 * 
	 * @param s Der String, der hinzugefügt werden soll
	 */
	public void add(T s) {
		if (first == null) {
			first = new ListElement(s);
		} else {
			ListElement current = first;
			while(current.next != null) {
				current = current.next;
			}
			current.next = new ListElement(s);
		}
	}

	/**
	 * Ersetzt den String an der gewünschten Stelle durch einen anderen
	 * 
	 * @param index Index des zu ersetzenden Elements
	 * @param s     String, durch den ersetzt werden soll
	 */
	public void set(int index, T s) {
		if (first == null) {
			throw new NoSuchElementException();
		} else {
			ListElement current = first;
			while(current.next != null && index > 0) {
				current = current.next;
				index--;
			}
			if (index == 0)
				current.value = s;
		}
	}

	/**
	 * Diese Methode entfernt einen String aus der Liste. Hierbei sollen keine
	 * Lücken im internen Array entstehen! Es kann natürlich sein, dass es mehrere
	 * Strings mit dem gleichen Inhalt in der Liste gibt. Es wird daher (als
	 * Kompromisslösung) nur der erste passende String entfernt.
	 * 
	 * WICHTIGER HINWEIS: Strings bitte NIEMALS so vergleichen: if (string1 ==
	 * string2) {...} Sondern IMMER so: if (string1.equals(string2)) {...}
	 *
	 * Grund: Der Vergleichsoperator "==" überprüft, ob es sich um dasselbe Objekt
	 * handelt - er überprüft hingegen nicht, ob es sich um zwei (potentiell
	 * verschiedene) String-Objekte mit dem selben Text-Inhalt handelt!
	 * 
	 * @param toRemove Der String, der entfernt werden soll
	 */
	public void remove(T toRemove) {
		// TODO: implementieren!
	}

	/**
	 * Diese Methode entfernt den String an der Stelle "index" aus der Liste. Auch
	 * hier dürfen keine Lücken entstehen!
	 * 
	 * @param index
	 */
	public void remove(int index) {
		// TODO: implementieren!
	}

	/**
	 * Diese Methode gibt den index des ersten Elements der Liste zurück, das dem
	 * übergebenen String entspricht.
	 * 
	 * WICHTIGER HINWEIS: Siehe Kommentar der Methode remove(...)!
	 * 
	 * @param s String, dessen Index gesucht werden soll
	 * @return Index des gesuchten Strings, oder -1 wenn String nicht enthalten ist.
	 */
	public int indexOf(T s) {
//		for (int i = 0; i < data.length; i++) {
//			String irgendwas = data[i];
//		}

		for (int i = 0; i < data.length; i++) {
			// for (String irgendwas : data) {
			if (s.equals(data[i])) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Diese Methode gibt den String an der Stelle "index" aus der Liste zurück.
	 * 
	 * @param index Index des Strings, der zurückgegeben werden soll
	 * @return Der String, der zurückgegeben werden soll
	 */
	public T get(int index) {
		if (isIndexValid(index)) {
			return data[index];
		} else {
			return null;
		}
	}

	/**
	 * Diese Methode gibt die StringList im aktuellen Zustand auf der Konsole aus.
	 * Hierfür wird die Klasse StringBuilder aus der Java-Library verwendet, welche
	 * das Verketten von Strings wesentlich beschleunigt (Niemals String in
	 * Schleifen verketten! Das ist sehr langsam wegen der Unveränderbarkeit von
	 * Strings/Arrays!).
	 * 
	 * Einfache Alternative: return Arrays.toString(data);
	 */
	public void print() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");

		for (int i = 0; i < nextInsertPosition; i++) {
			sb.append(data[i]);
			if (i < nextInsertPosition - 1)
				sb.append(", ");
		}

		sb.append("]");
		System.out.println(sb.toString());
	}

	/**
	 * Kehrt die gesamte Liste um (Reihenfolge der Strings)
	 */
	public void reverseList() {
		// String[] newArray = new String[this.nextInsertPosition];
		T[] newArray = (T[]) new Object[this.data.length];
		// int j = 0;
		for (int i = data.length - 1; i > 0; i--) {
			newArray[data.length - i] = data[i];
			// j++;
		}
		// TODO: implementieren!
	}

	/**
	 * Gibt eine neue Instanz von StringList mit den Elementen von "start" bis "end"
	 * (exklusiv) zurück
	 * 
	 * @param start Start-Index der Teil-Liste
	 * @param end   End-Index der Teil-Liste + 1
	 * @return
	 */
	public MyLinkedList getSubList(int start, int end) {
		// TODO: implementieren!
		return null;
	}

	/**
	 * Gibt an, wieviele Elemente diese Liste momentan enthält.
	 * 
	 * @return Anzahl der Elemente dieser Liste
	 */
	public int size() {
		return this.nextInsertPosition;
	}
	
	private ListElement last() {
		ListElement current = first;
		while(current.next != null) {
			current = current.next;
		}
		return current;
	}
	
	class ListElement {
		T value;
		ListElement next;
		
		public ListElement(T value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		MyLinkedList<String> ml1 = new MyLinkedList<String>();
		ml1.add("Hello");
		ml1.print();
		MyLinkedList<Student> ml2 = new MyLinkedList<Student>();
		ml2.add(new Student("Maria Müller"));
		ml2.print();
	}

}
package idh.java;

public class Student extends Object {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(String name) {
		super();
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
}

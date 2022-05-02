package idh.java;

import java.util.Iterator;

public class StudentIterator implements Iterator<Student> {

	Course course;
	int counter;
	
	public StudentIterator(Course c) {
		course = c;
		counter = 0;
	}
	
	@Override
	public boolean hasNext() {
		return counter < course.size();
	}

	@Override
	public Student next() {
		Student s = course.getMember(counter);
		counter = counter + 1;
		return s;
	}

}

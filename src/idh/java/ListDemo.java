package idh.java;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListDemo {
	public static void doTimingLinkedList() throws IOException {
		int n = (int) Math.pow(10.0, 7.0);
		Random random = new Random(0);
		System.out.println("Timing for LinkedList");
		System.out.println("n = " + n);
		OutputStream os = OutputStream.nullOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);

		
		long start = System.currentTimeMillis();
		List<Integer> linkedList = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			linkedList.add(i);
		}
		System.out.println("- create and fill: " + (System.currentTimeMillis()-start) + "ms.");

		start = System.currentTimeMillis();
		for (int i = 0; i < 10; i++)
			osw.write(linkedList.get(random.nextInt(n)));
		System.out.println("- access 10 random elements: " + (System.currentTimeMillis()-start) + "ms.");
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 10; i++)
			osw.write(linkedList.remove(random.nextInt(n-i)));
		System.out.println("- remove 10 random positions: " + (System.currentTimeMillis()-start) + "ms.");

		start = System.currentTimeMillis();
		Iterator<Integer> iter = linkedList.listIterator();
		int removed = 0;
		while(iter.hasNext()) {
			Integer o = iter.next();
			if (random.nextDouble() < 100/(double)n) {
				iter.remove();
				removed++;
			}
		}
		System.out.println("- remove random "+removed+" positions via iterator: " + (System.currentTimeMillis()-start) + "ms.");
	}
	
	public static void doTimingArrayList() throws IOException {
		int n = (int) Math.pow(10.0, 7.0);
		Random random = new Random(0);
		System.out.println("Timing for ArrayList");
		System.out.println("n = " + n);
		OutputStream os = OutputStream.nullOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		long start = System.currentTimeMillis();

		List<Integer> arrayList = new ArrayList<Integer>(n);
		for (int i = 0; i < n; i++) {
			arrayList.add(i);
		}
		System.out.println("- create and fill: " + (System.currentTimeMillis()-start) + "ms.");
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 10; i++)
			osw.write(arrayList.get(random.nextInt(n)));
		System.out.println("- access 10 random elements: " + (System.currentTimeMillis()-start) + "ms.");

		
		start = System.currentTimeMillis();
		for (int i = 0; i < 10; i++)
			osw.write(arrayList.remove(random.nextInt(n-i)));
		System.out.println("- remove 10 random positions: " + (System.currentTimeMillis()-start) + "ms.");
		
		start = System.currentTimeMillis();
		Iterator<Integer> iter = arrayList.listIterator();
		int removed = 0;
		while(iter.hasNext()) {
			Integer o = iter.next();
			if (random.nextDouble() < 100/(double) n) {
				iter.remove();
				removed++;
			}
		}
		System.out.println("- remove random " +removed+ " positions via iterator: " + (System.currentTimeMillis()-start) + "ms.");
	}
	
	public static void main(String[] args) throws IOException {
		doTimingLinkedList();
		doTimingArrayList();

	}
	
}

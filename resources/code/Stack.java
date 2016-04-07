import java.util.Scanner;

public class Stack {
	private int[] elements;
	
	/**
	 * size is the number of elements in the stack ... this controls how many 
	 * elements there are, where elements are pushed, and which elements are
	 * considered no longer in the stack
	 */
	private int size = 0;
	
	// start small, so we can see the capacity change
	public final int DEFAULT_CAPACITY = 3;
	
	public Stack() {
		elements = new int[DEFAULT_CAPACITY];
	}
	
	/**
	 * push adds an item to the top of the stack
	 * @param item - the int to add to the stack
	 */
	public void push(int item) {
		// if we go over the capacity, expand our array to fit more elements
		if (size >= elements.length) {
			// double the capacity
			int[] newElements = new int[elements.length * 2];
			
			// copy over original array... (you can also copy manually using 
			// a for loop). note that the args for arraycopy are: 
			// src, srcPos, dest, destPos, length;
			System.arraycopy(elements, 0, newElements, 0, elements.length);
			
			elements = newElements;
		}
		elements[size] = item;
		
		// note that we increment size to show that this stack has another
		// element
		size++;
	}
	
	/**
	 * Removes the top item from the stack (that last item pushed)
	 * @return the top int on the stack
	 */
	public int pop() {
		// "remove" the top element and return it. Notice that internally, 
		// array is not being changed in any way... instead, we just
		// decrement the size variable so that the next push, pop and peek
		// are performed *as if* the last element were removed.
		size--;
		return elements[size];
	}
	
	public int peek() {
		return elements[size - 1];
	}
	
	/**
	 * Used for illustrative purposes only.
	 */
	public void showInternalState() {
		int w = 1;
		for(int ele : elements) {
			w = (ele + "").length() > w ? (ele + "").length() : w;
		}
		String sizeMarker = "___size=" + size;
		if(size == elements.length) {
			System.out.printf(
					"%" + (w + 4 + sizeMarker.length()) + "s\n", sizeMarker);
		}
		for(int i = elements.length - 1; i >= 0; i--) {

			if (i < size) {
				System.out.printf("| %" + w + "s |", elements[i]);
			} else {
				System.out.print(String.format(
						"| %" + (w + 1) + "s |", 
						elements[i] + "\u0338").replace(" ",  "/"));			
			}
			System.out.println(i == size ? sizeMarker : "");
		}
		System.out.println(
				String.format("+ %" + w + "s +\n", "").replace(" ", "-"));

	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		Scanner in = new Scanner(System.in);
		System.out.println("This program displays the internal state of our stack as we perform stack operations.");
		System.out.println("This stack has a capcity of 3 elements");
		String command;
		do {
			System.out.printf("p(u)sh, p(e)ek, (p)op or (q)uit?\n> ");
			command = in.nextLine();
			if (command.equals("u")) {
				System.out.printf("...enter a number to push\n> ");
				stack.push(Integer.parseInt(in.nextLine()));
			} else if (command.equals("e")) {
				System.out.println("...the top element is " + stack.peek());
			} else if (command.equals("p")) {
				System.out.println("...popped off " + stack.pop());				
			}
			stack.showInternalState();
		} while (!command.equals("q"));
		in.close();
	}
}









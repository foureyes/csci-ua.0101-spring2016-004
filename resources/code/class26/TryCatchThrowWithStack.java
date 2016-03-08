/**
 * demonstrates:
 * ============
 * handling exceptions
 * throwing custom exceptions
 * declaring checked exceptions
 * creating a custom exception class
 * where best to handle exception
 */
public class TryCatchThrowWithStack {
	public static void main(String[] args) {
		StackString stack = new StackString();
		stack.push("hello");
		stack.push("hi");
		stack.push("bye!");
		try {
			stack.pop();
			stack.pop();
			stack.pop();
			System.out.println(stack.pop());
		} catch (StackEmpty e) {
			System.out.println(e);
		}
	}
}

class StackString {
	private String[] elements = new String[2];
	int size = 0;
	public void push(String s) {
		try {
			elements[size] = s;
		} catch (ArrayIndexOutOfBoundsException e){
			String[] newElements = new String[elements.length * 2];
			System.arraycopy(elements, 0, newElements, 0, elements.length);
			elements = newElements;
			elements[size] = s;
		}
		size++;
	}
	
	public String pop() throws StackEmpty {
		if(size < 1) {
			throw new StackEmpty("No more elements to pop off of the stack!");
		}
		return elements[--size];
	}
}

class StackEmpty extends Exception {
	StackEmpty(String s) {
		super(s);
	}
}

// checked vs unchecked exceptions
// checked exceptions... they either have to be:
// handled in a try catch
// or the method that encloses it has to declare the exception
// this check happens during compile time

// RuntimeExceptions are unchecked, such as....
// NullPointerException
// ArithmeticException
public class CheckedException {
	// must declare exception in method header if method
	// may throw a checked exception
	public static void main(String[] args) throws Exception {
		throw new Exception("hi there");
	}
}

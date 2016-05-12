
/**
 * If you have a recursive function:
 * you have a function that's defined in terms of itself
 * 
 * You have method
 * within that method, you call that method
 *
 * 1. determine some sort of case where the answer is not to call the method again
 * 2. simplify the problem until you get to number 1
 * 
 * #1 the base case - a case where you no longer have to use recursion to return a value
 * 
 * n! = n * n - 1 * n - 2... 0 
 * n * (n - 1)!
 * n * (n - 1) * (n - 2)!
 * 
 * 0! --> 1
 * 
 * 
 * 
 */


public class RecursionDemo {
	public static void main(String[] args) {
		//System.out.println(factorial(0));
		//System.out.println(factorial(3));
		System.out.println(isPalindrome("a"));
		System.out.println(isPalindrome("aa"));
		System.out.println(isPalindrome("racecar"));
		System.out.println(isPalindrome("abaa"));
		System.out.println(isPalindrome("racebar"));
	}
	
	/*public static void hello() {
		System.out.println("hello");
		hello();
	}*/
	// that problem can be solved without recursion for a base case
	// factorial(0) --> 1
	// factorial(3) --> 3 * factorial(2)
	// 						2 * factorial(1)
	//							1 * factorial(0)
	public static int factorial(int n) {
		if(n == 0) {
			// base case
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}
	// create a method called isPalindrome
	// takes a string as an argument
	// returns true or flase?
	// palindrome is a word that's the same forwards and backwards
	// racecar
	// yy
	// hannah
	// amanaplanacanalpanama
	// isPalindrome(hannah) --> true
	// isPalindrome(joe) --> false
	// how do we do this with recursion?
	// 1. what's the base case?
	// 2. how do you get to that base case?
	// if the first and the letter are the same... we don't have to do anything else
	// we know it's a palindrome
	// aa
	// stars
	// a
	public static boolean isPalindrome(String s) {
		if(s.length() <= 1) {
			return true;
		} else {
			// if the first and last letter of this string
			// are the same...
			// then we know we _could_ have a palindrome
			// only if.... everything but the first and last letter
			// is also a palindrome
			if(s.charAt(0) == s.charAt(s.length() - 1)) {
				return isPalindrome(s.substring(1, s.length() - 1));
			} else {
				return false;
			}
		}
	}
	
}

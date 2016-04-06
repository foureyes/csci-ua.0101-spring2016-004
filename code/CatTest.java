import java.util.Arrays;

public class CatTest {
	public static void main(String[] args) {
		String[] catNames = {"Bill Furry", "Kitty Purry", "Paw Newman"};
		Cat[] cats = new Cat[catNames.length];
		
		// prints out Array of nulls (default value of
		// reference types in Array is null)
		System.out.println("Default value for refence types is null:");
		System.out.println(Arrays.toString(cats));

		// this is a null character in a string (different
		// from the value, null). This "null" is like any
		// other character, like "A" or "\n"
		String s = "\u0000";
		
		// null can be used as a literal value - this null
		// means a reference that doesn't refer to any object
		// ... or can also mean:
		// * the default value for a reference type
		// * (uninitialized reference type variable)
		// we can use it as an actual value!!!
		if(cats[0] == null) {
			System.out.println("We can use null as a value:");

			System.out.println("No cat to see here!");
		}		
		
		// create a bunch of cats
		for(int i = 0; i < cats.length; i++) {
			cats[i] = new Cat(catNames[i]);
		}
		
		// using static method to set lives:
		cats[1].setLives(3);
		cats[0].setLives(5);
		System.out.println("using setLives:");
		System.out.println(Arrays.toString(cats));
		
		// print out a cat
		// notice that we get a nice string representation
		// based on our Cat class toString method
		System.out.println("toString gives us a way to specify what this object's"); 
		System.out.println("string representation should be:");
		System.out.println(cats[0]);
		
		// switch first and last cat
		Cat temp = cats[0];
		cats[0] = cats[cats.length - 1];
		cats[cats.length - 1] = temp;
		
		
		// cats are now swapped!
		System.out.println("first and last cat swapped:");
		System.out.println(Arrays.toString(cats));

		// use our static method sortCats ... to sort by lives
		// note that sortCats sorts the Array in place
		// (it does not return a value)		
		Cat.sortCats(cats);
		System.out.println("sorted cats:");
		System.out.println(Arrays.toString(cats));
		
	}
	
}

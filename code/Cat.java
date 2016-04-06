// Cat class:
// per instance... a name
// per instance... number of lives
// for all instances... it'll have an owner
public class Cat {

	// each instance has its own name and number of lives
	private String name;
	private int lives = 9;

	// defined as static it's shared among all instances
	private static String owner = "Joe";

	// once we create a constructor, the default, no arg
	// constructor disappears
	public Cat(String name) {

		// in the commented out code immediately below, there's
		// no operation, since it's assigning the value of the 
		// parameter name to itself:

		// name = name;

		// we can use this to qualify the variable name...
		// this instance's name is equal to parameter, name
		this.name = name;		
	}

	public String getName() {
		return this.name;
	}

	public int getLives() {
		return lives;
	}

	// this shows the advantage of using getters and setters
	// here... we're preventing direct access to the lives
	// property so that a negative value can't be assigned to
	// it:
	public void setLives(int lives) {
		if(lives <= 0) {
			lives = 0;
		}
		this.lives = lives;
	}

	public static String getOwner() {
		return Cat.owner;
	}

	public static void setOwner(String owner) {
		Cat.owner = owner;
	}

	// toString is:
	// a special method that will automatically be called
	// when a string representation of an instance of this
	// object is needed. just define it to return a string!
	public String toString() {
		return this.name + " " + this.lives;
		// return "whatever";
	}

	// static method for sorting cats (doesn't make sense
	// to call on instance; we don't need access to a single
	// instance)
	public static void sortCats(Cat[] cats) {
		// using selection sort...

		// for every *position* in the incoming Array, cats
		for(int i = 0; i < cats.length; i++) {
			// assume that the value at the position, i, is
			// the smallest... remember that min is an *index*
			int min = i;

			// go through every element after...
			for(int j = i + 1; j < cats.length; j++) {

				// IMPORTANT PART - we're comparing objects, so
				// we get to define what to compare by... here,
				// we're comparing by a cat's number of lives:
				if(cats[j].lives < cats[min].lives) {
					min = j;
				}
				// if we wanted to sort by name
				// cats[j].name.compareTo(...)
			}

			// if the min index has changed, we know we should
			// swap
			if(min != i) {
				Cat temp = cats[min];
				cats[min] = cats[i];
				cats[i] = temp;
			}
		}
	}

}

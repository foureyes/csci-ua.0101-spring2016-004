import java.util.Arrays;

/**
 * Demonstrates:
 * 1. creating an interface
 * 2. implementing an interface
 * 3. implementing the Comparable interface
 */
public class InterfaceDemo {
	public static void main(String[] args) {
		Cat[] cats = {new Cat("frisky", 9), new Cat("fuzzy", 7), new Cat("furball", 3)};
		System.out.println(Arrays.toString(cats));
		Arrays.sort(cats);
		System.out.println(Arrays.toString(cats));
		cats[0].makeSound(2);
	}
}
interface MakesSound {
	public abstract void makeSound(int times);
}
class Cat implements Comparable<Cat>, MakesSound {
	String name;
	int lives = 9;
	Cat(String name, int lives) {
		this.name = name;
		this.lives = lives;
	}
	
	@Override 
	public String toString() {
		return this.name + " - " + this.lives;
	}
	
	@Override
	public void makeSound(int times) {
		for(int i = 0; i < times; i++) {
			System.out.println("Purr");
		}
	}
	
	@Override
	public int compareTo(Cat otherCat) {
		if(otherCat.lives > this.lives) {
			return -1;
		} else if(otherCat.lives == this.lives) {
			return 0;
		} else {
			return 1;
		}
	}
}
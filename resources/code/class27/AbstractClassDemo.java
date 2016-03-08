/**
 * Demonstrates abstract classes
 */
public class AbstractClassDemo {
	public static void main(String[] args) {
		// no can doozy
		// Monster m = new Monster();
		
		// this works though
		Monster m = new Werewolf();
	}
}

abstract class Monster {
	String name;
	public abstract void scare();
}

class Ghost extends Monster {
	public void scare() {
		System.out.println("Boo!");
	}
	public void slime() {
		System.out.println("Sliiiime");
	}
}

class Werewolf extends Monster {
	boolean isWolf = false;
	public void scare() {
		System.out.println("Boo!");
	}
}

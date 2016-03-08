/**
 * Shows the subclass has to explicitly call the superclass
 * constructor if there's no no-arg constructor in the 
 * superclass
 */
public class Constructors {
	public static void main(String[] args) {
		C1 c = new C1(5);
	}
}

class C1 {
	int x;
	C1(int x) {
		this.x = x;
	}
}
class C2 extends C1 {
	C2(int x) {
		super(x);
	}
}

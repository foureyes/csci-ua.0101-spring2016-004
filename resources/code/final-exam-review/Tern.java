
public class Tern {
	public static void main(String[] args) {
		int x = 10;
		int y;
		y = (x > 5) ? (2 * x) : x;
		//    |
	    //   \/
 		if(x > 5) {
			y = 2 * x;
		} else {
			y = x;
		}
	}
}

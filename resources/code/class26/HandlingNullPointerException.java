/**
 * Handling a NullPointerException
 */
public class HandlingNullPointerException {
  public static void main(String[] args) {
    Thing thing = new Thing();
    String s = "";
    try {
    		s = thing.obj.toString();	 
    } catch (NullPointerException e) {
    		System.out.println("uh oh an error happened");
    }
    System.out.println(s);
  }
}

class Thing {
	Object obj;
}
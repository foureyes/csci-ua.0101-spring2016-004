import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;


public class WriteRandom {
	// throw an IOException... since it's a checked exception
	public static void main(String[] args) throws IOException {
		Random rng = new Random();
		File f = new File("rando.txt");
		// notice regular java programs save in... project folder 
		// (processing seems to save in bin?)
		System.out.println(f.getAbsolutePath());
		PrintWriter out = new PrintWriter(f);
		for(int i = 0; i < 5; i++) {
			out.write(rng.nextInt());
		}
		// what happens if you forget to close?
		// nothing gets written!
		out.close();
	}
}

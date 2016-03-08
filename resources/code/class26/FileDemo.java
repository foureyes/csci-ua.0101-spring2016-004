/**
 * Reads a file in the project directory called foo.txt
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileDemo {
	public static void main(String[] args) throws IOException {
		File f = new File("foo.txt");
		System.out.println(f.exists());
		System.out.println(f.getAbsolutePath());
		
		Scanner input = new Scanner(f);
		// use input.next() to read based on whitespace 
		// use input.nextLine() to read one line at a time
		while (input.hasNext()) {
			String token = input.next();
			System.out.println(token);
		}
	}
}

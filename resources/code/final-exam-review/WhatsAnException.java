import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

// an exception is an error <-- a runtime error (that's different from compile error)
// errors:
// * compile / syntax error
// * runtime error (everything is syntactically correct, but there's some excepetional condition
//   in your program that prevents it from continuing to run)
// * logic errors ... it compiles, it doesn't crash, but it just doesn't do what you want it 
//   to do
//
// in java exceptions can be represented by objects
// all runtime errors are represented by a subclass of a class called Exception
// Exception has a bunch of subclasses
// one subclass is RuntimeException <-- unchecked exception
// another subclass IOException <-- checked exception
//
public class WhatsAnException {
	public static void main(String[] args) {
		writeFile();
	}
	public static void writeFile() {
		File f = new File("/tmp/gabe.txt");
		try {
			PrintWriter fileOut = new PrintWriter(f);
			fileOut.write("hello!!!");
			fileOut.close();
		} catch(IOException ioe) {

		} catch(Exception e) {

		} finally {
			try {
				
			} catch(Exception e) {
				
			}
		}


	}
}





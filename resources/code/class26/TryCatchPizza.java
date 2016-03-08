import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * demonstrates:
 * ============
 * try/catch
 * multiple exceptions
 */
public class TryCatchPizza {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("How many people are attending the 🍕 pizza 🍕 party?\n> ");
		int people = 1;
		try {
			people = input.nextInt();
			int slicesPerPerson = 8 / people;
			System.out.printf("Everyone gets %s slices", slicesPerPerson);
		} catch (InputMismatchException ie) {
			System.out.println("I expected a number!");
		} catch (ArithmeticException ae) {
			System.out.println("More for me!");
		}
	}
}

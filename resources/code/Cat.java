import java.util.Arrays;

public class Cat {
	
	int cutenessFactor = 10;
	String name;
	
	/**
	 * Cat constructor... 
	 * @param name
	 * @param cutenessFactor
	 */
	public Cat(String name, int cutenessFactor) {
		this.cutenessFactor = cutenessFactor;
		this.name = name;
	}
	
	public String toString() {
		return this.name + ", cuteness factor " + this.cutenessFactor;
	}
	
	/**
	 * We're dropping our main method directly into the Cat class that we're 
	 * using just for ease of use. Normally, you would have your Cat class 
	 * completely separate from the class that serves as the entry point into
	 * your program. (We're doing both in the same file here).
	 * @param args
	 */
	public static void main(String[] args) {
		
		Cat[] cats = new Cat[3];
		cats[0] = new Cat("Bill Furry", 8);
		cats[1] = new Cat("Katie Purry", 6);
		cats[2] = new Cat("Hunter S. Tomcat", 7);
		System.out.println("Before sorting:");
		System.out.println(Arrays.toString(cats));
		bubbleSort(cats);
		System.out.println("All sorted!");
		System.out.println(Arrays.toString(cats));
	}
	
	/**
	 * Sorts cats by cuteness factor
	 * @param arr an Array of cute cats (er... Cat objects)
	 */
	public static void bubbleSort(Cat[] arr) {
		// the number of swaps that have occurred
		int count;
		do {
			// start with 0 swaps
			count = 0;
			for(int i = 0; i < arr.length - 1; i++) {
				// compare by objects' cuteness factor
				if(arr[i].cutenessFactor > arr[i + 1].cutenessFactor) {
					// swap object positions (make sure to swap the entire
					// object)
					Cat temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					// count this as a swap
					count++;
				}
			}
		} while(count > 0);
	}
}

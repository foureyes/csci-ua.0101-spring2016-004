import java.util.Arrays;
import java.util.Date;


public class Sort {
	// [5, 4, 8, 9, 7]
	// [4, 5, 8, 9, 7]
	// [4, 5, 7, 8, 9]
	//for every startIndex
	//   find the smallest in the remainder
	//   if its less than the value at startIndex
	//      swap
	/*as long as there have been at least one swap
	  look at pairs of numbers... and swap their place if the second
	  is smaller than the first
	  move on to next pair
	  pairs of numbers... are adjacent elements in Array
	//  [5, 4, 8, 9, 7]
	//  [4, 5, 8, 7, 9]
	//  [4, 5, 7, 8, 9]
	//  [4, 5, 7, 8, 9]
	 * 
	 */
	public static void bubbleSort(Foo[] arr) {
		int count  = 1;
		while(count > 0) {
			count = 0;
			// go up to second to last... 
			// so that you can compare with last
			for(int i = 0; i < arr.length - 1; i++) {
				if(arr[i].key > arr[i + 1].key) {
					Foo temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					count++;
				}
			}
		}
	}
	public static void main(String[] args) {
		Date d = new Date();
		d.getTime();
		Foo[] foos = new Foo[3];
		foos[0] = new Foo(7, 100);
		foos[1] = new Foo(5, 101);
		foos[2] = new Foo(3, 102);
		
		bubbleSort(foos);
		System.out.println(Arrays.toString(foos));
	}
}

import java.util.Arrays;


public class SelectionSort {
	public static void main(String[] args) {
		int[] numbers1 = {2, 4, 7, 8, 9};
		int[] numbers2 = {8, 3, 3, 8, 9, 5};
		selectionSort(numbers1);
		System.out.println(Arrays.toString(numbers1));
		selectionSort(numbers2);
		System.out.println(Arrays.toString(numbers2));
	}
	public static void selectionSort(int[] arr) {
		
		// incrementally set the start point of the array
		// to beginning of unsorted region
		for(int start = 0; start < arr.length - 1; start++) {
			
			int smallest = arr[start];
			int indexSmallest = start;
			
			// search remainder of array for smallest
			for(int i = start + 1; i < arr.length; i++) {
				if (arr[i] <  smallest) {
					smallest = arr[i];
					indexSmallest = i;
				}
			}
			// swap with next smallest (which is already in 
			// variable smallest, no need for temp variable
			arr[indexSmallest] = arr[start];
			arr[start] = smallest;
		}
	}
}

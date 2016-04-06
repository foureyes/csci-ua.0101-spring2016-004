import java.util.Arrays;
public class BinarySearch {
	public static void main(String[] args) {
		int[] numbers = {2, 4, 7, 8, 9};
		System.out.println(binarySearch(numbers, 3));
		System.out.println(binarySearch(numbers, 4));
		System.out.println(binarySearch(numbers, 9));
		System.out.println(binarySearch(numbers, 2));
	}
	
	public static int binarySearch(int[] arr, int search) {
		int start = 0;
		int end = arr.length - 1;
		int mid = arr.length / 2;
		while (end >= start) {
			if (search == arr[mid]) {
				return mid;
			} else if (search < arr[mid]) {
				// lower half
				end = mid - 1;
			} else {
				// higher half
				start = mid + 1;
			}
			mid = start + (end - start) / 2;
		}
		return -1;
	}
}

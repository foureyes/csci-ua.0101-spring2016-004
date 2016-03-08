import java.util.Arrays;


public class Shifty {
	public static void main(String[] args) {
		int[] empty = {};
		int[] oneNum = {1};
		int[] nums = {1, 2, 3, 4, 5};
		System.out.printf("%s, %s --> ", Arrays.toString(nums), 1);
		System.out.println(Arrays.toString(shift(nums, 1)));
		
		System.out.printf("%s, %s --> ", Arrays.toString(nums), 2);
		System.out.println(Arrays.toString(shift(nums, 2)));
		
		System.out.printf("%s, %s --> ", Arrays.toString(nums), -1);
		System.out.println(Arrays.toString(shift(nums, -1)));
		
		System.out.printf("%s, %s --> ", Arrays.toString(nums), -4);
		System.out.println(Arrays.toString(shift(nums, -2)));		
	}
	public static int[] shift(int[] arr, int offset) {
		
		int[] shifted = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			int newIndex = i + offset;
			
			
			if(newIndex >= arr.length) {
				// newIndex = newIndex % arr.length;
				newIndex -= arr.length;
			} else if (newIndex < 0) {
				// newIndex = arr.length + newIndex % arr.length;
				newIndex = arr.length + newIndex;
			}
			shifted[newIndex] = arr[i];
		}
		return shifted;
	}
}

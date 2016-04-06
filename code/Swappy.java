import java.util.Arrays;


public class Swappy {
	public static void main(String[] args) {
		int[] numbers1 = {1, 2, 3, 4, 5};
		int[] numbers2 = {1, 2, 3, 4, 5};
		int[] oneNum1 = {1};
		int[] oneNum2 = {1};
		
		System.out.println(Arrays.toString(swapFirstLastNew1(numbers1)));
		System.out.println(Arrays.toString(swapFirstLastNew2(numbers1)));
		System.out.println(Arrays.toString(swapFirstLastNew1(oneNum1)));
		System.out.println(Arrays.toString(swapFirstLastNew2(oneNum1)));
		swapFirstLast(numbers2);
		swapFirstLast(oneNum2);
		System.out.println(Arrays.toString(numbers2));
		System.out.println(Arrays.toString(oneNum2));
	}
	public static void swapFirstLast(int[] arr) {
		int temp = arr[0];
		arr[0] = arr[arr.length - 1];
		arr[arr.length - 1] = temp;
	}
	
	public static int[] swapFirstLastNew1(int[] arr) {
		int[] newArr = new int[arr.length];
		newArr[0] = arr[arr.length - 1];
		newArr[arr.length - 1] = arr[0];
		if(arr.length > 2) {
			for(int i = 1; i < arr.length - 1; i++) {
				newArr[i] = arr[i];
			}
		}
		return newArr;
	}
	
	public static int[] swapFirstLastNew2(int[] arr) {
		int[] newArr = new int[arr.length];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		newArr[0] = arr[arr.length - 1];
		newArr[arr.length - 1] = arr[0];
		return newArr;
	}	
}

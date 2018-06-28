import java.util.Arrays;

public class ProductOfAllOthersInArr {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		System.out.println(Arrays.toString(prodOfArrExceptSelf(arr)));
	}
	/*
	 * Need to sultiply all the left side of an element right side
	 */
	public static int[] prodOfArrExceptSelf(int[] arr) {
		//set up arrays
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		left[0] = 1;
		right[arr.length-1] = 1;
		
		
		for(int i = 1; i < arr.length; i++) {
			left[i] = arr[i-1] * left[i-1];
		}

		for(int i = arr.length-2; i >= 0; i--) {
			right[i] = arr[i+1] * right[i+1];		
		}

		for(int i = 0; i < arr.length; i++) {
			arr[i] = left[i] * right[i];
		}
				
		return arr;
	}

}

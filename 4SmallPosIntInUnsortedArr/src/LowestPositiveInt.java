import java.util.Arrays;

public class LowestPositiveInt {
	public static int startFromNthElement = 0;
	public static void main(String[] args) {
		int[] arr2 = {0,0,0,9,2,0,3,10,4,52,0,6,0,-2,-4,1,2,123,3,4,5,6,7,8,90,0,7};
//		System.out.println(moveNegNumToLeft(arr));
//		System.out.println();
//		int[] arr2 = {1,3,7,5,2};
		System.out.println(moveNegNumToLeft2(arr2));
		System.out.println(firstMissingPositiveWithOffset(arr2,startFromNthElement));
//		System.out.println(firstMissingPositive2(arr2));

		
	}
	
	public static int firstMissingPositiveWithOffset(int[] arr, int offset) {
		for(int i = offset; i < arr.length; i++) {

			if(Math.abs(arr[i]) > arr.length-1 ) {
				System.out.println("continued");
				continue;
			}

			int indexToLookAt = Math.abs(arr[i]) -1;//we subtract 1, because index starts at 1 offset
			if(arr[indexToLookAt+offset] < 0 == false)//switch to neg if not already
				arr[indexToLookAt+offset] = -1 * arr[indexToLookAt+offset];
			System.out.println(Arrays.toString(arr));
		}
		
		for(int i = offset; i < arr.length; i++) {
			if(arr[i] > 0)
				return i+1-offset;	
		}
		return arr.length+1;
	}
	public static int firstMissingPositive2(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println("looking at" +arr[i]);

			if(Math.abs(arr[i]) > arr.length-1 ) {
				System.out.println("continued");
				continue;
			}
			System.out.println(arr[i]);
			System.out.println(Arrays.toString(arr));

			int indexToLookAt = arr[i] -1;//we subtract 1, because index starts at 1 offset
			arr[indexToLookAt] = -1 * arr[indexToLookAt];
			System.out.println(Arrays.toString(arr));

		}
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > 0)
				return i+1;	
		}
		return arr.length+1;
	}
	
	public static int firstMissingPositive(int[] A, int startFromNthElement) {
		System.out.println(Arrays.toString(A));

		int n = A.length - startFromNthElement;
	
		for (int i = 0; i < n; i++) {
			while (A[startFromNthElement+i] != i + 1) {
				if (A[startFromNthElement+i] <= 0 || A[startFromNthElement+i] >= n)
					break;
	
	            	if(A[startFromNthElement+i]==A[A[startFromNthElement+i]-1])
	                		break;
	
				int temp = A[startFromNthElement+i];
				A[startFromNthElement+i] = A[temp - 1];
				A[temp - 1] = temp;
			}
		}
		System.out.println(Arrays.toString(A));

		for (int i = startFromNthElement; i < A.length; i++){
			if (A[i] != i + 1){
				return i + 1;
			}
		}	
	
		return n + 1;
	}
	
	public static int[] moveNegNumToLeft(int[] arr) {
		int moveTo = 0;
		int findPos = 0;
		
		//find first pos number
		while (arr[findPos] >= 1 ) {
			if(findPos+1 == arr.length)
				return arr;
			findPos++;
		}
		moveTo=findPos;
		
		while(moveTo < arr.length) {
			if(arr[moveTo] < 1) {
				int temp = arr[moveTo];
				arr[moveTo] = arr[findPos];
				arr[findPos] = temp;
				
//				System.out.println(arr[moveTo] + " : "+ arr[findPos]);
//				System.out.println(Arrays.toString(arr));
				
				findPos++;
			}
			moveTo++;
		}
		
					
		System.out.println(Arrays.toString(arr));
		return arr;
	}
	public static int[] moveNegNumToLeft2(int[] arr) {
		int left = 0;
		int right = arr.length-1;
		
		while(true) {
			while(arr[left] <= 0 && left < right)//finds leftmost positive
				left++;
			while(arr[right] >= 1 && left < right)//finds rightmost negative
				right--;
			if(right == left)
				break;

			//swap
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
		}
		System.out.println(Arrays.toString(arr));
		startFromNthElement = left;
		return arr;
	}
}

public class LargestSumContiniousSubArrary {
	public static void main(String[] args) {
		int[] arr = {-2,-3,4,-1,-2,1,5,-3};
		System.out.println(largestSubarraySum(arr));
	}
	public static int largestSubarraySum(int[] arr) {
		int maxSoFar = 0;
		int maxEndingHere = 0;
		
		for(int i = 0; i<arr.length; i++) {
			System.out.println("---");

			System.out.println(maxSoFar + " " + maxEndingHere);
			//update to include curr element
			maxEndingHere = maxEndingHere + arr[i];
			System.out.println("  " + maxEndingHere);

			//if adding current element brings the sum to neg, reset 
			if(maxEndingHere < 0)
				maxEndingHere = 0;
			System.out.println("  " + maxEndingHere);

			
			//update max so far
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
			System.out.println(maxSoFar + " ");

		}		
		return maxSoFar;
	}
}

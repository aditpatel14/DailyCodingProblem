import java.util.HashSet;

public class TwoSum {

	public static void main(String[] args) {
		int[] arr = new int[] {10, 15, 3 ,7};
		int k = 17;
		
		System.out.println(lookForTwoSum(arr, k));

	}
	public static boolean lookForTwoSum(int [] arr, int k) {
		HashSet<Integer> set = new HashSet<Integer>();

		for(int i = 0; i < arr.length; i++) {
			int diff = k - arr[i];
			if(set.contains(diff)) {
				return true;
			} 
			else {
				set.add(arr[i]);
			}
		}		
		return false;
	}

}

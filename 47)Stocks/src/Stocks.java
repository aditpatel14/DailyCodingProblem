
public class Stocks {
	public static void main(String[] args) {
		int[] arr = new int[] {7,6,4,3,1};
		System.out.println(getMaxReturn(arr));
	}
	public static int getMaxReturn(int[] arr) {
		int maxReturn = 0;
		int low = arr[0];
		int high = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < low) {
				low = arr[i];
				high = low;
			}
			else if(arr[i] > low) {
				high = arr[i];
			}
			maxReturn = Math.max(maxReturn, Math.abs(low-high));
		}
		return maxReturn;
	}
}

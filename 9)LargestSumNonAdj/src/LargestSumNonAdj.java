
public class LargestSumNonAdj {
	public static void main(String[] args) {
		int[] arr = {1,2,3,14,5};
		System.out.println(incExc(arr));
	}
	
	public static int incExc(int[] arr) {
		int include = 0;
		int exclude = 0;
		for (int i = 0; i < arr.length; i++) {
			int temp = include;			
			include = Math.max( exclude + arr[i] , include);
			exclude = temp;
		}
		return include;
	}
}

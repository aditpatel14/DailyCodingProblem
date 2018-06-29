import java.util.*;
public class RGBArraySort {
	public static void main(String[] args) {
		int[] arr = new int[] {3,2,1,1,3,1,2};
		sort(arr);
	}
	
	public static void sort(int[] arr) {
		
		int startAt = 0;

		startAt = helper(arr, startAt, 1);
		System.out.println(startAt + " -----------");

		startAt = helper(arr, startAt, 2);
		System.out.println(startAt + "----------- " );

		helper(arr, startAt, 3);
		
	}
	
	public static int helper(int[] arr, int l, int lookingFor) {
		int r = arr.length-1;

		while( l < r) {
			while(arr[l] == lookingFor && l<r)//will find leftmost NOT R
				l++;
			while(arr[r] != lookingFor && l<r)//will find rightmost R
				r--;

			int temp = arr[r];
			arr[r] = arr[l];
			arr[l] = temp;
			System.out.println(l+" " + r +" " +Arrays.toString(arr));

		}
		return l;
	}
}

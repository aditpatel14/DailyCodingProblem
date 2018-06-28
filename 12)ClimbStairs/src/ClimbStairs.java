import java.util.ArrayList;
import java.util.Arrays;

public class ClimbStairs {
	public static void main(String[] args ) {
		System.out.println(count(9));
		
		ArrayList<Integer> steps = new ArrayList<Integer>();
		steps.add(1);
		steps.add(3);
		steps.add(5);

		
		genericCount(9,steps);
	}
	public static int count(int n) {
		int[] dp = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i< dp.length; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(Arrays.toString(dp));
		return dp[n];
	}
	public static int genericCount(int n, ArrayList<Integer> steps) {
		int[] dp = new int[n+1];
		dp[0] = 0;
		
		for(int i = 0; i < dp.length; i++) {
			//calculate ways to add to current index
			int sumWays = 0;
			for(int step: steps) {
				if(i - step >= 0) 
					sumWays += dp[i-step];
				if(i == step)
					sumWays++;
			}
			
			dp[i] = sumWays;

		}
		System.out.println(Arrays.toString(dp));		
		return n;
	}

}

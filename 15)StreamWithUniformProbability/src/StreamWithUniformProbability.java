import java.util.*;

public class StreamWithUniformProbability {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random ran = new Random();
		int counter = 0;
		String hold = "";

		while(true) {
			String curr = s.nextLine();
			counter++;
			if(curr.equals(""))
				break;
			System.out.println(curr);
			
			
			//update probability to 1/number of option in STREAM, replace holder if picked 
			int r = ran.nextInt(counter);
			System.out.println(r);
			if(r == counter-1) {
				hold = curr;
				System.out.println(counter + " " + hold);
			}
		}
		System.out.println(hold);
	}
}

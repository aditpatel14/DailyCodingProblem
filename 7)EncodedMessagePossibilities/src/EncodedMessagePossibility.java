import java.util.ArrayList;

/*
 * This problem was asked by Facebook.
Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.
 */
public class EncodedMessagePossibility {
	public static ArrayList<String> lis = new ArrayList<String>();

	public static void main(String[] args) {
		
		System.out.println(pos("","12",""));
		
		for(String s : lis)
			System.out.println(s);
	}
	
	public static int pos(String pre,String back, String t) {
		int count = 0;
		t+="\t";
		String str = "-"+pre+"-"+back+"-";
		if(lis.contains(str) == false)
			lis.add(str);
		System.out.println(t+"-"+pre+"-"+back+"-");

		if(back.length() == 0)
			return 0;
		
		if(back.length() >= 2) {
			int d = Integer.parseInt(back.substring(0,2));
			if( 10 <= d && d <= 26){
				count += 1 + pos(pre+back.substring(0,2),back.substring(2),t);
			}
			System.out.println(t+" count:"+count);
			System.out.println(t+" "+"yippie");

		}
		if(back.length() >= 1) {

			int b = Integer.parseInt(back.substring(0,1));
			if(b > 26)
				return 0;
			else if( 1 <= b && b <= 9) {
				count += 1 + pos(pre+back.substring(0,1),back.substring(1),t);
			}
			System.out.println(t+" count:"+count);

		}
		
		
		
		return count;
	}
}

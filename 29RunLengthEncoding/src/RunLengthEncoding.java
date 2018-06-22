
public class RunLengthEncoding {
	public static void main(String[] args) {
		String in = "AAAASDDDDDSSSSDKSSSSS";
		System.out.println(encode(in));
	}
	
	public static String encode(String input) {
		int tail = 0;
		int head = 1;
		String toReturn = "";
		while(head != input.length()) {
			if(input.charAt(head) == input.charAt(tail)) {
				head++;
			}
			else {
				toReturn = toReturn + input.charAt(tail) + (head - tail);
				tail = head;
			}
		}
		
		toReturn = toReturn + input.charAt(tail) + (head - tail);
		return toReturn;
	}
}

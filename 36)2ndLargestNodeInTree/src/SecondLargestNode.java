
public class SecondLargestNode {
	public static void main(String[] args) {
		Node n = new 
				Node(50, 
						new Node(20), 
						new Node(300,
								null, 
								new Node(400, new Node(350,null,new Node(375)),null)
						)
						
				);
		
		print2ndLargest(n);
		System.out.println(getSecondLargest(n));
	}
	
	public static int count = 2;
	public static void print2ndLargest(Node n) {	
		System.out.println("Running through the 6 Like");
			if(n.right != null)
				print2ndLargest(n.right);
			
			if(count <= 0) 
				return;
			System.out.println(n.val + " count:" + count);
			count--;
			
			if(n.left != null)
				print2ndLargest(n.left);

	}

	public static int getSecondLargest(Node n) {
		Node parent = n;
		//find rightmost parent
		while(n.right != null) {
			parent = n;
			n = n.right;
		}
		
		//if has left kid, return largest of left squad
		if(n.left != null)
			return getLargest(n.left);
		//else current parent is the 2nd largest
		return parent.val;
	}
	public static int getLargest(Node n) {
		if(n.right != null)
			return getLargest(n.right);
		return n.val;
	}
}

class Node{
	int val;
	Node left;
	Node right;
	public Node(int val, Node left, Node right) {
		super();
		this.val = val;
		this.left = left;
		this.right = right;
	}
	public Node() {
		
	}
	public Node(int val) {
		super();
		this.val = val;
		this.left = null;
		this.right = null;
	}
	
	@Override
	public String toString() {
		return "[" + val + ", " + left + ", " + right + "]";
	}
	public String str() {//Serialize
		String toRet = val+"";
		if(left != null)
			toRet += ","+left;
		else
			toRet += ",#";

		if(right != null)
			toRet += ","+right;
		else
			toRet += ",#";
		return toRet;
	}
	
}
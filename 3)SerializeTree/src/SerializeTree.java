import java.util.*;

public class SerializeTree {
	public static void main(String[] args) {
		Node n = new 
				Node(1, 
						new Node(2), 
						new Node(3,
								null, 
								new Node(4, new Node(5), new Node (6))
						)
						
				);
		System.out.println("\n"+n.toString());

//		
//		String coded = serialize(n);
//		System.out.println(coded);
//	    String[] arr = coded.split(",");
//	    Node nn = helper(arr, new int[]{0},"");
//		System.out.println("\n"+nn.toString());
//		
//		System.out.println(coded);
//	    Node nnn = deserializeTwo(arr);
//		System.out.println("\n"+nnn.toString());
			

		System.out.println(serializeLevelOrder(n));
		Node yes = deserealizeLevelOrder(serializeLevelOrder(n),0);
		System.out.println(yes.toString());
	}
	
	public static String serializeLevelOrder(Node n) {
		String s = "";
		String temp = "";
		Queue<Node> q = new LinkedList<Node>();
		q.add(n);
		
		while(!q.isEmpty()) {
			if(s.length() < temp.length() && temp.contains("[^0-9]") == false)
				break;
			
			Node curr = q.remove();
			
			if(curr == null) {
				temp+="#";
				q.add(null);
				q.add(null);
			}
			else {
				s+= temp+curr.val;
				temp = "";
				
				if(curr.left!= null)
					q.add(curr.left);
				else
					q.add(null);

				
				if(curr.right != null)
					q.add(curr.right);
				else 
					q.add(null);

			}
		}
		System.out.println(s + " "+temp);

		return s;

	}
	
//	public static int index = 0;
//	public static Node deserializeTwo(String[] arr) {		
//		if(arr[index].equals("#"))
//			return null;
//		Node n = new Node(Integer.parseInt(arr[index]));
//		index++;
//		n.left = deserializeTwo(arr);
//		index++;
//		n.right = deserializeTwo(arr);
//		return n;
//	}
	public static Node deserealizeLevelOrder(String s, int lookAt) {
		
		System.out.println(lookAt + " "+(s.charAt(lookAt)+""));
		
		if(s.charAt(lookAt) == ('#'))
			return null;
		
		String ss = s.charAt(lookAt)+"";
		int curr = Integer.parseInt(ss);
		
		Node n = new Node(curr);
		if((lookAt+1)*2 < s.length())
			n.right = deserealizeLevelOrder(s,(lookAt+1)*2);
		if((lookAt+1)*2-1 < s.length())
			n.left = deserealizeLevelOrder(s,(lookAt+1)*2-1);
		return n;
		
	}
	
	
	public static String serialize(Node root) {
	    if(root==null)
	        return null;
	 
	    Stack<Node> stack = new Stack<Node>();
	    stack.push(root);
	    StringBuilder sb = new StringBuilder();
	 
	    while(!stack.isEmpty()){
	    	Node h = stack.pop();   
	        if(h!=null){
	            sb.append(h.val+",");
	            stack.push(h.right);
	            stack.push(h.left);  
	        }else{
	            sb.append("#,");
	        }
	    }
	 
	    return sb.toString().substring(0, sb.length()-1);
	}
	 
	 //Decodes your encoded data to tree.
	/*
	 * I'm confused as to why the second solution works, since java is 
	 * passed by value how would the T get updated?
	 * 
	 * t is an array with one element. When the recursion function 
	 * changed the t inside. The t outside will be modified at the 
	 * same time. Since they share the same memory space. In another 
	 * word, the reference t inside is different from the reference t 
	 * outside, but they point to the same memory space.
	 */
	public static Node deserialize(String data) {
	    if(data == null)
	        return null;
	 
	    int[] t = {0};
	    String[] arr = data.split(",");
	 
	    return helper(arr, t,"");
	}
	 
	public static Node helper(String[] arr, int[] t, String s){
		s+="\t";

		System.out.println(s+"index: "+Arrays.toString(t)+ " : "+ arr[t[0]]);

	    if(arr[t[0]].equals("#")){
	        return null;
	    }
	 
	    Node root = new Node(Integer.parseInt(arr[t[0]]));
	 
	    t[0]=t[0]+1;
		System.out.println("updating index" + t[0]);

	    root.left = helper(arr, t,s);
	    t[0]=t[0]+1;
		System.out.println("updating index" + t[0]);

	    root.right = helper(arr, t,s);
	 
	    return root;
	}
	
	public static int index = 0;
	public static Node deserializeTwo(String[] arr) {		
		if(arr[index].equals("#"))
			return null;
		Node n = new Node(Integer.parseInt(arr[index]));
		index++;
		n.left = deserializeTwo(arr);
		index++;
		n.right = deserializeTwo(arr);
		return n;
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
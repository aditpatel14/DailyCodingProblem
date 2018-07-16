
public class EquationTree {
	public static void main(String[] args) {
		Node two = new Node("2");
		Node five = new Node("5");
		Node four = new Node("4");

		Node three = new Node("3");
		Node plus1 = new Node("+",three, two);
		Node plus2 = new Node("+",four, five);
		Node star = new Node("*", plus1, plus2);

		Node head = star;
		
		System.out.println(getEval(head));
	}
	public static int getEval(Node n) {
		if(n.val.equals("*")) {
			return getEval(n.left) * getEval(n.right);
		}
		else if(n.val.equals("+")) {
			return getEval(n.left) + getEval(n.right);
		}
		else if(n.val.equals("-")) {
			return getEval(n.left) - getEval(n.right);
		}
		else if(n.val.equals("/")) {
			return getEval(n.left) / getEval(n.right);
		}
		
		else 
			return Integer.parseInt(n.val);
	}
	
	
}
class Node{
	String val;
	Node left;
	Node right;
	public Node(String val, Node left, Node right) {
		super();
		this.val = val;
		this.left = left;
		this.right = right;
	}
	public Node(String val) {
		super();
		this.val = val;
		this.left = null;
		this.right = null;
	}
	@Override
	public String toString() {
		return "Node [val=" + val + ", left=" + left + ", right=" + right + "]";
	}
	
}

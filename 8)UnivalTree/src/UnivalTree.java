public class UnivalTree {
/*
 * A unival tree is a tree where 
 * all nodes under it have the same value.
 */
	public static void main(String[] args) {
		Node rlr = new Node(null,null,1,"rlr");
		Node rll = new Node(null,null,1,"rll");

		
		Node rl = new Node(rll,rlr,1,"rl");

		Node rr = new Node(null,null,0,"rr");
//		Node ll = new Node(null,null,4,"ll");
//		Node lr = new Node(null,null,4,"lr");

		Node r = new Node(rl,rr,0,"r");
		Node l = new Node(null,null,1,"l");
		
		Node root = new Node(l,r,0,"root");
		
		countUnivalTrees(root);
		
	}
	
	public static void countUnivalTrees(Node n) {
		
		if(n.left != null)
			countUnivalTrees(n.left);		
		if(n.right != null)
			countUnivalTrees(n.right);
		
		//if no child
		if(n.left == null && n.right == null) {
			System.out.println("yes " + n.name);
		}
		
		//if only left child 
		else if(n.left == null && n.right != null) {
			if(n.right.value == n.value) {
				System.out.println("yes "+n.name);
			}
		}
		
		//if only right child
		else if(n.left != null && n.right == null) {
			if(n.left.value == n.value) {
				System.out.println("yes "+n.name);
			}
		}
		
		//if both kids present
		else if(n.left.value == n.right.value && n.right.value == n.value) {
			System.out.println("yes "+n.name);
		}

	}
	
}

class Node{
	Node left;
	Node right;
	int value;
	String name;
	public Node(Node left, Node right, int value, String name) {
		super();
		this.left = left;
		this.right = right;
		this.value = value;
		this.name = name;
	}	
}
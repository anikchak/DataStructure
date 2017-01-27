package practice.tree;

public class TreeDiameter {

	/*
	 * Method 1: This method will give Time complexity of O(n^2)
	 * Calculate Height of Left Subtree
	 * Calculate Height of Right Subtree
	 * Calculate LeftDiameter and Right Diameter
	 * Tree Diameter = max(leftDiameter, rightDiameter, (leftHeight+rightHeight+1)) where leftHeight+rightHeight+1 = longest path through a node
	 */
	public int diameter(BinaryTreeNode n){
		if (n == null) return 0;
		int lHt = height(n.left);
		int rHt = height(n.right);
		
		int lDiameter = diameter(n.left);
		int rDiameter = diameter(n.right);
		
		int finalDiameter = Math.max((lHt+rHt+1), Math.max(lDiameter,rDiameter));
		
		return finalDiameter;
	}
	
	public int height(BinaryTreeNode n){
		if(n == null) return 0;
		int l = height(n.left);
		int r = height(n.right);
		return Math.max(l, r)+1;
	}
	/*
	 * End of method 1
	 */
	
	/*
	 * Method 2: Time complexity = O(n)
	 * In this method, instead of separately calculating height and diameter for each node's left and right subtree
	 * These values are calculated simultaneously
	 */
	class HtDia{
		int height;
		int dia;
		HtDia(int h, int d){
			this.height = h;
			this.dia = d;
		}
	}
	public HtDia diameterOpt(BinaryTreeNode node){
		if(node == null){
			HtDia hd = new HtDia(0,0);
			return hd;
		}
		
		HtDia left = diameterOpt(node.left);
		HtDia right = diameterOpt(node.right);
		
		int htMax = Math.max(left.height, right.height)+1;
		int lD = left.dia;
		int rD = right.dia;
		int nD = left.height+right.height+1;
		int finalDia = Math.max(Math.max(lD, rD), nD);
		HtDia finalHtDia = new HtDia(htMax, finalDia);
		return finalHtDia;
	}
	/*
	 * End of Method 2
	 */
	public static void main(String[] args) {
	   TreeDiameter td = new TreeDiameter();
	   
	   BinaryTreeNode node = new BinaryTreeNode(1);
	   node.left = new BinaryTreeNode(2);
	   node.right = new BinaryTreeNode(3);
	   node.left.left = new BinaryTreeNode(4);
	   node.left.right = new BinaryTreeNode(5);
	   node.left.left.left = new BinaryTreeNode(8);
	   node.left.right.left = new BinaryTreeNode(6);
	   node.left.right.left.right = new BinaryTreeNode(7);
	   
	   BinaryTreeNode n = new BinaryTreeNode(1);
	   n.left = new BinaryTreeNode(2);
	   n.right = new BinaryTreeNode(3);
	   n.left.left = new BinaryTreeNode(4);
	   n.left.left.left = new BinaryTreeNode(6);
	   n.left.left.right = new BinaryTreeNode(7);
	   n.right.right = new BinaryTreeNode(5);
	   n.right.right.left = new BinaryTreeNode(8);
	   
	   System.out.println("Diameter for Node tree = "+td.diameter(node));
	   System.out.println("Diameter for n tree = "+td.diameter(n));
	   
	   System.out.println("\nOptimised Diameter Finding method");
	   HtDia h1 = td.diameterOpt(node);
	   HtDia h2 = td.diameterOpt(n);
	   System.out.println("Diameter Opt for node = "+h1.dia);
	   System.out.println("Diameter Opt for n = "+h2.dia);
	}

}

package danyu.leetcode;

public class BalancedBTree {

	/*Given a binary tree, determine if it is height-balanced.
	For this problem, a height-balanced binary tree is defined 
	as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.*/
	
	  //Definition for binary tree
	  public class TreeNode {
	     int val;
	      TreeNode left;
	      TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 
	public boolean isBalanced(TreeNode root) {
        if(root==null)return false;
        return isSubTreeBalanced(root.left) && isSubTreeBalanced(root.right) && Math.abs(level(root.left)-level(root.right))<=1;
    }
	
	public boolean isSubTreeBalanced(TreeNode root){
		if(root==null) return true;
		return Math.abs(level(root.left)-level(root.right))<=1;
	}
	
	public int level(TreeNode root){
		if(root==null) return 0;
		return Math.max(level(root.left),level(root.right))+1;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BalancedBTree bbt=new BalancedBTree();
		BalancedBTree.TreeNode  treeNode =  bbt.new TreeNode(6);
		treeNode.left=bbt.new TreeNode(6);
		treeNode.left.left=bbt.new TreeNode(6);
		
		System.out.print(bbt.isBalanced(treeNode));
	}

}


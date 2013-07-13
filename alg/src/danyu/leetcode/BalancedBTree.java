package danyu.leetcode;

/*Did not pass the large case yet because of performance*/
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
	  
	boolean isStop=false; 
	public boolean isBalanced(TreeNode root) {
		isStop=false;
        return isSubtreeBalanced(root);
    }
	
	public boolean isSubtreeBalanced(TreeNode root){
		if(isStop==true) {return false;}
        if(root==null)return true;
        isStop= !(isSubtreeBalanced(root.left)&& isSubtreeBalanced(root.right)&& Math.abs(depth(root.left)-depth(root.right))<=1);
        return !isStop;
	}
	
	public int depth(TreeNode root){
		if(root==null) return 0;
		return Math.max(depth(root.left),depth(root.right))+1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BalancedBTree bbt=new BalancedBTree();
		BalancedBTree.TreeNode  treeNode =  bbt.new TreeNode(1);
		treeNode.left=bbt.new TreeNode(2);
		treeNode.left.left=bbt.new TreeNode(4);
		treeNode.left.right=bbt.new TreeNode(5);
		treeNode.left.left.left=bbt.new TreeNode(7);
		treeNode.right=bbt.new TreeNode(3);
		treeNode.right.right=bbt.new TreeNode(6);
		treeNode.right.right.right=bbt.new TreeNode(8);
//		treeNode.right.left=bbt.new TreeNode(6);
//		treeNode.right.left.left=bbt.new TreeNode(6);
		
		System.out.println(bbt.isBalanced(treeNode));
		//System.out.println(bbt.maxDepth(treeNode.left)+", "+bbt.maxDepth(treeNode));
	}

}


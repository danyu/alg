/**
 * 
 */
package danyu.leetcode;

import danyu.leetcode.BalancedBTree.TreeNode;

/**
 * @author danyu
 *
 */
public class SortedAry2BST {

	// Definition for binary tree
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode sortedArrayToBST(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num == null)
			return null;
		if (num.length == 0)
			return null;
		int n = num.length;
        
		TreeNode root=null;
		root=insert(num,0,n-1);//left sub tree
		return root;
	}

	public TreeNode insert(int[] num,int start, int end) {
		if(start>end) return null ;
		int mid = (int) (start+end) / 2;
		TreeNode root=new TreeNode(num[mid]);
		root.left=insert(num,start,mid-1);//left sub tree
		root.right=insert(num,mid+1,end);//right sub tree
		return root;
	}
	
	public void print(TreeNode tn){
		
	    if(tn==null) {System.out.print("# ");return;}
	    
		print(tn.left);
		System.out.print(tn.val);
	    print(tn.right);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] num={1,2,3,4,5,6};
        SortedAry2BST case1=new SortedAry2BST();
        TreeNode tn= case1.sortedArrayToBST(num);
        case1.print(tn.right);
        case1.print(tn.left);
        
	}

}

/**
 * 
 */
package danyu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author dyou
 * 
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 *      [2],
 *      [3,4],
 *      [6,5,7],
 *      [4,1,8,3]
 *  ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 */
public class Triangle {

	int[] result;//extra n space for saving result to avoid duplicated calculation
	
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {	
		int layer=triangle.size();
		int total =(layer)*(layer+1)/2;
		result=new int[total];
		for(int i=0;i<total;i++) result[i]=-1;
		
		return findMinSum(0,0,triangle.size()-1,triangle);
    }
	
	//Recursive
	public int findMinSum(
			int level, 
			int pos,
			int maxlevel,
			ArrayList<ArrayList<Integer>> triangle) {

		int val = triangle.get(level).get(pos).intValue(), left = 0, right = 0;
		if (level >= maxlevel)
			return val;
		
		int index_left_child=-1;
		int index_right_child=-1;
		if (level + 1 <= maxlevel) {
			 index_left_child=index(level + 1, pos);
			 index_right_child=index(level+1,pos+1);
			if (result[index_left_child] == -1)
				result[index_left_child] = findMinSum(level + 1, pos,
						maxlevel, triangle);

			if (result[index_right_child] == -1)
				result[index_right_child] = findMinSum(level + 1,
						pos + 1, maxlevel, triangle);
			left=result[index_left_child];
		    right=result[index_right_child];
		}
			
		return val + (left > right ? right : left);
	}
	
	public int index(int level,int pos){return level*(level+1)/2+pos;}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Define a test case.
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>() {
			{
				add(new ArrayList<Integer>(Arrays.asList(2)));
				add(new ArrayList<Integer>(Arrays.asList(3,4)));
				add(new ArrayList<Integer>(Arrays.asList(6,5,7)));
				add(new ArrayList<Integer>(Arrays.asList(4,1,8,3)));
			}
		}; // new ArrayList<ArrayList<Integer>>();
		
		System.out.print(new Triangle().minimumTotal(triangle));
		
	}

}

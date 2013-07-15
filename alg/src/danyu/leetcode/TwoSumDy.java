/**
 * 
 */
package danyu.leetcode;

import java.lang.reflect.Array;

/**
 * @author danyu
 * 
 * Find pairs of num whose summation is n. 
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 */

public class TwoSumDy {

	public int[] twoSum(int[] numbers, int target) {
      
		int[] sortedIndex=sort(numbers);
		int head=0,tail=numbers.length-1, sum=0;
		while(head<tail){
			sum=numbers[head]+numbers[tail];
			if(sum>target)				tail--;
			else if(sum<target)				head++;
			else				break;
		}
		return new int[]{Math.min(sortedIndex[head]+1,sortedIndex[tail]+1),Math.max(sortedIndex[head]+1,sortedIndex[tail]+1)};
	}

	// do insertion sort to return re-organized index of sorted array
	public int[] sort(int[] num) {
		int[] sortedIndex=new int[num.length];
		
		for(int i=0;i<sortedIndex.length;i++){
		    sortedIndex[i]=i;
		}
		int sorted = 0, next = 1, cur;
		for (sorted = 0; sorted < num.length - 1; sorted++) {
			next = num[sorted + 1];
			for (cur = sorted + 1; cur > 0; cur--) {
				if (next < num[cur - 1]) {
					num[cur] = num[cur - 1];
					sortedIndex[cur] = sortedIndex[cur - 1];
				} else
					break;//find the position
			}
			num[cur] = next;
			sortedIndex[cur] = sorted+1;
		}
		return sortedIndex;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int result[]= new TwoSumDy().twoSum(new int[]{5,75,25},100);
        
        
	}

}

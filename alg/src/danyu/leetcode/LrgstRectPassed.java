package danyu.leetcode;


/**
 * Find the biggest internal rectangle of a histogram
 * 
 *  |         _   _
 *  |        | |_| |
 *  |     _  |     |_ _ _ _ _ _
 *  |   _| |_|/ / / / / / / / /|_ _
 *  | _|_ _ _ / / / / / / / / / _ _|_
 *      1 2 1 4 3 4 2 2 2 2 2 2 1 1 
 * In this example, the shadowed area is the result.
 * 
 * Algorithm(n^2):
 * Each value is checked to find the longest rectangle with the same height.
 * Store the area, and replace it when larger one is met.
 * 
 * Time Complexity=(n^2)
 * 
 * */
public class LrgstRectPassed {

	public int doIt(int[] height){
		int maxRect=0;
	    int tempStart=0,tempEnd=0,tempMax=0;  
	    
	    //O(n)
		for(int i=0;i<height.length;i++){
			//System.out.println( "Check "+i+":"+height[i]);
			
			tempStart=i;
			tempEnd=i;
			tempMax=i;//this is introduced for  
			
			// looking for start point
			// |<---------------------
			for (int m = i - 1; m >= 0; m--) {
				if (height[m] < height[i]) {//meet smaller height,
					tempStart = m + 1;//one step back,
					break;//and ends
				} else {// meet greater height
					tempStart = m;
					if (height[tempMax] < height[m]) tempMax = m;
				}
			}
			
			//looking for end point
			// ------------------------>|
			// O(n)
			for (int m = i + 1; m < height.length; m++) {
				if (height[m] < height[i]) {//meet smaller height
					tempEnd = m-1;
					break;
				}else	{
					tempEnd=m;
					if(height[tempMax]< height[m]) tempMax=m ;
				}
			}
					
			// new bigger rectangle is found, then update
			int s = height[i] * (tempEnd - tempStart + 1);
			if (s > maxRect)
				maxRect = s;

			// ***Important improvement: check if it is a same-height area
			// if i marks the maximum height, it means that it is a same-height
			// area,
			// then jump to the end of the same-height are.
			if (i == tempMax)
				i = tempEnd;

		}
		
		return maxRect;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//         new BiggestHistogram().doIt(new int[]{5,4,4,
//        		 4,4,4,
//        		 4,4,4,
//        		 4,4,4,
//        		 4,4,4});
       System.out.println( new LrgstRectPassed().doIt(new int[]{1,2,1,4,3,4,2,2,2,2,2,2,1,1}));
         
	}

}

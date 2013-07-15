package danyu.leetcode;

public class InterleaveString {

	public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		if((s1.length()+s2.length())!=s3.length()) return false;
		if(s1.length()==0) return s2==s3;
		if(s2.length()==0) return s1==s3;
        boolean result=true;
		int iS1=0,iS2=0;
        while(result && iS1<s1.length() && iS2<s2.length() ){
        	//result=false;
		     char charNext= s3.charAt(iS1+iS2);
		     if(charNext==s1.charAt(iS1)) {iS1++;}
		     else if(charNext==s2.charAt(iS2)){iS2++;}
		     else {result=false;break;}
		}
        
        if (!result) {
        	result=true;
        	iS1=0;iS2=0;
        	while(result && iS1<s1.length() && iS2<s2.length() ){
            	//result=false;
    		     char charNext= s3.charAt(iS1+iS2);
    		     if(charNext==s2.charAt(iS2)){iS2++;}
    		     else if(charNext==s1.charAt(iS1)) {iS1++;} 
    		     else {result=false;break;}
    		}
        }
		
		return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean result=new InterleaveString().isInterleave("a", "", "a");
		return;
	}

}

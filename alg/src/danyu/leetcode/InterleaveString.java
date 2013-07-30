package danyu.leetcode;

import java.util.ArrayList;

public class InterleaveString {

	public boolean isInterleave(String s1, String s2, String s3) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (s1 == null)
			return s2 == s3;
		if (s2 == null)
			return s1 == s3;

		if ((s1.length() + s2.length()) != s3.length())
			return false;
		if (s1.length() == 0)
			return s2 == s3;
		if (s2.length() == 0)
			return s1 == s3;

		int iS1 = 0, iS2 = 0, iS3 = 0;

		StringBuilder copy = new StringBuilder(s3);
		int offset = 0;
		ArrayList<String> alts = new ArrayList<String>();
		// Check s1,then s2
		while (iS1 < s1.length() && iS3 < s3.length()) {
			// result=false;
			if (s3.charAt(iS3) == s1.charAt(iS1)) {
				copy = copy.delete(iS3 - offset, iS3 - offset + 1);
				iS1++;
				offset++;
			}
			iS3++;
		}
		if (iS1 != s1.length())
			return false;
		if (copy.substring(0).equals(s2))
			return true;

		// Check s2, then s1
		iS3 = 0;
		offset = 0;
		copy = new StringBuilder(s3);
		while (iS2 < s2.length() && iS3 < s3.length()) {
			// result=false;
			if (s3.charAt(iS3) == s2.charAt(iS2)) {
				copy = copy.delete(iS3 - offset, iS3 - offset + 1);
				iS2++;
				offset++;
			}
			iS3++;
		}
		if (iS2 != s2.length())
			return false;
		if (copy.substring(0).equals(s1))
			return true;

		return false;
	}

	public boolean bruteForce(String s1, String s2, String s3) {

		for (int i = 0; i < s1.length(); i++) {

			for (int j = 0; j < s2.length(); j++) {
				// s1.substring(i,)
			}
		}

		return false;
	}

	public boolean generate(String s1, String s2, String s3) {
		String aInstance = "";

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean result = new InterleaveString().isInterleave("", "def", "def");
		return;
	}

}

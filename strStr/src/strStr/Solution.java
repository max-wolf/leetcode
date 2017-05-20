package strStr;

public class Solution {
	 public int strStr(String haystack, String needle) {
		 int len1 = haystack.length();
		 int len2 = needle.length();
		 if(len2==0) return 0;
		 for(int i=0; ; i++) {
			 for(int j=0; ; j++) {
				 if(j==len2) return i;
				 if(i+j==len1) return -1;
				 if(needle.charAt(j)==haystack.charAt(i+j)) {
					 continue;
				 } else {
					 break;
				 }
			 }
		 }
	 }
}

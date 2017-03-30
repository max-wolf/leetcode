
public class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(n <= k || n == 0) return "0";
        while(k > 0) {
            if(num.charAt(1) == '0') {
                int count = 1;
                while(count < num.length()-1 && num.charAt(count) == '0')
                    count++;
                num = num.substring(count);
            } else {
                int i = 0;
                while (i < num.length() - 1 && num.charAt(i) <= num.charAt(i+1)) i++;
                num = num.substring(0, i) + num.substring(i+1);
            }
            k--;
        }
        return num;
    }
}

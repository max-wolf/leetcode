import java.util.Scanner;
import static java.lang.Math.pow;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        //long a=System.currentTimeMillis();
        System.out.println(new Solution().MyAtio(input));
        //long b=System.currentTimeMillis();
        //System.out.println(b-a);
    }

    public int MyAtio(String str) {
        if (str.isEmpty()) return 0;
        char[] num = new char[100];
        int i, j = 0;
        int one = 1;
        long result = 0;
        int str_len = str.length();
        for (i = 0; i < str_len; ++i) {
            char str_i = str.charAt(i);
            if (str_i == ' ') {
                continue;
            } else {
                break;
            }
        }
        if (i == str.length()) return 0;
        String str_nonspace = str.substring(i, str.length());
        char strnon_0 = str_nonspace.charAt(0);
        if (!(strnon_0 >= '0' && strnon_0 <= '9') && strnon_0 != '+' && strnon_0 != '-') return 0;
        int strnon_len = str_nonspace.length();
        if (strnon_0 != '+' && strnon_0 != '-') {
            for (i = 0; i < strnon_len; ++i) {
                char strnon_i = str_nonspace.charAt(i);
                if (!(strnon_i >= '0' && strnon_i <= '9')) break;
                num[i] = strnon_i;
            }
            j = i;
        } else if (strnon_0 == '-') {
            one = -1;
            int q = 0;
            for (i = 1; i < strnon_len; ++i) {
                char strnon_i = str_nonspace.charAt(i);
                if (!(strnon_i >= '0' && strnon_i <= '9')) break;
                num[q] = strnon_i;
                q++;
            }
            j = q;
        } else if (strnon_0 == '+') {
            one = 1;
            int q = 0;
            for (i = 1; i < strnon_len; ++i) {
                char strnon_i = str_nonspace.charAt(i);
                if (!(strnon_i >= '0' && strnon_i <= '9')) break;
                num[q] = strnon_i;
                q++;
            }
            j = q;
        }
        int w = j;
        int ss;
        for (i = 0; i < w; ++i) {
            ss = (int) pow(10, j - 1);
            result = (num[i] - '0') * ss + result;
            j--;
        }
        long re = one * result;
        if (re > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (re < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) re;
    }
}

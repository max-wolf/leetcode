
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        String val = new String();
        if(s.length() < 4 || s.length() > 12)
            return res;
        recursion(s, val, res, 0);
        return res;
    }

    boolean isValid(String s) {
        if(s.charAt(0) == '0')
            return s.equals("0");
        int num = Integer.parseInt(s);
        if(num > 0 && num <= 255)
            return true;
        else
            return false;
    }

    void recursion(String s, String val, List<String> res, int dot) {
        if(dot == 3 && isValid(s)) {
            res.add(val + s);
            return;
        } else if(dot == 3 && !isValid(s)) {
            return;
        }
        for(int i = 0; i < 3 && i < s.length() - 1; i++) {
            String substr = s.substring(0, i+1);
            if(isValid(substr))
                recursion(s.substring(i+1, s.length()), val + substr + ".", res, dot+1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.restoreIpAddresses("0000");
    }
}

import java.util.*;

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid.
//The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
public class Solution {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        int len = s.length();
        if(len == 0 || len == 1) return false;
        char c, top;
        for(int i = 0; i < len; ++i) {
            c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') stack.push(c);
            else if(c == ')') {
                if(stack.empty()) return false;
                top = stack.pop().toString().charAt(0);
                if(top != '(') return false;
            }
            else if(c == ']') {
                if(stack.empty()) return false;
                top = stack.pop().toString().charAt(0);
                if(top != '[') return false;
            }
            else if(c == '}') {
                if(stack.empty()) return false;
                top = stack.pop().toString().charAt(0);
                if(top != '{') return false;
            }
            else return false;
        }
        if(stack.empty()) return true;
        else return false;
    }
}

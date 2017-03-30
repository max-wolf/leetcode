
//Determine whether an integer is a palindrome. Do this without extra space.
/*
    conditions: without extra space;negative is not palindrome;
    reverse may cause overflow
    1. reverse half
*/
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;    //110
        int t = 0;
        while (t < x) {
            t = t * 10 + x % 10;
            x /= 10;
        }
        if (t > x) {
            return t / 10 == x;
        } else return t == x;
    }
}

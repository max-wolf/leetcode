
//Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
// n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
// Find two lines, which together with x-axis forms a container,
// such that the container contains the most water.
/*
    1.brute force
    2.choose two pointers, points left and right. Every time move one of them to middle.
    Intuition: as we move any pointer further, the length of the next rectangle decreases,
        so the height needs to increase as to result in a larger area.
    Assertion: By moving shorter end pointer further doesn't eliminate the final answer
        (with two ends at maxi, maxj respectively) in our process
*/
public class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = Math.min(height[l], height[r]) * (r - l);
        int tmp;
        while (l < r){
            if(height[l] < height[r]){
                l++;
                tmp = Math.min(height[l], height[r]) * (r - l);
                if(tmp > max) max = tmp;
            }
            else {
                r--;
                tmp = Math.min(height[l], height[r]) * (r - l);
                if(tmp > max) max = tmp;
            }
        }
        return max;
    }
}

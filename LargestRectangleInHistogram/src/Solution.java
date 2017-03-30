import java.util.Stack;

public class Solution {
    static int largestRectangleArea(int[] heights) {
        int result = 0;
        int size = heights.length;
        Stack<Integer> sk = new Stack<>();
        for(int i = 0; i < size; i++) {
            if(sk.empty() || sk.peek() <= heights[i]) {
                sk.push(heights[i]);
            } else {
                int count = 1;
                while(!sk.empty() && sk.peek() > heights[i]) {
                    int tmp_height = sk.pop();
                    result = Math.max(result, tmp_height * count);
                    count++;
                }
                while(count > 1) {
                    sk.push(heights[i]);
                    count--;
                }
                sk.push(heights[i]);
            }
        }
        int count = 1;
        while(!sk.empty()) {
            int tmp_height = sk.pop();
            result = Math.max(result, tmp_height * count);
            count++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] h = {2,1,2};
        int res = largestRectangleArea(h);
    }
}

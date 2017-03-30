import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int[] histogram = new int[column];
        int maxarea = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(matrix[i][j] == '1') {
                    histogram[j] += 1;
                } else {
                    histogram[j] = 0;
                }
            }
            maxarea = Math.max(maxarea, largestRectangleArea(histogram));
        }
        return maxarea;
    }
    int largestRectangleArea(int[] heights) {
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
}

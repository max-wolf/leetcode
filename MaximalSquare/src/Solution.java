
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int max = 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        for(int i = 0; i < row; i++) {
            if(matrix[i][0] == '1') {
                dp[i][0] = 1;
                max = 1;
            }
        }
        for(int i = 0; i < column; i++) {
            if(matrix[0][i] == '1') {
                dp[0][i] = 1;
                max = 1;
            }
        }
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < column; j++) {
                if(matrix[i][j] == '0') dp[i][j] = 0;
                else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}

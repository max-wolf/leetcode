
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int m = 0, n = column - 1;
        if(matrix == null || row < 1 || column < 1) return false;
        while (m <= row - 1 && n >= 0) {
            if(target < matrix[m][n]) {
                n--;
            } else if(target > matrix[m][n]) {
                m++;
            } else return true;
        }
        return false;
    }
}

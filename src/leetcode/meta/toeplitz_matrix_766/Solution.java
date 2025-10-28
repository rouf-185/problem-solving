package leetcode.meta.toeplitz_matrix_766;

public class Solution {
    private boolean checkDiagonal(int x, int y, int[][] matrix) {
        int item = matrix[x][y];
        while(x < matrix.length && y < matrix[0].length) {
            if(matrix[x++][y++] != item) return false;
        }
        return true;
    }
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int j = 0; j < matrix[0].length; j++) {
            if(!checkDiagonal(0, j, matrix)) return false;
        }
        for(int i = 1; i < matrix.length; i++) {
            if(!checkDiagonal(i, 0, matrix)) return false;
        }
        return true;
    }
}
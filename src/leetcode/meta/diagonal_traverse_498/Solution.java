package leetcode.meta.diagonal_traverse_498;

public class Solution {
    private List<Integer> getDiagonal(int x, int y, int[][] mat) {
        List<Integer> diag = new ArrayList<>();
        while(x >= 0 && y < mat[0].length) {
            diag.add(mat[x--][y++]);
        }
        return diag;
    }
    public int[] findDiagonalOrder(int[][] mat) {
        List<Integer> result = new ArrayList<>();
        boolean doReverse = false;
        int idx = 0;
        for(int i = 0; i < mat.length; i++) {
            List<Integer> diag = getDiagonal(i, 0, mat);
            if(doReverse) {
                Collections.reverse(diag);
            }
            result.addAll(diag);
            doReverse = (!doReverse);
        }
        for(int i = 1; i < mat[0].length; i++) {
            List<Integer> diag = getDiagonal(mat.length - 1, i, mat);
            if(doReverse) {
                Collections.reverse(diag);
            }
            result.addAll(diag);
            doReverse = (!doReverse);
        }
        
        int[] ans = new int[result.size()];
        for(int i = 0; i < ans.length; i++) ans[i] = result.get(i);
        return ans;
    }
}

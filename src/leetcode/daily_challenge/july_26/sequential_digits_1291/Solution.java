package leetcode.daily_challenge.july_26.sequential_digits_1291;

public class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String str = "123456789";
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            for(int j = i + 1; j < 9; j++) {
                int num = Integer.parseInt(str.substring(i, j + 1));
                if(num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}

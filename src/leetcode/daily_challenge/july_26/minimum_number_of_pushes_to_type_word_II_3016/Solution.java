package leetcode.daily_challenge.july_26.minimum_number_of_pushes_to_type_word_II_301;

public class Solution {
    public int minimumPushes(String word) {
        Integer[][] count = new Integer[26][2];
        for(int i = 0; i < 26; i++) { count[i][0] = i; count[i][1] = 0;}
        for(char c : word.toCharArray()) count[((int)(c - 'a'))][1]++;
        Arrays.sort(count, (a, b) -> (b[1] - a[1]));
        int ans = 0;
        int weight = 0;
        for(int i = 0; i < 26; i++) {
            if(count[i][1] == 0) break;
            if(i % 8 == 0) {
                weight++;
            }
            ans += weight * count[i][1];
        }   
        return ans;
    }
}


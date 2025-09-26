package leetcode.daily_challenge.september_25.vowels_game_in_a_string_12;
import java.util.*;
public class Solution {
    public boolean doesAliceWin(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList(new Character[]{'a', 'e', 'i', 'o', 'u'}));
        for(char c : s.toCharArray()) {
            if(set.contains(c)) {
                return true;
            }
        }
        return false;
    }
}
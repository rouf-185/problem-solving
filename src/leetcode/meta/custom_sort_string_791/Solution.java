package leetcode.meta.custom_sort_string_791;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class Solution {
    public String customSortString(String order, String s) {
        Map<Integer, Integer> pairs = new HashMap<>();
        for(int i = 0; i < order.length(); i++) {
            pairs.put((int)(order.charAt(i) - 'a'), i);
        }
        int k = order.length();
        for(int i = 0; i < 26; i++) {
            if(!pairs.containsKey(i)) pairs.put(i, k++);
        }
        Integer[] newString = new Integer[s.length()];
        for(int i = 0; i < newString.length; i++) {
            newString[i] = (Integer) (s.charAt(i) - 'a');
        }
        Arrays.sort(newString, (a, b) -> (pairs.get(a) - pairs.get(b)));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < newString.length; i++) {
            sb.append((char) ('a' + newString[i]));
        }
        return sb.toString();
    }
}
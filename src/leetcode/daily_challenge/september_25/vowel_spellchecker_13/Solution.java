package leetcode.daily_challenge.september_25.vowel_spellchecker_13;

import java.util.*;
public class Solution {
    private String convertVowelInsensitive(String str) {
        Set<Character> vowels = new HashSet<>(Arrays.asList(new Character[]{'a', 'i', 'e', 'o', 'u'}));
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()) {
            if(vowels.contains(c)) {
                sb.append('a');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactMatches = new HashSet<>();
        Map<String, String> caseInsensitiveMatches = new HashMap<>();
        Map<String, String> vowelInsensitiveMatches = new HashMap<>();
        for(String query : wordlist) {
            exactMatches.add(query);
            String lowercase = query.toLowerCase();
            if(!caseInsensitiveMatches.containsKey(lowercase)) {
                caseInsensitiveMatches.put(lowercase, query);
            }
            String vowelInsen = convertVowelInsensitive(lowercase);
            if(!vowelInsensitiveMatches.containsKey(vowelInsen)) {
                vowelInsensitiveMatches.put(vowelInsen, query);
            }
        }
        String[] ans = new String[queries.length];
        int idx = 0;
        for(String query : queries) {
            if(exactMatches.contains(query)) {
                ans[idx++] = query;
                continue;
            }
            String lowercase = query.toLowerCase();
            if(caseInsensitiveMatches.containsKey(lowercase)) {
                ans[idx++] = caseInsensitiveMatches.get(lowercase);
                continue;
            }
            String vIns = convertVowelInsensitive(lowercase);
            if(vowelInsensitiveMatches.containsKey(vIns)) {
                ans[idx++] = vowelInsensitiveMatches.get(vIns);
                continue;
            }
            ans[idx++] = "";
        }
        return ans;
    }
}
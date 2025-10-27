package leetcode.meta.merge_account_721;
import java.util.*;
public class Solution {
    private void dfs(String email, Map<String, Set<String>> map, Set<String> visited, List<String> cc) {
        if(visited.contains(email)) {
            return;
        }
        visited.add(email);
        cc.add(email);
        for(String nei : map.get(email)) {
            dfs(nei, map, visited, cc);
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, String> name = new HashMap<>();
        for(List<String> account : accounts) {
            String nam = account.get(0);
            String firstEmail = account.get(1);
            name.put(firstEmail, nam);
            if(!map.containsKey(firstEmail)) map.put(firstEmail, new HashSet<>());
            for(int i = 2; i < account.size(); i++) {
                String email = account.get(i);
                if(!map.containsKey(email)) {
                    map.put(email, new HashSet<>());
                }
                map.get(firstEmail).add(email);
                map.get(email).add(firstEmail);
                name.put(email, nam);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for(String key : map.keySet()) {
            if(!visited.contains(key)) {
                List<String> mergedAccount = new ArrayList<>();
                String nam = name.get(key);
                dfs(key, map, visited, mergedAccount);
                Collections.sort(mergedAccount);
                List<String> mergedAccountWithName = new ArrayList<>();
                mergedAccountWithName.add(nam);
                mergedAccountWithName.addAll(mergedAccount);
                ans.add(mergedAccountWithName);
            }
        }
        
        Collections.sort(ans, (a, b) -> a.get(0).compareTo(b.get(0)));
        return ans;
        
    }
}

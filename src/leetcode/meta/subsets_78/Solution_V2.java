package leetcode.meta.subsets_78;

public class Solution_V2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for(int n : nums) {
            List<List<Integer>> additionalSuperset = new ArrayList<>();
            for(List<Integer> list : ans) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(n);
                additionalSuperset.add(newList);
            }
            ans.addAll(additionalSuperset);
        }
        return ans;
    }
}

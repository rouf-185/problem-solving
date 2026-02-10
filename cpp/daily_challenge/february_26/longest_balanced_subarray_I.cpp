#include <iostream>
#include <bits\c++.h>

class Solution {
public:
    int longestBalanced(vector<int>& nums) {
        int ans = 0;
        for(int i = 0; i < nums.size(); i++) {
            unordered_set<int> u_set;
            int evenCount = 0;
            int oddCount = 0;
            int totalCount = 0;
            for(int j = i; j < nums.size(); j++) {
                if(u_set.count(nums[j]) == 0) {
                    if(nums[j] % 2 == 0) {
                        evenCount++;
                    } else {
                        oddCount++;
                    }
                }
                u_set.insert(nums[j]);
                totalCount++;
                if(evenCount == oddCount) {
                    ans = max(ans, totalCount);
                }
            }
        } 
        return ans;
    }
};

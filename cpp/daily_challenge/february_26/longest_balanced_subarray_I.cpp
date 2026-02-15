#include <iostream>
#include <bits/stdc++.h>

class Solution {
public:
    int longestBalanced(vector<int>& nums) {
        int result = 0;
        for(int i = 0; i < nums.size(); i++) {
            unordered_set<int> distinct;
            int odd = 0;
            int even = 0;
            for(int j = i; j < nums.size(); j++) {
                if(distinct.count(nums[j]) == 0) {
                    distinct.insert(nums[j]);
                    odd += nums[j] % 2;
                    even += nums[j] % 2 == 0 ? 1 : 0;
                }
                if(even == odd) result = max(result, j - i + 1);
            }
        }
        return result;
    }
};

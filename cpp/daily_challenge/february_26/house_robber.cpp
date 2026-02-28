#include<iostream>
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size() == 1) {
            return nums[0];
        }
        int prev = nums[0];
        int current = max(nums[1], nums[0]);
        for(int i = 2; i < nums.size(); i++) {
            int newCurrent = max(current, prev + nums[i]);
            prev = current;
            current = newCurrent;
        }
        return current;
    }
};

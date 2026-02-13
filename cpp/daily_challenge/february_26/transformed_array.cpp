#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> constructTransformedArray(vector<int>& nums) {
        vector<int> result(nums.size(), 0);
        for(int i = 0; i < nums.size(); i++) {
            if(nums[i] == 0) {
                result[i] = nums[i];
            } else if(nums[i] > 0) {
                result[i] = nums[(i + nums[i]) % nums.size()];
            } else {
                result[i] = nums[(nums.size() + (i - abs(nums[i])%nums.size()))% nums.size()];
            }
            // formula 
            // (len + (i - leftShift%len))%len
        }
        return result;
    }
};

#include <iostream>
#include <bits\c++.h>
using namespace std;

class Solution {
public:
    int minRemoval(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int ans = n;
        int left = 0;
        int right = 0;
        while(right < n) {
            while(right < n && static_cast<long long>(nums[left]) * static_cast<long long>(k) >= static_cast<long long>(nums[right])) {
                right++;
            }
            ans = min(ans, n - (right - left));
            left++;
        }
        return ans;
    }
};

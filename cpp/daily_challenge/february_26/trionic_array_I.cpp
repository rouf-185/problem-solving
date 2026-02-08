#include <iostream>
#include <bits\c++.h>
using namespace std;

class Solution {
public:
    bool isTrionic(vector<int>& nums) {
        if(nums.size() <= 3) {
            return false;
        }
        if(nums[1] <= nums[0]) {
            return false;
        }
        int changeHappened = 0;
        bool isIncreasing = true;
        for(int i = 1; i < nums.size(); i++) {
            if(isIncreasing) {
                if(nums[i] > nums[i - 1]) continue;
                else if(nums[i] == nums[i - 1]) return false;
                else {
                    isIncreasing ^= true;
                    changeHappened++;
                }
            } else {
                if(nums[i] < nums[i - 1]) continue;
                else if(nums[i] == nums[i - 1]) return false;
                else {
                    isIncreasing ^= true;
                    changeHappened++;
                }
            }
        }
        return changeHappened == 2;
    }
};

#include<iostream>
#inlcude<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int binaryGap(int n) {
        int maxCount = 0;
        int j = 0;
        int prevOnePos = -1;
        while(n > 0) {
            if(n % 2 == 1) {
                if(prevOnePos != -1) {
                    maxCount = max(maxCount, j - prevOnePos);
                }
                prevOnePos = j; 
            }
            n /= 2;
            j++;
        }
        return maxCount;
    }
};

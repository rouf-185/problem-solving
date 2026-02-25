#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int setBitCount(int n) {
        int count = 0;
        while(n > 0) {
            count += (n % 2);
            n /= 2;
        }
        return count;
    }
    vector<int> sortByBits(vector<int>& arr) {
        sort(arr.begin(), arr.end(), [this](int a, int b) {
            int aCount = setBitCount(a);
            int bCount = setBitCount(b);
            if(aCount == bCount) {
                return a < b;
            } else {
                return aCount < bCount;
            }
        });
        return arr;
    }
};

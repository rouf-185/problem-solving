#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool hasAlternatingBits(int n) {
        vector<int> bits;
        while(n > 0) {
            bits.push_back(n % 2);
            n /= 2;
        }
        for(int i = 1; i < bits.size(); i++) {
            if(bits[i] == bits[i - 1]) {
                return false;
            }
        }
        return true;
    }
};

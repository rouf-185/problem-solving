#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool checkOnesSegment(string s) {
        char currentBit = s[0];
        bool setBitStarted = (currentBit == '1');
        for(int i = 1; i < s.size(); i++) {
            if(s[i - 1] == '0' && s[i] == '1') {
                if(setBitStarted) {
                    return false;
                } else {
                    setBitStarted = true;
                }
            }
        }
        if(setBitStarted) {
            return true;
        } else {
            return false;
        }
    }
};

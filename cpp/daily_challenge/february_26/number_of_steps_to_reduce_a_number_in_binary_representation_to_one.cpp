#include<iostream>
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int numSteps(string s) {
        int stepCount = 0;
        int sLen = s.size();
        int carry = 0;
        for(int i = sLen - 1; i >= 0; i--) {
            if(i == 0) {
                if((carry + 1) % 2 == 0) {
                    stepCount++;
                }
                break;
            }
            int bit = ((s[i] - '0') + carry) % 2;
            carry = ((s[i] - '0') + carry) / 2;
            if(bit == 1) {
                stepCount += 2;
                carry++;
            } else {
                stepCount++;
            }
        }
        return stepCount;
    }
};

class SolutionV0 {
public:
    string addOne(string s) {
        int carry = 1;
        int sLen = s.size();
        for(int i = sLen - 1; i >= 0; i--) {
            int currentBit = s[i] - '0';
            s[i] = static_cast<char>('0' + ((currentBit + carry) % 2));
            carry = (currentBit + carry) / 2;
        }
        if(carry == 1) {
            s = "1" + s;
        }
        return s;
    }
    int numSteps(string s) {
        int stepCount = 0;
        while(!(s.size() == 1 && s[0] == '1')) {
            int sLen = s.size();
            if(s[sLen - 1] == '1') {
                s = addOne(s);
            } else {
                s.pop_back();
            }
            stepCount++;
            
        }
        return stepCount;
    }
};

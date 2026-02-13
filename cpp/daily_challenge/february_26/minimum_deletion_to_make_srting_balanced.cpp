#include <iostream>
#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
    int minimumDeletions(string s) {
        int aCount = 0;
        int bCount = 0;
        for(char c : s) {
            if(c == 'a') aCount++;
        }
        int result = s.size();
        for(char c : s) {
            if(c == 'a') aCount--;
            int needToDelete = aCount + bCount;
            result = min(result, needToDelete);
            if(c == 'b') bCount++;
        }
        return result;
    }
};


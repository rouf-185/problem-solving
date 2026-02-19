#include<iostream>
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int countBinarySubstrings(string s) {
        vector<int> groups;
        int count = 1;
        char c = s[0];
        for(int i = 1; i < s.size(); i++) {
            if(c == s[i]) {
                count++;
                continue;
            }
            // cout << count << endl;
            groups.push_back(count);
            c = s[i];
            count = 1;
        }
        groups.push_back(count);
        int ans = 0;
        for(int i = 1; i < groups.size(); i++) {
            ans += min(groups[i - 1], groups[i]);
        }
        return ans;
    }
};

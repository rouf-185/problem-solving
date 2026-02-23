#include<iostream>
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool hasAllCodes(string s, int k) {
        unordered_set<int> all;
        for(int i = 0; i < pow(2, k); i++) {
            all.insert(i);
        }
        for(int i = 0; i < (static_cast<int>(s.size()) - k + 1); i++) {
            string sub = s.substr(i, k);
            int number = 0;
            int mul = 1;
            for(int j = sub.size() - 1; j >= 0; j--) {
                number += sub[j] == '1' ? mul : 0;
                mul *= 2;
            }
            all.erase(number);
        }
        return all.empty();
    }
};

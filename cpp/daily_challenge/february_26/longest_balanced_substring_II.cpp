#include <iostream>
#include <bits/stdc++.h>
class Solution {
public:
    int step1(string s) {
        vector<int> count(3, 0);
        int maxLen = 0;
        for(int i = 0; i < s.size(); i++) {
            int idx = s[i] - 'a';
            if(i == 0) {
                count[idx]++;
            } else {
                count[idx] = (s[i - 1] - 'a') == idx ? count[idx] + 1 : 1;
            }
            maxLen = max(count[idx], maxLen);
        }
        return maxLen;
    }
    long long generateKey(int a, int b) {
        return ((long long)(a)) << 32 | (unsigned int)(b);
    }
    void calculate(unordered_map<long long, int>& map, int i, long long key, int& result) {
        if(map.contains(key)) {
            result = max(result, i - map[key]);
        } else {
            map[key] = i;
        }
    }
    int longestBalanced(string s) {
        int result = step1(s);
        vector<unordered_map<long long, int>> maps(4);
        for(auto& item : maps) {
            item[0] = -1;
        }
        vector<int> count(3, 0);
        for(int i = 0; i < s.size(); i++) {
            int idx = s[i] - 'a';
            count[idx]++;
            long long key = generateKey(count[0] - count[1], count[0] - count[2]);
            calculate(maps[0], i, key, result);
            key = generateKey(count[0] - count[1], count[2]);
            calculate(maps[1], i, key, result);
            key = generateKey(count[0] - count[2], count[1]);
            calculate(maps[2], i, key, result);
            key = generateKey(count[1] - count[2], count[0]);
            calculate(maps[3], i, key, result);
        }
        return result;
    }
};

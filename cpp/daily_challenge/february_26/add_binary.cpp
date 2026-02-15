#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string addBinary(string a, string b) {
        int n = a.size() - 1;
        int m = b.size() - 1;
        int carry_in = 0;
        string ans = "";
        while(m >= 0 || n >= 0) {
            int total = 0;
            if(m >= 0 && n >= 0) {
               total = (a[n--] - '0') + (b[m--] - '0') + carry_in;
            } else if(m >= 0) {
                total =  (b[m--] - '0') + carry_in;
            } else {
                total = (a[n--] - '0') + carry_in;
            }
            ans.push_back(static_cast<char>((total % 2) + '0'));
            carry_in = total/2;
        }
        if(carry_in == 1) {
            ans.push_back('1');
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};

#include <iostream>
#include <bits/stdc++.h>
class Solution {
public:
    long long getKey(int a, int b) {
        return (static_cast<long long> (a)) << 32 | (static_cast<unsigned int> (b));
    }
    int step1(string s) {
        int a = 0;
        int b = 0;
        int c = 0;
        int n = s.size();
        int ans = 1;
        for(int i = 0; i < n; i++) {
            if(s[i] == 'a') {
                if(i > 0) {
                    a = s[i - 1] == 'a' ? a + 1 : 1;
                } else {
                    a = 1;
                }
                ans = max(a, ans);
            } else if(s[i] == 'b') {
                if(i > 0) {
                    b = s[i - 1] == 'b' ? b + 1 : 1;
                } else {
                    b = 1;
                }
                ans = max(b, ans);
            } else if(s[i] == 'c') {
                if(i > 0) {
                    c = s[i - 1] == 'c' ? c + 1 : 1;
                } else {
                    c = 1;
                }
                ans = max(c, ans);
            }
        }
        return ans;
    }
    int longestBalanced(string s) {
        int ans = step1(s);
        unordered_map<long long, int> abc;
        unordered_map<long long, int> ab;
        unordered_map<long long, int> bc;
        unordered_map<long long, int> ac;
        abc[getKey(0, 0)] = -1; // (A-B, A-C)
        ab[getKey(0, 0)]  = -1; // (A-B, C)
        bc[getKey(0, 0)]  = -1; // (B-C, A)
        ac[getKey(0, 0)]  = -1; // (A-C, B)

        vector<int> count(3, 0);
        int n = s.size();
        for(int i = 0; i < n; i++) {
            int idx = static_cast<int>(s[i] - 'a');
            count[idx]++;
            long long abcKey = getKey(count[0] - count[1], count[0] - count[2]); // acount - bcount, acount - ccount
            if(abc.contains(abcKey)) {
                ans = max(ans, i - abc[abcKey]);
            } else {
                abc[abcKey] = i;
            }
            
            long long abKey = getKey(count[0] - count[1], count[2]); // acount - bcount, acount - ccount
            if(ab.contains(abKey)) {
                ans = max(ans, i - ab[abKey]);
            } else {
                ab[abKey] = i;
            }
            
            long long bcKey = getKey(count[1] - count[2], count[0]); // acount - bcount, acount - ccount
            if(bc.contains(bcKey)) {
                ans = max(ans, i - bc[bcKey]);
            } else {
                bc[bcKey] = i;
            }
    
            long long acKey = getKey(count[0] - count[2], count[1]); // acount - bcount, acount - ccount
            if(ac.contains(acKey)) {
                ans = max(ans, i - ac[acKey]);
            } else {
                ac[acKey] = i;
            }
            
        }
        return ans;
    }
};

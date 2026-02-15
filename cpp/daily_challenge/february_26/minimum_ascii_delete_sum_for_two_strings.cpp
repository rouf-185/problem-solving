#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int performDP(string s1, string s2) {
        vector<vector<int>> dp(s1.size() + 1, vector<int>(s2.size() + 1, 0));
        for(int i = 1; i <= s1.size(); i++) {
            for(int j = 1; j <= s2.size(); j++) {
                if(s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + static_cast<int>(s1[i - 1]);
                } else {
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s1.size()][s2.size()];
    }
    int minimumDeleteSum(string s1, string s2) {
        int total = 0;
        for(char c : s1) total += static_cast<int>(c); 
        for(char c : s2) total += static_cast<int>(c); 
        int matchingSum = performDP(s1, s2);
        return total - (2 * matchingSum);
    }
};

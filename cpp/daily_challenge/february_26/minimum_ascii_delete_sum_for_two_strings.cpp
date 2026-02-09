#include<bits\c++.h>
using namespace std;

class Solution {
public:
    int findMatchingIndices(string s1, string s2) {
        int m = s1.size();
        int n = s2.size();
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = static_cast<int>(s1[i - 1]) + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    int minimumDeleteSum(string s1, string s2) {
        int match = findMatchingIndices(s1, s2);
        int s1_total = 0;
        for(char c : s1) {
            s1_total += static_cast<int>(c);
        }
        int s2_total = 0;
        for(char c : s2) {
            s2_total += static_cast<int>(c);
        }
        
        return (s1_total + s2_total - 2 * match) ;
    }
};

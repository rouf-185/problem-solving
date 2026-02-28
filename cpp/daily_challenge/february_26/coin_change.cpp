#include<iostream>
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<vector<int>> dp(coins.size() + 1, vector<int>(amount + 1, 0));
        for(int i = 1; i < dp[0].size(); i++) {
            dp[0][i] = 999999;
        }
        for(int i = 1; i < dp.size(); i++) {
            for(int j = 1; j < dp[0].size(); j++) {
                int currentCoin = coins[i - 1];
                if(j < currentCoin) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - currentCoin]);
                }
            }
        }
        return dp[coins.size()][amount] >= 999999 ? -1 : dp[coins.size()][amount];
    }
};

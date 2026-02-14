#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    double champagneTower(int poured, int query_row, int query_glass) {
        vector<vector<pair<double, double>>> arr(100);
        if(poured <= 0) {
            return 0;
        }
        arr[0].push_back({1.0, (poured - 1) * 1.0});
        for(int i = 1; i < 100; i++) {
            int currentRow = i + 1;
            for(int j = 0; j < currentRow; j++) {
                double total = 0;
                if(j == 0 || j == currentRow - 1) {
                    total = (arr[i - 1][0].second)/2.0;
                } else {
                    total = (arr[i - 1][j - 1].second + arr[i - 1][j].second)/2.0;
                }
                arr[i].push_back({total >= 1.0 ? 1.0 : total, total >= 1 ? total - 1 : 0});
            }
        }
        return arr[query_row][query_glass].first;
    }
};

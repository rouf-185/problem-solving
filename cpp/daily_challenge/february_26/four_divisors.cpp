#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int sumFourDivisors(vector<int>& nums) {
        int sum = 0;
        for(int num : nums) {
            int factorCount = 0;
            int factorSum = 0;
            for(int i = 1; i * i <= num; i++) {
                if(num % i == 0) {
                    factorCount++;
                    factorSum += i;
                    if(i * i != num) {
                        factorCount++;
                        factorSum += (num /i);
                    }
                }
            }
            if(factorCount == 4) {
                sum += factorSum;
            }
        }
        return sum;
    }
};

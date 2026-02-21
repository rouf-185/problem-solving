#include<iostream>
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isPrime(int n) {
        if(n < 2) {
            return false;
        }
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
    int countPrimeSetBits(int left, int right) {
        int count = 0;
        for(int i = left; i <= right; i++) {
            int bitCount = 0;
            int c = i;
            while(c > 0) {
                bitCount += (c % 2);
                c /= 2;
            }
            if(isPrime(bitCount)) {
                count++;
            }
        }
        return count;
    }
};

#include <iostream>
#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
    int reverseBits(int n) {
        int m = 0;
        int i = 0; 
        while(i < 31) {
            m += (n % 2);
            n /= 2;
            m *= 2;
            i++;
        }   
        return m;
    }
};

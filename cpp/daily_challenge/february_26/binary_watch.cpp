#include <iosteam>
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<string> readBinaryWatch(int turnedOn) {
        vector<string> list;
        for(int i = 0; i < 1024; i++) {
            int x = i;
            int bitCount = 0;
            vector<int> position;
            for(int k = 0; k < 10; k++) {
                if((x%2) == 1) position.push_back(1);
                else position.push_back(0);
                bitCount += (x%2);
                x /= 2;
            }
            if(bitCount == turnedOn) {
                int hours = 0;
                int minutes = 0;
                for(int j = 0; j < 4; j++) {
                    if(position[j] == 1) {
                        hours += pow(2, j);
                    }
                }
                for(int j = 4; j < 10; j++) {
                    if(position[j] == 1) {
                        minutes += pow(2, j - 4);
                    }
                }
                int totalMinutes = hours * 60 + minutes;
                if(totalMinutes >= 12 * 60) continue;
                if(minutes >= 60) continue;
                list.push_back(to_string(hours) + ":" + (minutes < 10 ? "0" : "") + to_string(minutes));
            }
        }
        return list;
    }
};

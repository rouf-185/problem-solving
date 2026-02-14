#include <iostream>
#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
    int calculateDistance(vector<vector<pair<int, int>>> adj, int from, int to) {
        vector<int> dist(adj.size(), INT_MAX);
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({0, from});
        dist[from] = 0;
        while(!pq.empty()) {
            pair<int, int> topItem = pq.top();
            pq.pop();
            if(topItem.second == to) {
                return dist[to];
            }
            for(auto& nei : adj[topItem.second]) {
                if(dist[nei.second] > topItem.first + nei.first) {
                    dist[nei.second] = topItem.first + nei.first;
                    pq.push({dist[nei.second], nei.second});
                }
            }
        }
        return -1;
    }
    int minCost(int n, vector<vector<int>>& edges) {
        vector<vector<pair<int, int>>> adj(n);
        for(auto& edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            adj[from].push_back({weight, to});
            adj[to].push_back({2 * weight, from});
        }
        return calculateDistance(adj, 0, n - 1);
    }
};

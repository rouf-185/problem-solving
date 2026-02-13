#include <iostream>
#include <bits/stdc++.h>

class Solution {
public:
    int calculateDistance(vector<vector<pair<int, int>>> adj, int from, int to) {
        vector<int> dist(adj.size(), INT_MAX);
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({0, from});
        dist[from] = 0;
        while(!pq.empty()) {
            pair<int, int> item = pq.top();
            pq.pop();
            if(item.second == to) {
                return dist[to];
            }
            for(auto& nei : adj[item.second]) {
                if(dist[nei.second] > dist[item.second] + nei.first) {
                    dist[nei.second] = dist[item.second] + nei.first;
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
            int w = edge[2];
            adj[from].push_back({w, to});
            adj[to].push_back({2 * w, from});
        }
        return calculateDistance(adj, 0, n-1);
    }
};

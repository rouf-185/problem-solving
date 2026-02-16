#include <iostream>
#include <bits/stdc++.h> 
using namespace std;

class Solution {
public:
    vector<int> performTopSort(vector<vector<int>> adj) {
        int V = adj.size();
        vector<int> indegree(V, 0);
        for(auto& vList : adj) {
            for(auto& neighbor : vList) {
                indegree[neighbor]++;
            }
        }
        queue<int> q;
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                // can be start vertex
                q.push(i);
            }
        }
        vector<int> result;
        while(!q.empty()) {
            int u = q.front();
            result.push_back(u);
            q.pop();
            for(auto& nei : adj[u]) {
                indegree[nei]--;
                if(indegree[nei] == 0) {
                    q.push(nei);
                }
            }
        }
        if(result.size() != V) {
            return {};
        }
        // reverse(result.begin(), result.end());
        return result;

    }
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> adj(numCourses);
        for(auto& preq : prerequisites) {
            adj[preq[1]].push_back(preq[0]);
        }
        return performTopSort(adj);
    }
};

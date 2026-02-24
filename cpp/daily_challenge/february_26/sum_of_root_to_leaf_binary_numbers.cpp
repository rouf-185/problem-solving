#include<iostream>
#include<bits/stdc++.h>
using namespace std;


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    int helper(TreeNode* node, string bin) {
        if(node == nullptr) {
            return 0;
        }
        bin += static_cast<char>('0' + node->val);
        if(node->left == nullptr && node->right == nullptr) {
            int val = 0;
            int mul = 1;
            // cout << bin << endl;
            for(int i = bin.size() - 1; i >= 0; i--) {
                val += bin[i] == '1' ? mul : 0;
                mul *= 2;
            }
            return val;
        }
        int leftval = helper(node->left, bin);
        int rightval = helper(node->right, bin);
        return leftval + rightval;
    }
    int sumRootToLeaf(TreeNode* root) {
        int sum = 0;
        string bin = "";
        sum = helper(root, bin);
        return sum;
    }
};

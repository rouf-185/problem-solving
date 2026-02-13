#include <iostream>
#include <bits/stdc++.h>
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
    pair<bool, int> calculate(TreeNode* node) {
        if(node == nullptr) {
            return {true, 0};
        }
        pair<bool, int> leftInfo = calculate(node->left);
        pair<bool, int> rightInfo = calculate(node->right);
        int newDepth = max(leftInfo.second, rightInfo.second) + 1;
        if(abs(leftInfo.second - rightInfo.second) > 1 || (leftInfo.first & rightInfo.first) == false) {
            return {false, newDepth};
        } else {
            return {true, newDepth};
        }
    }
    bool isBalanced(TreeNode* root) {
        return calculate(root).first;
    }
};

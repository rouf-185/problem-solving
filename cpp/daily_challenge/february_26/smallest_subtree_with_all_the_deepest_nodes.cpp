#include <iostream>
#include <bits\c++.h>
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
    pair<int, TreeNode*> helper(TreeNode* node, int depth) {
        if(node == nullptr) {
            return {depth, nullptr};
        }
        pair<int, TreeNode*> leftTree = helper(node->left, depth + 1);
        pair<int, TreeNode*> rightTree = helper(node->right, depth + 1);
        if(leftTree.second == nullptr && rightTree.second == nullptr) {
            return {leftTree.first, node};
        } else if(leftTree.first == rightTree.first) {
            return {leftTree.first, node};
        } else {
            if(leftTree.first > rightTree.first) {
                return leftTree;
            } else {
                return rightTree;
            }
        }

    }
    TreeNode* subtreeWithAllDeepest(TreeNode* root) {
        return helper(root, 0).second;
    }
};

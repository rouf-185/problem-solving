#include <iostream>
#include <bits/stdc++.h>
using namespace std;
class Solution {
private:
public:
    void inorder(TreeNode* node, vector<int>& elements) {
        if(node == nullptr) {
            return;
        }
        inorder(node->left, elements);
        elements.push_back(node->val);
        inorder(node->right, elements);
    }
    TreeNode* construct(vector<int>& elements, int left, int right) {
        if(left > right) {
            return nullptr;
        }
        int mid = left + (right - left)/2;
        TreeNode* leftTree = construct(elements, left, mid - 1);
        TreeNode* rightTree = construct(elements, mid + 1, right);
        TreeNode* node = new TreeNode(elements[mid], leftTree, rightTree);
        return node;
    }
    TreeNode* balanceBST(TreeNode* root) {
        vector<int> elements;
        inorder(root, elements);
        return construct(elements, 0, elements.size() - 1);
    }
};

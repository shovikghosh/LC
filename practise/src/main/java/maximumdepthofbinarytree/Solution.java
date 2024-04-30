package maximumdepthofbinarytree;

import utilclasses.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    public int maxDepth(TreeNode root, int depth) {
        if(root == null)
            return depth;
        else
            return Math.max(
                maxDepth(root.left, depth + 1),
                maxDepth(root.right, depth + 1)
            );
    }
}



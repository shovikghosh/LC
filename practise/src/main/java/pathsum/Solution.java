package pathsum;

import utilclasses.TreeNode;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root, 0, targetSum);
    }

    public boolean pathSum(TreeNode root, int currentSum, int targetSum) {
        if (root == null)
            return false;
        currentSum += root.val;
        if (root.left != null && root.right != null)
            return pathSum(root.left, currentSum, targetSum) || pathSum(root.right, currentSum, targetSum);
        else if (root.left != null) {
            return pathSum(root.left, currentSum, targetSum);
        } else if (root.right != null) {
            return pathSum(root.right, currentSum, targetSum);
        } else { // leaf node both left and right are null
            return currentSum == targetSum;
        }
    }
}

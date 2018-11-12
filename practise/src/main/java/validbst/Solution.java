package validbst;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    // public boolean isValidBST(TreeNode root) {
    //     if(root!=null)
    //     {
    //         isValidBST(root.left, Integer.MIN_VALUE,root.val) && isValidRight(root.right, root.val , Integer.MAX_VALUE);
    //     }
    //     return true;
       
    // }

    // private boolean isValidLeft(TreeNode node, int min , int max)
    // {
    //     if(node == null)
    //         return true;
    //     else if(  node.val > min && node.val < max)
    //          return isValidLeft(node.left, Integer.MIN_VALUE,node.val) && isValidRight(node.right, node.val , max);

    //     return false;

    // }


    // private boolean isValidRight(TreeNode node, int min, int max) {
    //     if (node == null)
    //         return true;
    //     else if (node.val > min && node.val < max)
    //         return isValidLeft(node.left, min, node.val) && isValidRight(node.right, node.val, Integer.MAX_VALUE);

    //     return false;

    // }
}